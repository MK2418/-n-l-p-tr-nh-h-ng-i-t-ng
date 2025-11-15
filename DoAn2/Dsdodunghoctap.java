import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.Arrays;
import java.util.Scanner;

interface dieukien {
    void them();

    void xoa();

    void timkiem();

    void sua();
}

public class Dsdodunghoctap implements dieukien {
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
        if (n == 0) {
            System.out.println("Danh sach rong!");
            return;
        }

        System.out.println("\nDANH SACH DO DUNG HOC TAP");
        System.out.println(
                "==========================================================================================================");
        System.out.printf("%-10s %-10s %8s %12s %-8s %-8s %-8s %-12s %-10s\n",
                "Ma SP", "Ten SP", "So luong", "Don gia", "DVT", "MaLoai", "MaSX", "Loai but/Do day", "Ngoi/Kho");
        System.out.println(
                "==========================================================================================================");

        for (int i = 0; i < n; i++) {
            if (ds[i] != null) {
                ds[i].xuat();
            }
        }
        System.out.println(
                "==========================================================================================================");
        System.out.println("Tong so: " + n + " san pham");
    }

    @Override
    public void them() {
        System.out.print("Chon loai (1-But viet, 2-Giay so): ");
        int loai = Integer.parseInt(sc.nextLine());

        Dodunghoctap spMoi;
        if (loai == 1) {
            spMoi = new Butviet();
        } else {
            spMoi = new Giayso();
        }

        spMoi.nhap();

        // Kiểm tra trùng mã
        if (tim(spMoi.maSP) != -1) {
            System.out.println("Ma SP da ton tai!");
            return;
        }

        ds = Arrays.copyOf(ds, n + 1);
        ds[n] = spMoi;
        n++;
        System.out.println("Them thanh cong!");
    }

    @Override
    public void xoa() {
        System.out.print("Nhap ma SP can xoa: ");
        String maSP = sc.nextLine();

        int index = tim(maSP);
        if (index == -1) {
            System.out.println("Khong tim thay san pham!");
            return;
        }

        for (int i = index; i < n - 1; i++) {
            ds[i] = ds[i + 1];
        }
        ds = Arrays.copyOf(ds, n - 1);
        n--;
        System.out.println("Da xoa san pham ma: " + maSP);
    }

    @Override
    public void timkiem() {
        System.out.print("Nhap ma SP can tim: ");
        String maSP = sc.nextLine();

        int index = tim(maSP);
        if (index == -1) {
            System.out.println("Khong tim thay san pham!");
            return;
        }

        System.out.println("\nTHONG TIN SAN PHAM:");
        System.out.printf("%-10s %-15s %8s %12s %-8s %-8s %-8s %-12s %-10s\n",
                "Ma SP", "Ten SP", "So luong", "Don gia", "DVT", "MaLoai", "MaSX", "Loai but/Do day", "Ngoi/Kho");
        ds[index].xuat();
    }

    @Override
    public void sua() {
        System.out.print("Nhap ma SP can sua: ");
        String maSP = sc.nextLine();

        int index = tim(maSP);
        if (index == -1) {
            System.out.println("Khong tim thay san pham!");
            return;
        }

        System.out.println("Nhap thong tin moi cho san pham:");
        if (ds[index] instanceof Butviet) {
            ds[index] = new Butviet();
        } else {
            ds[index] = new Giayso();
        }
        ds[index].nhap();
        ds[index].maSP = maSP;
        System.out.println("Sua thong tin thanh cong!");
    }

    private int tim(String maSP) {
        for (int i = 0; i < n; i++) {
            if (ds[i] != null && ds[i].maSP.equalsIgnoreCase(maSP)) {
                return i;
            }
        }
        return -1;
    }

    public void thongKe() {
        if (n == 0) {
            System.out.println("Danh sach rong!");
            return;
        }

        int tongSL = 0;
        long tongGT = 0;
        int countButviet = 0;
        int countGiayso = 0;

        for (int i = 0; i < n; i++) {
            if (ds[i] != null) {
                tongSL += ds[i].soLuong;
                tongGT += (long) ds[i].soLuong * ds[i].donGia;

                if (ds[i] instanceof Butviet) {
                    countButviet++;
                } else if (ds[i] instanceof Giayso) {
                    countGiayso++;
                }
            }
        }

        System.out.println("\nTHONG KE:");
        System.out.println("Tong so san pham: " + n);
        System.out.println("So but viet: " + countButviet);
        System.out.println("So giay so: " + countGiayso);
        System.out.println("Tong so luong: " + tongSL);
        System.out.println("Tong gia tri: " + tongGT + " VND");
    }
}
