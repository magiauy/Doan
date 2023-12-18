import java.util.Scanner;
public class QL_Sanpham {
    private DS_Sanpham dssp = new DS_Sanpham(0);
    Scanner scanner = new Scanner(System.in);
    public void menu(){
        dssp.DocFileJava("../src/Sanpham.txt");
        int choice;

        do {
            System.out.println("===== Menu =====");
            System.out.println("1. Thêm sản phẩm");
            System.out.println("2. Xuất danh sách sản phẩm");
            System.out.println("3. Xóa sản phẩm");
            System.out.println("4. Sửa thông tin sản phẩm");
            System.out.println("5. Tìm kiếm sản phẩm");
            System.out.println("6. Thống kê sản phẩm");
            System.out.println("0. Thoát");
            System.out.print("Nhập lựa chọn của bạn: ");
            if (scanner.hasNextInt()) {
                choice = scanner.nextInt();
                scanner.nextLine();
            

            switch (choice) {
                case 1:
                    dssp.them();
                    break;
                case 2:
                    dssp.xuat();
                    break;
                case 3:
                    dssp.xoa();
                    break;
                case 4:
                    dssp.sua();
                    break;
                case 5:
                    dssp.find();
                    break;
                case 6:
                    dssp.thongke();
                    break;
                default:
                    System.out.println("Lựa chọn không hợp lệ. Vui lòng nhập lại.");
                    break;
            }
        }else{
            System.out.println("Nhap khong hop le. Vui long nhap lai.");
            scanner.next();
            choice=-1;
        }
        } while (choice != 0);

    }
}
