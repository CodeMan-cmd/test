<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="fm" uri="http://www.springframework.org/tags/form" %>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'res.jsp' starting page</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
  <script type="text/javascript" src="statics/js/jquery-1.12.4.js"></script>
  <script type="text/javascript" src="statics/js/res.js"></script>
  </head>
  
  <body>
  	<form action="sc" method="post" enctype="multipart/form-data">
    	<table>
    		<tr>
    			<td>证件照</td>
    			<td>
    				<input type="file" name="a_idPicPath"/>
    			</td>
    		</tr>
    		<tr>
    			<td>用户编号:</td>
    			<td>
    				<input type="text" name="userCode">
    			</td>
    			<td>
    				<span id="userCode"></span>
    			</td>
    		</tr>
    		<tr>
    			<td>用户名:</td>
    			<td>
    				<input type="text" name="userName">
    			</td>
    		</tr>
    		<tr>
    			<td>密码:</td>
    			<td>
    				<input type="text" name="userPassword">
    			</td>
    		</tr>
    		<tr>
    			<td>出生日期:</td>
    			<td>
    				<input type="text" name="birthday">
    			</td>
    		</tr>
    		<tr>
    			<td>
    				<input type="submit" value="注册">
    			</td>
    		</tr>
    	</table>
    </form>
  </body>
</html>
