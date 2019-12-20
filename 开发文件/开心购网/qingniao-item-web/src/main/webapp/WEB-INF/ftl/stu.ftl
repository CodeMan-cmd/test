<html>
<head>
 <title>FreeMaker TEST</title>
 <meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
</head>
<body>
	Student Inf<br/>
	NAME:${student.name}
	Age:${student.age}
	Sex:${student.sex}
	<br/>
	Student List<br/>
	<table border="1">
		<tr>
			<th>INDEX</th>
			<th>Name</th>
			<th>AGE</th>
			<th>SEX</th>
		</tr>
		<#list students as stu>
			<#if stu_index%2==0>
				<tr bgcolor="green">
			<#else>
				<tr bgcolor="yellow">
			</#if>
				<td>${stu_index}</td>
				<td>${stu.name}</td>
				<td>${stu.age}</td>
				<td>${stu.sex}</td>
			</tr>
		</#list>
	</table><br/>
	Time:<br/>
	${date?string('yyyy/MM/dd HH:mm:ss')}<br/>
	NULL<br/>
	${key!}<br/>
	INCLUDE<br/>
	<#include "hello.ftl">
	
</body>
</html>	