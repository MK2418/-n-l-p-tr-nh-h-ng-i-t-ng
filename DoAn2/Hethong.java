import java.util.*;

public class Hethong {
    public void menuchinh() {
        Scanner sc = new Scanner(System.in);
        int chon;
        QLBH ql;

        QLBH.tongTien();
        do {
            System.out.println("\n=== MENU CHINH HE THONG ===");
            System.out.println("1. Quan ly nha cung cap");
            System.out.println("2. Quan ly san pham");
            System.out.println("3. Quan ly hoa don");
            System.out.println("4. Quan ly chi tiet hoa don");
            System.out.println("5. Quan ly khach hang");
            System.out.println("6. Quan ly nhan vien");
            System.out.println("7. Quan ly loai hang");
            System.out.println("8. Quan ly hang san xuat");
            System.out.println("9. Quan ly phieu nhap hang");
            System.out.println("10. Quan ly chi tiet phieu nhap hang");
            System.out.println("11. Thong ke");
            System.out.println("0. Thoat");
            System.out.print("Chon: ");
            chon = sc.nextInt();
            sc.nextLine();

            switch (chon) {
                case 1:
                    ql = new QLNCC();
                    ql.menuChinh();
                    break;
                case 2:
                    ql = new QLSP();
                    ql.menuChinh();
                    break;
                case 3:
                    ql = new QLHD();
                    ql.menuChinh();
                    break;
                case 4:
                    ql = new QLCTHD();
                    ql.menuChinh();
                    break;
                case 5:
                    ql = new QLKH();
                    ql.menuChinh();
                    break;
                case 6:
                    ql = new QLNV();
                    ql.menuChinh();
                    break;
                case 7:
                    ql = new QLLH();
                    ql.menuChinh();
                    break;
                case 8:
                    ql = new QLHSX();
                    ql.menuChinh();
                    break;
                case 9:
                    ql = new QLPNH();
                    ql.menuChinh();
                    break;
                case 10:
                    ql = new QLCTPNH();
                    ql.menuChinh();
                    break;
                case 0:
                    System.out.println("Thoat chuong trinh!");
                    break;
                default:
                    System.out.println("Lua chon khong hop le!");
            }
        } while (chon != 0);

        sc.close();
    }
}