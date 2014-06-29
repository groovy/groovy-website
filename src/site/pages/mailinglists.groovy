layout 'layouts/main.groovy',
        menu: menu,
        pageTitle: 'The Groovy programming language - Mailing-lists',
        contents: contents {
            div(id: 'content', class: 'page-1') {
                div(class: 'row') {
                    div(class: 'row-fluid') {
                        div(class: 'col-lg-3') {
                            ul(class: 'nav-sidebar') {
                                li(class: 'active') {
                                    a(href: 'mailing-lists.html') { strong('Mailing-lists') }
                                }
                            }
                        }

                        div(class: 'col-lg-8 col-lg-pull-0') {
                            h1 'Mailing-lists'
                            article {

                            }
                            hr(class: 'divider')
                        }
                    }
                }
            }
        }