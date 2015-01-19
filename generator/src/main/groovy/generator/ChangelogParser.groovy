package generator

import groovy.json.JsonSlurper
import model.Changelog
import model.Issue

import java.util.regex.Pattern

class ChangelogParser {
    private static final String JIRA_SERVER = 'http://jira.codehaus.org'
    private static final String PROJECT_NAME = 'GROOVY'
    private static final String PROJECT_ID = '10242'

    private static final String LOGNOTES_INTRO = /Release Notes - groovy/
    private static final String LOGNOTES_END = /<\/textarea>/
    private static final String BUGTYPE_MARK = '** '
    private static final String ITEM_MARK = '    * '
    private static final Pattern ITEM_PATTERN = ~/\[(GROOVY-[0-9]+)\] - (.+)/
    private static final String VERSION_PATTERN = /^((1\.)|[23]\.)/

    static List<Changelog> fetchReleaseNotes(File cacheDirectory) {
        def slurper = new JsonSlurper()
        def versions = slurper.parse("$JIRA_SERVER/rest/api/2/project/$PROJECT_NAME/versions".toURL())
        def versionMap = versions.findAll {
            it.name =~ VERSION_PATTERN &&
                    it.released == true
        }.collectEntries {
            [it.name, it.id]
        }

        def raw = versionMap.collect { name, id ->
            println "Fetching changelog for version $name"
            new Changelog(groovyVersion: name, issues: changelogHTML(id, cacheDirectory))
        }
        createAggregates(raw)
    }

    private static List<Changelog> createAggregates(final List<Changelog> changelogs) {
        def allMajor = changelogs.groupBy {
            def v = it.groovyVersion
            v.contains('-')?v-v.substring(v.indexOf('-')):v
        }
        allMajor.collect { k,v ->
            def changelog = changelogs.find { it.groovyVersion == v }
            if (!changelog) {
                changelog = new Changelog(groovyVersion: k, issues:[])
                changelogs << changelog
            }
            v.each {
                changelog.issues = [*changelog.issues, *it.issues].unique().sort { it.id }
            }
        }
        changelogs
    }

    private static List<Issue> changelogHTML(String id, File cacheDir) {
        def cache = new File(cacheDir, "changelog-${id}.html")
        def log
        if (cache.exists()) {
            log = cache.getText('UTF-8')
        } else {
            log = new URL("$JIRA_SERVER/secure/ReleaseNote.jspa?version=$id&styleName=Text&projectId=$PROJECT_ID").getText('UTF-8')
            cache.write(log, 'UTF-8')
        }
        boolean inNotes = false
        String type = null
        List<Issue> issues = []

        log.eachLine { line ->
            if (line.startsWith(LOGNOTES_INTRO)) {
                inNotes = true
            } else if (line.startsWith(LOGNOTES_END)) {
                inNotes = false
            } else if (inNotes) {
                if (line.startsWith(BUGTYPE_MARK)) {
                    type = line - BUGTYPE_MARK
                } else if (line.startsWith(ITEM_MARK)) {
                    def m = ITEM_PATTERN.matcher(line)
                    m.find()
                    issues << new Issue(id: m.group(1), description: m.group(2), type: type)
                }
            }
        }

        issues
    }
}
