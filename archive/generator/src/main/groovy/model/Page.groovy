package model

import groovy.transform.CompileStatic

@CompileStatic
class Page {
    String source
    String target
    Map model = [:]
}
