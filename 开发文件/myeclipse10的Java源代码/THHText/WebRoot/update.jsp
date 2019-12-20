<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
  </head>
  
  <body>
<form method="post" action="AudioServlet?info=updateAudio&id=${p.id}">
<table width="330" height="158" border="1">
    <tr>
      <td width="62" style="text-align: center" >name</td>
      <td width="252"><input name="name" type="text"value="${p.name}"></td>
    </tr>
    <tr>
      <td style="text-align: center">music路径</td>
      <td><input name="music" type="text" value="${p.music}"></td>
    </tr>
    <tr>
      <td style="text-align: center">video路径</td>
      <td><input name="video" type="text" value="${p.video}"></td>
    </tr>
    <tr>
      <td style="text-align: center">image路径</td>
      <td><input name="image" type="text" value="${p.image}"></td>
    </tr>
</table>
<input type="submit">
<input type="reset">
</form>
  </body>
</html>

