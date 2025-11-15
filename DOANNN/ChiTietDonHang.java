import java.util.Scanner;

public class ChiTietDonHang {
    private String mahd;
    private String msp;
    private int sl;
    private double dongia;
    private double tongtien;
    Scanner sc = new Scanner(System.in);

    public ChiTietDonHang() {
    }

    public ChiTietDonHang(String mahd, String msp, int sl, double dongia) {
        this.mahd = mahd;
        this.msp = msp;
        this.sl = sl;
        this.dongia = dongia;
        this.tongtien = sl * dongia;
    }

    public ChiTietDonHang(ChiTietDonHang other) {
        this.mahd = other.mahd;
        this.msp = other.msp;
        this.sl = other.sl;
        this.dongia = other.dongia;
        this.tongtien = other.tongtien;
    }

    public void nhap() {
        System.out.print("Nhap ma hoa don: ");
        mahd = sc.nextLine();
        System.out.print("Nhap ma san pham: ");
        msp = sc.nextLine();
        System.out.print("Nhap so luong: ");
        sl = sc.nextInt();
        System.out.print("Nhap don gia: ");
        dongia = sc.nextDouble();
        sc.nextLine();
        tongtien = sl * dongia;
    }

    public void xuat() {
        System.out.printf("%-12s %-15s %-10s %-15s %-15s%n",
                "Mã HĐ", "Mã SP", "Số lượng", "Đơn giá", "Tổng tiền");
        System.out.println("--------------------------------------------------------------------------");
        System.out.printf("%-12s %-15s %-10d %-15.2f %-15.2f%n",
                mahd, msp, sl, dongia, tongtien);
    }

    public String toFileString() {
        return String.format("%s,%s,%s,%s,%s",
                mahd, msp, sl, dongia, tongtien);
    }

    public String getMahd() {
        return mahd;
    }

    public void setMahd(String mahd) {
        this.mahd = mahd;
    }

    public String getMsp() {
        return msp;
    }

    public void setMsp(String msp) {
        this.msp = msp;
    }

    public int getSl() {
        return sl;
    }

    public void setSl(int sl) {
        this.sl = sl;
        this.tongtien = sl * this.dongia;
    }

    public double getDongia() {
        return dongia;
    }

    public void setDongia(double dongia) {
        this.dongia = dongia;
        this.tongtien = this.sl * dongia;
    }

    public double getTongtien() {
        return tongtien;
    }
}