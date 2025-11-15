import java.util.*;

public class QLCTHD extends QLBH {
    Scanner sc = new Scanner(System.in);

    @Override
    public void menuChinh() {

        int choice;
        do {
            System.out.println("\n===== QUAN LY CHI TIET HOA DON =====");
            System.out.println("1. Xem danh sach chi tiet hoa don ");
            System.out.println("2. Them chi tiet hoa don");
            System.out.println("3. Xoa chi tiet hoa don");
            System.out.println("4. Sua thong tin chi tiet hoa don");
            System.out.println("5. Tim kiem chi tiet hoa don");
            System.out.println("6. Thong ke chi tiet hoa don theo dia chi");
            System.out.println("0. Thoat");
            System.out.print("Nhap lua chon cua ban: ");
            choice = sc.nextInt();
            sc.nextLine(); // Consume newline

            switch (choice) {
                case 1:
                    System.out.println("\n--- DANH SACH CHI TIET HOA DON ---");
                    dsChiTietHoaDon.xuat();
                    break;
                case 2:
                    System.out.println("\n--- THEM CHI TIET HOA DON MOI ---");
                    dsChiTietHoaDon.them();
                    break;
                case 3:
                    System.out.println("\n--- XOA CHI TIET HOA DON ---");
                    dsChiTietHoaDon.xoa();
                    break;
                case 4:
                    System.out.println("\n--- SUA THONG TIN CHI TIET HOA DON ---");
                    dsChiTietHoaDon.sua();
                    break;
                case 5:
                    System.out.println("\n--- TIM KIEM CHI TIET HOA DON ---");
                    dsChiTietHoaDon.timkiem();
                    break;
                // case 6:
                // System.out.println("\n--- THONG KE NHA CHUNG CAP THEO DIA CHI ---");
                // dsNhaCungCap.thongke();
                case 0:
                    System.out.println("Thoat khoi quan ly chi tiet hoa don .");
                    break;
                default:
                    System.out.println("Lua chon khong hop le. Vui long thu lai.");
            }
        } while (choice != 0);
    }
}