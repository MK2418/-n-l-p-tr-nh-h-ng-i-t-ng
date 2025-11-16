import java.util.*;

public class QLSP extends QLBH {
    Scanner sc = new Scanner(System.in);

    @Override
    public void menuChinh() {
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
                    // dsDoDungHocTap.them();
                    dsDoDungHocTap.themcothamso("BV06", "But long mau", 40, 6000, "cay", "BV", "TL", "Muc nuoc", 12);
                    System.out.print("Da them SP BV06, But long mau, 40, 6000, cay, BV, TL, Muc nuoc, 12\n");
                    break;
                case 3:
                    // dsDoDungHocTap.xoa();
                    dsDoDungHocTap.xoacothamso("BV01");
                    System.out.print("Da xoa SP BV01, But bi, 20, 5000, cay, BV, TL, Muc dau, 1\n");
                    break;
                case 4:
                    // dsDoDungHocTap.sua();
                    dsDoDungHocTap.suacothamso("BV02", "But da quang", 25, 7000, "cay", "BV", "TL", "Muc nuoc", 3);
                    System.out.println("Da sua SP BV02, But da quang, 25, 7000, cay, BV, TL, Muc nuoc, 3");
                    break;
                case 5:
                    // dsDoDungHocTap.timkiem();
                    dsDoDungHocTap.timkiemcothamso("GS02");
                    break;
                case 6:
                    dsDoDungHocTap.thongke();
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