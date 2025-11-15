// File: Giayso.java
public class Giayso extends Dodunghoctap {
    public String doDay;
    public String khoGiay;

    // Hàm có tham số
    public Giayso(String maSP, String tenSP, int soLuong, int donGia,
            String donViTinh, String maLoai, String maSX,
            String doDay, String khoGiay) {
        super(maSP, tenSP, soLuong, donGia, donViTinh, maLoai, maSX);
        this.doDay = doDay;
        this.khoGiay = khoGiay;
    }

    // Hàm không tham số
    public Giayso() {
        super();
        doDay = "";
        khoGiay = "";
    }

    // Hàm thiết lập sao chép
    public Giayso(Giayso other) {
        super(other.maSP, other.tenSP, other.soLuong, other.donGia,
                other.donViTinh, other.maLoai, other.maSX);
        this.doDay = other.doDay;
        this.khoGiay = other.khoGiay;
    }

    // Phương thức nhập
    @Override
    public void nhap() {
        super.nhap(); // Gọi phương thức nhập từ lớp cha
        java.util.Scanner sc = new java.util.Scanner(System.in);
        System.out.print("Nhap do day: ");
        doDay = sc.nextLine();
        System.out.print("Nhap kho giay: ");
        khoGiay = sc.nextLine();
    }

    // Phương thức xuất
    @Override
    public void xuat() {
        super.xuat(); // Gọi xuất từ class cha
        System.out.printf(" %-12s %10s\n", doDay, khoGiay);
    }

    @Override
    public String toFileString() {
        return String.format("%s,%s,%d,%d,%s,%s,%s,%s,%s",
                maSP, tenSP, soLuong, donGia, donViTinh, maLoai, maSX, doDay, khoGiay);
    }

    // Getter methods
    public String getDoDay() {
        return doDay;
    }

    public String getKhoGiay() {
        return khoGiay;
    }

    // Setter methods
    public void setDoDay(String doDay) {
        this.doDay = doDay;
    }

    public void setKhoGiay(String khoGiay) {
        this.khoGiay = khoGiay;
    }

    // Phương thức toString
    @Override
    public String toString() {
        return "Giayso{" +
                "maSP='" + maSP + '\'' +
                ", tenSP='" + tenSP + '\'' +
                ", soLuong=" + soLuong +
                ", donGia=" + donGia +
                ", donViTinh='" + donViTinh + '\'' +
                ", maLoai='" + maLoai + '\'' +
                ", maSX='" + maSX + '\'' +
                ", doDay='" + doDay + '\'' +
                ", khoGiay='" + khoGiay + '\'' +
                '}';
    }
}
