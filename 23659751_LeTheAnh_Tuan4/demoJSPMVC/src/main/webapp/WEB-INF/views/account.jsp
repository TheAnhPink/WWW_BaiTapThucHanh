<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>
<%@ taglib prefix="fmt" uri="jakarta.tags.fmt" %>
<!DOCTYPE html>
<html lang="vi">
<head>
    <meta charset="UTF-8">
    <title>Danh sách tài khoản</title>
    <link href="https://jsdelivr.net" rel="stylesheet">
    <style>
        body { background-color: #f8f9fa; padding-top: 30px; }
        .table-container { background: #ffffff; padding: 25px; border-radius: 8px; box-shadow: 0 4px 6px rgba(0,0,0,0.05); }
        .table th { background-color: #0d6efd; color: white; }
    </style>
</head>
<body>

<div class="container">
    <div class="table-container">

        <div class="d-flex justify-content-between align-items-center mb-4">
            <h2 class="text-dark font-weight-bold">Danh Sách Tài Khoản Đăng Ký</h2>
            <a href="${pageContext.request.contextPath}/registerform" class="btn btn-outline-primary">
                + Thêm tài khoản mới
            </a>
        </div>

        <div class="alert alert-success alert-dismissible fade show" role="alert">
            <strong>Thành công!</strong> Đã thêm tài khoản mới vào cơ sở dữ liệu.
            <button type="button" class="btn-close" data-bs-dismiss="alert" aria-label="Close"></button>
        </div>

        <div class="table-responsive">
            <table class="table table-striped table-hover align-middle border text-center">
                <thead>
                <tr>
                    <th scope="col" style="width: 8%;">ID</th>
                    <th scope="col">Họ và Tên</th>
                    <th scope="col">Email</th>
                    <th scope="col">Ngày sinh</th>
                    <th scope="col">Mật khẩu</th>
                </tr>
                </thead>
                <tbody>
                <c:if test="${empty accounts}">
                    <tr>
                        <td colspan="5" class="text-muted py-4">Không có tài khoản nào trong hệ thống.</td>
                    </tr>
                </c:if>

                <c:forEach var="acc" items="${accounts}">
                    <tr>
                        <th scope="row">${acc.id}</th>
                        <td class="text-start">${acc.firstname} ${acc.lastname}</td>
                        <td class="text-start">${acc.email}</td>
                        <td>
                            <fmt:formatDate value="${acc.dateOfBirth}" pattern="dd/MM/yyyy" />
                        </td>
                        <td>
                            <span class="text-muted">••••••••</span>
                        </td>
                    </tr>
                </c:forEach>
                </tbody>
            </table>
        </div>

    </div>
</div>

<script src="https://jsdelivr.net"></script>
</body>
</html>
