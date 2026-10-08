<%--
  Created by IntelliJ IDEA.
  User: User
  Date: 9/8/2026
  Time: 6:22 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html>
<head>
    <title>Danh sách sản phẩm</title>
</head>
<body>
<h2>Danh sách sản phẩm</h2>
<a href="products?action=add">Thêm sản phẩm mới</a>
<br><br>
<table border="1" >
    <tr>
        <th>ID</th>
        <th>Tên sản phẩm</th>
        <th>Giá</th>
        <th>Hành động</th>
    </tr>
    <c:forEach items="${products}" var="pro">
        <tr>
            <td>${pro.id}</td>
            <td>${pro.name}</td>
            <td>${pro.price}</td>
            <td>
                <a href="products?action=edit&id=${pro.id}">Sửa</a> |
                <a href="products?action=delete&id=${pro.id}" onclick="return confirm('Bạn có chắc muốn xóa không?');">Xóa</a>
            </td>
        </tr>
    </c:forEach>
</table>
</body>
</html>
