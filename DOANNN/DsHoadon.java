import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.time.LocalDate;
import java.util.Arrays;
import java.util.Scanner;

public class DsHoadon implements dieukien {
	static int n;
	static Hoadon[] ds;
	static Scanner sc = new Scanner(System.in);

	public void docFile(String filename) throws Exception {
		try (BufferedReader br = new BufferedReader(new FileReader(filename))) {
			n = Integer.parseInt(br.readLine());
			ds = new Hoadon[n];
			for (int i = 0; i < n; i++) {
				String line = br.readLine();
				if (line == null)
					break;
				String[] parts = line.split(",");
				ds[i] = new Hoadon(parts[0], parts[1], parts[2], LocalDate.parse(parts[3]));
			}
		}
	}

	public void ghiFile(String filename) throws Exception {
		try (BufferedWriter bw = new BufferedWriter(new FileWriter(filename))) {
			bw.write(String.valueOf(n));
			bw.newLine();
			for (int i = 0; i < n; i++) {
				if (ds[i] != null) {
					bw.write(ds[i].toFileString());
					bw.newLine();
				}
			}
		}
		System.out.println("Ghi du lieu vao file thanh cong!");
	}

	public void xuat() {
		System.out.println(
				"=================================================================================================================");
		System.out.printf("%-10s %-10s %-10s %15s %-15s\n",
				"MaHD", "MaKH", "MaNV", "NgayXuat", "TongTien");
		System.out.println(
				"=================================================================================================================");
		for (int i = 0; i < n; i++) {
			if (ds[i] != null) {
				ds[i].xuat();
				System.out.println();
			}
		}
		System.out.println(
				"=================================================================================================================");
		System.out.println("Tong so: " + n + " hoa don");
	}

	public void themCothamso(String mahd, String makh, String manv, LocalDate ngayxuathd, double tongtien) {
		ds = Arrays.copyOf(ds, n + 1);
		ds[n] = new Hoadon(mahd, makh, manv, tongtien, ngayxuathd);
		n++;
		System.out.println("Da them hoa don moi: " + mahd);
	}

	public void xoaCothamso(String mahd) {
		for (int i = 0; i < n; i++) {
			if (ds[i].getMahd().equalsIgnoreCase(mahd)) {
				for (int j = i; j < n - 1; j++) {
					ds[j] = ds[j + 1];
				}
				ds = Arrays.copyOf(ds, n - 1);
				n--;
				System.out.println("Da xoa hoa don: " + mahd);
				return;
			}
		}
		System.out.println("Khong tim thay hoa don: " + mahd);
	}

	public void suaCothamso(String mahd, String makh, String manv, LocalDate ngayxuathd, double tongtien) {
		for (int i = 0; i < n; i++) {
			if (ds[i].getMahd().equalsIgnoreCase(mahd)) {
				ds[i].setMaKh(makh);
				ds[i].setMaNv(manv);
				ds[i].setNgayxuathd(ngayxuathd);
				ds[i].setTongtien(tongtien);
				System.out.println("Da sua hoa don: " + mahd);
				return;
			}
		}
		System.out.println("Khong tim thay hoa don: " + mahd);
	}

	public void timkiemCothamso(String mahd) {
		for (int i = 0; i < n; i++) {
			if (ds[i].getMahd().equalsIgnoreCase(mahd)) {
				ds[i].xuat();
				return;
			}
		}
		System.out.println("Khong tim thay ma hoa don: " + mahd);
	}

	@Override
	public void them() {
		ds = Arrays.copyOf(ds, n + 1);
		ds[n] = new Hoadon();
		ds[n].nhap();
		n++;
		System.out.println("Da them hoa don moi thanh cong!");
	}

	@Override
	public void xoa() {
		System.out.println("Nhap ma hoa don muon xoa: ");
		String mahd = sc.nextLine();
		for (int i = 0; i < n; i++) {
			if (ds[i].getMahd().equals(mahd)) {
				for (int j = i; j < n - 1; j++) {
					ds[j] = ds[j + 1];
				}
				ds = Arrays.copyOf(ds, n - 1);
				n--;
				System.out.println("Da xoa " + mahd);
				return;
			}
		}
		System.out.println("Khong tim thay " + mahd);
	}

