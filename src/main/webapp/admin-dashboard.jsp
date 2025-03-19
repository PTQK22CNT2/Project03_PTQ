<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Admin Dashboard</title>
    <!-- Bootstrap 5.3.0 CSS -->
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css">
</head>
<body>
    <!-- Thanh navbar màu tối (bg-dark) -->
    <nav class="navbar navbar-expand-lg navbar-dark bg-dark">
        <div class="container">
            <a class="navbar-brand" href="#">Quản Lý Công Văn</a>
            <button class="navbar-toggler" type="button" data-bs-toggle="collapse" data-bs-target="#navbarNav">
                <span class="navbar-toggler-icon"></span>
            </button>
            <!-- Menu -->
            <div class="collapse navbar-collapse" id="navbarNav">
                <ul class="navbar-nav ms-auto">
                    <!-- Link cập nhật thông tin cá nhân -->
                    <li class="nav-item me-2">
                        <a class="nav-link" href="PtqThongTinCaNhanServlet">
                            Cập nhật Thông tin Cá Nhân
                        </a>
                    </li>
                    <!-- Link quản trị người dùng -->
                    <li class="nav-item me-2">
                        <a class="nav-link" href="PtqQuanTriNguoiDungServlet?action=list">
                            Quản trị Người Dùng
                        </a>
                    </li>
                    <!-- Link danh sách công văn -->
                    <li class="nav-item me-2">
                        <a class="nav-link" href="PTQ_admin_danhSachCongVan.jsp">
                            Danh Sách Công Văn
                        </a>
                    </li>
                    <!-- Nút đăng xuất nổi bật -->
                    <li class="nav-item">
                        <a class="btn btn-danger" href="LogoutServlet">
                            Đăng Xuất
                        </a>
                    </li>
                </ul>
            </div>
        </div>
    </nav>

    <!-- Nội dung trang -->
    <div class="container mt-5">
        <div class="card p-4 shadow-sm">
            <h2>Chào mừng <strong><%= session.getAttribute("userEmail") %></strong></h2>
            <p><strong>Vai trò:</strong> <%= session.getAttribute("userRole") %></p>
            <hr>
            <p>Vui lòng chọn chức năng ở menu trên.</p>
        </div>
    </div>

    <!-- Footer -->
    <footer class="bg-dark text-white text-center py-3 mt-5">
        &copy; 2025 - Quản Lý Công Văn
    </footer>

    <!-- Bootstrap 5.3.0 JS Bundle -->
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/js/bootstrap.bundle.min.js"></script>
</body>
</html>
