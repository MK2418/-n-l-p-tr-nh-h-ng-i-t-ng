import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
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
	            if (line == null || line.trim().isEmpty()) break;

	            // Giả sử file có cấu trúc: mahd, makh, manv, tongtien, ngayxuathd
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
	    System.out.println("Đọc dữ liệu từ file thành công!");
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
	    System.out.println("Ghi dữ liệu vào file thành công!");
	}

	public void xuat() {
		for (int i = 0; i < n; i ++) {
			System.out.println("------------------------");
			System.out.println("Thong tin hoa don thu"+(i+1) +": ");
			ds[i].xuat();
		}	
	}
	@Override 
	public void them() {
		ds = Arrays.copyOf(ds, n+1);
		ds[n] = new Hoadon();
		ds[n].nhap();
		n++;
		System.out.println("da them hoa don moi thanh cong!");
	}
	
	@Override 
	public void xoa() {
		System.out.println("nhap ma hoa don muon xoa");
		String mahd = sc.nextLine();
		for (int i = 0; i < n; i++) {
			if (ds[i].getMahd().equals(mahd)) {
				for (int j = i; j < n -1 ; j++) {
					ds[j] = ds[j +1];
				}
				ds = Arrays.copyOf(ds, n - 1 );
				n--;
				System.out.println("da xoa" +mahd);
				return;
			}
		}
		System.out.println("khong tim thay" +mahd);
	}
	
	@Override 
	public void timkiem() {
		System.out.println("nhập mã hóa đơn để tìm kiếm");
		String mahd = sc.nextLine();
		for (int i = 0; i <n; i++) {
			if (ds[i].getMahd().equalsIgnoreCase(mahd)){
				ds[i].xuat();
				return;
			}	
		}
		System.out.print("không tìm thấy mã hóa đơn");
	}
	
	@Override 
	public void sua() {
		System.out.print("nhập mã hóa đơn cần sửa");
		String mahd = sc.nextLine();
		for (int i = 0; i < n; i++) {
			if (ds[i].getMahd().equalsIgnoreCase(mahd)) {
				int k;
				do {
					System.out.println("---Sửa thông tin hóa đơn---");
					System.out.println("1.Sửa mã hóa đơn");
					System.out.println("2.Sửa mã khách hàng");
					System.out.println("2.Sửa mã khách hàng");
					System.out.println("3.Sửa mã nhân viên");
					System.out.println("4.Sửa tổng tiền");
					System.out.print("Nhập lựa chọn: ");
                    k = sc.nextInt();
                    
                switch (k){
                case 1:
                	System.out.println("Vui lòng nhập mã hóa đơn mới");
                	ds[i].setMahd(sc.nextLine());
                case 2:
                	System.out.println("Vui lòng nhập mã khách hàng mới");
                	String makh = sc.nextLine();
                	Khachhang kh = new Khachhang();
                	kh.setMakh(makh);
                	ds[i].setMaKh(kh);
                case 3:
                	System.out.println("Vui lòng nhập mã nhân viên mới");
                	String manv = sc.nextLine();
                	Nhanvien nv = new Nhanvien();
                	nv.setManv(manv);
                	ds[i].setMaNv(nv);
                case 4:
                	System.out.println("Vui lòng nhập tổng tiền mới");
                	ds[i].setTongtien(sc.nextDouble());
                }
				}while (k !=0); 
				return;
			}
		}
		System.out.println("Không tìm thấy mã hóa đơn này!");
	}
	
	public void thongkeTheoThang() {
        System.out.println("--- Thống kê hóa đơn theo tháng ---");
        System.out.print("Nhập tháng (MM): ");
        int thang = sc.nextInt();
        System.out.print("Nhập năm (YYYY): ");
        int nam = sc.nextInt();
        sc.nextLine(); 

        int soLuongHoaDon = 0;
        double tongDoanhThu = 0.0;

        System.out.println("\nDanh sách hóa đơn trong tháng " + thang + " năm " + nam + ":");
        boolean timThay = false;

        for (int i = 0; i < n; i++) {
            if (ds[i].getNgayxuathd() != null) {
                if (ds[i].getNgayxuathd().getMonthValue() == thang && 
                    ds[i].getNgayxuathd().getYear() == nam) {
                    ds[i].xuat();
                    soLuongHoaDon++;
                    tongDoanhThu += ds[i].getTongtien();
                    timThay = true;
                }
            }
        }

        if (!timThay) {
             System.out.println("Không có hóa đơn nào trong tháng " + thang + " năm " + nam + ".");
        } else {
             System.out.println("----------------------------------------");
             System.out.println("Tổng kết thống kê tháng " + thang + " năm " + nam + ":");
             System.out.println("Tổng số lượng hóa đơn: " + soLuongHoaDon);
             System.out.println("Tổng doanh thu: " + tongDoanhThu);
             System.out.println("----------------------------------------");
        }
    }
	
	public void thongkeTheoKhachHang() {
	    System.out.print("Nhập mã khách hàng cần thống kê: ");
	    String makh = sc.nextLine();
	    int soLuong = 0;
	    double tongTien = 0;

	    System.out.println("\n--- Danh sách hóa đơn của khách hàng " + makh + " ---");
	    for (int i = 0; i < n; i++) {
	        if (ds[i].getMaKh().getMakh().equalsIgnoreCase(makh)) {
	            ds[i].xuat();
	            soLuong++;
	            tongTien += ds[i].getTongtien();
	        }
	    }

	    if (soLuong == 0) {
	        System.out.println("❌ Không có hóa đơn nào của khách hàng này.");
	    } else {
	        System.out.println("--------------------------------------");
	        System.out.println("Tổng số hóa đơn: " + soLuong);
	        System.out.println("Tổng doanh thu: " + tongTien);
	    }
	}
}
