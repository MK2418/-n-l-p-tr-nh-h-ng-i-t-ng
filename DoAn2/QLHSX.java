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
                    dsHangSanXuat.them();
                    break;
                }
                case 3: {
                    System.out.println("========== Xoa hang san xuat ==========");
                    dsHangSanXuat.xoa();
                    break;
                }
                case 4: {
                    System.out.println("========== Sua hang san xuat ==========");
                    dsHangSanXuat.sua();
                    break;
                }
                case 5: {
                    System.out.println("========== Tim hang san xuat ==========");
                    dsHangSanXuat.timkiem();
                    break;
                }
                case 6: {
                    System.out.println("========== Thong ke hang san xuat theo do dai ten hang san xuat ==========");
                    dsHangSanXuat.thongke();
                    break;
                }
                case 0: System.out.println("Thoat quan ly hang san xuat.");
                default: System.out.println("Chon sai, vui long nhap lai!");
            }
        } while (chon != 0);
    }
}


