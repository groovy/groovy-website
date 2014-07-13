layout 'layouts/main.groovy', true,
        pageTitle: 'The Groovy programming language - Sponsors',
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
                                yield ' Sponsors'
                            }
                            article {
                                p "The Groovy project is generously sponsored by several companies:"
                                ul {
                                    li "${$a(href: 'http://gopivotal.com/', 'Pivotal')} hire key project committers"
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
                                    Sponsors are a key ingredient of the success of the Groovy project.
                                    If you consider helping the project in a way or another,
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