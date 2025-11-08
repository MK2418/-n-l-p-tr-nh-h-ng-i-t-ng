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
                    bw.write(ds[i].getMaPNH() + "," + ds[i].getNgayNhap() + "," + ds[i].getNv() + ","
                            + ds[i].getNcc() + "," + ds[i].getTongTien());
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

        System.out.println("\n================= DANH SACH PHIEU NHAP HANG =================");
        System.out.printf("| %-4s | %-8s | %-12s | %-10s | %-10s | %-12s |\n",
                "STT", "Ma PNH", "Ngay Nhap", "Nhan Vien", "NCC", "Tong Tien");
        System.out.println("----------------------------------------------------------------");

        for (int i = 0; i < soLuong; i++) {
            System.out.printf("| %-4d | %-8s | %-12s | %-10s | %-10s | %-12.2f |\n",
                    (i + 1),
                    ds[i].getMaPNH(),
                    ds[i].getNgayNhap(), // LocalDate sẽ tự in dạng yyyy-MM-dd
                    ds[i].getNv(), // Nếu getNv() trả về đối tượng, nên sửa lại thành getNv().getTenNV()
                    ds[i].getNcc(), // Tương tự nếu trả về đối tượng NCC
                    ds[i].getTongTien());
        }

        System.out.println("----------------------------------------------------------------");
    }

    // ====== Tìm phiếu nhập hàng theo mã ======
    public PhieuNhapHang timPhieuNhap() {
        String ma = sc.nextLine();
        for (int i = 0; i < soLuong; i++) {
            if (ds[i].getMaPNH().equalsIgnoreCase(ma)) {
                return ds[i];
            }
        }
        return null;
    }

    // ====== Thêm 1 phiếu nhập hàng ======
    public void themPhieuNhap() {
        ds = Arrays.copyOf(ds, soLuong + 1);
        System.out.print("Nhap ma phieu nhap hang: ");
        String maPNH = sc.nextLine();
        System.out.print("Nhap ngay nhap (YYYY-MM-DD): ");
        LocalDate ngayNhap = LocalDate.parse(sc.nextLine());
        System.out.print("Nhap ma nhan vien: ");
        String nv = sc.nextLine();
        System.out.print("Nhap nha cung cap: ");
        String ncc = sc.nextLine();
        ds[soLuong] = new PhieuNhapHang(maPNH, ngayNhap, nv, ncc);
        soLuong++;
    }

    // ====== Xoá phiếu nhập hàng theo mã ======
    public void xoaPhieuNhapTheoMa() {
        System.out.println("Nhap ma can xoa ");
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
