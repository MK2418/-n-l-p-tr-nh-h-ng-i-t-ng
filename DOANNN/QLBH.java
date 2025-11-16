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

    // ---- MENU CHÍNH ĐỂ RỖNG ----
    public abstract void menuChinh();
}
