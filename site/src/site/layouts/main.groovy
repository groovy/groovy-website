/**
 * This layout accepts the following parameters:
 *
 * @param menu the navigation menu
 * @param pageTitle the page title
 * @param extraStyles , a list of CSS files to be added in the header
 * @param scripts , a list of scripts to be imported
 * @param extraFooter , a section to be added before closing body
 */
layout 'layouts/page.groovy', true,
        mainContent: contents {
            // 'Content'
            div {
                include template: 'includes/topmenu.groovy'
/*
                div(class:'alert alert-danger',role:'alert') {
                    p '''You are seeing a beta version of the new Groovy website. You probably came here through the
old Codehaus site which is currently down and beyond our control. This is a therefore a temporary redirection.
'''
                    p {
                        yieldUnescaped 'While we do our best to restore the old version of the website, you can find '
                        a(href:'documentation.html', 'a new documentation following this link.')
                    }
                    p '''We strongly encourage you to leverage this temporary workaround to give us your
impressions about the new website and documentation. Thanks for your understanding!'''
                }
*/
                // main contents goes here!
                mainContent()

                include template: 'includes/bottommenu.groovy'
            }
        }
