package model

import groovy.transform.CompileStatic
import groovy.transform.EqualsAndHashCode
import groovy.transform.ToString

@CompileStatic
@ToString
@EqualsAndHashCode
class Issue {
    String id
    String type
    String description
}
