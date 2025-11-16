public abstract class QLBH {
    // ---- CÁC DANH SÁCH DÙNG CHUNG ----
    protected static Dsnhanvien dsNhanVien = new Dsnhanvien();
    protected static Dskhachhang dsKhachHang = new Dskhachhang();
    protected static DsHoadon dsHoaDon = new DsHoadon();
    protected static Dsphieunhaphang dsPhieuNhapHang = new Dsphieunhaphang();
    protected static Dsdodunghoctap dsDoDungHocTap = new Dsdodunghoctap();
    protected static Dsloaihang dsLoaiHang = new Dsloaihang();
    protected static Dshangsanxuat dsHangSanXuat = new Dshangsanxuat();
    protected static DsCTDH dsChiTietHoaDon = new DsCTDH();
    protected static Dschitietphieunhaphang dsChiTietPhieuNhap = new Dschitietphieunhaphang();
    protected static Dsnhacungcap dsNhaCungCap = new Dsnhacungcap();

    // ---- HÀM ĐỌC TẤT CẢ FILE ----
    public static void docTatCaFile() {
        try {
            dsNhanVien.docFile("nhanvien.txt");
            dsKhachHang.docFile("DsKH.txt");
            dsHoaDon.docFile("DsHD.txt");
            dsPhieuNhapHang.docFile("Dsphieunhaphang.txt");
            dsDoDungHocTap.docFile("dodunghoctap.txt");
            dsLoaiHang.docFile("loaihang.txt");
            dsHangSanXuat.docFile("hangsanxuat.txt");
            dsChiTietHoaDon.docFile("DsCTHD.txt");
            dsChiTietPhieuNhap.docFile("Dschitietphieunhaphang.txt");
            dsNhaCungCap.docFile("Dsnhacungcap.txt");
            System.out.println("Doc tat ca file thanh cong");
        } catch (Exception e) {
            System.out.println("Loi doc file: " + e.getMessage());
        }
    }

    public static void tongTien() {
        for (PhieuNhapHang pnh : dsPhieuNhapHang.getDs()) {
            double tongTien = 0;
            for (chitietphieunhaphang ct : dsChiTietPhieuNhap.getDs()) {
                if (ct.getMaPNH().equals(pnh.getMaPNH())) {
                    tongTien += ct.getSoLuong() * ct.getDonGia();
                }
            }
            pnh.setTongTien(tongTien);
        }
    }

    public static void tongTienhd() {
        for (Hoadon hd : dsHoaDon.getDS()) {
            double tongTien = 0;
            for (ChiTietDonHang ct : dsChiTietHoaDon.getDS()) {
                if (ct.getMahd().equals(hd.getMahd())) {
                    tongTien = tongTien + ct.getTongtien();
                }
            }
            hd.setTongtien(tongTien);
        }
    }

    public static void thongke() {
        // Lấy tổng lương nhân viên theo quý
        double luongQuy = dsNhanVien.TKQuy(2025);

        // Lấy tổng chi theo quý (nhập hàng)
        double chiQuy1 = dsPhieuNhapHang.TKQuy1(2025);
        double chiQuy2 = dsPhieuNhapHang.TKQuy2(2025);
        double chiQuy3 = dsPhieuNhapHang.TKQuy3(2025);
        double chiQuy4 = dsPhieuNhapHang.TKQuy4(2025);

        // Lấy tổng thu theo quý
        double thuQuy1 = dsHoaDon.TKQuy1(2025);
        double thuQuy2 = dsHoaDon.TKQuy2(2025);
        double thuQuy3 = dsHoaDon.TKQuy3(2025);
        double thuQuy4 = dsHoaDon.TKQuy4(2025);

        // Tính lợi nhuận = Thu - Chi nhập hàng - Lương nhân viên
        double loiNhuanQuy1 = thuQuy1 - chiQuy1 - luongQuy;
        double loiNhuanQuy2 = thuQuy2 - chiQuy2 - luongQuy;
        double loiNhuanQuy3 = thuQuy3 - chiQuy3 - luongQuy;
        double loiNhuanQuy4 = thuQuy4 - chiQuy4 - luongQuy;

        System.out.println("\nBANG THONG KE TAI CHINH NAM 2025");
        System.out.println("==========================================================");
        System.out.printf("| %-12s | %-12s | %-12s | %-12s | %-12s |\n",
                "    ", "QUY 1", "QUY 2", "QUY 3", "QUY 4");
        System.out.println("==========================================================");
        System.out.printf("| %-12s | %-12.2f | %-12.2f | %-12.2f | %-12.2f |\n",
                "TONG CHI", chiQuy1 + luongQuy, chiQuy2 + luongQuy, chiQuy3 + luongQuy, chiQuy4 + luongQuy);
        System.out.printf("| %-12s | %-12.2f | %-12.2f | %-12.2f | %-12.2f |\n",
                "TONG THU", thuQuy1, thuQuy2, thuQuy3, thuQuy4);
        System.out.printf("| %-12s | %-12.2f | %-12.2f | %-12.2f | %-12.2f |\n",
                "LOI NHUAN", loiNhuanQuy1, loiNhuanQuy2, loiNhuanQuy3, loiNhuanQuy4);
        System.out.println("==========================================================");
    }

    public static void thongkeTheonam() {
        // Tính toán trước cho từng năm
        double chi2022 = dsPhieuNhapHang.TKTheoNam(2022);
        double chi2023 = dsPhieuNhapHang.TKTheoNam(2023);
        double chi2024 = dsPhieuNhapHang.TKTheoNam(2024);
        double chi2025 = dsPhieuNhapHang.TKTheoNam(2025) + dsNhanVien.tinhLuongTheoNam(2025);

        double thu2022 = dsHoaDon.TKTheoNam(2022);
        double thu2023 = dsHoaDon.TKTheoNam(2023);
        double thu2024 = dsHoaDon.TKTheoNam(2024);
        double thu2025 = dsHoaDon.TKTheoNam(2025);

        double loiNhuan2022 = thu2022 - chi2022;
        double loiNhuan2023 = thu2023 - chi2023;
        double loiNhuan2024 = thu2024 - chi2024;
        double loiNhuan2025 = thu2025 - chi2025;

        // Hiển thị bảng
        System.out.println("\nBANG THONG KE THEO NAM");
        System.out.println("===================================================================");
        System.out.printf("| %-8s | %-10s | %-10s | %-10s | %-12s |\n",
                "    ", "2022", "2023", "2024", "2025");
        System.out.println("===================================================================");
        System.out.printf("| %-8s | %-10.2f | %-10.2f | %-10.2f | %-10.2f |\n",
                "TONG CHI", chi2022, chi2023, chi2024, chi2025);
        System.out.printf("| %-8s | %-10.2f | %-10.2f | %-10.2f | %-10.2f |\n",
                "TONG THU", thu2022, thu2023, thu2024, thu2025);
        System.out.printf("| %-8s | %-10.2f | %-10.2f | %-10.2f | %-10.2f |\n",
                "LOI NHUAN", loiNhuan2022, loiNhuan2023, loiNhuan2024, loiNhuan2025);
        System.out.println("===================================================================");
    }

    public static void thongkeKhachHangTheoNam() {

        System.out.println("\n============== THONG KE KHACH HANG THEO NAM ==============");

        // Lấy danh sách khách hàng
        Khachhang[] ds = dsKhachHang.getKhachhang();
        int soKH = dsKhachHang.getN();

        // Tiêu đề bảng
        System.out.println("===========================================================================");
        System.out.printf("| %-10s | %-10s | %-10s | %-10s | %-10s |\n",
                "MA KH", "2022", "2023", "2024", "2025");
        System.out.println("===========================================================================");

        // Duyệt tất cả khách hàng
        for (int i = 0; i < soKH; i++) {
            String maKH = ds[i].getMakh();

            double nam2022 = dsHoaDon.TKKHtheonam(2022, maKH);
            double nam2023 = dsHoaDon.TKKHtheonam(2023, maKH);
            double nam2024 = dsHoaDon.TKKHtheonam(2024, maKH);
            double nam2025 = dsHoaDon.TKKHtheonam(2025, maKH);

            System.out.printf("| %-10s | %-10.2f | %-10.2f | %-10.2f | %-10.2f |\n",
                    maKH, nam2022, nam2023, nam2024, nam2025);
        }

        System.out.println("===========================================================================");
    }

    // ---- MENU CHÍNH ĐỂ RỖNG ----
    public abstract void menuChinh();
}
