<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <title>添加页面</title>
  </head>
  <style type="text/css">
body {
	background-color: #EDE3E3;
}
body,td,th {
	color: #440708;
	font-family: cabin-sketch;
	font-style: normal;
	font-weight: 400;
	text-align: center;
}
</style>

  <form action="insertBooks" method="post" >
		<table width="383" border="1">
    		<tr>
      			<td colspan="3"><p style="text-align: center">添加新书</p></td>
   			 </tr>
    		<tr>
      			<td width="68"><p>书名：</p></td>
      			<td width="183"><input type="text" name="bookName" class="class1"></td>
      			<td width="110" style="text-align: left">*<span id="span1"></span></td>
    		</tr>
   			<tr>
      			<td><p>作者：</p></td>
      			<td><input type="text" name="bookAuthor"></td>
      			<td style="text-align: left">*<span id="span2"></span></td>
   			</tr>
    		<tr>
      			<td><p>出版社：</p></td>
      			<td><input type="text" name="bookPublish"></td>
      			<td style="text-align: left">*<span id="span3"></span></td>
    		</tr>
    		<tr>
      			<td><p>页数：</p></td>
      			<td><input type="text" name="bookPage"></td>
      			<td style="text-align: left">*<span id="span4"></span></td>
    		</tr>
    		<tr>
      			<td><p>价格：</p></td>
      			<td><input type="text" name="bookPrice"></td>
      			<td style="text-align: left">*<span id="span5"></span></td>
    		</tr>
    		<tr>
      			<td colspan="3"><input type=submit value="提交" id="but"><input type="reset" value="重置" ></td>
    		</tr>
	</table>
	</form>
  <body>
  <script type="text/javascript" src="statics/js/jquery-1.12.4.js"></script>
  <script type="text/javascript">
  $(function(){
  $("#but").click(function(){
  	var bookName1=$("input[name='bookName']").val();
  	var bookAuthor1=$("input[name='bookName']").val();
  	var bookPublish1=$("input[name='bookPublish']").val();
  	var bookPage1=$("input[name='bookPage']").val();
  	var bookPrice1=$("[name='bookPrice']").val();
  	alert(bookName1);
  	if (bookName1.match(reg)==null) {
		$("#span1").html("不能为空");
	}else if (bookAuthor1(reg)==null) {
		$("#span2").html("不能为空");
	}else if (bookPublish1(reg)==null) {
		$("#span3").html("不能为空");
	}else if (bookPage1(reg)==null) {
		$("#span4").html("不能为空");
	}else if (bookPrice1(reg)==null) {
		$("#span5").html("不能为空");
	}
  });
  });
  </script>
  </body>
</html>

