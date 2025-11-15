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
                    dsLoaiHang.them();
                    break;
                }
                case 3: {
                    System.out.println("========== Xoa loai hang ==========");
                    dsLoaiHang.xoa();
                    break;
                }
                case 4: {
                    System.out.println("========== Sua loai hang ==========");
                    dsLoaiHang.sua();
                    break;
                }
                case 5: {
                    System.out.println("========== Tim loai hang ==========");
                    dsLoaiHang.timkiem();
                    break;
                }
                case 6: {
                    System.out.println("========== Thong ke loai hang theo mo ta loai hang ==========");
                    dsLoaiHang.thongkeMota();
                    break;
                }
                case 0: System.out.println("Thoat quan ly loai hang.");
                default: System.out.println("Chon sai, vui long nhap lai!");
            }
        } while (chon != 0);
    }
}


