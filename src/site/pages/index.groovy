layout 'layouts/main.groovy',
        menu: menu,
        category: category,
        pageTitle: 'The Groovy programming language',
        mainContent: contents {
            div(id: 'band', class: 'band') {

            }
            include unescaped: 'html/index.html'
        }
