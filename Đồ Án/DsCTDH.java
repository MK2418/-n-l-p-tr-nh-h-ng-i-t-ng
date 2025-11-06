import java.io.*;
import java.util.Arrays;
import java.util.Scanner;

public class DsCTDH implements dieukien {
    int n;
    ChiTietDonHang[] ds = new ChiTietDonHang[0];
    Scanner sc = new Scanner(System.in);

    public void ghifile() {
        try {
            FileWriter fw = new FileWriter("DsCTHD.txt");
            BufferedWriter bw = new BufferedWriter(fw);
            for (int i = 0; i < n; i++) {
                bw.write(ds[i].getMahd() + "," + ds[i].getMsp() + "," + ds[i].getSl() + "," + ds[i].getDongia());
                bw.newLine();
            }
            bw.close();
            fw.close();
            System.out.println("Đã ghi file thành công!");
        } catch (IOException e) {
            System.out.println("Lỗi ghi file: " + e.getMessage());
        }
    }

    public void docfile() {
        try {
            FileReader fr = new FileReader("DsCTHD.txt");
            BufferedReader br = new BufferedReader(fr);
            String line;
            n = 0;
            ds = new ChiTietDonHang[0];

            while ((line = br.readLine()) != null) {
                String[] parts = line.split(",");
                if (parts.length == 4) {
                    String mahd = parts[0];
                    String msp = parts[1];
                    int sl = Integer.parseInt(parts[2]);
                    double dongia = Double.parseDouble(parts[3]);

                    ds = Arrays.copyOf(ds, n + 1);
                    ds[n] = new ChiTietDonHang(mahd, msp, sl, dongia);
                    n++;
                }
            }
            br.close();
            fr.close();
            System.out.println("Đã đọc file thành công (" + n + " hóa đơn)");
        } catch (IOException e) {
            System.out.println("Lỗi đọc file: " + e.getMessage());
        }
    }
    
    public void xuat() {
        System.out.println("===== DANH SÁCH CHI TIẾT HÓA ĐƠN =====");
        for (int i = 0; i < n; i++) {
            ds[i].xuat();
        }
    }

    @Override
    public void them() {
        ds = Arrays.copyOf(ds, n + 1);
        System.out.println("Nhập thông tin chi tiết hóa đơn thứ " + (n + 1) + ": ");
        ds[n] = new ChiTietDonHang();
        ds[n].nhap();
        n++;
        System.out.println("Đã thêm chi tiết hóa đơn!");
    }


    @Override
    public void xoa() {
        System.out.print("Nhập mã hóa đơn cần xóa: ");
        String mahd = sc.nextLine();
        for (int i = 0; i < n; i++) {
            if (ds[i].getMahd().equalsIgnoreCase(mahd)) {
                for (int j = i; j < n - 1; j++) {
                    ds[j] = ds[j + 1];
                }
                ds = Arrays.copyOf(ds, n - 1);
                n--;
                System.out.println("✅ Đã xóa thành công!");
                return;
            }
        }
        System.out.println("Không tìm thấy mã hóa đơn cần xóa!");
    }

    @Override
    public void timkiem() {
        System.out.print("Nhập mã hóa đơn cần tìm: ");
        String mahd = sc.nextLine();
        for (int i = 0; i < n; i++) {
            if (ds[i].getMahd().equalsIgnoreCase(mahd)) {
                System.out.println("Thông tin chi tiết hóa đơn:");
                ds[i].xuat();
                return;
            }
        }
        System.out.println("Không tìm thấy hóa đơn!");
    }

    @Override
    public void sua() {
        System.out.print("Nhập mã hóa đơn cần sửa: ");
        String mahd = sc.nextLine();
        for (int i = 0; i < n; i++) {
            if (ds[i].getMahd().equalsIgnoreCase(mahd)) {
                int chon;
                do {
                    System.out.println("=== SỬA THÔNG TIN CHI TIẾT HÓA ĐƠN ===");
                    System.out.println("1. Sửa mã sản phẩm");
                    System.out.println("2. Sửa số lượng");
                    System.out.println("3. Sửa đơn giá");
                    System.out.println("0. Thoát sửa");
                    System.out.print("Chọn: ");
                    chon = sc.nextInt();
                    sc.nextLine();

                    switch (chon) {
                        case 1:
                            System.out.print("Nhập mã sản phẩm mới: ");
                            ds[i].setMsp(sc.nextLine());
                            break;
                        case 2:
                            System.out.print("Nhập số lượng mới: ");
                            ds[i].setSl(sc.nextInt());
                            break;
                        case 3:
                            System.out.print("Nhập đơn giá mới: ");
                            ds[i].setDongia(sc.nextDouble());
                            break;
                        case 0:
                            System.out.println("Đã thoát sửa.");
                            break;
                        default:
                            System.out.println("Lựa chọn không hợp lệ!");
                    }
                } while (chon != 0);
                return;
            }
        }
        System.out.println(" Không tìm thấy mã hóa đơn cần sửa!");
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
