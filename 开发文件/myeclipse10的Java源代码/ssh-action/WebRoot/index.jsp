<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ taglib uri="/struts-tags" prefix="s" %>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <title>第一次</title>
    <style type="text/css">
    	ul,li{
    		display: inline;
    	}
    </style>
  </head>
  <body>
  <div>
  <h1>
		  	<!-- 显示Struts action中 message 的属性内容 -->
		  <%-- 	<s:property value="message"/> --%>
		 	<%-- <s:fielderror></s:fielderror>  --%>
  </h1>
  </div>
  <div>
  		<form action="accp.action" method="post">
  		请输入您的姓名：
  		<input name="name" type="text">
  		<s:fielderror fieldName="name"/><br>
  		请输入你的密码：
  		<input type="text" name="password">
  		<s:fielderror fieldName="pwd"/><br>
  		<input type="submit" value="提交">
  		</form>
  		<form action="accpp.action" method="post">
  		<input type="submit" value="开始">
  		</form>
  		<form action="accppp.action" method="post">
  		<input type="text" >
  		<s:fielderror></s:fielderror>
  		<input type="submit" value="格式转换"> 
  		</form>
  </div>
  </body>
</html>
