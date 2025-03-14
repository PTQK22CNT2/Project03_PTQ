<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ page import="PTQ_model.PtqCongVan, PTQ_dao.PtqCongVanDAO" %>
<%@ page import="java.util.*" %>
<!DOCTYPE html>
<html>
<head>
    <title>Quản Lý Công Văn</title>
    <!-- Bootstrap 4.5.2 CSS -->
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
</head>
<body>
    <div class="container mt-4">
        <h2 class="text-center">Danh Sách Công Văn</h2>

        <!-- Form tìm kiếm công văn theo ID -->
        <form action="PTQ_admin_danhSachCongVan.jsp" method="get" class="mb-3">
            <div class="form-group">
                <label for="id">Tìm Công Văn Theo ID:</label>
                <input type="number" class="form-control" name="id" required>
            </div>
            <button type="submit" class="btn btn-primary">Tìm Kiếm</button>
        </form>

        <hr>

        <!-- Nút Thêm mới -->
        <div class="mb-3">
            <!-- Giả sử bạn có servlet Ptq_admin_CongVanServlet xử lý action=new -->
            <a href="Ptq_admin_CongVanServlet?action=new" class="btn btn-success">Thêm mới</a>
        </div>

        <%
            // Kiểm tra nếu có yêu cầu tìm kiếm công văn theo ID
            String idParam = request.getParameter("id");
            if (idParam != null && !idParam.isEmpty()) {
                try {
                    int id = Integer.parseInt(idParam);
                    PtqCongVanDAO dao = new PtqCongVanDAO();
                    PtqCongVan cv = dao.getCongVanByID(id);

                    if (cv != null) {
        %>
                        <h3>Chi Tiết Công Văn</h3>
                        <table class="table table-bordered">
                            <tr><th>ID</th><td><%= cv.getId() %></td></tr>
                            <tr><th>Số Hiệu</th><td><%= cv.getPtqSoHieu() %></td></tr>
                            <tr><th>Tiêu Đề</th><td><%= cv.getPtqTieuDe() %></td></tr>
                            <tr><th>Nội Dung</th><td><%= cv.getPtqNoiDung() %></td></tr>
                            <tr><th>Ngày Ban Hành</th><td><%= cv.getPtqNgayBanHanh() %></td></tr>
                            <tr><th>Loại Công Văn</th><td><%= cv.getPtqLoaiCongVan() %></td></tr>
                            <tr><th>Trạng Thái</th><td><%= cv.getPtqTrangThai() %></td></tr>
                            <tr><th>Tài Liệu Đính Kèm</th><td><%= cv.getPtqTaiLieuDinhKem() %></td></tr>
                        </table>
        <%
                    } else {
        %>
                        <p class="text-danger">Không tìm thấy công văn có ID = <%= id %></p>
        <%
                    }
                } catch (NumberFormatException e) {
        %>
                    <p class="text-danger">ID không hợp lệ!</p>
        <%
                }
            }
        %>

        <hr>

        <h3>Danh Sách Tất Cả Công Văn</h3>
        <table class="table table-bordered">
            <thead>
                <tr>
                    <th>ID</th>
                    <th>Số Hiệu</th>
                    <th>Tiêu Đề</th>
                    <th>Ngày Ban Hành</th>
                    <th>Trạng Thái</th>
                    <th>Chi Tiết</th>
                    <!-- Thêm cột Sửa và Xóa -->
                    <th>Sửa</th>
                    <th>Xóa</th>
                </tr>
            </thead>
            <tbody>
                <%
                    PtqCongVanDAO dao = new PtqCongVanDAO();
                    List<PtqCongVan> danhSachCongVan = dao.getAllCongVan();

                    for (PtqCongVan cv : danhSachCongVan) {
                %>
                    <tr>
                        <td><%= cv.getId() %></td>
                        <td><%= cv.getPtqSoHieu() %></td>
                        <td><%= cv.getPtqTieuDe() %></td>
                        <td><%= cv.getPtqNgayBanHanh() %></td>
                        <td><%= cv.getPtqTrangThai() %></td>
                        <td>
                            <!-- Nút Xem chi tiết cũ của bạn -->
                            <a href="PTQ_admin_danhSachCongVan.jsp?id=<%= cv.getId() %>" class="btn btn-info">Xem</a>
                        </td>
                        <!-- Nút Sửa: Gọi servlet Ptq_admin_CongVanServlet?action=edit -->
                        <td>
                            <a href="Ptq_admin_CongVanServlet?action=edit&id=<%= cv.getId() %>"
                               class="btn btn-warning">
                                Sửa
                            </a>
                        </td>
                        <!-- Nút Xóa: Gọi servlet Ptq_admin_CongVanServlet?action=delete -->
                        <td>
                            <a href="Ptq_admin_CongVanServlet?action=delete&id=<%= cv.getId() %>"
                               class="btn btn-danger"
                               onclick="return confirm('Bạn có chắc chắn muốn xóa công văn này không?');">
                                Xóa
                            </a>
                        </td>
                    </tr>
                <%
                    }
                %>
            </tbody>
        </table>

    </div>

    <!-- Bootstrap 4.5.2 JS (tuỳ chọn nếu cần) -->
    <script src="https://code.jquery.com/jquery-3.5.1.slim.min.js"></script>
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@4.5.2/dist/js/bootstrap.bundle.min.js"></script>
</body>
</html>
