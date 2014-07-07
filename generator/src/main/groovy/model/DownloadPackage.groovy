package model

class DownloadPackage {
    String version
    String releaseNotes
    String windowsInstaller

    void releaseNotes(String notes) {
        releaseNotes = notes
    }

    void windowsInstaller(String installer) {
        windowsInstaller = installer
    }
}
