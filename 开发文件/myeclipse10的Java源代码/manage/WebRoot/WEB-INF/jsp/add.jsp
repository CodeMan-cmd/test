<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>


<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>

<title>My JSP 'index1.jsp' starting page</title>
</head>

<body>
	<form action="employeeInsert" method="post">
		<table width="280" border="1">
			<tbody>
				<tr>
					<td colspan="2" style="text-align: center">修改员工</td>
				</tr>
				<tr>
					<td width="74" style="text-align: center">员工：</td>
					<td width="190" style="text-align: center"><input type="text"></td>
				</tr>
				<tr>
					<td style="text-align: center">职位：</td>
					<td style="text-align: center"><input type="text"></td>
				</tr>
				<tr>
					<td style="text-align: center">入职时间：</td>
					<td style="text-align: center"><input type="text"></td>
				</tr>
				<tr>
					<td style="text-align: center">工资：</td>
					<td style="text-align: center"><input type="text"></td>
				</tr>
				<tr>
					<td style="text-align: center">部门：</td>
					<td style="text-align: center"><input type="text"></td>
				</tr>
		</table>
		<input type="submit" value="提交">
	</form>
</body>
</html>
