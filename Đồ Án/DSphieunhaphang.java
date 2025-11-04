import java.util.Arrays;
import java.util.Scanner;
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

    // ====== Xuất danh sách phiếu nhập hàng ======
    public void xuat() {
        if (soLuong == 0) {
            System.out.println("Chưa có phiếu nhập hàng nào!");
            return;
        }

        System.out.println("\n===== DANH SÁCH PHIẾU NHẬP HÀNG =====");
        for (int i = 0; i < soLuong; i++) {
            System.out.println("\n--- Phiếu nhập hàng thứ " + (i + 1) + " ---");
            ds[i].xuatThongTin();
        }
    }

    // ====== Tìm phiếu nhập hàng theo mã ======
    public PhieuNhapHang timPhieuNhapTheoMa(String ma) {
        for (int i = 0; i < soLuong; i++) {
            if (ds[i].getMaPNH().equalsIgnoreCase(ma)) {
                return ds[i];
            }
        }
        return null;
    }

    // ====== Thêm 1 phiếu nhập hàng ======
    public void themPhieuNhap(PhieuNhapHang p) {
        ds = Arrays.copyOf(ds, soLuong + 1);
        ds[soLuong] = p;
        soLuong++;
    }

    // ====== Xoá phiếu nhập hàng theo mã ======
    public void xoaPhieuNhapTheoMa(String ma) {
        for (int i = 0; i < soLuong; i++) {
            if (ds[i].getMaPNH().equalsIgnoreCase(ma)) {
                // Xoá phiếu nhập hàng tại vị trí i
                for (int j = i; j < soLuong - 1; j++) {
                    ds[j] = ds[j + 1];
                }
                ds = Arrays.copyOf(ds, soLuong - 1);
                soLuong--;
                System.out.println("Đã xoá phiếu nhập hàng với mã: " + ma);
                return;
            }
        }
        System.out.println("Không tìm thấy phiếu nhập hàng với mã: " + ma);
    }

    // ====== Sửa thông tin phiếu nhập hàng theo mã ======
    public void suaNCC(String maPNH) {
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

    public void setDanhSach(PhieuNhapHang[] ds, int soLuong) {
        this.ds = ds;
        this.soLuong = soLuong;
    }
}
