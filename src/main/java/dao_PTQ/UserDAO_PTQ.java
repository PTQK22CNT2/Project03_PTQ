package dao_PTQ;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import model_PTQ.User_PTQ;
import config.DBConnection;

public class UserDAO_PTQ {

    // Kiểm tra đăng nhập (Tìm user theo email)
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
}
