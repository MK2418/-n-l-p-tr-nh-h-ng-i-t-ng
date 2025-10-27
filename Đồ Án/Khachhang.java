
import java.util.Scanner;

public class Khachhang {
	private String makh;
	private String ho;
	private String ten;
	private String diachi;
	private int sdt;

	public Khachhang() {
	}

	public Khachhang(String makh, String ho, String ten, String diachi, int sdt) {
		this.makh = makh;
		this.ho = ho;
		this.ten = ten;
		this.diachi = diachi;
		this.sdt = sdt;
	}

	public void Nhap() {
		Scanner sc = new Scanner(System.in);
		System.out.print("Nhập mã khách hàng: ");
		makh = sc.next();
		System.out.print("Nhập họ khách hàng: ");
		ho = sc.next();
		System.out.print("Nhập tên khách hàng: ");
		ten = sc.next();
		System.out.print("Nhập địa chỉ khách hàng: ");
		diachi = sc.next();
		System.out.print("Nhập số điện thoại khách hàng: ");
		sdt = sc.nextInt();
	}

	public void Xuat() {
		System.out.println(
				"Khách hàng có mã " + makh + " tên " + ho + " " + ten + " địa chỉ " + diachi + " số điện thoại " + sdt);
	}

	public String getMaKh() {
		return makh;
	}

	public void setMaKh(String makh) {
		this.makh = makh;
	}

	public String getHo() {
		return ho;
	}

	public void setHo(String ho) {
		this.ho = ho;
	}

	public String getTen() {
		return ten;
	}

	public void setTen(String ten) {
		this.ten = ten;
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

	public void setSdt(Integer sdt) {
		this.sdt = sdt;
	}
}