<%@ page contentType="text/html; charset=UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>Danh sách Công Văn</title>
    <meta charset="UTF-8">
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css">
</head>
<body class="container mt-4">
    <h2 class="text-center">Danh sách Công Văn</h2>
    <div class="d-flex justify-content-between mb-3">
        <a href="PtqCongVanServlet?action=new" class="btn btn-success">Thêm Công Văn</a>
        <a href="index.jsp" class="btn btn-secondary">Trang Chủ</a>
    </div>
    <table class="table table-bordered table-striped">
        <thead class="table-dark">
            <tr>
                <th>ID</th>
                <th>Số Hiệu</th>
                <th>Tiêu Đề</th>
                <th>Ngày Ban Hành</th>
                <th>Loại</th>
                <th>Trạng Thái</th>
                <th>Hành Động</th>
            </tr>
        </thead>
        <tbody>
            <c:forEach var="congVan" items="${listCongVan}">
                <tr>
                    <td>${congVan.id}</td>
                    <td>${congVan.soHieu}</td>
                    <td>${congVan.tieuDe}</td>
                    <td>${congVan.ngayBanHanh}</td>
                    <td>${congVan.loaiCongVan}</td>
                    <td>${congVan.trangThai}</td>
                    <td>
                        <a href="PtqCongVanServlet?action=edit&id=${congVan.id}" class="btn btn-warning btn-sm">Sửa</a>
                        <a href="PtqCongVanServlet?action=delete&id=${congVan.id}" class="btn btn-danger btn-sm"
                           onclick="return confirm('Bạn có chắc muốn xóa?');">Xóa</a>
                    </td>
                </tr>
            </c:forEach>
        </tbody>
    </table>
</body>
</html>
