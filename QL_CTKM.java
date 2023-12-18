import java.util.Scanner;

public class QL_CTKM {
    private DS_CTKM ds;
    Scanner input = new Scanner(System.in);


    public void menu() {
        QL_Khuyenmai km = new QL_Khuyenmai();
        ds = new DS_CTKM();
        ds.them(new O_ChuongTrinhKhuyenMai("CT01", "Big Sale", "2023/12/01", "2023/12/31"));
        ds.them(new O_ChuongTrinhKhuyenMai("CT02", "Winter Discount", "2023/12/02", "2023/12/30"));
        ds.them(new O_ChuongTrinhKhuyenMai("CT03", "Holiday Special", "2023/12/05", "2023/12/25"));
        ds.them(new O_ChuongTrinhKhuyenMai("CT04", "End of Year Sale", "2023/12/10", "2023/12/31"));
        ds.them(new O_ChuongTrinhKhuyenMai("CT05", "Festive Offer", "2023/12/15", "2023/12/31"));
        ds.them(new O_ChuongTrinhKhuyenMai("CT06", "One Day Deal", "2023/12/01", "2023/12/01"));
        ds.GhiFileJava("../src/ChuongTrinhKhuyenMai.txt");
        ds.docFile();

        ds.DocFileJava("../src/ChuongTrinhKhuyenMai.txt");

        boolean flag = true;
        while (flag) {
            System.out.println("----------------Menu----------------");
            System.out.println("1: Them Chuong Trinh Khuyen Mai");
            System.out.println("2: Xoa Chuong Trinh Khuyen Mai theo Ma Chuong Trinh");
            System.out.println("3: Sua thong tin Chuong Trinh Khuyen Mai");
            System.out.println("4: Tim kiem Chuong Trinh Khuyen Mai");
            System.out.println("5: Xuat danh sach Chuong Trinh Khuyen Mai");
            System.out.println("6: Quan ly khuyen mai");
            System.out.println("7: Ket thuc chuong trinh.");
            System.out.print("Chon thao tac: ");
            int choice;
            choice = input.nextInt();
            input.nextLine();

            switch (choice) {
                case 1:
                    ds.them();
                    System.out.println("----------------Thong tin Chuong Trinh Khuyen Mai----------------");
                    ds.xuat();
                    break;
                case 2:
                    ds.xoa();
                    System.out.println("----------------Thong tin Chuong Trinh Khuyen Mai----------------");
                    ds.xuat();
                    break;
                case 3:
                    ds.sua();
                    System.out.println("----------------Thong tin Chuong Trinh Khuyen Mai----------------");
                    ds.xuat();
                    break;
                case 4:
                    ds.timKiem();
                    break;
                case 5:
                    System.out.println("----------------Thong tin Chuong Trinh Khuyen Mai----------------");
                    ds.xuat();
                    break;
                case 6:
                    km.menu();
                default:
                    System.out.println("--------------Ket thuc chuong trinh!---------------");
                    flag = false;
                    break;
            }
        }

        

    }
}
