div(id: 'contribute-btn') {
    button(type: 'button', class: 'btn btn-default',
            onclick: "window.location.href=\"https://github.com/groovy/groovy-website/tree/master/site/src/site/pages/${currentPage}.groovy\"") {
        i(class: 'fa fa-pencil-square-o') {}
        yield ' Improve this doc'
    }
}