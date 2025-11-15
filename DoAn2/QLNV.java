import java.util.*;

public class QLNV extends QLBH {
    Scanner sc = new Scanner(System.in);

    @Override
    public void menuChinh() {
        int chon;
        do {
            System.out.println("\n=== MENU QUAN LY  NHAN VIEN ===");
            System.out.println("1. Xuat danh sach nhan vien.");
            System.out.println("2. Them nhan vien moi.");
            System.out.println("3. Xoa nhan vien.");
            System.out.println("4. Sua nhan vien.");
            System.out.println("5. Tim nhan vien.");
            System.out.println("6. Thong ke nhan vien theo luong nhan vien.");
            System.out.println("0. Thoat");
            System.out.print("Chon: ");
            chon = sc.nextInt();
            sc.nextLine();

            switch (chon) {
                case 1: {
                    System.out.println("========== Danh sách nhan vien ==========");
                    dsNhanVien.xuat();
                    break;
                }
                case 2: {
                    System.out.println("========== Them nhan vien ==========");
                    dsNhanVien.them();
                    break;
                }
                case 3: {
                    System.out.println("========== Xoa nhan vien ==========");
                    dsNhanVien.xoa();
                    break;
                }
                case 4: {
                    System.out.println("========== Sua nhan vien ==========");
                    dsNhanVien.sua();
                    break;
                }
                case 5: {
                    System.out.println("========== Tim nhan vien ==========");
                    dsNhanVien.timkiem();
                    break;
                }
                case 6: {
                    System.out.println("========== Thong ke luong nhan vien ==========");
                    dsNhanVien.thongke();
                    break;
                }
                case 0: System.out.println("Thoat quan ly nhan vien.");
                default: System.out.println("Chon sai, vui long nhap lai!");
            }
        } while (chon != 0);
    }
}


