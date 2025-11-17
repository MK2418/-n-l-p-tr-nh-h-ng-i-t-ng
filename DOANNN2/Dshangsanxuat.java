import java.io.*;
import java.util.*;

public class Dshangsanxuat {
    private int n;
    private Hangsanxuat[] ds;
    private Scanner sc = new Scanner(System.in);

    public Dshangsanxuat() {
        n = 0;
        ds = new Hangsanxuat[0];
    }

    // ---- Doc file ----
    public void docFile(String filename) throws Exception {
        try (BufferedReader br = new BufferedReader(new FileReader(filename))) {
            n = Integer.parseInt(br.readLine().trim());
            ds = new Hangsanxuat[n];
            for (int i = 0; i < n; i++) {
                String line = br.readLine();
                if (line == null)
                    break;

                String[] parts = line.split(",");
                for (int j = 0; j < parts.length; j++) {
                    parts[j] = parts[j].trim();
                }

                if (parts.length >= 3) {
                    ds[i] = new Hangsanxuat(parts[0], parts[1], parts[2]);
                }
            }
        }
        System.out.println("Doc du lieu thanh cong: " + n + " hang san xuat!");
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
        System.out.print("Nhap so luong hang san xuat: ");
        n = Integer.parseInt(sc.nextLine());
        ds = new Hangsanxuat[n];

        for (int i = 0; i < n; i++) {
            System.out.println("\nNhap thong tin hang san xuat thu " + (i + 1) + ":");
            ds[i] = new Hangsanxuat();
            ds[i].nhap();
        }
    }

    // ---- Xuat danh sach ----
    public void xuat() {
        System.out.println("\nDANH SACH HANG SAN XUAT");
        System.out.println("====================================================");
        System.out.printf("%-15s %-20s %-25s\n",
                "Ma HSX", "Ten hang SX", "Dia chi");
        System.out.println("====================================================");

        for (int i = 0; i < n; i++) {
            if (ds[i] != null) {
                ds[i].xuat();
                System.out.println();
            }
        }
        System.out.println("====================================================");
        System.out.println("Tong so: " + n + " hang san xuat");
    }

    // ===== Các phương thức có tham số =====
    public void themcothamso(String maHSX, String tenHSX, String diaChi) {
        ds = Arrays.copyOf(ds, n + 1);
        ds[n] = new Hangsanxuat(maHSX, tenHSX, diaChi);
        n++;
    }

    public void xoacothamso(String maHSX) {
        for (int i = 0; i < n; i++) {
            if (ds[i].getMahsx().equals(maHSX)) {
                for (int j = i; j < n - 1; j++) {
                    ds[j] = ds[j + 1];
                }
                ds = Arrays.copyOf(ds, n - 1);
                n--;
                return;
            }
        }
    }

    public Hangsanxuat[] timkiemcothamso(String maHSX) {
        // Đếm số lượng kết quả trùng khớp
        int count = 0;
        for (int i = 0; i < n; i++) {
            if (ds[i].getMahsx().equalsIgnoreCase(maHSX)) {
                count++;
            }
        }

        // Tạo mảng kết quả
        Hangsanxuat[] ketQua = new Hangsanxuat[count];
        int index = 0;

        System.out.println("\nKET QUA TIM KIEM:");
        System.out.println("====================================================");
        System.out.printf("%-15s %-20s %-25s\n",
                "Ma HSX", "Ten hang SX", "Dia chi");
        System.out.println("====================================================");

        boolean found = false;
        for (int i = 0; i < n; i++) {
            if (ds[i].getMahsx().equalsIgnoreCase(maHSX)) {
                ds[i].xuat();
                System.out.println();
                ketQua[index++] = ds[i]; // Thêm vào mảng kết quả
                found = true;
            }
        }

        if (!found) {
            System.out.println("Khong tim thay hang san xuat voi ma: " + maHSX);
        }
        System.out.println("====================================================");

        return ketQua;
    }

    public void suacothamso(String maHSX, String tenHSX, String diaChi) {
        for (int i = 0; i < n; i++) {
            if (ds[i].getMahsx().equals(maHSX)) {
                ds[i].setTenhsx(tenHSX);
                ds[i].setDiachi(diaChi);
                System.out.println("Da sua hang san xuat co ma " + maHSX + " thanh cong!");
                return;
            }
        }
    }

