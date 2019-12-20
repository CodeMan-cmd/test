<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    
    <title>My JSP 'index1.jsp' starting page</title>

  </head>
  
  <body>
<table width="772" height="89" border="1">
  <tbody>
    <tr>
      <td colspan="8" style="text-align: center">添加</td>
    </tr>
    <tr>
      <td style="text-align: center">编号</td>
      <td style="text-align: center">员工</td>
      <td style="text-align: center">职位</td>
      <td style="text-align: center">入职时间</td>
      <td style="text-align: center">工资</td>
      <td style="text-align: center">部门</td>
      <td style="text-align: center">修改</td>
      <td style="text-align: center">删除</td>
    </tr>
    <c:forEach var="p" items="list">
    <tr>
      <td>p.empno</td>
      <td>p.ename</td>
      <td>p.job</td>
      <td>p.sal</td>
      <td>p.hiredate</td>
      <td>p.deptno</td>
      <td><a href="employeeUpdate?empno=p.empno">修改</a></td>
      <td><a href="employeeDelete?empno=p.empno">删除</a></td>
    </tr>
    </c:forEach>
  </tbody>
</table>
  </body>
</html>
