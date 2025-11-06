import java.util.Scanner;

public class QLKH {
    Dskhachhang ds = new Dskhachhang();
    Scanner sc = new Scanner(System.in);
    
    public void menu() throws Exception {
        int chon;
        do {
            System.out.println("\n=== MENU QUẢN LÝ KHÁCH HÀNG ===");
            System.out.println("1. Nhập danh sách khách hàng");
            System.out.println("2. Xuất danh sách khách hàng");
            System.out.println("3. Thêm khách hàng");
            System.out.println("4. Xóa khách hàng");
            System.out.println("5. Sửa khách hàng");
            System.out.println("6. Tìm kiếm khách hàng");
            System.out.println("0. Thoát");
            System.out.print("Chọn: ");
            chon = sc.nextInt(); sc.nextLine();

            switch (chon) {
                case 1 -> ds.docFile("DsKH.txt");
                case 2 -> ds.xuat();
                case 3 -> ds.them();
                case 4 -> ds.xoa();
                case 5 -> ds.sua();
                case 6 -> ds.timkiem();
                case 0 -> System.out.println("Thoát quản lý khách hàng.");
                default -> System.out.println("Chọn sai, vui lòng nhập lại!");
            }
        } while (chon != 0);
    }
}
