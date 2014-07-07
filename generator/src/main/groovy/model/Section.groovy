package model

import groovy.transform.ToString

@ToString(includeNames=true)
import groovy.transform.CompileStatic

@CompileStatic
class Section {
    String name
    String icon
    List<SectionItem> items = []

    void item(String name, String targetFile, String sourceFile) {
        items.add(new SectionItem(name: name, sourceFilename: sourceFile, targetFilename: targetFile))
    }

    String getAnchor() {
        name.replaceAll('[^a-zA-Z0-9]','').toLowerCase()
    }
}
