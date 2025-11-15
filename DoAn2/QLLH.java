import java.util.*;

public class QLLH extends QLBH {
    Dsloaihang ds = new Dsloaihang();
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
                case 1 -> ds.xuat();
                case 2 -> ds.them();
                case 3 -> ds.xoa();
                case 4 -> ds.sua();
                case 5 -> ds.timkiem();
                case 6 -> ds.thongkeMota();
                case 0 -> System.out.println("Thoat quan ly loai hang.");
                default -> System.out.println("Chon sai, vui long nhap lai!");
            }
        } while (chon != 0);
    }
}


