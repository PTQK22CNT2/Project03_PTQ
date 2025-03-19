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
    
    <!-- Bootstrap 5.3.0 CSS -->
    <link rel="stylesheet" 
          href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css">
    <!-- Bootstrap Icons (tùy chọn) -->
    <link rel="stylesheet" 
          href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.10.3/font/bootstrap-icons.css">
    
    <!-- Home CSS -->
    <link rel="stylesheet" href="css/home.css">
</head>
<body>
    <!-- Navbar -->
    <nav class="navbar navbar-expand-lg navbar-dark bg-dark">
        <div class="container">
            <a class="navbar-brand" href="#">Quản Lý Công Văn</a>
            <button class="navbar-toggler" type="button" data-bs-toggle="collapse" data-bs-target="#navbarNav">
                <span class="navbar-toggler-icon"></span>
            </button>
            <!-- Menu -->
            <div class="collapse navbar-collapse" id="navbarNav">
                <ul class="navbar-nav ms-auto">
                    <!-- Đăng nhập (nút màu xanh dương) -->
                    <li class="nav-item me-2">
                        <a class="btn btn-primary" href="login.jsp">Đăng Nhập</a>
                    </li>
                    <!-- Đăng ký (nút màu xanh lá) -->
                    <li class="nav-item">
                        <a class="btn btn-success" href="register.jsp">Đăng Ký</a>
                    </li>
                </ul>
            </div>
        </div>
    </nav>
    
    <!-- Hero Section -->
    <div class="hero d-flex align-items-center">
        <div class="hero-overlay"></div>
        <div class="container text-center hero-content">
            <h1 class="display-4">Chào mừng đến với Hệ thống Quản Lý Công Văn</h1>
            <p class="lead">
                Quản lý công văn đến và đi một cách hiệu quả, bảo mật và trực quan.
            </p>
        </div>
    </div>
    
    <!-- Features Section -->
    <div class="container my-5">
        <div class="row text-center">
            <div class="col-md-4 mb-4">
                <i class="bi bi-search" style="font-size: 3rem; color: #0d6efd;"></i>
                <h4 class="mt-3">Tìm kiếm nhanh</h4>
                <p>Dễ dàng tìm kiếm công văn theo từ khóa, ngày tháng và tiêu chí khác.</p>
            </div>
            <div class="col-md-4 mb-4">
                <i class="bi bi-file-earmark-text" style="font-size: 3rem; color: #198754;"></i>
                <h4 class="mt-3">Quản lý hiệu quả</h4>
                <p>Lưu trữ, phân loại và xử lý công văn một cách trực quan và nhanh chóng.</p>
            </div>
            <div class="col-md-4 mb-4">
                <i class="bi bi-shield-lock" style="font-size: 3rem; color: #dc3545;"></i>
                <h4 class="mt-3">Bảo mật cao</h4>
                <p>Hệ thống hỗ trợ đăng nhập nhiều cấp độ và phân quyền người dùng an toàn.</p>
            </div>
        </div>
    </div>
    
    <!-- Giới thiệu thêm -->
    <div class="container my-5">
        <div class="row align-items-center">
            <div class="col-md-6">
                <h2>Tại sao chọn chúng tôi?</h2>
                <p>
                    Với giao diện thân thiện và các tính năng tiên tiến, hệ thống của chúng tôi giúp bạn quản lý công văn một cách thông minh, giảm thiểu thời gian xử lý và tối ưu hóa hiệu quả công việc.
                </p>
                <ul>
                    <li>Quản lý công văn đến và đi hiệu quả.</li>
                    <li>Tìm kiếm và phân loại nhanh chóng.</li>
                    <li>Bảo mật thông tin với phân quyền rõ ràng.</li>
                    <li>Giao diện hiện đại, dễ sử dụng.</li>
                </ul>
            </div>
            <div class="col-md-6">
                <!-- Có thể thêm ảnh minh họa ở đây -->
            </div>
        </div>
    </div>
    
    <!-- Footer -->
    <footer class="bg-dark text-white text-center py-4">
        <div class="container">
            <p>&copy; 2025 - Quản Lý Công Văn</p>
            <p>
                Liên hệ:
                <a href="tel:+84901234567" class="text-white text-decoration-none">+84 901 234 567</a> |
                <a href="mailto:support@quanlycongvan.com" class="text-white text-decoration-none">support@quanlycongvan.com</a>
            </p>
        </div>
    </footer>
    
    <!-- Bootstrap 5.3.0 JS Bundle -->
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/js/bootstrap.bundle.min.js"></script>
</body>
</html>
