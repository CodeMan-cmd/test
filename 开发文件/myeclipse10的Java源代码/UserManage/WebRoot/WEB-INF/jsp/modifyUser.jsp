<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jstl/core_rt"%>
<%@ taglib prefix="s" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title></title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	
  </head>
  
  <body>
  <center>
  <h1>修改用户</h1>
   	<form action="modifySuccess" method="post">
		<table width="366" height="239" border="1">
				<tr>
					<td>用户名：</td>
					<td><input type="text" name="userName" value="${user.userName}">
					</td>
				</tr>
				<tr>
					<td>密码：</td>
					<td><input type="password" name="userPassword" value="${user.userPassword}">
					</td>
				</tr>
				<tr>
					<td>性别：</td>
					<td>
						<label> <input type="radio" name="gender"
							value="${user.gender=='男'}" checked="checked">男</label> 
						<label> <input type="radio" name="gender" 
							value="${user.gender=='女'}">女</label>
					</td>
				</tr>
				<tr>
					<td>电话：</td>
					<td><input type="text" name="phone" value="${user.phone}">
					</td>
				</tr>
				<tr>
					<td>地址：</td>
					<td><input type="text" name="address" value="${user.address}">
					</td>
				</tr>
				<tr>
					<td>出生日期：</td>
					<td><input type="date" name="birthday" value="${user.birthday}">
					</td>
				</tr>
				<tr>
					<td colspan="2" align="center">
					<input name="submit" type="submit" value="修改">
					</td>
				</tr>
		</table>
	</form>
	</center>
  </body>
</html>
