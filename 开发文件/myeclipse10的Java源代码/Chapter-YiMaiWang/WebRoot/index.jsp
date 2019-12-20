<%@page import="pojo.User"%>
<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
  <head>
    <title>信息管理</title>
	
  </head>
  
  <body>
  <table width="783" height="199" border="1">
    <tr>
      <td width="18" style="text-align: center">id</td>
      <td width="81" style="text-align: center">usercode</td>
      <td width="103" style="text-align: center">username</td>
      <td width="104" style="text-align: center">userpassword</td>
      <td width="61" style="text-align: center">gender</td>
      <td width="73" style="text-align: center">birthday</td>
      <td width="45" style="text-align: center">phon</td>
      <td width="70" style="text-align: center">adderss</td>
      <td width="71" style="text-align: center">userrole</td>
      <td width="93" style="text-align: center">createdby</td>
    </tr>
    <c:forEach var="s" items="#{list}">
    <tr>
      <td>#{s.getid}</td>
      <td>#{s.getuserCode}</td>
      <td>#{s.getuserName}</td>
      <td>#{s.getuserPassword}</td>
      <td>#{s.getgender}</td>
      <td>#{s.getbirthday}</td>
      <td>#{s.getphone}</td>
      <td>#{s.geaddress}</td>
      <td>#{s.getuserRole}</td>
      <td>#{s.getcreatedBy}</td>
    </tr>
    </c:forEach>
</table>
<ol>
<li><a href="insert.jsp">添加</a></li>
<li><a href="">删除</a></li>
<li><a href="update.jsp">修改</a></li>
<li><a href="">查询</a></li>
</ol>
  </body>
</html>
