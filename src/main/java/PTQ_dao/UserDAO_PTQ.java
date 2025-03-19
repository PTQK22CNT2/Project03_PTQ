package PTQ_dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import PTQ_model.User_PTQ;
import config.DBConnection;

public class UserDAO_PTQ {

    // Phương thức kiểm tra đăng nhập (đã có)
    public User_PTQ checkLogin(String email, String password) {
        User_PTQ user = null;
        String sql = "SELECT ptqEmail, ptqMatKhau, ptqVaiTro FROM PtqNGUOI_DUNG WHERE ptqEmail = ? AND ptqMatKhau = ?";
        try (Connection conn = DBConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            
            stmt.setString(1, email);
            stmt.setString(2, password);
            ResultSet rs = stmt.executeQuery();
            
            if (rs.next()) {
                user = new User_PTQ();
                user.setPtqEmail(rs.getString("ptqEmail"));
                user.setPtqMatKhau(rs.getString("ptqMatKhau")); 
                user.setPtqVaiTro(rs.getString("ptqVaiTro"));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return user; // Trả về null nếu không tìm thấy user
    }
    
    // Lấy thông tin người dùng theo email (cho quản lý thông tin cá nhân)
    public User_PTQ getUserByEmail(String email) {
        User_PTQ user = null;
        String sql = "SELECT ptqEmail, ptqMatKhau, ptqVaiTro, ptqHoTen FROM PtqNGUOI_DUNG WHERE ptqEmail = ?";
        try (Connection conn = DBConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
             
            stmt.setString(1, email);
            ResultSet rs = stmt.executeQuery();
            if (rs.next()) {
                user = new User_PTQ();
                user.setPtqEmail(rs.getString("ptqEmail"));
                user.setPtqMatKhau(rs.getString("ptqMatKhau"));
                user.setPtqVaiTro(rs.getString("ptqVaiTro"));
                user.setPtqHoTen(rs.getString("ptqHoTen"));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return user;
    }
    
    // Cập nhật thông tin người dùng (cho quản lý thông tin cá nhân)
    public void updateUser(User_PTQ user) {
        // Cập nhật mật khẩu, họ tên và vai trò dựa trên ptqEmail (khóa duy nhất)
        String sql = "UPDATE PtqNGUOI_DUNG SET ptqMatKhau = ?, ptqHoTen = ?, ptqVaiTro = ? WHERE ptqEmail = ?";
        try (Connection conn = DBConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            
            stmt.setString(1, user.getPtqMatKhau());
            stmt.setString(2, user.getPtqHoTen());
            stmt.setString(3, user.getPtqVaiTro());
            stmt.setString(4, user.getPtqEmail());
            stmt.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    
    // Lấy danh sách tất cả người dùng (cho quản trị)
    public List<User_PTQ> getAllNguoiDung() {
        List<User_PTQ> list = new ArrayList<>();
        String sql = "SELECT id, ptqEmail, ptqMatKhau, ptqVaiTro, ptqHoTen FROM PtqNGUOI_DUNG";
        try (Connection conn = DBConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
             
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                User_PTQ user = new User_PTQ();
                user.setId(rs.getInt("id"));
                user.setPtqEmail(rs.getString("ptqEmail"));
                user.setPtqMatKhau(rs.getString("ptqMatKhau"));
                user.setPtqVaiTro(rs.getString("ptqVaiTro"));
                user.setPtqHoTen(rs.getString("ptqHoTen"));
                list.add(user);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return list;
    }
    
    // Lấy thông tin người dùng theo id (cho quản trị)
    public User_PTQ getUserById(int id) {
        User_PTQ user = null;
        String sql = "SELECT id, ptqEmail, ptqMatKhau, ptqVaiTro, ptqHoTen FROM PtqNGUOI_DUNG WHERE id = ?";
        try (Connection conn = DBConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
             
            stmt.setInt(1, id);
            ResultSet rs = stmt.executeQuery();
            if (rs.next()) {
                user = new User_PTQ();
                user.setId(rs.getInt("id"));
                user.setPtqEmail(rs.getString("ptqEmail"));
                user.setPtqMatKhau(rs.getString("ptqMatKhau"));
                user.setPtqVaiTro(rs.getString("ptqVaiTro"));
                user.setPtqHoTen(rs.getString("ptqHoTen"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return user;
    }
    
    // Thêm người dùng mới (cho quản trị)
    public void insertUser(User_PTQ user) {
        String sql = "INSERT INTO PtqNGUOI_DUNG (ptqEmail, ptqMatKhau, ptqVaiTro, ptqHoTen) VALUES (?, ?, ?, ?)";
        try (Connection conn = DBConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
             
            stmt.setString(1, user.getPtqEmail());
            stmt.setString(2, user.getPtqMatKhau());
            stmt.setString(3, user.getPtqVaiTro());
            stmt.setString(4, user.getPtqHoTen());
            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    
    // Xóa người dùng theo id (cho quản trị)
    public void deleteUser(int id) {
        String sql = "DELETE FROM PtqNGUOI_DUNG WHERE id = ?";
        try (Connection conn = DBConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
             
            stmt.setInt(1, id);
            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
