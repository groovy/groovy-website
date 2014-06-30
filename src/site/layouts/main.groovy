/**
 * This layout accepts the following parameters:
 *
 * @param menu the navigation menu
 * @param pageTitle the page title
 * @param extraStyles , a list of CSS files to be added in the header
 * @param scripts , a list of scripts to be imported
 * @param extraFooter , a section to be added before closing body
 */
layout 'layouts/page.groovy',
        pageTitle: pageTitle,
        extraStyles: extraStyles,
        scripts: scripts,
        extraFooter: extraFooter,
        menu: menu,
        category: category,
        contents: contents {

            // 'Content'
            div {
                include template: 'includes/topmenu.groovy'

                // main contents goes here!
                contents()

                include template: 'includes/bottommenu.groovy'
            }
        }
