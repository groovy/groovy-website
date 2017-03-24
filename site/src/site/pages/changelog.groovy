layout 'layouts/main.groovy', true,
        pageTitle: "The Apache Groovy programming language - Groovy $groovyVersion Changelog",
        mainContent: contents {
            def issueMap = issues.groupBy { it.type }
            def issueTypes = issueMap.keySet().sort()

            div(id: 'content', class: 'page-1') {
                div(class: 'row') {
                    div(class: 'row-fluid') {
                        div(class: 'col-lg-3') {
                            ul(class: 'nav-sidebar') {
                                li(class:'active') {
                                    a(href: '#changelog', "Changelog for Groovy $groovyVersion")
                                }
                                issueTypes.eachWithIndex { type, i ->
                                    li { a(href: "#type$i", class: 'anchor-link', type) }
                                }
                            }
                        }

                        div(class: 'col-lg-8 col-lg-pull-0') {
                            a(name:"changelog"){}
                            h1("Changelog for Groovy $groovyVersion")
                            issueTypes.eachWithIndex { type,i ->
                                def list = issueMap[type]
                                a(name:"type$i"){}
                                h2("$type")
                                ul {
                                    list.each { issue ->
                                        li("[${$a(href: 'https://issues.apache.org/jira/browse/' + issue.id, issue.id)}] - ${issue.description}")
                                    }
                                }

                            }
                        }
                    }
                }
            }
        }
