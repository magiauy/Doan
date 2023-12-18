import java.util.Scanner;

public class App {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int choice;

        do {
            System.out.println("======== Menu ========");
            System.out.println("1. Quản lý sản phẩm");
            System.out.println("2. Quản lý hóa đơn");
            System.out.println("3. Quản lý khuyến mãi");
            System.out.println("4. Quản lý nhà cung cấp");
            System.out.println("5. Quản lý nhân viên");
            System.out.println("6. Quản lý phiếu nhập");
            System.out.println("7. Thoát chương  trình");
            System.out.print("Nhập lựa chọn của bạn: ");
            choice = scanner.nextInt();
            scanner.nextLine();
            switch (choice) {
                case 1:
                    QL_Sanpham sp = new QL_Sanpham();
                    sp.menu();
                    //Waitting 90%
                    break;
                case 2:
                    QL_Hoadon hd = new QL_Hoadon();
                    hd.menu();
                    //Waitting 80%
                    break;
                case 3:
                    QL_CTKM ctkm = new QL_CTKM();
                    ctkm.menu();
                    //Done , maybe
                    break;
                case 4:
                    QL_NCC ncc = new QL_NCC();
                    ncc.menu();
                    //Done
                    break;
                case 5:
                    QL_NV nv = new QL_NV();
                    nv.menu();
                    //Done
                    break;
                case 6:
                    QL_Phienhap pn = new QL_Phienhap();
                    pn.menu();
                    //Waitting
                case 7:
                    break;
                default:
                    System.out.println("Lựa chọn không hợp lệ. Vui lòng chọn lại.");
            }

        } while (choice != 7);

        scanner.close();
    }
}
