import java.util.Arrays;
import java.util.Scanner;

import javax.print.attribute.standard.DocumentName;

import java.io.*;

public class DS_Chitiethoadon implements DanhSach{
  private int n;
  private double tongtien;
  private String MaHD;
  private ChiTietHoaDon[] cthd;
  private DS_Sanpham dssp = new DS_Sanpham(0);
  private DS_CTKM dsctkm = new DS_CTKM();
  private DS_KM dskm = new DS_KM();

  Scanner scanner = new Scanner(System.in);

  public DS_Chitiethoadon() {

  }

  public DS_Chitiethoadon(int n) {
    this.n = n;
    cthd = new ChiTietHoaDon[n];
  }

  public void getTongtien(String mahd) {
    tongtien =0;
    for (int i = 0; i < n; i++) {
      if (cthd[i].getmaHD().equals(mahd)) {
        tongtien += cthd[i].getthanhtien();
      }
    }
    System.out.println("Tổng hoá đơn: "+tongtien);
    }

  public void them() {
    cthd = Arrays.copyOf(cthd, cthd.length + 1);
    cthd[n] = new ChiTietHoaDon();
    cthd[n].nhapchitiethoadon(MaHD);
    n++;
  }

  public void them(ChiTietHoaDon ct) {
    cthd = Arrays.copyOf(cthd, cthd.length + 1);
    cthd[n].setmaHD(MaHD) ;
    cthd[n] = ct;
    n++;
  }

  public void nhap(String ma) {
    String cancel;
    int choice;
    this.MaHD = ma;
    dssp.DocFileJava("../src/Sanpham.txt");
    System.out.println("Hoa don so:" + MaHD);
        dssp.xuat();
      System.out.println("Them san pham");
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

  public void xuat(String HD) {
    System.out.format("%-8s %-20s %-8s %-8s %-8s%n", "MASP", "TenSP", "Soluong", "Dongia", "Thanhtien");
    for (int i = 0; i < n; i++) {
      if (cthd[i].getmaHD().equals(HD)) {
        cthd[i].xuatchitiethoadon();
      }
    }
    getTongtien(HD);
  }

  public void xuat() {
    System.out.format("%-8s %-20s %-8s %-8s %-8s%n", "MASP", "TenSP", "Soluong", "Dongia", "Thanhtien");
    for (int i = 0; i < n; i++) {
      cthd[i].xuatchitiethoadon();
    }
  }
  public void xoa(){
    System.out.print("Nhap thu tu can xoa: ");
    int c = scanner.nextInt();
    for(int i=0;i<n;i++){
      if ((c-1)==i) {
        cthd[i].updateSL(cthd[i].getmaSP(),cthd[i].getSL());
        for (int j = i; j < n - 1; j++) {
          cthd[j] = cthd[j + 1];
        }
      }
    }
  }
  public void xoaMaHD(String id){
    for(int i=0;i<n;i++){
      if (cthd[i].getmaHD().equals(id)) {
        for (int j = i; j < n - 1; j++) {
          cthd[j] = cthd[j + 1];
        }
    cthd=Arrays.copyOf(cthd, cthd.length-1);
    n--;
      }

    }

  }
  public void xoaMaSP() {
    boolean daTimThay = false;
    System.out.println("Chon ma san pham can xoa: ");
    int tempMaSP = scanner.nextInt();
    for (int i = 0; i < n; i++) {
      if (cthd[i].getmaSP() == tempMaSP) {
        for (int j = i; j < n - 1; j++) {
          cthd[j] = cthd[j + 1];
        }
        n--;
        daTimThay = true;
        break;
      }
    }
    if (!daTimThay) {
      System.out.println("Khong tim thay san pham voi MaSP: " + tempMaSP);
    }
  }

  public void suachitiethoadon() {
    int tempMaSP;
    boolean daTimThay = false;
    System.out.println("Chon ma san pham can sua: ");
    tempMaSP = scanner.nextInt();
    for (int i = 0; i < n; i++) {
      if (cthd[i].getmaSP() == tempMaSP) {
        System.out.println("Chon so luong can sua: ");
        int tempSL = scanner.nextInt();
        cthd[i].setSL(tempSL);
        daTimThay = true;
      }
    }
    if (!daTimThay) {
      System.out.println("Khong tim thay san pham voi MaSP: " + tempMaSP);
    }

  }

  public void GhiFileJava(String filename) {
    try {
      DataOutputStream dos = new DataOutputStream(new FileOutputStream(filename));
      dos.writeInt(n);
      try {
        for (int i = 0; i < n; i++) {
          cthd[i].GhiFile(filename);
        }
      } catch (NullPointerException npe) {

      }
      dos.close();
    } catch (IOException e) {
      e.printStackTrace();
    }
    System.out.println("Ghi file thanh cong");
  }

  public void DocFileJava(String filename) {
    int i = 0;
    try {
      DataInputStream dis = new DataInputStream(new FileInputStream(filename));
      n = dis.readInt();
      cthd = new ChiTietHoaDon[n];
      try {
        while (i < n) {
          String maHD = dis.readUTF();
          int maSP = dis.readInt();
          String TenSP = dis.readUTF();
          int SL = dis.readInt();
          double Dongia = dis.readDouble();
          double Thanhtien = dis.readDouble();
          cthd[i] = new ChiTietHoaDon(maHD, maSP, TenSP, SL, Dongia, Thanhtien);
          i++;
        }
      } catch (EOFException e) {

      } finally {
        dis.close();
      }
    } catch (IOException e) {
      e.printStackTrace();
    }
  }
  public void apmakm(String id,String mahd){
    dsctkm.DocFileJava("../src/ChuongTrinhKhuyenMai.txt");
    dsctkm.docFile();
    dskm.DocFileJava("../src/KhuyenMai.txt");
    if (dsctkm.getMaKM(id)!=null) {
      for(int i=0;i<n;i++){
        if(cthd[i].getmaHD().equals(mahd)){
        cthd[i].setdongia(dskm.apdungkm((cthd[i]).getdongia(),cthd[i].getmaSP(),id));
      }
      }
    }
  }
  public void setSoLuong(){
    DS_Sanpham sp = new DS_Sanpham();
  sp.DocFileJava("../src/Sanpham.txt");		
    for(int i=0;i<n;i++){
        sp.setSoLuonghd(cthd[i].getmaSP(),cthd[i].getSL());
    }
    sp.GhiFileJava("../src/Sanpham.txt");
}
}