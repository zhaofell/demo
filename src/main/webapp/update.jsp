<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: zfl
  Date: 11/15/21
  Time: 10:03 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<h1>更新用户</h1>
<form action="update" method="post">
    Id<input name="userId" value="${user.userId}" readonly /> <br>
    Username<input name="username" value="${user.username}"/> <br>
    Password<input name="password" type="password" value="${user.password}"/> <br>
    Age<input name="age" value="${user.age}"/> <br>
    Mobile<input name="mobile" value="${user.mobile}"/> <br>
    Birthday<input name="birthday" type="date" value="${user.birthday}"/> <br>
    <c:if test="${user.sex=='M'}">
        <input name="sex" type="radio" value="M" checked/>男
        <input name="sex" type="radio" value="F"/>女<br>
    </c:if>

    <c:if test="${user.sex=='F'}">
        <input name="sex" type="radio" value="M" />男
        <input name="sex" type="radio" value="F" checked/>女<br>
    </c:if>

    <input type="submit" value="更新" />
</form>
</body>
</html>
