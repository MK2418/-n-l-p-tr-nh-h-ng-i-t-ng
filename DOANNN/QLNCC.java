import java.util.*;

public class QLNCC extends QLBH {
    Scanner sc = new Scanner(System.in);

    @Override
    public void menuChinh() {

        int choice;
        do {
            System.out.println("\n===== QUAN LY NHA CUNG CAP =====");
            System.out.println("1. Xem danh sach nha cung cap");
            System.out.println("2. Them nha cung cap");
            System.out.println("3. Xoa nha cung cap");
            System.out.println("4. Sua thong tin nha cung cap");
            System.out.println("5. Tim kiem nha cung cap");
            System.out.println("6. Thong ke nha cung cap theo dia chi");
            System.out.println("0. Thoat");
            System.out.print("Nhap lua chon cua ban: ");
            choice = sc.nextInt();
            sc.nextLine(); // Consume newline

            switch (choice) {
                case 1:
                    System.out.println("\n--- DANH SACH NHA CUNG CAP ---");
                    dsNhaCungCap.xuat();
                    break;
                case 2:
                    System.out.println("\n--- THEM NHA CUNG CAP MOI ---");
                    dsNhaCungCap.them();
                    break;
                case 3:
                    System.out.println("\n--- XOA NHA CUNG CAP ---");
                    dsNhaCungCap.xoa();
                    break;
                case 4:
                    System.out.println("\n--- SUA THONG TIN NHA CUNG CAP ---");
                    dsNhaCungCap.sua();
                    break;
                case 5:
                    System.out.println("\n--- TIM KIEM NHA CUNG CAP ---");
                    dsNhaCungCap.timkiem();
                    break;
                case 6:
                    System.out.println("\n--- THONG KE NHA CHUNG CAP THEO DIA CHI ---");
                    dsNhaCungCap.thongke();
                    break;
                case 0:
                    // Ghi file khi thoát
                    try {
                        dsNhaCungCap.ghiFile("Dsnhacungcap.txt");
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