import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.Arrays;
import java.util.Scanner;

public class Dskhachhang{
    static int n;
    static Khachhang[] ds;
    static Scanner sc = new Scanner(System.in);

    public void docFile(String filename) throws Exception {
        try (BufferedReader br = new BufferedReader(new FileReader(filename))) {
            n = Integer.parseInt(br.readLine());
            ds = new Khachhang[n];
            for (int i = 0; i < n; i++) {
                String line = br.readLine();
                if (line == null || line.trim().isEmpty())
                    break;

                String[] parts = line.split(",");

                String makh = parts[0];
                String ho = parts[1];
                String ten = parts[2];
                String diachi = parts[3];
                int sdt = Integer.parseInt(parts[4]);

                Khachhang kh = new Khachhang();
                kh.setMakh(makh);
                kh.setHo(ho);
                kh.setTen(ten);
                kh.setDiaChi(diachi);
                kh.setSdt(sdt);

                ds[i] = kh;
            }
        }
        System.out.println("Doc du lieu tu file thanh cong!");
    }

    public void ghiFile(String filename) throws Exception {
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(filename))) {
            bw.write(n + "");
            bw.newLine();
            for (int i = 0; i < n; i++) {
                if (ds[i] != null) {
                    bw.write(ds[i].getMakh() + ","
                            + ds[i].getHo() + ","
                            + ds[i].getTen() + ","
                            + ds[i].getDiaChi() + ","
                            + ds[i].getSdt());
                    bw.newLine();
                }
            }
        }
        System.out.println("Ghi du lieu vao file thanh cong!");
    }

    public void xuat() {
        for (int i = 0; i < n; i++) {
            System.out.println("------------------------");
            System.out.println("Thong tin khach hang thu " + (i + 1) + ": ");
            ds[i].xuat();
        }
    }

    public void them(Khachhang khMoi) {
        ds = Arrays.copyOf(ds, n + 1);
        ds[n] = khMoi;
        n++;
        System.out.println("Đã thêm khách hàng mới: " + khMoi.getMakh());
    }

    public void xoa(String makh) {
        for (int i = 0; i < n; i++) {
            if (ds[i].getMakh().equalsIgnoreCase(makh)) {
                for (int j = i; j < n - 1; j++) {
                    ds[j] = ds[j + 1];
                }
                ds = Arrays.copyOf(ds, n - 1);
                n--;
                System.out.println("Đã xóa khách hàng: " + makh);
                return;
            }
        }
        System.out.println("Không tìm thấy khách hàng: " + makh);
    }

    public void sua(String makh, Khachhang khMoi) {
        for (int i = 0; i < n; i++) {
            if (ds[i].getMakh().equalsIgnoreCase(makh)) {
                ds[i] = khMoi;
                System.out.println("Đã sửa khách hàng: " + makh);
                return;
            }
        }
        System.out.println("Không tìm thấy khách hàng: " + makh);
    }
    
    public void timkiem() {
        System.out.println("Nhap ma khach hang de tim kiem: ");
        String makh = sc.nextLine();
        for (int i = 0; i < n; i++) {
            if (ds[i].getMakh().equalsIgnoreCase(makh)) {
                ds[i].xuat();
                return;
            }
        }
        System.out.print("Khong tim thay ma khach hang");
    }

    public void thongke() {
        System.out.println("=== THONG KE KHACH HANG ===");
        System.out.println("Tong so khach hang: " + n);

        System.out.println("Danh sach khach hang:");
        for (int i = 0; i < n; i++) {
            System.out.println((i + 1) + ". " + ds[i].getMakh() + " - " +
                    ds[i].getHo() + " " + ds[i].getTen());
        }
    }
}