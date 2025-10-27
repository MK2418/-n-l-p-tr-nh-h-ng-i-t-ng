import java.util.*;

public class home {
    public static void main(String[] args) {
        Dsnhacungcap dsncc = new Dsnhacungcap();
        Nhacungcap[] ncc = new Nhacungcap[5];
        ncc[0] = new Nhacungcap("NCC001", "Cung Cap A", "123 Duong A", 123456789);
        ncc[1] = new Nhacungcap("NCC002", "Cung Cap B", "456 Duong B", 987654321);
        ncc[2] = new Nhacungcap("NCC003", "Cung Cap C", "789 Duong C", 112233445);
        ncc[3] = new Nhacungcap("NCC004", "Cung Cap D", "321 Duong D", 556677889);
        ncc[4] = new Nhacungcap("NCC005", "Cung Cap E", "654 Duong E", 998877665);
        dsncc.setDanhSach(ncc, 5);

        Scanner sc = new Scanner(System.in);
        int k;
        do {
            System.out.println("\n===== QUAN LY NHA CUNG CAP =====");
            System.out.println("1. Them nha cung cap");
            System.out.println("2. Hien thi danh sach nha cung cap");
            System.out.println("3. Tim kiem nha cung cap theo ma");
            System.out.println("4. Xoa nha cung cap theo ma");
            System.out.println("5. Sua thong tin nha cung cap theo ma");
            System.out.println("0. Thoat");
            System.out.print("Nhap lua chon: ");
            k = sc.nextInt();
            sc.nextLine(); // bỏ dòng trống

            switch (k) {
                case 1:
                    dsncc.themNCC();
                    break;
                case 2:
                    dsncc.xuat();
                    break;
                case 3:
                    dsncc.timKiemNCC();
                    break;
                case 4:
                    System.out.print("Nhap ma nha cung cap can xoa: ");
                    String maXoa = sc.nextLine();
                    dsncc.xoaNCC(maXoa);
                    break;
                case 5:
                    System.out.print("Nhap ma nha cung cap can sua: ");
                    String maSua = sc.nextLine();
                    dsncc.suaNCC(maSua);
                    break;
                case 0:
                    System.out.println("Da thoat chuong trinh.");
                    break;
                default:
                    System.out.println("Lua chon khong hop le!");
            }
        } while (k != 0);
    }
}