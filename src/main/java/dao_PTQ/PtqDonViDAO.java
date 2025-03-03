package dao_PTQ;

import model_PTQ.PtqDonVi;
import config.DBConnection;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class PtqDonViDAO {
    private Connection conn;

    public PtqDonViDAO() {
        conn = DBConnection.getConnection();
    }

    // Thêm đơn vị mới
    public boolean themDonVi(PtqDonVi donVi) {
        String sql = "INSERT INTO PtqDON_VI (PtqTenDonVi, PtqDiaChi, PtqSoDienThoai) VALUES (?, ?, ?)";
        try (PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, donVi.getTenDonVi());
            stmt.setString(2, donVi.getDiaChi());
            stmt.setString(3, donVi.getSoDienThoai());

            return stmt.executeUpdate() > 0;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    // Lấy danh sách tất cả đơn vị
    public List<PtqDonVi> layDanhSachDonVi() {
        List<PtqDonVi> danhSach = new ArrayList<>();
        String sql = "SELECT * FROM PtqDON_VI";
        try (PreparedStatement stmt = conn.prepareStatement(sql)) {
            ResultSet rs = stmt.executeQuery();

            while (rs.next()) {
                danhSach.add(new PtqDonVi(
                        rs.getInt("id"),
                        rs.getString("PtqTenDonVi"),
                        rs.getString("PtqDiaChi"),
                        rs.getString("PtqSoDienThoai")
                ));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return danhSach;
    }

    // Tìm đơn vị theo ID
    public PtqDonVi timDonViTheoID(int id) {
        String sql = "SELECT * FROM PtqDON_VI WHERE id = ?";
        try (PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setInt(1, id);
            ResultSet rs = stmt.executeQuery();

            if (rs.next()) {
                return new PtqDonVi(
                        rs.getInt("id"),
                        rs.getString("PtqTenDonVi"),
                        rs.getString("PtqDiaChi"),
                        rs.getString("PtqSoDienThoai")
                );
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    // Cập nhật thông tin đơn vị
    public boolean capNhatDonVi(PtqDonVi donVi) {
        String sql = "UPDATE PtqDON_VI SET PtqTenDonVi = ?, PtqDiaChi = ?, PtqSoDienThoai = ? WHERE id = ?";
        try (PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, donVi.getTenDonVi());
            stmt.setString(2, donVi.getDiaChi());
            stmt.setString(3, donVi.getSoDienThoai());
            stmt.setInt(4, donVi.getId());

            return stmt.executeUpdate() > 0;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    // Xóa đơn vị
    public boolean xoaDonVi(int id) {
        String sql = "DELETE FROM PtqDON_VI WHERE id = ?";
        try (PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setInt(1, id);

            return stmt.executeUpdate() > 0;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }
}
