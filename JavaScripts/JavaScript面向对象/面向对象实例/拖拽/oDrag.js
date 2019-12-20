function Drag(id) {
				
				var _this = this;
				this.disX = 0;
				this.disY = 0;
				
				this.oDiv = document.getElementById(id);
				this.oDiv.onmousedown = function(ev) {
					_this.fnDown(ev);
				};
			};
			//鼠标点击
			Drag.prototype.fnDown = function(ev) {
				/*Drag.prototype.fnDown对象的this*/
				var _this = this;
				var oEvent = ev || event;
				this.disX = oEvent.clientX - this.oDiv.offsetLeft;
				this.disY = oEvent.clientY - this.oDiv.offsetTop;
				/*onmousemove当用户把鼠标移动到图像上时*/
				document.onmousemove = function(ev) {
					_this.fnMove(ev);
				};
				/*onmousedown鼠标松下*/
				document.onmouseup = function() {
					_this.fnUp();
				};
			};
			//鼠标悬浮
			Drag.prototype.fnMove = function(ev) {
				var oEvent = ev || event;
				this.oDiv.style.left = oEvent.clientX - this.disX + 'px';
				this.oDiv.style.top = oEvent.clientY - this.disY + 'px';
			};
			//鼠标松下
			Drag.prototype.fnUp = function() {
				/*oDiv的onmousemove值赋值为空*/
				document.onmousemove = null;
				document.onmouseup = null;
			};