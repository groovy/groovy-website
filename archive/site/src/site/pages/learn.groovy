import model.Book
import model.Video
import model.Course

layout 'layouts/main.groovy', true,
        pageTitle: 'The Apache Groovy programming language - Learn',
        extraStyles: ['book.css'],
        mainContent: contents {
            div(id: 'content', class: 'page-1') {
                div(class: 'row') {
                    div(class: 'row-fluid') {
                        div(class: 'col-lg-3') {
                            ul(class: 'nav-sidebar') {
                                li(class: 'active') {
                                    a(href: '#') { strong('Learn') }
                                }
                                li {
                                    a(href: '#books', class: 'anchor-link', 'Books')
                                }
                                li {
                                    a(href: '#videos', class: 'anchor-link', 'Presentations')
                                }
                                li {
                                    a(href: '#courses', class: 'anchor-link', 'Courses')
                                }
                            }
                        }

                        div(class: 'col-lg-8 col-lg-pull-0') {
                            include template: 'includes/contribute-button.groovy'
                            h1 {
                                i(class: 'fa fa-graduation-cap') {}
                                yield ' Learn'
                            }
                            article {
                                p 'Welcome to the learning section of the Groovy website.'
                                p """
                                    First of all, you will need to ${$a(href: 'documentation.html#gettingstarted', 'get started')}
                                    by installing Groovy on your system or project.
                                """
                                p """
                                    Once all set up, we invite you to have a look at the Groovy
                                    ${$a(href: 'documentation.html', 'documentation')}, which explains all the
                                    ${$a(href: 'documentation.html#languagespecification', 'details of the language')}, such as how to use the
                                    ${$a(href: 'documentation.html#tools', 'tools')}
                                    that come with a Groovy installation, and how to tackle more complex tasks with the various
                                    ${$a(href: 'documentation.html#groovymoduleguides', 'module user guides')}.
                                """
                                p """
                                    But there are other ways to learn more about Groovy, thanks to ${$a(href: '#books', 'books')}
                                    and ${$a(href: '#videos', 'presentations')} given about Groovy at conferences.
                                """
                                hr(class: 'divider')

                                a(name: 'books') {}
                                h2 {
                                    i(class: 'fa fa-book') {}
                                    yield ' Books'
                                }
                                p '''
                                    Another great approach to learning Groovy is to read the various books published
                                    on the language:'''

                                allBooks.each {
                                    String title = it.key
                                    Book book = it.value

                                    figure(class: 'book') {
                                        ul(class: 'hardcover_front') {
                                            li {
                                                img(src: book.cover, width: '100%', height: '100%')
                                            }
                                            li {}
                                        }
                                        ul(class: 'page') {
                                            li {}
                                            li {
                                                a(class: 'book-btn', href: book.url, target: '_blank', 'More info')
                                            }
                                            3.times { li {} }
                                        }
                                        ul(class: 'hardcover_back') {
                                            2.times { li {} }
                                        }
                                        ul(class: 'book_spine') {
                                            2.times { li {} }
                                        }
                                        figcaption {
                                            h1 { a(href: book.url, book.title) }
                                            span "By ${book.authors}"
                                            p book.description
                                        }
                                    }
                                }

                                hr(class: 'divider')

                                a(name: 'videos') {}
                                h2 {
                                    i(class: 'fa fa-film') {}
                                    yield ' Presentations'
                                }
                                p """
                                    Many Groovy-related presentations have been recorded at ${$a(href: 'events.html', 'conferences')}
                                    that you might wish to have a look at, to learn more about Groovy, delve into particular topics, and more.
                                """
                                p """
                                    Below are a few selected presentations given at the
                                    ${$a(href: 'http://springone2gx.com/', 'SpringOne2GX')},
                                    ${$a(href: 'http://gr8conf.eu/', 'GR8Conf')} and
                                    ${$a(href: 'http://greach.es/', 'Greach')} conferences.
                                """

                                videos.each { Video video ->
                                    div(class: 'presentations') {
                                        a(href: video.videoUrl) {
                                            img(class: 'screenshot', src: "img/videos/${video.pictureUrl}")
                                        }
                                        div(class: 'metadata') {
                                            a(href: video.videoUrl) {
                                                h1(class: 'title', video.title)
                                            }
                                            span(class: 'speaker', "By ${video.speaker}")
                                            if(video.slidesUrl || video.codeUrl) {
                                                p(class: 'urls') {
                                                    if (video.slidesUrl) {
                                                        i(class: 'fa fa-photo') {}
                                                        yield ' '
                                                        a(href: video.slidesUrl, 'slides')
                                                    }
                                                    if (video.slidesUrl && video.codeUrl) yield ' | '
                                                    if (video.codeUrl) {
                                                        i(class: 'fa fa-code') {}
                                                        yield ' '
                                                        a(href: video.codeUrl, 'source code')
                                                    }
                                                }
                                            }
                                            div(class: 'summary') {
                                                yieldUnescaped video.summary
                                            }
                                        }
                                    }
                                }

                                p "You can find more presentations:"
                                ul {
                                    li {
                                        a(href: 'https://www.youtube.com/channel/UCJXNOMywewNmau4hzAy4LjA/videos', 'GR8Conf YouTube channel')
                                    }
                                    li {
                                        a(href: 'https://www.youtube.com/user/GR8ConfUS/videos', 'GR8Conf US YouTube channel')
                                    }
                                    li {
                                        a(href: 'https://www.youtube.com/user/TheGreachChannel/videos', 'Greach YouTube channel')
                                    }
                                }

                                hr(class: 'divider')

                                a(name: 'courses') {}
                                h2 {
                                    i(class: 'fa fa-film') {}
                                    yield ' Courses'
                                }
                                p '''
                                    Another great resource for learning Groovy is by watching a course. You could spend time hunting down
                                    various videos on the web but these courses have all the information you need packed into one place.
                                  '''

                                courses.each { Course course ->
                                    div(class: 'courses') {
                                        a(href: course.url, target: "_blank") {
                                            img(class: 'screenshot', src: "img/courses/${course.cover}")
                                        }
                                        div(class: 'metadata') {
                                            a(href: course.url, target: '_blank') {
                                                h1(class: 'title', course.title)
                                            }
                                            span(class: 'instructor', "By ${course.instructor}")
                                            div(class: 'description') {
                                                yieldUnescaped course.description
                                            }
                                        }
                                    }
                                }

                            }
                        }
                    }
                }
            }
        }
