import java.util.Scanner;

public class QLCTHD extends QLBH {
    Scanner sc = new Scanner(System.in);

    @Override
    public void menuChinh() {
        int choice;
        do {
            System.out.println("\n===== QUAN LY CHI TIET PHIEU NHAP HANG =====");
            System.out.println("1. Xem danh sach chi tiet hoa don");
            System.out.println("2. Them chi tiet hoa don");
            System.out.println("3. Xoa chi tiet hoa don");
            System.out.println("4. Tim kiem chi tiet hoa don");
            System.out.println("5. Sua chi tiet hoa don");
            System.out.println("6. Thong ke theo ma hoa don");
            System.out.println("0. Thoat");
            System.out.print("Nhap lua chon cua ban: ");
            choice = sc.nextInt();
            sc.nextLine(); // Consume newline

            switch (choice) {
                case 1:
                    System.out.println("\n--- danh sach cho tiet hoa don ---");
                    dsChiTietHoaDon.xuat();
                    break;
                case 2:
                    System.out.println("\n--- them chi tiet hoa don moi ---");
                    dsChiTietHoaDon.them();
                    break;
                case 3:
                    System.out.println("\n--- xoa chi tiet hoa don moi ---");
                    dsChiTietHoaDon.xoa();
                    break;
                case 4:
                    System.out.println("\n--- tim kiem chi tiet hoa don ---");
                    dsChiTietHoaDon.timkiem();
                    break;
                case 5:
                    System.out.println("\n--- sua chi tiet hoa don ---");
                    dsChiTietHoaDon.sua();
                    break;
                case 0:
                    System.out.println("Thoat khoi quan ly chi tiet hoa don.");
                    break;
                default:
                    System.out.println("Lua chon khong hop le. Vui long thu lai.");
            }
        } while (choice != 0);
    }

}