	@Override
	public void sua() {
		System.out.print("Nhap ma hoa don can sua: ");
		String mahd = sc.nextLine();
		for (int i = 0; i < n; i++) {
			if (ds[i].getMahd().equalsIgnoreCase(mahd)) {
				int k;
				do {
					System.out.println("---Sua thong tin hoa don---");
					System.out.println("1. Sua ma hoa don");
					System.out.println("2. Sua ma khach hang");
					System.out.println("3. Sua ma nhan vien");
					System.out.println("4. Sua tong tien");
					System.out.println("0. Thoat");
					System.out.print("Nhap lua chon: ");
					k = sc.nextInt();
					sc.nextLine();

					switch (k) {
						case 1:
							System.out.println("Vui long nhap ma hoa don moi: ");
							ds[i].setMahd(sc.nextLine());
							break;
						case 2:
							System.out.println("Vui long nhap ma khach hang moi: ");
							String kh = sc.nextLine();
							ds[i].setMaKh(kh);
							break;
						case 3:
							System.out.println("Vui long nhap ma nhan vien moi: ");
							String nv = sc.nextLine();
							ds[i].setMaNv(nv);
							break;
						case 4:
							System.out.println("Vui long nhap tong tien moi: ");
							ds[i].setTongtien(sc.nextDouble());
							sc.nextLine();
							break;
						case 0:
							System.out.println("Thoat sua thong tin.");
							break;
						default:
							System.out.println("Lua chon khong hop le!");
					}
				} while (k != 0);
				return;
			}
		}
		System.out.println("Khong tim thay ma hoa don nay!");
	}

	@Override
	public void timkiem() {
		System.out.println("Nhap ma hoa don de tim kiem: ");
		String mahd = sc.nextLine();
		for (int i = 0; i < n; i++) {
			if (ds[i].getMahd().equalsIgnoreCase(mahd)) {
				ds[i].xuat();
				return;
			}
		}
		System.out.print("Khong tim thay ma hoa don");
	}

	public void thongkeDaydu() {
		System.out.println("============================================================");
		System.out.println("                 THONG KE HOA DON THEO THANG                ");
		System.out.println("============================================================");

		for (int nam = 2020; nam <= 2025; nam++) {
			boolean coDuLieu = false;
			System.out.println("\nNam " + nam + ":");
			System.out.println("------------------------------------------------------------");
			System.out.println("Thang | So hoa don | Tong doanh thu");
			System.out.println("------------------------------------------------------------");

			for (int thang = 1; thang <= 12; thang++) {
				int soLuong = 0;
				double tongTien = 0;

				for (int i = 0; i < n; i++) {
					if (ds[i].getNgayxuathd() != null &&
							ds[i].getNgayxuathd().getMonthValue() == thang &&
							ds[i].getNgayxuathd().getYear() == nam) {
						soLuong++;
						tongTien += ds[i].getTongtien();
					}
				}

				if (soLuong > 0) {
					System.out.printf("| %-8d | %-14d | %,-19.2f |%n", nam, soLuong, tongTien);
					coDuLieu = true;
				}
			}

			if (!coDuLieu) {
				System.out.println("Khong co hoa don nao trong nam " + nam + ".");
			}
		}

		System.out.println("\n============================================================");
		System.out.println("                 THONG KE HOA DON THEO QUY                  ");
		System.out.println("============================================================");

		for (int nam = 2020; nam <= 2025; nam++) {
			boolean coDuLieu = false;
			System.out.println("\nNam " + nam + ":");
			System.out.println("------------------------------------------------------------");
			System.out.println("Quy  | So hoa don | Tong doanh thu");
			System.out.println("------------------------------------------------------------");

			for (int quy = 1; quy <= 4; quy++) {
				int soLuong = 0;
				double tongTien = 0;

				for (int i = 0; i < n; i++) {
					if (ds[i].getNgayxuathd() != null && ds[i].getNgayxuathd().getYear() == nam) {
						int month = ds[i].getNgayxuathd().getMonthValue();
						int quyHienTai = (month - 1) / 3 + 1;
						if (quyHienTai == quy) {
							soLuong++;
							tongTien += ds[i].getTongtien();
						}
					}
				}

				if (soLuong > 0) {
					System.out.printf("  %-5s |     %-6d |   %,.2f%n", quy, soLuong, tongTien);
					coDuLieu = true;
				}
			}

			if (!coDuLieu) {
				System.out.println("Khong co hoa don nao trong nam " + nam + ".");
			}
		}

		System.out.println("\n============================================================");
		System.out.println("                 THONG KE HOA DON THEO NAM                  ");
		System.out.println("============================================================");

		for (int nam = 2020; nam <= 2025; nam++) {
			int soLuong = 0;
			double tongTien = 0;

			for (int i = 0; i < n; i++) {
				if (ds[i].getNgayxuathd() != null && ds[i].getNgayxuathd().getYear() == nam) {
					soLuong++;
					tongTien += ds[i].getTongtien();
				}
			}

			if (soLuong > 0) {
				System.out.printf("| %-8d | %-14d | %,-19.2f |%n", nam, soLuong, tongTien);
			}
		}

		System.out.println("\n=== THONG KE THEO MA KHACH HANG ===");
		for (int i = 0; i < n; i++) {
			String maKH = ds[i].getMaKh();
			int soLuong = 0;
			double tongTien = 0;

			boolean daDem = false;
			for (int j = 0; j < i; j++) {
				if (ds[j].getMaKh().equals(maKH)) {
					daDem = true;
					break;
				}
			}
			if (daDem)
				continue;

			for (int j = 0; j < n; j++) {
				if (ds[j].getMaKh().equals(maKH)) {
					soLuong++;
					tongTien += ds[j].getTongtien();
				}
			}

			System.out.printf("Ma KH: %s | So hoa don: %d | Tong doanh thu: %.2f%n",
					maKH, soLuong, tongTien);
		}
	}

