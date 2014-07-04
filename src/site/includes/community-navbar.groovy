
ul(class: 'nav-sidebar') {
    ['community':'Community','contribute':'Contribute','mailing-lists':'Mailing-lists','events':'Events','hipchat':'Chat'].each { page, label ->
        if (currentPage==page) {
            li(class:'active') {a(href: "${page}.html") { strong(label) } }
        } else {
            li { a(href: "${page}.html", label) }
        }
    }
}
br()
include unescaped: 'html/twittersearch.html'
