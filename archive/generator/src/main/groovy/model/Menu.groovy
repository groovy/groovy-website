package model

import groovy.transform.CompileStatic

@CompileStatic
class Menu extends LinkedHashMap<String, List<MenuItem>> {

    void group(String name, Closure groupSpec) {
        Group g = new Group()
        def clone = groupSpec.rehydrate(g,g,g)
        clone()
        put(name, g.items)
    }

    private static class Group {
        List<MenuItem> items = []
        void item(String name, String link, String style=null) {
            items << new MenuItem(name:name, link: link, style:style)
        }
    }
}
