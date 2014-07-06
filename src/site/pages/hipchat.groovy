layout 'layouts/main.groovy',
        currentPage: currentPage,
        menu: menu,
        category: category,
        pageTitle: 'The Groovy programming language - Chatting',
        extraFooter: contents {
            script(src:'js/jquery.hipchat.js', type:'text/javascript') {}
            script(src:'js/hipchatwidget.js', type:'text/javascript') {}
        },
        mainContent: contents {
            div(id: 'content', class: 'page-1') {
                div(class: 'row') {
                    div(class: 'row-fluid') {
                        div(class: 'col-lg-3') {
                            include template: 'includes/community-navbar.groovy'
                        }

                        div(class: 'col-lg-8 col-lg-pull-0') {
                            h1 {
                                i(class: 'fa fa-comments-o') {}
                                yield ' Chat'
                            }
                            article {
                                p 'Here you can chat with the Groovy Development Team and other members of the Groovy community.'
                                p {
                                    yieldUnescaped '''
                                        This chat-room is <strong>not</strong> a way to get support (please use the
                                        <a href="mailing-lists.html">mailing lists</a> for this) but a discussion channel
                                        around the Groovy language and future developments.
                                        '''
                                }
                                p 'You can use it to ask questions related to the development of the language itself, but in any case, answers are left to the discretion of people on the channel.'
                            }
                            hr(class: 'divider')
                            div id:'hipchatpanel', class:'hipchatpanel'
                        }
                    }
                }
            }
        }