import java.util.Arrays;
import java.util.Scanner;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.time.LocalDate;

class Dsphieunhaphang {
    private PhieuNhapHang[] ds; // mảng lưu các phiếu nhập
    private int soLuong; // số lượng phiếu hiện có
    private Scanner sc = new Scanner(System.in);

    // ====== Constructor ======
    public Dsphieunhaphang() {
        ds = new PhieuNhapHang[0];
        soLuong = 0;
    }

    public void docFile(String filename) throws Exception {
        try (BufferedReader br = new BufferedReader(new FileReader(filename))) {
            soLuong = Integer.parseInt(br.readLine());
            ds = new PhieuNhapHang[soLuong];
            for (int i = 0; i < soLuong; i++) {
                String line = br.readLine();
                if (line == null)
                    break;
                String[] parts = line.split(",");
                ds[i] = new PhieuNhapHang(parts[0], LocalDate.parse(parts[1]), parts[2], parts[3]);
            }
        }
    }

    public void ghiFile(String filename) throws Exception {
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(filename))) {
            bw.write(soLuong + "");
            bw.newLine();
            for (int i = 0; i < soLuong; i++) {
                if (ds[i] != null) {
                    bw.write(ds[i].toFileString());
                    bw.newLine();
                }
            }
        }
        System.out.println("Da ghi du lieu vao file thanh cong!");
    }

    // ====== Xuất danh sách phiếu nhập hàng ======
    public void xuat() {
        if (soLuong == 0) {
            System.out.println("Chua co phieu nhap nao!");
            return;
        }
        System.out.println("\n===================== DANH SACH PHIEU NHAP HANG ====================");
        System.out.printf("| %-8s | %-12s | %-10s | %-10s | %-12s |\n",
                "Ma PNH", "Ngay Nhap", "Nhan Vien", "NCC", "Tong Tien");
        System.out.println("--------------------------------------------------------------------");

        for (int i = 0; i < soLuong; i++) {
            ds[i].xuat();
        }
        System.out.println("--------------------------------------------------------------------");
    }

    // Ham co ban khong tham so
    // ====== Tìm phiếu nhập hàng theo mã ======
    public void timPhieuNhap() {
        System.out.println("Nhap ma can tim kiem");
        String ma = sc.nextLine();
        System.out.printf("| %-8s | %-12s | %-10s | %-10s | %-12s |\n",
                "Ma PNH", "Ngay Nhap", "Nhan Vien", "NCC", "Tong Tien");
        for (int i = 0; i < soLuong; i++) {
            if (ds[i].getMaPNH().equalsIgnoreCase(ma)) {
                ds[i].xuat();
            }
        }

    }

    // ====== Thêm 1 phiếu nhập hàng ======
    public void themPhieuNhap() {
        ds = Arrays.copyOf(ds, soLuong + 1);
        ds[soLuong] = new PhieuNhapHang();
        ds[soLuong].nhap();
        soLuong++;
    }

    // ====== Xoá phiếu nhập hàng theo mã ======
    public void xoaPhieuNhapTheoMa() {
        String ma = sc.nextLine();
        for (int i = 0; i < soLuong; i++) {
            if (ds[i].getMaPNH().equalsIgnoreCase(ma)) {
                for (int j = i; j < soLuong - 1; j++) {
                    ds[j] = ds[j + 1];
                }
                ds = Arrays.copyOf(ds, soLuong - 1);
                soLuong--;
                System.out.println("Da xoa phieu nhap hang co ma  " + ma);
                return;
            }
        }
        System.out.println("Khong tim thay phieu co ma  " + ma);
    }

    // ====== Sửa thông tin phiếu nhập hàng theo mã ======
    public void suaPNH() {
        String maPNH = sc.nextLine();
        for (int i = 0; i < soLuong; i++) {
            if (ds[i].getMaPNH().equals(maPNH)) {
                int k;
                do {
                    System.out.println("\n--- Sua thong tin phieu nhap hang ---");
                    System.out.println("1. Sua ma phieu nhap hang");
                    System.out.println("2. Sua ngay nhap hang");
                    System.out.println("3. Sua nhan vien");
                    System.out.println("4. Sua nha cung cap");
                    System.out.println("0. Thoat sua");
                    System.out.print("Nhap lua chon: ");
                    k = sc.nextInt();
                    sc.nextLine(); // bỏ dòng thừa

                    switch (k) {
                        case 1:
                            System.out.print("Nhap ma phieu nhap hang moi: ");
                            ds[i].setMaPNH(sc.nextLine());
                            break;
                        case 2:
                            System.out.print("Nhap ngay nhap hang moi: ");
                            ds[i].setNgayNhap(LocalDate.parse(sc.nextLine()));
                            break;
                        case 3:
                            System.out.print("Nhap ma nhan vien moi: ");
                            ds[i].setNv(sc.nextLine());
                            break;
                        case 4:
                            System.out.print("Nhap nha cung cap moi: ");
                            ds[i].setNcc(sc.nextLine());
                            break;
                        case 0:
                            System.out.println("Da thoat sua thong tin.");
                            break;
                        default:
                            System.out.println("Lua chon khong hop le!");
                            break;
                    }
                } while (k != 0);
                return;
            }
        }
        System.out.println("Khong tim thay phieu nhap hang voi ma nay.");
    }

    // Ham co ban co tham so
    public PhieuNhapHang[] timPhieuNhapcothamso(String ma) {
        String manh = ma;

        // Đếm số lượng kết quả trùng khớp
        int count = 0;
        for (int i = 0; i < soLuong; i++) {
            if (ds[i].getMaPNH().equalsIgnoreCase(manh)) {
                count++;
            }
        }

        // Tạo mảng kết quả
        PhieuNhapHang[] ketQua = new PhieuNhapHang[count];
        int index = 0;

        System.out.printf("| %-8s | %-12s | %-10s | %-10s | %-12s |\n",
                "Ma PNH", "Ngay Nhap", "Nhan Vien", "NCC", "Tong Tien");

        for (int i = 0; i < soLuong; i++) {
            if (ds[i].getMaPNH().equalsIgnoreCase(manh)) {
                ds[i].xuat();
                ketQua[index++] = ds[i]; // Thêm vào mảng kết quả
            }
        }

        if (count == 0) {
            System.out.println("Khong tim thay phieu nhap hang voi ma: " + manh);
        }

        return ketQua;
    }

    public void themPhieuNhap(String ma, LocalDate ngay, String nv, String ncc) {
        ds = Arrays.copyOf(ds, soLuong + 1);
        ds[soLuong] = new PhieuNhapHang();
        ds[soLuong].setMaPNH(ma);
        ds[soLuong].setNgayNhap(ngay);
        ds[soLuong].setNv(nv);
        ds[soLuong].setNcc(ncc);
        soLuong++;
    }

    public void xoaPhieuNhapTheoMacothamso(String mapnh) {
        String ma = mapnh;
        for (int i = 0; i < soLuong; i++) {
            if (ds[i].getMaPNH().equalsIgnoreCase(ma)) {
                for (int j = i; j < soLuong - 1; j++) {
                    ds[j] = ds[j + 1];
                }
                ds = Arrays.copyOf(ds, soLuong - 1);
                soLuong--;
                System.out.println("Da xoa phieu nhap hang co ma  " + ma);
                return;
            }
        }
        System.out.println("Khong tim thay phieu co ma  " + ma);
    }

    public void suaPNHcothamso(String ma) {
        String maPNH = ma;
        for (int i = 0; i < soLuong; i++) {
            if (ds[i].getMaPNH().equals(maPNH)) {
                int k;
                do {
                    System.out.println("\n--- Sua thong tin phieu nhap hang ---");
                    System.out.println("1. Sua ma phieu nhap hang");
                    System.out.println("2. Sua ngay nhap hang");
                    System.out.println("3. Sua nhan vien");
                    System.out.println("4. Sua nha cung cap");
                    System.out.println("0. Thoat sua");
                    System.out.print("Nhap lua chon: ");
                    k = sc.nextInt();
                    sc.nextLine(); // bỏ dòng thừa

                    switch (k) {
                        case 1:
                            System.out.print("Nhap ma phieu nhap hang moi: ");
                            ds[i].setMaPNH(sc.nextLine());
                            break;
                        case 2:
                            System.out.print("Nhap ngay nhap hang moi: ");
                            ds[i].setNgayNhap(LocalDate.parse(sc.nextLine()));
                            break;
                        case 3:
                            System.out.print("Nhap ma nhan vien moi: ");
                            ds[i].setNv(sc.nextLine());
                            break;
                        case 4:
                            System.out.print("Nhap nha cung cap moi: ");
                            ds[i].setNcc(sc.nextLine());
                            break;
                        case 0:
                            System.out.println("Da thoat sua thong tin.");
                            break;
                        default:
                            System.out.println("Lua chon khong hop le!");
                            break;
                    }
                } while (k != 0);
                return;
            }
        }
        System.out.println("Khong tim thay phieu nhap hang voi ma nay.");
    }

    public void thongke() {
        String[] ma = new String[soLuong];
        int[] n = new int[soLuong];
        int count = 0;
        for (int i = 0; i < soLuong; i++) {
            boolean found = false;
            String mancc = ds[i].getNcc();
            for (int j = 0; j < count; j++) {
                if (ma[j].equals(mancc)) {
                    n[j]++;
                    found = true;
                    break;
                }
            }
            if (!found) {
                ma[count] = mancc;
                n[count] = 1;
                count++;
            }
        }
        for (int i = 0; i < count; i++) {
            System.out.println(ma[i] + ": co " + n[i] + " phieu nhap hang");
        }

    }

    public double TKQuy1(int nam) {
        double tien = 0.0;
        for (int i = 0; i < soLuong; i++) {
            if (ds[i].getNgayNhap().getYear() == nam) {
                int thang = ds[i].getNgayNhap().getMonthValue();
                if (thang >= 1 && thang <= 3) {
                    tien = tien + ds[i].getTongTien();
                }
            }
        }
        return tien;
    }

    public double TKQuy2(int nam) {
        double tien = 0.0;
        for (int i = 0; i < soLuong; i++) {
            if (ds[i].getNgayNhap().getYear() == nam) {
                int thang = ds[i].getNgayNhap().getMonthValue();
                if (thang >= 4 && thang <= 6) {
                    tien = tien + ds[i].getTongTien();
                }
            }
        }
        return tien;
    }

    public double TKQuy3(int nam) {
        double tien = 0.0;
        for (int i = 0; i < soLuong; i++) {
            if (ds[i].getNgayNhap().getYear() == nam) {
                int thang = ds[i].getNgayNhap().getMonthValue();
                if (thang >= 7 && thang <= 9) {
                    tien = tien + ds[i].getTongTien();
                }
            }
        }
        return tien;
    }

    public double TKQuy4(int nam) {
        double tien = 0.0;
        for (int i = 0; i < soLuong; i++) {
            if (ds[i].getNgayNhap().getYear() == nam) {
                int thang = ds[i].getNgayNhap().getMonthValue();
                if (thang >= 10 && thang <= 12) {
                    tien = tien + ds[i].getTongTien();
                }
            }
        }
        return tien;
    }

    public double TKTheoNam(int nam) {
        double tong = 0.0;
        for (PhieuNhapHang pnh : ds) {
            if (pnh != null && pnh.getNgayNhap().getYear() == nam) {
                tong += pnh.getTongTien();
            }
        }
        return tong;
    }

    public PhieuNhapHang[] getDs() {
        return ds;
    }

    public int getSoLuong() {
        return soLuong;
    }

    public void setDanhSach(PhieuNhapHang[] ds, int soLuong) {
        this.ds = ds;
        this.soLuong = soLuong;
    }
}
