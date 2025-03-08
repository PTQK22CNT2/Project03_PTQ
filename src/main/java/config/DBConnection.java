package config;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBConnection {
	private static final String JDBC_URL = "jdbc:mysql://localhost:3306/quanlycongvan_ptq";

    private static final String JDBC_USERNAME = "root";  // Thay bằng user của bạn
    private static final String JDBC_PASSWORD = "";  // Thay bằng mật khẩu của bạn

    public static Connection getConnection() throws SQLException {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            return DriverManager.getConnection(JDBC_URL, JDBC_USERNAME, JDBC_PASSWORD);
        } catch (ClassNotFoundException e) {
            throw new SQLException("Không tìm thấy Driver JDBC!", e);
        }
    }
}
