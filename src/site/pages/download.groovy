layout 'layouts/main.groovy',
        pageTitle: 'The Groovy programming language - Download',
        contents: contents {
            div(id: 'content', class: 'page-1') {
                div(class: 'row') {
                    div(class: 'row-fluid') {
                        div(class: 'col-lg-3') {
                            ul(class: 'nav-sidebar') {
                                li(class: 'active') {
                                    a(href: 'download.html') { strong('Download') }
                                }
                                li {
                                    a(href: '#distro', 'Distributions')
                                }
                                li {
                                    a(href: '#gvm', 'Through GVM')
                                }
                                li {
                                    a(href: '#buildtools', 'From your build tools')
                                }
                                li {
                                    a(href: '#otherways', 'Other ways')
                                }
                                li {
                                    a(href: 'versioning.html', 'Versioning')
                                }
                                li {
                                    a(href: 'indy.html', 'Invoke dynamic support')
                                }
                            }
                        }

                        div(class: 'col-lg-8 col-lg-pull-0') {
                            h1 'Download'
                            article {
                                p {
                                    yield 'In this download area, you will be able to download the '
                                    a(href: '#distro', 'distribution')
                                    yield ' (binary and source), the Windows installer (for some of the versions) and the documentation for Groovy.'
                                }
                                p {
                                    yield 'For a quick and effortless start on Mac OSX, Linux or Cygwin, you can use '
                                    a(href: 'http://gvmtool.net', 'GVM (Groovy enVironment Manager)')
                                    yield ' to download and configure any Groovy version of your choice. Basic instructions can be found below.'
                                }
                            }
                            hr(class: 'divider')

/*
                            <a name="distro"></a>
                                    <article>
                                        <h1>Distributions</h1>
                            <p>
                                    You can download a binary, a source, a documentation bundle,
                            as well as a bundle of the three.
                                    </p>
                                        <h2>Groovy 2.4</h2>
                            <p>
                                    Groovy 2.4 is currently in beta testing. If you want a stable version,
                            please choose Groovy 2.3 which is our latest official
                            <a href="versioning.html">version</a> of Groovy.
                                        </p>
                            <h3>Groovy 2.4.0-beta-1 distributions</h3>
                                        <table width="100%" class="download-table">
                                            <tr>
                                                <td>
                                                    <a href="http://dl.bintray.com/groovy/maven/groovy-binary-2.4.0-beta-1.zip">
                            <i class="fa fa-gears fa-4x"></i><br/> binary
                            </a>
                                                </td>
                            <td>
                            <a href="http://dl.bintray.com/groovy/maven/groovy-src-2.4.0-beta-1.zip">
                            <i class="fa fa-code fa-4x"></i><br/> source
                            </a>
                                                </td>
                            <td>
                            <a href="http://dl.bintray.com/groovy/maven/groovy-docs-2.4.0-beta-1.zip">
                            <i class="fa fa-file-text fa-4x"></i><br/> documentation
                            </a>
                                                </td>
                            <td>
                            <a href="http://dl.bintray.com/groovy/maven/groovy-sdk-2.4.0-beta-1.zip">
                            <i class="fa fa-file-zip-o fa-4x"></i><br/> bundle
                            </a>
                                                </td>
                            <td>

                            </td>
                                            </tr>
                            </table>
                                        <p>
                                            Consult the <a href="https://jira.codehaus.org/secure/ReleaseNote.jspa?projectId=10242&version=20369">JIRA release notes</a>.<br>
                            Read the <a href="indy.html">invoke dynamic support information</a> if you wish to use it on JDK 7+.
                                        </p>

                            <h2>Groovy 2.3</h2>
                                        <p>
                                            Groovy 2.3 is our latest official <a href="versioning.html">version</a> of Groovy.
                                    </p>
                                        <h3>Groovy 2.3.3 distributions</h3>
                            <table width="100%" class="download-table">
                            <tr>
                            <td>
                            <a href="http://dl.bintray.com/groovy/maven/groovy-binary-2.3.3.zip">
                            <i class="fa fa-gears fa-4x"></i><br/> binary
                            </a>
                                                </td>
                            <td>
                            <a href="http://dl.bintray.com/groovy/maven/groovy-src-2.3.3.zip">
                            <i class="fa fa-code fa-4x"></i><br/> source
                            </a>
                                                </td>
                            <td>
                            <a href="http://dl.bintray.com/groovy/maven/groovy-docs-2.3.3.zip">
                            <i class="fa fa-file-text fa-4x"></i><br/> documentation
                            </a>
                                                </td>
                            <td>
                            <a href="http://dl.bintray.com/groovy/maven/groovy-sdk-2.3.3.zip">
                            <i class="fa fa-file-zip-o fa-4x"></i><br/> bundle
                            </a>
                                                </td>
                            <td>
                            <a href="http://dist.codehaus.org/groovy/distributions/installers/windows/nsis/groovy-2.3.3-installer.exe">
                            <i class="fa fa-windows fa-4x"></i><br/> windows installer
                            </a>
                                                </td>
                            </tr>
                                        </table>
                            <p>
                                    Consult the <a href="https://jira.codehaus.org/secure/ReleaseNote.jspa?projectId=10242&version=20369">JIRA release notes</a>.<br>
                                            Read the <a href="indy.html">invoke dynamic support information</a> if you wish to use it on JDK 7+.
                            </p>

                                    </article>
                            <hr class="divider" />

                            <a name="gvm"></a>
                                    <article>
                                        <h1>GVM (the Groovy enVironment Manager)</h1>
                            <p>This tool makes installing Groovy on any Bash platform (Mac OSX, Linux, Cygwin, Solaris or FreeBSD) very easy.<br />
                            Simply open a new terminal and enter:</p>
                                        <pre><code>$ curl -s get.gvmtool.net | bash</code></pre>
                                        <p>Follow the instructions on-screen to complete installation.<br />
                                    Open a new terminal or type the command:</p>
                                        <pre><code>$ source "$HOME/.gvm/bin/gvm-init.sh"</code></pre>
                            <p>Then install the latest stable Groovy:</p>
                                        <pre><code>$ gvm install groovy</code></pre>
                                        <p>After installation is complete and you've made it your default version, test it with:</p>
                            <pre><code>$ groovy -version</code></pre>
                            <p>That's all there is to it!</p>
                            </article>
                                    <hr class="divider" />

                            <a name="buildtools"></a>
                                    <article>
                                        <h1>From your build tools</h1>
                            <p>
                                    If you wish to add Groovy as a dependency in your projects,
                            you can refer to the Groovy JARs in the dependency section of your project build file descriptor:
                            </p>
                                        <table class="table">
                                            <thead>
                                            <tr>
                                                <th>Gradle</th>
                            <th>Maven</th>
                                                <th>Explanation</th>
                            </tr>
                                            </thead>
                            <tbody>
                            <tr>
                            <td><code>org.codehaus.groovy:groovy:x.y.z</code></td>
                            <td>
                            <code>&lt;groupId&gt;org.codehaus.groovy&lt;/groupId&gt; </code><br />
                            <code>&lt;artifactId&gt;groovy&lt;/artifactId&gt; </code><br />
                            <code>&lt;version&gt;x.y.z&lt;/version&gt;</code>
                            </td>
                                                <td>
                                                    Just the core of Groovy without the modules (see below).
                                                    Also includes <em>jarjar'ed</em> versions of Antlr, ASM, and Commons-CLI.
                                    </td>
                                            </tr>
                            <tr>
                            <td><code>org.codehaus.groovy:groovy-$module:x.y.z</code></td>
                            <td>
                            <code>&lt;groupId&gt;org.codehaus.groovy&lt;/groupId&gt; </code><br />
                            <code>&lt;artifactId&gt;groovy-$module&lt;/artifactId&gt; </code><br />
                            <code>&lt;version&gt;x.y.z&lt;/version&gt;</code>
                            </td>
                                                <td>
                                                    <code>"$module"</code> stands for the different optional groovy modules
                            "ant", "bsf", "console", "docgenerator", "groovydoc", "groovysh", "jmx",
                            "json", "jsr223", "servlet", "sql", "swing", "test", "testng" and "xml".
                            Example: <code>&lt;artifactId&gt;groovy-sql&lt;/artifactId&gt;</code>
                            </td>
                                            </tr>
                            <tr>
                            <td><code>org.codehaus.groovy:groovy-all:x.y.z</code></td>
                            <td>
                            <code>&lt;groupId&gt;org.codehaus.groovy&lt;/groupId&gt; </code><br />
                            <code>&lt;artifactId&gt;groovy-all&lt;/artifactId&gt; </code><br />
                            <code>&lt;version&gt;x.y.z&lt;/version&gt;</code>
                            </td>
                                                <td>
                                                    The core plus all the modules.
                                                    Also includes <em>jarjar'ed</em> versions of Antlr, ASM, Commons-CLI runtime.
                            Allows you or your other dependencies (e.g. Hibernate) to use other versions of these jars.
                            Optional dependencies are marked as optional.
                            You may need to include some of the optional dependencies to use some features of Groovy, e.g. AntBuilder, GroovyMBeans, etc.</td>
                                            </tr>
                            </tbody>
                                        </table>
                            </article>
                                    <hr class="divider" />

                            <a name="otherways"></a>
                                    <article>
                                        <h1>Other ways to get Groovy</h1>
                            <p>
                                    If you're on MacOS and have <a href="http://brew.sh/">Homebrew</a> installed, you can install Groovy with:
                            <pre><code>brew install groovy</code></pre>
                            If you're on MacOS and have <a href="http://www.macports.org/">MacPorts</a> installed, you can install Groovy with:
                            <pre><code>sudo port install groovy</code></pre>
                                    If you're on Windows, you can also use the <a href="#">NSIS Windows installer</a>.<br />
                            If you prefer to live on the bleeding edge, you can also grab the <a href="http://github.com/groovy/groovy-core">source code from Git</a>.<br />
                                    If you are an IDE user, you can just grab the latest <a href="#">IDE plugin</a> and follow the plugin installation instructions.
                                        </p>
                            </article>
*/



                        }
                    }
                }
            }
        }