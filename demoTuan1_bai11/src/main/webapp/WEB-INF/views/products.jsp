<%--
  Created by IntelliJ IDEA.
  User: User
  Date: 9/16/2026
  Time: 9:25 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
    <h1>Xin chào, ${user.userName}</h1>
    <form action="${pageContext.request.contextPath}/logout" method="post">
        <button type="submit">Đăng xuất</button>
    </form>
    <table>
        <tr>
            <td>ID</td>
            <td>Name</td>
            <td>Price</td>
            <td>Hành động</td>
        </tr>

    <c:forEach items="${dssp}" var="sp">
        <tr>
            <td>${sp.id}</td>
            <td>${sp.name}</td>
            <td>${sp.price}</td>
            <td>
                <form action="${pageContext.request.contextPath}/cart/add" method="post">
                    <input type="hidden" name="id" value="${sp.id}"  id="">
                    <button type="submit">Thêm</button>
                </form>
            </td>
        </tr>
    </c:forEach>
    </table>

    <h1>Danh sách sản phẩm trong giỏ hàng: </h1>
    <table>
        <tr>
            <td>ID</td>
            <td>Name</td>
            <td>Price</td>
            <td>Số lượng</td>
            <td>Tổng tiền</td>
        </tr>
        <c:forEach items="${user.shoppingCart.dsCartItemTrongGio}" var="item">
            <tr>
                <td>${item.product.id}</td>
                <td>${item.product.name}</td>
                <td>${item.product.price}</td>
                <td>${item.quantity}</td>
                <td>${item.getTongTienSanPham()}</td>
            </tr>
        </c:forEach>


        <tr>
            <td>Tổng tiền thanh toán: </td>
            <td>${user.shoppingCart.getTongTienToanBoGioHang()}</td>

        </tr>
    </table>
    <strong>Số người đang hoạt động: ${applicationScope.userCounter}</strong>

</body>
</html>
