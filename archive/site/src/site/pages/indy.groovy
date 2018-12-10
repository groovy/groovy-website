layout 'layouts/main.groovy', true,
        pageTitle: 'The Apache Groovy programming language - Invoke dynamic support',
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
                                    a(href: 'download.html#sdkman', class: 'anchor-link', 'Through SDKMAN!')
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
                                    Since Groovy 2.0, support was added for the JVM invokedynamic instruction.
                                    This instruction is supported since Java 7 and is a new bytecode instruction in the JVM
                                    that allows easier implementation of dynamic languages.
                                    This instruction is used internally, by the JVM, for the lambda support in Java 8.
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
                                            li 'without invokedynamic, Groovy classes are still compatible with JDK 1.6+'
                                        }
                                    }
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
                                        yield ': compatible with JDK 1.6+, contains Groovy sources compiled with call site caching'
                                    }
                                    li {
                                        code 'groovy-x-y-z-indy.jar'
                                        yield ': compatible with JDK 1.7+, contains Groovy sources compiled with invokedynamic'
                                    }
                                }
                                p '''
                                    As Groovy core and the Groovy modules are sometimes written in Groovy, we currently have no choice but to distribute two distinct versions of Groovy.
                                    This means that if you pick the "normal" jar, the Groovy classes of Groovy itself are compiled with call site caching,
                                    while if you use the "indy" jar, the Groovy classes of Groovy itself are compiled using invokedynamic.
                                '''
                                p '''Both jars contain a fully working Groovy implementation that is capable of compiling user supplied Groovy sources using either 
                                     invokedynamic or call site caching. The sets of jars are mutually exclusive (don't put both on classpath) and the key difference between 
                                     them has to do with how the Groovy source files that make up Groovy itself are compiled.
                                '''
                                p '''
                                    When accessing a Groovy jar from a Maven repository, you can select the indy version using the 'indy' classifier.
                                '''

                                h3 'Command-line and indy'
                                p '''
                                    If you download the distribution and use the command line,
                                    it's always the "normal" version of Groovy which is picked up in classpath.
                                    This means that whatever command you use (groovy, groovyc, groovysh or groovyConsole), invokedynamic support is not available out of the box.
                                    To use a Groovy distribution that was compiled with invokedynamic for its Groovy sources you have to switch the jars manually.
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
                                    The usual way to run a script from the command line is by "groovy foo.groovy", where foo.groovy is the Groovy program in source form.
                                    To use indy for this you have to use the indy compilation flag, "groovy --indy foo.groovy".
                                '''

                                h3 'The compilation flag'
                                p '''
                                    Independently of the jar version that you use, invokedynamic support requires a specific compilation flag (indy).
                                    If you want to compile your classes with invokedynamic support, this flag must be set at compile time.
                                    The following tables show you what happens with user compiled classes and Groovy core classes depending on the jar you use and the compilation flag:
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
                                        td 'invokedynamic'
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
                                        td 'call site caching'
                                    }
                                    tr {
                                        td 'indy jar'
                                        td 'invokedynamic'
                                        td 'invokedynamic'
                                    }
                                }
                                p '''
                                    So even if you use the indy jar, if you don't use the invokedynamic flag at compile time,
                                    then the compiled classes will use the "old" format, meaning they will use the JDK1.6+ classes without invokedynamic.
                                '''
                            }
                            hr(class: 'divider')
                        }
                    }
                }
            }
        }
