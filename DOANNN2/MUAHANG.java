import java.time.LocalDate;

public class MUAHANG extends QLBH {
    @Override
    public void menuChinh() {
        int chon;
        do {
            System.out.println("\n===== MENU BAN HANG =====");
            System.out.println("1. Tao hoa don moi va mua hang");
            System.out.println("2. Xem danh sach san pham");
            System.out.println("3. Xem hoa don");
            System.out.println("0. Thoat");
            System.out.print("Chon: ");
            chon = Integer.parseInt(sc.nextLine());

            switch (chon) {
                case 1 -> muaHangNhieu();
                case 2 -> dsDoDungHocTap.xuat();
                case 3 -> dsHoaDon.xuat();
                case 0 -> System.out.println("Thoat menu ban hang...");
                default -> System.out.println("Chon sai, vui long nhap lai!");
            }

        } while (chon != 0);
    }

    // Ham mua nhieu mat hang trong mot hoa don
    private void muaHangNhieu() {
        System.out.println("\n===== TAO HOA DON MUA HANG =====");

        // Tao ma hoa don
        LocalDate today = LocalDate.now();
        System.out.println("Nhap ma hoa don");
        String ma = sc.nextLine();
        String maHD = String.format(ma, today.getYear(), today.getMonthValue(),
                today.getDayOfMonth(), dsHoaDon.getDS().length + 1);

        double tongTienHD = 0;
        int soMatHang = 0;

        System.out.print("Nhap ma khach hang: ");
        String maKH = sc.nextLine().trim();
        if (maKH.isEmpty())
            maKH = "KH01";

        System.out.print("Nhap ma nhan vien : ");
        String maNV = sc.nextLine().trim();
        if (maNV.isEmpty())
            maNV = "NV01";

        boolean tiepTuc = true;
        while (tiepTuc) {
            System.out.println("\n--- Them san pham vao hoa don ---");
            System.out.print("Nhap ma san pham (hoac 'x' de ket thuc): ");
            String maSP = sc.nextLine().trim();

            if (maSP.equalsIgnoreCase("x")) {
                tiepTuc = false;
                break;
            }

            // Tim san pham
            Dodunghoctap sp = dsDoDungHocTap.timkiemcothamso(maSP);
            if (sp == null) {
                System.out.println("San pham khong ton tai!");
                continue;
            }

            System.out.println("Ten: " + sp.getTenSP());
            System.out.println("Gia: " + sp.getDonGia());
            System.out.println("SL ton kho: " + sp.getSoLuong());

            // Nhap so luong
            System.out.print("Nhap so luong can mua: ");
            int sl;
            try {
                sl = Integer.parseInt(sc.nextLine().trim());
            } catch (NumberFormatException e) {
                System.out.println("So luong khong hop le!");
                continue;
            }

            if (sl <= 0) {
                System.out.println("So luong phai lon hon 0!");
                continue;
            }

            if (sl > sp.getSoLuong()) {
                System.out.println("Kho khong du! Chi con " + sp.getSoLuong() + " san pham");
                continue;
            }

            // Tinh tien cho san pham nay
            double thanhTien = sl * sp.getDonGia();
            tongTienHD += thanhTien;
            soMatHang++;

            // Cap nhat so luong ton kho
            sp.setSoLuong(sp.getSoLuong() - sl);

            // Tao chi tiet hoa don
            dsChiTietHoaDon.themCothamso(maHD, maSP, sl, (double) sp.getDonGia());

            System.out.println("Da them: " + sp.getTenSP() + " x" + sl + " = " + thanhTien);
        }

        if (soMatHang == 0) {
            System.out.println("Chua co san pham nao trong hoa don!");
            return;
        }

        // Tao hoa don chinh
        dsHoaDon.themCothamso(maHD, maKH, maNV, LocalDate.now(), tongTienHD);

        // Xuat hoa don
        System.out.println("\n===== HOA DON BAN HANG =====");
        System.out.println("════════════════════════════════════════");
        System.out.println("Ma HD        : " + maHD);
        System.out.println("Ma KH        : " + maKH);
        System.out.println("Ma NV        : " + maNV);
        System.out.println("Ngay         : " + LocalDate.now());
        System.out.println("════════════════════════════════════════");
        System.out.println("Chi tiet:");

        // Hien thi chi tiet tu array
        ChiTietDonHang[] chiTietArray = dsChiTietHoaDon.getDS();
        int count = 0;
        for (ChiTietDonHang ct : chiTietArray) {
            if (ct != null && ct.getMahd().equals(maHD)) {
                System.out.printf("  %d. %s x%d = %.0f%n",
                        ++count, ct.getMsp(), ct.getSl(), ct.getTongtien());
            }
        }

        System.out.println("════════════════════════════════════════");
        System.out.printf("TONG TIEN    : %.0f%n", tongTienHD);
        System.out.println("════════════════════════════════════════");
        System.out.println("MUA HANG THANH CONG !");
    }
}