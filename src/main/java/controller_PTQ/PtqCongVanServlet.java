package controller_PTQ;

import dao_PTQ.PtqCongVanDAO;
import model_PTQ.PtqCongVan;

import javax.servlet.*;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.IOException;
import java.util.List;

@WebServlet("/PtqCongVanServlet_PTQ")
public class PtqCongVanServlet extends HttpServlet {
    private PtqCongVanDAO congVanDAO;

    @Override
    public void init() throws ServletException {
        congVanDAO = new PtqCongVanDAO();
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");
        if (action == null) {
            action = "list";
        }

        switch (action) {
            case "new":
                showNewForm(request, response);
                break;
            case "edit":
                showEditForm(request, response);
                break;
            case "delete":
                deleteCongVan(request, response);
                break;
            case "list":
            default:
                listCongVan(request, response);
                break;
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");

        switch (action) {
            case "insert":
                insertCongVan(request, response);
                break;
            case "update":
                updateCongVan(request, response);
                break;
            default:
                listCongVan(request, response);
                break;
        }
    }

    private void listCongVan(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<PtqCongVan> congVanList = congVanDAO.getAllCongVan();
        request.setAttribute("congVanList", congVanList);
        RequestDispatcher dispatcher = request.getRequestDispatcher("congvan-list.jsp");
        dispatcher.forward(request, response);
    }

    private void showNewForm(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        RequestDispatcher dispatcher = request.getRequestDispatcher("congvan-form.jsp");
        dispatcher.forward(request, response);
    }

    private void showEditForm(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        PtqCongVan existingCongVan = congVanDAO.getCongVanById(id);
        request.setAttribute("congVan", existingCongVan);
        RequestDispatcher dispatcher = request.getRequestDispatcher("congvan-form.jsp");
        dispatcher.forward(request, response);
    }

    private void insertCongVan(HttpServletRequest request, HttpServletResponse response) throws IOException {
        String soHieu = request.getParameter("soHieu");
        String tieuDe = request.getParameter("tieuDe");
        String noiDung = request.getParameter("noiDung");
        String ngayBanHanh = request.getParameter("ngayBanHanh");
        String loaiCongVan = request.getParameter("loaiCongVan");
        String trangThai = request.getParameter("trangThai");
        String taiLieuDinhKem = request.getParameter("taiLieuDinhKem");

        PtqCongVan newCongVan = new PtqCongVan(0, soHieu, tieuDe, noiDung, java.sql.Date.valueOf(ngayBanHanh), loaiCongVan, trangThai, taiLieuDinhKem);
        congVanDAO.addCongVan(newCongVan);
        response.sendRedirect("PtqCongVanServlet_PTQ?action=list");
    }

    private void updateCongVan(HttpServletRequest request, HttpServletResponse response) throws IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        String soHieu = request.getParameter("soHieu");
        String tieuDe = request.getParameter("tieuDe");
        String noiDung = request.getParameter("noiDung");
        String ngayBanHanh = request.getParameter("ngayBanHanh");
        String loaiCongVan = request.getParameter("loaiCongVan");
        String trangThai = request.getParameter("trangThai");
        String taiLieuDinhKem = request.getParameter("taiLieuDinhKem");

        PtqCongVan updatedCongVan = new PtqCongVan(id, soHieu, tieuDe, noiDung, java.sql.Date.valueOf(ngayBanHanh), loaiCongVan, trangThai, taiLieuDinhKem);
        congVanDAO.updateCongVan(updatedCongVan);
        response.sendRedirect("PtqCongVanServlet_PTQ?action=list");
    }

    private void deleteCongVan(HttpServletRequest request, HttpServletResponse response) throws IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        congVanDAO.deleteCongVan(id);
        response.sendRedirect("PtqCongVanServlet_PTQ?action=list");
    }
}
