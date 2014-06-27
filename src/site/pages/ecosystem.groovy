layout 'layouts/main.groovy',
   menu: menu,
   pageTitle: 'The Groovy programming language - Ecosystem',
   contents: contents {
       div(id: 'content', class:'page-1') {
           section(class:'row') {
               div(class:'row-fluid') {
                   div(class: 'col-lg-3') {
                       ul(class:'nav-sidebar') {
                           li(class:'active') { a(href:'ecosystem.html') { strong('Ecosystem') } }
                           ecosys.keySet().each { name ->
                               li { a(href:"#$name", name) }
                           }
                       }
                   }
                   div(class:'col-lg-8 col-lg-pull-0') {
                       h1('Ecosystem')
                       p {
                           yield '''
                                        Beside the language and its API, Groovy gave birth to a fruitful ecosystem of projects around it,
                                        on various themes such as web frameworks, desktop application framework, concurrency, testing, and more.
                                        In this section, we'll highlight a few of the most well-known and successful projects,
                                        which leverage Groovy at their core.
                            '''
                       }
                       hr(class:'divider')

                       ecosys.each {
                           def (name, item) = [it.key, it.value]
                           article {
                               a(name:"${name}"){}
                               h2(name)
                               p(item.description)
                               a(href:item.url, "Learn more...")
                           }
                           hr(class:'divider')
                       }
                   }
               }
           }
       }
   }
