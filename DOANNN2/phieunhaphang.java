import java.time.LocalDate;
import java.util.*;

class PhieuNhapHang {
    private String maPNH;
    private LocalDate ngayNhap;
    private String nv;
    private String ncc;
    private double tongTien;
    Scanner sc = new Scanner(System.in);

    public PhieuNhapHang() {
        maPNH = "";
        ngayNhap = LocalDate.now();
        nv = "";
        ncc = "";
        tongTien = 0;
    }

    public PhieuNhapHang(String maPhieu, LocalDate ngay, String nv, String ncc) {
        this.maPNH = maPhieu;
        this.ngayNhap = ngay;
        this.nv = nv;
        this.ncc = ncc;
    }

    public PhieuNhapHang(String maPhieu, LocalDate ngay, String nv, String ncc, double tongTien) {
        this.maPNH = maPhieu;
        this.ngayNhap = ngay;
        this.nv = nv;
        this.ncc = ncc;
        this.tongTien = tongTien;
    }

    public PhieuNhapHang(PhieuNhapHang pnh) {
        this.maPNH = pnh.maPNH;
        this.ngayNhap = pnh.ngayNhap;
        this.nv = pnh.nv;
        this.ncc = pnh.ncc;
    }

    public void xuat() {
        System.out.printf("| %-8s | %-12s | %-10s | %-10s | %-12.2f |\n",
                maPNH, ngayNhap, nv, ncc, tongTien);
    }

    public String toFileString() {
        return String.format("%s,%s,%s,%s,%s",
                maPNH, ngayNhap, nv, ncc, tongTien);
    }

    public void nhap() {
        System.out.print("Nhap ma phieu nhap hang: ");
        this.maPNH = sc.nextLine();
        System.out.print("Nhap ngay nhap (YYYY-MM-DD): ");
        this.ngayNhap = LocalDate.parse(sc.nextLine());
        System.out.print("Nhap ma nhan vien: ");
        this.nv = sc.nextLine();
        System.out.print("Nhap nha cung cap: ");
        this.ncc = sc.nextLine();
    }

    public String getMaPNH() {
        return maPNH;
    }

    public LocalDate getNgayNhap() {
        return ngayNhap;
    }

    public String getNv() {
        return nv;
    }

    public String getNcc() {
        return ncc;
    }

    public double getTongTien() {
        return tongTien;
    }

    public void setMaPNH(String maPNH) {
        this.maPNH = maPNH;
    }

    public void setNgayNhap(LocalDate ngayNhap) {
        this.ngayNhap = ngayNhap;
    }

    public void setNv(String nv) {
        this.nv = nv;
    }

    public void setNcc(String ncc) {
        this.ncc = ncc;
    }

    public void setTongTien(double tongTien) {
        this.tongTien = tongTien;
    }
}
