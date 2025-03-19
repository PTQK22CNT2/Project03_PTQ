package PTQ_model;

public class User_PTQ {
    private int id;  // Thêm thuộc tính id
    private String ptqEmail;
    private String ptqMatKhau;
    private String ptqVaiTro;
    private String ptqHoTen;

    // Constructor mặc định
    public User_PTQ() {}

    // Constructor có tham số (bao gồm id)
    public User_PTQ(int id, String ptqEmail, String ptqMatKhau, String ptqVaiTro, String ptqHoTen) {
        this.id = id;
        this.ptqEmail = ptqEmail;
        this.ptqMatKhau = ptqMatKhau;
        this.ptqVaiTro = ptqVaiTro;
        this.ptqHoTen = ptqHoTen;
    }
    
    // Constructor không có id (dùng cho trường hợp insert, id tự tăng)
    public User_PTQ(String ptqEmail, String ptqMatKhau, String ptqVaiTro, String ptqHoTen) {
        this.ptqEmail = ptqEmail;
        this.ptqMatKhau = ptqMatKhau;
        this.ptqVaiTro = ptqVaiTro;
        this.ptqHoTen = ptqHoTen;
    }

    // Getter và Setter cho id
    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }

    // Getter và Setter cho ptqEmail
    public String getPtqEmail() {
        return ptqEmail;
    }
    public void setPtqEmail(String ptqEmail) {
        this.ptqEmail = ptqEmail;
    }

    // Getter và Setter cho ptqMatKhau
    public String getPtqMatKhau() {
        return ptqMatKhau;
    }
    public void setPtqMatKhau(String ptqMatKhau) {
        this.ptqMatKhau = ptqMatKhau;
    }

    // Getter và Setter cho ptqVaiTro
    public String getPtqVaiTro() {
        return ptqVaiTro;
    }
    public void setPtqVaiTro(String ptqVaiTro) {
        this.ptqVaiTro = ptqVaiTro;
    }

    // Getter và Setter cho ptqHoTen
    public String getPtqHoTen() {
        return ptqHoTen;
    }
    public void setPtqHoTen(String ptqHoTen) {
        this.ptqHoTen = ptqHoTen;
    }
}
