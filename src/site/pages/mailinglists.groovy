layout 'layouts/main.groovy',
        menu: menu,
        category: category,
        pageTitle: 'The Groovy programming language - Mailing-lists',
//        extraFooter: contents { link(rel: 'stylesheet', type: 'text/css', href: 'css/nabble.css') },
//        extraStyles: ['nabble.css'],
        mainContent: contents {
            div(id: 'content', class: 'page-1') {
                div(class: 'row') {
                    div(class: 'row-fluid') {
                        div(class: 'col-lg-3') {
                            ul(class: 'nav-sidebar') {
                                li {
                                    a(href: 'community.html', 'Community')
                                }
                                li {
                                    a(href: 'contribute.html', 'Contribute')
                                }
                                li(class: 'active') {
                                    a(href: 'mailing-lists.html') { strong('Mailing-lists') }
                                }
                                li {
                                    a(href: 'events.html', 'Events')
                                }
                            }
                        }

                        div(class: 'col-lg-8 col-lg-pull-0') {
                            h1 'Mailing-lists'
                            article {
/*
                                a(id: 'nabblelink', href: 'http://groovy.329449.n5.nabble.com/embed/329449', 'Nabble forum')
                                script(src: 'http://groovy.329449.n5.nabble.com/embed/329450')
*/
                            }
                            hr(class: 'divider')
                        }
                    }
                }
            }
        }