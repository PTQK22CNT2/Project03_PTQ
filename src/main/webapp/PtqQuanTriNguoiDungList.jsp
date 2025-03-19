<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="java.util.List" %>
<%@ page import="PTQ_model.User_PTQ" %>
<!DOCTYPE html>
<html lang="vi">
<head>
    <meta charset="UTF-8">
    <title>Quản trị Người Dùng</title>
    <!-- Bootstrap 5 CSS -->
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css">
</head>
<body>
<div class="container mt-5">
    <h2 class="mb-4">Danh sách Người Dùng</h2>
    <div class="mb-3">
        <a href="PtqQuanTriNguoiDungServlet?action=new" class="btn btn-success">Thêm mới</a>
    </div>
    <table class="table table-bordered">
        <thead class="table-light">
            <tr>
                <th>ID</th>
                <th>Họ và Tên</th>
                <th>Email</th>
                <th>Vai trò</th>
                <th>Hành động</th>
            </tr>
        </thead>
        <tbody>
            <%
                List<User_PTQ> listUser = (List<User_PTQ>) request.getAttribute("listUser");
                if(listUser != null){
                    for(User_PTQ user : listUser){
            %>
            <tr>
                <td><%= user.getId() %></td>
                <td><%= user.getPtqHoTen() %></td>
                <td><%= user.getPtqEmail() %></td>
                <td><%= user.getPtqVaiTro() %></td>
                <td>
                    <a href="PtqQuanTriNguoiDungServlet?action=edit&id=<%= user.getId() %>" class="btn btn-warning btn-sm">Sửa</a>
                    <a href="PtqQuanTriNguoiDungServlet?action=delete&id=<%= user.getId() %>" 
                       class="btn btn-danger btn-sm" 
                       onclick="return confirm('Bạn có chắc muốn xóa người dùng này?');">
                       Xóa
                    </a>
                </td>
            </tr>
            <%
                    }
                }
            %>
        </tbody>
    </table>
</div>
<!-- Bootstrap 5 JS Bundle -->
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/js/bootstrap.bundle.min.js"></script>
</body>
</html>
