import java.util.Scanner;

public class Butviet extends Dodunghoctap {
    public String loaibut;
    public int kichcongoi;

    // Hàm có tham số
    public Butviet(String maSP, String tenSP, int soLuong, int donGia,
            String donViTinh, String maLoai, String maSX,
            String loaibut, int kichcongoi) {
        super(maSP, tenSP, soLuong, donGia, donViTinh, maLoai, maSX);
        this.loaibut = loaibut;
        this.kichcongoi = kichcongoi;
    }

    // Hàm không tham số
    public Butviet() {
        super();
        loaibut = "";
        kichcongoi = 0;
    }

    // Hàm thiết lập sao chép
    public Butviet(Butviet other) {
        super(other.maSP, other.tenSP, other.soLuong, other.donGia,
                other.donViTinh, other.maLoai, other.maSX);
        this.loaibut = other.loaibut;
        this.kichcongoi = other.kichcongoi;
    }

    // Phương thức nhập
    @Override
    public void nhap() {
        super.nhap(); // Gọi nhập từ class cha
        Scanner sc = new Scanner(System.in);
        System.out.print("Loai but: ");
        this.loaibut = sc.nextLine();
        System.out.print("Kich co ngoi: ");
        this.kichcongoi = Integer.parseInt(sc.nextLine());
    }

    // Phương thức xuất
    @Override
    public void xuat() {
        super.xuat(); // Gọi xuất từ class cha
        System.out.printf(" %-12s %10s\n", loaibut, kichcongoi);
        ;
    }

    // Ghi vào file
    @Override
    public String toFileString() {
        return String.format("%s,%s,%d,%d,%s,%s,%s,%s,%d",
                maSP, tenSP, soLuong, donGia, donViTinh, maLoai, maSX, loaibut, kichcongoi);
    }

    // Getter và Setter
    public String getLoaibut() {
        return loaibut;
    }

    public void setLoaibut(String loaibut) {
        this.loaibut = loaibut;
    }

    public int getKichcongoi() {
        return kichcongoi;
    }

    public void setKichcongoi(int kichcongoi) {
        this.kichcongoi = kichcongoi;
    }

    // Phương thức toString
    @Override
    public String toString() {
        return "Butviet{" +
                "maSP='" + maSP + '\'' +
                ", tenSP='" + tenSP + '\'' +
                ", soLuong=" + soLuong +
                ", donGia=" + donGia +
                ", donViTinh='" + donViTinh + '\'' +
                ", maLoai='" + maLoai + '\'' +
                ", maSX='" + maSX + '\'' +
                ", loaibut='" + loaibut + '\'' +
                ", kichcongoi=" + kichcongoi +
                '}';
    }
}
