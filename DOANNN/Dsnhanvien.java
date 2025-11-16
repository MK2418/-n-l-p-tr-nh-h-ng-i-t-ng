import java.io.*;
import java.util.*;

public class Dsnhanvien {
    private int n;
    private Nhanvien[] ds;
    private Scanner sc = new Scanner(System.in);

    public Dsnhanvien() {
        n = 0;
        ds = new Nhanvien[0];
    }

    // ---- Doc file ----
    public void docFile(String filename) throws Exception {
        try (BufferedReader br = new BufferedReader(new FileReader(filename))) {
            n = Integer.parseInt(br.readLine().trim());
            ds = new Nhanvien[n];
            for (int i = 0; i < n; i++) {
                String line = br.readLine();
                if (line == null)
                    break;

                String[] parts = line.split(",");
                for (int j = 0; j < parts.length; j++) {
                    parts[j] = parts[j].trim();
                }

                if (parts.length >= 4) {
                    ds[i] = new Nhanvien(parts[0], parts[1], parts[2], Integer.parseInt(parts[3]));
                }
            }
        }
        System.out.println("Doc du lieu thanh cong: " + n + " nhan vien!");
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
        System.out.print("Nhap so luong nhan vien: ");
        n = Integer.parseInt(sc.nextLine());
        ds = new Nhanvien[n];

        for (int i = 0; i < n; i++) {
            System.out.println("\nNhap thong tin nhan vien thu " + (i + 1) + ":");
            ds[i] = new Nhanvien();
            ds[i].nhap();
        }
    }

    // ---- Xuat danh sach ----
    public void xuat() {
        System.out.println("\nDANH SACH NHAN VIEN");
        System.out.println("========================================================================================");
        System.out.printf("%-15s %-20s %-20s %-20s\n",
                "Ma NV", "Ho NV", "Ten NV", "Luong");
        System.out.println("========================================================================================");

        for (int i = 0; i < n; i++) {
            if (ds[i] != null) {
                System.out.printf("%-15s %-20s %-20s %-20s\n",
                        ds[i].getManv(),
                        ds[i].getHonv(),
                        ds[i].getTennv(),
                        Nhanvien.formatLuong(ds[i].getLuong()));
            }
        }

        System.out.println("========================================================================================");
        System.out.println("Tong so: " + n + " nhan vien");
    }

    // ===== Các phương thức có tham số =====
    public void themcothamso(String maNV, String hoNV, String tenNV, int luong) {
        ds = Arrays.copyOf(ds, n + 1);
        ds[n] = new Nhanvien(maNV, hoNV, tenNV, luong);
        n++;
    }

    public void xoacothamso(String maNV) {
        for (int i = 0; i < n; i++) {
            if (ds[i].getManv().equals(maNV)) {
                for (int j = i; j < n - 1; j++) {
                    ds[j] = ds[j + 1];
                }
                ds = Arrays.copyOf(ds, n - 1);
                n--;
                return;
            }
        }
    }

    public void suacothamso(String maNV, String hoNV, String tenNV, int luong) {
        for (int i = 0; i < n; i++) {
            if (ds[i].getManv().equals(maNV)) {
                // Sửa tất cả thông tin
                ds[i].setHonv(hoNV);
                ds[i].setTennv(tenNV);
                ds[i].setLuong(luong);
                System.out.println("Da sua nhan vien co ma " + maNV + " thanh cong!");
                return;
            }
        }
        System.out.println("Khong tim thay nhan vien co ma " + maNV);
    }

    public void timkiemcothamso(String maNV) {
        boolean found = false;
        System.out.println("\nKET QUA TIM KIEM:");
        System.out.println("======================================================================");
        System.out.printf("%-10s %-15s %-20s %-15s\n",
                "Ma NV", "Ho NV", "Ten NV", "Luong");
        System.out.println("======================================================================");

        for (int i = 0; i < n; i++) {
            if (ds[i].getManv().equalsIgnoreCase(maNV)) {
                ds[i].xuat();
                System.out.println();
                found = true;
            }
        }

        if (!found) {
            System.out.println("Khong tim thay nhan vien voi ma: " + maNV);
        }
        System.out.println("======================================================================");
    }

