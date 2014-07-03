layout 'layouts/main.groovy',
        menu: menu,
        category: category,
        pageTitle: 'The Groovy programming language - Learn',
        extraStyles: ['book.css'],
        mainContent: contents {
            div(id: 'content', class: 'page-1') {
                div(class: 'row') {
                    div(class: 'row-fluid') {
                        div(class: 'col-lg-3') {
                            ul(class: 'nav-sidebar') {
                                li(class: 'active') {
                                    a(href: '#') { strong('Learn') }
                                }
                                li {
                                    a(href: '#books', 'Books')
                                }
                            }
                        }

                        div(class: 'col-lg-8 col-lg-pull-0') {
                            h1('Learn')
                            article {
                                p 'Welcome to the learning section of the Groovy website.'
                                p {
                                    yield 'First of all, you will need to '
                                    a(href: 'documentation.html#gettingstarted', 'get started')
                                    yield ' by installing Groovy on your system or project.'
                                }
                                p {
                                    yield 'Once all set up, we invite you to have a look at the Groovy '
                                    a(href: 'documentation.html', 'documentation')
                                    yield ', explaining all the '
                                    a(href: 'documentation.html#languagespecification', 'details of the language')
                                    yield ', how to use the '
                                    a(href: 'documentation.html#tools', 'tools')
                                    yield ' coming with a Groovy installation, and showing how to tackle more complex tasks with the various '
                                    a(href: 'documentation.html#groovymoduleguides', 'module user guides')
                                    yield '.'
                                }
                                hr(class: 'divider')

                                a(name: 'books') {}
                                h2 'Books'
                                p '''
                                    Another great approach to learning Groovy is to read the various books published
                                    on the language:'''

                                include unescaped: 'html/books.html'
                            }
                        }
                    }
                }
            }
        }