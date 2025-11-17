import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.Arrays;
import java.util.Scanner;

public class Dsdodunghoctap {
    private int n;
    private Dodunghoctap[] ds;
    private Scanner sc = new Scanner(System.in);

    public Dsdodunghoctap() {
        n = 0;
        ds = new Dodunghoctap[0];
    }

    public void docFile(String filename) throws Exception {
        try (BufferedReader br = new BufferedReader(new FileReader(filename))) {
            n = Integer.parseInt(br.readLine().trim());
            ds = new Dodunghoctap[n];
            for (int i = 0; i < n; i++) {
                String line = br.readLine();
                if (line == null)
                    break;

                String[] parts = line.split(",");
                for (int j = 0; j < parts.length; j++) {
                    parts[j] = parts[j].trim();
                }

                if (parts.length >= 9) {
                    if (parts[0].startsWith("BV")) {
                        ds[i] = new Butviet(parts[0], parts[1],
                                Integer.parseInt(parts[2]), Integer.parseInt(parts[3]),
                                parts[4], parts[5], parts[6], parts[7],
                                Integer.parseInt(parts[8]));
                    } else if (parts[0].startsWith("GS")) {
                        ds[i] = new Giayso(parts[0], parts[1],
                                Integer.parseInt(parts[2]), Integer.parseInt(parts[3]),
                                parts[4], parts[5], parts[6], parts[7], parts[8]);
                    }
                }
            }
        }
        System.out.println("Doc du lieu thanh cong: " + n + " san pham!");
    }

