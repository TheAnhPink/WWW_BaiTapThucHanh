<%--
  Created by IntelliJ IDEA.
  User: User
  Date: 9/8/2026
  Time: 7:58 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
  <title>${product!= null? "Cập nhật sản phẩm": "Thêm sản phẩm mới"}</title>
</head>
<body>
<h2>${product!= null ? "Cập nhật sản phẩm" : "Thêm sản phẩm mới"}</h2>

<form action="products" method="post">
  <input type="hidden" name="id" value="${product.id}" />

  <label>Tên sản phẩm:</label>
  <br>
  <input type="text" name="name" value="${product.name}" required /><br>
  <br>

  <label>Giá:</label>
  <br>
  <input type="number" step="any" name="price" value="${product.price}" required /><br><br>

  <button type="submit">Lưu lại</button>
  <a href="products">Hủy</a>
</form>
</body>
</html>
