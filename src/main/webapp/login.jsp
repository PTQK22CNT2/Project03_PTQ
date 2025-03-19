<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Đăng nhập</title>
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css">
</head>
<body class="d-flex justify-content-center align-items-center vh-100">

    <div class="card p-4 shadow" style="width: 350px;">
        <h3 class="text-center">Đăng nhập</h3>
        <form action="LoginServlet_PTQ" method="post">
            <div class="mb-3">
                <label for="email" class="form-label">Email</label>
                <input type="email" class="form-control" id="email" name="email" required>
            </div>
            <div class="mb-3">
                <label for="password" class="form-label">Mật khẩu</label>
                <input type="password" class="form-control" id="password" name="password" required>
            </div>
            <button type="submit" class="btn btn-primary w-100">Đăng nhập</button>
        </form>

        <!-- Hiển thị lỗi nếu có -->
        <p class="text-danger mt-2 text-center">
            <% if (request.getAttribute("errorMessage") != null) { %>
                <%= request.getAttribute("errorMessage") %>
            <% } %>
        </p>

        <!-- Link Đăng ký -->
        <p class="text-center mt-3">
            Chưa có tài khoản? <a href="register.jsp" style="color: blue; text-decoration: none;">Đăng ký ngay</a>
        </p>
    </div>

</body>
</html>
