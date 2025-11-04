import java.time.LocalDate;
import java.util.*;

class PhieuNhapHang {
    private String maPNH;
    private LocalDate ngayNhap;
    private String nv;
    private String ncc;
    private int tongTien;

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

    public void nhap() {
        Scanner sc = new Scanner(System.in);
        System.out.print("Nhap ma phieu nhap hang: ");
        maPNH = sc.nextLine();
        System.out.print("Nhap ngay nhap (YYYY-MM-DD): ");
        ngayNhap = LocalDate.parse(sc.nextLine());
        System.out.print("Nhap ten nhan vien: ");
        nv = sc.nextLine();
        System.out.print("Nhap ma nha cung cap: ");
        ncc = sc.nextLine();
    }

    public void xuatThongTin() {
        System.out.println("Ma PNH: " + maPNH);
        System.out.println("Ngay Nhap: " + ngayNhap);
        System.out.println("Ma nhan Vien: " + nv);
        System.out.println("Ma nha Cung Cap: " + ncc);
        System.out.println("Tong Tien: " + tongTien);
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

    public int getTongTien() {
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

    public void setTongTien(int tongTien) {
        this.tongTien = tongTien;
    }
}
