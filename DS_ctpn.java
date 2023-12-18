import java.io.*;
import java.util.Arrays;
import java.util.Scanner;

import javax.swing.text.MaskFormatter;

public class DS_ctpn implements DanhSach{
    private String MaPN;
    private int n;
    private O_ChiTietPhieuNhap[] ctpn;
    private DS_Sanpham dssp;
    Scanner scanner = new Scanner(System.in);

    public DS_ctpn(){

    }
    public DS_ctpn(int n){
        this.n=n;
        ctpn = new O_ChiTietPhieuNhap[n];
    }
    public void them(){
        ctpn=Arrays.copyOf(ctpn,ctpn.length+1);
        ctpn[n]=new O_ChiTietPhieuNhap();
        ctpn[n].nhap(MaPN);
        n++;
    }
    public void nhap(String id){
        String cancel;
        int choice;
        dssp = new DS_Sanpham(0);
        dssp.DocFileJava("../src/Sanpham.txt");
        this.MaPN=id;
            System.out.println("Them san pham");
            dssp.xuat();
            them();
            do{
                System.out.println("\n----- Menu -----");
                    System.out.println("1. Them san pham");
                    System.out.println("2. Sua so luong");
                    System.out.println("3. Xoa san pham");
                    System.out.println("4. Thoat");
        
                    // Nhap lua chon tu nguoi dung
                    System.out.print("Nhap lua chon cua ban (1-4): ");
                    choice = scanner.nextInt();
                    switch (choice) {
                      case 1:
                          them();
                          break;
                      case 2:
                          // sua();
                          break;
                      case 3:
                          xoa();
                          break;
                      case 4:
                          System.out.println("Thoat chuong trinh");
                          break;
                      default:
                          System.out.println("Lua chon khong hop le. Vui long nhap lai.");
                  }
        
              }while(choice != 4);
}

    public void xuat(String id){
        System.out.format("%-8s %-8s %-20s %-8s %-8s %-8s\n","MaPN","MaSP","TenSP","SoLuong","DonGia","ThanhTien");
        for(int i=0;i<n;i++){
            if (ctpn[i].getMaPN().equals(id)) {
                ctpn[i].xuat();
            }
        }
    }
    public void GhiFileJava(String filename){
        try{
                DataOutputStream dos = new DataOutputStream(new FileOutputStream(filename));
            dos.writeInt(n);
            try{
                for(int i=0;i<n;i++){
                    ctpn[i].GhiFile(filename);
                }
            }catch(NullPointerException npe){

            }
            dos.close();
        }catch(IOException e){
            e.printStackTrace();
        }
    }
    public void DocFileJava(String filename){
        int i=0;
        try{
            DataInputStream dis = new DataInputStream(new FileInputStream(filename));
            n=dis.readInt();
            ctpn=new O_ChiTietPhieuNhap[n];
            try{
                while (i<n) {
                    String MaPN = dis.readUTF();
                    int MaSP = dis.readInt();
                    String TenSP = dis.readUTF();
                    int SoLuong = dis.readInt();
                    double DonGia = dis.readDouble();
                    ctpn[i]=new O_ChiTietPhieuNhap(MaPN,MaSP,TenSP,SoLuong,DonGia);
                    i++;
                }
            }catch(EOFException e){

            }finally{
                dis.close();
            }
        }catch(IOException e){
            e.printStackTrace();
        }
    }

