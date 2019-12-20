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
 
<link rel="stylesheet" href="resource/css/style.css" type="text/css"></link>


</head>

<body>
	<center>
	
		<img src="resource/image/4.jpg" />
		<h1>用户登录</h1>
		<form action="login.do" method="post">
			<p>用户名<input type="text" name = "username" value="张三" /></p>
			<p>密码<input type="text" name = "password" value="111"/></p>
			<p><input type="submit" value = "提交" /></p> 
		</form>

	</center>
</body>
</html>
