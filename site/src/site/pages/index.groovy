import model.Event

layout 'layouts/main.groovy', true,
        pageTitle: 'The Groovy programming language',
        mainContent: contents {
            div(id: 'band', class: 'band') {

            }
            div(id: 'content') {
                include unescaped: 'html/index.html'

                section(class: "row colset-3-article") {
                    h1 { strong "Groovy events you shouldn't miss!" }
                    allEvents.keySet().take(3).each { String eventName ->
                        Event event = allEvents[eventName]
                        article {
                            div(class: 'content') {
                                div(class: 'event-img', style: "background-image: url(${event.logo})") {}
                                h1 {
                                    a(href: event.url) {
                                        strong eventName
                                        br()
                                        em event.location
                                    }
                                }
                                time event.date
                                yieldUnescaped event.description
                            }
                        }
                    }
                }
            }
            include unescaped: 'html/they-use-groovy.html'
        }
