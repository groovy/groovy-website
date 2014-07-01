layout 'layouts/main.groovy',
        menu: menu,
        category: category,
        allEvents: allEvents,
        pageTitle: 'The Groovy programming language',
        mainContent: contents {
            div(id: 'band', class: 'band') {

            }
            div(id: 'content') {
                include unescaped: 'html/index.html'
//                include unescaped: 'html/next-events.html'

                boolean titleDisplayed = false
                allEvents.keySet().toList().collate(3).each { List<String> eventNames ->
                    section(class: "row colset-3-article") {
                        if (!titleDisplayed) {
                            h1 { strong "Groovy events you shouldn't miss!" }
                            titleDisplayed = true
                        }
                        eventNames.each { String eventName ->
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
            }
            include unescaped: 'html/they-use-groovy.html'
        }
