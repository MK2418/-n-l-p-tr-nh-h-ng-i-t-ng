import java.util.Scanner;

public class Nhanvien {
    private String manv;
    private String honv;
    private String tennv;
    private int luong;

    static Scanner sc = new Scanner(System.in);

    // Ham thiet lap khong tham so
    public Nhanvien() {
        manv = "";
        honv = "";
        tennv = "";
        luong = 0;
    }

    // Ham thiet lap co tham so
    public Nhanvien(String manv, String honv, String tennv, int luong) {
        this.manv = manv;
        this.honv = honv;
        this.tennv = tennv;
        this.luong = luong;
    }

    // Ham thiet lap sao chep
    public Nhanvien(Nhanvien other) {
        this.manv = other.manv;
        this.honv = other.honv;
        this.tennv = other.tennv;
        this.luong = other.luong;
    }

    // ---- Getters & Setters ----
    public String getManv() {
        return manv;
    }

    public void setManv(String manv) {
        this.manv = manv;
    }

    public String getHonv() {
        return honv;
    }

    public void setHonv(String honv) {
        this.honv = honv;
    }

    public String getTennv() {
        return tennv;
    }

    public void setTennv(String tennv) {
        this.tennv = tennv;
    }

    public int getLuong() {
        return luong;
    }

    public void setLuong(int luong) {
        this.luong = luong;
    }

    // ---- Nhap / Xuat ----
    public void nhap() {
        System.out.print("Nhap ma nhan vien: ");
        manv = sc.nextLine();

        System.out.print("Nhap ho nhan vien: ");
        honv = sc.nextLine();

        System.out.print("Nhap ten nhan vien: ");
        tennv = sc.nextLine();

        System.out.print("Nhap luong: ");
        luong = Integer.parseInt(sc.nextLine());
    }

    public void xuat() {
        System.out.printf("%-15s %-20s %-15s %-15d%n", manv, honv, tennv, formatLuong(luong));
        System.out.println("---------------------------------------------------------------------");
    }

    public String toFileString() {
        return String.format("%s,%s,%s,%d",
                manv, honv, tennv, luong);
    }

    
    public static String formatLuong(int n) {
        return String.format("%,d", n).replace(",", ".");
    }
}
