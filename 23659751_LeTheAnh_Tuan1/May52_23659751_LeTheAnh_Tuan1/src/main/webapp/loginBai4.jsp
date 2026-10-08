<%--
  Created by IntelliJ IDEA.
  User: Student
  Date: 8/17/2026
  Time: 10:04 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title></title>
</head>
<body>
    <h1>HTML Form Example with File Upload</h1>
    <form action="${pageContext.request.contextPath}/login_servlet"
            method="post" enctype="multipart/form-data"  >
        <label>Name: </label>
        <input type="text" name="name">
        <br>
        <label>Password: </label>
        <input type="password" name="pw">
        <br>
        <label>Gender: </label>
        <input type="radio" name="gender" value="Male" checked>Male
        <input type="radio" name="gender" value="Female">Female
        <br>
        <label>Hobbies: </label>
        <input type="checkbox" name="hobbies" value="Reading">Reading
        <input type="checkbox" name="hobbies" value="Sports">Sports
        <input type="checkbox" name="hobbies" value="Music">Music
        <br>
        <label>Country: </label>
        <select name="country">
            <option>VietNam</option>
            <option>Cam</option>
            <option>Thai</option>
        </select>
        <br>
        <label>Birth Date: </label>
        <input type="date" name="birth">
        <br>
        <label>Profile picture: </label>
        <input type="file" name="file">
        <br>
        <button type="submit" name="submit">Submit</button>
    </form>
</body>
</html>
