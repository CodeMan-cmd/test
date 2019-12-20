<%--
  Created by IntelliJ IDEA.
  User: Mr-tong
  Date: 2019/10/12
  Time: 21:50
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
  <head>
    <title>ajax</title>

    <script>
      window.onload=function () {
        var oBtn=document.getElementById('btn1');
        oBtn.onclick=function () {
          /*请求Request对象内容*/
          /*非ie6的浏览器*/
          /*var oAjax=new XMLHttpRequest();
          alert(oAjax);*/
          /*之能在ie6*/
          var oAjax=new ActiveXObject("Microsoft.XMLHTTP");
          alert(oAjax);
        }
      }
    </script>
  </head>
  <body>
      <input id="btn1" type="button" value="读取" />
  </body>
</html>
