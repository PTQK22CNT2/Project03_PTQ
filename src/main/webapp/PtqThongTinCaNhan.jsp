<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ page import="PTQ_model.User_PTQ" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Thông Tin Cá Nhân</title>
    <!-- Bootstrap CSS -->
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
</head>
<body>
<div class="container mt-4">
    <h2>Thông Tin Cá Nhân</h2>
    <% 
        String message = (String) request.getAttribute("message");
        if(message != null){
    %>
        <div class="alert alert-success"><%= message %></div>
    <% } %>
    <%
        User_PTQ user = (User_PTQ) request.getAttribute("user");
        if(user != null) {
    %>
    <form action="PtqThongTinCaNhanServlet" method="post">
        <div class="form-group">
            <label>Email (không thay đổi)</label>
            <input type="email" class="form-control" name="ptqEmail" value="<%= user.getPtqEmail() %>" readonly>
        </div>
        <div class="form-group">
            <label>Họ và Tên</label>
            <input type="text" class="form-control" name="ptqHoTen" value="<%= user.getPtqHoTen() %>" required>
        </div>
        <div class="form-group">
            <label>Mật Khẩu (nhập vào nếu muốn thay đổi)</label>
            <input type="password" class="form-control" name="ptqMatKhau">
        </div>
        <button type="submit" class="btn btn-primary">Cập nhật</button>
    </form>
    <% } else { %>
         <div class="alert alert-danger">Không tìm thấy thông tin người dùng!</div>
    <% } %>
</div>
<!-- Bootstrap JS -->
<script src="https://code.jquery.com/jquery-3.5.1.slim.min.js"></script>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@4.5.2/dist/js/bootstrap.bundle.min.js"></script>
</body>
</html>
