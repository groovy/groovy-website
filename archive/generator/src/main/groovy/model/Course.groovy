package model

import groovy.transform.CompileStatic

@CompileStatic
class Course {

    String title
    String instructor
    String url
    String description
    String cover

    void title(String title) {
        this.title = title
    }

    void instructor(String instructor) {
        this.instructor = instructor
    }

    void url(String url){
        this.url = url
    }

    void description(String description){
        this.description = description
    }

    void cover(String cover){
        this.cover = cover
    }

}
