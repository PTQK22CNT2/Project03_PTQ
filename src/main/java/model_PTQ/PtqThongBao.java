package model_PTQ;

import java.sql.Timestamp;

public class PtqThongBao {
    private int id;
    private int nguoiNhan;
    private String noiDung;
    private Timestamp ngayGui;
    private boolean trangThai;

    public PtqThongBao() {}

    public PtqThongBao(int id, int nguoiNhan, String noiDung, Timestamp ngayGui, boolean trangThai) {
        this.id = id;
        this.nguoiNhan = nguoiNhan;
        this.noiDung = noiDung;
        this.ngayGui = ngayGui;
        this.trangThai = trangThai;
    }

    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }
    public int getNguoiNhan() {
        return nguoiNhan;
    }
    public void setNguoiNhan(int nguoiNhan) {
        this.nguoiNhan = nguoiNhan;
    }
    public String getNoiDung() {
        return noiDung;
    }
    public void setNoiDung(String noiDung) {
        this.noiDung = noiDung;
    }
    public Timestamp getNgayGui() {
        return ngayGui;
    }
    public void setNgayGui(Timestamp ngayGui) {
        this.ngayGui = ngayGui;
    }
    public boolean isTrangThai() {
        return trangThai;
    }
    public void setTrangThai(boolean trangThai) {
        this.trangThai = trangThai;
    }
}
