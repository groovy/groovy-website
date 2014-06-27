layout 'layouts/main.groovy',
   menu: menu,
   pageTitle: 'The Groovy programming language',
   contents: contents {
       div(id: 'band', class: 'band') {

       }
       include unescaped: 'html/index.html'
   }
