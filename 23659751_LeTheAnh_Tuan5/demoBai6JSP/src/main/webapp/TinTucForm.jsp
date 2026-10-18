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
    <title>Thêm tin tức</title>
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

        /* Form thêm thường để khung hẹp hơn nhìn sẽ đẹp hơn */
        .container {
            max-width: 600px;
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

        /* Thông báo lỗi */
        .error {
            background-color: #fce4ec;
            color: #c62828;
            padding: 12px;
            border-radius: 4px;
            border: 1px solid #f8bbd0;
            margin-bottom: 20px;
            font-size: 14px;
        }

        /* Các nhóm input */
        .form-group {
            margin-bottom: 18px;
        }

        label {
            display: block;
            margin-bottom: 6px;
            color: #ad1457;
            font-weight: bold;
            font-size: 14px;
        }

        input[type="text"],
        input[type="number"],
        textarea,
        select {
            width: 100%;
            padding: 10px;
            border: 1px solid #f8bbd0;
            border-radius: 4px;
            box-sizing: border-box;
            font-family: inherit;
            font-size: 14px;
            transition: all 0.2s;
        }

        /* Hiệu ứng khi click vào ô nhập liệu */
        input:focus,
        textarea:focus,
        select:focus {
            outline: none;
            border-color: #d81b60;
            box-shadow: 0 0 4px rgba(216, 27, 96, 0.2);
        }

        textarea {
            height: 120px;
            resize: vertical; /* Chỉ cho phép kéo dãn chiều cao */
        }

        /* Nút bấm */
        .button-group {
            margin-top: 25px;
            text-align: right;
        }

        button, .btn {
            display: inline-block;
            padding: 10px 24px;
            border-radius: 4px;
            font-size: 14px;
            font-weight: bold;
            cursor: pointer;
            text-decoration: none;
            text-align: center;
            transition: all 0.2s;
        }

        /* Nút Thêm */
        button[type="submit"] {
            background-color: #f06292;
            color: #ffffff;
            border: 1px solid #f06292;
        }

        button[type="submit"]:hover {
            background-color: #d81b60;
            border-color: #d81b60;
        }

        /* Nút Hủy */
        .btn {
            background-color: #ffffff;
            color: #d81b60;
            border: 1px solid #d81b60;
            margin-left: 10px;
        }

        .btn:hover {
            background-color: #fce4ec;
        }
    </style>
</head>

<body>

<div class="container">

    <h1>THÊM TIN TỨC</h1>

    <c:if test="${not empty error}">
        <div class="error">
                ${error}
        </div>
    </c:if>

    <form action="${pageContext.request.contextPath}/tin-tuc-form"
          method="post"
          onsubmit="return validateForm()">

        <div class="form-group">
            <label>Mã tin tức:</label>
            <input type="number" id="maTinTuc" name="maTinTuc" placeholder="Nhập mã số...">
        </div>

        <div class="form-group">
            <label>Tiêu đề:</label>
            <input type="text" id="tieuDe" name="tieuDe" placeholder="Nhập tiêu đề tin...">
        </div>

        <div class="form-group">
            <label>Nội dung:</label>
            <textarea id="noiDungTinTuc" name="noiDungTinTuc" placeholder="Nhập nội dung tóm tắt..."></textarea>
        </div>

        <div class="form-group">
            <label>Liên kết:</label>
            <input type="text" id="lienKet" name="lienKet" placeholder="http://example.com">
        </div>

        <div class="form-group">
            <label>Danh mục:</label>
            <select id="maDM" name="maDM">
                <option value="">-- Chọn danh mục --</option>
                <c:forEach var="dm" items="${danhSachDanhMuc}">
                    <option value="${dm.maDM}">
                            ${dm.tenDanhMuc}
                    </option>
                </c:forEach>
            </select>
        </div>

        <div class="button-group">
            <button type="submit">Thêm</button>
            <a class="btn" href="${pageContext.request.contextPath}/danh-sach-tin-tuc">Hủy</a>
        </div>

    </form>

</div>

<script>
    function validateForm() {
        const maTinTuc = document.getElementById("maTinTuc").value.trim();
        const tieuDe = document.getElementById("tieuDe").value.trim();
        const noiDung = document.getElementById("noiDungTinTuc").value.trim();
        const lienKet = document.getElementById("lienKet").value.trim();
        const maDM = document.getElementById("maDM").value;

        // Bắt buộc nhập
        if (maTinTuc === "" || tieuDe === "" || noiDung === "" || lienKet === "" || maDM === "") {
            alert("Vui lòng nhập đầy đủ thông tin!");
            return false;
        }

        // Link phải bắt đầu bằng http://
        const regexURL = /^http:\/\/.+$/;
        if (!regexURL.test(lienKet)) {
            alert("Liên kết phải bắt đầu bằng http://");
            return false;
        }

        // Nội dung không quá 255 ký tự
        const regexNoiDung = /^.{1,255}$/s;
        if (!regexNoiDung.test(noiDung)) {
            alert("Nội dung không được vượt quá 255 ký tự!");
            return false;
        }

        return true;
    }
</script>

</body>
</html>