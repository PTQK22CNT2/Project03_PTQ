package model_PTQ;

import java.sql.Timestamp;

public class PtqXuLyCongVan {
    private int id;
    private int congVanID;
    private int nguoiXuLy;
    private Timestamp ngayXuLy;
    private String trangThaiMoi;
    private String ghiChu;

    public PtqXuLyCongVan() {}

    public PtqXuLyCongVan(int id, int congVanID, int nguoiXuLy, Timestamp ngayXuLy, String trangThaiMoi, String ghiChu) {
        this.id = id;
        this.congVanID = congVanID;
        this.nguoiXuLy = nguoiXuLy;
        this.ngayXuLy = ngayXuLy;
        this.trangThaiMoi = trangThaiMoi;
        this.ghiChu = ghiChu;
    }

    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }

    public int getCongVanID() {
        return congVanID;
    }
    public void setCongVanID(int congVanID) {
        this.congVanID = congVanID;
    }

    public int getNguoiXuLy() {
        return nguoiXuLy;
    }
    public void setNguoiXuLy(int nguoiXuLy) {
        this.nguoiXuLy = nguoiXuLy;
    }

    public Timestamp getNgayXuLy() {
        return ngayXuLy;
    }
    public void setNgayXuLy(Timestamp ngayXuLy) {
        this.ngayXuLy = ngayXuLy;
    }

    public String getTrangThaiMoi() {
        return trangThaiMoi;
    }
    public void setTrangThaiMoi(String trangThaiMoi) {
        this.trangThaiMoi = trangThaiMoi;
    }

    public String getGhiChu() {
        return ghiChu;
    }
    public void setGhiChu(String ghiChu) {
        this.ghiChu = ghiChu;
    }
}
