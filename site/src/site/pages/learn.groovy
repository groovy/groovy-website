import model.Book

layout 'layouts/main.groovy', true,
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
                                    a(href: '#books', class: 'anchor-link', 'Books')
                                }
                            }
                        }

                        div(class: 'col-lg-8 col-lg-pull-0') {
                            include template: 'includes/contribute-button.groovy'
                            h1 {
                                i(class: 'fa fa-graduation-cap') {}
                                yield ' Learn'
                            }
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
                                    yield ', which explains all the '
                                    a(href: 'documentation.html#languagespecification', 'details of the language')
                                    yield ', such as how to use the '
                                    a(href: 'documentation.html#tools', 'tools')
                                    yield ' that come with a Groovy installation, and how to tackle more complex tasks with the various '
                                    a(href: 'documentation.html#groovymoduleguides', 'module user guides')
                                    yield '.'
                                }
                                hr(class: 'divider')

                                a(name: 'books') {}
                                h2 {
                                    i(class: 'fa fa-book') {}
                                    yield ' Books'
                                }
                                p '''
                                    Another great approach to learning Groovy is to read the various books published
                                    on the language:'''

                                allBooks.each {
                                    String title = it.key
                                    Book book = it.value

                                    figure(class: 'book') {
                                        ul(class: 'hardcover_front') {
                                            li {
                                                img(src: book.cover, width: '100%', height: '100%')
                                            }
                                            li {}
                                        }
                                        ul(class: 'page') {
                                            li {}
                                            li {
                                                a(class: 'book-btn', href: book.url, target: '_blank', 'More info')
                                            }
                                            3.times { li {} }
                                        }
                                        ul(class: 'hardcover_back') {
                                            2.times { li {} }
                                        }
                                        ul(class: 'book_spine') {
                                            2.times { li {} }
                                        }
                                        figcaption {
                                            h1 book.title
                                            span "By ${book.authors}"
                                            p book.description
                                        }
                                    }
                                }
                            }
                        }
                    }
                }
            }
        }
