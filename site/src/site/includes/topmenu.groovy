/*
header(id: 'header') {
    div(class: 'row') {
        h1(id: 'logo') { a(href: 'index.html', 'Groovy') }
        nav(id: 'navigation') {
            ul {
                menu['Groovy'].each { menuItem ->
                    li(class: category == menuItem.name ? 'active' : '') { a(href: menuItem.link, menuItem.name) }
                }
                li {
                    a('data-effect': 'st-effect-9', class: 'st-trigger', href: '#', 'Socialize')
                }
                li(class: (category == 'Search') ? 'active' : '') {
                    a(href: 'search.html') {
                        i(class: 'fa fa-search') {}
                    }
                }
            }
        }
    }
}
*/

div(class: 'navbar navbar-default navbar-static-top', role: 'navigation') {
    div(class: 'container') {
        div(class: 'navbar-header') {
            button(type: 'button', class: 'navbar-toggle', 'data-toggle': 'collapse', 'data-target': '.navbar-collapse') {
                span(class: 'sr-only') {}
                span(class: 'icon-bar') {}
                span(class: 'icon-bar') {}
                span(class: 'icon-bar') {}
            }
            a(class: 'navbar-brand', href: 'index.html') {
                i(class: 'fa fa-star') {}
                yield ' Groovy'
            }
        }
        div(class: 'navbar-collapse collapse') {
            ul(class: 'nav navbar-nav') {
                menu['Groovy'].each { menuItem ->
                    li(class: category == menuItem.name ? 'active' : '') { a(href: menuItem.link, menuItem.name) }
                }
            }
            ul(class: 'nav navbar-nav navbar-right') {
                li {
                    a('data-effect': 'st-effect-9', class: 'st-trigger', href: '#', 'Socialize')
                }
                li(class: (category == 'Search') ? 'active' : '') {
                    a(href: 'search.html') {
                        i(class: 'fa fa-search') {}
                    }
                }
            }
        }
    }
}

/*
<div class="navbar navbar-default navbar-static-top" role="navigation">
    <div class="container">
        <div class="navbar-header">
            <button type="button" class="navbar-toggle" data-toggle="collapse" data-target=".navbar-collapse">
                <span class="sr-only"></span>
                <span class="icon-bar"></span>
                <span class="icon-bar"></span>
                <span class="icon-bar"></span>
            </button>
            <a class="navbar-brand" href="index.html"><i class="fa fa-star"></i> Groovy</a>
        </div>
        <div class="navbar-collapse collapse">
            <ul class="nav navbar-nav">
                <li class="active"><a href="learn.html">Learn</a></li>
                <li><a href="documentation.html">Documentation</a></li>
                <li><a href="download.html">Download</a></li>
                <li><a href="community.html">Community</a></li>
                <li><a href="ecosystem.html">Ecosystem</a></li>
            </ul>
            <ul class="nav navbar-nav navbar-right">
                <li><a href="../navbar/">Socialize</a></li>
                <li><a href="search.html"><i class="fa fa-search"></i></a></li>
            </ul>
        </div><!--/.nav-collapse -->
    </div>
</div>

 */