import java.util.Scanner;

public class QLKH extends QLBH {
    Dskhachhang ds = new Dskhachhang();
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
                case 1 -> ds.xuat();

                case 2 -> {
                    // Tạo khách hàng mới trực tiếp
                    System.out.println("Nhap ma khach hang moi: ");
                    String makh = sc.nextLine();
                    System.out.println("Nhap ho khach hang: ");
                    String ho = sc.nextLine();
                    System.out.println("Nhap ten khach hang: ");
                    String ten = sc.nextLine();
                    System.out.println("Nhap dia chi: ");
                    String diachi = sc.nextLine();
                    System.out.println("Nhap so dien thoai: ");
                    int sdt = sc.nextInt();
                    sc.nextLine();

                    Khachhang khMoi = new Khachhang();
                    khMoi.setMakh(makh);
                    khMoi.setHo(ho);
                    khMoi.setTen(ten);
                    khMoi.setDiaChi(diachi);
                    khMoi.setSdt(sdt);

                    ds.them(khMoi);
                }

                case 3 -> {
                    System.out.println("Nhap ma khach hang can xoa: ");
                    String makh = sc.nextLine();
                    ds.xoa(makh);
                }

                case 4 -> {
                    System.out.println("Nhap ma khach hang can sua: ");
                    String makh = sc.nextLine();

                    System.out.println("Nhap ho khach hang moi: ");
                    String ho = sc.nextLine();
                    System.out.println("Nhap ten khach hang moi: ");
                    String ten = sc.nextLine();
                    System.out.println("Nhap dia chi moi: ");
                    String diachi = sc.nextLine();
                    System.out.println("Nhap so dien thoai moi: ");
                    int sdt = sc.nextInt();
                    sc.nextLine();

                    Khachhang khMoi = new Khachhang();
                    khMoi.setMakh(makh);
                    khMoi.setHo(ho);
                    khMoi.setTen(ten);
                    khMoi.setDiaChi(diachi);
                    khMoi.setSdt(sdt);

                    ds.sua(makh, khMoi);
                }
                case 5 -> ds.timkiem(); 
                case 6 -> ds.thongke(); 
                case 0 -> System.out.println("Thoat quan ly khach hang.");
                default -> System.out.println("Chon sai, vui long nhap lai!");
            }
        } while (chon != 0);
    }
}
