<%--
  Created by IntelliJ IDEA.
  User: Student
  Date: 8/17/2026
  Time: 11:24 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
    <h1>
        Dang nhap
    </h1>
    <form action="${pageContext.request.contextPath}/login" method="post">
        <label>Ten dang nhap: </label>
        <input name="tendn" type="text">
        <br>
        <label>Mat khau: </label>
        <input name="matkhau" type="password">
        <br>
        <button type="submit" name="btnsub">Dang nhap</button>
    </form>

</body>
</html>
