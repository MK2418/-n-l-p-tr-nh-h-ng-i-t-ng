import java.util.Scanner;

public class Khachhang {
	private String makh;
	private String hokh;
	private String tenkh;
	private String diachi;
	private int sdt;

	public Khachhang() {
	}

	public Khachhang(String makh, String hokh, String tenkh, String diachi, int sdt) {
		this.makh = makh;
		this.hokh = hokh;
		this.tenkh = tenkh;
		this.diachi = diachi;
		this.sdt = sdt;
	}

	public Khachhang(Khachhang other) {
		this.makh = other.makh;
		this.hokh = other.hokh;
		this.tenkh = other.tenkh;
		this.diachi = other.diachi;
		this.sdt = other.sdt;
	}

	public void nhap() {
		@SuppressWarnings("resource")
		Scanner sc = new Scanner(System.in);
		System.out.print("Nhap ma khach hang: ");
		makh = sc.nextLine();
		System.out.print("Nhap ho khach hang: ");
		hokh = sc.nextLine();
		System.out.print("Nhap ten khach hang: ");
		tenkh = sc.nextLine();
		System.out.print("Nhap dia chi khach hang: ");
		diachi = sc.nextLine();
		System.out.print("Nhap so dien thoai khach hang: ");
		sdt = sc.nextInt();
	}

	public void xuat() {
		System.out.println("----------------------------------------------------------------------------------");
		System.out.printf("%-10s %-15s %-15s %-25s %-15s%n",
				makh, hokh, tenkh, diachi, sdt);
	}

	public String toFileString() {
		return String.format("%s,%s,%s,%s,%s",
				makh, hokh, tenkh, diachi, sdt);
	}

	public String getHo() {
		return hokh;
	}

	public void setHo(String hokh) {
		this.hokh = hokh;
	}

	public String getTen() {
		return tenkh;
	}

	public void setTen(String tenkh) {
		this.tenkh = tenkh;
	}

	public String getDiaChi() {
		return diachi;
	}

	public void setDiaChi(String diachi) {
		this.diachi = diachi;
	}

	public Integer getSdt() {
		return sdt;
	}

	public void setSdt(int sdt) {
		this.sdt = sdt;
	}

	public String getMakh() {
		return makh;
	}

	public void setMakh(String makh) {
		this.makh = makh;
	}
}