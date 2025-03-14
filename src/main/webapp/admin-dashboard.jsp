<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Admin Dashboard</title>
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css">
</head>
<body>
    <nav class="navbar navbar-expand-lg navbar-dark bg-primary">
        <div class="container">
            <a class="navbar-brand" href="#">Quản Lý Công Văn</a>
            <button class="navbar-toggler" type="button" data-bs-toggle="collapse" data-bs-target="#navbarNav">
                <span class="navbar-toggler-icon"></span>
            </button>
            <div class="collapse navbar-collapse" id="navbarNav">
                <ul class="navbar-nav ms-auto">
                    <li class="nav-item">
                        <a class="nav-link" href="user-dashboard.jsp">Trang Chủ</a>
                    </li>
                    <li class="nav-item">
                        <a class="nav-link" href="PTQ_admin_danhSachCongVan.jsp">Danh Sách Công Văn</a>
                    </li>
                    <li class="nav-item">
                        <a class="nav-link btn btn-danger text-white" href="LogoutServlet">Đăng Xuất</a>
                    </li>
                </ul>
            </div>
        </div>
    </nav>

    <div class="container mt-5">
        <div class="card p-4 shadow-sm">
            <h2>Chào mừng <strong><%= session.getAttribute("userEmail") %></strong></h2>
            <p><strong>Vai trò:</strong> <%= session.getAttribute("userRole") %></p>
            <hr>
            <p>Vui lòng chọn chức năng ở menu trên.</p>
        </div>
    </div>

    <footer class="bg-primary text-white text-center py-3 mt-5">
        &copy; 2025 - Quản Lý Công Văn
    </footer>

    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/js/bootstrap.bundle.min.js"></script>
</body>
</html>
