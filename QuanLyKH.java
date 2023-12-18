import java.util.Scanner;

public class QuanLyKH {
	private DanhSachKH ds;
	Scanner sc = new Scanner(System.in);

	public void menu() {
		ds = new DanhSachKH();
		ds.DocFileJava("../src/KhachHang.txt");

		boolean flag = true;
		while (flag) {
			System.out.println("----------Menu----------");
			System.out.println("1.Them khach hang.");
			System.out.println("2.Xoa khach hang theo ma khach.");
			System.out.println("3.Chinh sua thong tin khach hang.");
			System.out.println("4.Tiem kiem khach hang.");
			System.out.println("5.Thong ke theo gioi tinh.");
			System.out.println("6.Xuat danh sach khach hang.");
			System.out.print("Chon thao tac: ");
			int chon = sc.nextInt();
			sc.nextLine();

			switch (chon) {
			case 1:
				ds.themkhachhang();
				System.out.println("Khach hang vua them: ");
				ds.xuatkhachhang();
				break;
			case 2:
				ds.xoakhachhang();
				ds.xuatkhachhang();
				break;
			case 3:
				ds.suathongtin();
				System.out.println("Danh sach sau khi sua: ");
				ds.xuatkhachhang();
				break;
			case 4:
				ds.timkiemkhachhang();
				break;
			case 5:
				ds.thongkekhachhang();
				break;
			case 6:
				ds.xuatkhachhang();
				break;
			default:
				System.out.println("-------Ket thuc chuong trinh------");
				ds.GhiFileJava("../src/Khachhang.txt");
				flag = false;
				break;
			}
		}

		// ds.themkhachhang(new KhachHang("001", "Le Thi Thuy", "Duong", "nu", "123456789", "5-vo van kiet-quan 3-tphcm"));
		// ds.themkhachhang(new KhachHang("002", "Ly Nhat", "Tam", "nu", "987654321", "6-pham van chi-quan 6-tphcm"));
		// ds.themkhachhang(new KhachHang("003", "Dao Chi", "Cuong", "nam", "246810120", "7-su van hanh-quan 10-tphcm"));
		// ds.themkhachhang(new KhachHang("004", "Nguyen Trung", "Dung", "nam", "135791134", "8-ly thuong kiet-quan 11-tphcm"));
		// ds.themkhachhang(new KhachHang("005", "Ly Nhat", "Hoa", "nu", "369101215", "9-truong chinh-quan tan binh-tphcm"));
		// ds.themkhachhang(new KhachHang("006", "Tran Quoc", "Vinh", "nam", "168456513", "10-an duong vuong-quan 5-tphcm"));
		// ds.themkhachhang(new KhachHang("007", "Nguyen Thi", "Anh", "nu", "987654321", "20-le loi-quan 1-tphcm"));
		// ds.themkhachhang(new KhachHang("008", "Le Van", "Duc", "nam", "123456789", "30-nguyen hue-quan 1-tphcm"));
		// ds.themkhachhang(new KhachHang("009", "Pham Thi", "Huong", "nu", "987612345", "40-ngo quyen-quan 3-tphcm"));
		// ds.themkhachhang(new KhachHang("010", "Tran Van", "Hung", "nam", "567812345", "50-tran hung dao-quan 10-tphcm"));
		// ds.themkhachhang(new KhachHang("011", "Le Thi", "Minh", "nu", "345678912", "60-nguyen van cu-quan binh thanh-tphcm"));
		// ds.themkhachhang(new KhachHang("012", "Nguyen Van", "Hai", "nam", "987612345", "70-le van sy-quan 3-tphcm"));
		// ds.themkhachhang(new KhachHang("013", "Tran Thi", "My", "nu", "567812345", "80-nguyen thai binh-quan 1-tphcm"));
		// ds.themkhachhang(new KhachHang("014", "Pham Van", "Dung", "nam", "345678912", "90-ly tu trong-quan 1-tphcm"));
		// ds.themkhachhang(new KhachHang("015", "Le Van", "Hanh", "nam", "987612345", "100-tran hung dao-quan 5-tphcm"));
		// ds.themkhachhang(new KhachHang("016", "Nguyen Thi", "Lan", "nu", "567812345", "110-nguyen dinh chieu-quan 3-tphcm"));
		// ds.themkhachhang(new KhachHang("017", "Tran Van", "Tuan", "nam", "345678912", "120-vo van tan-quan 3-tphcm"));
		// ds.themkhachhang(new KhachHang("018", "Nguyen Van", "Hoa", "nam", "987612345", "130-dien bien phu-quan 3-tphcm"));
		// ds.themkhachhang(new KhachHang("019", "Le Thi", "Thu", "nu", "567812345", "140-le loi-quan 1-tphcm"));
		// ds.themkhachhang(new KhachHang("020", "Tran Van", "Son", "nam", "345678912", "150-ly chinh thang-quan 3-tphcm"));
		// ds.GhiFileJava("../src/KhachHang.txt");
		
	}

}
