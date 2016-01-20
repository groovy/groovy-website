
ul(class: 'nav-sidebar') {
    [
            'community': 'Community',
            'contribute': 'Contribute',
            'thanks': 'Thanks',
            'mailing-lists': 'Mailing-lists',
            'events': 'Events',
            'usergroups': 'User groups',
            'groovy-weekly': 'Groovy newsletter'
    ].each { page, label ->
        if (currentPage == page) {
            li(class: 'active') { a(href: relative("${page}.html")) { strong(label) } }
        } else {
            li { a(href: "${page}.html", label) }
        }
    }
    li { a(href: relative("groovy-weekly.html#subscribe"), class: 'anchor-link', 'Subscribe') }
    li { a(href: relative("groovy-weekly.html#archives"), class: 'anchor-link', 'Archive') }
}
br()
include unescaped: 'html/twittersearch.html'
