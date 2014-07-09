package generator

import groovy.text.markup.MarkupTemplateEngine
import groovy.text.markup.TemplateConfiguration
import groovy.transform.CompileStatic
import model.Page
import model.Section
import model.SectionItem
import model.SiteMap

import java.nio.file.FileSystems
import java.nio.file.Path
import java.nio.file.WatchEvent

import static java.nio.file.StandardWatchEventKinds.*

@CompileStatic
class SiteGenerator {

    File sourcesDir
    File outputDir

    private MarkupTemplateEngine tplEngine
    private SiteMap siteMap

    void setup() {

        println "Generating website using Groovy ${GroovySystem.version}"

        def tplConf = new TemplateConfiguration()
        tplConf.autoIndent = true
        tplConf.autoNewLine = true

        def classLoader = new URLClassLoader([sourcesDir.toURI().toURL()] as URL[], this.class.classLoader)
        tplEngine = new MarkupTemplateEngine(classLoader, tplConf, new MarkupTemplateEngine.CachingTemplateResolver())

        siteMap = SiteMap.from(new File(sourcesDir, "sitemap.groovy"))

    }

    void render(String page, String target = null, Map model = [:]) {
        model.menu = siteMap.menu
        model.currentPage = target
        target = target ?: page
        new File("$outputDir/${target}.html").write(tplEngine.createTemplateByPath("pages/${page}.groovy").make(model).toString(), 'utf-8')
    }

    void generateSite() {
        long sd = System.currentTimeMillis()
        setup()

        siteMap.documentationSections.each { Section section ->
            section.items.each { SectionItem item ->
                if (item.generate) {
                    println "Generating documentation page [$item.name]"
                    render 'docpage', item.targetFilename, [category: 'Learn', title: item.name, iframeTarget: "http://docs.groovy-lang.org/docs/next/html/documentation/${item.sourceFilename}.html"]
                }
            }
        }

        siteMap.pages.each { Page page ->
            println "Rendering individual page [$page.source]"
            render page.source, page.target, page.model
        }


        long dur = System.currentTimeMillis() - sd
        println "Generated site into $outputDir in ${dur}ms"
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
}
