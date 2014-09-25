menu {
    group('Groovy') {
        item 'Learn',                       'learn.html'
        item 'Documentation',               'documentation.html'
        item 'Download',                    'download.html'
        item 'Community',                   'community.html'
        item 'Ecosystem',                   'ecosystem.html'
    }

    group('About') {
        item 'Contributing',                'contribute.html'
        item 'Source code',                 'https://github.com/groovy/groovy-core'
        item 'Build status',                'buildstatus.html'
        item 'Books',                       'learn.html#books'
        item 'Sponsors',                    'sponsors.html'
        item 'FAQ',                         'faq.html'
        item 'Search',                      'search.html'
    }

    group('Socialize') {
        item 'Discuss on the mailing-list', 'mailing-lists.html',                               'fa-envelope'
        item 'Groovy Weekly newsletter',    'groovy-weekly.html',                               'fa-envelope-o'
        item 'Groovy on Twitter',           'https://twitter.com/hashtag/groovylang',           'fa-twitter'
        item 'Events and conferences',      'events.html',                                      'fa-calendar'
        item 'Source code on GitHub',       'https://github.com/groovy/groovy-core',            'fa-github'
        item 'Report issues in Jira',       'contribute.html#reporting-issues',                 'fa-bug'
        item 'Google+ Groovy Page',         'https://google.com/+groovy',                       'fa-google-plus'
        item 'Google+ Groovy Community',    'http://bit.ly/g-community',                        'fa-google-plus'
        item 'Stack Overflow questions',    'http://stackoverflow.com/questions/tagged/groovy', 'fa-stack-overflow'
    }
}

pages {
    page 'index', 'index', [allEvents: allEvents]
    page 'search', 'search', [category: 'Search']
    page 'ecosystem', 'ecosystem', [category: 'Ecosystem', ecosys: ecosystem]
    page 'learn', 'learn', [category: 'Learn', docSections: documentationSections, allBooks: library, videos: videos]
    page 'documentation', 'documentation', [category: 'Documentation', docSections: documentationSections, allDocVersions: allDocVersions]
    page 'download', 'download', [category: 'Download', distributions: distributions]
    page 'versioning', 'versioning', [category: 'Download']
    page 'indy', 'indy', [category: 'Download']
    page 'community', 'community', [category: 'Community']
    page 'usergroups', 'usergroups', [category: 'Community', userGroups: usergroups]
    page 'groovy-weekly', 'groovy-weekly', [category: 'Community']
    page 'mailing-lists', 'mailing-lists', [category: 'Community']
    page 'contribute', 'contribute', [category: 'Community']
    page 'hipchat', 'hipchat', [category: 'Community']
    page 'sponsors', 'sponsors', [category: 'Community']
    page 'buildstatus', 'buildstatus', [category: 'Community']
    page 'faq', 'faq', [category: 'Documentation', docSections: documentationSections]
    page 'events', 'events', [category: 'Community', allEvents: allEvents]
    page 'api', 'api', [category: 'Learn', iframeTarget: 'http://docs.groovy-lang.org/docs/next/html/gapi']
    page 'gdk', 'gdk', [category: 'Learn', iframeTarget: 'http://docs.groovy-lang.org/docs/next/html/groovy-jdk']
    page 'singlepagedocumentation', 'single-page-documentation', [category: 'Learn', iframeTarget: 'http://docs.groovy-lang.org/docs/next/html/documentation/']
}

