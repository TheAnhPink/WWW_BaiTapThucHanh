<%--
  Created by IntelliJ IDEA.
  User: User
  Date: 9/1/2026
  Time: 9:19 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<h1>Nộp nhiều file</h1>
  <form action="${pageContext.request.contextPath}/nopfile" method="post" enctype="multipart/form-data">
    <input type="file" name="onhapfile" id=""> <br>
    <input type="file" name="onhapfile" id=""> <br>
    <input type="file" name="onhapfile" id=""> <br>
    <input type="file" name="onhapfile" id=""> <br>
    <input type="file" name="onhapfile" id=""> <br> <br>
    <button type="submit">Nộp file</button>
  </form>
</body>
</html>
