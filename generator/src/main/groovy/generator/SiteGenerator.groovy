package generator

import groovy.text.markup.MarkupTemplateEngine
import groovy.text.markup.TemplateConfiguration
import groovy.transform.CompileStatic
import model.Changelog
import model.Page
import model.Section
import model.SectionItem
import model.SiteMap

import java.nio.file.FileSystems
import java.nio.file.Path
import java.nio.file.WatchEvent

import static generator.DocumentationHTMLCleaner.cleanupPage
import static generator.DocumentationHTMLCleaner.parsePage
import static java.nio.file.StandardWatchEventKinds.*

@CompileStatic
class SiteGenerator {

    private final static Closure SEMANTIC_SORT = { String v1, String v2 ->
        List<String> items1 = decomposeVersion(v1)
        List<String> items2 = decomposeVersion(v2)
        for (int i=0; i<Math.max(items1.size(),items2.size());i++) {
            if (i>=items2.size()) {
                return 1
            }
            if (i>=items1.size()) {
                return -1
            }
            def p1 = items1[i]
            def p2 = items2[i]
            if (p1.isNumber()) {
                if (p2.isNumber()) {
                    def pi1 = p1.toInteger()
                    def pi2 = p2.toInteger()

                    if (pi1 < pi2) {
                        return 1
                    } else if (pi1 > pi2) {
                        return -1
                    }
                } else {
                    return -1
                }
            } else if (p2.isNumber()) {
                return 1
            } else {
                return p2 <=> p1
            }
        }
        0
    }

    File sourcesDir
    File outputDir

    private MarkupTemplateEngine tplEngine
    private SiteMap siteMap

    void setup() {

        println "Generating website using Groovy ${GroovySystem.version}"

        def tplConf = new TemplateConfiguration()
        tplConf.autoIndent = true
        tplConf.autoNewLine = true
        tplConf.baseTemplateClass = PageTemplate

        def classLoader = new URLClassLoader([sourcesDir.toURI().toURL()] as URL[], this.class.classLoader)
        tplEngine = new MarkupTemplateEngine(classLoader, tplConf, new MarkupTemplateEngine.CachingTemplateResolver())

        siteMap = SiteMap.from(new File(sourcesDir, "sitemap.groovy"))

    }

    void render(String page, String target = null, Map model = [:], String baseDir=null) {
        model.menu = siteMap.menu
        model.currentPage = target
        target = target ?: page
        File root
        if (baseDir) {
            root = new File(outputDir, baseDir)
            model[PageTemplate.BASEDIR] = baseDir
            root.mkdirs()
        } else {
            root = outputDir
        }

        new File(root,"${target}.html").write(tplEngine.createTemplateByPath("pages/${page}.groovy").make(model).toString(), 'utf-8')
    }

    void generateSite() {
        long sd = System.currentTimeMillis()
        setup()

        def cacheDir = new File(new File('build'), 'cache')
        cacheDir.mkdirs()
        println "Cache directory: $cacheDir"
        def changelogs = ChangelogParser.fetchReleaseNotes(cacheDir);

        renderDocumentation()

        renderPages(changelogs)

        renderChangelogs(changelogs)

        renderReleaseNotes()

        renderWiki()


        long dur = System.currentTimeMillis() - sd
        println "Generated site into $outputDir in ${dur}ms"
    }

    private List<Section> renderDocumentation() {
        siteMap.documentationSections.each { Section section ->
            section.items.each { SectionItem item ->
                if (item.generate) {
                    println "Generating documentation page [$item.name]"
                    render 'docpage', item.targetFilename, [
                            category: 'Learn',
                            title   : item.name,
                            page    : parsePage("${DocUtils.DOCS_BASEURL}/html/documentation/${item.sourceFilename}.html")]
                }
            }
        }
    }

    private List<Page> renderPages(List<Changelog> changelogs) {
        siteMap.pages.each { Page page ->
            println "Rendering individual page [$page.source]"
            if ('changelogs' == page.source) {
                page.model.versions = changelogs.groovyVersion.sort(SEMANTIC_SORT)
            }
            render page.source, page.target, page.model
        }
    }

