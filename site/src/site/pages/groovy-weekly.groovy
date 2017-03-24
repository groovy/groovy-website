layout 'layouts/main.groovy', true,
        pageTitle: 'The Apache Groovy programming language - Groovy newsletter',
        mainContent: contents {
            div(id: 'content', class: 'page-1') {
                div(class: 'row') {
                    div(class: 'row-fluid') {
                        div(class: 'col-lg-3') {
                            include template: 'includes/community-navbar.groovy'
                        }

                        div(class: 'col-lg-8 col-lg-pull-0') {
                            include template: 'includes/contribute-button.groovy'
                            h1 {
                                i(class: 'fa fa-envelope-o') {}
                                yield ' Groovy Newsletter '
                            }
                            article {
                                p 'Once in a while, receive a newsletter, directly in your inbox, with all the news ' +
                                        'of the Groovy ecosystem: the latest releases, interesting articles, interviews, ' +
                                        'presentations, relevant tweets or Google+ posts, links to podcasts or screencasts, ' +
                                        'code snippets, books, upcoming events, and more.'
                                p 'The Groovy newsletter is the best way to stay up-to-date with all things Groovy!'
                                p {
                                    yield 'This newsletter is powered by '
                                    a(href: "http://eepurl.com/XXyCD", 'MailChimp')
                                    yield '.'
                                }
                            }
                            hr(class: 'divider')

                            a(name: 'subscribe') {}
                            h2 {
                                i(class: 'fa fa-envelope') {}
                                yield ' Subscribe to the newsletter'
                            }
                            article {
                                p 'To subscribe to the newsletter, please fill in the form below.'
                                p 'Please note that all fields are required.'
                            }
                            div(id: 'mc_embed_signup') {
                                form(action: 'http://appspot.us4.list-manage2.com/subscribe/post?u=cb8b56e9d6a1cb1696cecc673&amp;id=1a76961630',
                                        method: 'post', id: 'mc-embedded-subscribe-form', name: 'mc-embedded-subscribe-form',
                                        class: 'validate', target: '_blank', novalidate: true, role: 'form') {
                                    div(class: 'form-group') {
                                        label(for: 'mce-EMAIL', 'Email address')
                                        input(type: 'email', value: '', class: 'required email form-control', id: 'mce-EMAIL')
                                    }
                                    div(class: 'form-group') {
                                        label(for: 'mce-MNAME', 'First name')
                                        input(type: 'text', value: '', class: 'required required email form-control', id: 'mce-FNAME')
                                    }
                                    div(class: 'form-group') {
                                        label(for: 'mce-LNAME', 'Last name')
                                        input(type: 'text', value: '', class: 'required required email form-control', id: 'mce-LNAME')
                                    }
                                    div(class: 'form-group') {
                                        label(for: 'mce-COMPANY', 'Company')
                                        input(type: 'text', value: '', class: 'required required email form-control', id: 'mce-COMPANY')
                                    }
                                    div(class: 'form-group radio') {
                                        div {
                                            strong 'Email format '
                                        }
                                        label(class: 'radio-inline') {
                                            input(type: 'radio', value: 'html', name: 'EMAILTYPE', id: 'mce-EMAILTYPE-0', checked: 'checked')
                                            span 'html'
                                        }
                                        label(class: 'radio-inline') {
                                            input(type: 'radio', value: 'text', name: 'EMAILTYPE', id: 'mce-EMAILTYPE-1')
                                            span 'text'
                                        }
                                    }
                                    div(id: 'mce-responses', class: 'clear') {
                                        div(class: 'response', id: 'mce-error-response', style: 'display-none') {}
                                        div(class: 'response', id: 'mce-success-response', style: 'display-none') {}
                                    }
                                    div(style: 'position: absolute; left: -5000px') {
                                        input(type: 'text', name: 'b_cb8b56e9d6a1cb1696cecc673_1a76961630', tabindex: '-1', value: '')
                                    }
                                    br()
                                    div(class: 'clear form-group') {
                                        input(type: 'submit', value: 'Subscribe', name: 'subscribe', id: 'mc-embedded-subscribe', class: 'btn btn-default')
                                    }
                                }
                            }
                            hr(class: 'divider')

                            a(name: 'archives') {}
                            h2 {
                                i(class: 'fa fa-archive') {}
                                yield ' Archives'
                            }
                            article {
                                p {
                                    a(href: 'http://us4.campaign-archive2.com/home/?u=cb8b56e9d6a1cb1696cecc673&id=1a76961630',
                                            'View past editions of the Groovy newsletter.')
                                }
                            }
                        }
                    }
                }
            }
        }
