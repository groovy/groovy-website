package model

import groovy.transform.ToString

import groovy.transform.CompileStatic

@CompileStatic
@ToString(includeNames=true)
class MenuItem {
    String name
    String link
    String style
}
