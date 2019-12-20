
<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<link rel="stylesheet" href="css/style2.css">
<script type="text/javascript" src="js/jquery-1.12.4.js"></script></head>

<body>
	<div>
		<!-- 背景 -->
		<div id="background" class="wall"></div>
		<!-- 中 -->
		<div id="midground" class="wall"></div>
		<!-- 前景 -->
		<div id="foreground" class="wall"></div>
		<div id="top" class="wall">
			<div id="qwe">
				<form action="AudioServlet?info=Landing" method="post">
					<table width="400" height="87"
						style="margin-left:100px;margin-top: 400px">
						<tr>
							<td>账号
								 <input type="text"name="user" style="border-radius: 20px;"> *<span
								></span>
							</td>
						</tr>
						<tr style="width: 600px;">
							<td>密码 <input type="password" name="pwd" style="border-radius: 20px;">
								*${msg}</td>
						</tr>
						<tr>
							<td colspan="2" style="padding-left: 80px"><input
								type="submit" value="登陆" id="denglu" style="border-radius: 20px;"><input type="reset" value="清除" style="border-radius: 20px;">
							</td>
						</tr>
					</table>
				</form>
			</div>
		</div>
		<script src="js/hb.js"></script>
	</div>
</body>
</html>

