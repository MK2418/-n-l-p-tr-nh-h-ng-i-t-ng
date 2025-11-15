import java.util.Scanner;

public class QLPNH extends QLBH {
    Scanner sc = new Scanner(System.in);

    @Override
    public void menuChinh() {
        int choice;
        do {
            System.out.println("\n===== QUAN LY PHIEU NHAP HANG =====");
            System.out.println("1. Xem danh sach phieu nhap hang");
            System.out.println("2. Them phieu nhap hang");
            System.out.println("3. Xoa phieu nhap hang");
            System.out.println("4. Sua thong tin phieu nhap hang");
            System.out.println("5. Tim kiem phieu nhap hang");
            System.out.println("6 Thong ke theo nha cung cap");
            System.out.println("0. Thoat");
            System.out.print("Nhap lua chon cua ban: ");
            choice = sc.nextInt();
            sc.nextLine(); // Consume newline
            switch (choice) {
                case 1:
                    System.out.println("\n--- DANH SACH PHIEU NHAP HANG ---");
                    dsPhieuNhapHang.xuat();
                    break;
                case 2:
                    System.out.println("\n--- THEM PHIEU NHAP HANG MOI ---");
                    dsPhieuNhapHang.themPhieuNhap();
                    break;
                case 3:
                    System.out.println("\n--- XOA PHIEU NHAP HANG ---");
                    dsPhieuNhapHang.xoaPhieuNhapTheoMa();
                    break;
                case 4:
                    System.out.println("\n--- SUA THONG TIN PHIEU NHAP HANG ---");
                    dsPhieuNhapHang.suaPNH();
                    break;
                case 5:
                    System.out.println("\n--- TIM KIEM PHIEU NHAP HANG ---");
                    dsPhieuNhapHang.timPhieuNhap();
                    break;
                case 6:
                    System.out.println("\n--- THONG KE THEO NHA CUNG CAP ---");
                    dsPhieuNhapHang.thongke();
                case 0:
                    // Ghi file khi thoát
                    try {
                        dsPhieuNhapHang.ghiFile("Dsphieunhaphang.txt");
                    } catch (Exception e) {
                        System.out.println("Loi khi ghi file: " + e.getMessage());
                    }
                    System.out.println("Thoat khoi quan ly san pham.");
                    break;
                default:
                    System.out.println("Lua chon khong hop le!");

            }
        } while (choice != 0);
    }
}