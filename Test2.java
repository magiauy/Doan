import java.util.Arrays;
import java.util.Scanner;
import java.io.*;
public class Test2 {
    public static void main(String[] args) {
            Scanner scanner = new Scanner(System.in);
        //     DScthd hd = new DScthd(0);
        //     int[] MaHD = new int[n];
        //     int j=0;
        //     String cancel;
        // while (true) {
        //      System.out.print("MaHD: ");
        //         MaHD[j]=scanner.nextInt();
        //         hd.nhap(MaHD[j]);
        //     j++;
        //     System.out.print("Tiep tuc them hoa don [y/n]: ");
        //     cancel = scanner.nextLine();
        //     if (!cancel.equalsIgnoreCase("y")) {
        //         break; // Thoát khỏi vòng lặp nếu người dùng không muốn tiếp tục
        //     }
        // }
           
        //     // hd.DocFileJava("../src/Chitiethoadon.txt");
        //     hd.GhiFileJava("../src/Chitiethoadon.txt");
        //     MaHD=hd.getMangHD();
        //     for(int i=0;i<n;i++){
        //         System.out.println(MaHD[i]);
        //         hd.xuat(MaHD[i]);

        //     }
        //     scanner.close();
        DS_HoaDon dshd=new DS_HoaDon(1);
        dshd.nhap();
        // dshd.setSoLuong();
        dshd.Ghifile(); // Ghi Chi tiết hoá đơn vào file
        dshd.GhiFileJava("../src/Hoadon.txt");//Ghi thông tin hoá đơn vào file
        // dshd.xuat();
        // dshd.docFile(); //Đọc Chi tiết hoá đơn từ file 
        // dshd.DocFileJava("../src/Hoadon.txt"); // Đọc thông tin hoá đơn tư file 
        // dshd.xuat();
        // DanhSachSP dssp=new DanhSachSP(0);
        // dssp.DocFileJava();
        // dssp.xuat();
        // DScthd ds = new DScthd(0);
        // ds.nhap(1);
        // ds.GhiFileJava("../src/Chitiethoadon.txt");
        // ds.DocFileJava("../src/Chitiethoadon.txt");
        // ds.xuat();
            //Tiếp tục với mua hàng trừ vào file sản phẩm 
            // có thể là dụng hàm set ngay tại lúc xuat hoa don
            scanner.close();
    }

       
    }    

