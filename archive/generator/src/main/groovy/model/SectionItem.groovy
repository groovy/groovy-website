package model

import groovy.transform.ToString

import groovy.transform.CompileStatic

@CompileStatic
@ToString(includeNames=true)
class SectionItem {
    String name
    String targetFilename
    String sourceFilename
    boolean generate = true
}
