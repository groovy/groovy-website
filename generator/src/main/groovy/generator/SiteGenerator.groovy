package generator

import groovy.text.markup.MarkupTemplateEngine
import groovy.text.markup.TemplateConfiguration
import groovy.transform.CompileStatic
import model.Section
import model.SectionItem
import model.SiteMap

@CompileStatic
class SiteGenerator {

    File sourcesDir
    File sitemapFile
    File outputDir

    private MarkupTemplateEngine tplEngine
    private SiteMap siteMap

    void setup() {
        def tplConf = new TemplateConfiguration()
        tplConf.autoIndent = true
        tplConf.autoNewLine = true

        tplEngine = new MarkupTemplateEngine(this.class.classLoader, sourcesDir, tplConf)

        siteMap = SiteMap.from(sitemapFile)

    }

    void render(String page, String target=null, Map model=[:]) {
        model.menu = siteMap.menu
        model.currentPage=target
        target = target ?: page
        new File("$outputDir/${target}.html").write(tplEngine.createTemplateByPath("pages/${page}.groovy").make(model).toString(), 'utf-8')
    }
    void generateSite() {
        setup()

        println "Generating website using Groovy ${GroovySystem.version}"

        render 'index', 'index', [allEvents: siteMap.allEvents]
        render 'search', 'search'
        render 'ecosystem', 'ecosystem', [category: 'Ecosystem', ecosys: siteMap.ecosystem]
        render 'learn', 'learn', [category: 'Learn', docSections: siteMap.documentationSections, allBooks: siteMap.library]
        render 'documentation', 'documentation', [category: 'Documentation', docSections: siteMap.documentationSections]

        siteMap.documentationSections.each { Section section ->
            section.items.each { SectionItem item ->
                println "Generating documentation page [$item.name]"
                render 'docpage', item.targetFilename, [category: 'Learn', title: item.name, iframeTarget: "http://docs.groovy-lang.org/docs/next/html/documentation/${item.sourceFilename}.html"]
            }
        }

        render 'download', 'download', [category: 'Download', distributions: siteMap.distributions]
        render 'versioning', 'versioning', [category: 'Download']
        render 'indy', 'indy', [category: 'Download']
        render 'community', 'community', [category: 'Community']
        render 'groovy-weekly', 'groovy-weekly', [category: 'Community']
        render 'mailing-lists', 'mailing-lists', [category: 'Community']
        render 'contribute', 'contribute', [category: 'Community']
        render 'hipchat', 'hipchat', [category: 'Community']
        render 'faq', 'faq', [category: 'Documentation', docSections: siteMap.documentationSections]
        render 'events', 'events', [category: 'Community', allEvents: siteMap.allEvents]
        render 'api', 'api', [category: 'Learn', iframeTarget: 'http://docs.groovy-lang.org/docs/next/html/gapi']
        render 'gdk', 'gdk', [category: 'Learn', iframeTarget: 'http://docs.groovy-lang.org/docs/next/html/groovy-jdk']
        render 'singlepagedocumentation', 'single-page-documentation', [category: 'Learn', iframeTarget: 'http://docs.groovy-lang.org/docs/next/html/documentation/']
    }

    static void main(String... args) {
        def sourcesDir = args[0] as File
        def siteMap    = args[1] as File
        def outputDir  = args[2] as File
        def generator = new SiteGenerator(sourcesDir: sourcesDir, sitemapFile: siteMap, outputDir: outputDir)
        generator.generateSite()
    }
}