documentation {
    groovyDocumentationVersions([
            '1.7.0', '1.7.1', '1.7.2', '1.7.3', '1.7.4', '1.7.5', '1.7.6', '1.7.7', '1.7.8', '1.7.9', '1.7.10', '1.7.11',
            '1.8.0', '1.8.1', '1.8.2', '1.8.3', '1.8.4', '1.8.5', '1.8.6', '1.8.7', '1.8.8', '1.8.9',
            '2.0.0', '2.0.1', '2.0.2', '2.0.3', '2.0.4', '2.0.5', '2.0.6', '2.0.7', '2.0.8',
            '2.1.0', '2.1.1', '2.1.2', '2.1.3', '2.1.4', '2.1.5', '2.1.6', '2.1.7', '2.1.8', '2.1.9',
            '2.2.0', '2.2.1', '2.2.2',
            '2.3.0', '2.3.1', '2.3.2', '2.3.3', '2.3.4','2.3.5','2.3.6','2.3.7'])

    section('Getting started','fa-graduation-cap') {
        //          NAME                                     TARGET HTML         DOCPAGE HTML                       GENERATE
        item 'Download Groovy',                             'download',         'download',                         false
        item 'Install Groovy',                              'install',          'core-getting-started'
        item 'Differences with Java',                       'differences',      'core-differences-java'
        item 'The Groovy Development Kit',                  'groovy-dev-kit',   'core-gdk'
        item 'Runtime and compile-time metaprogramming',    'metaprogramming',  'core-metaprogramming'
        item 'The Grape dependency manager',                'grape',            'grape'
        item 'Testing guide',                               'testing',          'core-testing-guide'
        item 'Domain-Specific Languages',                   'dsls',             'core-domain-specific-languages'
        item 'Security',                                    'security',         'security'
        item 'Design patterns in Groovy',                   'design-patterns',  'design-pattern-in-groovy'
    }

    section ('Language Specification', 'fa-graduation-cap') {
        item 'Syntax',              'syntax',               'core-syntax'
        item 'Operators',           'operators',            'core-operators'
        item 'Program structure',   'structure',            'core-program-structure'
        item 'Object orientation',  'objectorientation',    'core-object-orientation'
        item 'Closures',            'closures',             'core-closures'
        item 'Semantics',           'semantics',            'core-semantics'
    }

    section ('Tools','fa-gears') {
        item 'groovyc — the Groovy compiler',               'groovyc',          'tools-groovyc'
        item 'groovysh — the Groovy command -like shell',   'groovysh',         'tools-groovysh'
        item 'groovyConsole — the Groovy Swing console',    'groovyconsole',    'tools-groovyconsole'
        item 'IDE integration', 'ides', 'tools-ide'
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

        version('2.4.0-beta-3') {
            releaseNotes 'https://jira.codehaus.org/secure/ReleaseNote.jspa?projectId=10242&version=20544'
        }
    }
    distribution('Groovy 2.3') {
        description {
            yield 'Groovy 2.3 is our latest official '
            a(href: 'versioning.html', 'version')
            yield ' of Groovy.'
        }

        version('2.3.7') {
            stable true
            releaseNotes 'http://jira.codehaus.org/secure/ReleaseNote.jspa?projectId=10242&version=20543'
            // windowsInstaller 'http://dl.bintray.com/groovy/Distributions/groovy-2.3.7-installer.exe'
        }
    }
}

ecosystem {
    project('Grails') {
        description 'Grails is an Open Source, full stack, web application framework for the JVM. It takes advantage of the Groovy programming language and convention over configuration to provide a productive and stream-lined development experience.'
        url 'http://grails.org/'
        logo 'img/ecosystem/grails.png'
    }

    project('Gradle') {
        description 'Gradle is build automation evolved. Gradle can automate the building, testing, publishing, deployment and more of software packages or other types of projects such as generated static websites, generated documentation or indeed anything else.'
        url 'http://gradle.org'
        logo 'img/ecosystem/gradle.gif'
    }

    project('Spock') {
        description 'Spock is a testing and specification framework for Java and Groovy applications. What makes it stand out from the crowd is its beautiful and highly expressive specification language. Thanks to its JUnit runner, Spock is compatible with most IDEs, build tools, and continuous integration servers.'
        url 'https://code.google.com/p/spock/'
        logo ''
    }

    project('GPars') {
        description 'The GPars framework offers Java developers intuitive and safe ways to handle Java or Groovy tasks concurrently. Leveraging the enormous flexibility of the Groovy programing language and building on proven Java technologies, we aim to make concurrent programming for multi-core hardware intuitive, robust and enjoyable.'
        url 'http://gpars.codehaus.org/'
        logo 'img/ecosystem/gpars.png'
    }

    project('Ratpack') {
        description 'Ratpack is a simple, capable, toolkit for creating high performance web applications.'
        url 'http://www.ratpack.io/'
        logo 'img/ecosystem/ratpack.png'
    }

    project('Griffon') {
        description 'Griffon is an application framework for developing desktop applications in the JVM, with Groovy being the primary language of choice. Inspired by Grails, Griffon follows the Convention over Configuration paradigm, paired with an intuitive MVC architecture and a command line interface.'
        url 'http://griffon.codehaus.org/'
        logo 'img/ecosystem/griffon.png'
    }

    project('GVM') {
        description 'GVM is a tool for managing parallel Versions of multiple Software Development Kits on most Unix based systems. It provides a convenient command line interface for installing, switching, removing and listing Candidates.'
        url 'http://gvmtool.net/'
        logo 'img/ecosystem/gvmtool.png'
    }
}

