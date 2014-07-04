layout 'layouts/main.groovy',
        menu: menu,
        category: category,
        pageTitle: 'The Groovy programming language - Search',
        mainContent: contents {
            div(id: 'content', class: 'page-1') {
                div(class: 'row') {
                    div(class: 'row-fluid') {
                        div(class: 'col-lg-3') {
                            ul(class: 'nav-sidebar') {
                                li(class: 'active') {
                                    a(href: 'search.html') { strong('Search') }
                                }
                            }
                            br()
                        }

                        div(class: 'col-lg-8 col-lg-pull-0') {
                            h1 'Search'
                                script '''
                                  (function() {
                                    var cx = '013939896723962546743:hbhn__olhii';
                                    var gcse = document.createElement('script');
                                    gcse.type = 'text/javascript';
                                    gcse.async = true;
                                    gcse.src = (document.location.protocol == 'https:' ? 'https:' : 'http:') +
                                        '//www.google.com/cse/cse.js?cx=' + cx;
                                    var s = document.getElementsByTagName('script')[0];
                                    s.parentNode.insertBefore(gcse, s);
                                  })();
                                '''
                                'gcse:search'(){}
                            hr(class: 'divider')
                        }
                    }
                }
            }
        }