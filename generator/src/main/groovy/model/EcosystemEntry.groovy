package model

import groovy.transform.ToString

import groovy.transform.CompileStatic

@CompileStatic
@ToString(includeNames=true)
class EcosystemEntry {
    String name
    String url
    String description
    String logo

    void url(String url) { this.url = url }
    void description(String description) { this.description = description }
    void logo(String logo) { this.logo = logo }
}
