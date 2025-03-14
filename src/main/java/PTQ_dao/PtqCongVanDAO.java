package PTQ_dao;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import PTQ_model.PtqCongVan;
import config.DBConnection;

public class PtqCongVanDAO {

    // Thêm công văn mới
    public boolean insertCongVan(PtqCongVan cv) {
        String sql = "INSERT INTO ptqcong_van (PtqSoHieu, PtqTieuDe, PtqNoiDung, PtqNgayBanHanh, PtqLoaiCongVan, PtqTrangThai, PtqTaiLieuDinhKem) VALUES (?, ?, ?, ?, ?, ?, ?)";
        try (Connection conn = DBConnection.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setString(1, cv.getPtqSoHieu());
            ps.setString(2, cv.getPtqTieuDe());
            ps.setString(3, cv.getPtqNoiDung());
            ps.setDate(4, cv.getPtqNgayBanHanh() != null ? new java.sql.Date(cv.getPtqNgayBanHanh().getTime()) : null);
            ps.setString(5, cv.getPtqLoaiCongVan());
            ps.setString(6, cv.getPtqTrangThai());
            ps.setString(7, cv.getPtqTaiLieuDinhKem());

            int rowsAffected = ps.executeUpdate();
            return rowsAffected > 0;
        } catch (SQLException e) {
            System.err.println("Lỗi khi thêm công văn: " + e.getMessage());
            e.printStackTrace();
        }
        return false;
    }

    // Cập nhật công văn
    public boolean updateCongVan(PtqCongVan cv) {
        String sql = "UPDATE ptqcong_van SET PtqSoHieu=?, PtqTieuDe=?, PtqNoiDung=?, PtqNgayBanHanh=?, PtqLoaiCongVan=?, PtqTrangThai=?, PtqTaiLieuDinhKem=? WHERE id=?";
        try (Connection conn = DBConnection.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setString(1, cv.getPtqSoHieu());
            ps.setString(2, cv.getPtqTieuDe());
            ps.setString(3, cv.getPtqNoiDung());
            ps.setDate(4, cv.getPtqNgayBanHanh() != null ? new java.sql.Date(cv.getPtqNgayBanHanh().getTime()) : null);
            ps.setString(5, cv.getPtqLoaiCongVan());
            ps.setString(6, cv.getPtqTrangThai());
            ps.setString(7, cv.getPtqTaiLieuDinhKem());
            ps.setInt(8, cv.getId());

            int rowsAffected = ps.executeUpdate();
            return rowsAffected > 0;
        } catch (SQLException e) {
            System.err.println("Lỗi khi cập nhật công văn: " + e.getMessage());
            e.printStackTrace();
        }
        return false;
    }

    // Xóa công văn theo ID
    public boolean deleteCongVan(int id) {
        String sql = "DELETE FROM ptqcong_van WHERE id=?";
        try (Connection conn = DBConnection.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setInt(1, id);
            int rowsAffected = ps.executeUpdate();
            return rowsAffected > 0;
        } catch (SQLException e) {
            System.err.println("Lỗi khi xóa công văn: " + e.getMessage());
            e.printStackTrace();
        }
        return false;
    }

    // Lấy danh sách công văn
    public List<PtqCongVan> getAllCongVan() {
        List<PtqCongVan> list = new ArrayList<>();
        String sql = "SELECT * FROM ptqcong_van";
        try (Connection conn = DBConnection.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql);
             ResultSet rs = ps.executeQuery()) {
            while (rs.next()) {
                PtqCongVan cv = new PtqCongVan(
                        rs.getInt("id"),
                        rs.getString("PtqSoHieu"),
                        rs.getString("PtqTieuDe"),
                        rs.getString("PtqNoiDung"),
                        rs.getDate("PtqNgayBanHanh"),
                        rs.getString("PtqLoaiCongVan"),
                        rs.getString("PtqTrangThai"),
                        rs.getString("PtqTaiLieuDinhKem")
                );
                list.add(cv);
            }
        } catch (SQLException e) {
            System.err.println("Lỗi khi lấy danh sách công văn: " + e.getMessage());
            e.printStackTrace();
        }
        return list;
    }

 // Tìm công văn theo tiêu đề
    public List<PtqCongVan> searchCongVanByTitle(String title) {
        String sql = "SELECT * FROM ptqcong_van WHERE PtqTieuDe LIKE ?";
        List<PtqCongVan> danhSachCongVan = new ArrayList<>();

        try (Connection conn = DBConnection.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setString(1, "%" + title + "%"); // Tìm kiếm gần đúng

            try (ResultSet rs = ps.executeQuery()) {
                while (rs.next()) {
                    danhSachCongVan.add(new PtqCongVan(
                            rs.getInt("id"),
                            rs.getString("PtqSoHieu"),
                            rs.getString("PtqTieuDe"),
                            rs.getString("PtqNoiDung"),
                            rs.getDate("PtqNgayBanHanh"),
                            rs.getString("PtqLoaiCongVan"),
                            rs.getString("PtqTrangThai"),
                            rs.getString("PtqTaiLieuDinhKem")
                    ));
                }
            }
        } catch (SQLException e) {
            System.err.println("Lỗi khi tìm công văn theo tiêu đề: " + e.getMessage());
            e.printStackTrace();
        }
        return danhSachCongVan;
    }
 // Lấy công văn theo ID
    public PtqCongVan getCongVanByID(int id) {
        String sql = "SELECT * FROM ptqcong_van WHERE id=?";
        try (Connection conn = DBConnection.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setInt(1, id);
            try (ResultSet rs = ps.executeQuery()) {
                if (rs.next()) {
                    return new PtqCongVan(
                            rs.getInt("id"),
                            rs.getString("PtqSoHieu"),
                            rs.getString("PtqTieuDe"),
                            rs.getString("PtqNoiDung"),
                            rs.getDate("PtqNgayBanHanh"),
                            rs.getString("PtqLoaiCongVan"),
                            rs.getString("PtqTrangThai"),
                            rs.getString("PtqTaiLieuDinhKem")
                    );
                }
            }
        } catch (SQLException e) {
            System.err.println("Lỗi khi lấy công văn theo ID: " + e.getMessage());
            e.printStackTrace();
        }
        return null;
    }


}
