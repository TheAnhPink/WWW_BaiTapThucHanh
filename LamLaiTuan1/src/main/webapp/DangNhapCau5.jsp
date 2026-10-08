<%--
  Created by IntelliJ IDEA.
  User: User
  Date: 9/1/2026
  Time: 1:20 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<form action="${pageContext.request.contextPath}/dangNhapCau5Servlet" method="post">
    <h1>Đăng nhập</h1>
    <label for="tendn">Tên đăng nhập: </label>
    <input type="text" name="tendn" id="tendn">
    <br>
    <label for="mk">Mật khẩu: </label>
    <input type="text" name="mk" id="mk">
    <input type="submit" value="Đăng nhập">
</form>
</body>
</html>
