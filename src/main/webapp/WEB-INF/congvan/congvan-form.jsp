<%@ page contentType="text/html; charset=UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>Quản lý Công Văn</title>
    <meta charset="UTF-8">
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css">
</head>
<body class="container mt-4">
    <h2 class="text-center">${congVan != null ? "Chỉnh Sửa" : "Thêm"} Công Văn</h2>
    <form action="PtqCongVanServlet?action=save" method="post" class="border p-4">
        <input type="hidden" name="id" value="${congVan.id}">

        <div class="mb-3">
            <label class="form-label">Số Hiệu</label>
            <input type="text" name="soHieu" class="form-control" value="${congVan.soHieu}" required>
        </div>

        <div class="mb-3">
            <label class="form-label">Tiêu Đề</label>
            <input type="text" name="tieuDe" class="form-control" value="${congVan.tieuDe}" required>
        </div>

        <div class="mb-3">
            <label class="form-label">Ngày Ban Hành</label>
            <input type="date" name="ngayBanHanh" class="form-control" value="${congVan.ngayBanHanh}" required>
        </div>

        <div class="mb-3">
            <label class="form-label">Loại Công Văn</label>
            <input type="text" name="loaiCongVan" class="form-control" value="${congVan.loaiCongVan}" required>
        </div>

        <div class="mb-3">
            <label class="form-label">Trạng Thái</label>
            <select name="trangThai" class="form-select">
                <option value="Đã xử lý" ${congVan.trangThai == 'Đã xử lý' ? 'selected' : ''}>Đã xử lý</option>
                <option value="Chưa xử lý" ${congVan.trangThai == 'Chưa xử lý' ? 'selected' : ''}>Chưa xử lý</option>
            </select>
        </div>

        <div class="d-flex justify-content-between">
            <button type="submit" class="btn btn-primary">Lưu</button>
            <a href="PtqCongVanServlet?action=list" class="btn btn-secondary">Hủy</a>
        </div>
    </form>
</body>
</html>
