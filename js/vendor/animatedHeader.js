var animatedHeader = (function() {

	var docElem = document.documentElement,
		header = jQuery('#header'),
		didScroll = false,
		changeHeaderOn = 100;

	function init() {


		window.addEventListener( 'scroll', function( event ) {
            console.log("scroll");
			if( !didScroll ) {
				didScroll = true;
				setTimeout( scrollPage, 250 );
			}
		}, false );
	}
	function scrollPage() {
		var sy = scrollY();
        console.log("ici");
		if ( sy >= changeHeaderOn ) {
			classie.add( header, 'header-shrink' );
		}
		else {
			classie.remove( header, 'header-shrink' );
		}
		didScroll = false;
	}
	function scrollY() {
		return window.pageYOffset || docElem.scrollTop;
	}
	init();
})();