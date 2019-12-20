<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jstl/core_rt"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<base href="<%=basePath%>">

<title>首页</title>
<script type="text/javascript" src="statics/js/jquery-1.12.4.js"></script>
<!-- <script type="text/javascript" src="statics/js/fenye.js"></script> -->
<script type="text/javascript">
			function toHome(){
				$("[name='nowPageNumber']").val(1);
				$("#myform").submit();
			}
			function toTop(){
				var s=parseInt($("[name='nowPageNumber']").val())-1;
				$("[name='nowPageNumber']").val(s);
				$("#myform").submit();
			}
			function toEnd(){
				var s=parseInt($("[name='nowPageNumber']").val())+1;
				$("[name='nowPageNumber']").val(s);
				$("#myform").submit();
			}
			function toBack(abc){
				$("[name='nowPageNumber']").val(abc);
				$("#myform").submit();
			}

</script>
</head>

<body>
	<center>
	<form action="indexBook" method="post" id="myform">
		<input type="hidden" name="nowPageNumber" value="${page.nowPageNumber}">
		<select name="type">
			<option <c:if test="${type==0 }">selected="selected"</c:if> value="0">
				书名
			</option>
			<option <c:if test="${type==1 }">selected="selected"</c:if> value="1">
				作者
			</option>
			<option <c:if test="${type==2 }">selected="selected"</c:if> value="2">
				出版社
			</option>
		</select>
		<input type="text" name="text" value="${text}">
		<input type="submit" value="查询">
	</form>
	<a href="add">增加图书</a>
	<table border="1">
		<tr style="color:blue">
			<td>书名</td>
			<td>作者</td>
			<td>出版社</td>
			<td>页数</td>
			<td>价格</td>
		</tr>
		<c:forEach items="${list}" var="b">
			<tr>
				<td>${b.bookName}</td>
				<td>${b.bookAuthor}</td>
				<td>${b.bookPublish}</td>
				<td>${b.bookPage}</td>
				<td>${b.bookPrice}</td>
			</tr>
		</c:forEach>
	</table>
	<a href="javascript:void();" onclick="toHome()">首页</a>&nbsp;&nbsp;&nbsp;
	<a href="javascript:void();" onclick="toTop()">上一页</a>&nbsp;&nbsp;&nbsp;
	<a href="javascript:void();" onclick="toEnd()">下一页</a>&nbsp;&nbsp;&nbsp;
	<a href="javascript:void();" onclick="toBack(${page.pagesCount})">末页</a>&nbsp;&nbsp;&nbsp;
	第${page.nowPageNumber}页/共${page.pagesCount}页
	</center>
</body>
</html>
