import java.util.Scanner;

public class QLHD{
    DsHoadon ds = new DsHoadon();
    Scanner sc = new Scanner(System.in);

    public void menu() throws Exception {
        int chon;
        do {
            System.out.println("\n=== MENU QUẢN LÝ HÓA ĐƠN ===");
            System.out.println("1. Đọc danh sách hóa đơn từ file");
            System.out.println("2. Xuất danh sách hóa đơn");
            System.out.println("3. Thêm hóa đơn mới");
            System.out.println("4. Xóa hóa đơn");
            System.out.println("5. Sửa hóa đơn");
            System.out.println("6. Tìm hóa đơn");
            System.out.println("7. Thống kê hóa đơn theo mã khách hàng");
            System.out.println("0. Thoát");
            System.out.print("Chọn: ");
            chon = sc.nextInt(); sc.nextLine();

            switch (chon) {
                case 1 -> ds.docFile("DsHD.txt");
                case 2 -> ds.xuat();
                case 3 -> ds.them();
                case 4 -> ds.xoa();
                case 5 -> ds.sua();
                case 6 -> ds.timkiem();
                case 7 -> ds.thongkeDaydu();
                case 0 -> System.out.println("Thoát quản lý hóa đơn.");
                default -> System.out.println("Chọn sai, vui lòng nhập lại!");
            }
        } while (chon != 0);
    }
}
