class Ecosystem extends LinkedHashMap<String,EcosystemEntry> {
    void entry(String name, Closure entrySpec) {
        def entry = new EcosystemEntry(name:name)
        def clone = entrySpec.rehydrate(entry,entry,entry)
        clone()
        put(name, entry)
    }
}
