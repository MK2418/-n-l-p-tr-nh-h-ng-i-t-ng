import java.util.*;

public class QLLH extends QLBH {
    Scanner sc = new Scanner(System.in);

    @Override
    public void menuChinh() {
        int chon;
        do {
            System.out.println("\n=== MENU QUAN LY LOAI HANG ===");
            System.out.println("1. Xuat danh sach loai hang.");
            System.out.println("2. Them loai hang moi.");
            System.out.println("3. Xoa loai hang.");
            System.out.println("4. Sua loai hang.");
            System.out.println("5. Tim loai hang.");
            System.out.println("6. Thong ke loai hang theo mo ta loai hang.");
            System.out.println("0. Thoat");
            System.out.print("Chon: ");
            chon = sc.nextInt();
            sc.nextLine();

            switch (chon) {
                case 1: {
                    System.out.println("========== Danh sách loai hang ==========");
                    dsLoaiHang.xuat();
                    break;
                }
                case 2: {
                    System.out.println("========== Them loai hang ==========");
                    // dsLoaiHang.them();
                    dsLoaiHang.themcothamso("LH04", "Giay", "Giay AUTO 10D");
                    System.out.println("Da them loai hang LH04 Giay AUTO 10D");
                    break;
                }
                case 3: {
                    System.out.println("========== Xoa loai hang ==========");
                    // dsLoaiHang.xoa();
                    dsLoaiHang.xoacothamso("LH02");
                    System.out.println("Da xoa loai hang LH02 Giay ve");
                    break;
                }
                case 4: {
                    System.out.println("========== Sua loai hang ==========");
                    // dsLoaiHang.sua();
                    dsLoaiHang.suacothamso("LH01", "But", "But cute");
                    System.out.println("Da sua loai hang LH01 lai thanh But cute");
                    break;
                }
                case 5: {
                    System.out.println("========== Tim loai hang ==========");
                    // dsLoaiHang.timkiem();
                    dsLoaiHang.timkiemcothamso("LH03");
                    break;
                }
                case 6: {
                    System.out.println("========== Thong ke loai hang theo mo ta loai hang ==========");
                    dsLoaiHang.thongke();
                    break;
                }
                case 0:
                    // Ghi file khi thoát
                    try {
                        dsLoaiHang.ghiFile("loaihang.txt");
                    } catch (Exception e) {
                        System.out.println("Loi khi ghi file: " + e.getMessage());
                    }
                    System.out.println("Thoat khoi quan ly san pham.");
                    break;
                default:
                    System.out.println("Lua chon khong hop le!");
            }
        } while (chon != 0);
    }
}