	public double TKQuy1(int nam) {
		double tien = 0.0;
		for (int i = 0; i < n; i++) {
			if (ds[i].getNgayxuathd().getYear() == nam) {
				int thang = ds[i].getNgayxuathd().getMonthValue();
				if (thang >= 1 && thang <= 3) {
					tien = tien + ds[i].getTongtien();
				}
			}
		}
		return tien;
	}

	public double TKQuy2(int nam) {
		double tien = 0.0;
		for (int i = 0; i < n; i++) {
			if (ds[i].getNgayxuathd().getYear() == nam) {
				int thang = ds[i].getNgayxuathd().getMonthValue();
				if (thang >= 4 && thang <= 6) {
					tien = tien + ds[i].getTongtien();
				}
			}
		}
		return tien;
	}

	public double TKQuy3(int nam) {
		double tien = 0.0;
		for (int i = 0; i < n; i++) {
			if (ds[i].getNgayxuathd().getYear() == nam) {
				int thang = ds[i].getNgayxuathd().getMonthValue();
				if (thang >= 7 && thang <= 9) {
					tien = tien + ds[i].getTongtien();
				}
			}
		}
		return tien;
	}

	public double TKQuy4(int nam) {
		double tien = 0.0;
		for (int i = 0; i < n; i++) {
			if (ds[i].getNgayxuathd().getYear() == nam) {
				int thang = ds[i].getNgayxuathd().getMonthValue();
				if (thang >= 10 && thang <= 12) {
					tien = tien + ds[i].getTongtien();
				}
			}
		}
		return tien;
	}

	public double TKTheoNam(int nam) {
		double tong = 0.0;
		for (Hoadon hd : ds) {
			if (hd != null && hd.getNgayxuathd().getYear() == nam) {
				tong += hd.getTongtien();
			}
		}
		return tong;
	}

	public double TKKHtheonam(int nam, String makh) {

		double tongTien = 0;

		for (int i = 0; i < n; i++) {

			// Chỉ xét mã khách hàng yêu cầu
			if (!ds[i].getMaKh().equals(makh))
				continue;

			// Lấy năm
			int year = ds[i].getNgayxuathd().getYear();
			if (year != nam)
				continue;

			tongTien += ds[i].getTongtien();
		}

		return tongTien;
	}

	public Hoadon[] getDS() {
		return ds;
	}
}
