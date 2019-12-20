<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: Cmone
  Date: 06/19/2019
  Time: 13:48
--%>
<%@ page contentType="text/html;charset=UTF-8" %>
<html>
<head>
    <title>Index</title>
    <style>
        th {
            border: 1px black solid;
        }

        th, td {
            padding: 0 10px 0 10px;
            text-align: center;
        }

    </style>
</head>
<body>
<div style="width: 850px;margin: 0 auto;padding-top: 20px">
    <table>
        <thead>
        <span>
        <span style="font-size: 40px;font-weight: bold">User Info</span>
        <span style="margin-left: 10px"><a href="toAdd">To Add Page</a></span>
        <span style="margin-left: 430px">
            <a href="index?current=${sessionScope.pager.currentPageNumber-1}">Next</a>
            <span>${sessionScope.pager.currentPageNumber}&nbsp;/&nbsp;${sessionScope.pager.totalPage}</span>
            <a href="index?current=${sessionScope.pager.currentPageNumber+1}">Previous</a></span>
        </span>
        </thead>
        <tbody>
        <tr>
            <th>ID</th>
            <th>Name</th>
            <th>PassWord</th>
            <th>Phone</th>
            <th>Address</th>
            <th>Gender</th>
            <th>Birthday</th>
            <th>Modify</th>
            <th>Remove</th>
        </tr>
        <c:forEach items="${listAll}" var="item">
            <tr>
                <td>${item.id}</td>
                <td>${item.userName}</td>
                <td>${item.userPassword}</td>
                <td>${item.phone}</td>
                <td>${item.address}</td>
                <td>${item.gender}</td>
                <td>${item.birthday}</td>
                <td><a href="toModify?id=${item.id}">Modify</a></td>
                <td><a href="remove?id=${item.id}">Remove</a></td>
            </tr>
        </c:forEach>
        </tbody>
    </table>
</div>
</body>
</html>
