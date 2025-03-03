package dao_PTQ;

import model_PTQ.PtqCongVan;
import config.DBConnection;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class PtqCongVanDAO {

    public boolean addCongVan(PtqCongVan cv) {
        String sql = "INSERT INTO PtqCONG_VAN (ptqSoHieu, ptqTieuDe, ptqNoiDung, ptqNgayBanHanh, ptqLoaiCongVan, ptqTrangThai, ptqTaiLieuDinhKem) VALUES (?, ?, ?, ?, ?, ?, ?)";
        
        try (Connection conn = DBConnection.getConnection()) {
            if (conn == null) {
                System.err.println("Lỗi: Kết nối database thất bại (conn = null)");
                return false;
            }

            try (PreparedStatement ps = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) {
                ps.setString(1, cv.getPtqSoHieu());
                ps.setString(2, cv.getPtqTieuDe());
                ps.setString(3, cv.getPtqNoiDung());
                ps.setDate(4, new java.sql.Date(cv.getPtqNgayBanHanh().getTime()));
                ps.setString(5, cv.getPtqLoaiCongVan());
                ps.setString(6, cv.getPtqTrangThai());
                ps.setString(7, cv.getPtqTaiLieuDinhKem());

                return ps.executeUpdate() > 0;
            }
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    public List<PtqCongVan> getAllCongVan() {
        List<PtqCongVan> list = new ArrayList<>();
        String sql = "SELECT * FROM PtqCONG_VAN";

        try (Connection conn = DBConnection.getConnection()) {
            if (conn == null) {
                System.err.println("Lỗi: Kết nối database thất bại (conn = null)");
                return list;
            }

            try (PreparedStatement ps = conn.prepareStatement(sql);
                 ResultSet rs = ps.executeQuery()) {

                while (rs.next()) {
                    list.add(new PtqCongVan(
                        rs.getInt("Id"),
                        rs.getString("ptqSoHieu"),
                        rs.getString("ptqTieuDe"),
                        rs.getString("ptqNoiDung"),
                        rs.getDate("ptqNgayBanHanh"),
                        rs.getString("ptqLoaiCongVan"),
                        rs.getString("ptqTrangThai"),
                        rs.getString("ptqTaiLieuDinhKem")
                    ));
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return list;
    }

    public boolean updateCongVan(PtqCongVan cv) {
        String sql = "UPDATE PtqCONG_VAN SET ptqSoHieu=?, ptqTieuDe=?, ptqNoiDung=?, ptqNgayBanHanh=?, ptqLoaiCongVan=?, ptqTrangThai=?, ptqTaiLieuDinhKem=? WHERE Id=?";
        
        try (Connection conn = DBConnection.getConnection()) {
            if (conn == null) {
                System.err.println("Lỗi: Kết nối database thất bại (conn = null)");
                return false;
            }

            try (PreparedStatement ps = conn.prepareStatement(sql)) {
                ps.setString(1, cv.getPtqSoHieu());
                ps.setString(2, cv.getPtqTieuDe());
                ps.setString(3, cv.getPtqNoiDung());
                ps.setDate(4, new java.sql.Date(cv.getPtqNgayBanHanh().getTime()));
                ps.setString(5, cv.getPtqLoaiCongVan());
                ps.setString(6, cv.getPtqTrangThai());
                ps.setString(7, cv.getPtqTaiLieuDinhKem());
                ps.setInt(8, cv.getId());

                return ps.executeUpdate() > 0;
            }
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    public PtqCongVan getCongVanById(int id) {
        String sql = "SELECT * FROM PtqCONG_VAN WHERE Id = ?";
        PtqCongVan congVan = null;

        try (Connection conn = DBConnection.getConnection()) {
            if (conn == null) {
                System.err.println("Lỗi: Kết nối database thất bại (conn = null)");
                return null;
            }

            try (PreparedStatement ps = conn.prepareStatement(sql)) {
                ps.setInt(1, id);
                try (ResultSet rs = ps.executeQuery()) {
                    if (rs.next()) {
                        congVan = new PtqCongVan(
                            rs.getInt("Id"),
                            rs.getString("ptqSoHieu"),
                            rs.getString("ptqTieuDe"),
                            rs.getString("ptqNoiDung"),
                            rs.getDate("ptqNgayBanHanh"),
                            rs.getString("ptqLoaiCongVan"),
                            rs.getString("ptqTrangThai"),
                            rs.getString("ptqTaiLieuDinhKem")
                        );
                    }
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return congVan;
    }

    public boolean deleteCongVan(int id) {
        String sql = "DELETE FROM PtqCONG_VAN WHERE Id=?";
        
        try (Connection conn = DBConnection.getConnection()) {
            if (conn == null) {
                System.err.println("Lỗi: Kết nối database thất bại (conn = null)");
                return false;
            }

            try (PreparedStatement ps = conn.prepareStatement(sql)) {
                ps.setInt(1, id);
                return ps.executeUpdate() > 0;
            }
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }
}
