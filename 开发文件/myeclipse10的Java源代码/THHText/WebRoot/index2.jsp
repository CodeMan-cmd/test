<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<link rel="stylesheet" href="css/style.css" type="text/css"></link>
<link rel="stylesheet" href="css/NewFile.css" type="text/css"></link>
</head>
<body>
	<div id="petalbox"></div>
	<c:forEach items="${list}" var="a">
		<div class="qwe">
			<td><video poster="${a.image}" class="but" width="300px"
					height="300px" controls> <source src="${a.video}"
					class="qwe"></video>
				<h1 style="margin-left: 100px;">${a.name}</h1></td>
		</div>
	</c:forEach>
	<a style="text-decoration: none;" href="">清空页面</a>
	<a style="text-decoration: none;" href="add.jsp">添加</a>
	<a style="text-decoration: none;" href="GuanLi.jsp">管理员进入</a>
	
	<!-- <script src="js/hb.js"></script> -->
</body>
</html>

