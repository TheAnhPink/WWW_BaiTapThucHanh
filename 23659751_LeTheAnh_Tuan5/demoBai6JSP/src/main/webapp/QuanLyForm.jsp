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
    <title>Quản lý tin tức</title>
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

        /* Nút Xóa */
        .btn-delete {
            background-color: #f06292; /* Hồng tươi */
            color: #ffffff;
            border: none;
            padding: 6px 14px;
            border-radius: 4px;
            cursor: pointer;
            font-size: 13px;
            font-weight: bold;
            transition: background 0.2s;
        }

        .btn-delete:hover {
            background-color: #d81b60; /* Hồng đậm khi di chuột */
        }
    </style>
</head>

<body>

<div class="container">

    <h1>QUẢN LÝ TIN TỨC</h1>

    <nav>
        <a href="${pageContext.request.contextPath}/danh-sach-tin-tuc">Danh sách</a>
        <a href="${pageContext.request.contextPath}/tin-tuc-form">Thêm tin</a>
        <a href="${pageContext.request.contextPath}/quan-ly-form">Quản lý</a>
    </nav>

    <h2>Danh sách tin tức</h2>

    <table>
        <thead>
        <tr>
            <th>Mã TT</th>
            <th>Tiêu đề</th>
            <th>Nội dung</th>
            <th>Danh mục</th>
            <th>Thao tác</th>
        </tr>
        </thead>

        <tbody>
        <c:forEach var="tin" items="${danhSachTin}">
            <tr>
                <td>${tin.maTinTuc}</td>
                <td>${tin.tieuDe}</td>
                <td>${tin.noiDungTinTuc}</td>
                <td>${tin.maDM}</td>
                <td>
                    <form action="${pageContext.request.contextPath}/quan-ly-form"
                          method="post"
                          onsubmit="return confirm('Bạn có chắc muốn xóa tin này?')">

                        <input type="hidden" name="maTinTuc" value="${tin.maTinTuc}">

                        <button type="submit" class="btn-delete">
                            Xóa
                        </button>

                    </form>
                </td>
            </tr>
        </c:forEach>
        </tbody>
    </table>

</div>

</body>
</html>