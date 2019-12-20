<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<base href="<%=basePath%>">

<title>登录</title>

<script type="text/javascript" src="/springmvc-8101/resource/js/jquery-1.8.3.min.js"></script></head>

<body>
	<center>
		<h1>添加用户</h1>
 
		<form action="toadd.do" method="post" enctype="multipart/form-data" style="background-color:grey">
			<p>
				用户名：<input type="text" name="username" id = "username" onblur="vertifyUserName()"/>
				<span id="spanusername"></span>
			</p>
			<p>
				密码：<input type="password" name="password" />
			</p>
			<p>
				出生日期：<input type="date" name="birthday" />
			</p>
			<p>
				性别： <input type="radio" name="gender" value="1" />男 <input
					type="radio" name="gender" value="2" />女 <input type="radio"
					name="gender" value="3" />保密
			</p>

			<p>
				邮箱：<input type="text" name="email" />
			</p>
			<p>
				爱好： <input type="checkbox" name="hobby" value="读书" />读书 <input
					type="checkbox" name="hobby" value="练书法" />练书法 <input
					type="checkbox" name="hobby" value="做好事" />做好事 <input
					type="checkbox" name="hobby" value="K歌" />K歌

			</p>
			<p>
				城市 <select name="city">
					<option value="湖北">湖北</option>
					<option value="湖南">湖南</option>
					<option value="山东">山东</option>
					<option value="山西">山西</option>
				</select>

			</p>

			<p>
				附件: <input type="file" name= "upload" />
				附件: <input type="file" name= "upload" />
				附件: <input type="file" name= "upload" />
			</p>
			<p>
				<input type="submit" value="提交" />
		</form>
	</center>
	
	
	<script type="text/javascript">
		
		
		function vertifyUserName(){
			var x = $("#username").val();
			$.ajax({
				"method":"post",
				"url":"vertifyUserName.do",
				"data":{"username":x},
				"success":function(data){
					 $("#spanusername").html(data);
				
				}
			
			
			});
			
		}
	
	
	</script>
</body>
</html>
 