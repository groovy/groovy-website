layout 'layouts/main.groovy',
        menu: menu,
        category: category,
        pageTitle: 'The Groovy programming language - Ecosystem',
        mainContent: contents {
            div(id: 'content', class: 'page-1') {
                section(class: 'row') {
                    div(class: 'row-fluid') {
                        div(class: 'col-lg-3') {
                            ul(class: 'nav-sidebar') {
                                li(class: 'active') { a(href: 'ecosystem.html') { strong('Ecosystem') } }
                                ecosys.keySet().each { name ->
                                    li { a(href: "#$name", name) }
                                }
                            }
                        }
                        div(class: 'col-lg-8 col-lg-pull-0') {
                            h1('Ecosystem')
                            p {
                                yield '''
                                        Beside the language and its API, Groovy gave birth to a fruitful ecosystem of projects around it,
                                        on various themes such as web frameworks, desktop application framework, concurrency, testing, and more.
                                        In this section, we'll highlight a few of the most well-known and successful projects,
                                        which leverage Groovy at their core.
                            '''
                            }
                            hr(class: 'divider')

                            ecosys.eachWithIndex { e, index ->
                                def (name, item) = [e.key, e.value]
                                article {
                                    a(name: "${name}") {}
                                    div(class:"content-heading clearfix media") {
                                        div {
                                            if (item.logo) {
                                                img class: "pull-${(index % 2 == 0) ? 'left' : 'right'}", src: item.logo, alt: name, hspace: '20px'
                                            } else {
                                                h2(name)
                                            }
                                            p(item.description)
                                        }
                                        a(href: item.url, target:'_blank', "Learn more...")
                                    }
                                }
                                hr(class: 'divider')
                            }
                        }
                    }
                }
            }
        }
