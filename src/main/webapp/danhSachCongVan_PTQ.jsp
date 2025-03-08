<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ page import="java.util.List" %>
<%@ page import="model_PTQ.PtqCongVan" %>
<!DOCTYPE html>
<html lang="vi">
<head>
    <meta charset="UTF-8">
    <title>Danh Sách Công Văn</title>
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css">
    <script>
        function searchTable() {
            var input, filter, table, tr, td, i, j, txtValue;
            input = document.getElementById("searchInput");
            filter = input.value.toUpperCase();
            table = document.getElementById("congVanTable");
            tr = table.getElementsByTagName("tr");

            for (i = 1; i < tr.length; i++) {
                tr[i].style.display = "none";
                td = tr[i].getElementsByTagName("td");
                for (j = 0; j < td.length; j++) {
                    if (td[j]) {
                        txtValue = td[j].textContent || td[j].innerText;
                        if (txtValue.toUpperCase().indexOf(filter) > -1) {
                            tr[i].style.display = "";
                            break;
                        }
                    }
                }
            }
        }
    </script>
</head>
<body>
    <div class="container mt-4">
        <h2 class="text-center">Danh Sách Công Văn</h2>
        
        <!-- Ô tìm kiếm -->
        <div class="mb-3">
            <input type="text" id="searchInput" class="form-control" placeholder="Nhập từ khóa tìm kiếm..." onkeyup="searchTable()">
        </div>

        <table id="congVanTable" class="table table-bordered table-striped">
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
                <%
                    List<PtqCongVan> danhSachCongVan = (List<PtqCongVan>) request.getAttribute("danhSachCongVan");
                    if (danhSachCongVan != null) {
                        for (PtqCongVan congVan : danhSachCongVan) {
                %>
                <tr>
                    <td><%= congVan.getId() %></td>
                    <td><%= congVan.getPtqSoHieu() %></td>
                    <td><%= congVan.getPtqTieuDe() %></td>
                    <td><%= congVan.getPtqNoiDung() %></td>
                    <td><%= congVan.getPtqNgayBanHanh() %></td>
                    <td><%= congVan.getPtqLoaiCongVan() %></td>
                    <td><%= congVan.getPtqTrangThai() %></td>
                    <td>
                        <% if (congVan.getPtqTaiLieuDinhKem() != null && !congVan.getPtqTaiLieuDinhKem().isEmpty()) { %>
                            <a href="<%= congVan.getPtqTaiLieuDinhKem() %>" target="_blank">Xem Tài Liệu</a>
                        <% } else { %>
                            Không có
                        <% } %>
                    </td>
                </tr>
                <% 
                        }
                    } else { 
                %>
                <tr>
                    <td colspan="8" class="text-center">Không có công văn nào</td>
                </tr>
                <% } %>
            </tbody>
        </table>
        <a href="home.jsp" class="btn btn-secondary">Quay lại</a>
    </div>
</body>
</html>
