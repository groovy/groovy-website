html {
    head {
        title 'Dead links report'
    }
    body {
        h1('Dead links report')
        if (!deadLinks) {
            p("No dead link found. All green!")
        } else {
            p "Found a total of ${deadLinks.values().sum { it.size()}} dead links."
            p """Not that not all dead links can be fixed directly in the Groovy website project: some of them
are generated in the Groovy documentation instead."""
            p "The following files contain dead links:"
        }
        deadLinks.each { entry ->
            def (page, links) = [entry.key, entry.value]
            h3 { a(href:page,page) }
            ul {
                links.each { link ->
                    asciidoc("At line ${link.line}, dead link to ${link.link}")
                }
            }
        }
    }
}
