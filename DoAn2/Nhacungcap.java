import java.util.*;

class Nhacungcap {
    private String maNCC;
    private String tenNCC;
    private String diaChi;
    private int soDienThoai;
    Scanner sc = new Scanner(System.in);

    // Ham thiet lap khong tham so
    public Nhacungcap() {
        maNCC = "";
        tenNCC = "";
        diaChi = "";
        soDienThoai = 0;
    }

    // Ham thiet lap co tham so
    public Nhacungcap(String maNCC, String tenNCC, String diaChi, int soDienThoai) {
        this.maNCC = maNCC;
        this.tenNCC = tenNCC;
        this.diaChi = diaChi;
        this.soDienThoai = soDienThoai;
    }

    // Ham thiet lap copy
    public Nhacungcap(Nhacungcap ncc) {
        this.maNCC = ncc.maNCC;
        this.tenNCC = ncc.tenNCC;
        this.diaChi = ncc.diaChi;
        this.soDienThoai = ncc.soDienThoai;
    }

    public void xuat() {
        System.out.printf("| %-10s | %-20s | %-20s | %-13s |\n",
                maNCC,
                tenNCC,
                diaChi,
                soDienThoai);
    }

    public void nhap() {
        System.out.print("Ma NCC: ");
        this.maNCC = sc.nextLine();
        System.out.print("Ten nha cung cap: ");
        this.tenNCC = sc.nextLine();
        System.out.print("Dia chi nha cung cap: ");
        this.diaChi = sc.nextLine();
        System.out.print("So dien thoai: ");
        this.soDienThoai = sc.nextInt();
    }

    public String getMaNCC() {
        return maNCC;
    }

    public String getTenNCC() {
        return tenNCC;
    }

    public String getDiaChi() {
        return diaChi;
    }

    public int getSoDienThoai() {
        return soDienThoai;
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
