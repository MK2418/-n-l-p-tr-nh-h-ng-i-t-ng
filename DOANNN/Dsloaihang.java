import java.io.*;
import java.util.*;

public class Dsloaihang {
    private int n;
    private Loaihang[] ds;
    private Scanner sc = new Scanner(System.in);

    public Dsloaihang() {
        n = 0;
        ds = new Loaihang[0];
    }

    // ---- Doc file ----
    public void docFile(String filename) throws Exception {
        try (BufferedReader br = new BufferedReader(new FileReader(filename))) {
            n = Integer.parseInt(br.readLine().trim());
            ds = new Loaihang[n];
            for (int i = 0; i < n; i++) {
                String line = br.readLine();
                if (line == null)
                    break;

                String[] parts = line.split(",");
                for (int j = 0; j < parts.length; j++) {
                    parts[j] = parts[j].trim();
                }

                if (parts.length >= 3) {
                    ds[i] = new Loaihang(parts[0], parts[1], parts[2]);
                }
            }
        }
        System.out.println("Doc du lieu thanh cong: " + n + " loai hang!");
    }

    // ---- Ghi file ----
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

    // ---- Nhap danh sach ----
    public void nhap() {
        System.out.print("Nhap so luong loai hang: ");
        n = Integer.parseInt(sc.nextLine());
        ds = new Loaihang[n];

        for (int i = 0; i < n; i++) {
            System.out.println("\nNhap thong tin loai hang thu " + (i + 1) + ":");
            ds[i] = new Loaihang();
            ds[i].nhap();
        }
    }

    // ---- Xuat danh sach ----
    public void xuat() {
        System.out.println("\nDANH SACH LOAI HANG");
        System.out.println("========================================================");
        System.out.printf("%-12s %-20s %-25s\n",
                "Ma LH", "Ten loai hang", "Mo ta");
        System.out.println("========================================================");

        for (int i = 0; i < n; i++) {
            if (ds[i] != null) {
                ds[i].xuat();
                System.out.println();
            }
        }
        System.out.println("=========================================================");
        System.out.println("Tong so: " + n + " loai hang");
    }

    // ===== Các phương thức có tham số =====
    public void themcothamso(String maLH, String tenLH, String moTa) {
        ds = Arrays.copyOf(ds, n + 1);
        ds[n] = new Loaihang(maLH, tenLH, moTa);
        n++;
    }

    public void xoacothamso(String maLH) {
        for (int i = 0; i < n; i++) {
            if (ds[i].getMalh().equals(maLH)) {
                for (int j = i; j < n - 1; j++) {
                    ds[j] = ds[j + 1];
                }
                ds = Arrays.copyOf(ds, n - 1);
                n--;
                return;
            }
        }
    }

    public void timkiemcothamso(String maLH) {
        boolean found = false;
        System.out.println("\nKET QUA TIM KIEM:");
        System.out.println("====================================================");
        System.out.printf("%-12s %-20s %-25s\n",
                "Ma LH", "Ten loai hang", "Mo ta");
        System.out.println("====================================================");

        for (int i = 0; i < n; i++) {
            if (ds[i].getMalh().equalsIgnoreCase(maLH)) {
                ds[i].xuat();
                System.out.println();
                found = true;
            }
        }
        System.out.println("====================================================");
    }

    public void suacothamso(String maLH, String tenLH, String moTa) {
        for (int i = 0; i < n; i++) {
            if (ds[i].getMalh().equals(maLH)) {
                // Sửa tất cả thông tin
                ds[i].setTenlh(tenLH);
                ds[i].setMota(moTa);
                return;
            }
        }
    }

    // ===== Các phương thức không tham số =====
    public void them() {
        ds = Arrays.copyOf(ds, n + 1);
        System.out.println("Nhap thong tin loai hang moi: ");
        ds[n] = new Loaihang();
        ds[n].nhap();
        n++;
        System.out.println("Da them loai hang moi thanh cong!");
    }

    public void xoa() {
        System.out.print("Nhap ma loai hang can xoa: ");
        String maLH = sc.nextLine();
        for (int i = 0; i < n; i++) {
            if (ds[i].getMalh().equals(maLH)) {
                for (int j = i; j < n - 1; j++) {
                    ds[j] = ds[j + 1];
                }
                ds = Arrays.copyOf(ds, n - 1);
                n--;
                System.out.println("Da xoa loai hang co ma " + maLH);
                return;
            }
        }
        System.out.println("Khong tim thay loai hang co ma " + maLH);
    }

    public void timkiem() {
        System.out.print("Nhap ma loai hang can tim: ");
        String maLH = sc.nextLine();
        boolean found = false;

        System.out.println("\nKET QUA TIM KIEM:");
        System.out.println("====================================================");
        System.out.printf("%-12s %-20s %-25s\n",
                "Ma LH", "Ten loai hang", "Mo ta");
        System.out.println("====================================================");

        for (int i = 0; i < n; i++) {
            if (ds[i].getMalh().equalsIgnoreCase(maLH)) {
                ds[i].xuat();
                System.out.println();
                found = true;
            }
        }

        if (!found) {
            System.out.println("Khong tim thay loai hang voi ma: " + maLH);
        }
        System.out.println("====================================================");
    }

    public void sua() {
        System.out.print("Nhap ma loai hang can sua: ");
        String maLH = sc.nextLine();
        for (int i = 0; i < n; i++) {
            if (ds[i].getMalh().equals(maLH)) {
                System.out.println("\nTim thay loai hang:");
                ds[i].xuat();
                System.out.println();

                int k;
                do {
                    System.out.println("\n--- Sua thong tin loai hang ---");
                    System.out.println("1. Sua ma loai hang");
                    System.out.println("2. Sua ten loai hang");
                    System.out.println("3. Sua mo ta");
                    System.out.println("0. Thoat sua");
                    System.out.print("Nhap lua chon: ");
                    k = sc.nextInt();
                    sc.nextLine();

                    switch (k) {
                        case 1:
                            System.out.print("Nhap ma moi: ");
                            ds[i].setMalh(sc.nextLine());
                            break;
                        case 2:
                            System.out.print("Nhap ten moi: ");
                            ds[i].setTenlh(sc.nextLine());
                            break;
                        case 3:
                            System.out.print("Nhap mo ta moi: ");
                            ds[i].setMota(sc.nextLine());
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
        System.out.println("Khong tim thay loai hang voi ma: " + maLH);
    }

    // ---- Thong ke ----
    public void thongke() {
        System.out.println("\nTHONG KE LOAI HANG");
        System.out.println("====================================");
        System.out.println("Tong so loai hang: " + n);

        // Thống kê theo độ dài mô tả
        int ngan = 0, trungBinh = 0, dai = 0;
        for (int i = 0; i < n; i++) {
            int doDaiMoTa = ds[i].getMota().length();
            if (doDaiMoTa < 10) {
                ngan++;
            } else if (doDaiMoTa < 30) {
                trungBinh++;
            } else {
                dai++;
            }
        }

        System.out.println("Loai co mo ta ngan (<10 ky tu): " + ngan);
        System.out.println("Loai co mo ta trung binh (10-30 ky tu): " + trungBinh);
        System.out.println("Loai co mo ta dai (>30 ky tu): " + dai);
        System.out.println("====================================");
    }

    public Loaihang[] getDs() {
        return ds;
    }

    public int getN() {
        return n;
    }
}