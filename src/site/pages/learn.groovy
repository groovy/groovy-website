layout 'layouts/main.groovy',
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
                                [['gettingstarted', 'Getting started'],
                                 ['moduleguides', 'Groovy module guides'],
                                 ['apidoc', 'API documentation'],
                                 ['tools', 'Tools'],
                                 ['specification', 'Language specification']].each { anchor, text ->
                                    li { a(href: "$anchor", text) }
                                }
                            }
                        }


                        div(class: 'col-lg-8 col-lg-pull-0') {
                            h1('Documentation')
                            p {
                                yield 'The documentation is available as a '
                                a(href: "single-page-documentation.html", 'single-page document')
                                yield ', or feel free to pick at a direct sections below.'
                            }
                            hr(class: 'divider')

                            div(class: 'row-fluid') {
                                article {
                                    div(class: 'col-md-6') {
                                        a(name: 'gettingstarted')
                                        h2 {
                                            i(class: 'fa fa-graduation-cap', 'Getting started')
                                            ul {
                                                ['download.html'        : 'Download Groovy',
                                                 'install.html'         : 'Install Groovy',
                                                 'core-differences.html': 'Differences with Java',
                                                 'core-gdk.html'        : 'The Groovy Development Kit'].each { url, text ->
                                                    li { a(href: url, text) }
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