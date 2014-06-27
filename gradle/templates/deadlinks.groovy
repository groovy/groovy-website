html {
    head {
        title 'Dead links report'
        link rel:'stylesheet', type:'text/css', href:'../site/css/style.css'
    }
    body {
        h1('Dead links report')
        if (!deadLinks) {
            p("No dead link found. All green!")
        } else {
            p("The following files contain dead links:")
        }
        deadLinks.each { entry ->
            def (page, links) = [entry.key, entry.value]
            h3(page)
            ul {
                links.each {
                    li(it)
                }
            }
        }
    }
}
