layout 'layouts/main.groovy',
        menu: menu,
        pageTitle: 'The Groovy programming language - FAQ - Frequently Asked Questions',
        contents: contents {
            div(id: 'content', class: 'page-1') {
                div(class: 'row') {
                    div(class: 'row-fluid') {
                        div(class: 'col-lg-3') {
                            ul(class: 'nav-sidebar') {
                                li(class: 'active') {
                                    a(href: 'faq.html') { strong('Frequently Asked Questions') }
                                }
                            }
                        }

                        div(class: 'col-lg-8 col-lg-pull-0') {
                            h1 'FAQ - Frequently Asked Questions'
                            article {

                            }
                            hr(class: 'divider')
                        }
                    }
                }
            }
        }