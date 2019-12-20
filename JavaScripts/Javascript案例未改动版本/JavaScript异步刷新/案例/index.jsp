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
    <script src="ajax/new_ajax.js"></script>
    <script>
        window.onload = function () {
            var oBtn = document.getElementById('btn1');
            oBtn.onclick = function () {
                ajax('ajax/a.txt', function (str) {
                    alert(str);
                })
            };
        };
    </script>
</head>
<body>
<input id="btn1" type="button" value="读取"/>
</body>
</html>
