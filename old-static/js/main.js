function socialize() {
    //$("#st-container").addClass("st-menu-open");
    return false
}

$(function(){
    $(window).scroll(function(){
        console.log("2");
    });
    $("body, html, .st-container, .st-pusher").scroll(function(){
        console.log("2");
    });

});
