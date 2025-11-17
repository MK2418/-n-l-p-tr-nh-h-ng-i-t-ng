import java.util.Scanner;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.Arrays;

public class Dschitietphieunhaphang {
    int n;
    chitietphieunhaphang[] ds;
    Scanner sc = new Scanner(System.in);

    public void docFile(String filename) throws Exception {
        try (BufferedReader br = new BufferedReader(new FileReader(filename))) {
            n = Integer.parseInt(br.readLine());
            ds = new chitietphieunhaphang[n];
            for (int i = 0; i < n; i++) {
                String line = br.readLine();
                if (line == null)
                    break;
                String[] parts = line.split(",");
                ds[i] = new chitietphieunhaphang(parts[0], parts[1], Integer.parseInt(parts[2]),
                        Double.parseDouble(parts[3]));
            }
        }
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

    public void xuat() {
        System.out.println("======================================================================");
        System.out.printf("| %-10s | %-10s | %-10s | %-10s | %-12s  |\n",
                "Ma PNH", "Ma Hang", "So Luong", "Don Gia", "Thanh Tien");
        System.out.println("======================================================================");

        for (int i = 0; i < n; i++) {
            ds[i].xuat();
        }
        System.out.println("======================================================================");
    }

    public void nhap() {
        for (int i = 0; i < n; i++) {
            System.out.println("Nhap thong tin chi tiet phieu nhap hang thu " + (i + 1) + ": ");
            ds[i] = new chitietphieunhaphang();
            ds[i].nhap();
        }
    }

    // Ham co ban khong tham so
    public void themChiTietPNH() {
        ds = Arrays.copyOf(ds, n + 1);
        ds[n] = new chitietphieunhaphang();
        System.out.println("Nhap thong tin chi tiet phieu nhap hang thu " + (n + 1) + ": ");
        ds[n].nhap();
        n++;
        System.out.println("Da them chi tiet phieu nhap hang moi thanh cong!");
    }

    public void xoaChiTietPNH() {
        String maPNH = sc.nextLine();
        for (int i = 0; i < n; i++) {
            if (ds[i].getMaPNH().equals(maPNH)) {
                for (int j = i; j < n - 1; j++) {
                    ds[j] = ds[j + 1];
                }
                ds = Arrays.copyOf(ds, n - 1);
                n--;
                System.out.println("Da xoa chi tiet phieu nhap hang co ma PNH " + maPNH);
                return;
            }
        }
        System.out.println("Khong tim thay chi tiet phieu nhap hang co ma PNH " + maPNH);
    }

    public void timKiemChiTietPNH() {
        System.out.print("Nhap ma PNH can tim: ");
        String maPNH = sc.nextLine();
        for (int i = 0; i < n; i++) {
            if (ds[i].getMaPNH().equalsIgnoreCase(maPNH)) {
                System.out.println("Thong tin chi tiet phieu nhap hang:");
                System.out.printf("| %-10s | %-10s | %-10s | %-10s | %-12s |\n",
                        "Ma PNH", "Ma Hang", "So Luong", "Don Gia", "Thanh Tien");
                ds[i].xuat();
                return;
            }
        }
        System.out.println("Khong tim thay chi tiet phieu nhap hang co ma PNH " + maPNH);
    }

    public void suaNCC() {
        String maPNH = sc.nextLine();
        for (int i = 0; i < n; i++) {
            if (ds[i].getMaPNH().equals(maPNH)) {
                int k;
                do {
                    System.out.println("\n--- Sua thong tin chi tiet phieu nhap hang ---");
                    System.out.println("1. Sua ma phieu nhap hang");
                    System.out.println("2. Sua ma hang");
                    System.out.println("3. Sua so luong");
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
                            System.out.print("Nhap ma hang moi: ");
                            ds[i].setMaHang(sc.nextLine());
                            break;
                        case 3:
                            System.out.print("Nhap so luong moi: ");
                            ds[i].setSoLuong(sc.nextInt());
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
    public void themChiTietPNHcothamso(String ma, String mahang, int soluong, double dongia) {
        ds[n] = new chitietphieunhaphang();
        ds[n].setMaPNH(ma);
        ds[n].setMaHang(mahang);
        ds[n].setSoLuong(soluong);
        ds[n].setDonGia(dongia);
        n++;
        System.out.println("Da them chi tiet phieu nhap hang moi thanh cong!");
    }

    public chitietphieunhaphang[] timKiemChiTietPNHcothamso(String ma) {
        String maPNH = ma;

        // Đếm số lượng kết quả trùng khớp
        int count = 0;
        for (int i = 0; i < n; i++) {
            if (ds[i].getMaPNH().equalsIgnoreCase(maPNH)) {
                count++;
            }
        }

        // Tạo mảng kết quả
        chitietphieunhaphang[] ketQua = new chitietphieunhaphang[count];
        int index = 0;

        System.out.println("Thong tin chi tiet phieu nhap hang:");
        System.out.printf("| %-10s | %-10s | %-10s | %-10s | %-12s |\n",
                "Ma PNH", "Ma Hang", "So Luong", "Don Gia", "Thanh Tien");

        for (int i = 0; i < n; i++) {
            if (ds[i].getMaPNH().equalsIgnoreCase(maPNH)) {
                ds[i].xuat();
                ketQua[index++] = ds[i]; // Thêm vào mảng kết quả
            }
        }

        if (count == 0) {
            System.out.println("Khong tim thay chi tiet phieu nhap hang co ma PNH " + maPNH);
        }

        return ketQua;
    }

    public void xoaChiTietPNHcothamso(String maPNH) {
        for (int i = 0; i < n; i++) {
            if (ds[i].getMaPNH().equals(maPNH)) {
                for (int j = i; j < n - 1; j++) {
                    ds[j] = ds[j + 1];
                }
                ds = Arrays.copyOf(ds, n - 1);
                n--;
                System.out.println("Da xoa chi tiet phieu nhap hang co ma PNH " + maPNH);
                return;
            }
        }
        System.out.println("Khong tim thay chi tiet phieu nhap hang co ma PNH " + maPNH);
    }

    public void suaNCCcothamso(String maPNH) {
        for (int i = 0; i < n; i++) {
            if (ds[i].getMaPNH().equals(maPNH)) {
                int k;
                do {
                    System.out.println("\n--- Sua thong tin chi tiet phieu nhap hang ---");
                    System.out.println("1. Sua ma phieu nhap hang");
                    System.out.println("2. Sua ma hang");
                    System.out.println("3. Sua so luong");
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
                            System.out.print("Nhap ma hang moi: ");
                            ds[i].setMaHang(sc.nextLine());
                            break;
                        case 3:
                            System.out.print("Nhap so luong moi: ");
                            ds[i].setSoLuong(sc.nextInt());
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
        String[] ma = new String[n];
        int[] soluong = new int[n];
        int count = 0;
        for (int i = 0; i < n; i++) {
            boolean found = false;
            String mapn = ds[i].getMaPNH();
            for (int j = 0; j < count; j++) {
                if (ma[j].equals(mapn)) {
                    soluong[j]++;
                    found = true;
                }
            }
            if (!found) {
                ma[count] = mapn;
                soluong[count] = 1;
                count++;
            }
        }
        for (int i = 0; i < count; i++) {
            System.out.println(ma[i] + ": " + soluong[i] + " don hang");
        }
    }

    public chitietphieunhaphang[] getDs() {
        return ds;
    }

    public int getN() {
        return n;
    }

    public void setDanhSach(chitietphieunhaphang[] ds, int n) {
        this.ds = ds;
        this.n = n;
    }
}
