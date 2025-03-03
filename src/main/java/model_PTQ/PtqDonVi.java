package model_PTQ;

public class PtqDonVi {
    private int id;
    private String tenDonVi;
    private String diaChi;
    private String soDienThoai;

    public PtqDonVi() {}

    public PtqDonVi(int id, String tenDonVi, String diaChi, String soDienThoai) {
        this.id = id;
        this.tenDonVi = tenDonVi;
        this.diaChi = diaChi;
        this.soDienThoai = soDienThoai;
    }

    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }

    public String getTenDonVi() {
        return tenDonVi;
    }
    public void setTenDonVi(String tenDonVi) {
        this.tenDonVi = tenDonVi;
    }

    public String getDiaChi() {
        return diaChi;
    }
    public void setDiaChi(String diaChi) {
        this.diaChi = diaChi;
    }

    public String getSoDienThoai() {
        return soDienThoai;
    }
    public void setSoDienThoai(String soDienThoai) {
        this.soDienThoai = soDienThoai;
    }
}
