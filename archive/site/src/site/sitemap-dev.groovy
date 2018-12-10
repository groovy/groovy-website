def userSiteBase = 'http://groovy-lang.org/'
def devSiteBase = '/'

changelogs = false
releaseNotes = false

menu {
    group('Groovy') {
        item 'Learn',                       "${userSiteBase}learn.html"
        item 'Documentation',               "${userSiteBase}documentation.html"
        item 'Download',                    "${userSiteBase}download.html"
        item 'Support',                     "${userSiteBase}support.html"
        item 'Contribute',                  "${devSiteBase}"
        item 'Ecosystem',                   "${userSiteBase}ecosystem.html"
    }

    group('About') {
        item 'Source code',                 'https://github.com/apache/groovy'
        item 'Security',                    "${userSiteBase}security.html"
        item 'Books',                       "${userSiteBase}learn.html#books"
        item 'Thanks',                      "${userSiteBase}thanks.html"
        item 'Sponsorship',                 'http://www.apache.org/foundation/sponsorship.html'
        item 'FAQ',                         "${userSiteBase}faq.html"
        item 'Search',                      "${userSiteBase}search.html"
    }

    group('Socialize') {
        item 'Discuss on the mailing-list', "${userSiteBase}mailing-lists.html",                'fa-envelope'
        item 'Groovy newsletter',           "${userSiteBase}groovy-weekly.html",                'fa-envelope-o'
        item 'Groovy on Twitter',           'https://twitter.com/ApacheGroovy',                 'fa-twitter'
        item 'Events and conferences',      "${userSiteBase}events.html",                       'fa-calendar'
        item 'Source code on GitHub',       'https://github.com/apache/groovy',                 'fa-github'
        item 'Report issues in Jira',       "${userSiteBase}reporting-issues.html",             'fa-bug'
        item 'Google+ Groovy Page',         'https://google.com/+groovy',                       'fa-google-plus'
        item 'Google+ Groovy Community',    'http://bit.ly/g-community',                        'fa-google-plus'
        item 'Stack Overflow questions',    'http://stackoverflow.com/questions/tagged/groovy', 'fa-stack-overflow'
        item 'Slack Community',             'http://groovycommunity.com/',                      'fa-slack'
    }
}

pages {
//    page 'index', 'index', [:]
    page 'search', 'search', [category: 'Search']
    page 'versioning', 'versioning', [category: 'Download']
    page 'contribute', 'index', [category: 'Develop']
    page 'buildstatus', 'buildstatus', [category: 'Develop']
    page 'faq', 'faq', [category: 'Documentation']
    page '404','404', [:]
}

documentation {
    section('Getting started','fa-graduation-cap') {
        //          NAME                                     TARGET HTML         DOCPAGE HTML                       GENERATE
        item 'Download Groovy',                             'download',         'download',                         false
    }
}
