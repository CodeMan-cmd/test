<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ page import="java.util.Date,java.text.SimpleDateFormat" %>
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

<title>新增图书</title>
<script type="text/javascript" src="../../statics/js/jquery-1.12.4.js"></script></head>

<body>   
	<form action="success" method="post" id="form-add">
		<table>
			<tr>
				<td colspan="2" align="center">增加新书</td>
			</tr>
			<tr>
				<td>书名：</td>
				<td><input type="text" name="bookName">
				</td>
			</tr>
			<tr>
				<td>作者：</td>
				<td><input type="text" name="bookAuthor">
				</td>
			</tr>
			<tr>
				<td>出版社：</td>
				<td><input type="text" name="bookPublish">
				</td>
			</tr>
			<tr>
				<td>页数：</td>
				<td><input type="text" name="bookPage">
				</td>
			</tr>
			<tr>
				<td>价格：</td>
				<td><input type="text" name="bookPrice">
				</td>
			</tr>	
			<tr>
				<td colspan="2" align="center">
					<input type="submit" name="submit" id="submit" value="提交">&nbsp;&nbsp;&nbsp;&nbsp;
					<input type="reset" name="reset" id="reset" value="重置">
				</td>
			</tr>
		</table>
	</form>
</body>
<script type="text/javascript">
	$("#form-add").submit(function(){
		var flag=true;
		if($(["name=bookName"]).val()==''){
			alert("书名不能为空！");
			flag=false;
		}
		if($(["name=bookAuthor"]).val()==''){
			alert("请输入作者名！");
			flag=false;
		}
		if($(["name=bookPublish"]).val()==''){
			alert("出版社不能为空！");
			flag=false;
		}
		if(!page.test($(["name=bookPage"]).val())){
			alert("页数不能为空，并为整数！");
			flag=false;
		}
		if(!page.test($(["name=bookPrice"]).val())){
			alert("请输入价格！");
			flag=false;
		}
		return flag;
	});
</script>
</html>
