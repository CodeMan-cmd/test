<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
</head>

<body>
	<form action="add2?id=${id}" method="post">

		用户编号：<input type="text" name="userCode" value="${upUser.userCode} ">
		<br> 用户名：<input type="text" name="userName"
			value="${upUser.userName}"> <br> <input type="submit"
			value="保存修改">
	</form>
</body>
</html>
