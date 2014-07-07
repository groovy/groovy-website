package model

import groovy.transform.CompileStatic

@CompileStatic
class Ecosystem extends LinkedHashMap<String,EcosystemEntry> {
    void project(String name, Closure entrySpec) {
        def entry = new EcosystemEntry(name:name)
        def clone = entrySpec.rehydrate(entry,entry,entry)
        clone()
        put(name, entry)
    }
}
