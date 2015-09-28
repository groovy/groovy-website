package generator

import groovy.transform.CompileStatic

/**
 * This class is responsible for downloading a documentation page as generated through the Asciidoctor task
 * of the Groovy build, then filter its contents in order to return only the body of the documentation, as HTML.
 *
 * @author Cédric Champeau
 */
@CompileStatic
class DocumentationHTMLCleaner {
    private final static String BODY_START = /<body/
    private final static String BODY_END = /<\/body/
    private final static String TOC_START = /<div id="toc"/
    private final static String MAIN_START = /<div id="content"/
    private final static String MAIN_END = /<div id="footer"/

    /**
     * A list of links which are badly generated, but we know how to fix them
     */
    private final static Map<String,String> KNOWN_REPLACEMENTS = [
        /docs\.groovy-lang\.org\/(latest|next)\/html\/documentation\/gdk\.html/: 'groovy-lang.org/gdk.html',
        /\/maven\/groovy-/: '/maven/apache-groovy-'
    ]

    private static String cleanupPage(String location) {
        def url = location.toURL()
        try {
            def fullHTML = url.getText('utf-8')
            return extractBetween(fullHTML, BODY_START, BODY_END)
        } catch (FileNotFoundException e) {
            // 404 not found
        }

        null
    }

    private static String extractBetween(String html, String startString, String endString) {
        def start = html.indexOf(startString)
        if (start > 0) {
            start = html.indexOf('>', start) + 1
        }
        if (start > 1) {
            def end = html.indexOf(endString, start)
            if (end > start) {
                return html.substring(start, end)
            }
        }
        null
    }

    public static DocPage parsePage(String location) {
        String contents = cleanupPage(location)
        if (contents==null) {
            return new DocPage(content: "Contents not found for <a href='$location'>$location</a>, most likely because this section has not yet been written.")
        }
        String toc = extractTOC(contents)?:''
        String main = extractBetween(contents, MAIN_START, MAIN_END)?:"Main body not found for <a href='$location'>$location</a>"
        main = replaceInternalLinks(main)
        new DocPage(toc: toc, content: main)
    }

    private static String replaceInternalLinks(String html) {
        def replacer = { List<String> it ->
            def (String tag, String attr, String url) = [it[1], it[2], it[3]]
            url = url.replaceAll(/x(.+)\.(?:pagespeed.+)/, '$1')
            if (!url.startsWith('http') && !url.startsWith('#') && 'target.html'!=url) {
                "$tag $attr'${DocUtils.DOCS_BASEURL}/html/documentation/$url'"
            } else {
                it[0]
            }
        }
        html = html.replaceAll(/(a)\s+(href=)["'](.+?)["']/,replacer)
        html = html.replaceAll(/(img)\s+(src=)["'](.+?)["']/,replacer)
        KNOWN_REPLACEMENTS.each { link, repl ->
            html = html.replaceAll(link, repl)
        }
        html
    }

    private static String extractTOC(final String html) {
        int start = html.indexOf(TOC_START)
        if (start > 0) {
            int end = html.indexOf(MAIN_START)
            if (end>0) {
                def out = html.substring(start, end).replace("<div id=\"toctitle\">Table of Contents</div>", "")
                end = out.size()-1
                while (!out.substring(end, out.size()).startsWith('</div>')) end--
                return out.substring(0, end)
            }
        }
        null
    }

    static class DocPage {
        String toc = ''
        String content
    }

}
