package controller_PTQ;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import PTQ_dao.UserDAO_PTQ;
import PTQ_model.User_PTQ;

@WebServlet("/PtqThongTinCaNhanServlet")
public class PtqThongTinCaNhanServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;
    private UserDAO_PTQ userDAO;

    @Override
    public void init() {
        userDAO = new UserDAO_PTQ();
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        // Cấu hình UTF-8 cho request và response
        request.setCharacterEncoding("UTF-8");
        response.setCharacterEncoding("UTF-8");
        response.setContentType("text/html; charset=UTF-8");

        // Lấy email người dùng từ session (đã đăng nhập)
        HttpSession session = request.getSession();
        String email = (String) session.getAttribute("userEmail");
        if (email == null) {
            response.sendRedirect("login.jsp");
            return;
        }
        // Lấy thông tin người dùng từ DB
        User_PTQ user = userDAO.getUserByEmail(email);
        request.setAttribute("user", user);
        request.getRequestDispatcher("PtqThongTinCaNhan.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        // Cấu hình UTF-8
        request.setCharacterEncoding("UTF-8");
        response.setCharacterEncoding("UTF-8");
        response.setContentType("text/html; charset=UTF-8");

        HttpSession session = request.getSession();
        String email = (String) session.getAttribute("userEmail");
        if (email == null) {
            response.sendRedirect("login.jsp");
            return;
        }
        // Lấy dữ liệu cập nhật từ form
        String hoTen = request.getParameter("ptqHoTen");
        String matKhau = request.getParameter("ptqMatKhau"); // Nếu để trống, giữ nguyên mật khẩu

        // Lấy thông tin hiện tại của người dùng
        User_PTQ user = userDAO.getUserByEmail(email);
        user.setPtqHoTen(hoTen);
        if (matKhau != null && !matKhau.trim().isEmpty()) {
            user.setPtqMatKhau(matKhau);
        }
        // Cập nhật thông tin qua DAO
        userDAO.updateUser(user);

        // Gửi thông báo thành công và forward lại trang form
        request.setAttribute("message", "Cập nhật thông tin thành công.");
        request.setAttribute("user", user);
        request.getRequestDispatcher("PtqThongTinCaNhan.jsp").forward(request, response);
    }
}
