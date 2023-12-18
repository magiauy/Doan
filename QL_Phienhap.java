import java.util.Scanner;;
public class QL_Phienhap {
    public void menu(){
        Scanner scanner = new Scanner(System.in);
        DS_PhieuNhap dspn = new DS_PhieuNhap(0); 
        dspn.DocFileJava("../src/Phieunhap.txt");
        dspn.Docfile();
        int choice;

        do {
            System.out.println("===== Menu =====");
            System.out.println("1. Thêm phiếu nhập");
            System.out.println("2. Xuất danh sách phiếu nhập");
            System.out.println("3. Xóa phiếu nhập");
            System.out.println("4. Sửa thông tin phiếu nhập");
            System.out.println("5. Tìm kiếm phiếu nhập");
            System.out.println("6. Thoát");
            System.out.print("Nhập lựa chọn của bạn: ");
            if (scanner.hasNextInt()) {
            choice = scanner.nextInt();
            scanner.nextLine();                
            switch (choice) {
                case 1:
                    dspn.them();
                    dspn.xuat();

                    break;
                case 2:
                    dspn.xuat();
                    break;
                case 3:
                    dspn.xoa();
                    break;
                case 4:
                    dspn.sua();
                    break;
                case 5:
                    dspn.timkiem();
                    break;
                case 6:
                    System.out.println("Chương trình kết thúc.");
                    dspn.GhiFile();
                    dspn.GhiFileJava("../src/Phieunhap.txt");
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
        } while (choice != 6);
    }
    
}
