package model

import groovy.transform.CompileStatic

@CompileStatic
class Events extends LinkedHashMap<String, Event> {
    void event(String name, Closure eventClosure) {
        def entry = new Event(name: name)
        def clone = eventClosure.rehydrate(entry, entry, entry)
        clone()
        put(name, entry)
    }
}
