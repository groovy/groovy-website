layout 'layouts/main.groovy', true,
        pageTitle: "The Apache Groovy programming language - Changelogs",
        mainContent: contents {
            def majorize = { it.split(/\.|-/)[0..1].join('.')}

            def major = versions.collect([] as Set) { majorize(it) }

            div(id: 'content', class: 'page-1') {
                div(class: 'row') {
                    div(class: 'row-fluid') {
                        div(class: 'col-lg-3') {
                            ul(class: 'nav-sidebar') {
                                li(class:'active') {
                                    a(href: '#changelog', "Changelogs")
                                }
                                major.each { v ->
                                    li { a(href: "#changelog$v", class: 'anchor-link', "Groovy $v") }
                                }
                            }
                        }

                        div(class: 'col-lg-8 col-lg-pull-0') {
                            h1('Changelogs for Groovy')
                            p 'Here you can find the changelogs for the past Groovy releases.'
                            versions.groupBy { majorize(it) }.each {
                                String mj = it.key
                                List<String> minor = it.value
                                a(name: "changelog$mj") {}
                                h2("Groovy $mj")
                                ul {
                                    minor.each { v->
                                        li {
                                            yieldUnescaped "Changelog for "
                                            a(href: "changelogs/changelog-${v}.html", "Groovy $v")
                                        }
                                    }
                                }
                            }
                        }
                    }
                }
            }
        }
