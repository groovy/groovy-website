layout 'layouts/main.groovy', true,
        pageTitle: 'The Groovy programming language - Search',
        mainContent: contents {
            div(id: 'content', class: 'page-1') {
                div(class: 'row') {
                    div(class: 'row-fluid') {
                        div(class: 'col-lg-3') {}

                        div(class: 'col-lg-8 col-lg-pull-0') {
                            include template: 'includes/contribute-button.groovy'
                            h1 {
                                i(class: 'fa fa-search') {}
                                yield ' Search'
                            }
                            p '''
                                You can search the Groovy website, the Groovy documentation, and the Groovy APIs,
                                with the Google Custom Search box below. Please type your search query, and hit enter:'''
                            div {
                                script '''
                                  (function() {
                                    var cx = '013939896723962546743:hbhn__olhii';
                                    var gcse = document.createElement('script');
                                    gcse.type = 'text/javascript';
                                    gcse.async = true;
                                    gcse.src = (document.location.protocol == 'https:' ? 'https:' : 'http:') +
                                        '//www.google.com/cse/cse.js?cx=' + cx;
                                    var s = document.getElementsByTagName('script')[0];
                                    s.parentNode.insertBefore(gcse, s);
                                  })();
                                '''
                                'gcse:search'(linkTarget: '_blank'){}
                                style '''
                                    .gsc-input-box {
                                        height: 30px;
                                    }
                                    input.gsc-search-button, input.gsc-search-button-v2 {
                                        height: 30px;
                                        display: none;
                                    }
                                    .gs-title {
                                        line-height: 20px;
                                        font-weight: bold;
                                    }
                                    .gs-snippet {
                                        margin-left: 8px;
                                        line-height: 18px;
                                        font-family: "Open Sans", "Helvetica Neue", Helvetica, Arial, sans-serif;
                                    }
                                    .gsc-cursor-page {
                                        margin: 4px;
                                        padding: 4px;
                                        padding-left: 8px;
                                        padding-right: 8px;
                                        border: 1px solid gray;
                                    }
                                    .gsc-cursor-page:hover {
                                        color: white !important;
                                        background-color: #db4800 !important;
                                        text-decoration: none !important;
                                    }
                                    .gsc-cursor-current-page {
                                        background-color: #F2F2F2 !important;
                                        color: black !important;
                                    }
                                    .gsc-selected-option-container {
                                        width: 120px !important;
                                    }
                                    td.gsc-search-button {
                                        padding-top: 6px;
                                    }
                                    td.gsc-orderby-container {
                                        padding-right: 20px;
                                    }
                                    .gs-no-results-result .gs-snippet {
                                        font-weight: bold;
                                        color: #db4800;
                                        background-color: white;
                                        border: 0px;
                                    }
                                    .gsc-webResult, .gsc-result {
                                        font-family: "Open Sans", "Helvetica Neue", Helvetica, Arial, sans-serif;
                                    }
                                    .gsst_a, .gscb_a {
                                        margin-top: 3px;
                                    }
                                    .gs-per-result-labels {
                                        margin-left: 8px;
                                        margin-top: 4px;
                                    }
                                    .gs-per-result-labels:before {
                                        font-family: FontAwesome;
                                        content: '\\f02c';
                                        margin-right: 8px;
                                    }
                                    .gsc-tabHeader.gsc-tabhActive {
                                        border-color: #CCCCCC;
                                        border-bottom-color: #F2F2F2;
                                        background-color: #F2F2F2;
                                    }
                                    .gsc-tabsArea {
                                        border-bottom: 0;
                                    }
                                    a.gs-label, img.gs-image {
                                        margin-left: 5px;
                                    }
                                '''
                            }
                            hr(class: 'divider')
                        }
                    }
                }
            }
        }