package PTQ_model;

import java.util.Date;

public class PtqCongVan {
    private int id;
    private String ptqSoHieu;
    private String ptqTieuDe;
    private String ptqNoiDung;
    private Date ptqNgayBanHanh;
    private String ptqLoaiCongVan; // Đến hoặc Đi
    private String ptqTrangThai;   // Đang xử lý, Hoàn thành, Từ chối
    private String ptqTaiLieuDinhKem;

    // Constructor không tham số
    public PtqCongVan() {
    }

    // Constructor đầy đủ tham số
    public PtqCongVan(int id, String ptqSoHieu, String ptqTieuDe, String ptqNoiDung, Date ptqNgayBanHanh, String ptqLoaiCongVan, String ptqTrangThai, String ptqTaiLieuDinhKem) {
        this.id = id;
        this.ptqSoHieu = ptqSoHieu;
        this.ptqTieuDe = ptqTieuDe;
        this.ptqNoiDung = ptqNoiDung;
        this.ptqNgayBanHanh = ptqNgayBanHanh;
        this.ptqLoaiCongVan = ptqLoaiCongVan;
        this.ptqTrangThai = ptqTrangThai;
        this.ptqTaiLieuDinhKem = ptqTaiLieuDinhKem;
    }

    // Getter và Setter
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getPtqSoHieu() {
        return ptqSoHieu;
    }

    public void setPtqSoHieu(String ptqSoHieu) {
        this.ptqSoHieu = ptqSoHieu;
    }

    public String getPtqTieuDe() {
        return ptqTieuDe;
    }

    public void setPtqTieuDe(String ptqTieuDe) {
        this.ptqTieuDe = ptqTieuDe;
    }

    public String getPtqNoiDung() {
        return ptqNoiDung;
    }

    public void setPtqNoiDung(String ptqNoiDung) {
        this.ptqNoiDung = ptqNoiDung;
    }

    public Date getPtqNgayBanHanh() {
        return ptqNgayBanHanh;
    }

    public void setPtqNgayBanHanh(Date ptqNgayBanHanh) {
        this.ptqNgayBanHanh = ptqNgayBanHanh;
    }

    public String getPtqLoaiCongVan() {
        return ptqLoaiCongVan;
    }

    public void setPtqLoaiCongVan(String ptqLoaiCongVan) {
        this.ptqLoaiCongVan = ptqLoaiCongVan;
    }

    public String getPtqTrangThai() {
        return ptqTrangThai;
    }

    public void setPtqTrangThai(String ptqTrangThai) {
        this.ptqTrangThai = ptqTrangThai;
    }

    public String getPtqTaiLieuDinhKem() {
        return ptqTaiLieuDinhKem;
    }

    public void setPtqTaiLieuDinhKem(String ptqTaiLieuDinhKem) {
        this.ptqTaiLieuDinhKem = ptqTaiLieuDinhKem;
    }
}
