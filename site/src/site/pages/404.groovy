/**
 * Ths template is generating the 404 page
 */

layout 'layouts/main.groovy', true,
        pageTitle: 'The Apache Groovy programming language - 404',
        mainContent: contents {
            div(id: 'content', class: 'page-1') {
                div(class: 'row') {
                    div(class: 'row-fluid') {
                        div(class: 'panel panel-danger') {
                            div(class: 'panel-heading', 'Oops! The page you are looking for does not exist!')
                            div(class: 'panel-body') {
                                p 'We could not find the page you are looking for. Maybe you are looking for one of those?'
                                ul {
                                    li("The ${$a(href: latestDocURL('documentation'), 'reference documentation')} of the Groovy language.")
                                    li("The latest ${$a(href: latestDocURL('api'), 'Javadocs')} of the language.")
                                    li("The latest ${$a(href: latestDocURL('gapi'), 'Groovdocs')} of the language.")
                                    li("Description of ${$a(href: latestDocURL('groovy-jdk'), 'the Groovy development kit APIs')}.")
                                }
                            }
                        }
                    }
                }
            }
        }

