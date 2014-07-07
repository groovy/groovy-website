package model

import groovy.transform.CompileStatic

@CompileStatic
class Distribution {
    String name
    Closure description
    List<DownloadPackage> packages = []

    void description(Closure cl) { this.description = cl }

    void version(String name, Closure versionSpec) {
        DownloadPackage pkg = new DownloadPackage(version:name)
        def clone = versionSpec.rehydrate(pkg,pkg,pkg)
        clone()
        packages.add(pkg)
    }
}
