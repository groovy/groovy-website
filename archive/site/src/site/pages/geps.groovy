layout 'layouts/main.groovy', true,
        pageTitle: "The Apache Groovy programming language - GEPs",
        mainContent: contents {
            def sorted = list.sort{ (it.key - 'GEP-').toInteger() }
            div(id: 'content', class: 'page-1') {
                div(class: 'row') {
                    div(class: 'row-fluid') {
                        div(class: 'col-lg-3') {
                            ul(class: 'nav-sidebar') {
                                li(class:'active') {
                                    a(href: '#gep', "GEPs")
                                }
                                sorted.each { gep ->
                                    li { a(href: "#$gep.key", class: 'anchor-link', "$gep.key") }
                                }
                            }
                        }

                        div(class: 'col-lg-8 col-lg-pull-0') {
                            h1('GEPs for Groovy')
                            p 'Here you can find the GEPs for the Groovy programming language.'
                            ul {
                                sorted.each { gep ->
                                    li {
                                        a(href: "${gep.key}.html", "$gep.key: $gep.value")
                                    }
                                }
                            }
                        }
                    }
                }
            }
        }
