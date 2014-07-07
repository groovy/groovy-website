/**
 * This layout accepts the following parameters:
 *
 * @param menu the navigation menu
 * @param pageTitle the page title
 * @param extraStyles , a list of CSS files to be added in the header
 * @param scripts , a list of scripts to be imported
 * @param iframeTarget , the URL of the page to be included as an iframe
 */
layout 'layouts/page.groovy', true,
        mainContent: contents {
            div {
                include template: 'includes/topmenu.groovy'
            }
            iframe(class: 'doc-embed', frameborder: '0', height: '100%', width: '100%', src: iframeTarget) {}
        }
