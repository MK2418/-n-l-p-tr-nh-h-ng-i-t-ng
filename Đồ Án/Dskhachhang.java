import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.Arrays;
import java.util.Scanner;

public class Dskhachhang implements dieukien {
    int n;
    Khachhang[] ds;

    Scanner sc = new Scanner(System.in);

    public void docFile(String filename) throws Exception {
        try (BufferedReader br = new BufferedReader(new FileReader(filename))) {
            n = Integer.parseInt(br.readLine().trim());
            ds = new Khachhang[n];

            for (int i = 0; i < n; i++) {
                String line = br.readLine();
                if (line == null || line.trim().isEmpty())
                    break;

                // Định dạng: makh,ho,ten,diaChi,sdt
                String[] parts = line.split(",");

                String makh = parts[0].trim();
                String ho = parts[1].trim();
                String ten = parts[2].trim();
                String diaChi = parts[3].trim();
                int sdt = Integer.parseInt(parts[4].trim());

                Khachhang kh = new Khachhang(makh, ho, ten, diaChi, sdt);
                ds[i] = kh;
            }
        }
        System.out.println("Đọc dữ liệu khách hàng từ file thành công!");
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
        System.out.println("Ghi dữ liệu khách hàng ra file thành công!");
    }

    public void xuat() {
        for (int i = 0; i < n; i++) {
            System.out.println("---------------------------");
            System.out.println("Thong tin khach hang thu " + (i + 1) + ": ");
            ds[i].xuat();
        }
    }

    @Override
    public void them() {
        ds = Arrays.copyOf(ds, n + 1);
        ds[n] = new Khachhang();
        ds[n].nhap();
        n++;
        System.out.println("Đã thêm khách hàng mới thành công!");
    }

    @Override
    public void xoa() {
        System.out.println("Nhập mã khách hàng muốn xóa");
        String makh = sc.nextLine();
        for (int i = 0; i < n; i++) {
            if (ds[i].getMakh().equalsIgnoreCase(makh)) {
                for (int j = i; j < n - 1; j++) {
                    ds[j] = ds[j + 1];
                }
                ds = Arrays.copyOf(ds, n - 1);
                n--;
                System.out.println("Đã xóa khách hàng thành công");
                return;
            }
        }
        System.out.println("Không tìm thấy mã khách hàng muốn xóa");
    }

    @Override
    public void timkiem() {
        System.out.print("Nhap ma khach hang can tim: ");
        String makh = sc.nextLine();
        for (int i = 0; i < n; i++) {
            if (ds[i].getMakh().equalsIgnoreCase(makh)) {
                System.out.println("Thong tin khach hang:");
                ds[i].xuat();
                return;
            }
        }
        System.out.println("Khong tim thay nha cung cap voi ma nay.");
    }

    @Override
    public void sua() {
        System.out.print("Nhap ma khach hang can sua: ");
        String makh = sc.nextLine();
        for (int i = 0; i < n; i++) {
            if (ds[i].getMakh().equals(makh)) {
                int k;
                do {
                    System.out.println("\n--- Sua thong tin khach hang ---");
                    System.out.println("1. Sua ma khach hang");
                    System.out.println("2. Sua ho khach hang");
                    System.out.println("3. Sua ten khach hang");
                    System.out.println("4. Sua dia chi");
                    System.out.println("5. Sua so dien thoai");
                    System.out.println("0. Thoat sua");
                    System.out.print("Nhap lua chon: ");
                    k = sc.nextInt();
                    sc.nextLine(); // bỏ dòng thừa

                    switch (k) {
                        case 1:
                            System.out.print("Nhap ma moi: ");
                            ds[i].setMakh(sc.nextLine());
                            break;
                        case 2:
                            System.out.print("Nhap ho moi: ");
                            ds[i].setHo(sc.nextLine());
                            break;
                        case 3:
                            System.out.print("Nhap ten moi: ");
                            ds[i].setTen(sc.nextLine());
                            break;
                        case 4:
                            System.out.print("Nhap dia chi moi: ");
                            ds[i].setDiaChi(sc.nextLine());
                            break;
                        case 5:
                            System.out.print("Nhap so dien thoai moi: ");
                            ds[i].setSdt(sc.nextInt());
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
        System.out.println("Khong tim thay khach hang voi ma nay.");
    }
}
