import java.util.Scanner;

public class QLKH extends QLBH {
    Scanner sc = new Scanner(System.in);

    @Override
    public void menuChinh() {
        int chon;
        do {
            System.out.println("\n=== MENU QUAN LY KHACH HANG ===");
            System.out.println("1. Xuat danh sach khach hang");
            System.out.println("2. Them khach hang moi");
            System.out.println("3. Xoa khach hang");
            System.out.println("4. Sua khach hang");
            System.out.println("5. Tim khach hang");
            System.out.println("6. Thong ke khach hang theo ma khach hang");
            System.out.println("0. Thoat");
            System.out.print("Chon: ");
            chon = sc.nextInt();
            sc.nextLine();

            switch (chon) {
                case 1 -> dsKhachHang.xuat();
                case 2 -> dsKhachHang.them();
                case 3 -> dsKhachHang.xoa();
                case 4 -> dsKhachHang.sua();
                case 5 -> dsKhachHang.timkiem();
                case 6 -> dsKhachHang.thongke();
                case 0 -> {
                    // Ghi file khi thoát
                    try {
                        dsKhachHang.ghiFile("DsKH.txt");
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