allEvents {
    event('GR8Conf US 2014') {
        location 'Minneapolis, MN, USA'
        date 'July 28-29, 2014'
        url 'http://gr8conf.us/'
        logo 'img/confs/gr8confus2014.png'
        description '''
            <p>
            Groovy, Grails and the related technologies have seen astounding growth in interest and adoption the past
            few years, and with good reason. To spread the word even more we have created GR8Conf.
            </p>
            <p>
            GR8Conf is an independent, affordable series of conferences.
            It's dedicated to the technologies in the Groovy ecosystem.
            </p>
        '''
    }
    event('SpringOne 2GX 2014') {
        location 'Dallas, TX, USA'
        date 'September 8-11, 2014'
        url 'http://springone2gx.com/'
        logo 'img/confs/s2gx2014.png'
        description '''
            <p>
            Pivotal and No Fluff Just Stuff bring you SpringOne 2GX 2014, a one-of-a-kind conference for application
            developers, solution architects, web operations and IT teams who develop business applications, create
            multi-device aware web applications, design cloud architectures, and manage high performance infrastructure.
            The sessions are specifically tailored for developers using the hugely popular open source Spring IO projects,
            Groovy & Grails, Cloud Foundry, Hadoop and Tomcat technologies. Whether you're building and running
            mission-critical business applications, designing the next killer cloud or big data application,
            SpringOne 2GX will keep you up to date with the latest enterprise open source technology.
            </p>
        '''
    }
    event('Groovy Grails eXchange 2014') {
        location 'London, United Kingdom'
        date 'December 11-12, 2014'
        url 'https://skillsmatter.com/conferences/1957-groovy-grails-exchange-2014'
        logo 'img/confs/ggex2014.png'
        description '''
            <p>
            Do you love Groovy & Grails? Would you like to spend 2 days with 150+ Groovy & Grails developers, learning
            and sharing skills with the world's leading experts on Groovy, Grails and modern enterprise development?
            </p>
            <p>
            Then why not come to the 8th annual Groovy & Grails eXchange and be part of this passionate community of
            creators, founders, developers and enthusiasts.
            </p>
        '''
    }
        event('GR8Conf EU 2015') {
        location 'Copenhagen, Denmark'
        date 'June 2-4, 2015'
        url 'http://gr8conf.eu/'
        logo 'img/confs/gr8confeu2015.png'
        description '''
            <p>
            Groovy, Grails and the related technologies have seen astounding growth in interest and adoption the past
            few years, and with good reason. To spread the word even more we have created GR8Conf.
            </p>
            <p>
            GR8Conf is an independent, affordable series of conferences.
            It's dedicated to the technologies in the Groovy ecosystem.
            </p>
        '''
    }
}

