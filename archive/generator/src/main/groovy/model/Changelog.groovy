package model

import groovy.transform.CompileStatic
import groovy.transform.ToString

@CompileStatic
@ToString
class Changelog {
    String groovyVersion
    List<Issue> issues
}
