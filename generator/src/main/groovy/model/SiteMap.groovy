package model

import groovy.transform.ToString
import org.codehaus.groovy.control.CompilerConfiguration

import groovy.transform.CompileStatic

@CompileStatic
@ToString(includeNames=true)
class SiteMap {
    final List<Section> documentationSections = []
    final List<Distribution> distributions = []
    final Menu menu = new Menu()
    final Ecosystem ecosystem = new Ecosystem()
    final Events allEvents = new Events()
    final Library library = new Library()
    final List<String> allDocVersions = []
    final List<Page> pages = []

    private SiteMap() {}

    public static SiteMap from(File source) {
        CompilerConfiguration config = new CompilerConfiguration()
        config.scriptBaseClass = 'groovy.util.DelegatingScript'
        GroovyShell shell = new GroovyShell(config)
        def script = shell.parse(source)

        def result = new SiteMap()
        ((DelegatingScript)script).setDelegate(result)
        script.run()

        result
    }

    private void documentation(Closure docSpec) {
        def clone = docSpec.rehydrate(this, this, this)
        clone()
    }

    private void section(String name, String icon, Closure sectionSpec) {
        Section section = new Section(name:name, icon:icon)
        def spec = sectionSpec.rehydrate(section,section,section)
        spec()
        documentationSections.add(section)
    }

    private void groovyDocumentationVersions(List<String> allDocVersions) {
        this.allDocVersions.addAll(allDocVersions)
    }

    private void downloads(Closure dlSpec) {
        def clone = dlSpec.rehydrate(this,this,this)
        clone()
    }

    private void pages(Closure pagesSpec) {
        def clone = pagesSpec.rehydrate(this,this,this)
        clone()
    }

    private void distribution(String name, Closure distSpec) {
        Distribution dist = new Distribution(name: name)
        def clone = distSpec.rehydrate(dist, dist, dist)
        clone()
        distributions.add(dist)
    }

    private void menu(Closure menuSpec) {
        def clone = menuSpec.rehydrate(menu, menu, menu)
        clone()
    }

    private void ecosystem(Closure ecoSpec) {
        def clone = ecoSpec.rehydrate(ecosystem, ecosystem, ecosystem)
        clone()
    }

    private void allEvents(Closure eventsSpec) {
        def clone = eventsSpec.rehydrate(allEvents, allEvents, allEvents)
        clone()
    }

    private void books(Closure booksSpec) {
        def clone = booksSpec.rehydrate(library, library, library)
        clone()
    }

    private void page(String source, String target, Map model = [:]) {
        pages.add(new Page(source:source, target: target, model: model))
    }

}
