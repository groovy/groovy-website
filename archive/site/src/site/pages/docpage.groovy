/**
 * This layout accepts the following parameters:
 *
 * @param menu the navigation menu
 * @param pageTitle the page title
 * @param extraStyles , a list of CSS files to be added in the header
 * @param scripts , a list of scripts to be imported
 * @param iframeTarget , the URL of the page to be included as an iframe
 */
layout 'layouts/main.groovy', true,
        pageTitle: "The Apache Groovy programming language - $title",
        extraStyles: ['docstyle.css','https://cdnjs.cloudflare.com/ajax/libs/prettify/r298/prettify.min.css'],
        extraFooter: contents {
            script(src: 'https://cdnjs.cloudflare.com/ajax/libs/prettify/r298/prettify.min.js') {}
            script { yieldUnescaped "document.addEventListener('DOMContentLoaded',prettyPrint)" }
        },
        mainContent: contents {
            div(id: 'content', class: 'page-1') {
                div(class: 'row') {
                    div(class: 'row-fluid') {
                        div(class: 'col-lg-3') {
                            ul(class: 'nav-sidebar') {
                                li(class: 'active') {
                                    a(href: '#') { strong('Table of contents') }
                                }
                                yieldUnescaped page.toc
                            }
                        }

                        div(class: 'col-lg-8 col-lg-pull-0') {
                            h1(title)
                            yieldUnescaped(page.content)
                        }
                    }
                }
            }
        }
