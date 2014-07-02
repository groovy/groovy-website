layout 'layouts/main.groovy',
        menu: menu,
        category: category,
        pageTitle: 'The Groovy programming language - Mailing-lists',
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
                            p '''The Groovy mailing-lists is the main means of interaction with the Groovy developers and Groovy users.'''
                            article {
                                h1 'Subscribing to the lists'
                                p {
                                    yield '''
                                        Here are the public mailing lists that have been set up for the project.
                                        In order to subscribe / unsubscribe you first need to get a special link from '''
                                    a(href: 'http://xircles.codehaus.org/manage_email', 'http://xircles.codehaus.org/manage_email')
                                }
                                p {
                                    yield 'Once you have got this link you can manage your subscriptions by going to the Groovy project page: '
                                    a(href: 'http://xircles.codehaus.org/projects/groovy', 'http://xircles.codehaus.org/projects/groovy')
                                }
                                h2 'Available lists'
                                table(class: 'table') {
                                    tr {
                                        td {
                                            strong 'user@groovy.codehaus.org'
                                        }
                                        td 'high volume list for questions and general discussion about Groovy'
                                    }
                                    tr {
                                        td {
                                            strong 'dev@groovy.codehaus.org'
                                        }
                                        td 'medium volume list useful for those interested in ongoing developments'
                                    }
                                    tr {
                                        td {
                                            strong 'announce@groovy.codehaus.org'
                                        }
                                        td 'is a low volume list for announcements about new releases or major news'
                                    }
                                    tr {
                                        td {
                                            strong 'eclipse-plugin-user@groovy.codehaus.org'
                                        }
                                        td 'low volume list for questions and problems using the Groovy Eclipse plugin'
                                    }
                                    tr {
                                        td {
                                            strong 'scm@groovy.codehaus.org'
                                        }
                                        td 'medium volume list that logs commits'
                                    }
                                }

                                h2 'Mailing-lists archive on Nabble'
                                p '''
                                    The mailing-lists are archived on Nabble.
                                    Below you can see the archives of the lists.
                                    In order to post messages to the mailing-lists through Nabble,
                                    you first need to be registered to the Groovy mailing-lists,
                                    as explained at the top of this page.
                                '''
                                a(id: 'nabblelink', href: 'http://groovy.329449.n5.nabble.com/', 'Nabble forum')
                                script(src: 'http://groovy.329449.n5.nabble.com/embed/f329449')
                            }
                            hr(class: 'divider')
                        }
                    }
                }
            }
        }