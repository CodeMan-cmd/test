<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
</head>

<body>
	<table border="1px">
		<c:forEach items="${list}" var="p">
			<tr>
				<td>${p.userCode}</td>
				<td>${p.userName}</td>
			</tr>
		</c:forEach>
	</table>
</body>
</html>

