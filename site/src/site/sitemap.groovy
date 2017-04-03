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
        item 'Source code',                 'https://github.com/apache/groovy'
        item 'Build status',                'buildstatus.html'
        item 'Security',                    'security.html'
        item 'Books',                       'learn.html#books'
        item 'Thanks',                      'thanks.html'
        item 'Sponsorship',                 'http://www.apache.org/foundation/sponsorship.html'
        item 'FAQ',                         'faq.html'
        item 'Search',                      'search.html'
    }

    group('Socialize') {
        item 'Discuss on the mailing-list', 'mailing-lists.html',                               'fa-envelope'
        item 'Groovy newsletter',           'groovy-weekly.html',                               'fa-envelope-o'
        item 'Groovy on Twitter',           'https://twitter.com/ApacheGroovy',                 'fa-twitter'
        item 'Events and conferences',      'events.html',                                      'fa-calendar'
        item 'Source code on GitHub',       'https://github.com/apache/groovy',                 'fa-github'
        item 'Report issues in Jira',       'contribute.html#reporting-issues',                 'fa-bug'
        item 'Google+ Groovy Page',         'https://google.com/+groovy',                       'fa-google-plus'
        item 'Google+ Groovy Community',    'http://bit.ly/g-community',                        'fa-google-plus'
        item 'Stack Overflow questions',    'http://stackoverflow.com/questions/tagged/groovy', 'fa-stack-overflow'
	item 'Slack Community',             'http://groovycommunity.com/',                      'fa-slack'
    }
}

pages {
    page 'index', 'index', [allEvents: allEvents]
    page 'search', 'search', [category: 'Search']
    page 'ecosystem', 'ecosystem', [category: 'Ecosystem', ecosys: ecosystem]
    page 'learn', 'learn', [category: 'Learn', docSections: documentationSections, allBooks: library, videos: videos, courses: courses]
    page 'documentation', 'documentation', [category: 'Documentation', docSections: documentationSections, allDocVersions: allDocVersions]
    page 'download', 'download', [category: 'Download', distributions: distributions]
    page 'versioning', 'versioning', [category: 'Download']
    page 'indy', 'indy', [category: 'Download']
    page 'security', 'security', [category: 'Learn']
    page 'community', 'community', [category: 'Community']
    page 'usergroups', 'usergroups', [category: 'Community', userGroups: usergroups]
    page 'groovy-weekly', 'groovy-weekly', [category: 'Community']
    page 'mailing-lists', 'mailing-lists', [category: 'Community']
    page 'contribute', 'contribute', [category: 'Community']
    page 'thanks', 'thanks', [category: 'Community']
    page 'buildstatus', 'buildstatus', [category: 'Community']
    page 'faq', 'faq', [category: 'Documentation', docSections: documentationSections]
    page 'events', 'events', [category: 'Community', allEvents: allEvents]
    page 'api', 'api', [category: 'Learn', iframeTarget: "${DOCS_BASEURL}/html/gapi"]
    page 'gdk', 'gdk', [category: 'Learn', iframeTarget: "${DOCS_BASEURL}/html/groovy-jdk"]
    page 'singlepagedocumentation', 'single-page-documentation', [category: 'Learn', iframeTarget: "${DOCS_BASEURL}/html/documentation/"]
    page 'changelogs', 'changelogs', [:]
    page '404','404', [:]
}

documentation {
    groovyDocumentationVersions([
            '1.7.0', '1.7.1', '1.7.2', '1.7.3', '1.7.4', '1.7.5', '1.7.6', '1.7.7', '1.7.8', '1.7.9', '1.7.10', '1.7.11',
            '1.8.0', '1.8.1', '1.8.2', '1.8.3', '1.8.4', '1.8.5', '1.8.6', '1.8.7', '1.8.8', '1.8.9',
            '2.0.0', '2.0.1', '2.0.2', '2.0.3', '2.0.4', '2.0.5', '2.0.6', '2.0.7', '2.0.8',
            '2.1.0', '2.1.1', '2.1.2', '2.1.3', '2.1.4', '2.1.5', '2.1.6', '2.1.7', '2.1.8', '2.1.9',
            '2.2.0', '2.2.1', '2.2.2',
            '2.3.0', '2.3.1', '2.3.2', '2.3.3', '2.3.4', '2.3.5', '2.3.6', '2.3.7', '2.3.8', '2.3.9', '2.3.10', '2.3.11',
            '2.4.0', '2.4.1', '2.4.2', '2.4.3', '2.4.4', '2.4.5', '2.4.6', '2.4.7', '2.4.8', '2.4.9', '2.4.10',
            '2.5.0-alpha-1'
    ])

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
        item 'Integrating Groovy into applications',        'integrating',      'guide-integrating'
        item 'Security',                                    'security',         'security'
        item 'Design patterns in Groovy',                   'design-patterns',  'design-pattern-in-groovy'
        item 'Style guide',                                 'style-guide',      'style-guide'
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
        item 'groovysh — the Groovy command -like shell',   'groovysh',         'groovysh'
        item 'groovyConsole — the Groovy Swing console',    'groovyconsole',    'groovy-console'
        item 'IDE integration', 'ides', 'tools-ide'
    }

    section('Groovy module guides', 'fa-cubes') {
        item 'Parsing and producing JSON',          'json',             'json-userguide'
        item 'Working with a relational database',  'databases',        'sql-userguide'
        item 'Processing XML',                      'processing-xml',   'xml-userguide'
        item 'Scripting Ant tasks',                 'scripting-ant',    'ant-builder'
        item 'Template engines',                    'templating',       'template-engines'
        item 'Creating Swing UIs',                  'swing',            'swing-builder'
        item 'Servlet support',                     'servlet',          'servlet-userguide'
        item 'Working with JMX',                    'jmx',              'jmx'
    }

    section ('API documentation', 'fa-code') {
        item 'GroovyDoc documentation of the Groovy APIs',  'api',    'api'
        item 'The Groovy Development Kit enhancements',     'gdk',    'gdk'
    }
}

