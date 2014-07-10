layout 'layouts/main.groovy', true,
        pageTitle: 'The Groovy programming language - User groups',
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
                                i(class: 'fa fa-users') {}
                                yield ' User groups'
                            }
                            article {
                                p '''
                                    We're living in a virtual world, but it's great from time to time to be able to meet in real life,
                                    chat with other Groovy users, discover new aspects of the language or platform,
                                    attend presentations about special features or ecosystem projects, and more.
                                    Groovy user groups are there for you to exchange with others about your favorite language.
                                '''
                                ul {
                                    li { a(href: '#europe', 'Europe')}
                                    li { a(href: '#northamerica', 'North-America')}
                                    li { a(href: '#southamerica', 'South-America')}
                                    li { a(href: '#australia', 'Australia')}
                                    li { a(href: '#asia', 'Asia')}
                                }
                                hr(class: 'divider')

                                a(name: 'europe') {}
                                h2 'Europe'
                                h3 'France'
                                ul {
                                    li { a(href: 'http://www.meetup.com/Paris-Groovy-Grails/', 'Paris Groovy Grails User Group') }
                                }
                                hr(class: 'divider')

                                a(name: 'northamerica') {}
                                h2 'North-America'
                                ul {
                                    li { a(href: 'http://groovy.mn', 'Groovy Users of Minnesota') }
                                }
                                hr(class: 'divider')

                                a(name: 'southamerica') {}
                                h2 'South-America'
                                ul {

                                }
                                hr(class: 'divider')

                                a(name: 'australia') {}
                                h2 'Australia'
                                ul {

                                }
                                hr(class: 'divider')

                                a(name: 'asia') {}
                                h2 'Asia'
                                ul {

                                }
                                hr(class: 'divider')
                            }
                        }
                    }
                }
            }
        }
