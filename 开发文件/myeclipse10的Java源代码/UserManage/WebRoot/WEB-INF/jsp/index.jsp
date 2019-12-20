<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jstl/core_rt"%>
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

<title>首页</title>
<meta http-equiv="pragma" content="no-cache">
<meta http-equiv="cache-control" content="no-cache">
<meta http-equiv="expires" content="0">
<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
<meta http-equiv="description" content="This is my page">

</head>

<body>
	<center>
		<h1>用户列表</h1>
		<a href="../UserManage/add">添加</a>
		<table border="1px">
			<tr>
				<td>编号</td>
				<td>用户名</td>
				<td>密码</td>
				<td>电话</td>
				<td>地址</td>
				<td>性别</td>
				<td>出生日期</td>
				<td>修改</td>
				<td>删除</td>
			</tr>
			<c:forEach items="${list}" var="u">
				<tr>
					<td><a href="../UserManage/ById?id=${u.id}">${u.id}</a></td>
					<td>${u.userName }</td>
					<td>${u.userPassword }</td>
					<td>${u.phone }</td>
					<td>${u.address }</td>
					<td>
						<c:if test="${u.gender=='男'}">男</c:if>
						<c:if test="${u.gender=='女'}">女</c:if>
					</td>
					
					<td>
						
						<s:formatDate value="${u.birthday}" type="date"/>
					</td>
					<td><a href="../UserManage/modify?id=${u.id}">修改</a></td>
					<td><a href="../UserManage/deleteUser?id=${u.id}">删除</a></td>
				</tr>
			</c:forEach>
		</table>
	</center>
</body>
</html>
