layout 'layouts/main.groovy', true,
        pageTitle: 'The Groovy programming language - Documentation',
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
                                    a(href: "#old-docs", class: 'anchor-link', 'Documentation for older versions')
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
                            p "You can also browse ${$a(href: '#old-docs', 'documentation for older versions')}."
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
                            hr(class: 'divider')

                            a(name: 'old-docs') {}
                            h2 'Documentation for older versions'
                            p 'You can browse the documentation of previous versions of Groovy since Groovy 1.7:'
                            def allVersions =  [
                                    '1.7.0', '1.7.1', '1.7.2', '1.7.3', '1.7.4', '1.7.5', '1.7.6', '1.7.7', '1.7.8', '1.7.9', '1.7.10', '1.7.11',
                                    '1.8.0', '1.8.1', '1.8.2', '1.8.3', '1.8.4', '1.8.5', '1.8.6', '1.8.7', '1.8.8', '1.8.9',
                                    '2.0.0', '2.0.1', '2.0.2', '2.0.3', '2.0.4', '2.0.5', '2.0.6', '2.0.7', '2.0.8',
                                    '2.1.0', '2.1.1', '2.1.2', '2.1.3', '2.1.4', '2.1.5', '2.1.6', '2.1.7', '2.1.8', '2.1.9',
                                    '2.2.0', '2.2.1', '2.2.2',
                                    '2.3.0', '2.3.1', '2.3.2', 'Select a version'
                            ].reverse()

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