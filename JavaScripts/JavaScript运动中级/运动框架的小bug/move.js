	function getStyle(obj, name) 
	{
		/*当前样式currentStyle*/
		if(obj.currentStyle) 
		{
			//返回样式
			return obj.currentStyle[name];
		}
		else
		{
			/*获取计算样式getComputedStyle*/
			return getComputedStyle(obj, false)[name];
		}
	};

	//startMove(obj,{width:400,height:400},fnEnd)
	//obj=指定位置 json=数值 fnend=继续运行的函数  
	function startMove(obj, json, fnEnd) 
	{
		//每次运行完关闭定时器
		clearInterval(obj.timer);
		//运行obj定时器
		obj.timer = setInterval(function() 
		{
				//假设所有的值都已经到了
				var bStop = true; 
				//循环json
				for(var attr in json) 
				{
					//数值初始化
					var cur = 0;
					
					if(attr == 'opacity') 
					{
						//round最后的数字取整
						cur = Math.round(parseFloat(getStyle(obj, attr)) * 100);
					}
					else 
					{
						cur = parseInt(getStyle(obj, attr));
					};
					
					var speed = (json[attr] - cur) / 6;
					speed = speed > 0 ? Math.ceil(speed) : Math.floor(speed);
					
					//判断数值！=json传递的所有几个数值就返回false
					if(cur != json[attr])
						bStop = false;
					
					//透明度以及长宽高运动判断
					if(attr == 'opacity') 
					{
						obj.style.filter = 'alpha(opcity:' + (cur + speed) + ')';
						obj.style.opacity = (cur + speed) / 100;
					}
					else
					{
						obj.style[attr] = cur + speed + 'px';
					};
					};
					
					/*整个循环完成 bStop如果为truer就运行下面的 赋值都到达*/
					if(bStop) 
					{
						clearInterval(obj.timer);
						if(fnEnd) fnEnd();
					}
				}, 30);
		};