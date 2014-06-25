import groovy.transform.ToString

@ToString(includeNames=true)
class SectionItem {
    String name
    String targetFilename
    String sourceFilename
}
