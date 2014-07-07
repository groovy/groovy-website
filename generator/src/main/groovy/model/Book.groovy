package model

import groovy.transform.CompileStatic

@CompileStatic
class Book {
    String title
    String authors
    String cover
    String url
    String description

    void authors    (String authors)     { this.authors     = authors }
    void cover      (String cover)       { this.cover       = cover }
    void url        (String url)         { this.url         = url }
    void description(String description) { this.description = description }
}
