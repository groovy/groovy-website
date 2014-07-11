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
                                h3 'Belgium'
                                ul {
                                    li { a(href: 'http://www.meetup.com/Belgium-Groovy-Grails-User-Group/', 'Belgium Groovy/Grails User Group') }
                                }
                                h3 'Denmark'
                                ul {
                                    li('Aarhus Groovy & Grails meetup - no homepage yet')
                                }
                                h3 'France'
                                ul {
                                    li { a(href: 'http://www.meetup.com/Paris-Groovy-Grails/', 'Paris Groovy Grails User Group') }
                                }
                                h3 'Israel'
                                ul {
                                    li { a(href: 'http://www.meetup.com/Groovy-Grails-Israel-Meetup-Group/', 'Groovy & Grails Israel User Group') }
                                }
                                h3 'Poland'
                                ul {
                                    li { a(href: 'http://www.meetup.com/Warsaw-Groovy-User-Group/', 'Warsaw Groovy User Group') }
                                }
                                h3 'Spain'
                                ul {
                                    li { a(href: 'http://www.meetup.com/madrid-gug/', 'Madrid Groovy User Group') }
                                }

                                hr(class: 'divider')

                                a(name: 'northamerica') {}
                                h2 'North-America'
                                ul {
                                    li { a(href: 'http://groovy.mn', 'Groovy Users of Minnesota') }
                                    li { a(href: 'http://www.meetup.com/Austin-Groovy-and-Grails-Users/', 'Austin Groovy and Grails User Group (TX)') }
                                    li { a(href: 'http://www.meetup.com/Grails-and-Ales/', 'Groovy and Grails Users of Columbus OH') }
                                    li { a(href: 'http://www.meetup.com/grails/', 'NYC Groovy / Grails Meetup') }
                                    li { a(href: 'http://www.scottsdale-groovy.com/', 'Scottsdale Groovy Brigade') }
                                }
                                hr(class: 'divider')

                                a(name: 'southamerica') {}
                                h2 'South-America'
                                ul {
                                   li { a(href: 'http://www.grailsbrasil.com.br', 'Grails Brasil - Groovy and Grails users group of Brazil')  }
                                }
                                hr(class: 'divider')

                                a(name: 'australia') {}
                                h2 'Australia'
                                ul {

                                }
                                hr(class: 'divider')

                                a(name: 'asia') {}
                                h2 'Asia'
                                h3 'India'
                                ul {
                                    li { a(href: 'http://www.meetup.com/Bangalore-Groovy-Grails-Meetup/', 'Bangalore Groovy Grails Meetup') }
                                }
                                h3 'Japan'
                                ul {
                                    li { a(href: 'http://www.jggug.org/', 'Japan Grails/Groovy User Group') }
                                }
                                hr(class: 'divider')
                            }
                        }
                    }
                }
            }
        }
