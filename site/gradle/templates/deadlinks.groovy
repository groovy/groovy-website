html {
    head {
        title 'Dead links report'
    }
    body {
        h1('Dead links report')
        if (!deadLinks) {
            p("No dead link found. All green!")
        } else {
            p "Found a total of ${deadLinks.values().sum{ it.size() }} dead links in the following files:"
            deadLinks.each { entry ->
                def (page, links) = [entry.key, entry.value]
                h3 { a(href:page,page) }
                ul {
                    links.each { link ->
                        li("At line ${link.line}, dead link to ${link.link}")
                    }
                }
            }
            p "Note: not all dead links can be fixed directly in the Groovy website project - some are generated from the Groovy documentation and must be fixed there."
        }
    }
}
