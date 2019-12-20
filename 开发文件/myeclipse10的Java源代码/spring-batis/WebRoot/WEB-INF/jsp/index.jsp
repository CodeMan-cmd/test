<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jstl/core_rt"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head></head>

<body>
<div>
<a href="image">图片添加到服务器</a>
	<form id="form1" action="cc" method="post">
		<input type="hidden" name="dangqianyema" value="${p.dangqianyema}">
		用户名：<input type="text" name="userCode" value="${userCode}"><br>
		密码：<input type="text" name="userName" value="${userName}">
		<input type="submit" value="查询">
		<a href="insertAA">添加</a>
	</form>
	
	<table border=" 4px" >
		<c:forEach items="${list}" var="u" >
			<tr >
				<td>${u.id}</td>
				<td>${u.userCode}</td>
				<td>${u.userName}</td>
				<td><a href="add?id=${u.id}">修改 </a></td>
				<td><a href="dateUser?id=${u.id}">删除 </a></td>
			</tr>
		</c:forEach>
	</table>
	<span  onclick="toTop()" id="shou">首页</span>&nbsp;&nbsp;&nbsp;&nbsp;
	<span  onclick="toTop1()" id="shang">上一页</span>&nbsp;&nbsp;&nbsp;&nbsp;
	<span  onclick="toEnd()" id="xia">下一页</span>&nbsp;&nbsp;&nbsp;&nbsp;
	<span  onclick="toEnd1()" id="wei">尾页</span>&nbsp;&nbsp;&nbsp;&nbsp;
	当前页数 ${p.dangqianyema }/总页数${p.zongyeshu }
	<br>
	</div>
	<script type="text/javascript" src="statics/js/jquery-1.12.4.js"></script>
	<script type="text/javascript">
			function toTop(){
        		$("[name=dangqianyeshu]").val(1);
        		$("#form1").submit();
        	}
        	function toTop1(){
        		var s=$("[name=dangqianyeshu]").val()-1;
        		$("[name=dangqianyeshu]").val(s);
        		$("#form1").submit();
        	}
        	function toEnd(){
        		var s =parseInt($("[name='dangqianyeshu']").val())+1;
        		$("[name=dangqianyeshu]").val(s);
        		$("#form1").submit();
        	}
        	function toEnd1(abc){
        		$("[name=dangqianyeshu]").val(abc);
        		$("#form1").submit();
        	}
	</script>
</body>
</html>
