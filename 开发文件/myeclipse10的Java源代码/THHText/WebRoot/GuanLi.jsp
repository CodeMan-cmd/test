<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    
    <title>管理员页面</title>
    
  </head>
  
  <body>
   <c:forEach items="${list}" var="b">
		<div style="margin-left: 150px;">
			<table width="1046" height="65" border="1">
				<tr></tr>
				<tr>
					<td>id</td>
					<td width="135" style="text-align: center">歌手名称</td>
					<td width="218" style="text-align: center">音乐路径</td>
					<td width="216" style="text-align: center">视频路径</td>
					<td width="196" style="text-align: center">图片路径</td>
					<td width="179" style="text-align: center"><a
						href="AudioServlet?info=selectAllid&id=${b.id}" style="text-decoration: none; margin-right: 50px;">修改</a></td>
				</tr>
				<tr>
					<td>${b.id}</td>
					<td style="text-align: center">${b.name}</td>
					<td>${b.music}</td>
					<td>${b.video}</td>
					<td>${b.image}</td>
					<td><a
						style="padding-left: 50px; text-decoration:none;"
						href="AudioServlet?info=deletePerson&id=${b.id}">删除</a>
					</td>
				</tr>
			</table>
		</div>
	</c:forEach>
  </body>
</html>
