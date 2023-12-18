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
                          sua();
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
        Scanner scanner = new Scanner(System.in);
        System.out.print("Nhap stt can chinh sua: ");
        int stt = scanner.nextInt();
        for (int i = 0; i<n; i++) {
            if (i==(stt-1) ) {
                System.out.print("Nhap so luong moi: ");
                int tempsl = scanner.nextInt();
                ctpn[i].updateSL(ctpn[i].getMaSP(),ctpn[i].getSoLuong(),tempsl);
                ctpn[i].setSoLuong(tempsl);

                }
            }
    }

 

    public void xoa() {
		boolean daTimThay = false;
		System.out.print("Nhap stt can xoa");
		Scanner Scanner = new Scanner(System.in);
		int x=Scanner.nextInt();
		for (int i=0;i<n ;i++ ) {
			if (i==(x-1) ) {
                ctpn[i].xoaSL(ctpn[i].getMaSP(),ctpn[i].getSoLuong());
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
