import java.time.LocalDate;
import java.util.Scanner;

public class Hoadon {
    String mahd;
    LocalDate ngayxuathd;
    double tongtien;
    private Khachhang makh;
    private Nhanvien manv;
    
 // Ham thiet lap khong tham so
    public Hoadon() {
    	mahd = "";
        makh = new Khachhang();
        manv = new Nhanvien();
        ngayxuathd = LocalDate.now();
        tongtien = 0;
    }

    // Ham thiet lap co tham so
    public Hoadon(String mahd, LocalDate ngayxuathd, Khachhang makh, Nhanvien manv) {
        this.mahd = mahd;
        this.ngayxuathd = ngayxuathd;
        this.makh = makh;
        this.manv = manv;
    }

    public Hoadon(Hoadon other) {
        this.mahd = other.mahd;
        this.ngayxuathd = other.ngayxuathd;
        this.makh = new Khachhang(other.makh);
        this.manv = new Nhanvien(other.manv);
    }
    
 // Ham nhap
    public void nhap() {
        Scanner sc = new Scanner(System.in);
        makh = new Khachhang();
        manv = new Nhanvien();

        System.out.print("Nhap ma hoa don: ");
        mahd = sc.nextLine();

        System.out.print("Ma Khach Hang: ");
        makh.setMakh(sc.nextLine());

        System.out.print("Ma Nhan Vien: ");
        manv.setManv(sc.nextLine());

        System.out.print("Tong tien: ");
        tongtien = sc.nextDouble();
        // tổng tiền của chi tiết hóa đơn...

    }

    // Ham xuat
    public void xuat() {
        System.out.printf("%-10s %-15s %-15s %-20s %-15s%n",
            "Mã HĐ", "Mã KH", "Mã NV", "Ngày xuất", "Tổng tiền");
        System.out.println("--------------------------------------------------------------------------");
        System.out.printf("%-10s %-15s %-15s %-20s %-15.2f%n",
            mahd, makh.getMakh(), manv.getManv(), ngayxuathd, tongtien);
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

    public Khachhang getMaKh() {
        return makh;
    }

    public Nhanvien getMaNv() {
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

    public void setMaKh(Khachhang makh) {
        this.makh = makh;
    }

    public void setMaNv(Nhanvien manv) {
        this.manv = manv;
    }

    
}