layout 'layouts/main.groovy', true,
        pageTitle: 'The Apache Groovy programming language - Mailing-lists',
        mainContent: contents {
            div(id: 'content', class: 'page-1') {
                div(class: 'row') {
                    div(class: 'row-fluid') {
                        div(class: 'col-lg-3') {
                            include template: 'includes/community-navbar.groovy'
                        }

                        div(class: 'col-lg-8 col-lg-pull-0') {
                            include template: 'includes/contribute-button.groovy'
                            h1 {
                                i(class: 'fa fa-envelope-o') {}
                                yield ' Mailing-lists'
                            }
                            p '''The Groovy mailing-lists is the main means of interaction with the Groovy developers and Groovy users.'''
                            hr(class: 'divider')

                            article {
                                h1 'Available lists'
                                table(class: 'table') {
                                    tr {
                                        td {
                                            strong 'users@groovy.apache.org'
                                        }
                                        td 'high volume list for questions and general discussion about Groovy'
                                        td { a(href: 'mailto:users-subscribe@groovy.apache.org', 'Subscribe') }
                                        td { a(href: 'http://mail-archives.apache.org/mod_mbox/groovy-users/', 'Archive') }
                                        td { a(href: 'mailto:users-unsubscribe@groovy.apache.org', 'Unsubscribe') }
                                    }
                                    tr {
                                        td {
                                            strong 'dev@groovy.apache.org'
                                        }
                                        td 'medium volume list useful for those interested in ongoing developments'
                                        td { a(href: 'mailto:dev-subscribe@groovy.apache.org', 'Subscribe') }
                                        td { a(href: 'http://mail-archives.apache.org/mod_mbox/groovy-dev/', 'Archive') }
                                        td { a(href: 'mailto:dev-unsubscribe@groovy.apache.org', 'Unsubscribe') }
                                    }
                                    tr {
                                        td {
                                            strong 'commits@groovy.apache.org'
                                        }
                                        td 'medium volume list that logs commits'
                                        td { a(href: 'mailto:commits-subscribe@groovy.apache.org', 'Subscribe') }
                                        td { a(href: 'http://mail-archives.apache.org/mod_mbox/groovy-commits/', 'Archive') }
                                        td { a(href: 'mailto:commits-unsubscribe@groovy.apache.org', 'Unsubscribe') }
                                    }
                                    tr {
                                        td {
                                            strong 'notifications@groovy.apache.org'
                                        }
                                        td 'high volume list for JIRA and Github notifications'
                                        td { a(href: 'mailto:notifications-subscribe@groovy.apache.org', 'Subscribe') }
                                        td { a(href: 'http://mail-archives.apache.org/mod_mbox/groovy-notifications/', 'Archive') }
                                        td { a(href: 'mailto:notifications-unsubscribe@groovy.apache.org', 'Unsubscribe') }
                                    }
                                }
                                hr(class: 'divider')

                                h2 'Mailing-lists archive on Nabble'
                                p """
                                    The mailing-lists are archived on ${$a(href: 'http://www.nabble.com/', 'Nabble')}.
                                    Below you can see the archives of the lists.
                                    Even if you can post messages to the mailing-lists through Nabble,
                                    you first need to be registered to the Apache Groovy mailing-lists!
                                """
                                a(id: 'nabblelink', href: 'http://groovy.329449.n5.nabble.com/', 'Nabble forum')
                                script(src: 'http://groovy.329449.n5.nabble.com/embed/f329449') {}
                            }
                        }
                    }
                }
            }
        }
