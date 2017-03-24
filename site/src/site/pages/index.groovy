import model.Event

layout 'layouts/main.groovy', true,
        pageTitle: 'The Apache Groovy programming language',
        mainContent: contents {
            div(id: 'band', class: 'band') {

            }
            div(id: 'content') {
                include unescaped: 'html/index.html'

                def firstTreeEvents = allEvents.keySet().take(3)
                section(class: 'row colset-3-article first-event-row') {
                    h1 { strong "Groovy and Grails events you shouldn't miss!" }
                    firstTreeEvents.each { String eventName ->
                        Event event = allEvents[eventName]
                        article {
                            div(class: 'content') {
                                // Note that the event image should be 257x180 to look nice
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
                section(class: 'row  last-event-row') {
                    p(class: 'text-center') {
                        yield "For more events see the "
                        a(href: relative("events.html")) { strong('Events') }
                        yield " page"
                    }
                }

            }
            include unescaped: 'html/they-use-groovy.html'
        }
