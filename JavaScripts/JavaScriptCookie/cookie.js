function setCookie(name, value, iDay) {
	var oDate = new Date();
	oDate.setDate(oDate.getDate() + iDay);
	document.cookie = name + '=' + value + ';expires=' + oDate;
};

function getCookie(name) {
	/*split() 方法用于把一个字符串分割成字符串数组*/
	var arr = document.cookie.split('; ');
	for(var i = 0; i < arr.length; i++) {
		var arr2 = arr[i].split('=');
		if(arr2[0] == name) {
			return arr2[i];
		}
	}
	return '';
};

function removeCookie(name) {
	//-1天 浏览器内核自动删除cookie
	setCookie(name, 1, -1);
}