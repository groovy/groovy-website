import model.UserGroup

/**
 * Ths template is generating the user groups page.
 * If you want to add a user group, please edit the "usergroups" section in src/site/sitemap-user.groovy
 */

layout 'layouts/main.groovy', true,
        pageTitle: 'The Apache Groovy programming language - User groups',
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

                                Map groups = userGroups.groupBy { UserGroup g -> g.locationParts[0] }.sort { it.key }
                                def groupAnchor = { groupName -> groupName.toLowerCase().replaceAll('[^a-zA-Z]', '') }

                                // anchors for continents
                                ul {
                                    groups.keySet().each { group ->
                                        li { a(href: "#${groupAnchor(group)}", group) }
                                    }
                                }

                                // iterate on each top region
                                groups.each { name, list ->
                                    hr(class: 'divider')
                                    a(name: groupAnchor(name)) {}
                                    h2(name)
                                    Map split = list.groupBy { UserGroup g -> g.locationParts[1] }.sort { it.key }
                                    split.each { subregion, items ->
                                        h3(subregion)
                                        ul {
                                            items.each { g ->
                                                if (g.url) {
                                                    li { a(href: g.url, g.name) }
                                                } else {
                                                    li(g.name)
                                                }
                                            }
                                        }
                                    }
                                }
                            }
                        }
                    }
                }
            }
        }
