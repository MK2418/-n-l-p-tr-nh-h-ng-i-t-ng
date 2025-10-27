import java.util.*;

class Nhacungcap {
    private String maNCC;
    private String tenNCC;
    private String diaChi;
    private int soDienThoai;
    Scanner sc = new Scanner(System.in);

    public Nhacungcap() {
        maNCC = "";
        tenNCC = "";
        diaChi = "";
        soDienThoai = 0;
    }

    public Nhacungcap(String maNCC, String tenNCC, String diaChi, int soDienThoai) {
        this.maNCC = maNCC;
        this.tenNCC = tenNCC;
        this.diaChi = diaChi;
        this.soDienThoai = soDienThoai;
    }

    public void nhap() {
        sc.nextLine(); // bỏ dòng trống nếu còn
        System.out.print("Nhap ma nha cung cap: ");
        maNCC = sc.nextLine();
        System.out.print("Nhap ten nha cung cap: ");
        tenNCC = sc.nextLine();
        System.out.print("Nhap dia chi: ");
        diaChi = sc.nextLine();
        System.out.print("Nhap so dien thoai: ");
        soDienThoai = sc.nextInt();
    }

    public void xuat() {
        System.out.println("Ma nha cung cap: " + maNCC);
        System.out.println("Ten nha cung cap: " + tenNCC);
        System.out.println("Dia chi: " + diaChi);
        System.out.println("So dien thoai: " + soDienThoai);
    }

    public String getMaNCC() {
        return maNCC;
    }

    public void setMaNCC(String maNCC) {
        this.maNCC = maNCC;
    }

    public void setTenNCC(String tenNCC) {
        this.tenNCC = tenNCC;
    }

    public void setDiaChi(String diaChi) {
        this.diaChi = diaChi;
    }

    public void setSoDienThoai(int soDienThoai) {
        this.soDienThoai = soDienThoai;
    }
}
