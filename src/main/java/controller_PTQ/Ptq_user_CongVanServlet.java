package controller_PTQ;

import PTQ_dao.PtqCongVanDAO;
import PTQ_model.PtqCongVan;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet("/Ptq_user_CongVanServlet")
public class Ptq_user_CongVanServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;
    private PtqCongVanDAO congVanDAO;

    @Override
    public void init() throws ServletException {
        congVanDAO = new PtqCongVanDAO();
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        response.setCharacterEncoding("UTF-8");

        String action = request.getParameter("action");
        if ("search".equals(action)) {
            searchCongVan(request, response);
        } else {
            listCongVan(request, response);
        }
    }

    private void listCongVan(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<PtqCongVan> danhSachCongVan = congVanDAO.getAllCongVan();
        request.setAttribute("danhSachCongVan", danhSachCongVan);
        request.getRequestDispatcher("PTQ_user_danhSachCongVan.jsp").forward(request, response);
    }

    private void searchCongVan(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String keyword = request.getParameter("keyword");
        List<PtqCongVan> danhSachCongVan = congVanDAO.searchCongVanByTitle(keyword);
        request.setAttribute("danhSachCongVan", danhSachCongVan);
        request.setAttribute("keyword", keyword);
        request.getRequestDispatcher("PTQ_user_danhSachCongVan.jsp").forward(request, response);
    }
}