books {
    book('Groovy in Action, 2nd edition') {
        authors "Dierk König, Guillaume Laforge, Paul King, Cédric Champeau, Hamlet D'Arcy, Erik Pragt, and Jon Skeet"
        cover 'img/books/regina.png'
        url 'http://www.manning.com/koenig2/'
        description 'The undisputed definitive reference on the Groovy programming language, authored by core members of the development team.'
    }

    book('Making Java Groovy') {
        authors 'Ken Kousen'
        cover 'img/books/Kousen-MJG.png'
        url 'http://www.manning.com/kousen/'
        description 'Make Java development easier by adding Groovy. Each chapter focuses on a task Java developers do, like building, testing, or working with databases or restful web services, and shows ways Groovy can help.'
    }

    book('Programming Groovy 2') {
        authors 'Venkat Subramaniam'
        cover 'img/books/vslg2.jpg'
        url 'http://pragprog.com/book/vslg2/programming-groovy-2'
        description 'Dynamic productivity for the Java developer'
    }

    book('Groovy 2 Cookbook') {
        authors 'Andrey Adamovitch, Luciano Fiandeso'
        cover 'img/books/g2cook.jpg'
        url 'http://www.packtpub.com/groovy-2-cookbook/book'
        description 'Over 90 recipes that provide solutions to everyday programming challenges using the powerful features of Groovy 2'
    }

    book('Groovy for Domain-Specific Languages') {
        authors 'Fergal Dearle'
        cover 'img/books/gdsl.jpg'
        url 'http://www.packtpub.com/groovy-for-domain-specific-languages-dsl/book'
        description 'Enhance and extend your Java applications with Domain-Specific Languages in Groovy'
    }

    book('Groovy Goodness Notebook') {
        authors 'Hubert A. Klein Ikkink'
        cover 'img/books/ggood.jpg'
        url 'https://leanpub.com/groovy-goodness-notebook'
        description 'Experience the Groovy programming language through code snippets. Learn more about (hidden) Groovy features with code snippets and short articles. The articles and code will get you started quickly and will give more insight in Groovy.'
    }
}

usergroups {
    // Europe
    userGroup('Belgium Groovy/Grails User Group') {
        location 'Europe/Belgium'
        url 'http://www.meetup.com/Belgium-Groovy-Grails-User-Group/'
    }
    userGroup('Aarhus Groovy & Grails meetup - no homepage yet') {
        location 'Europe/Denmark'
    }
    userGroup('Paris Groovy Grails User Group') {
        location 'Europe/France'
        url 'http://www.meetup.com/Belgium-Groovy-Grails-User-Group/'
    }
    userGroup('Groovy & Grails Israel User Group') {
        location 'Europe/Israel'
        url 'http://www.meetup.com/Groovy-Grails-Israel-Meetup-Group/'
    }
    userGroup('Warsaw Groovy User Group') {
        location 'Europe/Poland'
        url 'http://www.meetup.com/Warsaw-Groovy-User-Group/'
    }
    userGroup('Madrid Groovy User Group') {
        location 'Europe/Spain'
        url 'http://www.meetup.com/madrid-gug/'
    }
    userGroup('Dutch Groovy and Grails User Group (NLGUG)') {
    	location 'Europe/The Netherlands'
    	url 'http://www.meetup.com/nl-gug/'
    }

    // North-America
    userGroup('Groovy Users of Minnesota') {
        location 'North-America/United States'
        url 'http://groovy.mn'
    }
    userGroup('Austin Groovy and Grails User Group (TX)') {
        location 'North-America/United States'
        url 'http://www.meetup.com/Austin-Groovy-and-Grails-Users/'
    }
    userGroup('Groovy and Grails Users of Columbus OH') {
        location 'North-America/United States'
        url 'http://www.meetup.com/Grails-and-Ales/'
    }
    userGroup('NYC Groovy / Grails Meetup') {
        location 'North-America/United States'
        url 'http://www.meetup.com/grails/'
    }
    userGroup('Scottsdale Groovy Brigade') {
        location 'North-America/United States'
        url 'http://www.scottsdale-groovy.com/'
    }
    userGroup('Coder Consortium of Sacramento') {
        location 'North-America/United States'
        url 'http://coderconsortium.com/'
    }
    userGroup('DC Groovy') {
        location 'North-America/United States'
        url 'http://www.dcgroovy.org'
    }

    // South-America
    userGroup('Grails Brasil - Groovy and Grails users group of Brazil') {
        location 'South-America/Brazil'
        url 'http://www.grailsbrasil.com.br'
    }

    // Asia
    userGroup('Bangalore Groovy Grails Meetup') {
        location 'Asia/India'
        url 'http://www.meetup.com/Bangalore-Groovy-Grails-Meetup/'
    }
    userGroup('Japan Grails/Groovy User Group') {
        location 'Asia/Japan'
        url 'http://www.jggug.org/'
    }

    // Oceania?
    /* userGroup('') { location 'Oceania/Australia' } */
}

