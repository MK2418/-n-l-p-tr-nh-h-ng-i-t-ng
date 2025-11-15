import java.util.Scanner;

public class QLHD extends QLBH {
    Scanner sc = new Scanner(System.in);

    @Override
    public void menuChinh() {
        int choice;
        do {
            System.out.println("\n===== QUAN LY HOA DON =====");
            System.out.println("1. Xem danh sach hoa don");
            System.out.println("2. Them hoa don");
            System.out.println("3. Xoa hoa don");
            System.out.println("4. Tim kiem hoa don");
            System.out.println("5. Sua hoa don");
            System.out.println("6. Thong ke theo ma hoa don");
            System.out.println("0. Thoat");
            System.out.print("Nhap lua chon cua ban: ");
            choice = sc.nextInt();
            sc.nextLine(); // Consume newline
            
            switch (choice) {
                case 1:
                    System.out.println("\n--- danh sach hoa don ---");
                    dsHoaDon.xuat();
                    break;
                case 2:
                    System.out.println("\n--- them hoa don moi ---");
                    dsHoaDon.them();
                    break;
                case 3:
                    System.out.println("\n--- xoa hoa don moi ---");
                    dsHoaDon.xoa();
                    break;
                case 4:
                    System.out.println("\n--- tim kiem hoa don ---");
                    dsHoaDon.timkiem();
                    break;
                case 5:
                    System.out.println("\n--- sua hoa don ---");
                    dsHoaDon.sua();
                    break;
                case 0:
                    System.out.println("Thoat khoi quan ly hoa don.");
                    break;
                default:
                    System.out.println("Lua chon khong hop le. Vui long thu lai.");

            }
        } while (choice != 0);
    }

}

