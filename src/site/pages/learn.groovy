layout 'layouts/main.groovy',
        menu: menu,
        category: category,
        pageTitle: 'The Groovy programming language - Learning',
        contents: contents {
            div(id: 'content', class: 'page-1') {
                div(class: 'row') {
                    div(class: 'row-fluid') {
                        div(class: 'col-lg-3') {
                            ul(class: 'nav-sidebar') {
                                li(class: 'active') {
                                    a(href: '#') { strong('Documentation') }
                                }
                                docSections.each { section ->
                                    li { a(href: "#${section.anchor}", section.name) }
                                }
                            }
                        }

                        div(class: 'col-lg-8 col-lg-pull-0') {
                            h1('Documentation')
                            p {
                                yield 'The documentation is available as a '
                                a(href: "single-page-documentation.html", 'single-page document')
                                yield ', or feel free to pick at a direct section below.'
                            }
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
                        }
                    }
                }
            }
        }