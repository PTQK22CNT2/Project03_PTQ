package controller_PTQ;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import PTQ_dao.UserDAO_PTQ;
import PTQ_model.User_PTQ;

@WebServlet("/LoginServlet_PTQ")
public class LoginServlet_PTQ extends HttpServlet {
    private static final long serialVersionUID = 1L;

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String email = request.getParameter("email");
        String password = request.getParameter("password");

        UserDAO_PTQ userDAO = new UserDAO_PTQ();
        User_PTQ user = userDAO.checkLogin(email, password);

        if (user != null) {
            // Tạo session
            HttpSession session = request.getSession();
            session.setAttribute("userEmail", user.getPtqEmail());
            session.setAttribute("userRole", user.getPtqVaiTro());
            session.setAttribute("userName", user.getPtqHoTen()); // Thêm họ tên vào session


            // Chuyển hướng theo vai trò
            if ("Admin".equals(user.getPtqVaiTro())) {
                response.sendRedirect("admin-dashboard.jsp");
            } else {
                response.sendRedirect("user-dashboard.jsp");
            }
        } else {
            request.setAttribute("errorMessage", "Sai email hoặc mật khẩu!");
            request.getRequestDispatcher("login.jsp").forward(request, response);
        }
    }
}
