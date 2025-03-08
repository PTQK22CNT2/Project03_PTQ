package controller_PTQ;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/RegisterServlet")
public class RegisterServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    private static final String JDBC_URL = "jdbc:mysql://localhost:3306/quanlycongvan_ptq?useUnicode=true&characterEncoding=UTF-8";
    private static final String JDBC_USER = "root";
    private static final String JDBC_PASSWORD = "";

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        // 🔥 Cấu hình UTF-8 để nhập tiếng Việt
        request.setCharacterEncoding("UTF-8");
        response.setCharacterEncoding("UTF-8");
        response.setContentType("text/html; charset=UTF-8");

        // Nhận dữ liệu từ form đăng ký
        String ptqHoTen = request.getParameter("ptqHoTen").trim();
        String ptqEmail = request.getParameter("ptqEmail").trim();
        String ptqMatKhau = request.getParameter("ptqMatKhau").trim();
        String ptqVaiTro = request.getParameter("ptqVaiTro").trim();

        // Kiểm tra nếu dữ liệu rỗng
        if (ptqHoTen.isEmpty() || ptqEmail.isEmpty() || ptqMatKhau.isEmpty() || ptqVaiTro.isEmpty()) {
            response.sendRedirect("register.jsp?error=missing_fields");
            return;
        }

        // Chuẩn hóa vai trò (phải khớp với ENUM trong MySQL)
        if (!ptqVaiTro.equals("Admin") && !ptqVaiTro.equals("Nhân viên")) {
            ptqVaiTro = "Nhân viên"; // Mặc định nếu không hợp lệ
        }

        System.out.println("Debug: Nhận dữ liệu - " + ptqHoTen + ", " + ptqEmail + ", " + ptqVaiTro);

        Connection conn = null;
        PreparedStatement checkStmt = null;
        PreparedStatement insertStmt = null;
        ResultSet rs = null;

        try {
            // Kết nối CSDL
            Class.forName("com.mysql.cj.jdbc.Driver");
            conn = DriverManager.getConnection(JDBC_URL, JDBC_USER, JDBC_PASSWORD);
            System.out.println("Debug: Kết nối MySQL thành công!");

            // Kiểm tra email đã tồn tại chưa
            String checkSql = "SELECT COUNT(*) FROM ptqnguoi_dung WHERE ptqEmail = ?";
            checkStmt = conn.prepareStatement(checkSql);
            checkStmt.setString(1, ptqEmail);
            rs = checkStmt.executeQuery();
            rs.next();

            if (rs.getInt(1) > 0) {
                System.out.println("Debug: Email đã tồn tại!");
                response.sendRedirect("register.jsp?error=email_exists");
                return;
            }

            // Nếu email chưa tồn tại, thêm người dùng mới
            String insertSql = "INSERT INTO ptqnguoi_dung (ptqHoTen, ptqEmail, ptqMatKhau, ptqVaiTro) VALUES (?, ?, ?, ?)";
            insertStmt = conn.prepareStatement(insertSql);
            insertStmt.setString(1, ptqHoTen);
            insertStmt.setString(2, ptqEmail);
            insertStmt.setString(3, ptqMatKhau);
            insertStmt.setString(4, ptqVaiTro);

            System.out.println("Debug: SQL Insert - " + insertSql);

            int result = insertStmt.executeUpdate();
            System.out.println("Debug: Câu lệnh SQL đã chạy, số dòng bị ảnh hưởng: " + result);

            if (result > 0) {
                response.sendRedirect("register_success.jsp");
            } else {
                response.sendRedirect("register.jsp?error=insert_failed");
            }
        } catch (Exception e) {
            e.printStackTrace();
            response.sendRedirect("register.jsp?error=exception");
        } finally {
            // Đóng tài nguyên
            try {
                if (rs != null) rs.close();
                if (checkStmt != null) checkStmt.close();
                if (insertStmt != null) insertStmt.close();
                if (conn != null) conn.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}
