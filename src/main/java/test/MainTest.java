package test;

import dao_PTQ.PtqCongVanDAO;
import model_PTQ.PtqCongVan;

import java.util.List;

public class MainTest {
    public static void main(String[] args) {
        PtqCongVanDAO dao = new PtqCongVanDAO();

        // Lấy danh sách công văn
        List<PtqCongVan> list = dao.getAllCongVan();
        for (PtqCongVan cv : list) {
            System.out.println(cv.getId() + " - " + cv.getPtqTieuDe());
        }
    }
}
