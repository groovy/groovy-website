layout 'layouts/main.groovy', true,
        pageTitle: 'The Apache Groovy programming language - Thanks',
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
                                i(class: 'fa fa-building-o') {}
                                yield ' Thanks'
                            }
                            article {
                                p "The Apache Groovy team would like to thank:"
                                ul {
                                    li """
                                        ${$a(href: 'http://www.apache.org', 'The Apache Software Foundation')} which owns
                                        the project. We want to ${$a(href: 'http://www.apache.org/foundation/thanks.html', 'thank')} the Apache
                                        Software Foundation and its sponsors for providing support for the Apache Community of open-source software projects.
                                     """
                                    li """
                                        ${$a(href: 'http://www.jetbrains.com/', 'JetBrains')} cover the cost of our server
                                        which runs our continuous integration server, hosts our documentation and website,
                                        and they are also offering free licenses for
                                        the ${$a(href: 'http://www.jetbrains.com/teamcity/', 'TeamCity')} integration server and
                                        the ${$a(href: 'http://www.jetbrains.com/idea/', 'IntelliJ IDEA')} development environment.
                                    """
                                    li """
                                        ${$a(href: 'http://www.jfrog.com/', 'JFrog')} provide the infrastructure
                                        for deploying and hosting our snapshots and releases,
                                        thanks to the ${$a(href: 'https://bintray.com/', 'Bintray')} social platform for distribution,
                                        and the OSS ${$a(href: 'http://www.jfrog.com/home/v_artifactory_opensource_overview', 'Artifactory')} repository.
                                    """
                                }
                                p """
                                    Sponsors are a key ingredient of the success of the Apache projects.
                                    If you consider helping the project in any way,
                                    please don't hesitate to contact the Groovy development team.
                                    Your help will be most appreciated.
                                """
                            }
                            hr(class: 'divider')
                        }
                    }
                }
            }
        }
