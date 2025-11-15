import java.util.Scanner;

public class QLHD extends QLBH {
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
            System.out.println("7. Thong ke chi tiet hoa don");
            System.out.println("0. Thoat");
            System.out.print("Chon: ");
            chon = sc.nextInt();
            sc.nextLine();

            switch (chon) {
                case 1 -> dsHoaDon.xuat();
                case 2 -> dsHoaDon.them();
                case 3 -> dsHoaDon.xoa();
                case 4 -> dsHoaDon.sua();
                case 5 -> dsHoaDon.timkiem();
                case 6 -> dsHoaDon.thongkeDaydu();
                // case 7 -> dsct.thongke();
                case 0 -> {
                    // Ghi file khi thoát
                    try {
                        dsHoaDon.ghiFile("DsHD.txt");
                    } catch (Exception e) {
                        System.out.println("Loi khi ghi file: " + e.getMessage());
                    }
                    System.out.println("Thoat khoi quan ly san pham.");
                    break;
                }
                default -> System.out.println("Chon sai, vui long nhap lai!");
            }
        } while (chon != 0);
    }

}
