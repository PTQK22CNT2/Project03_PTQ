<%@ page contentType="text/html; charset=UTF-8" %>
<%@ page pageEncoding="UTF-8" %>
<%@ page import="javax.servlet.http.HttpSession" %>

<%
    HttpSession sessionUser = request.getSession();
    String userEmail = (String) sessionUser.getAttribute("userEmail");
    String userRole = (String) sessionUser.getAttribute("userRole");
%>

<!DOCTYPE html>
<html lang="vi">
<head>
    <meta charset="UTF-8">
    <title>Trang Chủ - Quản Lý Công Văn</title>
    <link rel="stylesheet" href="css/style.css">
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css">
</head>
<body>
    <!-- Thanh Điều Hướng -->
    <nav class="navbar navbar-expand-lg navbar-dark bg-primary">
        <div class="container-fluid">
            <a class="navbar-brand" href="#">Quản Lý Công Văn</a>
            <div class="collapse navbar-collapse">
                <ul class="navbar-nav ms-auto">
                    <li class="nav-item"><a class="nav-link" href="home.jsp">Trang Chủ</a></li>

                    <% if (userEmail != null) { %>
                        <li class="nav-item"><a class="nav-link" href="#">Danh Sách Công Văn</a></li>
                        <li class="nav-item"><a class="nav-link text-danger fw-bold" href="logout.jsp">Đăng Xuất</a></li>
                    <% } else { %>
                        <li class="nav-item">
                            <a class="nav-link fw-bold" href="login.jsp" style="color: #FFD700 !important;">Đăng Nhập</a>
                        </li>
                        <li class="nav-item">
                            <a class="nav-link fw-bold" href="register.jsp" style="color: #FFD700 !important;">Đăng Ký</a>
                        </li>
                    <% } %>
                </ul>
            </div>
        </div>
    </nav>

    <!-- Nội Dung Chính -->
    <div class="container mt-4 text-center">
        <h2>Chào mừng đến với hệ thống Quản Lý Công Văn</h2>
        <p>Hệ thống giúp bạn quản lý công văn đến và đi một cách hiệu quả.</p>

        <% if (userEmail != null) { %>
            <div class="alert alert-success">
                <h4>Xin chào, <%= userEmail %>!</h4>
                <p>Vai trò của bạn: <strong><%= userRole %></strong></p>
            </div>
        <% } %>
    </div>

    <!-- Footer -->
    <footer class="bg-light text-center p-3 mt-4">
        <p>&copy; 2025 - PTQ_Project03 | Quản lý công văn hiệu quả</p>
    </footer>
</body>
</html>
