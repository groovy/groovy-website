package model

import groovy.transform.CompileStatic

@CompileStatic
class Video {
    String title
    String speaker
    String summary
    String pictureUrl
    String videoUrl = ""
    String slidesUrl = ""
    String codeUrl = ""

    void speaker(String speaker) {
        this.speaker = speaker
    }

    void summary(String summary) {
        this.summary = summary
    }

    void pictureUrl(String pictureUrl) {
        this.pictureUrl = pictureUrl
    }

    void videoUrl(String videoUrl) {
        this.videoUrl = videoUrl
    }

    void slidesUrl(String slidesUrl) {
        this.slidesUrl = slidesUrl
    }

    void codeUrl(String codeUrl) {
        this.codeUrl = codeUrl
    }
}
