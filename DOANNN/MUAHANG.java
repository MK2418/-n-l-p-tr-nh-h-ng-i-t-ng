public class MUAHANG extends QLBH {
    @Override
    public void menuChinh() {
        int chon;
        do {
            System.out.println("\n===== MENU BAN HANG =====");
            System.out.println("1. Mua hang");
            System.out.println("2. Xem danh sach san pham");
            System.out.println("3. Xem hoa Don");
            System.out.println("0. Thoat");
            System.out.print("Chọn: ");
            chon = Integer.parseInt(sc.nextLine());

            switch (chon) {
                case 1 -> muaHang();
                case 2 -> dsDoDungHocTap.xuat();
                case 3 -> dsHoaDon.xuat();
                case 0 -> System.out.println("Thoat menu ban hsang...");
                default -> System.out.println("Chon sai, vui long nhap lai!");
            }

        } while (chon != 0);
    }
}