videos {
    video('Groovy in 2014 and beyond') {
        speaker 'Guillaume Laforge'
        summary '''
            <p>Groovy is already 10 years old, but continues to evolve and innovate.</p>
            <p>What's new under the hood? - implicit closure coercion - new AST transforms - finer grained script configuration - type checker extensions</p>
            <p>In the upcoming versions of Groovy, you'll be able to create "traits", do tail recursions, and much more.</p>
            <p>We'll also talk about what's cooking for Groovy 3.0, with its new Meta-Object Protocol, its new grammar, its JDK 8 support.</p>
        '''
        pictureUrl 'groovy-in-2014-and-beyond.png'
        videoUrl 'https://www.youtube.com/watch?v=P63OHYc3q8s&list=PLwxhnQ2Qv3xuE4JEKBpyE2AbbM_7G0EN1&index=2'
        slidesUrl 'https://speakerdeck.com/glaforge/groovy-in-2014-and-beyond-at-gr8conf-europe-2014'
    }

    video('The Groovy ecosystem revisited') {
        speaker 'Andrés Almiray'
        summary '''
            <p>Groovy is a well established player in the JVM since a few years ago.
            It's increased popularity across the years has spawned several projects that conform the Groovy Ecosystem.
            You've probably heard of Grails, Gradle, Griffon and Spock.
            But what about the rest of projects that are just waiting around the corner to be discovered and make your life easier?
            This talk presents them tools and libraries that use Groovy as the main driving force to get the job done.</p>
        '''
        pictureUrl 'groovy-ecosystem-revisited.png'
        videoUrl 'https://www.youtube.com/watch?v=2NGeaIwmnC8&list=PLwxhnQ2Qv3xuE4JEKBpyE2AbbM_7G0EN1&index=5'
        slidesUrl 'http://fr.slideshare.net/aalmiray/gr8conf-groovy-ecosystem'
    }

    video('Metaprogramming with the Groovy runtime') {
        speaker 'Jeff Brown'
        summary '''
            <p>The dynamic runtime nature of Groovy is one of the things that sets it apart from standard Java and makes it a fantastic language for building dynamic applications for the Java Platform.
            The metaprogramming capabilities offered by the language provide everything that an application development team needs to build systems that are far more capable than their all Java counterparts.
            This Part 1 of 2 will cover the runtime metaprogramming capabilities of Groovy. The session will dive deep into Groovy's Meta Object Protocol (MOP) which implements the incredibly dynamic runtime dispatch mechanism.
            The session will include a lot of live code demonstrating really powerful runtime features of the language.
            This session is focused specifically on Groovy's runtime metaprogramming capabilities.
            Part 2 of 2 will cover Groovy's compile time metaprogramming capabilities</p>
        '''
        pictureUrl 'metaprogramming-part-1.png'
        videoUrl 'https://www.youtube.com/watch?v=1xvg8Wcj-hg&list=PLwxhnQ2Qv3xuE4JEKBpyE2AbbM_7G0EN1&index=9'
    }

    video('Groovy Puzzlers') {
        speaker 'Noam Tenne'
        summary '''
            <p>Remember the epic Java Puzzlers? Here's the Groovy version, and we have some neat ones!
            Even though we are totally a Grails shop here at JFrog, some of these had us scratching our heads for days trying to figure them out.
            And there is more!
            Contributions from the truly Groovy senseis, including Guillaume Laforge, Andrés Almiray, Tim Yates, Ken Kousen
            make this talk an unforgettable journey to Groovy.
            In this talk, you'll have the expected dose of fun and enlightenment hearing about our mistakes and failures, great and small,
            in hard core Groovy/Grails development.</p>
        '''
        pictureUrl 'groovy-puzzlers.png'
        videoUrl 'https://www.youtube.com/watch?v=GfIhxi7L6R0&list=PLwxhnQ2Qv3xuE4JEKBpyE2AbbM_7G0EN1&index=17'
    }
}
