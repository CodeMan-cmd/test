	function getStyle(obj, name) {
				/*当前样式currentStyle*/
				if(obj.currentStyle) {
					return obj.currentStyle[name];
				} else {
					/*获取计算样式getComputedStyle*/
					return getComputedStyle(obj, false)[name];
				}
			};

		function startMove(obj, attr, iTarget,fnEnd) {
				clearInterval(obj.timer);
				obj.timer = setInterval(function() {
					var cur = 0;
					if(attr=='opacity'){
						/*round最后的数字取整*/
						cur=Math.round(parseFloat(getStyle(obj,attr))*100);
					}else{
						cur=parseInt(getStyle(obj, attr));
					};
					var speed = (iTarget - cur) / 6;
					speed = speed > 0 ? Math.ceil(speed) : Math.floor(speed);
					if(cur == iTarget) {
						clearInterval(obj.timer);
						/*只有在传递fnend函数才调用fnend函数*/
						if (fnEnd)fnEnd();
					} else {
						if (attr=='opacity') {
							obj.style.filter='alpha(opcity:'+(cur+speed)+')';
							obj.style.opacity=(cur+speed)/100;
							document.getElementById('txt1').value= obj.style.opacity
						} else{
							obj.style[attr] = cur + speed + 'px';
						};
					};
				}, 30);
			};
