import java.util.*;

public class QLCTHD extends QLBH {
    Scanner sc = new Scanner(System.in);

    @Override
    public void menuChinh() {

        int choice;
        do {
            System.out.println("\n===== QUAN LY CHI TIET HOA DON =====");
            System.out.println("1. Xem danh sach chi tiet hoa don");
            System.out.println("2. Them chi tiet hoa don");
            System.out.println("3. Xoa chi tiet hoa don");
            System.out.println("4. Sua chi tiet hoa don");
            System.out.println("5. Tim kiem chi tiet hoa don");
            System.out.println("6. Thong ke chi tiet hoa don");
            System.out.println("0. Thoat");
            System.out.print("Nhap lua chon cua ban: ");
            choice = sc.nextInt();
            sc.nextLine(); // Consume newline

            switch (choice) {
                case 1:
                    dsChiTietHoaDon.xuat();
                    break;
                case 2:
                	dsChiTietHoaDon.themCothamso("HD888", "SP333", 2, 22000.00);
                	System.out.println("Da them HD888, SP333, 2, 22000.00");
//                    dsChiTietHoaDon.them();
                    break;
                case 3:
                	dsChiTietHoaDon.xoaCothamso("HD004");
                	System.out.println("Da xoa HD004");
//                    dsChiTietHoaDon.xoa();
                    break;
                case 4:
                    dsChiTietHoaDon.suaCothamso("HD005", "SP1001", 666, 1000.0);
                    System.out.println("Da sua HD005, SP1001, 666, 1000.0");
//                  dsChiTietHoaDon.sua();
                    break;
                case 5:
                    dsChiTietHoaDon.timkiemCothamso("HD019");
//                    dsChiTietHoaDon.timkiem();
                    break;
                case 6:
                    dsChiTietHoaDon.thongke();
                case 0:
                    // Ghi file khi thoát
                    try {
                        dsChiTietHoaDon.ghiFile("DsCTHD.txt");
                    } catch (Exception e) {
                        System.out.println("Loi khi ghi file: " + e.getMessage());
                    }
                    System.out.println("Thoat khoi quan ly chi tiet hoa don.");
                    break;
                default:
                    System.out.println("Lua chon khong hop le!");
            }
        } while (choice != 0);
    }
}