import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.*;

interface dieukien {
    void them();

    void xoa();

    void timkiem();

    void sua();
}

class Dsnhacungcap implements dieukien {
    private int n;
    private Nhacungcap[] ds;
    Scanner sc = new Scanner(System.in);

    public void docFile(String filename) throws Exception {
        try (BufferedReader br = new BufferedReader(new FileReader(filename))) {
            n = Integer.parseInt(br.readLine());
            ds = new Nhacungcap[n];
            for (int i = 0; i < n; i++) {
                String line = br.readLine();
                if (line == null)
                    break;
                String[] parts = line.split(",");
                ds[i] = new Nhacungcap(parts[0], parts[1], parts[2], Integer.parseInt(parts[3]));
            }
        }
    }

    public void ghiFile(String filename) throws Exception {
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(filename))) {
            bw.write(n + "");
            bw.newLine();
            for (int i = 0; i < n; i++) {
                if (ds[i] != null) {
                    bw.write(ds[i].getMaNCC() + "," + ds[i].getTenNCC() + "," + ds[i].getDiaChi() + ","
                            + ds[i].getSoDienThoai());
                    bw.newLine();
                }
            }
        }
        System.out.println("Da ghi du lieu vao file thanh cong!");
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

    public void setDanhSach(Nhacungcap[] ds, int n) {
        this.ds = ds;
        this.n = n;
    }

    public Nhacungcap[] getDs() {
        return ds;
    }

}
