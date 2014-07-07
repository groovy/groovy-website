layout 'layouts/main.groovy', true,
        pageTitle: 'The Groovy programming language - Versioning',
        mainContent: contents {
            div(id: 'content', class: 'page-1') {
                div(class: 'row') {
                    div(class: 'row-fluid') {
                        div(class: 'col-lg-3') {
                            ul(class: 'nav-sidebar') {
                                li {
                                    a(href: 'download.html', 'Download Groovy')
                                }
                                li {
                                    a(href: 'download.html#distro', class: 'anchor-link', 'Distributions')
                                }
                                li {
                                    a(href: 'download.html#gvm', class: 'anchor-link', 'Through GVM')
                                }
                                li {
                                    a(href: 'download.html#buildtools', class: 'anchor-link', 'From your build tools')
                                }
                                li {
                                    a(href: 'download.html#otherways', class: 'anchor-link', 'Other ways to get Groovy')
                                }
                                li {
                                    a(href: 'versioning.html', 'Groovy version scheme')
                                }
                                li(class: 'active') {
                                    a(href: 'indy.html') {
                                        strong 'Invoke dynamic support'
                                    }
                                }
                            }
                        }

                        div(class: 'col-lg-8 col-lg-pull-0') {
                            include template: 'includes/contribute-button.groovy'
                            h1 {
                                i(class: 'fa fa-gear') {}
                                yield ' Invoke dynamic support'
                            }
                            article {
                                h2 'Introduction'
                                p '''
                                    Since Groovy 2.0, we added support for the JVM invokedynamic instruction.
                                    This instruction is supported since Java 7 and is a new bytecode instruction in the JVM
                                    that allows easier implementation of dynamic languages.
                                    This instruction will also be used internally, by the JVM, for the upcoming lamdba support in Java 8.
                                '''
                                p '''
                                    This means that unlike APIs, AST transformations or syntactic sugar,
                                    this feature is not visible to the developer or the end user.
                                    It is a compilation and runtime feature only.
                                    This means that given two programs written in Groovy,
                                    you have the choice to compile it with or without invokedynamic support.
                                    Whatever you choose, it comes with pros and cons.
                                '''
                                ul {
                                    li {
                                        yield 'classes compiled with invokedynamic can only be used on JDK 1.7+'
                                        ul {
                                            li 'without invokedynamic, Groovy classes are still compatible with JDK 1.5+'
                                        }
                                    }
                                    li 'call site caching, as implemented in "normal" Groovy is replaced with invokedynamic since Groovy 2.1'
                                    li 'it is possible to mix classes compiled with and without invokedynamic in the same project, as long as you run JDK 1.7+'
                                    li 'depending on the JVM (even different minor versions of the JVM), you can target close to Java performance for dynamic Groovy with invokedynamic support activated'
                                }

                                h2 'JDK version'
                                p '''
                                    All JDK 7 versions ranging from 7u21 to 7u55 are buggy with regards to invokedynamic.
                                    If you plan to use invokedynamic support, make sure you either use 7u60 or JDK 8.
                                '''

                                h2 'The distributions'
                                h3 'Two JARs'
                                p 'The Groovy distribution comes with two jars:'
                                ul {
                                    li {
                                        code 'groovy-x.y.z.jar'
                                        yield ': compatible with JDK 1.5+, makes use of call site caching'
                                    }
                                    li {
                                        code 'groovy-x-y-z-indy.jar'
                                        yield ': compatible with JDK 1.7+ only, has invokedynamic support bundled, old call site caching still possible'
                                    }
                                }
                                p '''
                                    The first jar is Groovy compiled without invokedynamic support, while the second one has invokedynamic support bundled.
                                    As Groovy core and the groovy modules are sometimes written in Groovy, we currently have no choice but issuing two distinct versions of Groovy.
                                    This means that if you pick the "normal" jar, the groovy classes of groovy itself are compiled with call site caching (1.5+),
                                    while if you use the "indy" jar, the groovy classes of groovy itself are compiled using invokedynamic.
                                    This means that the invokedynamic version of Groovy doesn't make use of the old call site caching mechanism.
                                '''
                                p 'Both jars contain a fully working groovy implementation. They are mutually exclusive (don\'t put both on classpath).'

                                h3 'Command-line and indy'
                                p '''
                                    If you download the distribution and that you use the command line,
                                    it's always the "normal" version of Groovy which is picked up in classpath.
                                    This means that whatever command you use (groovy, groovyc, groovysh or groovyConsole), invokedynamic support is not available out of the box.
                                    To use the invokedynamic version, you have to switch the jars manually.
                                    The distribution makes use of the jars in the lib directory, while the indy jars are available in the indy directory.
                                    You have three things to do:
                                '''
                                ul {
                                    li 'remove or rename the groovy-*.jar files in the lib directory'
                                    li 'replace them with the indy version from the indy directory'
                                    li 'remove the -indy classifier from jar names'
                                }
                                p "Here's a bash script that would do it all at once:"
                                pre { code '$ for f in `ls lib/groovy*.jar | cut -d/ -f2`;do k=`basename $f .jar`; mv lib/$k.jar lib/$k.jar.old; cp indy/$k-indy.jar lib/$k.jar ; done' }

                                h3 'Running groovy script from command line'
                                p '''
                                    The usual way to run a script from the command line is by "groovy foo.groovy", where foo.groovy is the groovy program in source form.
                                    To use indy for this you have to use the indy distribution and "groovy --indy foo.groovy".
                                    Doing this without the indy distribution will result in an error message.
                                '''

                                h3 'The compilation flag'
                                p '''
                                    Independently of the jar version that you use (and after having exchanged the jars as described), invokedynamic support requires a specific compilation flag (indy).
                                    If you want to compile your classes with invokedynamic support, this flag must be set at compile time.
                                    The following tables show you what happens with user compiled classes and groovy core classes depending on the jar you use and the compilation flag:
                                '''
                                p 'For user compiled classes:'
                                table(class: 'table') {
                                    tr {
                                        th 'indy flag'
                                        th 'off'
                                        th 'on'
                                    }
                                    tr {
                                        td 'normal jar'
                                        td 'call site caching'
                                        td 'N/A'
                                    }
                                    tr {
                                        td 'indy jar'
                                        td 'call site caching'
                                        td 'invokedynamic'
                                    }
                                }

                                p 'For core Groovy classes:'
                                table(class: 'table') {
                                    tr {
                                        th 'indy flag'
                                        th 'off'
                                        th 'on'
                                    }
                                    tr {
                                        td 'normal jar'
                                        td 'call site caching'
                                        td 'N/A'
                                    }
                                    tr {
                                        td 'indy jar'
                                        td 'invokedynamic'
                                        td 'invokedynamic'
                                    }
                                }
                                p '''
                                    So even if you use the indy jar, if you don't use the invokedynamic flag at compile time,
                                    then the compiled classes will use the "old" format, meaning they will use the JDK1.5+ classes without invokedynamic.
                                '''
                            }
                            hr(class: 'divider')
                        }
                    }
                }
            }
        }