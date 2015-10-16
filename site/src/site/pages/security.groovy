layout 'layouts/main.groovy', true,
        pageTitle: "The Groovy programming language - Security",
        mainContent: contents {

            div(id: 'content', class: 'page-1') {
                div(class: 'row') {
                    div(class: 'row-fluid') {
                        div(class: 'col-lg-3') {
                            ul(class: 'nav-sidebar') {
                                li(class: 'active') {
                                    a(href: '#security', "Security updates")
                                }
                            }
                        }

                        div(class: 'col-lg-8 col-lg-pull-0') {
                            a(name: 'security') {}
                            h1('Security updates')
                            p '''Here you can find information about security patches or updates released for Apache Groovy. Note that unless specified otherwise,
no binary or source patches are available. To obtain a security fix, you need to upgrade to the latest maintained version of Apache Groovy.'''
                            p '''Releases prior to 2.4.4 were not released under Apache so no official patches for security updates are available for older versions.'''
                            ul {
                                li {
                                    h2 "Groovy 2.4.x vulnerabilities"
                                    h3 'Fixed in Groovy 2.4.4'
                                    asciidoc '''
*Important*: http://cve.mitre.org/cgi-bin/cvename.cgi?name=CVE-2015-3253[CVE-2015-3253: Remote execution of untrusted code]

*Description*

When an application has Groovy on the classpath and that it uses standard Java serialization mechanim to communicate between servers, or to store local data, it is possible for an attacker to bake a special serialized object that will execute code directly when deserialized. All applications which rely on serialization and do not isolate the code which deserializes objects are subject to this vulnerability.

*Mitigation*

Apache Groovy 2.4.4 is the first supported release under the Apache Software Foundation. It is strongly recommended that all users using serialization upgrade to this version.
If you cannot upgrade or rely on an older, unsupported version of Groovy, you can apply the following patch on the `MethodClosure` class (`src/main/org/codehaus/groovy/runtime/MethodClosure.java`):

```
 public class MethodClosure extends Closure {
+    private Object readResolve() {
+        throw new UnsupportedOperationException();
+    }
```

Alternatively, you should make sure to use a custom security policy file (using the standard Java security manager) or make sure that you do not rely on serialization to communicate remotely.

*Credit*

This vulnerability was discovered by:

* cpnrodzc7 working with HP's Zero Day Initiative

'''
                                }
                                li {
                                    h2 "Reporting problems"
                                    asciidoc '''
The Apache Software Foundation takes a very active stance in eliminating security problems in its software products.
If you have questions about how to configure or use Groovy securely, you should send them to the users ${$a(href: 'mailing-lists.html', 'mailing list')}.
If you find any security problems due to bugs in Groovy software, you should raise issues in the ${$a(href: 'contribute.html#reporting-issues', 'bug tracker')}.
The Apache Software Foundation has a dedicated http://www.apache.org/security/[security team] which you may contact should the need arise.
'''
                                }
                            }
                        }
                    }
                }
            }
        }