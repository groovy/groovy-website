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
                                yield "Here is a checklist before creating a new issue:"
                                ul {
                                    li {
                                        yield "Check the "
                                        a(href: 'https://groovy.apache.org/#documenting', 'existing documentation')
                                        yield " to make sure the behavior you are reporting is really a bug, not a feature."
                                    }
                                    li {
                                        yield "Check the "
                                        a(href: 'https://issues.apache.org/jira/browse/GROOVY/', 'existing issues')
                                        yield " to make sure you aren\'t experiencing an existing known bug."
                                        yield " (In this case feel free to add additional information to the existing issue if you have new information.)"
                                    }
                                    li {
                                        yield "You'll frequently wish to discuss your issue first on one of the "
                                        a(href: 'mailing-lists.html', 'mailing-lists')
                                        yield '''
                                        or in one of the forums to make sure what you believe is a bug isn't really
                                        a feature or to gather support and ideas for your feature enhancement request.
                                        '''
                                        yield 'Alternatively, consider using the '
                                        a(href: 'https://groovycommunity.com/', 'Slack')
                                        yield " channel. (This channel is not endorsed by the Apache Software Foundation; it's run by Groovy enthusiasts in the community.)"
                                    }
                                }
                                yield "NOTE: While we don't absolutely exclude you from asking questions within Jira (as distinct from reporting technical issues), you'll probably receive much better support from the mailing lists or forums."
                            }
                            p {
                                yield 'If proceeding with reporting a new issue, here are some tips for making a good bug/issue report:'
                                ul {
                                    li('A meaningful title that captures how you believe Groovy is working incorrectly')
                                    li('Relevant version information: Groovy version(s) showing the problem, Groovy version where the behavior last worked, JDK version, operating system or third-party library versions if relevant')
                                    li('Any relevant stacktraces')
                                    li('Preconditions and steps to reproduce the bug. Preferably with no (or as few as possible) dependencies on third-party projects/libraries')
                                    li('Actual and expected results')
                                    li('Any relevant additional information: are you using indy, static compilation, local meta-programming additions, other libraries that might have metaprogramming in play.')
                                }
                            }
                            p 'Ready to report a new issue? (You\'ll need to sign up and log in, before proceeding.)'
                            p {
                                button(type: 'button', class: 'btn btn-default', 'Report an issue',
                                        onclick: 'window.location.href="https://issues.apache.org/jira/browse/GROOVY"')
                            }

                        }
                    }
                }
            }
        }
