import java.time.LocalDate;
import java.util.Scanner;

public class Hoadon {
    private String mahd;
    private LocalDate ngayxuathd;
    private double tongtien;
    private String makh;
    private String manv;

    // Ham thiet lap co tham so
    public Hoadon(String mahd, String makh, String manv, LocalDate ngayxuathd) {
        this.mahd = mahd;
        this.ngayxuathd = ngayxuathd;
        this.makh = makh;
        this.manv = manv;
    }

    public Hoadon(String mahd, String makh, String manv, double tien, LocalDate ngayxuathd) {
        this.mahd = mahd;
        this.ngayxuathd = ngayxuathd;
        this.makh = makh;
        this.manv = manv;
        this.tongtien = tien;
    }

    // Ham thiet lap khong tham so
    public Hoadon() {
        mahd = "";
        ngayxuathd = LocalDate.now();
        tongtien = 0.0;
        makh = "";
        manv = "";
    }

    public Hoadon(Hoadon other) {
        this.mahd = other.mahd;
        this.ngayxuathd = other.ngayxuathd;
        this.tongtien = other.tongtien;
        this.makh = other.makh;
        this.manv = other.manv;
    }

    // Ham get
    public String getMahd() {
        return mahd;
    }

    public LocalDate getNgayxuathd() {
        return ngayxuathd;
    }

    public double getTongtien() {
        return tongtien;
    }

    public String getMaKh() {
        return makh;
    }

    public String getMaNv() {
        return manv;
    }

    // Ham set
    public void setMahd(String mahd) {
        this.mahd = mahd;
    }

    public void setNgayxuathd(LocalDate ngayxuathd) {
        this.ngayxuathd = ngayxuathd;
    }

    public void setTongtien(double tongtien) {
        this.tongtien = tongtien;
    }

    public void setMaKh(String makh) {
        this.makh = makh;
    }

    public void setMaNv(String manv) {
        this.manv = manv;
    }

    public String toFileString() {
        return String.format("%s,%s,%s,%s,%s",
                mahd, makh, manv, ngayxuathd, tongtien);
    }

    // Ham nhap
    public void nhap() {
        @SuppressWarnings("resource")
        Scanner sc = new Scanner(System.in);
        System.out.print("Nhap ma hoa don: ");
        mahd = sc.nextLine();
        System.out.print("Ma Nhan Vien: ");
        manv = sc.nextLine();
        System.out.print("Ma Khach Hang: ");
        makh = sc.nextLine();
        System.out.println("Nhap ngay xuat hoa don ");
        ngayxuathd = LocalDate.parse(sc.nextLine());
    }

    // Ham xuat
    public void xuat() {
        System.out.printf("%-10s %-15s %-15s %-20s %-15.2f%n",
                mahd, makh, manv, ngayxuathd, tongtien);
    }
}