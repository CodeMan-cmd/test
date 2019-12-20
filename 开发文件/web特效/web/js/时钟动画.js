//时间
function showdate() {
	var week = new Array("星期日", "星期一", "星期二", "星期三", "星期四", "星期五", "星期六");
	var now = new Date();
	var n = now.getFullYear();
	var y = now.getDate();
	var r = now.getMonth() + 1;
	var shi = now.getMinutes();
	var miao = now.getSeconds();
	var hm = now.getMilliseconds();
	var xqj = now.getDay();
	jQuery("#n").html(n + ":");
	jQuery("#y").html(y + ":");
	jQuery("#r").html(r + ":");
	jQuery("#shi").html(shi + ":");
	jQuery("#miao").html(miao + ":");
	jQuery("#hm").html(hm + ":");
	jQuery("#xqj").html("星期" + week[xqj]);
}
setInterval("showdate()", 1000);
showdate();

//跳转
$(".ax").click(function(){
	window.open("时钟2.html");
});

//图片拖拽
var oDiv = document.getElementById("box");
oDiv.onmousedown = function(ev) {
	var oEvent = ev;
	var disX = oEvent.clientX - oDiv.offsetLeft;
	var disY = oEvent.clientY - oDiv.offsetTop;
	document.onmousemove = function(ev) {
		oEvent = ev;
		oDiv.style.left = oEvent.clientX - disX + "px";
		oDiv.style.top = oEvent.clientY - disY + "px";
	}
	document.onmouseup = function() {
		document.onmousemove = null;
		document.onmouseup = null;
	}

}