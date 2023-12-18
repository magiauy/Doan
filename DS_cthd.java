import java.util.Scanner;

import javax.print.attribute.standard.DocumentName;

import java.io.*;
import java.util.Arrays;
public class DS_cthd implements DanhSach{
    private int MaHD;
    private int n ;
    private int a =0;
    private O_Chitiethoadon[] cthd;
    Scanner scanner = new Scanner(System.in);
    public DS_cthd(){

    }
    public DS_cthd(int n){
        this.n=n;
        cthd = new O_Chitiethoadon[n];
    }

public int[] getMangHD(){
    int[] MangHD = new int[n];
    for(int i=0;i<n;i++){
        MangHD[i]=cthd[i].getMAHD();
    }
    return MangHD;
}
public int getTongtien(int hd) {
    int tongtien = 0;  // Initialize tongtien before the loop
    for (int i = 0; i < n; i++) {
        if (cthd[i].getMAHD() == hd) {
            tongtien = tongtien+(cthd[i].getDongia() * cthd[i].getSoluong());
        }
    }
    return tongtien;  // Directly return the computed tongtien value
}
public int getMaSp(int dh) {
    int tempMaSP = 0;
    for (int i = 0; i < n; i++) {
        if (cthd[i].getMAHD() == dh) {
            tempMaSP = cthd[i].getMASP();
            break;  // Break the loop once the matching MaHD is found
        }
    }
    return tempMaSP;  // Return tempMaSP outside the loop
}

    public void nhap(int ma){
        String cancel;
        this.MaHD=ma;
        System.out.println("Hoa don so:"+MaHD);
        while (true) {
            System.out.println("Them san pham");
            them();
            System.out.print("Tiep tuc them san pham [y/n]: ");
            cancel = scanner.nextLine();
            if (!cancel.equalsIgnoreCase("y")) {
                break; // Thoát khỏi vòng lặp nếu người dùng không muốn tiếp tục
            }
        }
}
    public void them(){
        cthd=Arrays.copyOf(cthd, cthd.length+1);
        cthd[n] = new O_Chitiethoadon();
        cthd[n].setMAHD(MaHD);
        cthd[n].nhap();
        n++;
        
    }
    public void xuat(int HD){
        System.out.format("%-8s %-20s %-8s %-8s %-8s%n", "MASP", "TenSP", "Soluong", "Dongia", "Thanhtien");
        for(int i=0;i<n;i++){
        if (cthd[i].getMAHD()==HD) {
            cthd[i].xuat();
        }
        }

    }
    public void xuat(){
        System.out.format("%-8s %-20s %-8s %-8s %-8s%n", "MASP", "TenSP", "Soluong", "Dongia", "Thanhtien");
        for(int i=0;i<n;i++){
                cthd[i].xuat(); 
            

        }

    }
    public void xoaMaSP(){
        int tempMaSP;
        boolean daTimThay=false;
        System.out.println("Chon MaSP can xoa");
        tempMaSP=scanner.nextInt();
        scanner.nextLine();
        for(int i=0;i<n;i++){
            if (tempMaSP==cthd[i].getMASP()) {
                for(int j=i;j<n-1;j++){
                    cthd[j]=cthd[j+1];
                }
            }cthd = Arrays.copyOf(cthd, cthd.length-1);
			n--;
			daTimThay=true;
			System.out.println("San pham da duoc xoa");
			break;
		}
		if (!daTimThay) {
			System.out.println("Khong tim thay san pham voi MaSP: "+tempMaSP);
		}
        }
        public void GhiFileJava(String filename) {
            try {
                
                DataOutputStream dos = new DataOutputStream(new FileOutputStream(filename));
                dos.writeInt(n);
                try {
                    for(int i = 0; i < n; i++) {
                        cthd[i].GhiFile(filename);
                    }
                }catch(NullPointerException npe) {
                    
                }
                dos.close();
            }catch(IOException e) {
                e.printStackTrace();
            }
            System.out.println("Ghi file thanh cong");
        }
        public void DocFileJava(String filename) {
            int i = 0;
            try {
                DataInputStream dis = new DataInputStream(new FileInputStream(filename));
                n = dis.readInt();
                cthd = new O_Chitiethoadon[n];
                try {
                    while (i < n) {  // Thêm điều kiện kiểm tra để tránh vượt quá độ dài của mảng
                        int MaHD = dis.readInt();
                        int MaSP = dis.readInt();
                        String TenSP = dis.readUTF();
                        int Soluong = dis.readInt();
                        int Dongia = dis.readInt();
                        int Thanhtien = dis.readInt();
                        cthd[i] = new O_Chitiethoadon(MaHD, MaSP, TenSP, Soluong, Dongia, Thanhtien);
                        i++;
                    }
                } catch (EOFException e) {
                    // End of file reached
                } finally {
                    a = i;
                    dis.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    public void setSoLuong(){
        DS_Sanpham sp = new DS_Sanpham();
		sp.DocFileJava("../src/Sanpham.txt");		
        for(int i=0;i<n;i++){
            sp.setSoLuong(cthd[i].getMASP(),cthd[i].getSL());
        }
        sp.GhiFileJava("../src/Sanpham.txt");
    }
    // format 
    // Hoa don: MaHD , MaNv,MaKh,Date
    // Chitiethoadon: MaHD , MaSp,TenSp,Soluong,Dongia,Thanhtien
}
