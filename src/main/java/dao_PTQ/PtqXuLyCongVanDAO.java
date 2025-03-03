package dao_PTQ;

import model_PTQ.PtqXuLyCongVan;
import config.DBConnection;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class PtqXuLyCongVanDAO {
    private Connection conn;

    public PtqXuLyCongVanDAO() {
        conn = DBConnection.getConnection();
    }

    // Thêm mới quá trình xử lý công văn
    public boolean themXuLyCongVan(PtqXuLyCongVan xlcv) {
        String sql = "INSERT INTO PtqXU_LY_CONG_VAN (PtqCongVanID, PtqNguoiXuLy, PtqNgayXuLy, PtqTrangThaiMoi, PtqGhiChu) VALUES (?, ?, ?, ?, ?)";
        try (PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setInt(1, xlcv.getCongVanID());
            stmt.setInt(2, xlcv.getNguoiXuLy());
            stmt.setTimestamp(3, xlcv.getNgayXuLy());
            stmt.setString(4, xlcv.getTrangThaiMoi());
            stmt.setString(5, xlcv.getGhiChu());

            return stmt.executeUpdate() > 0;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    // Lấy danh sách xử lý công văn theo ID công văn
    public List<PtqXuLyCongVan> layXuLyTheoCongVan(int congVanID) {
        List<PtqXuLyCongVan> danhSach = new ArrayList<>();
        String sql = "SELECT * FROM PtqXU_LY_CONG_VAN WHERE PtqCongVanID = ? ORDER BY PtqNgayXuLy DESC";
        try (PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setInt(1, congVanID);
            ResultSet rs = stmt.executeQuery();

            while (rs.next()) {
                danhSach.add(new PtqXuLyCongVan(
                        rs.getInt("id"),
                        rs.getInt("PtqCongVanID"),
                        rs.getInt("PtqNguoiXuLy"),
                        rs.getTimestamp("PtqNgayXuLy"),
                        rs.getString("PtqTrangThaiMoi"),
                        rs.getString("PtqGhiChu")
                ));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return danhSach;
    }

    // Cập nhật trạng thái xử lý công văn
    public boolean capNhatTrangThaiXuLy(int id, String trangThaiMoi, String ghiChu) {
        String sql = "UPDATE PtqXU_LY_CONG_VAN SET PtqTrangThaiMoi = ?, PtqGhiChu = ? WHERE id = ?";
        try (PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, trangThaiMoi);
            stmt.setString(2, ghiChu);
            stmt.setInt(3, id);

            return stmt.executeUpdate() > 0;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    // Xóa quá trình xử lý công văn
    public boolean xoaXuLyCongVan(int id) {
        String sql = "DELETE FROM PtqXU_LY_CONG_VAN WHERE id = ?";
        try (PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setInt(1, id);

            return stmt.executeUpdate() > 0;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }
}
