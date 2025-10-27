public class MAIN {
    public static void main(String[] args) {
        System.out.println("===== NHAP DANH SACH NHA CUNG CAP =====");
        Dsnhacungcap dsncc = new Dsnhacungcap();
        dsncc.Nhap();

        System.out.println("\n===== NHAP DANH SACH KHACH HANG =====");
        Dskhachhang dskh = new Dskhachhang();
        dskh.Nhap();

        System.out.println("\n===== NHAP DANH SACH NHAN VIEN =====");
        Dsnhanvien dsnv = new Dsnhanvien();
        dsnv.Nhap();

        System.out.println("\n===== NHAP DANH SACH DO DUNG HOC TAP =====");
        Dodunghoctap[] ht = new Dodunghoctap[2];

        ht[0] = new Butviet();
        System.out.println("Nhap thong tin but viet:");
        ht[0].Nhap();

        ht[1] = new Giayso();
        System.out.println("\nNhap thong tin giay so:");
        ht[1].Nhap();

        // Xuất thông tin
        System.out.println("\n===== DANH SACH NHA CUNG CAP =====");
        dsncc.Xuat();

        System.out.println("\n===== DANH SACH KHACH HANG =====");
        dskh.Xuat();

        System.out.println("\n===== DANH SACH NHAN VIEN =====");
        dsnv.Xuat();

        System.out.println("\n===== DANH SACH VAN PHONG PHAM =====");
        for (Dodunghoctap sp : ht) {
            sp.Xuat();
            System.out.println("----------------------------");
        }
    }
}
