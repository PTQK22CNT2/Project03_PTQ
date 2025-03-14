<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ page import="PTQ_model.PtqCongVan" %>
<!DOCTYPE html>
<html>
<head>
    <title>Thêm / Sửa Công Văn</title>
    <!-- Sử dụng Bootstrap 4.5.2 -->
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
</head>
<body>
    <div class="container mt-4">
        <%
            // Lấy đối tượng congVan từ request nếu có (trường hợp sửa)
            PtqCongVan congVan = (PtqCongVan) request.getAttribute("congVan");
            boolean isEdit = (congVan != null);
            String formAction = isEdit ? "update" : "insert";
            String pageTitle  = isEdit ? "Sửa Công Văn" : "Thêm Công Văn";

            // Định dạng ngày ban hành theo định dạng yyyy-MM-dd (để phù hợp với input type="date")
            String ngayBanHanhStr = "";
            if (isEdit && congVan.getPtqNgayBanHanh() != null) {
                java.text.SimpleDateFormat sdf = new java.text.SimpleDateFormat("yyyy-MM-dd");
                ngayBanHanhStr = sdf.format(congVan.getPtqNgayBanHanh());
            }
        %>

        <h2 class="text-center"><%= pageTitle %></h2>
        <form action="Ptq_admin_CongVanServlet" method="post">
            <!-- Ẩn action để servlet biết ta đang insert hay update -->
            <input type="hidden" name="action" value="<%= formAction %>">
            <% if (isEdit) { %>
                <input type="hidden" name="id" value="<%= congVan.getId() %>">
            <% } %>

            <div class="form-group">
                <label>Số Hiệu</label>
                <input type="text" class="form-control" name="soHieu" value="<%= isEdit ? congVan.getPtqSoHieu() : "" %>" required>
            </div>
            <div class="form-group">
                <label>Tiêu Đề</label>
                <input type="text" class="form-control" name="tieuDe" value="<%= isEdit ? congVan.getPtqTieuDe() : "" %>" required>
            </div>
            <div class="form-group">
                <label>Nội Dung</label>
                <textarea class="form-control" name="noiDung" rows="4" required><%= isEdit ? congVan.getPtqNoiDung() : "" %></textarea>
            </div>
            <div class="form-group">
                <label>Ngày Ban Hành</label>
                <input type="date" class="form-control" name="ngayBanHanh" value="<%= ngayBanHanhStr %>" required>
            </div>
            <div class="form-group">
                <label>Loại Công Văn</label>
                <input type="text" class="form-control" name="loaiCongVan" value="<%= isEdit ? congVan.getPtqLoaiCongVan() : "" %>" required>
            </div>
            <div class="form-group">
                <label>Trạng Thái</label>
                <input type="text" class="form-control" name="trangThai" value="<%= isEdit ? congVan.getPtqTrangThai() : "" %>" required>
            </div>
            <div class="form-group">
                <label>Tài Liệu Đính Kèm</label>
                <input type="text" class="form-control" name="taiLieu" value="<%= isEdit ? congVan.getPtqTaiLieuDinhKem() : "" %>" required>
            </div>

            <button type="submit" class="btn btn-primary"><%= isEdit ? "Cập Nhật" : "Thêm Mới" %></button>
            <a href="Ptq_admin_CongVanServlet?action=list" class="btn btn-secondary">Hủy</a>
        </form>
    </div>

    <!-- Bootstrap JS (tuỳ chọn) -->
    <script src="https://code.jquery.com/jquery-3.5.1.slim.min.js"></script>
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@4.5.2/dist/js/bootstrap.bundle.min.js"></script>
</body>
</html>
