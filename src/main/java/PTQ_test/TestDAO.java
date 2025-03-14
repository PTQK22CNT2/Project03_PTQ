package PTQ_test;

import PTQ_dao.PtqCongVanDAO;
import PTQ_model.PtqCongVan;
import java.util.List;

public class TestDAO {
    public static void main(String[] args) {
        PtqCongVanDAO dao = new PtqCongVanDAO();

        // 1. Test thêm công văn
        PtqCongVan newCv = new PtqCongVan(0, "CV-123", "Tiêu đề Test", "Nội dung test", new java.util.Date(), "Loại 1", "Chưa duyệt", "file.pdf");
        boolean isInserted = dao.insertCongVan(newCv);
        System.out.println("Thêm công văn: " + (isInserted ? "Thành công" : "Thất bại"));

        // 2. Test lấy danh sách công văn
        List<PtqCongVan> list = dao.getAllCongVan();
        System.out.println("Danh sách công văn:");
        for (PtqCongVan cv : list) {
            System.out.println(cv.getId() + " - " + cv.getPtqTieuDe());
        }

        // 3. Test cập nhật công văn
        if (!list.isEmpty()) {
            PtqCongVan firstCv = list.get(0);
            firstCv.setPtqTieuDe("Tiêu đề mới");
            boolean isUpdated = dao.updateCongVan(firstCv);
            System.out.println("Cập nhật công văn: " + (isUpdated ? "Thành công" : "Thất bại"));
        }

        // 4. Test xóa công văn
        if (!list.isEmpty()) {
            boolean isDeleted = dao.deleteCongVan(list.get(0).getId());
            System.out.println("Xóa công văn: " + (isDeleted ? "Thành công" : "Thất bại"));
        }
    }
}
