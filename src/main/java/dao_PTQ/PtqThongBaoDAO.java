package dao_PTQ;

import model_PTQ.PtqThongBao;
import config.DBConnection;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class PtqThongBaoDAO {
    private Connection conn;

    public PtqThongBaoDAO() {
        conn = DBConnection.getConnection();
    }

    // Thêm thông báo mới
    public boolean themThongBao(PtqThongBao thongBao) {
        String sql = "INSERT INTO PtqTHONG_BAO (PtqNguoiNhan, PtqNoiDung, PtqNgayGui, PtqTrangThai) VALUES (?, ?, ?, ?)";
        try (PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setInt(1, thongBao.getNguoiNhan());
            stmt.setString(2, thongBao.getNoiDung());
            stmt.setTimestamp(3, thongBao.getNgayGui());
            stmt.setBoolean(4, thongBao.isTrangThai());

            return stmt.executeUpdate() > 0;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    // Lấy danh sách thông báo theo người nhận
    public List<PtqThongBao> layThongBaoTheoNguoiNhan(int nguoiNhan) {
        List<PtqThongBao> danhSach = new ArrayList<>();
        String sql = "SELECT * FROM PtqTHONG_BAO WHERE PtqNguoiNhan = ? ORDER BY PtqNgayGui DESC";
        try (PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setInt(1, nguoiNhan);
            ResultSet rs = stmt.executeQuery();

            while (rs.next()) {
                danhSach.add(new PtqThongBao(
                        rs.getInt("id"),
                        rs.getInt("PtqNguoiNhan"),
                        rs.getString("PtqNoiDung"),
                        rs.getTimestamp("PtqNgayGui"),
                        rs.getBoolean("PtqTrangThai")
                ));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return danhSach;
    }

    // Cập nhật trạng thái thông báo (đã đọc)
    public boolean capNhatTrangThai(int id, boolean trangThai) {
        String sql = "UPDATE PtqTHONG_BAO SET PtqTrangThai = ? WHERE id = ?";
        try (PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setBoolean(1, trangThai);
            stmt.setInt(2, id);

            return stmt.executeUpdate() > 0;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    // Xóa thông báo
    public boolean xoaThongBao(int id) {
        String sql = "DELETE FROM PtqTHONG_BAO WHERE id = ?";
        try (PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setInt(1, id);

            return stmt.executeUpdate() > 0;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }
}
