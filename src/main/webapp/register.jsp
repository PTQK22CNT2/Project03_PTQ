<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Đăng Ký</title>
    <!-- Bootstrap 5.3.0 CSS -->
    <link rel="stylesheet" 
          href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css">
</head>
<body class="d-flex justify-content-center align-items-center vh-100">

    <div class="card p-4 shadow" style="width: 350px;">
        <h3 class="text-center">Đăng Ký Tài Khoản</h3>
        
        <!-- Hiển thị lỗi nếu có -->
        <%
            String error = request.getParameter("error");
            if ("1".equals(error)) {
        %>
            <div class="alert alert-danger">
                Đăng ký thất bại! Vui lòng thử lại.
            </div>
        <%
            }
        %>

        <form action="RegisterServlet" method="post">
            <div class="mb-3">
                <label for="ptqHoTen" class="form-label">Họ và Tên</label>
                <input type="text" class="form-control" name="ptqHoTen" id="ptqHoTen" required>
            </div>
            <div class="mb-3">
                <label for="ptqEmail" class="form-label">Email</label>
                <input type="email" class="form-control" name="ptqEmail" id="ptqEmail" required>
            </div>
            <div class="mb-3">
                <label for="ptqMatKhau" class="form-label">Mật khẩu</label>
                <input type="password" class="form-control" name="ptqMatKhau" id="ptqMatKhau" required>
            </div>
            <div class="mb-3">
                <label for="ptqVaiTro" class="form-label">Vai trò</label>
                <select class="form-select" name="ptqVaiTro" id="ptqVaiTro">
                    <option value="Nhân viên">Nhân viên</option>
                    <option value="Admin">Admin</option>
                </select>
            </div>
            <button type="submit" class="btn btn-primary w-100">Đăng Ký</button>
        </form>

        <!-- Link Đăng nhập -->
        <p class="text-center mt-3">
            Đã có tài khoản? <a href="login.jsp" style="color: blue; text-decoration: none;">Đăng nhập ngay</a>
        </p>
    </div>

</body>
</html>
