<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ page import="PTQ_model.PtqCongVan" %>
<!DOCTYPE html>
<html>
<head>
    <title>Thêm / Sửa Công Văn</title>
    <!-- Sử dụng Bootstrap 4.5.2 -->
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
</head>
<meta charset="UTF-8">
<body>
    <div class="container mt-4">
        <%
            // Lấy đối tượng congVan từ request nếu có (trường hợp sửa)
            PtqCongVan congVan = (PtqCongVan) request.getAttribute("congVan");
            boolean isEdit = (congVan != null);
            String formAction = isEdit ? "update" : "insert";
            String pageTitle  = isEdit ? "Sửa Công Văn" : "Thêm Công Văn";

            // Định dạng ngày ban hành theo định dạng yyyy-MM-dd (để phù hợp với input type="date")
            String ngayBanHanhStr = "";
            if (isEdit && congVan.getPtqNgayBanHanh() != null) {
                java.text.SimpleDateFormat sdf = new java.text.SimpleDateFormat("yyyy-MM-dd");
                ngayBanHanhStr = sdf.format(congVan.getPtqNgayBanHanh());
            }
        %>

        <h2 class="text-center"><%= pageTitle %></h2>
        <form action="Ptq_admin_CongVanServlet" method="post">
            <!-- Ẩn action để servlet biết ta đang insert hay update -->
            <input type="hidden" name="action" value="<%= formAction %>">
            <% if (isEdit) { %>
                <input type="hidden" name="id" value="<%= congVan.getId() %>">
            <% } %>

            <div class="form-group">
                <label>Số Hiệu</label>
                <input type="text" class="form-control" name="soHieu" value="<%= isEdit ? congVan.getPtqSoHieu() : "" %>" required>
            </div>
            <div class="form-group">
                <label>Tiêu Đề</label>
                <input type="text" class="form-control" name="tieuDe" value="<%= isEdit ? congVan.getPtqTieuDe() : "" %>" required>
            </div>
            <div class="form-group">
                <label>Nội Dung</label>
                <textarea class="form-control" name="noiDung" rows="4" required><%= isEdit ? congVan.getPtqNoiDung() : "" %></textarea>
            </div>
            <div class="form-group">
                <label>Ngày Ban Hành</label>
                <input type="date" class="form-control" name="ngayBanHanh" value="<%= ngayBanHanhStr %>" required>
            </div>
            <div class="form-group">
			    <label>Loại Công Văn</label>
			    <select class="form-control" name="loaiCongVan" required>
			        <option value="Đến"
			            <%= (isEdit && "Đến".equals(congVan.getPtqLoaiCongVan())) ? "selected" : "" %>>
			            Đến
			        </option>
			        <option value="Đi"
			            <%= (isEdit && "Đi".equals(congVan.getPtqLoaiCongVan())) ? "selected" : "" %>>
			            Đi
			        </option>
			    </select>
			</div>

           <div class="form-group">
			    <label>Trạng Thái</label>
			    <select class="form-control" name="trangThai" required>
			        <option value="Đang xử lý"
			            <%= (isEdit && "Đang xử lý".equals(congVan.getPtqTrangThai())) ? "selected" : "" %>>
			            Đang xử lý
			        </option>
			        <option value="Hoàn thành"
			            <%= (isEdit && "Hoàn thành".equals(congVan.getPtqTrangThai())) ? "selected" : "" %>>
			            Hoàn thành
			        </option>
			        <option value="Từ chối"
			            <%= (isEdit && "Từ chối".equals(congVan.getPtqTrangThai())) ? "selected" : "" %>>
			            Từ chối
			        </option>
			    </select>
			</div>


            <div class="form-group">
                <label>Tài Liệu Đính Kèm</label>
                <input type="text" class="form-control" name="taiLieu" value="<%= isEdit ? congVan.getPtqTaiLieuDinhKem() : "" %>" required>
            </div>

            <button type="submit" class="btn btn-primary"><%= isEdit ? "Cập Nhật" : "Thêm Mới" %></button>
            <a href="Ptq_admin_CongVanServlet?action=list" class="btn btn-secondary">Hủy</a>
        </form>
    </div>

    <!-- Bootstrap JS (tuỳ chọn) -->
    <script src="https://code.jquery.com/jquery-3.5.1.slim.min.js"></script>
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@4.5.2/dist/js/bootstrap.bundle.min.js"></script>
</body>
</html>
