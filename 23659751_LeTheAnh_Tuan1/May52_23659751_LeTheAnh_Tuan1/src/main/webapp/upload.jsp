<%--
  Created by IntelliJ IDEA.
  User: User
  Date: 8/17/2026
  Time: 8:48 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
  <title>Upload Multi-files</title>
</head>
<body>
<h2>Upload multi-files</h2>
<form action="${pageContext.request.contextPath}/uploadmulti" method="post" enctype="multipart/form-data">
  File #1: <input type="file" name="file"/><br/><br/>
  File #2: <input type="file" name="file"/><br/><br/>
  File #3: <input type="file" name="file"/><br/><br/>
  File #4: <input type="file" name="file"/><br/><br/>
  File #5: <input type="file" name="file"/><br/><br/>
  <input type="submit" value="Upload"/>
  <input type="reset" value="Reset"/>
</form>
</body>
</html>
