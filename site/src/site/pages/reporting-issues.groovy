layout 'layouts/main.groovy', true,
        pageTitle: 'The Apache Groovy programming language - Reporting Issues',
        mainContent: contents {
            div(id: 'content', class: 'page-1') {
                div(class: 'row') {
                    div(class: 'row-fluid') {
                        div(class: 'col-lg-3') {
                            include template: 'includes/support-navbar.groovy'
                        }

                        div(class: 'col-lg-8 col-lg-pull-0') {
                            include template: 'includes/contribute-button.groovy'
                            h1 {
                                i(class: 'fa fa-envelope-o') {}
                                yield ' Reporting Issues'
                            }
                            h2 'Reporting issues'
                            p {
                                yield 'The Groovy project is using the '
                                a(href: 'https://issues.apache.org/jira/browse/GROOVY/', 'JIRA bug tracker')
                                yield ' to report and track issues, feature enhancements, and new features.'
                            }
                            p {
                                yield "You'll frequently wish to discuss your issue first on one of the "
                                a(href: 'mailing-lists.html', 'mailing-lists')
                                yield '''
                                        or in one of the forums to make sure what you believe is a bug isn't really
                                        a feature or to gather support and ideas for your feature enhancement request.
                                '''
                            }
                            p 'Be sure to be signed-up and logged-in, before proceeding.'
                            p {
                                button(type: 'button', class: 'btn btn-default', 'Report an issue',
                                        onclick: 'window.location.href="https://issues.apache.org/jira/browse/GROOVY"')
                            }

                        }
                    }
                }
            }
        }
