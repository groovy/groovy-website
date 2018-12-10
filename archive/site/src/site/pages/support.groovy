layout 'layouts/main.groovy', true,
        pageTitle: 'The Apache Groovy programming language - Support',
        mainContent: contents {
            div(id: 'content', class: 'page-1') {
                div(class: 'row') {
                    div(class: 'row-fluid') {
                        div(class: 'col-lg-3') {
                            include template: 'includes/support-navbar.groovy'
                        }

                        div(class: 'col-lg-8 col-lg-pull-0') {
                            include template: 'includes/contribute-button.groovy'
                            h1 {
                                i(class: 'fa fa-users') {}
                                yield ' Support'
                            }
                            article {
                                p 'There are numerous ways to get help with Groovy: '
                                ul {
                                    li "discuss language usage or direction with other Groovy users and developers through the ${$a(href: 'mailing-lists.html', 'mailing-lists')} - this is the place for all official discussions"
                                    li "discuss matters on ${$a(href: 'https://groovycommunity.com/', 'Slack')}; it's run by Groovy enthusiasts in the community for casual conversations and Q&A"
                                    li "ask a question on ${$a(href: 'https://stackoverflow.com/questions/tagged/groovy', 'Stack Overflow')}; these are answered by Groovy enthusiasts in the community"
                                    li "find known issues (or create new ones) in our ${$a(href: 'reporting-issues.html', 'bug tracker')}"
                                    li "attend upcoming ${$a(href: 'events.html', 'events and conferences')} to learn more about Groovy and to share your experience with others"
                                    li "visit a local ${$a(href: 'usergroups.html', 'user group')} to meet other Groovy enthusiasts"
                                }
                                p '''
                                    If you click on the socialize link in the menu, you will also find other ways to interact
                                    with the Groovy community, and follow the news around the ecosystem:
                                '''
                                ul {
                                    li {
                                        a(href: 'groovy-weekly.html', 'Groovy newsletter')
                                        yieldUnescaped ' &mdash; links to articles, presentations, tweets, podcasts, etc.'
                                    }
                                    li {
                                        a(href: 'https://google.com/+groovy', 'Google+ Groovy page')
                                        yieldUnescaped ' &mdash; for sharing news and articles'
                                    }
                                    li {
                                        a(href: 'http://bit.ly/g-community', 'Google+ Groovy community')
                                        yieldUnescaped ' &mdash; for discussing and exchanging with other Groovy users'
                                    }
                                }
                            }
                            hr(class: 'divider')
                        }
                    }
                }
            }
        }
