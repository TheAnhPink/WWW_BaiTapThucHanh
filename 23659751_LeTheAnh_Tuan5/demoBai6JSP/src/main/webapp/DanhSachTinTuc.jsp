<%--
  Created by IntelliJ IDEA.
  User: acer-lap
  Date: 10/5/2026
  Time: 11:11 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" %>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>

<!DOCTYPE html>
<html lang="vi">

<head>
    <meta charset="UTF-8">
    <title>Danh sách tin tức</title>
    <!-- Bạn có thể giữ link CSS cũ hoặc copy đoạn style dưới vào file style.css -->
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/style.css">

    <style>
        /* GIAO DIỆN ĐƠN GIẢN - CHỦ ĐỀ MÀU HỒNG */
        body {
            font-family: Arial, sans-serif;
            background-color: #fff5f8; /* Nền hồng rất nhạt */
            color: #333;
            margin: 0;
            padding: 20px;
        }

        .container {
            max-width: 1000px;
            margin: 0 auto;
            background-color: #ffffff;
            padding: 25px;
            border-radius: 8px;
            border: 1px solid #f8bbd0; /* Viền hồng nhạt */
        }

        h1 {
            text-align: center;
            color: #d81b60; /* Hồng đậm */
            font-size: 24px;
            margin-top: 0;
            margin-bottom: 20px;
        }

        /* Thanh điều hướng */
        nav {
            text-align: center;
            margin-bottom: 25px;
            padding-bottom: 15px;
            border-bottom: 1px solid #fce4ec;
        }

        nav a {
            text-decoration: none;
            color: #d81b60;
            padding: 8px 16px;
            margin: 0 5px;
            border: 1px solid #f8bbd0;
            border-radius: 4px;
            font-weight: bold;
            font-size: 14px;
            transition: all 0.2s;
        }

        nav a:hover {
            background-color: #d81b60;
            color: #ffffff;
            border-color: #d81b60;
        }

        h2 {
            color: #ad1457;
            font-size: 18px;
            margin-bottom: 15px;
        }

        /* Bộ lọc danh mục */
        .category {
            background-color: #fce4ec; /* Nền hồng phấn */
            padding: 12px;
            border-radius: 6px;
            margin-bottom: 20px;
            font-size: 14px;
        }

        .category strong {
            color: #ad1457;
            margin-right: 8px;
        }

        .category a {
            text-decoration: none;
            color: #d81b60;
            margin-right: 15px;
        }

        .category a:hover {
            text-decoration: underline;
        }

        /* Bảng dữ liệu */
        table {
            width: 100%;
            border-collapse: collapse;
            font-size: 14px;
        }

        th {
            background-color: #f8bbd0; /* Hồng nhạt */
            color: #880e4f; /* Đỏ mận đậm */
            padding: 12px 10px;
            text-align: left;
            border: 1px solid #f8bbd0;
        }

        td {
            padding: 10px;
            border: 1px solid #fce4ec;
        }

        /* Hiệu ứng sọc xen kẽ cho bảng */
        tbody tr:nth-child(even) {
            background-color: #fff9fb;
        }

        tbody tr:hover {
            background-color: #fdf2f5;
        }

        /* Link trong bảng */
        td a {
            color: #d81b60;
            text-decoration: none;
            font-weight: bold;
        }

        td a:hover {
            text-decoration: underline;
        }
    </style>
</head>

<body>

<div class="container">

    <h1>QUẢN LÝ TIN TỨC</h1>

    <nav>
        <a href="${pageContext.request.contextPath}/danh-sach-tin-tuc">Danh sách tin</a>
        <a href="${pageContext.request.contextPath}/tin-tuc-form">Thêm tin tức</a>
        <a href="${pageContext.request.contextPath}/quan-ly-form">Quản lý / Xóa</a>
    </nav>

    <h2>Danh sách tin tức</h2>

    <div class="category">
        <strong>Danh mục:</strong>
        <a href="${pageContext.request.contextPath}/danh-sach-tin-tuc">Tất cả</a>

        <c:forEach var="dm" items="${danhSachDanhMuc}">
            <a href="${pageContext.request.contextPath}/danh-sach-tin-tuc?maDM=${dm.maDM}">
                    ${dm.tenDanhMuc}
            </a>
        </c:forEach>
    </div>

    <table>
        <thead>
        <tr>
            <th>Mã TT</th>
            <th>Tiêu đề</th>
            <th>Nội dung</th>
            <th>Liên kết</th>
            <th>Mã DM</th>
        </tr>
        </thead>

        <tbody>
        <c:forEach var="tin" items="${danhSachTin}">
            <tr>
                <td>${tin.maTinTuc}</td>
                <td>${tin.tieuDe}</td>
                <td>${tin.noiDungTinTuc}</td>
                <td>
                    <a href="${tin.lienKet}" target="_blank">Xem</a>
                </td>
                <td>${tin.maDM}</td>
            </tr>
        </c:forEach>
        </tbody>
    </table>

</div>

</body>
</html>