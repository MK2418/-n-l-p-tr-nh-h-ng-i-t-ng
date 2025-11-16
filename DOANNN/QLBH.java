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
        System.out.printf("| %-8s | %-10s | %-10s | %-10s | %-10s |\n",
                "    ", "QUY1", "QUY2", "QUY3", "QUY4");
        System.out.printf("| %-8s | %-10s | %-10s | %-10s | %-10s |\n",
                "TONG CHI", dsPhieuNhapHang.TKQuy1(2025), dsPhieuNhapHang.TKQuy2(2025), dsPhieuNhapHang.TKQuy3(2025),
                dsPhieuNhapHang.TKQuy4(2025));
        System.out.printf("| %-8s | %-10s | %-10s | %-10s | %-10s |\n",
                "TONG THU", dsHoaDon.TKQuy1(2025), dsHoaDon.TKQuy2(2025), dsHoaDon.TKQuy3(2025), dsHoaDon.TKQuy4(2025));
    }
    
    public static void thongkeTheonam() {
        System.out.printf("| %-8s | %-10s | %-10s | %-10s | %-10s |\n",
                "    ", "2022", "2023", "2024", "2025");
        
        System.out.printf("| %-8s | %-10.2f | %-10.2f | %-10.2f | %-10.2f |\n",
                "TONG CHI",
                dsPhieuNhapHang.TKTheoNam(2022),
                dsPhieuNhapHang.TKTheoNam(2023),
                dsPhieuNhapHang.TKTheoNam(2024),
                dsPhieuNhapHang.TKTheoNam(2025)
        );

        System.out.printf("| %-8s | %-10.2f | %-10.2f | %-10.2f | %-10.2f |\n",
                "TONG THU",
                dsHoaDon.TKTheoNam(2022),
                dsHoaDon.TKTheoNam(2023),
                dsHoaDon.TKTheoNam(2024),
                dsHoaDon.TKTheoNam(2025)
        );
    }


    // ---- MENU CHÍNH ĐỂ RỖNG ----
    public abstract void menuChinh();
}