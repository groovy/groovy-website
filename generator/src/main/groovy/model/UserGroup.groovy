package model

import groovy.transform.CompileStatic
import groovy.transform.ToString

@CompileStatic
@ToString(includeNames=true)
class UserGroup {
    String location
    String name
    String url

    void location(String location) {
        this.location = location
    }

    void name(String name) {
        this.name = name
    }

    void url(String url) {
        this.url = url
    }

    String[] getLocationParts() {
        location.split('/')
    }
}
