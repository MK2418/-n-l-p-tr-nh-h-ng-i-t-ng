import java.util.Scanner;

public class Nhanvien {
    private String manv;
    private String honv;
    private String tennv;
    private int luong;

    static Scanner sc = new Scanner(System.in);

    // ---- Constructors ----
    public Nhanvien() {}

    public Nhanvien(String manv, String honv, String tennv, int luong) {
        this.manv = manv;
        this.honv = honv;
        this.tennv = tennv;
        this.luong = luong;
    }
    
    public Nhanvien(Nhanvien other) {
        this.manv = other.manv;
        this.honv = other.honv;
        this.tennv = other.tennv;
        this.luong = other.luong;
    }

    // ---- Getters & Setters ----
    public String getManv() { return manv; }
    public void setManv(String manv) { this.manv = manv; }

    public String getHonv() { return honv; }
    public void setHonv(String honv) { this.honv = honv; }

    public String getTennv() { return tennv; }
    public void setTennv(String tennv) { this.tennv = tennv; }

    public int getLuong() { return luong; }
    public void setLuong(int luong) { this.luong = luong; }

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
        System.out.printf("%-15s %-20s %-15s %-15s%n",
        "Ma nhan vien", "Ho nhan vien", "Ten nhan vien", "Luong");
        System.out.println("-------------------------------------------------------------");
        System.out.printf("%-15s %-20s %-15s %-15d%n", manv, honv, tennv, luong);
    }

    @Override
    public String toString() {
        return manv + "," + honv + "," + tennv + "," + luong;
    }
}
