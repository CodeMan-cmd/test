$(function () {
    /*大背景弹出*/
    $(".navbar-toggle").click(function () {
        $(this).toggleClass("click");
        $(".bg-div").toggleClass("hide");
        $("body").toggleClass("body-static");
        // console.log($("#MyModal").style)
    });
    /*点击灰色背景，导航消失*/
    $(".bg-div").click(function () {
        $(".navbar-toggle").trigger("click");
    });


   /*  if ($("#MyModal").show()) {
        $("body").css({ "overflow": "hidden", "margin-right": "15px;" })
        $("modal").css({ "overflow": "auto", "overflow-y": "scroll;" })
    } */

})