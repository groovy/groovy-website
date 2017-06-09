layout 'layouts/main.groovy', true,
        pageTitle: 'The Apache Groovy programming language - Versioning',
        mainContent: contents {
            div(id: 'content', class: 'page-1') {
                div(class: 'row') {
                    div(class: 'row-fluid') {
                        div(class: 'col-lg-3') {
                            ul(class: 'nav-sidebar') {
                                li {
                                    a(href: 'download.html', 'Download Groovy')
                                }
                                li {
                                    a(href: 'download.html#distro', class: 'anchor-link', 'Distributions')
                                }
                                li {
                                    a(href: 'download.html#sdkman', class: 'anchor-link', 'Through SDKMAN!')
                                }
                                li {
                                    a(href: 'download.html#buildtools', class: 'anchor-link', 'From your build tools')
                                }
                                li {
                                    a(href: 'download.html#otherways', class: 'anchor-link', 'Other ways to get Groovy')
                                }
                                li(class: 'active') {
                                    a(href: 'versioning.html') {
                                        strong 'Groovy version scheme'
                                    }
                                }
                                li {
                                    a(href: 'indy.html', 'Invoke dynamic support')
                                }
                            }
                        }

                        div(class: 'col-lg-8 col-lg-pull-0') {
                            include template: 'includes/contribute-button.groovy'
                            h1 {
                                i(class: 'fa fa-copy') {}
                                yield ' Groovy version scheme'
                            }
                            article {
                                h2 'Since Groovy 2.0.0'
                                p "Since Groovy 2.0.0 we follow the ${$a(href: "http://semver.org/", 'semantic version scheme')}. This means the next minor version after 2.0.0 is 2.1.0, the first bugfix version after 2.0 is 2.0.1 and the next major version will be 3.0.0."

                                h2 'Before Groovy 2.0.0'
                                p 'Before Groovy 2.0.0 we followed a version scheme where we had X.Y.Z, where X.Y was the major version, and Z the minor version.\n' +
                                        'Bugfix versions were not really done, you had to upgrade to the next minor version for that.\n' +
                                        'Since Groovy 1.0 we incremented only the Y for a new major version.\n' +
                                        'The increment of X we wanted to leave for a very big breaking change, like a new Meta-Object Protocol.\n' +
                                        'The last major version in these scheme is 1.8(.0), 1.8.1 is the first minor and bugfix version.\n' +
                                        'The major versions in the past using this scheme are: 1.8, 1.7, 1.6, 1.5, 1.0. Each of them having around 10 minor/bugfix versions.'

                                h2 'Official Major Version'
                                p 'The official major version is the current major version that should/can be used by the developers if they are not bound to a specific major version.'

                                h2 'Maintenance Release Branch'
                                p 'Here we indicate a former major version\'s bugfix release.'

                                h2 'How long is a major version maintained?'
                                p 'That depends on the users. Let\'s say we have X in maintenance and Y is the official major version, ' +
                                        'then if a new major version Z is released, Y goes into maintenance. Usually we make one or two more bugfix releases for X and then we discontinue it, ' +
                                        'unless there are strong requests to have certain things fixed for users that can absolutely not upgrade.'
                            }
                            hr(class: 'divider')
                        }
                    }
                }
            }
        }