    public void ghiFile(String filename) throws Exception {
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(filename))) {
            bw.write(String.valueOf(n));
            bw.newLine();
            for (int i = 0; i < n; i++) {
                if (ds[i] != null) {
                    bw.write(ds[i].toFileString());
                    bw.newLine();
                }
            }
        }
        System.out.println("Ghi du lieu vao file thanh cong!");
    }

    public void nhap() {
        System.out.print("Nhap so luong san pham: ");
        n = Integer.parseInt(sc.nextLine());
        ds = new Dodunghoctap[n];

        for (int i = 0; i < n; i++) {
            System.out.println("\nNhap thong tin san pham thu " + (i + 1) + ":");
            System.out.print("Chon loai (1-But viet, 2-Giay so): ");
            int loai = Integer.parseInt(sc.nextLine());

            if (loai == 1) {
                ds[i] = new Butviet();
            } else {
                ds[i] = new Giayso();
            }
            ds[i].nhap();
        }
    }

    public void xuat() {
        System.out.println("\nDANH SACH DO DUNG HOC TAP");
        System.out.println(
                "================================================================================================================");
        System.out.printf("%-8s %-15s %11s %9s %-6s %-4s %5s %18s %13s\n",
                "Ma SP", "Ten SP", "So luong", "Don gia", "DVT", "MaLoai", "MaSX", "Loai but/Do day", "Ngoi/Kho");
        System.out.println(
                "================================================================================================================");

        for (int i = 0; i < n; i++) {
            if (ds[i] != null) {
                ds[i].xuat();
                System.out.println();
            }
        }
        System.out.println(
                "================================================================================================================");
        System.out.println("Tong so: " + n + " san pham");
    }

    // Ham khong tham so

    public void them() {
        ds = Arrays.copyOf(ds, n + 1);
        System.out.println("Nhap thong tin san pham moi: ");
        System.out.print("Chon loai (1-But viet, 2-Giay so): ");
        int loai = sc.nextInt();

        if (loai == 1) {
            ds[n] = new Butviet();
        } else {
            ds[n] = new Giayso();
        }
        ds[n].nhap();
        n++;
        System.out.println("Da them san pham moi thanh cong!");
    }

    public void xoa() {
        System.out.print("Nhap ma san pham can xoa: ");
        String maSP = sc.nextLine();
        for (int i = 0; i < n; i++) {
            if (ds[i].getMaSP().equals(maSP)) {
                for (int j = i; j < n - 1; j++) {
                    ds[j] = ds[j + 1];
                }
                ds = Arrays.copyOf(ds, n - 1);
                n--;
                System.out.println("Da xoa san pham co ma " + maSP);
                return;
            }
        }
        System.out.println("Khong tim thay san pham co ma " + maSP);
    }

    public void timkiem() {
        System.out.print("Nhap ma san pham can tim: ");
        String maSP = sc.nextLine();

        System.out.println("\nKET QUA TIM KIEM:");
        System.out.println(
                "==================================================================================================================");
        System.out.printf("%-8s %-15s %11s %12s %-8s %-8s %-8s %-15s %-10s\n",
                "Ma SP", "Ten SP", "So luong", "Don gia", "DVT", "MaLoai", "MaSX", "Loai but/Do day", "Ngoi/Kho");
        System.out.println(
                "==================================================================================================================");

        boolean found = false;
        for (int i = 0; i < n; i++) {
            if (ds[i].getMaSP().equalsIgnoreCase(maSP)) {
                ds[i].xuat();
                System.out.println();
                found = true;
                break; // Thoát vòng lặp khi tìm thấy
            }
        }
        System.out.println(
                "==================================================================================================================");

        if (!found) {
            System.out.println("Khong tim thay san pham co ma: " + maSP);
        }
    }

    public void sua() {
        System.out.print("Nhap ma san pham can sua: ");
        String maSP = sc.nextLine();
        for (int i = 0; i < n; i++) {
            if (ds[i].getMaSP().equals(maSP)) {
                System.out.println("\nTim thay san pham:");
                ds[i].xuat();
                System.out.println();

                int k;
                do {
                    System.out.println("\n--- Sua thong tin san pham ---");
                    System.out.println("1. Sua ten san pham");
                    System.out.println("2. Sua so luong");
                    System.out.println("3. Sua don gia");
                    System.out.println("4. Sua don vi tinh");
                    System.out.println("5. Sua ma loai");
                    System.out.println("6. Sua ma san xuat");
                    System.out.println("0. Thoat sua");
                    System.out.print("Nhap lua chon: ");
                    k = sc.nextInt();
                    sc.nextLine();

                    switch (k) {
                        case 1:
                            System.out.print("Nhap ten moi: ");
                            ds[i].setTenSP(sc.nextLine());
                            break;
                        case 2:
                            System.out.print("Nhap so luong moi: ");
                            ds[i].setSoLuong(Integer.parseInt(sc.nextLine()));
                            break;
                        case 3:
                            System.out.print("Nhap don gia moi: ");
                            ds[i].setDonGia(Integer.parseInt(sc.nextLine()));
                            break;
                        case 4:
                            System.out.print("Nhap don vi tinh moi: ");
                            ds[i].setdonViTinh(sc.nextLine());
                            break;
                        case 5:
                            System.out.print("Nhap ma loai moi: ");
                            ds[i].setmaLoai(sc.nextLine());
                            break;
                        case 6:
                            System.out.print("Nhap ma san xuat moi: ");
                            ds[i].setmaSX(sc.nextLine());
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
        System.out.println("Khong tim thay san pham voi ma: " + maSP);
    }

    // Ham co tham so
    public void themcothamso(String maSP, String tenSP, int soLuong, int donGia,
            String donViTinh, String maLoai, String maSX, String dacTrung1, int dacTrung2) {

        ds = Arrays.copyOf(ds, n + 1);

        if (maSP.startsWith("BV")) {
            ds[n] = new Butviet(maSP, tenSP, soLuong, donGia, donViTinh, maLoai, maSX, dacTrung1, dacTrung2);
        } else if (maSP.startsWith("GS")) {
            ds[n] = new Giayso(maSP, tenSP, soLuong, donGia, donViTinh, maLoai, maSX, dacTrung1,
                    String.valueOf(dacTrung2));
        }

        n++;
    }

    public void xoacothamso(String maSP) {
        for (int i = 0; i < n; i++) {
            if (ds[i].getMaSP().equals(maSP)) {
                for (int j = i; j < n - 1; j++) {
                    ds[j] = ds[j + 1];
                }
                ds = Arrays.copyOf(ds, n - 1);
                n--;
                return;
            }
        }
    }

    public Dodunghoctap timkiemcothamso(String maSP) {
        // Tìm sản phẩm
        for (int i = 0; i < n; i++) {
            if (ds[i].getMaSP().equalsIgnoreCase(maSP)) {
                return ds[i];
            }
        }
        return null;
    }

    public void suacothamso(String maSP, String tenSP, int soLuong, int donGia,
            String donViTinh, String maLoai, String maSX,
            String dacTrung1, int dacTrung2) {
        for (int i = 0; i < n; i++) {
            if (ds[i].getMaSP().equals(maSP)) {
                // Sửa tất cả thông tin cơ bản
                ds[i].setTenSP(tenSP);
                ds[i].setSoLuong(soLuong);
                ds[i].setDonGia(donGia);
                ds[i].setdonViTinh(donViTinh);
                ds[i].setmaLoai(maLoai);
                ds[i].setmaSX(maSX);

                if (ds[i] instanceof Butviet) {
                    ((Butviet) ds[i]).setLoaibut(dacTrung1);
                    ((Butviet) ds[i]).setKichcongoi(dacTrung2);
                } else if (ds[i] instanceof Giayso) {
                    ((Giayso) ds[i]).setDoDay(dacTrung1);
                    ((Giayso) ds[i]).setKhoGiay(String.valueOf(dacTrung2));
                }
                return;
            }
        }
    }

    public void thongke() {
        int countButviet = 0;
        int countGiayso = 0;
        int tongSoLuong = 0;
        int tongGiaTri = 0;

        for (int i = 0; i < n; i++) {
            if (ds[i] instanceof Butviet) {
                countButviet++;
            } else if (ds[i] instanceof Giayso) {
                countGiayso++;
            }
            tongSoLuong += ds[i].getSoLuong();
            tongGiaTri += ds[i].getSoLuong() * ds[i].getDonGia();
        }

        System.out.println("\nTHONG KE DO DUNG HOC TAP");
        System.out.println("====================================");
        System.out.println("Tong so san pham: " + n);
        System.out.println("So but viet: " + countButviet);
        System.out.println("So giay so: " + countGiayso);
        System.out.println("Tong so luong ton kho: " + tongSoLuong);
        System.out.println("Tong gia tri ton kho: " + tongGiaTri);
        System.out.println("====================================");
    }

    public void thongKeTheoMaLoai() {
        System.out.println("\nTHONG KE THEO MA LOAI");
        System.out.println("======================");

        String[] maLoais = new String[n];
        int[] soLuongs = new int[n];
        int count = 0;

        for (int i = 0; i < n; i++) {
            String maLoai = ds[i].getMaLoai();
            boolean found = false;
            for (int j = 0; j < count; j++) {
                if (maLoais[j].equals(maLoai)) {
                    soLuongs[j] += ds[i].getSoLuong();
                    found = true;
                    break;
                }
            }
            if (!found) {
                maLoais[count] = maLoai;
                soLuongs[count] = ds[i].getSoLuong();
                count++;
            }
        }

        for (int i = 0; i < count; i++) {
            System.out.println("Ma loai " + maLoais[i] + ": " + soLuongs[i] + " san pham");
        }
    }

    // Getter và Setter
    public void setDanhSach(Dodunghoctap[] ds, int n) {
        this.ds = ds;
        this.n = n;
    }

    public Dodunghoctap[] getDs() {
        return ds;
    }

    public int getN() {
        return n;
    }
}
