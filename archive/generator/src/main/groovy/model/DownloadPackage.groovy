package model

import groovy.transform.CompileStatic

@CompileStatic
class DownloadPackage {
    String version
    String releaseNotes
    String windowsInstaller
    boolean stable = false
    boolean archive = false

    void releaseNotes(String notes) {
        releaseNotes = notes
    }

    void windowsInstaller(String installer) {
        windowsInstaller = installer
    }

    void stable(boolean b) {
        stable = b
    }

    void archive(boolean b) {
        archive = b
    }
}
