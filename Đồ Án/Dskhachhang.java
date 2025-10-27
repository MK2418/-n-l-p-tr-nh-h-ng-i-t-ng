import java.util.Scanner;

class Dskhachhang {
    int n;
    Khachhang[] ds;
    Scanner sc = new Scanner(System.in);

    public void Nhap() {
        System.out.println("Nhap so luong khach hang: ");
        n = sc.nextInt();
        ds = new Khachhang[n];
        for (int i = 0; i < n; i++) {
            System.out.println("Nhap thong tin khach hang thu " + (i + 1) + ": ");
            ds[i] = new Khachhang();
            ds[i].Nhap();
        }
    }

    public void Xuat() {
        for (int i = 0; i < n; i++) {
            System.out.println("---------------------------");
            System.out.println("Thong tin khach hang thu " + (i + 1) + ": ");
            ds[i].Xuat();
        }
    }

}