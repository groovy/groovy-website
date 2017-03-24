layout 'layouts/main.groovy', true,
        pageTitle: 'The Apache Groovy programming language - Contribute',
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
                                i(class: 'fa fa-pencil-square-o') {}
                                yield ' Contribute'
                            }
                            article {
                                p '''
                                    Would you like to help us make the Groovy programming language even better? 
                                    There are many ways in which you can get involved, make a difference and help the Groovy development team to make Groovy even, well, groovier? 
                                    We really appreciate and welcome contributions and you can help us by:

                                '''
                                ul {
                                    li {
                                        yield 'helping other users on the '
                                        a(href: 'mailing-lists.html', 'mailing-lists')
                                    }
                                    li {
                                        a(href: '#reporting-issues', 'reporting issues')
                                        yield ' you encounter in our '
                                        a(href: 'https://issues.apache.org/jira/browse/GROOVY', 'bug tracker')
                                    }
                                    li {
                                        a(href: '#documenting', 'documenting')
                                        yield ' various aspects of the language or its APIs'
                                    }
                                    li {
                                        yield 'improving this '
                                        a(href: 'https://github.com/groovy/groovy-website', 'website')
                                    }
                                    li 'covering the code base with more tests to avoid future regressions, '
                                    li {
                                        yield 'and of course, by '
                                        a(href: '#code', 'contributing bug fixes or new features')
                                    }
                                }
                                hr(class: 'divider')

                                h2 'Discussing on the mailing-lists'
                                p {
                                    yield '''
                                        If you encounter a problem, want to discuss a new feature,
                                        share interesting findings, and more, then the '''
                                    a(href: 'mailing-lists.html', 'mailing-lists')
                                    yield ' are the place to go to start a conversation with the Groovy developers and other Groovy users.'
                                }
                                hr(class: 'divider')

                                a(name: 'reporting-issues') {}
                                h2 'Reporting issues'
                                p {
                                    yield 'The Groovy project is using the '
                                    a(href: 'https://issues.apache.org/jira/browse/GROOVY/', 'JIRA bug tracker')
                                    yield '''
                                        to report and track issues, feature enhancements, and new features.
                                        Be sure to be signed-up and logged-in, before proceeding.
                                    '''
                                }
                                p {
                                    button(type: 'button', class: 'btn btn-default', 'Report an issue',
                                            onclick: 'window.location.href="https://issues.apache.org/jira/browse/GROOVY"')
                                }

                                hr(class: 'divider')

                                a(name: 'documenting') {}
                                h2 'Improving the documentation'
                                p 'The documentation of the Groovy programming language comes in various forms:'
                                ul {
                                    li {
                                        yield 'the '
                                        a(href: 'single-page-documentation.html', 'reference documentation')
                                        yield ' covering the language specification, the user guides, getting started, and more.'
                                    }
                                    li {
                                        yield 'the '
                                        a(href: 'api.html', 'GroovyDoc APIs')
                                        yield ' documenting the classes of the Groovy code base'
                                    }
                                    li {
                                        yield 'the '
                                        a(href: 'gdk.html', 'Groovy GDK')
                                        yield ' documentation, explaining how Groovy enriches the JDK APIs'
                                    }
                                    li {
                                        yield 'this '
                                        a(href: 'https://github.com/groovy/groovy-website', 'website')
                                    }
                                }
                                p {
                                    yield 'To contribute to the Groovy reference documentation, this '
                                    a(href: 'http://blog.cacoethes.co.uk/groovyandgrails/contributing-to-the-groovy-documentation', 'blog post')
                                    yield ' gives all the details on how you can work on that documentation.'
                                }
                                p {
                                    yield 'All the above is stored in our code '
                                    a(href: 'https://github.com/groovy', 'repositories on Github')
                                    yield ', so having an account on Github would be ideal.'
                                }
                                p """
                                    Contributing to this website is fairly easy, if you have a Github account already,
                                    as you can click on the ${$em('Improve this doc')} buttons that you can see on all the pages of this website.
                                    So don't hesitate to help us improve it, fix typos, broken language, clarify complicated sections,
                                    add new material, etc.
                                """
                                p 'Please check the following section for more information on how to contribute to our codebase.'
                                hr(class: 'divider')

                                a(name: 'code') {}
                                h2 'Contributing code'
                                p {
                                    yield '''
                                        If you know the area you want to contribute to, this is great, but if you are looking for
                                        some first contributions, the Groovy development team tries to maintain a '''
                                    a(href: 'https://issues.apache.org/jira/secure/IssueNavigator%21executeAdvanced.jspa?jqlQuery=project%3DGROOVY+and+labels+%3D+contrib+AND+resolution%3DUnresolved&runQuery=true&clear=true', 'list of tickets')
                                    yield '''
                                        of possible easy contributions that could get you started on your journey
                                        to become a Groovy committer. Just raise your hand on the Groovy developer '''
                                    a(href: 'mailing-lists.html', 'mailing-list')
                                    yield ''' to tell us about your desire to work on that ticket.'''
                                }
                                p '''
                                    For more complicated tasks, the best approach is also to bring that to the attention of the Groovy developers,
                                    so they can give you some guidance on how best to tackle a particular problem, discuss implementation ideas
                                    and the semantics or scope of the proposed change.
                                '''

                                h3 'Cloning the code base'
                                p {
                                    yield 'To work on the Groovy code base, you should be proficient enough in '
                                    a(href: 'http://git-scm.com/', 'git')
                                    yield ' and you should have an account on '
                                    a(href: 'https://github.com/', 'Github')
                                    yield ' to be able to create '
                                    a(href: 'https://help.github.com/articles/creating-a-pull-request', 'pull requests')
                                    yield ' with your changes.'
                                }
                                p { 
                                    yield 'Please fork '
                                    a(href: 'https://github.com/apache/groovy', 'https://github.com/apache/groovy')
                                    yield ' and create a local clone of your fork as explained in '
                                    a(href: 'https://help.github.com/articles/fork-a-repo/', 'fork a repo')
                                    yield '.'
                                }
                                p 'Make sure you configure Git appropriately with the same email that you registered with on Github:'
                                pre { code 'git config --global user.name "YOUR NAME"\n' +
                                        'git config --global user.email "YOUR EMAIL"' }
                                p 'You can verify these are configured appropriately by running:'
                                pre { code 'git config --list' }

                                h3 'Working on the code base'
                                p {
                                    yield 'If you are working with the IntelliJ IDEA development environment, this '
                                    a(href: 'http://melix.github.io/blog/2014/06/contribute-groovy-ide.html', 'screencast')
                                    yield ' gives lots of details on how to setup your IDE.'
                                }
                                p {
                                    yield 'Then, to work on the Groovy code base, to build and test Groovy, you can follow the '
                                    a(href: 'https://github.com/apache/groovy/blob/master/README.adoc', 'instructions')
                                    yield ' from the readme file in the Groovy repository.'
                                }
                                p 'The most important command you will have to run before sending your changes is the test command:'
                                pre { code './gradlew test' }
                                p 'For a successful contribution, all tests should be green!'

                                h3 'Creating a pull request'
                                p 'Once you are satisfied with your changes:'
                                ul {
                                    li 'commit your changes in your local branch'
                                    li 'push your changes to your remote branch on Github'
                                    li {
                                        yield 'send us a '
                                        a(href: 'https://help.github.com/articles/creating-a-pull-request', 'pull requests')
                                    }
                                }
                            }
                            hr(class: 'divider')

                            h2('Build status')

                            p "The Groovy sources are tested thanks to our ${$a(href:'buildstatus.html','continuous integration server')}."
                        }
                    }
                }
            }
        }
