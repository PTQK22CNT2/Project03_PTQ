package controller_PTQ;

import java.io.IOException;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import PTQ_dao.UserDAO_PTQ;
import PTQ_model.User_PTQ;

@WebServlet("/PtqQuanTriNguoiDungServlet")
public class PtqQuanTriNguoiDungServlet extends HttpServlet {
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

        String action = request.getParameter("action");
        if (action == null) {
            action = "list";
        }

        try {
            switch (action) {
                case "new":
                    showNewForm(request, response);
                    break;
                case "insert":
                    insertUser(request, response);
                    break;
                case "edit":
                    showEditForm(request, response);
                    break;
                case "update":
                    updateUser(request, response);
                    break;
                case "delete":
                    deleteUser(request, response);
                    break;
                default:
                    listUsers(request, response);
                    break;
            }
        } catch (Exception e) {
            throw new ServletException(e);
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        // Gọi doGet() để xử lý tất cả các action
        doGet(request, response);
    }

    // Hiển thị danh sách người dùng
    private void listUsers(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        List<User_PTQ> listUser = userDAO.getAllNguoiDung();
        request.setAttribute("listUser", listUser);
        request.getRequestDispatcher("PtqQuanTriNguoiDungList.jsp").forward(request, response);
    }

    // Hiển thị form thêm mới
    private void showNewForm(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        request.getRequestDispatcher("PtqQuanTriNguoiDungForm.jsp").forward(request, response);
    }

    // Thêm người dùng mới
    private void insertUser(HttpServletRequest request, HttpServletResponse response)
            throws IOException {
        String ptqHoTen = request.getParameter("ptqHoTen");
        String ptqEmail = request.getParameter("ptqEmail");
        String ptqMatKhau = request.getParameter("ptqMatKhau");
        String ptqVaiTro = request.getParameter("ptqVaiTro");

        User_PTQ newUser = new User_PTQ();
        newUser.setPtqEmail(ptqEmail);
        newUser.setPtqMatKhau(ptqMatKhau);
        newUser.setPtqVaiTro(ptqVaiTro);
        newUser.setPtqHoTen(ptqHoTen);

        userDAO.insertUser(newUser);
        response.sendRedirect("PtqQuanTriNguoiDungServlet?action=list");
    }

    // Hiển thị form chỉnh sửa (dựa trên id)
    private void showEditForm(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        User_PTQ existingUser = userDAO.getUserById(id);
        request.setAttribute("user", existingUser);
        request.getRequestDispatcher("PtqQuanTriNguoiDungForm.jsp").forward(request, response);
    }

    // Cập nhật thông tin người dùng
    private void updateUser(HttpServletRequest request, HttpServletResponse response)
            throws IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        String ptqHoTen = request.getParameter("ptqHoTen");
        String ptqEmail = request.getParameter("ptqEmail");
        String ptqMatKhau = request.getParameter("ptqMatKhau");
        String ptqVaiTro = request.getParameter("ptqVaiTro");

        User_PTQ user = new User_PTQ();
        user.setId(id);
        user.setPtqHoTen(ptqHoTen);
        user.setPtqEmail(ptqEmail);
        user.setPtqMatKhau(ptqMatKhau);
        user.setPtqVaiTro(ptqVaiTro);

        userDAO.updateUser(user);
        response.sendRedirect("PtqQuanTriNguoiDungServlet?action=list");
    }

    // Xóa người dùng theo id
    private void deleteUser(HttpServletRequest request, HttpServletResponse response)
            throws IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        userDAO.deleteUser(id);
        response.sendRedirect("PtqQuanTriNguoiDungServlet?action=list");
    }
}
