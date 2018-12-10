layout 'layouts/main.groovy', true,
        pageTitle: "The Apache Groovy programming language - Release notes",
        mainContent: contents {

            div(id: 'content', class: 'page-1') {
                div(class: 'row') {
                    div(class: 'row-fluid') {
                        div(class: 'col-lg-3') {
                            ul(class: 'nav-sidebar') {
                                li(class: 'active') {
                                    a(href: '#notes', "Release notes")
                                }
                                versions.each { v ->
                                    li { a(href: "#notes$v", class: 'anchor-link', "Groovy $v") }
                                }
                            }
                        }

                        div(class: 'col-lg-8 col-lg-pull-0') {
                            h1('Release notes for Groovy')
                            p '''Here you can find the release notes for the past Groovy releases, describing
thoroughly what are the novelties and bug fixes of each version.'''
                            ul {
                                versions.each { mj ->
                                    li {
                                        a(name: "notes$mj") {}
                                        yieldUnescaped "Release notes for "
                                        a(href: "releasenotes/groovy-${mj}.html", "Groovy $mj")
                                    }
                                }
                            }
                        }
                    }
                }
            }
        }
