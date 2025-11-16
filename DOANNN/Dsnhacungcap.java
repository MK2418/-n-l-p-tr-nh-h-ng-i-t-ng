import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.*;

class Dsnhacungcap implements dieukien {
    private int n;
    private Nhacungcap[] ds;
    Scanner sc = new Scanner(System.in);

    public Dsnhacungcap() {
        n = 0;
        ds = new Nhacungcap[0];
    }

    public void docFile(String filename) throws Exception {
        try (BufferedReader br = new BufferedReader(new FileReader(filename))) {
            n = Integer.parseInt(br.readLine().trim());
            ds = new Nhacungcap[n];
            for (int i = 0; i < n; i++) {
                String line = br.readLine();
                if (line == null)
                    break;
                String[] parts = line.split(",");
                ds[i] = new Nhacungcap(parts[0], parts[1], parts[2], Integer.parseInt(parts[3]));
            }
            System.out.println("Doc du lieu thanh cong: " + n + " san pham!"); // ← CÓ THÔNG BÁO
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
        System.out.println("==============================================================");
        System.out.printf("| %-10s | %-20s | %-20s | %-13s |\n",
                "Ma NCC", "Ten NCC", "Dia Chi", "So Dien Thoai");
        System.out.println("==============================================================");

        for (int i = 0; i < n; i++) {
            ds[i].xuat();
        }

        System.out.println("==============================================================");
    }

    public void nhap() {
        for (int i = 0; i < n; i++) {
            System.out.println("Nhap thong tin nha cung cap thu " + (i + 1) + ": ");
            ds[i] = new Nhacungcap();
            ds[i].nhap();
        }
    }

    // Ham co ban khong tham so
    @Override
    public void them() {
        ds = Arrays.copyOf(ds, n + 1);
        System.out.println("Nhap thong tin nha cung cap moi: ");
        ds[n] = new Nhacungcap();
        ds[n].nhap();
        n++;
        System.out.println("Da them nha cung cap moi thanh cong!");
    }

    @Override
    public void xoa() {
        System.out.print("nhập mã nhà cung cấp cần xóa");
        String maNCC = sc.nextLine();
        for (int i = 0; i < n; i++) {
            if (ds[i].getMaNCC().equals(maNCC)) {
                for (int j = i; j < n - 1; j++) {
                    ds[j] = ds[j + 1];
                }
                ds = Arrays.copyOf(ds, n - 1);
                n--;
                System.out.println("Da xoa nha cung cap co ma " + maNCC);
                return;
            }
        }
        System.out.println("Khong tim thay nha cung cap co ma " + maNCC);
    }

    @Override
    public void timkiem() {
        System.out.print("Nhap ma nha cung cap can tim: ");
        String maNCC = sc.nextLine();
        for (int i = 0; i < n; i++) {
            if (ds[i].getMaNCC().equalsIgnoreCase(maNCC)) {
                System.out.printf("| %-10s | %-20s | %-20s | %-13s |\n",
                        "Ma NCC", "Ten NCC", "Dia Chi", "So Dien Thoai");
                ds[i].xuat();
                return;
            }
        }
        System.out.println("Khong tim thay nha cung cap voi ma nay.");
    }

    @Override
    public void sua() {
        System.out.print("Nhap ma nha cung cap can sua");
        String maNCC = sc.nextLine();
        for (int i = 0; i < n; i++) {
            if (ds[i].getMaNCC().equals(maNCC)) {
                int k;
                do {
                    System.out.println("\n--- Sua thong tin nha cung cap ---");
                    System.out.println("1. Sua ma nha cung cap");
                    System.out.println("2. Sua ten nha cung cap");
                    System.out.println("3. Sua dia chi");
                    System.out.println("4. Sua so dien thoai");
                    System.out.println("0. Thoat sua");
                    System.out.print("Nhap lua chon: ");
                    k = sc.nextInt();
                    sc.nextLine(); // bỏ dòng thừa

                    switch (k) {
                        case 1:
                            System.out.print("Nhap ma moi: ");
                            ds[i].setMaNCC(sc.nextLine());
                            break;
                        case 2:
                            System.out.print("Nhap ten moi: ");
                            ds[i].setTenNCC(sc.nextLine());
                            break;
                        case 3:
                            System.out.print("Nhap dia chi moi: ");
                            ds[i].setDiaChi(sc.nextLine());
                            break;
                        case 4:
                            System.out.print("Nhap so dien thoai moi: ");
                            ds[i].setSoDienThoai(sc.nextInt());
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
        System.out.println("Khong tim thay nha cung cap voi ma nay.");
    }

    // Ham co ban co tham so
    public void themcothamso(String ma, String ten, String diachi, int sdt) {
        ds = Arrays.copyOf(ds, n + 1);
        ds[n] = new Nhacungcap();
        ds[n].setMaNCC(ma);
        ds[n].setTenNCC(ten);
        ds[n].setDiaChi(diachi);
        ds[n].setSoDienThoai(sdt);
        n++;
        System.out.println("Da them nha cung cap moi thanh cong!");
    }

    public void xoacothamso(String ma) {
        String maNCC = ma;
        for (int i = 0; i < n; i++) {
            if (ds[i].getMaNCC().equals(maNCC)) {
                for (int j = i; j < n - 1; j++) {
                    ds[j] = ds[j + 1];
                }
                ds = Arrays.copyOf(ds, n - 1);
                n--;
                System.out.println("Da xoa nha cung cap co ma " + maNCC);
                return;
            }
        }
        System.out.println("Khong tim thay nha cung cap co ma " + maNCC);
    }

    public void timkiemcothamso(String ma) {
        String maNCC = ma;
        for (int i = 0; i < n; i++) {
            if (ds[i].getMaNCC().equalsIgnoreCase(maNCC)) {
                System.out.printf("| %-10s | %-20s | %-20s | %-13s |\n",
                        "Ma NCC", "Ten NCC", "Dia Chi", "So Dien Thoai");
                ds[i].xuat();
                return;
            }
        }
        System.out.println("Khong tim thay nha cung cap voi ma nay.");
    }

    public void suacothamso(String ma) {
        String maNCC = ma;
        for (int i = 0; i < n; i++) {
            if (ds[i].getMaNCC().equals(maNCC)) {
                int k;
                do {
                    System.out.println("\n--- Sua thong tin nha cung cap ---");
                    System.out.println("1. Sua ma nha cung cap");
                    System.out.println("2. Sua ten nha cung cap");
                    System.out.println("3. Sua dia chi");
                    System.out.println("4. Sua so dien thoai");
                    System.out.println("0. Thoat sua");
                    System.out.print("Nhap lua chon: ");
                    k = sc.nextInt();
                    sc.nextLine(); // bỏ dòng thừa

                    switch (k) {
                        case 1:
                            System.out.print("Nhap ma moi: ");
                            ds[i].setMaNCC(sc.nextLine());
                            break;
                        case 2:
                            System.out.print("Nhap ten moi: ");
                            ds[i].setTenNCC(sc.nextLine());
                            break;
                        case 3:
                            System.out.print("Nhap dia chi moi: ");
                            ds[i].setDiaChi(sc.nextLine());
                            break;
                        case 4:
                            System.out.print("Nhap so dien thoai moi: ");
                            ds[i].setSoDienThoai(sc.nextInt());
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
        System.out.println("Khong tim thay nha cung cap voi ma nay.");
    }

    public void thongke() {
        System.out.println("Thong ke theo thanh pho ");
        String[] thanhpho = new String[n];
        int[] soluong = new int[n];
        int count = 0;
        for (int i = 0; i < n; i++) {
            String tp = ds[i].getDiaChi();
            boolean found = false;
            for (int j = 0; j < count; j++) {
                if (thanhpho[j].equals(tp)) {
                    soluong[j]++;
                    found = true;
                    break;
                }
            }
            if (!found) {
                thanhpho[count] = tp;
                soluong[count] = 1;
                count++;
            }
        }
        for (int i = 0; i < count; i++) {
            System.out.println(thanhpho[i] + ": " + soluong[i] + " nha cung cap");
        }
    }

    public void setDanhSach(Nhacungcap[] ds, int n) {
        this.ds = ds;
        this.n = n;
    }

    public Nhacungcap[] getDs() {
        return ds;
    }

}
