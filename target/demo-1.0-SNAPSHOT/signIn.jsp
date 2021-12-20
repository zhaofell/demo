<%--
  Created by IntelliJ IDEA.
  User: zfl
  Date: 11/15/21
  Time: 8:01 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<h1>注册</h1>
action="signIn" method="post">
    Username<input name="username" /> <br>
    Password<input name="password" type="password"/> <br>
    Age<input name="age"/> <br>
    Mobile<input name="mobile"/> <br>
    Birthday<input name="birthday" type="date"/> <br>
    <input name="sex" type="radio" value="M"/>男
    <input name="sex" type="radio" value="F"/>女<br>
    <input type="submit" value="注册" />
</form>
</body>
</html>
