<%@ page contentType="text/html; charset=UTF-8" language="java" %>
<%@ page import="java.util.List" %>
<%@ page import="PTQ_model.PtqCongVan" %>
<%@ page import="PTQ_dao.PtqCongVanDAO" %>
<%
    String keyword = request.getParameter("keyword");
    PtqCongVanDAO congVanDAO = new PtqCongVanDAO();
    List<PtqCongVan> danhSachCongVan;

    if (keyword != null && !keyword.trim().isEmpty()) {
        danhSachCongVan = congVanDAO.searchCongVanByTitle(keyword);
    } else {
        danhSachCongVan = congVanDAO.getAllCongVan();
    }
%>
<!DOCTYPE html>
<html lang="vi">
<head>
    <meta charset="UTF-8">
    <title>Danh Sách Công Văn</title>
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css">
</head>
<body>
    <div class="container mt-4">
        <h2 class="text-center">Danh Sách Công Văn</h2>

        <!-- Form tìm kiếm -->
        <form action="PTQ_user_danhSachCongVan.jsp" method="GET" class="mb-3">
            <div class="input-group">
                <input type="text" name="keyword" class="form-control" placeholder="Nhập tiêu đề công văn..." value="<%= (keyword != null) ? keyword : "" %>">
                <button type="submit" class="btn btn-primary">Tìm Kiếm</button>
            </div>
        </form>

        <!-- Hiển thị danh sách công văn -->
        <table class="table table-bordered">
            <thead class="table-dark">
                <tr>
                    <th>ID</th>
                    <th>Số Hiệu</th>
                    <th>Tiêu Đề</th>
                    <th>Nội Dung</th>
                    <th>Ngày Ban Hành</th>
                    <th>Loại Công Văn</th>
                    <th>Trạng Thái</th>
                    <th>Tài Liệu Đính Kèm</th>
                </tr>
            </thead>
            <tbody>
                <% if (danhSachCongVan.isEmpty()) { %>
                    <tr>
                        <td colspan="8" class="text-center text-danger">Không tìm thấy công văn nào!</td>
                    </tr>
                <% } else { 
                    for (PtqCongVan cv : danhSachCongVan) { %>
                    <tr>
                        <td><%= cv.getId() %></td>
                        <td><%= cv.getPtqSoHieu() %></td>
                        <td><%= cv.getPtqTieuDe() %></td>
                        <td><%= cv.getPtqNoiDung() %></td>
                        <td><%= cv.getPtqNgayBanHanh() %></td>
                        <td><%= cv.getPtqLoaiCongVan() %></td>
                        <td><%= cv.getPtqTrangThai() %></td>
                        <td>
                            <% if (cv.getPtqTaiLieuDinhKem() != null && !cv.getPtqTaiLieuDinhKem().isEmpty()) { %>
                                <a href="<%= cv.getPtqTaiLieuDinhKem() %>" target="_blank">Xem tài liệu</a>
                            <% } else { %>
                                Không có
                            <% } %>
                        </td>
                    </tr>
                <% } } %>
            </tbody>
        </table>
    </div>
</body>
</html>
