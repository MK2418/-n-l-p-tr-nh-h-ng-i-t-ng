import java.io.*;
import java.util.*;

public class DsCTDH {
    static int n;
    static ChiTietDonHang[] ds;
    static Scanner sc = new Scanner(System.in);

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
        for (int i = 0; i < n; i++) {
            System.out.println("------------------------");
            System.out.println("Thong tin chi tiet don hang thu " + (i + 1) + ": ");
            ds[i].xuat();
        }
    }
    
    public void them(ChiTietDonHang ctdh) {
        ds = Arrays.copyOf(ds, n + 1);          
        ds[n] = ctdh;
        n++;                                  
        System.out.println("Da them chi tiet don hang thanh cong!");
    }

    public void xoa(String mahd, String msp) {
        for (int i = 0; i < n; i++) {
            if (ds[i].getMahd().equalsIgnoreCase(mahd) && ds[i].getMsp().equalsIgnoreCase(msp)) {
                for (int j = i; j < n - 1; j++) {
                    ds[j] = ds[j + 1];
                }
                ds = Arrays.copyOf(ds, n - 1);
                n--;
                System.out.println("Đã xóa " + mahd + " - " + msp);
                return;
            }
        }
        System.out.println("Không tìm thấy " + mahd + " - " + msp);
    }
    
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

    public void sua(String mahd, String msp, ChiTietDonHang ctdhMoi) {
        for (int i = 0; i < n; i++) {
            if (ds[i].getMahd().equalsIgnoreCase(mahd) && ds[i].getMsp().equalsIgnoreCase(msp)) {
                ds[i] = ctdhMoi;
                System.out.println("Đã sửa thông tin chi tiết đơn hàng " + mahd + " - " + msp);
                return;
            }
        }
        System.out.println("Không tìm thấy chi tiết đơn hàng " + mahd + " - " + msp);
    }
    
    

    public boolean kiemTraTrungMa(String mahd) {
        for (int i = 0; i < n; i++) {
            if (ds[i].getMahd().equalsIgnoreCase(mahd)) {
                return true;
            }
        }
        return false;
    }
}