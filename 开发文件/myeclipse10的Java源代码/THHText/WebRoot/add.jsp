<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
</head>

<body style="	background: linear-gradient(to top, #772f36, #929394);">
	<form method="post" action="AudioServlet?info=add" style="position: absolute;top: 100px;left: 400px;">
		<table width="330" height="158" border="1" >
			<tr>
				<td width="62" style="text-align: center">name</td>
				<td width="252"><input name="name" type="text">
				</td>
			</tr>
			<tr>
				<td style="text-align: center">music</td>
				<td><input name="music" type="text"
					value="AudioDiagram/Music/填写音乐名称.mp3" style="width: 100%">
				</td>
			</tr>
			<tr>
				<td style="text-align: center">video</td>
				<td><input name="video" type="text"
					value="AudioDiagram/Video/填写视频名称.Ogg" style="width: 100%">
				</td>
			</tr>
			<tr>
				<td style="text-align: center">image</td>
				<td><input name="image" type="text"
					value="AudioDiagram/Image/填写图片名称.jpg" style="width: 100%">
				</td>
			</tr>
		</table>
		<input type="submit"> <input type="reset">
	</form>
</body>
</html>

