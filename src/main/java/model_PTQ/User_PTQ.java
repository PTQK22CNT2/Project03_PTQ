package model_PTQ;

public class User_PTQ {
    private String ptqEmail;
    private String ptqMatKhau;
    private String ptqVaiTro;

    // Constructor mặc định
    public User_PTQ() {}

    // Constructor có tham số
    public User_PTQ(String ptqEmail, String ptqMatKhau, String ptqVaiTro) {
        this.ptqEmail = ptqEmail;
        this.ptqMatKhau = ptqMatKhau;
        this.ptqVaiTro = ptqVaiTro;
    }

    // Getter & Setter
    public String getPtqEmail() {
        return ptqEmail;
    }

    public void setPtqEmail(String ptqEmail) {
        this.ptqEmail = ptqEmail;
    }

    public String getPtqMatKhau() {
        return ptqMatKhau;
    }

    public void setPtqMatKhau(String ptqMatKhau) {
        this.ptqMatKhau = ptqMatKhau;
    }

    public String getPtqVaiTro() {
        return ptqVaiTro;
    }

    public void setPtqVaiTro(String ptqVaiTro) {
        this.ptqVaiTro = ptqVaiTro;
    }
}
