package controller_PTQ;

import java.io.IOException;
import java.sql.Date;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import PTQ_dao.PtqCongVanDAO;
import PTQ_model.PtqCongVan;

@WebServlet("/Ptq_admin_CongVanServlet")
public class Ptq_admin_CongVanServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;
    private PtqCongVanDAO congVanDAO;

    @Override
    public void init() {
        congVanDAO = new PtqCongVanDAO();
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) 
            throws ServletException, IOException {
        // Cấu hình để xử lý tiếng Việt
        request.setCharacterEncoding("UTF-8");
        response.setCharacterEncoding("UTF-8");
        response.setContentType("text/html; charset=UTF-8");

        String action = request.getParameter("action");
        if (action == null) {
            action = "list";
        }

        switch (action) {
            case "new":
                showNewForm(request, response);
                break;
            case "insert":
                insertCongVan(request, response);
                break;
            case "delete":
                deleteCongVan(request, response);
                break;
            case "edit":
                showEditForm(request, response);
                break;
            case "update":
                updateCongVan(request, response);
                break;
            case "search":
                searchCongVan(request, response);
                break;
            default:
                listCongVan(request, response);
                break;
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) 
            throws ServletException, IOException {
        // Cấu hình để xử lý tiếng Việt
        request.setCharacterEncoding("UTF-8");
        response.setCharacterEncoding("UTF-8");
        response.setContentType("text/html; charset=UTF-8");

        // Gọi lại doGet để xử lý logic
        doGet(request, response);
    }

    private void listCongVan(HttpServletRequest request, HttpServletResponse response) 
            throws ServletException, IOException {
        List<PtqCongVan> listCongVan = congVanDAO.getAllCongVan();
        request.setAttribute("listCongVan", listCongVan);
        request.getRequestDispatcher("PTQ_admin_danhSachCongVan.jsp").forward(request, response);
    }

    private void insertCongVan(HttpServletRequest request, HttpServletResponse response) 
            throws IOException {
        String soHieu = request.getParameter("soHieu");
        String tieuDe = request.getParameter("tieuDe");
        String noiDung = request.getParameter("noiDung");
        String loaiCongVan = request.getParameter("loaiCongVan");
        String trangThai = request.getParameter("trangThai");
        String taiLieu = request.getParameter("taiLieu");

        // Kiểm tra và chuyển đổi ngày ban hành
        Date ngayBanHanh = null;
        try {
            ngayBanHanh = Date.valueOf(request.getParameter("ngayBanHanh"));
        } catch (IllegalArgumentException e) {
            ngayBanHanh = new Date(System.currentTimeMillis()); // Nếu lỗi, gán ngày hiện tại
        }

        // Tạo đối tượng công văn
        PtqCongVan congVan = new PtqCongVan(0, soHieu, tieuDe, noiDung, 
                                            ngayBanHanh, loaiCongVan, 
                                            trangThai, taiLieu);

        // Lưu vào DB
        congVanDAO.insertCongVan(congVan);

        // Quay về danh sách
        response.sendRedirect("Ptq_admin_CongVanServlet?action=list");
    }

    private void deleteCongVan(HttpServletRequest request, HttpServletResponse response) 
            throws IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        congVanDAO.deleteCongVan(id);
        response.sendRedirect("Ptq_admin_CongVanServlet?action=list");
    }

    private void showEditForm(HttpServletRequest request, HttpServletResponse response) 
            throws ServletException, IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        PtqCongVan congVan = congVanDAO.getCongVanByID(id);
        request.setAttribute("congVan", congVan);
        request.getRequestDispatcher("PTQ_admin_CongVanForm.jsp").forward(request, response);
    }

    private void updateCongVan(HttpServletRequest request, HttpServletResponse response) 
            throws IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        String soHieu = request.getParameter("soHieu");
        String tieuDe = request.getParameter("tieuDe");
        String noiDung = request.getParameter("noiDung");
        String loaiCongVan = request.getParameter("loaiCongVan");
        String trangThai = request.getParameter("trangThai");
        String taiLieu = request.getParameter("taiLieu");

        // Kiểm tra và chuyển đổi ngày ban hành
        Date ngayBanHanh = null;
        try {
            ngayBanHanh = Date.valueOf(request.getParameter("ngayBanHanh"));
        } catch (IllegalArgumentException e) {
            ngayBanHanh = new Date(System.currentTimeMillis());
        }

        PtqCongVan congVan = new PtqCongVan(id, soHieu, tieuDe, noiDung, 
                                            ngayBanHanh, loaiCongVan, 
                                            trangThai, taiLieu);
        congVanDAO.updateCongVan(congVan);
        response.sendRedirect("Ptq_admin_CongVanServlet?action=list");
    }

    private void searchCongVan(HttpServletRequest request, HttpServletResponse response) 
            throws ServletException, IOException {
        String title = request.getParameter("title");
        List<PtqCongVan> searchResults = congVanDAO.searchCongVanByTitle(title);
        request.setAttribute("listCongVan", searchResults);
        request.getRequestDispatcher("PTQ_admin_danhSachCongVan.jsp").forward(request, response);
    }

    private void showNewForm(HttpServletRequest request, HttpServletResponse response) 
            throws ServletException, IOException {
        request.getRequestDispatcher("PTQ_admin_CongVanForm.jsp").forward(request, response);
    }
}
