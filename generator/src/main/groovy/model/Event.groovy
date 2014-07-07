package model

import groovy.transform.CompileStatic

@CompileStatic
class Event {
    String name
    String location
    String date
    String description
    String url
    String logo

    void location   (String location)    { this.location    = location }
    void date       (String date)        { this.date        = date }
    void description(String description) { this.description = description }
    void url        (String url)         { this.url         = url }
    void logo       (String logo)        { this.logo        = logo }
}
