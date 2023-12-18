import java.util.Scanner;
public class QL_Khuyenmai {
    public void menu(){
        Scanner scanner = new Scanner(System.in);
        int choice;
        DS_KM km = new DS_KM();
        km.DocFileJava("../src/KhuyenMai.txt");
        do {
            System.out.println("\n----- Menu Quan Ly Khuyen Mai -----");
            System.out.println("1. Them Khuyen Mai");
            System.out.println("2. Sua Thong Tin Khuyen Mai");
            System.out.println("3. Xoa Khuyen Mai");
            System.out.println("4. Tim Kiem Khuyen Mai");
            System.out.println("5. Thong Ke");
            System.out.println("0. Thoat");

            System.out.print("Nhap lua chon cua ban (0-5): ");
            if (scanner.hasNextInt()) {
            choice = scanner.nextInt();  
            scanner.nextLine();   
            switch (choice) {
                case 1:
                    km.them();
                    break;
                case 2:
                    km.sua();
                    break;
                case 3:
                    km.xoa();
                    break;
                case 4:
                    km.timKiem();
                    break;
                case 5:
                    km.thongKe();
                    break;
                case 0:
                    System.out.println("Ket thuc chuong trinh.");
                    break;
                default:
                    System.out.println("Lua chon khong hop le. Vui long nhap lai.");
            }
        }else{
            System.out.println("Nhap khong hop le. Vui long nhap lai.");
            scanner.next();
            choice=-1;
        }
        } while (choice != 0);
    }
}
