<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page session="true" %>
<%
    String userRole = (String) session.getAttribute("userRole");
    if (userRole != null) {
        if ("Admin".equals(userRole)) {
            response.sendRedirect("admin-dashboard.jsp");
        } else {
            response.sendRedirect("user-dashboard.jsp");
        }
    }
%>
<!DOCTYPE html>
<html lang="vi">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Trang Chủ - Quản Lý Công Văn</title>
    
    <!-- Import Bootstrap -->
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css">
    
    <!-- Import file home.css -->
    <link rel="stylesheet" href="css/home.css">
</head>
<body>

<!-- Thanh điều hướng góc trên bên phải -->
<div class="top-right">
    <a href="login.jsp" class="btn btn-primary me-2">Đăng Nhập</a>
    <a href="register.jsp" class="btn btn-success">Đăng Ký</a>
</div>

<!-- Nội dung chính -->
<div class="container content">
    <h2>Chào mừng bạn đến với hệ thống Quản Lý Công Văn</h2>
    <p>
        Hệ thống Quản Lý Công Văn giúp bạn theo dõi, lưu trữ và quản lý công văn đến và đi một cách hiệu quả.  
        Với các tính năng thông minh, bạn có thể dễ dàng tìm kiếm, phân loại và xử lý công văn nhanh chóng.  
        Hệ thống hỗ trợ đăng nhập nhiều cấp độ quyền hạn, giúp đảm bảo bảo mật và phân quyền hợp lý.  
        Dù bạn là quản trị viên hay nhân viên, hệ thống sẽ giúp bạn làm việc một cách hiệu quả hơn.  
    </p>
</div>

<!-- Thông tin liên lạc -->
<div class="footer">
    <p><strong>Liên hệ:</strong></p>
    <p>Số điện thoại: <a href="tel:+84901234567">+84 901 234 567</a></p>
    <p>Email: <a href="mailto:support@quanlycongvan.com">support@quanlycongvan.com</a></p>
</div>

</body>
</html>
