import java.util.*;

public class QLSP extends QLBH {
    Scanner sc = new Scanner(System.in);

    @Override
    public void menuChinh() {
        // Đọc file trước khi vào menu
        try {
            dsDoDungHocTap.docFile("dodunghoctap.txt");
        } catch (Exception e) {
            System.out.println("Loi khi doc du lieu: " + e.getMessage());
        }

        int choice;
        do {
            System.out.println("\n===== QUAN LY SAN PHAM =====");
            System.out.println("1. Xem danh sach san pham");
            System.out.println("2. Them san pham");
            System.out.println("3. Xoa san pham");
            System.out.println("4. Sua thong tin san pham");
            System.out.println("5. Tim kiem san pham");
            System.out.println("6. Thong ke san pham");
            System.out.println("0. Thoat");
            System.out.print("Nhap lua chon cua ban: ");
            choice = sc.nextInt();
            sc.nextLine();

            switch (choice) {
                case 1:
                    dsDoDungHocTap.xuat();
                    break;
                case 2:
                    dsDoDungHocTap.them();
                    break;
                case 3:
                    dsDoDungHocTap.xoa();
                    break;
                case 4:
                    dsDoDungHocTap.sua();
                    break;
                case 5:
                    dsDoDungHocTap.timkiem();
                    break;
                case 6:
                    dsDoDungHocTap.thongKe();
                    break;
                case 0:
                    // Ghi file khi thoát
                    try {
                        dsDoDungHocTap.ghiFile("dodunghoctap.txt");
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
