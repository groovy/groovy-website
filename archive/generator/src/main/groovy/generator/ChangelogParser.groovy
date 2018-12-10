package generator

import groovy.json.JsonSlurper
import model.Changelog
import model.Issue

import java.util.regex.Pattern

class ChangelogParser {
    private static final String JIRA_SERVER = 'https://issues.apache.org/jira'
    private static final String PROJECT_NAME = 'GROOVY'
    private static final String PROJECT_ID = '12318123'

    private static final String LOGNOTES_INTRO = /Release Notes - Groovy/
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
            [fixName(it.name), it.id]
        }

        def raw = versionMap.collect { name, id ->
            println "Fetching changelog for version $name"
            new Changelog(groovyVersion: name, issues: changelogHTML(id, cacheDirectory))
        }
        createAggregates(raw, versionMap.keySet())
    }

    private static String fixName(String name) {
        String id = name
        String classifier = ''

        int idx = name.indexOf('-')
        if (idx>0) {
            classifier = name.substring(idx)
            id = name - classifier
        }
        if (id.count('.')<2) {
            // groovy 2.0 instead of 2.0.0
            id = "${id}.0"
        }
        "$id$classifier"
    }

    private static List<Changelog> createAggregates(final List<Changelog> changelogs, final Set<String> releasedVersions) {
        def allMajor = changelogs.groupBy {
            def v = it.groovyVersion
            v.contains('-')?v-v.substring(v.indexOf('-')):v
        }.findAll { ver, logs -> ver in releasedVersions }
        allMajor.collect { k,v ->
            def changelog = changelogs.find { it.groovyVersion == k }
            if (!changelog) {
                println "Not found: $k"
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
