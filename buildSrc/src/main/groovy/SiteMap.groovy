import groovy.transform.ToString
import org.codehaus.groovy.control.CompilerConfiguration

@ToString(includeNames=true)
class SiteMap {
    final List<Section> documentationSections = []
    final List<Distribution> distributions = []

    private SiteMap() {}

    public static SiteMap from(File source) {
        CompilerConfiguration config = new CompilerConfiguration()
        config.scriptBaseClass = 'groovy.util.DelegatingScript'
        GroovyShell shell = new GroovyShell(config)
        def script = shell.parse(source)

        def result = new SiteMap()
        script.setDelegate(result)
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

    private void downloads(Closure dlSpec) {
        def clone = dlSpec.rehydrate(this,this,this)
        clone()
    }

    private void distribution(String name, Closure distSpec) {
        Distribution dist = new Distribution(name: name)
        def clone = distSpec.rehydrate(dist, dist, dist)
        clone()
        distributions.add(dist)
    }

}
