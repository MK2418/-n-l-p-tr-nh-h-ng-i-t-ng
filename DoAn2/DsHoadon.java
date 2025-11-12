import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.Arrays;
import java.util.Scanner;

public class DsHoadon{
	static int n;
	static Hoadon[] ds;
	static Scanner sc = new Scanner(System.in);

	public void docFile(String filename) throws Exception {
		try (BufferedReader br = new BufferedReader(new FileReader(filename))) {
			n = Integer.parseInt(br.readLine());
			ds = new Hoadon[n];
			for (int i = 0; i < n; i++) {
				String line = br.readLine();
				if (line == null || line.trim().isEmpty())
					break;

				String[] parts = line.split(",");

				String mahd = parts[0];
				String makh = parts[1];
				String manv = parts[2];
				double tongtien = Double.parseDouble(parts[3]);
				String ngay = parts.length > 4 ? parts[4] : "";

				Khachhang kh = new Khachhang();
				kh.setMakh(makh);
				Nhanvien nv = new Nhanvien();
				nv.setManv(manv);

				Hoadon hd = new Hoadon();
				hd.setMahd(mahd);
				hd.setMaKh(kh);
				hd.setMaNv(nv);
				hd.setTongtien(tongtien);

				if (!ngay.isEmpty()) {
					hd.setNgayxuathd(java.time.LocalDate.parse(ngay));
				}

				ds[i] = hd;
			}
		}
		System.out.println("Doc du lieu tu file thanh cong!");
	}

	public void ghiFile(String filename) throws Exception {
		try (BufferedWriter bw = new BufferedWriter(new FileWriter(filename))) {
			bw.write(n + "");
			bw.newLine();
			for (int i = 0; i < n; i++) {
				if (ds[i] != null) {
					String ngay = ds[i].getNgayxuathd() != null ? ds[i].getNgayxuathd().toString() : "";
					bw.write(ds[i].getMahd() + ","
							+ ds[i].getMaKh().getMakh() + ","
							+ ds[i].getMaNv().getManv() + ","
							+ ds[i].getTongtien() + ","
							+ ngay);
					bw.newLine();
				}
			}
		}
		System.out.println("Ghi du lieu vao file thanh cong!");
	}

	public void xuat() {
		for (int i = 0; i < n; i++) {
			System.out.println("------------------------");
			System.out.println("Thong tin hoa don thu " + (i + 1) + ": ");
			ds[i].xuat();
		}
	}

	public void them(Hoadon hdMoi) {
	    ds = Arrays.copyOf(ds, n + 1);
	    ds[n] = hdMoi;
	    n++;
	    System.out.println("Đã thêm hóa đơn mới: " + hdMoi.getMahd());
	}

	public void xoa(String mahd) {
	    for (int i = 0; i < n; i++) {
	        if (ds[i].getMahd().equalsIgnoreCase(mahd)) {
	            for (int j = i; j < n - 1; j++) {
	                ds[j] = ds[j + 1];
	            }
	            ds = Arrays.copyOf(ds, n - 1);
	            n--;
	            System.out.println("Đã xóa hóa đơn: " + mahd);
	            return;
	        }
	    }
	    System.out.println("Không tìm thấy hóa đơn: " + mahd);
	}

	public void sua(String mahd, Hoadon hdMoi) {
	    for (int i = 0; i < n; i++) {
	        if (ds[i].getMahd().equalsIgnoreCase(mahd)) {
	            ds[i] = hdMoi; 
	            System.out.println("Đã sửa hóa đơn: " + mahd);
	            return;
	        }
	    }
	    System.out.println("Không tìm thấy hóa đơn: " + mahd);
	}

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
		System.out.println("                 THONG KÊ HOA DON THEO THANG                ");
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
					System.out.println("  " + thang + "   |     " + soLuong + "      |   " + tongTien);
					coDuLieu = true;
				}
			}

			if (!coDuLieu) {
				System.out.println("Khong co hoa don nao trong nam " + nam + ".");
			}
		}

		System.out.println("\n============================================================");
		System.out.println("                 THONG KÊ HOA DON THEO QUY                  ");
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
					System.out.println("  " + quy + "   |     " + soLuong + "      |   " + tongTien);
					coDuLieu = true;
				}
			}

			if (!coDuLieu) {
				System.out.println("Khong co hoa don nao trong nam " + nam + ".");
			}
		}

		System.out.println("\n============================================================");
		System.out.println("                 THONG KÊ HOA DON THEO NAM                  ");
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
				System.out.println("Nam " + nam + " | So hoa don: " + soLuong + " | Tong doanh thu: " + tongTien);
			}
		}

		System.out.println("\n=== THONG KÊ THEO MA KH ===");
		for (int i = 0; i < n; i++) {
			String maKH = ds[i].getMaKh().getMakh();
			int soLuong = 0;
			double tongTien = 0;

			boolean daDem = false;
			for (int j = 0; j < i; j++) {
				if (ds[j].getMaKh().getMakh().equals(maKH)) {
					daDem = true;
					break;
				}
			}
			if (daDem)
				continue;

			for (int j = 0; j < n; j++) {
				if (ds[j].getMaKh().getMakh().equals(maKH)) {
					soLuong++;
					tongTien += ds[j].getTongtien();
				}
			}

			System.out.println("Ma KH: " + maKH +
					" | So hoa don: " + soLuong +
					" | Tong doanh thu: " + tongTien);
		}
	}
}