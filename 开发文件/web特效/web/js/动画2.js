function fun() {
	if($(".bb").css("display") == "none") {
		alert("小猫咪点击确定！！");
		$(".bb").css("display", "block");
		$("body").css("background", "radial-gradient(circle, #2DBDD1, #B84648)");
	};
};
setTimeout("fun()", 3000);
$(".bb").click(function(){
		window.open("时钟特效.html");
})
