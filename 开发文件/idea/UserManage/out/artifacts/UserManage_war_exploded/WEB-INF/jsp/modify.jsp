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
<form action="modify" method="post"
      style="border: solid black 1px;width: 260px;text-align: center;padding: 10px 0 20px 0;margin: 0 auto;">
    <input type="hidden" value="${aUser.id}" name="id"/>
    <label>
        UserName:<input value="${aUser.userName}" type="text" name="userName"/>
    </label><br/>
    <label>
        PassWord:<input value="${aUser.userPassword}" type="text" name="userPassword"/>
    </label><br/>
    <label>
        Phone:<input value="${aUser.phone}" type="text" name="phone"/>
    </label><br/>
    <label>
        Gender:<input value="${aUser.gender}" type="text" name="gender">
    </label><br/>
    <label>
        Address:<input value="${aUser.address}" type="text" name="address"/>
    </label><br/>
    <label>
        Birthday:<input value="${aUser.birthday}" type="date" name="birthday"/>
    </label><br/>
    <input type="submit" value="Modify"/>
</form>
</body>
</html>
