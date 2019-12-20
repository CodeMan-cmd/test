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
        window.onload = function () {
            var oBtn = document.getElementById('btn1');
            oBtn.onclick = function () {
                /*请求Request对象内容*/
                /*非ie6的浏览器*/
                /*下面决绝了问题*/
                if (window.XMLHttpRequest) {
                    var oAjax = new XMLHttpRequest();
                } else {
                    var oAjax = new ActiveXObject("Microsoft.XMLHTTP");
                }
                //连接服务器
                //open（方法,文件名,异步传输）
                //同步 多件事一起  事情一件件来
                //异步 一件一件来  多个事情可以一起做
                oAjax.open('GET', 'ajax/a.txt', true);

                //发送请求
                oAjax.send();

                //接收返回 onreadystatechange他就是跟服务器之间有交互的时候发生的事件
                oAjax.onreadystatechange = function () {
                    //oAjax.readyState //浏览器和服务器 ，进行到哪一步了
                    /*
                    * readyState
                    * 0 未初始化 还没有调用open方法
                    * 1 载入 已调用send方法，正在发送请求
                    * 2 载入完成 sendf方法完成 收到全部响应内容
                    * 3 解析 正在解析响应内容
                    * 4 完成 响应内容解析完成 可以在客户端调用了
                    * */
                    if (oAjax.readyState == 4) { //去读完成
                        if (oAjax.status==200){ //http状态码status
                            alert('成功'+oAjax.responseText);
                        }else{
                          alert('失败'+oAjax.status);
                        }
                    }
                };
            };
        };
    </script>
</head>
<body>
<input id="btn1" type="button" value="读取"/>
</body>
</html>
