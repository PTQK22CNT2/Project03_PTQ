package dao_PTQ;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import model_PTQ.PtqQuanTri;
import config.DBConnection;

public class PtqQuanTriDAO {

    // Lấy danh sách tất cả quản trị viên
    public List<PtqQuanTri> getAllQuanTri() {
        List<PtqQuanTri> list = new ArrayList<>();
        String sql = "SELECT * FROM PtqQUAN_TRI";

        try (Connection conn = DBConnection.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql);
             ResultSet rs = ps.executeQuery()) {

            while (rs.next()) {
                PtqQuanTri qt = new PtqQuanTri(
                    rs.getInt("id"),
                    rs.getString("taiKhoan"),
                    rs.getString("matKhau"),
                    rs.getBoolean("trangThai")
                );
                list.add(qt);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return list;
    }

    // Lấy thông tin một quản trị viên theo ID
    public PtqQuanTri getQuanTriById(int id) {
        String sql = "SELECT * FROM PtqQUAN_TRI WHERE id=?";
        try (Connection conn = DBConnection.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {

            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();

            if (rs.next()) {
                return new PtqQuanTri(
                    rs.getInt("id"),
                    rs.getString("taiKhoan"),
                    rs.getString("matKhau"),
                    rs.getBoolean("trangThai")
                );
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    // Thêm một quản trị viên mới
    public boolean addQuanTri(PtqQuanTri qt) {
        String sql = "INSERT INTO PtqQUAN_TRI (taiKhoan, matKhau, trangThai) VALUES (?, ?, ?)";

        try (Connection conn = DBConnection.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {

            ps.setString(1, qt.getTaiKhoan());
            ps.setString(2, qt.getMatKhau());
            ps.setBoolean(3, qt.isTrangThai());

            return ps.executeUpdate() > 0;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    // Cập nhật thông tin quản trị viên
    public boolean updateQuanTri(PtqQuanTri qt) {
        String sql = "UPDATE PtqQUAN_TRI SET taiKhoan=?, matKhau=?, trangThai=? WHERE id=?";

        try (Connection conn = DBConnection.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {

            ps.setString(1, qt.getTaiKhoan());
            ps.setString(2, qt.getMatKhau());
            ps.setBoolean(3, qt.isTrangThai());
            ps.setInt(4, qt.getId());

            return ps.executeUpdate() > 0;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    // Xóa quản trị viên theo ID
    public boolean deleteQuanTri(int id) {
        String sql = "DELETE FROM PtqQUAN_TRI WHERE id=?";

        try (Connection conn = DBConnection.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {

            ps.setInt(1, id);
            return ps.executeUpdate() > 0;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }
}
