package controller_PTQ;

import java.io.IOException;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao_PTQ.PtqCongVanDAO;
import model_PTQ.PtqCongVan;

@WebServlet("/PtqCongVanServlet_PTQ")
public class PtqCongVanServlet_PTQ extends HttpServlet {
    private static final long serialVersionUID = 1L;

    public PtqCongVanServlet_PTQ() {
        super();
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
    	PtqCongVanDAO congVanDAO = new PtqCongVanDAO();
        List<PtqCongVan> danhSachCongVan = congVanDAO.getAllCongVan();  // Lấy danh sách công văn từ DAO
        
        request.setAttribute("danhSachCongVan", danhSachCongVan);
        request.getRequestDispatcher("danhSachCongVan_PTQ.jsp").forward(request, response);

    }
}