downloads {
    distribution('Groovy 2.5') {
        description {
            yield 'Groovy 2.5 is the upcoming '
            a(href: 'versioning.html', 'version')
            yield ' of Groovy. Pre-release versions are available:'
        }
        version('2.5.0-alpha-1') {
            stable false
        }
    }
    distribution('Groovy 2.4') {
        description {
            yield 'Groovy 2.4 is the latest stable '
            a(href: 'versioning.html', 'version')
            yield ' of Groovy.'
            yieldUnescaped ''' Important: Releases before 2.4.4 weren't done under the Apache Software Foundation and are provided as a convenience, without any warranty.'''
        }
        version('2.4.10') {
            stable true
            windowsInstaller 'https://dl.bintray.com/groovy/Distributions/groovy-2.4.10-installer.exe'
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
        logo 'img/ecosystem/gradle.png'
    }

    project('Spock') {
        description 'Spock is a testing and specification framework for Java and Groovy applications. What makes it stand out from the crowd is its beautiful and highly expressive specification language. Thanks to its JUnit runner, Spock is compatible with most IDEs, build tools, and continuous integration servers.'
        url 'http://spockframework.org/'
        logo ''
    }

    project('GPars') {
        description 'The GPars framework offers Java developers intuitive and safe ways to handle Java or Groovy tasks concurrently. Leveraging the enormous flexibility of the Groovy programming language and building on proven Java technologies, we aim to make concurrent programming for multi-core hardware intuitive, robust and enjoyable.'
        url 'http://www.gpars.org/'
        logo 'img/ecosystem/gpars.png'
    }

    project('Ratpack') {
        description 'Ratpack is a simple, capable, toolkit for creating high performance web applications.'
        url 'http://www.ratpack.io/'
        logo 'img/ecosystem/ratpack.png'
    }

    project('Griffon') {
        description 'Griffon is an application framework for developing desktop applications in the JVM, with Groovy being the primary language of choice. Inspired by Grails, Griffon follows the Convention over Configuration paradigm, paired with an intuitive MVC architecture and a command line interface.'
        url 'http://griffon-framework.org/'
        logo 'img/ecosystem/griffon.png'
    }

    project('Geb') {
        description 'Geb is a powerful browser functional testing framework that lets you quickly and easily write functional tests in Groovy. It brings together the power of WebDriver, the elegance of jQuery content selection, the robustness of Page Object modelling and the expressiveness of the Groovy language.'
        url 'http://www.gebish.org/'
        logo 'img/ecosystem/geb.png'
    }

    project('SDKMAN!') {
        description 'SDKMAN! is a tool for managing parallel versions of multiple Software Development Kits on most Unix based systems. It provides a convenient command line interface for installing, switching, removing and listing Candidates.'
        url 'http://sdkman.io/'
        logo 'img/ecosystem/sdkman.png'
    }
}

allEvents {
    // Note that the event image should be 257x180 to look nice
    event('Greach 2017') {
        location 'Madrid, Spain'
        date 'March 31 - April 1, 2017'
        url 'http://greachconf.com/'
        logo 'img/confs/greach2017.png'
        description '''
            <p>
            Greach, the Spanish gathering of enthusiasts of Groovy, Grails, Griffon, Gradle, Spock, Vert.x, Gaelyk,
            and many more. With inspirational talks from the makers and users of these projects, hands-on workshops with the rock stars,
            join the 150+ attendees, designers, students, designers, the best professionals together in a great atmosphere.
            </p>
        '''
    }
    event('GR8Conf EU 2017') {
        location 'Copenhagen, Denmark'
        date 'May 31 - June 2, 2017'
        url 'http://gr8conf.eu/'
        logo 'img/confs/gr8confeu.png'
        description '''
            <p>
            Groovy, Grails and the related technologies have seen astounding growth in interest and adoption the past
            few years, and with good reason. To spread the word even more we have created GR8Conf.
            </p>
            <p>
            The 2017 Edition of GR8Conf Europe will feature a DevOps day. Focus will be on technologies to support your
            everyday DevOps needs.
            </p>
            <p>
            GR8Conf is an independent, affordable series of conferences.
            It's dedicated to the technologies in the Groovy ecosystem.
            </p>
        '''
    }
    event('GR8Conf US 2017') {
        location 'Minneapolis, MN, United States of America'
        date 'July 26 - 28, 2017'
        url 'http://gr8conf.us/'
        logo 'img/confs/gr8confus.png'
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
    event('GR8Conf India 2018') {
        location 'New Delhi, India'
        date 'January, 2018'
        url 'http://gr8conf.in/'
        logo 'img/confs/gr8confin.png'
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
    book('Groovy in Action, Second Edition') {
        authors "Dierk König, Paul King, Guillaume Laforge, Hamlet D'Arcy, Cédric Champeau, Erik Pragt, and Jon Skeet"
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

    book('Groovy for Domain-Specific Languages - Second Edition') {
        authors 'Fergal Dearle'
        cover 'img/books/gdsl.jpg'
        url 'https://www.packtpub.com/application-development/groovy-domain-specific-languages-second-edition'
        description 'Extend and enhance your Java applications with domain-specific scripting in Groovy'
    }

    book('Groovy Goodness Notebook') {
        authors 'Hubert A. Klein Ikkink'
        cover 'img/books/ggood.jpg'
        url 'https://leanpub.com/groovy-goodness-notebook'
        description 'Experience the Groovy programming language through code snippets. Learn more about (hidden) Groovy features with code snippets and short articles. The articles and code will get you started quickly and will give more insight in Groovy.'
    }

    book("Grails 3: A Practical Guide to Application Development") {
        authors "Eric Helgeson"
        cover 'img/books/pratical-grails-3-book-cover.png'
        url 'https://www.grails3book.com/'
        description "The first book dedicated to Grails 3. You will learn the concepts behind building Grails applications. Real, up-to-date code examples are provided so you can easily follow along."
    }

    book('Falando de Grails') {
        authors 'Henrique Lobo Weissmann'
        cover 'img/books/weissmann_groovy_grails.png'
        url 'http://www.casadocodigo.com.br/products/livro-grails'
        description 'For Groovy and Grails developers, authored by the founder of Grails Brasil based on his experiences as a Groovy and Grails consultant.'
    }

}

usergroups {
    // Europe
    userGroup('Aarhus Groovy & Grails Meetup') {
        location 'Europe/Denmark'
        url 'https://www.linkedin.com/grps/Groovy-Grails-Meetup-Aarhus-3702945/'
    }
    userGroup('Paris Groovy Grails User Group') {
         location 'Europe/France'
    }
    userGroup('Berlin Groovy User Group') {
        location 'Europe/Germany'
        url 'http://www.meetup.com/de/Berlin-Groovy-User-Group/'
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
    userGroup('Austin Groovy and Grails User Group (TX)') {
        location 'North-America/United States'
        url 'http://www.meetup.com/Austin-Groovy-and-Grails-Users/'
    }
    userGroup('Boston Groovy, Grails, Spring Meetup (B2GS)') {
        location 'North-America/United States'
        url 'https://www.meetup.com/Grails-Boston/'
    }
    userGroup('Coder Consortium of Sacramento') {
        location 'North-America/United States'
        url 'http://coderconsortium.com/'
    }
    userGroup('DFW Groovy & Grails User Group') {
        location 'North-America/United States'
        url 'http://dfw2gug.org'
    }
    userGroup('Groovy Users of Minnesota') {
        location 'North-America/United States'
        url 'http://groovy.mn'
    }
    userGroup('NYC Groovy / Grails Meetup') {
        location 'North-America/United States'
        url 'http://www.meetup.com/grails/'
    }
    userGroup('Pittsburgh Groovy Programming') {
        location 'North-America/United States'
        url 'http://www.meetup.com/Pittsburgh-Groovy-Programming/'
    }

    // South-America
    userGroup('Grails Brasil - Groovy and Grails users group of Brazil') {
        location 'South-America/Brazil'
        url 'http://www.grailsbrasil.com.br'
    }
    userGroup('Brazil Groovy and Grails Meetup') {
        location 'South-America/Brazil'
        url 'http://www.meetup.com/groovybr'
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

courses {
    course('The Complete Apache Groovy Developer Course') {
        instructor 'Dan Vega'
        url 'https://www.udemy.com/apache-groovy/?couponCode=LEARN_GROOVY'
        description '''
            <p>I am going to teach you everything you need to know to start using The Groovy Programming language. This course is really designed
            for 2 different types of people and I think both will benefit from it. If you’re a beginner programmer with a some experience in
            another language like Python or Ruby this course is for you. Dynamic languages are generally thought of as easier for total beginners
            to learn because they’re flexible and fun. If you’re an existing Java Developer (Beginner or Experienced) this course is also for you.</p>

            <p>This course is packed with almost 14 hours of content. We are going to start off with getting your development environment up and running
            and then go through the very basics of the language. From there we are going to build on that in each section cover topics like closures, meta-programming,
            builders and so much more. I feel like this is one of the most complete courses around and I am excited for you to join me on this adventure.</p>
        '''
        cover 'groovy-course-cover.png'
    }
}
