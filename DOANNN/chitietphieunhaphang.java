import java.util.Scanner;

class chitietphieunhaphang {
    private String maPNH;
    private String maHang;
    private int soLuong;
    // gia tiền của mỗi đơn vị hàng hóa
    private double donGia;
    Scanner sc = new Scanner(System.in);

    public chitietphieunhaphang() {
        maPNH = "";
        maHang = "";
        soLuong = 0;
        donGia = 0.0;
    }

    public chitietphieunhaphang(String maPNH, String maHang, int soLuong, double donGia) {
        this.maPNH = maPNH;
        this.maHang = maHang;
        this.soLuong = soLuong;
        this.donGia = donGia;
    }

    public chitietphieunhaphang(chitietphieunhaphang ctpnh) {
        this.maPNH = ctpnh.maPNH;
        this.maHang = ctpnh.maHang;
        this.soLuong = ctpnh.soLuong;
        this.donGia = ctpnh.donGia;
    }

    public void xuat() {
        System.out.printf(" | %-10s | %-10s | %-10d | %-10.2f | %-12.2f |\n",
                maPNH, maHang, soLuong, donGia, getThanhtien());
    }

    public void nhap() {
        System.out.print("Ma PNH: ");
        this.maPNH = sc.nextLine();
        System.out.print("Ma Hang: ");
        this.maHang = sc.nextLine();
        System.out.print("So Luong: ");
        this.soLuong = sc.nextInt();
        System.out.print("Don Gia: ");
        this.donGia = sc.nextDouble();
    }

    public String getMaPNH() {
        return maPNH;
    }

    public String getMaHang() {
        return maHang;
    }

    public int getSoLuong() {
        return soLuong;
    }

    public double getDonGia() {
        return donGia;
    }

    public double getThanhtien() {
        return soLuong * donGia;
    }

    // tính tổng tiền của đơn đó
    public double setThanhtien() {
        return soLuong * donGia;
    }

    public void setMaPNH(String maPNH) {
        this.maPNH = maPNH;
    }

    public void setMaHang(String maHang) {
        this.maHang = maHang;
    }

    public void setSoLuong(int soLuong) {
        this.soLuong = soLuong;
    }

    public void setDonGia(double donGia) {
        this.donGia = donGia;
    }
}
