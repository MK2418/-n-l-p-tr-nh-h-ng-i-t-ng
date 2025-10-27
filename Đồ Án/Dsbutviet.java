import java.util.Scanner;

class Dsbutviet {
    int n;
    Butviet[] ds;
    Scanner sc = new Scanner(System.in);

    public void Nhap() {
        System.out.println("Nhap so luong but viet: ");
        n = sc.nextInt();
        ds = new Butviet[n];
        for (int i = 0; i < n; i++) {
            System.out.println("Nhap thong tin but viet thu " + (i + 1) + ": ");
            ds[i] = new Butviet();
            ds[i].Nhap();
        }
    }

    public void Xuat() {
        for (int i = 0; i < n; i++) {
            System.out.println("---------------------------");
            System.out.println("Thong tin but viet thu " + (i + 1) + ": ");
            ds[i].Xuat();
        }
    }

}