package dao_PTQ;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import model_PTQ.PtqNguoiDung;
import config.DBConnection;

public class PtqNguoiDungDAO {
    
    // Lấy danh sách tất cả người dùng
    public List<PtqNguoiDung> getAllNguoiDung() {
        List<PtqNguoiDung> list = new ArrayList<>();
        String sql = "SELECT * FROM PtqNGUOI_DUNG";
        
        try (Connection conn = DBConnection.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql);
             ResultSet rs = ps.executeQuery()) {
            
            while (rs.next()) {
                PtqNguoiDung nd = new PtqNguoiDung(
                    rs.getInt("id"),
                    rs.getString("hoTen"),
                    rs.getString("email"),
                    rs.getString("matKhau"),
                    rs.getString("vaiTro")
                );
                list.add(nd);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return list;
    }

    // Lấy thông tin một người dùng theo ID
    public PtqNguoiDung getNguoiDungById(int id) {
        String sql = "SELECT * FROM PtqNGUOI_DUNG WHERE id=?";
        try (Connection conn = DBConnection.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {
            
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();
            
            if (rs.next()) {
                return new PtqNguoiDung(
                    rs.getInt("id"),
                    rs.getString("hoTen"),
                    rs.getString("email"),
                    rs.getString("matKhau"),
                    rs.getString("vaiTro")
                );
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }
    
    // Thêm một người dùng mới
    public boolean addNguoiDung(PtqNguoiDung nd) {
        String sql = "INSERT INTO PtqNGUOI_DUNG (hoTen, email, matKhau, vaiTro) VALUES (?, ?, ?, ?)";
        
        try (Connection conn = DBConnection.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {
            
            ps.setString(1, nd.getHoTen());
            ps.setString(2, nd.getEmail());
            ps.setString(3, nd.getMatKhau());
            ps.setString(4, nd.getVaiTro());
            
            return ps.executeUpdate() > 0;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    // Cập nhật thông tin người dùng
    public boolean updateNguoiDung(PtqNguoiDung nd) {
        String sql = "UPDATE PtqNGUOI_DUNG SET hoTen=?, email=?, matKhau=?, vaiTro=? WHERE id=?";
        
        try (Connection conn = DBConnection.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {
            
            ps.setString(1, nd.getHoTen());
            ps.setString(2, nd.getEmail());
            ps.setString(3, nd.getMatKhau());
            ps.setString(4, nd.getVaiTro());
            ps.setInt(5, nd.getId());
            
            return ps.executeUpdate() > 0;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    // Xóa người dùng theo ID
    public boolean deleteNguoiDung(int id) {
        String sql = "DELETE FROM PtqNGUOI_DUNG WHERE id=?";
        
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
