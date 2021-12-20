<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: zfl
  Date: 11/15/21
  Time: 10:51 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<h1>用户列表</h1>
<table border="1px">
    <tr>
        <td>id</td>
        <td>name</td>
        <td>age</td>
        <td>birthday</td>
        <td>mobile</td>
        <td>sex</td>
    </tr>
    <c:forEach items="${users}" var="u">
        <tr>
            <td>${u.userId}</td>
            <td>${u.username}</td>
            <td>${u.password}</td>
            <td>${u.birthday}</td>
            <td>${u.mobile}</td>
            <td>${u.sex}</td>
            <td><a href="delete?id=${u.userId}">删除</a></td>
            <td><a href="update?id=${u.userId}">修改</a></td>
        </tr>
    </c:forEach>
</table>
</body>
</html>
