<%--
  Created by IntelliJ IDEA.
  User: Cmone
  Date: 06/19/2019
  Time: 14:59
--%>
<%@ page contentType="text/html;charset=UTF-8" %>
<html>
<head>
    <title>Add</title>
    <style>
        input {
            margin-top: 10px;
        }
    </style>
</head>
<body>
<form action="add" method="post"
      style="border: solid black 1px;width: 260px;text-align: center;padding: 10px 0 20px 0;margin: 0 auto;">
    <label>
        UserName:<input type="text" name="userName"/>
    </label><br/>
    <label>
        PassWord:<input type="text" name="userPassword"/>
    </label><br/>
    <label>
        Phone:<input type="text" name="phone"/>
    </label><br/>
    <label>
        Gender: 男<input type="radio" value="男" name="gender"/>
        女<input type="radio" value="女" name="gender"/>
        保密<input type="radio" value="0" name="gender"/>
    </label><br/>
    <label>
        Address:<input type="text" name="address"/>
    </label><br/>
    <label>
        Birthday:<input type="date" name="birthday"/>
    </label><br/>
    <input type="submit" value="Add"/>
</form>
</body>
</html>
