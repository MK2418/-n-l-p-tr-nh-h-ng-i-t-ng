import java.util.Scanner;

public abstract class Dodunghoctap {
    public String maSP, tenSP, donViTinh, maLoai, maSX;
    public int soLuong, donGia;

    // Hàm có tham số
    public Dodunghoctap(String maSP, String tenSP, int soLuong, int donGia,
            String donViTinh, String maLoai, String maSX) {
        this.maSP = maSP;
        this.tenSP = tenSP;
        this.soLuong = soLuong;
        this.donGia = donGia;
        this.donViTinh = donViTinh;
        this.maLoai = maLoai;
        this.maSX = maSX;
    }

    // Hàm không tham số
    public Dodunghoctap() {
        maSP = "";
        tenSP = "";
        donViTinh = "";
        maLoai = "";
        maSX = "";
        soLuong = 0;
        donGia = 0;
    }

    // Hàm thiết lập sao chép
    public Dodunghoctap(Dodunghoctap other) {
        this.maSP = other.maSP;
        this.tenSP = other.tenSP;
        this.soLuong = other.soLuong;
        this.donGia = other.donGia;
        this.donViTinh = other.donViTinh;
        this.maLoai = other.maLoai;
        this.maSX = other.maSX;
    }

    // Phương thức nhập
    public void nhap() {
        java.util.Scanner sc = new java.util.Scanner(System.in);
        System.out.print("Nhap ma san pham: ");
        maSP = sc.nextLine();
        System.out.print("Nhap ten san pham: ");
        tenSP = sc.nextLine();
        System.out.print("Nhap so luong: ");
        soLuong = Integer.parseInt(sc.nextLine());
        System.out.print("Nhap don gia: ");
        donGia = Integer.parseInt(sc.nextLine());
        System.out.print("Nhap don vi tinh: ");
        donViTinh = sc.nextLine();
        System.out.print("Nhap ma loai: ");
        maLoai = sc.nextLine();
        System.out.print("Nhap ma san xuat: ");
        maSX = sc.nextLine();
    }

    // Phương thức xuất
    public void xuat() {
        String ten = tenSP.length() > 15 ? tenSP.substring(0, 12) + "..." : tenSP;
        System.out.printf("%-10s %-15s %8d %,12d %-8s %-8s %-8s \n",
                maSP, ten, soLuong, donGia, donViTinh, maLoai, maSX);
    }

    public abstract String toFileString();

    // Getter methods
    public String getMaSP() {
        return maSP;
    }

    public String getTenSP() {
        return tenSP;
    }

    public int getSoLuong() {
        return soLuong;
    }

    public int getDonGia() {
        return donGia;
    }

    public String getDonViTinh() {
        return donViTinh;
    }

    public String getMaLoai() {
        return maLoai;
    }

    public String getMaSX() {
        return maSX;
    }

    // Setter methods
    public void setMaSP(String maSP) {
        this.maSP = maSP;
    }

    public void setTenSP(String tenSP) {
        this.tenSP = tenSP;
    }

    public void setSoLuong(int soLuong) {
        this.soLuong = soLuong;
    }

    public void setDonGia(int donGia) {
        this.donGia = donGia;
    }

    public void setdonViTinh(String donViTinh) {
        this.donViTinh = donViTinh;
    }

    public void setmaLoai(String maLoai) {
        this.maLoai = maLoai;
    }

    public void setmaSX(String maSX) {
        this.maSX = maSX;
    }

    // Phương thức toString
    @Override
    public String toString() {
        return "Dodunghoctap{" +
                "maSP='" + maSP + '\'' +
                ", tenSP='" + tenSP + '\'' +
                ", soLuong=" + soLuong +
                ", donGia=" + donGia +
                ", donViTinh='" + donViTinh + '\'' +
                ", maLoai='" + maLoai + '\'' +
                ", maSX='" + maSX + '\'' +
                '}';
    }
}
