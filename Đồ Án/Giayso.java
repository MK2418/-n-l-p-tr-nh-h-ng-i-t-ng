import java.util.Scanner;

public class Giayso extends Dodunghoctap {
    private String KhoGiay;
    private int DoDay;

    public Giayso(String MSP, String Ten, int SL, int DonGia, String DVTinh, int DoDay, String KhoGiay) {
        super(MSP, Ten, SL, DonGia, DVTinh);
        this.KhoGiay = KhoGiay;
        this.DoDay = DoDay;
    }

    public Giayso() {
    }

    @Override
    public void Nhap() {
        Scanner sc = new Scanner(System.in);
        System.out.print("Nhap Ma San Pham: ");
        MSP = sc.nextLine();
        System.out.print("Nhap Ten San Pham: ");
        Ten = sc.nextLine();
        System.out.print("Nhap So Luong: ");
        SL = sc.nextInt();
        System.out.print("Nhap Don Gia: ");
        DonGia = sc.nextInt();
        sc.nextLine();
        System.out.print("Nhap Don Vi Tinh: ");
        DVTinh = sc.nextLine();
        System.out.print("Nhap Do Day: ");
        DoDay = sc.nextInt();
        sc.nextLine();
        System.out.print("Nhap Kho Giay (A4, A5,...): ");
        KhoGiay = sc.nextLine();
    }

    @Override
    public void Xuat() {
        System.out.println("===== GIẤY SỔ =====");
        System.out.println("MSP: " + MSP);
        System.out.println("Ten: " + Ten);
        System.out.println("So luong: " + SL);
        System.out.println("Đon gia: " + DonGia);
        System.out.println("Đon vi tinh: " + DVTinh);
        System.out.println("Đo day: " + DoDay);
        System.out.println("Kho giay: " + KhoGiay);
    }
}
