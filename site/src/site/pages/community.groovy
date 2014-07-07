layout 'layouts/main.groovy', true,
        pageTitle: 'The Groovy programming language - Community',
        mainContent: contents {
            div(id: 'content', class: 'page-1') {
                div(class: 'row') {
                    div(class: 'row-fluid') {
                        div(class: 'col-lg-3') {
                            include template: 'includes/community-navbar.groovy'
                        }

                        div(class: 'col-lg-8 col-lg-pull-0') {
                            h1 'Community'
                            article {
                                p {
                                    yield '''
                                        Groovy would not be the successful Open Source project it is today,
                                        without the help of its users, forming the base of a wider Groovy community
                                        and '''
                                    a(href: 'ecosystem.html', 'ecosystem')
                                    yield ' of projects using Groovy.'
                                }
                                p 'In this section of the website, you can find useful links and information about: '
                                ul {
                                    li {
                                        yield 'how you can '
                                        a(href: 'contribute.html', 'contribute')
                                        yield ' to the project, its codebase, its documentation'
                                    }
                                    li {
                                        yield 'how to raise issues in our '
                                        a(href: 'contribute.html#reporting-issues', 'bug tracker')
                                    }
                                    li {
                                        yield 'how to interact with other Groovy users and developers through the '
                                        a(href: 'mailing-lists.html', 'mailing-lists')
                                    }
                                    li {
                                        yield 'and the upcoming '
                                        a(href: 'events.html', 'events and conferences')
                                        yield ' you might want to attend to lear more about Groovy and to share your experience with others.'
                                    }
                                }
                            }
                            hr(class: 'divider')
                        }
                    }
                }
            }
        }