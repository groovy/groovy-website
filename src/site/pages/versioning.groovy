layout 'layouts/main.groovy',
        pageTitle: 'The Groovy programming language - Versioning',
        contents: contents {
            div(id: 'content', class: 'page-1') {
                div(class: 'row') {
                    div(class: 'row-fluid') {
                        div(class: 'col-lg-3') {
                            ul(class: 'nav-sidebar') {
                                li {
                                    a(href: 'download.html', 'Download')
                                }
                                li {
                                    a(href: '#distro', 'Distributions')
                                }
                                li {
                                    a(href: '#gvm', 'Through GVM')
                                }
                                li {
                                    a(href: '#buildtools', 'From your build tools')
                                }
                                li {
                                    a(href: '#otherways', 'Other ways')
                                }
                                li(class: 'active') {
                                    a(href: 'versioning.html') {
                                        strong 'Versioning'
                                    }
                                }
                                li {
                                    a(href: 'indy.html', 'Invoke dynamic support')
                                }
                            }
                        }

                        div(class: 'col-lg-8 col-lg-pull-0') {
                            h1 'The Groovy version scheme'
                            article {

                            }
                            hr(class: 'divider')
                        }
                    }
                }
            }
        }