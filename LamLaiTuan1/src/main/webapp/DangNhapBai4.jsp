<%--
  Created by IntelliJ IDEA.
  User: User
  Date: 8/23/2026
  Time: 11:27 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
  <form action="${pageContext.request.contextPath}/dangNhap" method="post" enctype="multipart/form-data">
    <input type="text" name="tendn">
    <input type="password" name="pw">
    <input type="radio" name="gender" value="nam"> nam
    <input type="radio" name="gender" value="nu"> nu
    <select name="so">
      <option>mot</option>
      <option>hai</option>
      <option>ba</option>
    </select>
    <input type="checkbox" name="sothich" value="nhac"> nhac
    <input type="checkbox" name="sothich" value="ve" id=""> ve
    <input type="checkbox" name="sothich" id="" value="hat"> hat
    <input type="file" name="file" id="">
    <button type="submit"> nhấnnsnnn</button>

  </form>

</body>
</html>