    public void sua() {
        boolean daTimThay = false;
        Scanner Scanner = new Scanner(System.in);
        System.out.println("Điền mã phiếu nhập cần sửa");
        int temp = Scanner.nextInt();
        for (int i = 0; i<n; i++) {
            if (ctpn[i].getMaPN().equals(temp) ) {
                System.out.println("Chọn thuộc tính cần sửa");
                System.out.println("1: Sửa mã phiếu nhập");
                System.out.println("2: Sửa mã sản phẩm");
                System.out.println("3: Sửa tên sản phẩm");
                System.out.println("4: Sửa số lượng");
                System.out.println("5: Sửa đơn giá");
                System.out.println("Vui lòng nhập từ 1-5: ");
                int c = Scanner.nextInt();
                switch (c) {
                    case 1:
                        System.out.println("Nhập mã phiếu nhập mới: ");
                        String tempMaPN = Scanner.nextLine();
                        ctpn[i].setMaPN(tempMaPN);
                        break;
                    case 2: 
                        System.out.println("Nhập mã sản phẩm mới: "); 
                        int tempMaSP = Scanner.nextInt();   
                        ctpn[i].setMaSP(tempMaSP);
                        break;
                    case 3: 
                        Scanner scanner3 = new Scanner(System.in);
                        System.out.println("Nhập tên sản phẩm mới: "); 
                        String tempTenSP = Scanner.nextLine();   
                        ctpn[i].setTenSP(tempTenSP);
                        break; 
                    case 4:
                        System.out.println("Nhập ngày lập mới: ");     
                        int tempSoLuong = Scanner.nextInt();
                        ctpn[i].SoLuong(tempSoLuong);  
                    case 5: 
                        System.out.println("Nhập đơn giá mới: ");
                        int tempDonGia = Scanner.nextInt();
                        ctpn[i].DonGia(tempDonGia);
                    default:
                        break;
                }
                daTimThay = true;
            }
        }
        if (!daTimThay) {
			System.out.println("Không tìm thấy mã phiếu nhập: ");
		}
    }

    public void timkiem() {
        Scanner Scanner = new Scanner(System.in);
        System.out.println("Chọn phương thức tìm kiếm");
        System.out.println("1: Tìm kiếm theo mã phiếu nhập");
        System.out.println("2: Tìm kiếm theo mã sản phẩm");
        System.out.println("3: Tìm kiếm theo tên sản phẩm");
        System.out.println("4: tìm kiếm theo số lượng");
        System.out.println("5: Tìm kiếm theo đơn giá");
        int c = Scanner.nextInt();
        switch (c) {
            case 1:
                System.out.println("Nhập mã phiếu nhập cần tìm: ");
                int tempMaPN = Scanner.nextInt();
                for (int i = 0; i < n; i++) {
                    if (ctpn[i].getMaPN().equals(tempMaPN) ) {
                        ctpn[i].xuat();
                    }
                }
                break;
            case 2:
                System.out.println("Nhập mã sản phẩm cần tìm: ");
                int tempMaSP = Scanner.nextInt();
                for (int i = 0; i < n ; i++) {
                    if (ctpn[i].getMaSP() == tempMaSP) {
                        ctpn[i].xuat();
                    }
                }
                break;
            case 3:
                System.out.println("Nhập tên sản phẩm cần tìm: ");
                String tempTenSP = Scanner.nextLine();
                for (int i = 0; i < n ; i++) {
                    if (ctpn[i].getTenSP().equals(tempTenSP)) {
                        ctpn[i].xuat();
                    }
                }
                break;
            case 4:
                System.out.println("Nhập số lượng cần tìm: ");
                int tempSoLuong = Scanner.nextInt();
                for (int i = 0; i < n; i++) {
                    if (ctpn[i].getSoLuong() == tempSoLuong) {
                        ctpn[i].xuat();
                    }
                }
            case 5:
                System.out.println("Nhập đơn giá cần tìm: ");
                int tempDonGia = Scanner.nextInt();
                for (int i = 0; i < n; i++) {
                    if (ctpn[i].getDonGia() == tempDonGia) {
                        ctpn[i].xuat();
                    }
                }   
                break;        
            default:
                break;
        }
    }

    public void xoa() {
		boolean daTimThay = false;
		System.out.print("Nhập mã phiếu nhập cần xóa: ");
		Scanner Scanner = new Scanner(System.in);
		int x=Scanner.nextInt();
		for (int i=0;i<n ;i++ ) {
			if (ctpn[i].getMaPN().equals(x) ) {
				for(int j=i;j<n-1;j++){
					ctpn[j]=ctpn[j+1];
				}
			n--;
			daTimThay = true;
			System.out.println("Chi tiết phiếu nhập đã được xóa ");
			break;
			}
		}
		if (!daTimThay) {
			System.out.println("Không tìm thấy mã phiếu nhập: "+x);
		}
    } 
}
