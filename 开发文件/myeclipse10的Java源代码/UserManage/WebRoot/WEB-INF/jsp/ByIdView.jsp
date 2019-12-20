<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="http://java.sun.com/jsp/jstl/fmt"%>
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

<title>My JSP 'ByIdView.jsp' starting page</title>

<meta http-equiv="pragma" content="no-cache">
<meta http-equiv="cache-control" content="no-cache">
<meta http-equiv="expires" content="0">
<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
<meta http-equiv="description" content="This is my page">
<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->

</head>

<body>
	<center>
		<h1>用户详情</h1>
		<table width="250" height="210" border="1">
			<tr>
				<td>用户名：</td>
				<td>${user.userName}</td>
			</tr>
			<tr>
				<td>密码：</td>
				<td>${user.userPassword}
			</tr>
			<tr>
				<td>性别：</td>
				<td>${user.gender}</td>
			</tr>
			<tr>
				<td>电话：</td>
				<td>${user.phone}
			</tr>
			<tr>
				<td>地址：</td>
				<td>${user.address}</td>
			</tr>
			<tr>
				<td>出生日期：</td>
				<td><s:formatDate value="${user.birthday}" /></td>
			</tr>
		</table>
	</center>
</body>
</html>
