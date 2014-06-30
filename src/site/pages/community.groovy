layout 'layouts/main.groovy',
        menu: menu,
        category: category,
        pageTitle: 'The Groovy programming language - Download',
        mainContent: contents {
            div(id: 'content', class: 'page-1') {
                div(class: 'row') {
                    div(class: 'row-fluid') {
                        div(class: 'col-lg-3') {
                            ul(class: 'nav-sidebar') {
                                li(class: 'active') {
                                    a(href: 'community.html') { strong('Community') }
                                }
                                li {
                                    a(href: 'contribute.html', 'Contribute')
                                }
                                li {
                                    a(href: 'mailing-lists.html', 'Mailing-lists')
                                }
                                li {
                                    a(href: 'events.html', 'Events')
                                }
                            }
                        }

                        div(class: 'col-lg-8 col-lg-pull-0') {
                            h1 'Community'
                            article {

                            }
                            hr(class: 'divider')
                        }
                    }
                }
            }
        }