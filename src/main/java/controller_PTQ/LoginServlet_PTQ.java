package controller_PTQ;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao_PTQ.UserDAO_PTQ;
import model_PTQ.User_PTQ;

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

            response.sendRedirect("home.jsp"); // Chuyển hướng đến trang chủ
        } else {
            request.setAttribute("errorMessage", "Sai email hoặc mật khẩu!");
            request.getRequestDispatcher("login.jsp").forward(request, response);
        }
    }
}
