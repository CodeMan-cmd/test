<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@taglib uri="/struts-tags" prefix="s" %>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    
    <title>My JSP 'index3.jsp' starting page</title>

  </head>
  
  <body>
  	信息：<s:property value="message" default="展示数据"/><br>
  	姓名：<s:property value="user.name" default="展示数据"/><br>
  	年龄：<s:property value="user.age" default="展示数据"/><br>
  </body>
</html>
