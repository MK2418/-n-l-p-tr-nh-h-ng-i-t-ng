import java.util.Scanner;

public class QLHD extends QLBH {
    DsHoadon ds;
    Scanner sc = new Scanner(System.in);

    @Override
    public void menuChinh() {
        int chon;
        do {
            System.out.println("\n=== MENU QUAN LY HOA DON ===");
            System.out.println("1. Xuat danh sach hoa don");
            System.out.println("2. Them hoa don moi");
            System.out.println("3. Xoa hoa don");
            System.out.println("4. Sua hoa don");
            System.out.println("5. Tim hoa don");
            System.out.println("6. Thong ke hoa don theo ma khach hang");
            System.out.println("0. Thoat");
            System.out.print("Chon: ");
            chon = sc.nextInt();
            sc.nextLine();

            switch (chon) {
                case 1 -> ds.xuat();
                case 2 -> {
                    System.out.print("Nhap ma hoa don: ");
                    String mahd = sc.nextLine();
                    System.out.print("Nhap ma khach hang: ");
                    String makh = sc.nextLine();
                    System.out.print("Nhap ma nhan vien: ");
                    String manv = sc.nextLine();
                    System.out.print("Nhap tong tien: ");
                    double tongtien = sc.nextDouble();
                    sc.nextLine();

                    Hoadon hdMoi = new Hoadon();
                    hdMoi.setMahd(mahd);
                    Khachhang kh = new Khachhang();
                    kh.setMakh(makh);
                    hdMoi.setMaKh(kh);
                    Nhanvien nv = new Nhanvien();
                    nv.setManv(manv);
                    hdMoi.setMaNv(nv);
                    hdMoi.setTongtien(tongtien);

                    ds.them(hdMoi);
                }
                case 3 -> {
                    System.out.print("Nhap ma hoa don can xoa: ");
                    String mahd = sc.nextLine();
                    ds.xoa(mahd);
                }
                case 4 -> {
                    System.out.print("Nhap ma hoa don can sua: ");
                    String mahd = sc.nextLine();

                    System.out.print("Nhap ma khach hang moi: ");
                    String makh = sc.nextLine();
                    System.out.print("Nhap ma nhan vien moi: ");
                    String manv = sc.nextLine();
                    System.out.print("Nhap tong tien moi: ");
                    double tongtien = sc.nextDouble();
                    sc.nextLine();

                    Hoadon hdMoi = new Hoadon();
                    Khachhang kh = new Khachhang();
                    kh.setMakh(makh);
                    hdMoi.setMaKh(kh);
                    Nhanvien nv = new Nhanvien();
                    nv.setManv(manv);
                    hdMoi.setMaNv(nv);
                    hdMoi.setTongtien(tongtien);

                    ds.sua(mahd, hdMoi);
                }
                case 5 -> ds.timkiem();
                case 6 -> ds.thongkeDaydu();
                case 0 -> System.out.println("Thoat quan ly hoa don.");
                default -> System.out.println("Chon sai, vui long nhap lai!");
            }
        } while (chon != 0);
    }

}
