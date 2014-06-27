header(id: 'header') {
    div(class: 'row') {
        h1(id: 'logo') { a(href: 'index.html', 'Groovy') }
        nav(id: 'navigation') {
            ul {
                menu['Groovy'].each { menuItem ->
                    li { a(href: menuItem.link, menuItem.name) }
                }
                li {
                    a('data-effect': 'st-effect-9', class: 'st-trigger', href: '#', 'Socialize')
                }
            }
        }
    }
}
