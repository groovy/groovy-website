layout 'layouts/iframedoc.groovy',
        pageTitle: "The Groovy programming language - $title",
        contents: contents { iframe class: 'doc-embed', frameborder: '0', height: '100%', width: '100%', src: iframeTarget }
