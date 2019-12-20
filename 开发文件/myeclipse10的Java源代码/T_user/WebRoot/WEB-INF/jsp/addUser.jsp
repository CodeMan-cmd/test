<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>


<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<title>添加</title>
</head>
<body>
<center>
<h1>添加用户</h1>
	<form action="addSuccess" method="post">
		<table width="366" height="239" border="1">
				<tr>
					<td>用户名：</td>
					<td><input type="text" name="userName">
					</td>
				</tr>
				<tr>
					<td>密码：</td>
					<td><input type="password" name="userPassword">
					</td>
				</tr>
				<tr>
					<td>性别：</td>
					<td>
						<label> <input type="radio" name="gender"
							value="男" checked="checked">男</label> 
						<label> <input type="radio" name="gender" 
							value="女">女</label>
					</td>
				</tr>
				<tr>
					<td>电话：</td>
					<td><input type="text" name="phone">
					</td>
				</tr>
				<tr>
					<td>地址：</td>
					<td><input type="text" name="address" >
					</td>
				</tr>
				<tr>
					<td>出生日期：</td>
					<td><input type="text" name="birthday">
					</td>
				</tr>
				<tr>
					<td colspan="2" align="center">
					<input name="submit" type="submit" value="添加">
					</td>
				</tr>
		</table>
	</form>
	</center>
</body>
</html>
