import java.util.Scanner;

public class QLKH extends QLBH {
    Scanner sc = new Scanner(System.in);

    @Override
    public void menuChinh() {
        int choice;
        do {
            System.out.println("\n===== QUAN LY KHACH HANG =====");
            System.out.println("1. Xem danh sach khach hang");
            System.out.println("2. Them khach hang");
            System.out.println("3. Xoa khach hang");
            System.out.println("4. Tim kiem khach hang");
            System.out.println("5. Sua khach hang");
            System.out.println("6. Thong ke theo ma khach hang");
            System.out.println("0. Thoat");
            System.out.print("Nhap lua chon cua ban: ");
            choice = sc.nextInt();
            sc.nextLine(); // Consume newline
            switch (choice) {
                case 1:
                    System.out.println("\n--- danh sach khach hang ---");
                    dsHoaDon.xuat();
                    break;
                case 2:
                    System.out.println("\n--- them khach hang moi ---");
                    dsHoaDon.them();
                    break;
                case 3:
                    System.out.println("\n--- xoa khach hang ---");
                    dsHoaDon.xoa();
                    break;
                case 4:
                    System.out.println("\n--- tim kiem khach hang ---");
                    dsHoaDon.timkiem();
                    break;
                case 5:
                    System.out.println("\n--- sua khach hang ---");
                    dsHoaDon.sua();
                    break;
                case 0:
                    System.out.println("Thoat khoi quan ly khach hang.");
                    break;
                default:
                    System.out.println("Lua chon khong hop le. Vui long thu lai.");
            }
        } while (choice != 0);
    }

}
