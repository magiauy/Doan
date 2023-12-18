import java.util.Scanner;

public class QL_Hoadon {
    Scanner scanner = new Scanner(System.in);
        public void menu(){
            Scanner scanner = new Scanner(System.in);
            DS_HoaDon dshd = new DS_HoaDon(); 
            int choice;
    
            do {
            dshd.DocFileJava("../src/Hoadon.txt");
            dshd.Docfile();
                System.out.println("===== Menu =====");
                System.out.println("1. Thêm hóa đơn");
                System.out.println("2. Xóa hóa đơn");
                System.out.println("3. Sửa hóa đơn");
                System.out.println("4. Tìm kiếm hóa đơn");
                System.out.println("5. Thống kê");
                System.out.println("6. Xuất danh sách hóa đơn");
                System.out.println("7. Thoát");
    
                System.out.print("Nhập lựa chọn của bạn: ");
                choice = scanner.nextInt();
    
                switch (choice) {
                    case 1:
                        dshd.them();
                        break;
                    case 2:
                        dshd.xoahoadon();
                        break;
                    case 3:
                        dshd.suahoadon();
                        break;
                    case 4:
                        dshd.timkiemhoadon();
                        break;
                    case 5:
                        // dshd.thongke();
                        break;
                    case 6:
                        dshd.xuat();
                        break;
                    case 7:
                        System.out.println("Chương trình kết thúc.");
                        dshd.Ghifile();
                        dshd.GhiFileJava("../src/Hoadon.txt");
                        break;
                    default:
                        System.out.println("Lựa chọn không hợp lệ. Vui lòng nhập lại.");
                        break;
                }
            } while (choice != 7);
    
    }
}
