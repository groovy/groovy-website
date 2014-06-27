layout 'layouts/main.groovy',
        menu: menu,
        pageTitle: 'The Groovy programming language - Versioning',
        contents: contents {
            div(id: 'content', class: 'page-1') {
                div(class: 'row') {
                    div(class: 'row-fluid') {
                        div(class: 'col-lg-3') {
                            ul(class: 'nav-sidebar') {
                                li {
                                    a(href: 'download.html', 'Download Groovy')
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
                                    a(href: '#otherways', 'Other ways to get Groovy')
                                }
                                li {
                                    a(href: 'versioning.html', 'Groovy version scheme')
                                }
                                li(class: 'active') {
                                    a(href: 'indy.html') {
                                        strong 'Invoke dynamic support'
                                    }
                                }
                            }
                        }

                        div(class: 'col-lg-8 col-lg-pull-0') {
                            h1 'Invoke dynamic support'
                            article {

                            }
                            hr(class: 'divider')
                        }
                    }
                }
            }
        }