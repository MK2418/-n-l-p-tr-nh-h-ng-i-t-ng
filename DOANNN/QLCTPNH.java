import java.util.*;

public class QLCTPNH extends QLBH {
    Scanner sc = new Scanner(System.in);

    @Override
    public void menuChinh() {
        int choice;
        do {
            System.out.println("\n===== QUAN LY CHI TIET PHIEU NHAP HANG =====");
            System.out.println("1. Xem danh sach chi tiet phieu nhap hang");
            System.out.println("2. Them chi tiet phieu nhap hang");
            System.out.println("3. Xoa chi tiet phieu nhap hang");
            System.out.println("4. Tim kiem chi tiet phieu nhap hang");
            System.out.println("5. Sua chi tiet phieu nhap hang");
            System.out.println("6. Thong ke theo ma PNH");
            System.out.println("0. Thoat");
            System.out.print("Nhap lua chon cua ban: ");
            choice = sc.nextInt();
            sc.nextLine(); // Consume newline

            switch (choice) {
                case 1:
                    System.out.println("\n--- DANH SACH CHI TIET PHIEU NHAP HANG ---");
                    dsChiTietPhieuNhap.xuat();
                    break;
                case 2:
                    System.out.println("\n--- THEM CHI TIET PHIEU NHAP HANG MOI ---");
                    // dsChiTietPhieuNhap.themChiTietPNH();
                    dsChiTietPhieuNhap.themChiTietPNHcothamso("ma01", "sp01", 2, 2000);
                    break;
                case 3:
                    System.out.println("\n--- XOA CHI TIET PHIEU NHAP HANG ---");
                    // dsChiTietPhieuNhap.xoaChiTietPNH();
                    dsChiTietPhieuNhap.xoaChiTietPNHcothamso("ma01");
                    break;
                case 4:
                    System.out.println("\n--- TIM KIEM CHI TIET PHIEU NHAP HANG ---");
                    // dsChiTietPhieuNhap.timKiemChiTietPNH();
                    dsChiTietPhieuNhap.timKiemChiTietPNHcothamso("ma01");
                    break;
                case 5:
                    System.out.println("\n--- SUA CHI TIET PHIEU NHAP HANG ---");
                    // dsChiTietPhieuNhap.suaCTPNH();
                    dsChiTietPhieuNhap.suaCTPNHcothamso("ma01");
                    break;
                case 6:
                    System.out.println("\n--- THONG KE THEO MA PHIEU");
                    dsChiTietPhieuNhap.thongke();
                    break;
                case 0:
                    // Ghi file khi thoát
                    try {
                        dsChiTietPhieuNhap.ghiFile("Dschitietphieunhaphang.txt");
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