    private List<Changelog> renderChangelogs(List<Changelog> changelogs) {
        changelogs.each {
            println "Rendering changelog for Groovy $it.groovyVersion"
            render 'changelog', "changelog-$it.groovyVersion", [groovyVersion: it.groovyVersion, issues: it.issues], 'changelogs'
        }
    }

    private void renderReleaseNotes() {
        def releaseNotesVersions = new TreeSet<String>(new Comparator<String>() {
            @Override
            int compare(final String v1, final String v2) {
                v2.toDouble() <=> v1.toDouble()
            }
        })
        new File(sourcesDir, 'releasenotes').eachFile { File file ->
            def name = file.name.substring(0, file.name.lastIndexOf('.adoc'))
            def version = name - 'groovy-'
            releaseNotesVersions << version
            println "Rendering release notes for Groovy $version"
            render 'release-notes', name, [notes: file.getText('utf-8'), groovyVersion: version], 'releasenotes'
        }
        render 'releases', 'releases', [versions: releaseNotesVersions]
    }

    private void renderWiki() {
        def asciidoctor = AsciidoctorFactory.instance
        println "Rendering wiki"

        def wikiDir = new File(sourcesDir, "wiki")
        wikiDir.eachFileRecurse { f->
            if (f.name.endsWith('.adoc')) {
                def header = asciidoctor.readDocumentHeader(f)
                def bn = f.name.substring(0,f.name.lastIndexOf('.adoc'))
                println "Rendering $header.documentTitle.main by ${header.author?.fullName}"
                def relativePath = []
                def p = f.parentFile
                while (p!=wikiDir) {
                    relativePath << p.name
                    p = p.parentFile
                }
                String baseDir = relativePath?"wiki${File.separator}${relativePath.join(File.separator)}":'wiki'
                render 'wiki', bn, [notes:f.getText('utf-8'), header: header], baseDir
                println baseDir
            }
        }
    }

    static void main(String... args) {
        def sourcesDir = args[0] as File
        def outputDir = args[1] as File
        def generator = new SiteGenerator(sourcesDir: sourcesDir, outputDir: outputDir)
        boolean watchMode = args.length > 2 ? Boolean.valueOf(args[2]) : false
        generator.generateSite()

        if (watchMode) {
            println "Started watch mode"
            def watcher = FileSystems.default.newWatchService()

            sourcesDir.toPath().register(watcher,
                    ENTRY_CREATE,
                    ENTRY_DELETE,
                    ENTRY_MODIFY)

            sourcesDir.eachDirRecurse { File f ->
                f.toPath().register(watcher,
                        ENTRY_CREATE,
                        ENTRY_DELETE,
                        ENTRY_MODIFY)
            }

            def existingDirectories = ['pages', 'layouts', 'includes', 'html', 'assets', 'css', 'fonts', 'img', 'js', 'vendor']

            while (true) {
                def key = watcher.take()
                def pollEvents = (List<WatchEvent<Path>>) key.pollEvents()

                def changed = pollEvents.collect { "${it.context()}".toString() }.join(', ')

                // only generate when the event refers to the actual file modified / created / added
                // as otherwise the watcher service generates two events:
                // 1) one for directory containing the modified file, and
                // 2) one for the actual file being modified
                // this checks avoid getting two events for one change
                if (existingDirectories.every { !changed.contains(it) }) {
                    try {
                        println "Regenerating site due to changes in: ${changed}"
                        // todo: selective regeneration
                        generator.generateSite()
                    } finally {
                        key.reset()
                    }
                }
            }
        }
    }

    static List<String> decomposeVersion(String version) {
        String qualifier = ''
        if (version.indexOf('-')>0) {
            qualifier = version.substring(version.indexOf('-'))
            version = version - qualifier
        }
        List<String> parts = version.split(/\./).toList()
        if (qualifier) {
            parts << qualifier
        }
        parts
    }
}
