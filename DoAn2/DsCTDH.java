import java.io.*;
import java.util.*;

public class DsCTDH implements dieukien {
    private int n;
    private ChiTietDonHang[] ds;
    private Scanner sc = new Scanner(System.in);

    public DsCTDH() {
        ds = new ChiTietDonHang[0];
        n = 0;
    }

    public void docFile(String filename) throws Exception {
        try (BufferedReader br = new BufferedReader(new FileReader(filename))) {
            n = Integer.parseInt(br.readLine());
            ds = new ChiTietDonHang[n];
            for (int i = 0; i < n; i++) {
                String line = br.readLine();
                if (line == null || line.trim().isEmpty())
                    break;

                String[] parts = line.split(",");
                String mahd = parts[0];
                String msp = parts[1];
                int sl = Integer.parseInt(parts[2]);
                double dongia = Double.parseDouble(parts[3]);

                ds[i] = new ChiTietDonHang(mahd, msp, sl, dongia);
            }
            System.out.println("Doc file thanh cong (" + n + " dong du lieu)");
        }
    }

    public void ghiFile(String filename) throws Exception {
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(filename))) {
            bw.write(n + "");
            bw.newLine();
            for (int i = 0; i < n; i++) {
                if (ds[i] != null) {
                    bw.write(ds[i].getMahd() + "," +
                            ds[i].getMsp() + "," +
                            ds[i].getSl() + "," +
                            ds[i].getDongia());
                    bw.newLine();
                }
            }
        }
        System.out.println("Ghi file thanh cong!");
    }

    public void xuat() {
        if (n == 0 || ds == null) {
            System.out.println("Danh sach chi tiet don hang trong!");
            return;
        }

        System.out.println("========================================================================================================");
        System.out.printf("%-10s %-10s %10s %15s %15s\n",
                "MaHD", "MaSP", "SoLuong", "DonGia", "ThanhTien");
        System.out.println("========================================================================================================");

        for (int i = 0; i < n; i++) {
            ChiTietDonHang ct = ds[i];

            double thanhTien = ct.getSl() * ct.getDongia();

            System.out.printf("%-10s %-10s %10d %,15.0f %,15.0f\n",
                    ct.getMahd(),
                    ct.getMsp(),
                    ct.getSl(),
                    ct.getDongia(),
                    thanhTien
            );
        }

        System.out.println("========================================================================================================");
        System.out.println("Tong so chi tiet don hang: " + n);
    }

    public void themCothamso(ChiTietDonHang ctdh) {
        ds = Arrays.copyOf(ds, n + 1);          
        ds[n] = ctdh;
        n++;                                  
        System.out.println("Da them chi tiet don hang thanh cong!");
    }

    public void xoaCothamso(String mahd, String msp) {
        for (int i = 0; i < n; i++) {
            if (ds[i].getMahd().equalsIgnoreCase(mahd) && ds[i].getMsp().equalsIgnoreCase(msp)) {
                for (int j = i; j < n - 1; j++) {
                    ds[j] = ds[j + 1];
                }
                ds = Arrays.copyOf(ds, n - 1);
                n--;
                System.out.println("Da xoa " + mahd + " - " + msp);
                return;
            }
        }
        System.out.println("Khong tim thay " + mahd + " - " + msp);
    }
    
    public void suaCothamso(String mahd, String msp, ChiTietDonHang ctdhMoi) {
        for (int i = 0; i < n; i++) {
            if (ds[i].getMahd().equalsIgnoreCase(mahd) && ds[i].getMsp().equalsIgnoreCase(msp)) {
                ds[i] = ctdhMoi;
                System.out.println("Da ua thong tin chi tiet don hang " + mahd + " - " + msp);
                return;
            }
        }
        System.out.println("Khong tim thay chi tiet don hang " + mahd + " - " + msp);
    }
    
    @Override
    public void them() {
        ds = Arrays.copyOf(ds, n + 1);
        ds[n] = new ChiTietDonHang();
        ds[n].nhap();
        n++;
        System.out.println("Da them chi tiet don hang thanh cong!");
    }

    @Override
    public void xoa() {
        System.out.println("Nhap ma hoa don muon xoa: ");
        String mahd = sc.nextLine();
        System.out.println("Nhap ma san pham muon xoa: ");
        String msp = sc.nextLine();

        for (int i = 0; i < n; i++) {
            if (ds[i].getMahd().equals(mahd) && ds[i].getMsp().equals(msp)) {
                for (int j = i; j < n - 1; j++) {
                    ds[j] = ds[j + 1];
                }
                ds = Arrays.copyOf(ds, n - 1);
                n--;
                System.out.println("Da xoa " + mahd + " - " + msp);
                return;
            }
        }
        System.out.println("Khong tim thay " + mahd + " - " + msp);
    }

    @Override
    public void timkiem() {
        System.out.println("Nhap ma hoa don de tim kiem: ");
        String mahd = sc.nextLine();
        for (int i = 0; i < n; i++) {
            if (ds[i].getMahd().equalsIgnoreCase(mahd)) {
                ds[i].xuat();
                return;
            }
        }
        System.out.print("Khong tim thay ma hoa don");
    }

    @Override
    public void sua() {
        System.out.print("Nhap ma hoa don can sua: ");
        String mahd = sc.nextLine();
        System.out.print("Nhap ma san pham can sua: ");
        String msp = sc.nextLine();

        for (int i = 0; i < n; i++) {
            if (ds[i].getMahd().equalsIgnoreCase(mahd) && ds[i].getMsp().equalsIgnoreCase(msp)) {
                int k;
                do {
                    System.out.println("---Sua thong tin chi tiet don hang---");
                    System.out.println("1. Sua ma hoa don");
                    System.out.println("2. Sua ma san pham");
                    System.out.println("3. Sua so luong");
                    System.out.println("4. Sua don gia");
                    System.out.println("0. Thoat");
                    System.out.print("Nhap lua chon: ");
                    k = sc.nextInt();
                    sc.nextLine();

                    switch (k) {
                        case 1:
                            System.out.println("Vui long nhap ma hoa don moi: ");
                            ds[i].setMahd(sc.nextLine());
                            break;
                        case 2:
                            System.out.println("Vui long nhap ma san pham moi: ");
                            ds[i].setMsp(sc.nextLine());
                            break;
                        case 3:
                            System.out.println("Vui long nhap so luong moi: ");
                            ds[i].setSl(sc.nextInt());
                            sc.nextLine();
                            break;
                        case 4:
                            System.out.println("Vui long nhap don gia moi: ");
                            ds[i].setDongia(sc.nextDouble());
                            sc.nextLine();
                            break;
                        case 0:
                            System.out.println("Thoat sua thong tin.");
                            break;
                        default:
                            System.out.println("Lua chon khong hop le!");
                    }
                } while (k != 0);
                return;
            }
        }
        System.out.println("Khong tim thay chi tiet don hang nay!");
    }

    public boolean kiemTraTrungMa(String mahd) {
        for (int i = 0; i < n; i++) {
            if (ds[i].getMahd().equalsIgnoreCase(mahd)) {
                return true;
            }
        }
        return false;
    }
    
    public void thongKeTheoMa() {
        System.out.print("Nhap ma hoa don can thong ke: ");
        String mahd = sc.nextLine();

        double tongTien = 0;
        int dem = 0;

        System.out.println("\n========================================================================================================");
        System.out.println("                         THONG KE CHI TIET THEO MA HOA DON: " + mahd);
        System.out.println("========================================================================================================");

        System.out.printf("%-10s %-10s %10s %15s %15s\n",
                "MaHD", "MaSP", "SoLuong", "DonGia", "ThanhTien");
        System.out.println("--------------------------------------------------------------------------------------------------------");

        for (int i = 0; i < n; i++) {
            if (ds[i].getMahd().equalsIgnoreCase(mahd)) {

                double thanhTien = ds[i].getSl() * ds[i].getDongia();
                tongTien += thanhTien;
                dem++;

                System.out.printf("%-10s %-10s %10d %,15.0f %,15.0f\n",
                        ds[i].getMahd(),
                        ds[i].getMsp(),
                        ds[i].getSl(),
                        ds[i].getDongia(),
                        thanhTien
                );
            }
        }

        if (dem == 0) {
            System.out.println("Khong tim thay chi tiet cua hoa don: " + mahd);
            return;
        }

        System.out.println("--------------------------------------------------------------------------------------------------------");
        System.out.printf("Tong so chi tiet: %d\n", dem);
        System.out.printf("TONG TIEN HOA DON: %,15.0f VND\n", tongTien);
        System.out.println("========================================================================================================");
    }
    
    public ChiTietDonHang[] getDs() {
        return ds;
    }
}