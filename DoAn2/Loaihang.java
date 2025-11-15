import java.util.Scanner;

public class Loaihang {
    private String malh, tenlh, mota;
    Scanner sc = new Scanner(System.in);

    public Loaihang() {}
    public Loaihang(String malh, String tenlh, String mota) {
        this.malh = malh;
        this.tenlh = tenlh;
        this.mota = mota;
    }

    public void nhap() {
        System.out.print("Nhap ma loai hang: ");
        malh = sc.nextLine();
        System.out.print("Nhap ten loai hang: ");
        tenlh = sc.nextLine();
        System.out.print("Nhap mo ta: ");
        mota = sc.nextLine();
    }

    public void xuat() {
        System.out.printf("%-15s %-20s %-15s%n", malh, tenlh, mota);
        System.out.println("---------------------------------------------------------");
    }


    public String toString() {
        return malh + "," + tenlh + "," + mota;
    }

    // Getter & Setter
    public String getMalh() { return malh; }
    public void setMalh(String malh) { this.malh = malh; }

    public String getTenlh() { return tenlh; }
    public void setTenlh(String tenlh) { this.tenlh = tenlh; }

    public String getMota() { return mota; }
    public void setMota(String mota) { this.mota = mota; }
}