    // ===== Các phương thức không tham số (implement interface) =====
    public void them() {
        ds = Arrays.copyOf(ds, n + 1);
        System.out.println("Nhap thong tin nhan vien moi: ");
        ds[n] = new Nhanvien();
        ds[n].nhap();
        n++;
        System.out.println("Da them nhan vien moi thanh cong!");
    }

    public void xoa() {
        System.out.print("Nhap ma nhan vien can xoa: ");
        String maNV = sc.nextLine();
        for (int i = 0; i < n; i++) {
            if (ds[i].getManv().equals(maNV)) {
                for (int j = i; j < n - 1; j++) {
                    ds[j] = ds[j + 1];
                }
                ds = Arrays.copyOf(ds, n - 1);
                n--;
                System.out.println("Da xoa nhan vien co ma " + maNV);
                return;
            }
        }
        System.out.println("Khong tim thay nhan vien co ma " + maNV);
    }

    public void timkiem() {
        System.out.print("Nhap ma nhan vien can tim: ");
        String maNV = sc.nextLine();
        boolean found = false;

        System.out.println("\nKET QUA TIM KIEM:");
        System.out.println("======================================================================");
        System.out.printf("%-10s %-15s %-20s %-15s\n",
                "Ma NV", "Ho NV", "Ten NV", "Luong");
        System.out.println("======================================================================");

        for (int i = 0; i < n; i++) {
            if (ds[i].getManv().equalsIgnoreCase(maNV)) {
                ds[i].xuat();
                System.out.println();
                found = true;
            }
        }

        if (!found) {
            System.out.println("Khong tim thay nhan vien voi ma: " + maNV);
        }
        System.out.println("======================================================================");
    }

    public void sua() {
        System.out.print("Nhap ma nhan vien can sua: ");
        String maNV = sc.nextLine();
        for (int i = 0; i < n; i++) {
            if (ds[i].getManv().equals(maNV)) {
                System.out.println("\nTim thay nhan vien:");
                ds[i].xuat();
                System.out.println();

                int k;
                do {
                    System.out.println("\n--- Sua thong tin nhan vien ---");
                    System.out.println("1. Sua ma nhan vien");
                    System.out.println("2. Sua ho nhan vien");
                    System.out.println("3. Sua ten nhan vien");
                    System.out.println("4. Sua luong");
                    System.out.println("0. Thoat sua");
                    System.out.print("Nhap lua chon: ");
                    k = sc.nextInt();
                    sc.nextLine();

                    switch (k) {
                        case 1:
                            System.out.print("Nhap ma moi: ");
                            ds[i].setManv(sc.nextLine());
                            break;
                        case 2:
                            System.out.print("Nhap ho moi: ");
                            ds[i].setHonv(sc.nextLine());
                            break;
                        case 3:
                            System.out.print("Nhap ten moi: ");
                            ds[i].setTennv(sc.nextLine());
                            break;
                        case 4:
                            System.out.print("Nhap luong moi: ");
                            ds[i].setLuong(Integer.parseInt(sc.nextLine()));
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
        System.out.println("Khong tim thay nhan vien voi ma: " + maNV);
    }

    // ---- Thong ke ----
    public void thongke() {
        System.out.println("\nTHONG KE NHAN VIEN");
        System.out.println("====================================");
        System.out.println("Tong so nhan vien: " + n);

        int tongLuong = 0;
        int luongCaoNhat = 0;
        int luongThapNhat = Integer.MAX_VALUE;

        for (int i = 0; i < n; i++) {
            int luong = ds[i].getLuong();
            tongLuong += luong;

            if (luong > luongCaoNhat) {
                luongCaoNhat = luong;
            }
            if (luong < luongThapNhat) {
                luongThapNhat = luong;
            }
        }

        int luongTrungBinh = tongLuong / n;

        System.out.println("Tong luong: " + tongLuong);
        System.out.println("Luong trung binh: " + luongTrungBinh);
        System.out.println("Luong cao nhat: " + luongCaoNhat);
        System.out.println("Luong thap nhat: " + luongThapNhat);
        System.out.println("====================================");
    }

    public Nhanvien[] getDs() {
        return ds;
    }

    public int getN() {
        return n;
    }
}