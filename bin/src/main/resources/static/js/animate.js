$(document).ready(function () {

    $(".hover-raise").hover(function () {
        $(this).animate({
            marginTop: "-1%"
        }, 200)
    }, function () {
        $(this).animate({
            marginTop: "0%"
        }, 200)
    })

})