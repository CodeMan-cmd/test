<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jstl/core_rt" %>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'index.jsp' starting page</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->

  <script type="text/javascript" src="statics/js/jquery-1.12.4.js"></script>
  <script type="text/javascript" src="statics/js/index.js"></script>
  </head>
  
  <body>
  <a href="res" >去注册</a>
  <form action="cc" method="post" id="form1">
  		<input type="hidden" name="dangqianyeshu" value="${p.dangqianyeshu}">
  		用户编码:<input type="text" name="userCode" value="${userCode }">&nbsp;&nbsp;&nbsp;&nbsp;
  		用户名:<input type="text" name="userName" value="${userName }">&nbsp;&nbsp;&nbsp;&nbsp;
  		<input type="submit" value="查询">
  </form>
    <table border="1px">
    <c:forEach items="${list}" var="c">
    	<tr>
    		<td>${c.userName}</td>
    		<td>${c.userCode}</td>
    		<td>
    			<a href="getUserById/${c.id}">修改</a>
    		</td>
    	</tr>
    </c:forEach>
    </table>
    <a href="javascript:void();" onclick="toTop()">首页</a>&nbsp;&nbsp;&nbsp;&nbsp;
    <a href="javascript:void();" onclick="toTop1()" >上一页</a>&nbsp;&nbsp;&nbsp;&nbsp;
    <a href="javascript:void();" onclick="toEnd()">下一页</a>&nbsp;&nbsp;&nbsp;&nbsp;
    <a href="javascript:void();" onclick="toEnd1(${p.zongyeshu})" >尾页</a>&nbsp;&nbsp;&nbsp;&nbsp;
        总页数${p.zongyeshu}/当前页数${p.dangqianyeshu}
       
  </body>
</html>
