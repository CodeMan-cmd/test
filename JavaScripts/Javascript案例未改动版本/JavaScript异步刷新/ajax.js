function ajax(url, fuSucc, fnFaild) {
	//创建ajax对象
	if(window.XMLHttpRequest) {
		var oAjax = new XMLHttpRequest();
	} else {
		var oAjax = new ActiveXObject("Microsoft.XMLTHHP");
	}
	//2、连接服务器
	oAjax.open('GET', url, true); //json数据内容如下图3
	//3、向服务器发送请求
	oAjax.send();

	oAjax.onreadystatechange=function()  {
		//4、请求完成，响应就绪
		oAjax.onreadystatechange=function(){
			if(oAjax.readyState == 4) {
				if(oAjax.status == 200) { //表示已经获取到文件。
					var str = JSON.parse(oAjax.responseText); //将json数据转换成js数组对    
					alert(str); //输出结果如图4 。               
				} else {
					alert(oAjax.statusText); //如果没有获取name.json的数据，即服务器找不到这个文件，则执行该段代码。输出框会显示“Not Found”。如果是alert(xhr.status)，则显示404；
				}
			}
		};
	};
};