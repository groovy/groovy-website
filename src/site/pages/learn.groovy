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
                                li {
                                    a(href: 'documentation.html', 'Documentation')
                                }
                                docSections.each { section ->
                                    li { a(href: "documentation.html#${section.anchor}", section.name) }
                                }
                                li {
                                    a(href: 'faq.html', 'FAQ')
                                }
                            }
                        }

                        div(class: 'col-lg-8 col-lg-pull-0') {
                            h1('Learn')
                            article {
                                p '''
                                    This learning section of the Groovy project website gives you key pointers
                                    to the following documentation resources:'''
                                ul {
                                    li { a(href: 'documentation.html#gettingstarted', 'reference documentation') }
                                    ul {
                                        li { a(href: 'documentation.html#gettingstarted', 'getting started guides') }
                                        li { a(href: 'documentation.html#languagespecification', 'language specification') }
                                        li { a(href: 'documentation.html#tools', 'tools documentation') }
                                        li { a(href: 'documentation.html#groovymoduleguides', 'Groovy module user guides') }
                                        li { a(href: 'documentation.html#groovymoduleguides', 'Groovy module user guides') }
                                    }
                                    li { a(href: 'gdk.html', 'Groovy GDK documentation') }
                                    li { a(href: 'api.html', 'GroovyDoc of the Groovy APIs') }
                                    li { a(href: 'faq.html', 'Frequently Asked Questions') }
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