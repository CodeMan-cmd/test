<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'Login.jsp' starting page</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->

  </head>
    <script type="text/javascript" src="statics/js/jquery-1.8.3.js"></script>
  <body>
      <img src="statics/images/yyy.jpg"></img>
    	<form action="form1User" method="post">
    		<table>
	    		<tr>
	    			<td>用户名：</td>
	    			<td><input type="text" name="userName"/></td>
	    			<td>${error1}</td>
	    		</tr>
	    		<tr>
	    			<td>密码：</td>
	    			<td><input type="text" name="password"/></td>
	    			<td>${Password}</td>
	    		</tr>
	    		<tr>
	    			<td><input type="submit" value="提交"/></td>
	    			<td><input type="reset" value="重置"/></td>
	    		</tr>
    		</table>
    	</form>   
    	<!-- <script type="text/javascript">
    		$(function(){
    			$("form").submit(function(){
    				var sname=$("[name=userName]").val();
    				if(sname==""){
    					alert("用户名不能为空！");
    					return false;
    				}
    			});   		
    		});
    	</script> -->
  </body>
</html>
