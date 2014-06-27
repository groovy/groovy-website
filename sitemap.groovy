menu {
    group('Groovy') {
        item 'Learn',                       'learn.html'
        item 'Download',                    'download.html'
        item 'Community',                   'community.html'
        item 'Ecosystem',                   'ecosystem.html'
    }
    group('About') {
        item 'Contributing',                'contribute.html'
        item 'Source code',                 'https://github.com/groovy/groovy-core'
        item 'FAQ',                         'faq.html'
    }
    group('Socialize') {
        item 'Mailling list',               'mailing-lists.html',                               'fa-envelope'
        item 'Groovy Weekly newsletter',    'http://bit.ly/groovy-weekly-subscribe',            'fa-envelope-o'
        item 'GitHub',                      'https://github.com/groovy/groovy-core',            'fa-github'
        item 'Jira',                        'http://jira.codehaus.org/browse/GROOVY',           'fa-tasks'
        item 'Google+ Groovy Page',         'https://google.com/+groovy',                       'fa-google-plus'
        item 'Google+ Groovy Community',    'http://bit.ly/g-community',                        'fa-google-plus'
        item 'Stack overflow',              'http://stackoverflow.com/questions/tagged/groovy', 'fa-stack-overflow'
    }
}

documentation {
    section('Getting started','fa-graduation-cap') {
        item 'Download Groovy',                             'download',         'download'
        item 'Install Groovy',                              'install',          'install'
        item 'Differences with Java',                       'differences',      'core-differences-java'
        item 'The Groovy Development Kit',                  'gdk',              'core-gdk'
        item 'Runtime and compile-time metaprogramming',    'metaprogramming',  'core-metaprogramming'
        item 'The Grape dependency manager',                'grapes',           'core-grapes'
        item 'Testing guide',                               'testing',          'core-testing-guide'
        item 'Domain-Specific Languages',                   'dsls',             'core-domain-specific-languages'
        item 'Security',                                    'security',         'security'
        item 'Design patterns in Groovy',                   'design-patterns',  'design-pattern-in-groovy'
    }

    section('Groovy module guides', 'fa-cubes') {
        item 'Parsing and producing JSON',          'json',             'json-userguide'
        item 'Working with a relational database',  'databases',        'databases'
        item 'Processing XML',                      'processing-xml',   'processing-xml'
        item 'Scripting Ant tasks',                 'scripting-ant',    'scripting-ant'
        item 'Template engines',                    'templating',       'template-engines'
        item 'Creating Swing UIs',                  'swing',            'swing'
        item 'Servlet support',                     'servlet',          'servlet'
        item 'Working with JMX',                    'jmx',              'jmx'
    }

    section ('Tools','fa-gears') {
        item 'groovyc — the Groovy compiler',               'groovyc',          'tools-groovyc'
        item 'groovysh — the Groovy command -like shell',   'groovysh',         'tools-groovysh'
        item 'groovyConsole — the Groovy Swing console',    'groovyconsole',    'tools-groovyconsole'
        item 'IDE integration', 'ide', 'tools-ide'
    }

    section ('Language Specification', 'fa-graduation-cap') {
        item 'Syntax',              'syntax',               'core-syntax'
        item 'Operators',           'operators',            'core-operators'
        item 'Program structure',   'structure',            'core-program-structure'
        item 'Object orientation',  'objectorientation',    'core-object-orientation'
        item 'Closures',            'closures',             'core-closures'
        item 'Semantics',           'semantics',            'core-semantics'
    }

    section ('API documentation', 'fa-code') {
        item 'GroovyDoc documentation of the Groovy APIs',  'api',    'api'
        item 'The Groovy Development Kit enhancements',     'gdk',    'gdk'
    }
}

downloads {
    distribution('Groovy 2.4') {
        description {
            yield 'Groovy 2.4 is currently in beta testing. If you want a stable version, please choose Groovy 2.3 which is our latest official '
            a(href: 'versioning.html', 'version')
            yield ' of Groovy.'
        }

        version('2.4.0-beta-1') {
            releaseNotes 'https://jira.codehaus.org/secure/ReleaseNote.jspa?projectId=10242&version=20369'
        }
    }
    distribution('Groovy 2.3') {
        description {
            yield 'Groovy 2.3 is our latest official '
            a(href: 'versioning.html', 'version')
            yield ' of Groovy.'
        }

        version('2.3.3') {
            releaseNotes 'https://jira.codehaus.org/secure/ReleaseNote.jspa?projectId=10242&version=20415'
            windowsInstaller 'http://dist.codehaus.org/groovy/distributions/installers/windows/nsis/groovy-2.3.3-installer.exe'
        }
    }
}

ecosystem {
    entry('Grails') {
        description 'Grails is an Open Source, full stack, web application framework for the JVM. It takes advantage of the Groovy programming language and convention over configuration to provide a productive and stream-lined development experience.'
        url 'http://grails.org/'
        logo ''
    }
    entry('Gradle') {
        description 'Gradle is build automation evolved. Gradle can automate the building, testing, publishing, deployment and more of software packages or other types of projects such as generated static websites, generated documentation or indeed anything else.'
        url 'http://gradle.org'
        logo ''
    }
    entry('Spock') {
        description 'Spock is a testing and specification framework for Java and Groovy applications. What makes it stand out from the crowd is its beautiful and highly expressive specification language. Thanks to its JUnit runner, Spock is compatible with most IDEs, build tools, and continuous integration servers.'
        url 'https://code.google.com/p/spock/'
        logo ''
    }
    entry('GPars') {
        description 'The GPars framework offers Java developers intuitive and safe ways to handle Java or Groovy tasks concurrently. Leveraging the enormous flexibility of the Groovy programing language and building on proven Java technologies, we aim to make concurrent programming for multi-core hardware intuitive, robust and enjoyable.'
        url 'http://gpars.codehaus.org/'
    }
    entry('Ratpack') {
        description 'Ratpack is a simple, capable, toolkit for creating high performance web applications.'
        url 'http://www.ratpack.io/'
    }
    entry('Griffon') {
        description 'Griffon is an application framework for developing desktop applications in the JVM, with Groovy being the primary language of choice. Inspired by Grails, Griffon follows the Convention over Configuration paradigm, paired with an intuitive MVC architecture and a command line interface.'
        url 'http://griffon.codehaus.org/'
    }
    entry('GVM') {
        description 'GVM is a tool for managing parallel Versions of multiple Software Development Kits on most Unix based systems. It provides a convenient command line interface for installing, switching, removing and listing Candidates.'
        url 'http://gvmtool.net/'
    }
}