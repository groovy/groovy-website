layout 'layouts/main.groovy', true,
        pageTitle: 'The Apache Groovy programming language - Documentation',
        mainContent: contents {
            div(id: 'content', class: 'page-1') {
                div(class: 'row') {
                    div(class: 'row-fluid') {
                        div(class: 'col-lg-3') {
                            ul(class: 'nav-sidebar') {
                                li(class: 'active') {
                                    a(href: '#') { strong('Documentation') }
                                }
                                docSections.each { section ->
                                    li { a(href: "#${section.anchor}", class: 'anchor-link', section.name) }
                                }
                                li {
                                    a(href: "#all-versions", class: 'anchor-link', 'Documentation for other versions')
                                }
                                li {
                                    a(href: 'faq.html', 'FAQ')
                                }
                            }
                        }

                        div(class: 'col-lg-8 col-lg-pull-0') {
                            include template: 'includes/contribute-button.groovy'
                            h1 {
                                i(class: 'fa fa-university') {}
                                yield ' Documentation'
                            }
                            p {
                                yield 'The documentation is available as a '
                                a(href: "single-page-documentation.html", 'single-page document')
                                yield ', or feel free to pick at a direct section below.'
                            }
                            p "You can also browse ${$a(href: '#all-versions', 'documentation for other versions')}."
                            hr(class: 'divider')

                            // group sections by 2, for 2 columns
                            def rows = docSections.collate(2)
                            rows.each { row ->
                                div(class: 'row-fluid') {
                                    article {
                                        row.each { section ->
                                            div(class: 'col-md-6') {
                                                a(name: section.anchor) {}
                                                h2 {
                                                    i(class: "fa ${section.icon}", " $section.name")
                                                }
                                                ul {
                                                    section.getItems().each { item ->
                                                        li { a(href: "${item.targetFilename}.html", item.name) }
                                                    }
                                                }
                                            }
                                        }
                                    }
                                }
                            }
                            div(class: 'col-md-12') {
                                hr(class: 'divider')

                                a(name: 'all-versions') {}
                                article {
                                    h2 'Documentation for all Groovy versions'
                                    p 'You can browse the documentation of a particular version of Groovy (since Groovy 1.7):'
                                    def allVersions =  [*allDocVersions, 'Select a version'].reverse()

                                    select(class: 'form-control', onchange: "window.location.href='http://docs.groovy-lang.org/docs/groovy-' + this.value + '/html/'") {
                                        allVersions.each { String version ->
                                            option version
                                        }
                                    }
                                }
                            }
                        }
                    }
                }
            }
        }
