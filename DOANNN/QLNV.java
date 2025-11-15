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
                    // dsNhanVien.them();
                    dsNhanVien.themcothamso("NV09", "Tran", "Kim", 4500000);
                    System.out.println("Da them NV09 Tran Kim luong 4500000\n");
                    break;
                }
                case 3: {
                    System.out.println("========== Xoa nhan vien ==========");
                    // dsNhanVien.xoa();
                    dsNhanVien.xoacothamso("NV07");
                    System.out.println("Da duoi NV07 Nguyen Ha luong 4700000\n");
                    break;
                }
                case 4: {
                    System.out.println("========== Sua nhan vien ==========");
                    // dsNhanVien.sua();
                    dsNhanVien.suacothamso("NV04", "Pham", "Long", 4500000);
                    System.out.println("Da sua nhan vien NV04 Pham Long luong lai thanh");
                    break;
                }
                case 5: {
                    System.out.println("========== Tim nhan vien ==========");
                    // dsNhanVien.timkiem();
                    dsNhanVien.timkiemcothamso("NV02");
                    break;
                }
                case 6: {
                    System.out.println("========== Thong ke luong nhan vien ==========");
                    dsNhanVien.thongke();
                    break;
                }
                case 0:
                    // Ghi file khi thoát
                    try {
                        dsNhanVien.ghiFile("nhanvien.txt");
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
