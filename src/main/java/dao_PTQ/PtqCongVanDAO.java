package dao_PTQ;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import model_PTQ.PtqCongVan;
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
            ps.setDate(4, new java.sql.Date(cv.getPtqNgayBanHanh().getTime()));
            ps.setString(5, cv.getPtqLoaiCongVan());
            ps.setString(6, cv.getPtqTrangThai());
            ps.setString(7, cv.getPtqTaiLieuDinhKem());
            return ps.executeUpdate() > 0;
        } catch (SQLException e) {
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
            ps.setDate(4, new java.sql.Date(cv.getPtqNgayBanHanh().getTime()));
            ps.setString(5, cv.getPtqLoaiCongVan());
            ps.setString(6, cv.getPtqTrangThai());
            ps.setString(7, cv.getPtqTaiLieuDinhKem());
            ps.setInt(8, cv.getId());
            return ps.executeUpdate() > 0;
        } catch (SQLException e) {
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
            return ps.executeUpdate() > 0;
        } catch (SQLException e) {
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
            e.printStackTrace();
        }
        return list;
    }

    // Tìm công văn theo ID
    public PtqCongVan getCongVanById(int id) {
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
            e.printStackTrace();
        }
        return null;
    }
}
