import java.util.*;

public class QLHSX extends QLBH {
    Scanner sc = new Scanner(System.in);

    @Override
    public void menuChinh() {
        int chon;
        do {
            System.out.println("\n=== MENU QUAN LY HANG SAN XUAT ===");
            System.out.println("1. Xuat danh sach hang san xuat.");
            System.out.println("2. Them hang san xuat moi.");
            System.out.println("3. Xoa hang san xuat.");
            System.out.println("4. Sua hang san xuat.");
            System.out.println("5. Tim hang san xuat.");
            System.out.println("6. Thong ke hang san xuat theo do dai ten hang san xuat.");
            System.out.println("0. Thoat");
            System.out.print("Chon: ");
            chon = sc.nextInt();
            sc.nextLine();

            switch (chon) {
                case 1: {
                    System.out.println("========== Danh sách hang san xuat ==========");
                    dsHangSanXuat.xuat();
                    break;
                }
                case 2: {
                    System.out.println("========== Them hang san xuat ==========");
                    // dsHangSanXuat.them();
                    dsHangSanXuat.themcothamso("HSX05", "SuperStar", "Ho Chi Minh");
                    System.out.println("Da them hang san xuat HSX05 SuperStar dia chi o Ho Chi Minh");
                    break;
                }
                case 3: {
                    System.out.println("========== Xoa hang san xuat ==========");
                    // dsHangSanXuat.xoa();
                    dsHangSanXuat.xoacothamso("HSX02");
                    System.out.println("Da xoa hang san xuat HSX02 KingStar dia chi o Da Nang");
                    break;
                }
                case 4: {
                    System.out.println("========== Sua hang san xuat ==========");
                    // dsHangSanXuat.sua();
                    dsHangSanXuat.suacothamso("HSX01", "Thien Long", "Ha Noi");
                    System.out.println("Da sua hang san xủa HSX01 Thien Long dia chi o Ha Noi");
                    break;
                }
                case 5: {
                    System.out.println("========== Tim hang san xuat ==========");
                    // dsHangSanXuat.timkiem();
                    dsHangSanXuat.timkiemcothamso("HSX04");
                    break;
                }
                case 6: {
                    System.out.println("========== Thong ke hang san xuat theo do dai ten hang san xuat ==========");
                    dsHangSanXuat.thongke();
                    break;
                }
                case 0:
                    // Ghi file khi thoát
                    try {
                        dsHangSanXuat.ghiFile("hangsanxuat.txt");
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
