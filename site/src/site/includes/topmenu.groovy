div(class: 'navbar navbar-default navbar-static-top', role: 'navigation') {
    div(class: 'container') {
        div(class: 'navbar-header') {
            button(type: 'button', class: 'navbar-toggle', 'data-toggle': 'collapse', 'data-target': '.navbar-collapse') {
                span(class: 'sr-only') {}
                span(class: 'icon-bar') {}
                span(class: 'icon-bar') {}
                span(class: 'icon-bar') {}
            }
            a(class: 'navbar-brand', href: 'index.html') {
                i(class: 'fa fa-star') {}
                yield ' Groovy'
            }
        }
        div(class: 'navbar-collapse collapse') {
            ul(class: 'nav navbar-nav navbar-right') {
                menu['Groovy'].each { menuItem ->
                    li(class: category == menuItem.name ? 'active' : '') { a(href: menuItem.link, menuItem.name) }
                }
                li {
                    a('data-effect': 'st-effect-9', class: 'st-trigger', href: '#', 'Socialize')
                }
                li(class: (category == 'Search') ? 'active' : '') {
                    a(href: 'search.html') {
                        i(class: 'fa fa-search') {}
                    }
                }
            }
        }
    }
}