    // ===== Các phương thức không tham số =====
    public void them() {
        ds = Arrays.copyOf(ds, n + 1);
        System.out.println("Nhap thong tin hang san xuat moi: ");
        ds[n] = new Hangsanxuat();
        ds[n].nhap();
        n++;
        System.out.println("Da them hang san xuat moi thanh cong!");
    }

    public void xoa() {
        System.out.print("Nhap ma hang san xuat can xoa: ");
        String maHSX = sc.nextLine();
        for (int i = 0; i < n; i++) {
            if (ds[i].getMahsx().equals(maHSX)) {
                for (int j = i; j < n - 1; j++) {
                    ds[j] = ds[j + 1];
                }
                ds = Arrays.copyOf(ds, n - 1);
                n--;
                System.out.println("Da xoa hang san xuat co ma " + maHSX);
                return;
            }
        }
        System.out.println("Khong tim thay hang san xuat co ma " + maHSX);
    }

    public void timkiem() {
        System.out.print("Nhap ma hang san xuat can tim: ");
        String maHSX = sc.nextLine();
        boolean found = false;

        System.out.println("\nKET QUA TIM KIEM:");
        System.out.println("====================================================");
        System.out.printf("%-15s %-20s %-25s\n",
                "Ma HSX", "Ten hang SX", "Dia chi");
        System.out.println("====================================================");

        for (int i = 0; i < n; i++) {
            if (ds[i].getMahsx().equalsIgnoreCase(maHSX)) {
                ds[i].xuat();
                System.out.println();
                found = true;
            }
        }

        if (!found) {
            System.out.println("Khong tim thay hang san xuat voi ma: " + maHSX);
        }
        System.out.println("====================================================");
    }

    public void sua() {
        System.out.print("Nhap ma hang san xuat can sua: ");
        String maHSX = sc.nextLine();
        for (int i = 0; i < n; i++) {
            if (ds[i].getMahsx().equals(maHSX)) {
                System.out.println("\nTim thay hang san xuat:");
                ds[i].xuat();
                System.out.println();

                int k;
                do {
                    System.out.println("\n--- Sua thong tin hang san xuat ---");
                    System.out.println("1. Sua ma hang san xuat");
                    System.out.println("2. Sua ten hang san xuat");
                    System.out.println("3. Sua dia chi");
                    System.out.println("0. Thoat sua");
                    System.out.print("Nhap lua chon: ");
                    k = sc.nextInt();
                    sc.nextLine();

                    switch (k) {
                        case 1:
                            System.out.print("Nhap ma moi: ");
                            ds[i].setMahsx(sc.nextLine());
                            break;
                        case 2:
                            System.out.print("Nhap ten moi: ");
                            ds[i].setTenhsx(sc.nextLine());
                            break;
                        case 3:
                            System.out.print("Nhap dia chi moi: ");
                            ds[i].setDiachi(sc.nextLine());
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
        System.out.println("Khong tim thay hang san xuat voi ma: " + maHSX);
    }

    // ---- Thong ke ----
    public void thongke() {
        System.out.println("\nTHONG KE HANG SAN XUAT");
        System.out.println("====================================");
        System.out.println("Tong so hang san xuat: " + n);

        // Thống kê theo tỉnh/thành phố (dựa trên địa chỉ)
        Map<String, Integer> thongKeTinhThanh = new HashMap<>();
        for (int i = 0; i < n; i++) {
            String diaChi = ds[i].getDiachi();
            // Giả sử tỉnh/thành là từ đầu tiên trong địa chỉ
            String tinhThanh = diaChi.split(",")[0].trim();
            thongKeTinhThanh.put(tinhThanh, thongKeTinhThanh.getOrDefault(tinhThanh, 0) + 1);
        }

        System.out.println("\nPhan bo theo tinh/thanh:");
        for (Map.Entry<String, Integer> entry : thongKeTinhThanh.entrySet()) {
            System.out.println("- " + entry.getKey() + ": " + entry.getValue() + " hang SX");
        }
        System.out.println("====================================");
    }

    // Getter và Setter
    public void setDanhSach(Hangsanxuat[] ds, int n) {
        this.ds = ds;
        this.n = n;
    }

    public Hangsanxuat[] getDs() {
        return ds;
    }

    public int getN() {
        return n;
    }
}