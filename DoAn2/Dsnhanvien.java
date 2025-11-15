import java.io.*;
import java.util.*;

public class Dsnhanvien implements dieukien {
    static int n;
    static Nhanvien[] ds;
    static Scanner sc = new Scanner(System.in);

    // ---- Doc file ----
    public void docFile(String filename) throws Exception {
        try (BufferedReader br = new BufferedReader(new FileReader(filename))) {
            n = Integer.parseInt(br.readLine());
            ds = new Nhanvien[n];
            for (int i = 0; i < n; i++) {
                String line = br.readLine();
                if (line == null || line.trim().isEmpty()) break;

                String[] parts = line.split(",");
                Nhanvien nv = new Nhanvien(
                    parts[0], // manv
                    parts[1], // honv
                    parts[2], // tennv
                    Integer.parseInt(parts[3]) // luong
                );
                ds[i] = nv;
            }
        }
        System.out.println("Doc du lieu tu file thanh cong!");
    }

    // ---- Ghi file ----
    public void ghiFile(String filename) throws Exception {
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(filename))) {
            bw.write(n + "");
            bw.newLine();
            for (int i = 0; i < n; i++) {
                if (ds[i] != null) {
                    bw.write(ds[i].toString());
                    bw.newLine();
                }
            }
        }
        System.out.println("Ghi du lieu vao file thanh cong!");
    }

    // ---- Xuat danh sach ----
    public void xuat() {
        System.out.printf("%-5s %-15s %-20s %-15s %-15s%n",
        "STT", "Ma nhan vien", "Ho nhan vien", "Ten nhan vien", "Luong");
        for (int i = 0; i < n; i++) {
            System.out.printf("%-5d", (i + 1));
            ds[i].xuat();
        }
    }

    // --- Các phương thức có tham số ---
    public void them(Nhanvien nvMoi) {
        ds = Arrays.copyOf(ds, n + 1);
        ds[n] = nvMoi;
        n++;
        System.out.println("Da them nhan vien moi thanh cong!");
    }

    public void xoa(String maNV) {
        System.out.print("Nhap ma nhan vien muon xoa: ");
        maNV = sc.nextLine();
        for (int i = 0; i < n; i++) {
            if(ds[i].getManv().equalsIgnoreCase(maNV)) {
                for (int j = i; j < n - 1; j++) {
                    ds[j] = ds[j + 1];
                }
                ds = Arrays.copyOf(ds, n - 1);
                n--;
                System.out.println("Da xoa nhan vien " + maNV);
                return;
            }
        }
        System.out.println("Khong tim thay nhan vien " + maNV);
    }

    public void sua(String maNV, Nhanvien nvSua) {
        for (int i = 0; i < n; i++) {
            if (ds[i].getManv().equalsIgnoreCase(maNV)) {
                ds[i] = nvSua;
                System.out.println("Da sua nhan vien: " + maNV);
                return;
            }
        }
        System.out.println("Khong tim thay nhan vien " + maNV);
    }

    // ---- Them ----
    @Override
    public void them() {
        ds = Arrays.copyOf(ds, n + 1);
        ds[n] = new Nhanvien();
        ds[n].nhap();
        n++;
        System.out.println("Da them nhan vien moi thanh cong!");
    }

    // ---- Xoa ----
    @Override
    public void xoa() {
        System.out.print("Nhap ma nhan vien muon xoa: ");
        String manv = sc.nextLine();
        for (int i = 0; i < n; i++) {
            if (ds[i].getManv().equalsIgnoreCase(manv)) {
                for (int j = i; j < n - 1; j++) {
                    ds[j] = ds[j + 1];
                }
                ds = Arrays.copyOf(ds, n - 1);
                n--;
                System.out.println("Da xoa nhan vien " + manv);
                return;
            }
        }
        System.out.println("Khong tim thay nhan vien " + manv);
    }

    // ---- Tim kiem ----
    @Override
    public void timkiem() {
        System.out.print("Nhap ma nhan vien can tim: ");
        String manv = sc.nextLine();
        for (int i = 0; i < n; i++) {
            if (ds[i].getManv().equalsIgnoreCase(manv)) {
                ds[i].xuat();
                return;
            }
        }
        System.out.println("Khong tim thay ma nhan vien nay!");
    }

    // ---- Sua ----
    @Override
    public void sua() {
        System.out.print("Nhap ma nhan vien can sua: ");
        String manv = sc.nextLine();
        for (int i = 0; i < n; i++) {
            if (ds[i].getManv().equalsIgnoreCase(manv)) {
                int k;
                do {
                    System.out.println("------ Sua thong tin nhan vien ------");
                    System.out.println("1. Sua ma nhan vien");
                    System.out.println("2. Sua ho nhan vien");
                    System.out.println("3. Sua ten nhan vien");
                    System.out.println("4. Sua luong");
                    System.out.println("0. Thoat");
                    System.out.print("Chon: ");
                    k = Integer.parseInt(sc.nextLine());

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
                            System.out.println("Thoat sua.");
                            break;
                        default:
                            System.out.println("Lua chon khong hop le!");
                    }
                } while (k != 0);
                return;
            }
        }
        System.out.println("Khong tim thay nhan vien can sua!");
    }

    // ---- Thong ke ----
    public void thongke() {
        System.out.println("=== THONG KE NHAN VIEN ===");
        System.out.println("Tong so nhan vien: " + n);
        double tongLuong = 0;
        for (int i = 0; i < n; i++) {
            tongLuong += ds[i].getLuong();
        }
        System.out.println("Tong luong toan cong ty: " + tongLuong);
    }
}
