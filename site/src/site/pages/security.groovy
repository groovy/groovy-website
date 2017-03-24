layout 'layouts/main.groovy', true,
        pageTitle: "The Apache Groovy programming language - Security",
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
                                    h3 'CVE-2015-3253 Apache Groovy Information Disclosure'
                                    asciidoc '''
Severity: Important

Vendor: The Apache Software Foundation

Versions Affected:

* Unsupported Codehaus versions of Groovy from 1.7.0 to 2.4.3
* Fixed in version 2.4.4

Impact:

Remote execution of untrusted code, DoS

Description:

When an application has Groovy on the classpath and uses standard Java serialization mechanisms to communicate between servers, or to store local data, it is possible for an attacker to bake a special serialized object that will execute code directly when deserialized. All applications which rely on serialization and do not isolate the code which deserializes objects are subject to this vulnerability.

Mitigation:

Apache Groovy 2.4.4 is the first supported release under the Apache Software Foundation. It is strongly recommended that all users using serialization upgrade to this version.
If you cannot upgrade or rely on an older, unsupported version of Groovy, you can apply the following patch on the `MethodClosure` class (`src/main/org/codehaus/groovy/runtime/MethodClosure.java`):

```
 public class MethodClosure extends Closure {
+    private Object readResolve() {
+        throw new UnsupportedOperationException();
+    }
```

Alternatively, you should make sure to use a custom security policy file (using the standard Java security manager) or make sure that you do not rely on serialization to communicate remotely.

Credit:

This vulnerability was discovered by:

* cpnrodzc7 working with HP's Zero Day Initiative

References:

* http://cve.mitre.org/cgi-bin/cvename.cgi?name=CVE-2015-3253[CVE-2015-3253: Remote execution of untrusted code]
* http://groovy-lang.org/security.html

'''
                                    h3 'CVE-2016-6814 Apache Groovy Information Disclosure'
                                    asciidoc '''
Severity: Important

Vendor: The Apache Software Foundation

Versions Affected:

* Unsupported Codehaus versions of Groovy from 1.7.0 to 2.4.3
* Apache Groovy 2.4.4 to 2.4.7
* Fixed in version 2.4.8

Impact:

Remote execution of untrusted code, DoS

Description:

When an application with Groovy on classpath uses standard
Java serialization mechanisms, e.g. to communicate between servers
or to store local data, it is possible for an attacker to bake a special
serialized object that will execute code directly when deserialized.
All applications which rely on serialization and do not isolate the
code which deserializes objects are subject to this vulnerability.
This is similar to CVE-2015-3253 but this exploit involves extra
wrapping of objects and catching of exceptions which are now safe
guarded against.

Mitigation:

Users of Groovy relying on (de)serialization with the affected versions
should apply one of the following mitigations:

* Isolate the code doing the (de)serialization
* Upgrade to Apache Groovy 2.4.8 or later
* Users of older versions of Groovy can apply the following patch to the
`MethodClosure` class (`src/main/org/codehaus/groovy/runtime/MethodClosure.java`):

```
public class MethodClosure extends Closure {
+    private void readObject(java.io.ObjectInputStream stream) throws
IOException, ClassNotFoundException {
+        if (ALLOW_RESOLVE) {
+            stream.defaultReadObject();
+        }
+        throw new UnsupportedOperationException();
+    }
```

Credit:

This vulnerability was discovered by:

* Sam Thomas of Pentest Limited working with Trend Micro's Zero Day Initiative

History:

* 2016-09-20 Original advisory
* 2017-01-12 Updated information on affected versions

References:

* http://cve.mitre.org/cgi-bin/cvename.cgi?name=CVE-2016-6814[CVE-2016-6814: Remote execution of untrusted code]
* http://groovy-lang.org/security.html

'''
                                }
                                li {
                                    h2 "Reporting problems"
                                    p """The Apache Software Foundation takes a very active stance in eliminating security problems in its software products.
If you have questions about how to configure or use Groovy securely, you should send them to the users ${$a(href: 'mailing-lists.html', 'mailing list')}.
If you find any security problems due to bugs in Groovy software, you should raise issues in the ${$a(href: 'contribute.html#reporting-issues', 'bug tracker')}.
The Apache Software Foundation has a dedicated ${$a(href: 'http://www.apache.org/security/', 'security team')} which you may contact should the need arise.
"""
                                }
                            }
                        }
                    }
                }
            }
        }
