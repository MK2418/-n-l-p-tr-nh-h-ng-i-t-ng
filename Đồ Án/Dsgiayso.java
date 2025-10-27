import java.util.Scanner;

class Dsgiayso {
    int n;
    Giayso[] ds;
    Scanner sc = new Scanner(System.in);

    public void Nhap() {
        System.out.println("Nhap so luong giay so: ");
        n = sc.nextInt();
        ds = new Giayso[n];
        for (int i = 0; i < n; i++) {
            System.out.println("Nhap thong tin giay so thu " + (i + 1) + ": ");
            ds[i] = new Giayso();
            ds[i].Nhap();
        }
    }

    public void Xuat() {
        for (int i = 0; i < n; i++) {
            System.out.println("---------------------------");
            System.out.println("Thong tin giay so thu " + (i + 1) + ": ");
            ds[i].Xuat();
        }
    }

}