<%--
  Created by IntelliJ IDEA.
  User: User
  Date: 9/18/2026
  Time: 2:17 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<h1> ĐĂNG NHẬP </h1> 
<strong> tk: admin - mk: 123</strong>

    <form action="${pageContext.request.contextPath}/login" method="post">
        <label for="un">Nhập User Name: </label>
        <input type="text" name="un" id="">
        <br>
        <label for="pw">Nhập Password: </label>
        <input type="text" name="pw" id="">
        <br>
        <button type="submit">Đăng nhập</button>
    </form>
<h2>${loi}</h2>
<strong>Số người đang hoạt động: ${applicationScope.userCounter}</strong>

</body>
</html>
