layout 'layouts/main.groovy', true,
        pageTitle: 'The Groovy programming language - Continuous integration',
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
                                i(class: 'fa fa-circle-o-notch') {}
                                yield ' Continuous integration'
                            }
                            article {
                                p """
                                    Our ${
                                    $a(href: 'http://ci.groovy-lang.org?guest=1', 'continuous integration server')
                                },
                                    sponsored by ${$a(href: 'http://www.jetbrains.com', 'Jetbrains')},
                                    builds Groovy against multiple JDK versions, as well as some projects from the community tested
                                    against development versions of Groovy:
                                """
                                hr(class: 'divider')

                                h2 'Groovy builds'

                                def renderBuilds = { Map builds ->
                                    table(class: 'table table-stripped') {
                                        thead {
                                            tr {
                                                th('Build name')
                                                th('Status')
                                            }
                                        }
                                        tbody {
                                            builds.each { name, ref ->
                                                def (id, branch) = ref
                                                tr {
                                                    td(name)
                                                    td {
                                                        a(href: "http://ci.groovy-lang.org/viewType.html?buildTypeId=$id&branch=$branch&tab=buildTypeStatusDiv&guest=1") {
                                                            img(src: """http://ci.groovy-lang.org:8111/app/rest/builds/buildType:(id:$id)${branch?",branch:$branch":''}/statusIcon""")
                                                        }
                                                    }
                                                }
                                            }
                                        }
                                    }
                                }
                                renderBuilds(['Groovy master, JDK 6': ['Groovy_Jdk6Build','master'],
                                        'Groovy master, JDK 7': ['Groovy_Jdk7Build', 'master'],
                                        'Groovy master, JDK 8': ['Groovy_Jdk8Build_2', 'master'],
                                        'Groovy master, JDK 9': ['Groovy_Jdk9Build', 'master'],
                                        'Groovy 2.3.X, JDK 6': ['Groovy_Jdk6Build', 'GROOVY_2_3_X'],
                                        'Groovy 2.3.X, JDK 7': ['Groovy_Jdk7Build', 'GROOVY_2_3_X'],
                                        'Groovy 2.2.X, JDK 5': ['Groovy_Jdk5Build', 'GROOVY_2_2_X'],
                                        'Groovy 2.2.X, JDK 6': ['Groovy_Jdk6Build', 'GROOVY_2_2_X'],
                                        'Groovy 2.2.X, JDK 7': ['Groovy_Jdk7Build', 'GROOVY_2_2_X'],
                                        ])

                                hr(class: 'divider')

                                h2 'Community joint builds'
                                renderBuilds(['Nextflow master, Groovy 2.3.X': ['JointBuilds_Nextflow_Groovy23xJointBuil',''],
                                              'Nextflow master, Groovy 2.4.X': ['JointBuilds_Nextflow_Groovy24xJointBuild', ''],
                                              'Ratpack master, Groovy 2.3.X': ['JointBuilds_Ratpac_RatpackGroovy23x', ''],
                                              'Ratpack master, Groovy 2.4.X': ['JointBuilds_Ratpac_RatpackGroovy24x', '']
                                ])

                                p """
                                    The Groovy development team is willing to test Groovy development versions against important
                                    ecosystem projects. If you want your project to be added to the list, please contact
                                    us on the ${$a(href:'mailing-lists.html','development mailing list')}.
                                """
                            }
                        }
                    }
                }
            }
        }