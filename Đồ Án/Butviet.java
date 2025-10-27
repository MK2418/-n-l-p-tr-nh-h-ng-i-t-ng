import java.util.Scanner;

public class Butviet extends Dodunghoctap {
    private int KichCoNgoi;
    private String LoaiBut;

    public Butviet(String MSP, String Ten, int SL, int DonGia, String DVTinh, int KichCoNgoi, String LoaiBut) {
        super(MSP, Ten, SL, DonGia, DVTinh);
        this.KichCoNgoi = KichCoNgoi;
        this.LoaiBut = LoaiBut;
    }

    public Butviet() {
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
        sc.nextLine(); // bỏ dòng
        System.out.print("Nhap Don Vi Tinh: ");
        DVTinh = sc.nextLine();
        System.out.print("Nhap Kich Co Ngoi: ");
        KichCoNgoi = sc.nextInt();
        sc.nextLine();
    }

    @Override
    public void Xuat() {
        System.out.println("MSP: " + MSP);
        System.out.println("Ten: " + Ten);
        System.out.println("So luong " + SL);
        System.out.println("Đon gia:" + DonGia);
        System.out.println("Đon vi tinh" + DVTinh);
        System.out.println("Kich co ngoi " + KichCoNgoi);
        System.out.println("Loai but: " + LoaiBut);
    }
}
