<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="PTQ_model.User_PTQ" %>
<!DOCTYPE html>
<html lang="vi">
<head>
    <meta charset="UTF-8">
    <title>Thêm/Sửa Người Dùng</title>
    <!-- Bootstrap 5 CSS -->
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css">
</head>
<body>
<div class="container mt-5">
    <%
        // Lấy đối tượng user từ request nếu có, dùng để xác định chỉnh sửa hay thêm mới
        User_PTQ user = (User_PTQ) request.getAttribute("user");
        boolean isEdit = (user != null);
        String pageTitle = isEdit ? "Sửa Người Dùng" : "Thêm Người Dùng";
    %>
    <h2 class="mb-4"><%= pageTitle %></h2>
    <form action="PtqQuanTriNguoiDungServlet" method="post">
        <!-- Xác định action insert/update -->
        <input type="hidden" name="action" value="<%= isEdit ? "update" : "insert" %>">
        <% if(isEdit) { %>
            <input type="hidden" name="id" value="<%= user.getId() %>">
        <% } %>
        <div class="mb-3">
            <label for="ptqHoTen" class="form-label">Họ và Tên</label>
            <input type="text" class="form-control" id="ptqHoTen" name="ptqHoTen" value="<%= isEdit ? user.getPtqHoTen() : "" %>" required>
        </div>
        <div class="mb-3">
            <label for="ptqEmail" class="form-label">Email</label>
            <input type="email" class="form-control" id="ptqEmail" name="ptqEmail" value="<%= isEdit ? user.getPtqEmail() : "" %>" required <%= isEdit ? "readonly" : "" %>>
        </div>
        <div class="mb-3">
            <label for="ptqMatKhau" class="form-label">Mật khẩu</label>
            <input type="password" class="form-control" id="ptqMatKhau" name="ptqMatKhau" required>
        </div>
        <div class="mb-3">
            <label for="ptqVaiTro" class="form-label">Vai trò</label>
            <select class="form-select" id="ptqVaiTro" name="ptqVaiTro" required>
                <option value="Admin" <%= (isEdit && "Admin".equals(user.getPtqVaiTro())) ? "selected" : "" %>>Admin</option>
                <option value="Nhân viên" <%= (isEdit && "Nhân viên".equals(user.getPtqVaiTro())) ? "selected" : "" %>>Nhân viên</option>
            </select>
        </div>
        <button type="submit" class="btn btn-primary w-100"><%= isEdit ? "Cập nhật" : "Thêm mới" %></button>
        <a href="PtqQuanTriNguoiDungServlet?action=list" class="btn btn-secondary w-100 mt-2">Hủy</a>
    </form>
</div>
<!-- Bootstrap 5 JS Bundle -->
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/js/bootstrap.bundle.min.js"></script>
</body>
</html>
