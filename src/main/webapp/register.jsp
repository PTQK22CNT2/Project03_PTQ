<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html lang="vi">
<head>
    <meta charset="UTF-8">
    <title>Đăng Ký</title>
    <link rel="stylesheet" href="style.css"> <!-- Thêm CSS nếu cần -->
</head>
<body>
    <h2>Đăng Ký Tài Khoản</h2>
    
    <%-- Hiển thị lỗi nếu có --%>
    <% String error = request.getParameter("error");
       if ("1".equals(error)) { %>
        <p style="color: red;">Đăng ký thất bại! Vui lòng thử lại.</p>
    <% } %>

    <form action="RegisterServlet" method="post">
        <label>Họ và Tên:</label>
        <input type="text" name="ptqHoTen" required>
        
        <label>Email:</label>
        <input type="email" name="ptqEmail" required>

        <label>Mật khẩu:</label>
        <input type="password" name="ptqMatKhau" required>

        <label>Vai trò:</label>
        <select name="ptqVaiTro">
            <option value="Nhân viên">Nhân viên</option>
            <option value="Admin">Admin</option>
        </select>

        <button type="submit">Đăng Ký</button>
    </form>
</body>
</html>
