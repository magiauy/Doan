import java.util.Scanner;
import java.util.Arrays;
import java.io.*;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class DS_HoaDon implements DanhSach{
  private int n;
  private HoaDon[] hd;
  private DS_Chitiethoadon cthd  = new DS_Chitiethoadon(0);
  Scanner scanner = new Scanner(System.in);

  public DS_HoaDon() {

  }

  public DS_HoaDon(int n) {
    this.n = n;
    hd = new HoaDon[n];
  }
  

  public void nhap() {
    for (int i = 0; i < n; i++) {
      hd[i] = new HoaDon();
      hd[i].nhaphoadon();
      cthd.nhap(hd[i].getMaHoaDon());
      cthd.apmakm(hd[i].getMaKhuyenMai(),hd[i].getMaHoaDon());

    }
  }

  public void xuat() {
    for (int i = 0; i < n; i++) {
      hd[i].xuathoadon();
      cthd.xuat(hd[i].getMaHoaDon());
    }
  }

  public void them() {
    hd = Arrays.copyOf(hd, hd.length + 1);
    hd[n] = new HoaDon();
    hd[n].nhaphoadon();
    cthd.nhap(hd[n].getMaHoaDon());
    cthd.apmakm(hd[n].getMaKhuyenMai(),hd[n].getMaHoaDon());
    n++;
    Ghifile();
    GhiFileJava("../src/Hoadon.txt");
  }

  public void xoahoadon() {
    String mahd;
    System.out.print("Xoa hoa don so: ");
    mahd = scanner.nextLine();
    for (int i = 0; i < n; i++) {
      if (hd[i].getMaHoaDon().equals(mahd)) {
            System.out.println("Da xoa hoa don: "+hd[i].getMaHoaDon());
        for (int j = i; j < n - 1; j++) {
          hd[j] = hd[j + 1];
        }
        hd=Arrays.copyOf(hd, hd.length-1);
        n--;
        break;
        
      }
    }
    cthd.xoaMaHD(mahd);
    Ghifile();
    GhiFileJava("../src/Hoadon.txt");

  }

  public void xoahoadon(String mahd) {
    for (int i = 0; i < n; i++) {
      if (hd[i].getMaHoaDon().equals(mahd)) {
        for (int j = i; j < n - 1; j++) {
          hd[j] = hd[j + 1];
        }
        hd=Arrays.copyOf(hd, hd.length-1);
        n--;
        break;
      }
    }
        cthd.xoaMaHD(mahd);

  }

  public void suahoadon() {
    boolean check = false;
    System.out.print("Sua hoa don so: ");
    String mahd = scanner.nextLine();
    for (int i = 0; i < n; i++) {
      if (hd[i].getMaHoaDon().equals(mahd)) {
        System.out.println("Chon thay doi: ");

      }
    }
  }

  public void timhoadon(String mahd) {
    System.out.print("Tim hoa don so: ");
    for (int i = 0; i < n; i++) {
      if (hd[i].getMaHoaDon().equals(mahd)) {
        hd[i].xuathoadon();
        cthd.xuat(hd[i].getMaHoaDon());
      }
    }
  }

  public void timhoadon() {
    String mahd;
    System.out.print("Tim hoa don so: ");
    mahd = scanner.nextLine();
    for (int i = 0; i < n; i++) {
      if (hd[i].getMaHoaDon().equals(mahd)) {
        hd[i].xuathoadon();
        cthd.xuat(hd[i].getMaHoaDon());
      }
    }
  }

  public void timtheonamlap(int nam1, int nam2) {
    DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd");

    System.out.println("Hoa don tu " + nam1 + " den " + nam2 + ":");
    for (int i = 0; i < n; i++) {
      LocalDate namlap = LocalDate.parse(hd[i].getNgayLap(), dtf);
      int nam = namlap.getYear();
      if ((nam >= nam1 && nam <= nam2) || (nam >= nam2 && nam <= nam1)) {
        hd[i].xuathoadon();
        cthd.xuat(hd[i].getMaHoaDon());
      }
    }
  }

  public void timtheothanglap(String thang1, String thang2) {
    DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd");

    System.out.println("Hoa don tu thang " + thang1 + " den thang " + thang2 + ":");
    for (int i = 0; i < n; i++) {
      LocalDate thanglap = LocalDate.parse(hd[i].getNgayLap(), dtf);
      int thang = thanglap.getMonthValue();
      if ((thang >= Integer.parseInt(thang1) && thang <= Integer.parseInt(thang2))
          || (thang >= Integer.parseInt(thang2) && thang <= Integer.parseInt(thang1))) {
        hd[i].xuathoadon();
        cthd.xuat(hd[i].getMaHoaDon());
      }
    }
  }

  public void timtheongaylap(String ngay1, String ngay2) {
    DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd");

    System.out.println("Hoa don tu ngay " + ngay1 + " den ngay " + ngay2 + ":");
    for (int i = 0; i < n; i++) {
      LocalDate ngaylap = LocalDate.parse(hd[i].getNgayLap(), dtf);
      int ngay = ngaylap.getDayOfMonth();
      if ((ngay >= Integer.parseInt(ngay1) && ngay <= Integer.parseInt(ngay2))
          || (ngay >= Integer.parseInt(ngay2) && ngay <= Integer.parseInt(ngay1))) {
        hd[i].xuathoadon();
        cthd.xuat(hd[i].getMaHoaDon());
      }
    }
  }

  public void timkiemhoadon() {
    System.out.println("Chon phuong thuc tim kiem:");
    System.out.println("1. Tim theo ma hoa don");
    System.out.println("2. Tim theo nam lap");
    System.out.println("3. Tim theo thang lap");
    System.out.println("4. Tim theo ngay lap");
    System.out.println("Chon:");
    int choice = scanner.nextInt();
    scanner.nextLine();
    switch (choice) {
      case 1:
        timhoadon();
        break;
      case 2:
        System.out.println("Tim hoa don tu nam: ");
        int nam1 = scanner.nextInt();
        System.out.println("Den nam: ");
        int nam2 = scanner.nextInt();
        timtheonamlap(nam1, nam2);
        break;
      case 3:
        System.out.println("Tim hoa don tu thang: ");
        String thang1 = scanner.nextLine();
        System.out.println("Den thang: ");
        String thang2 = scanner.nextLine();
        timtheothanglap(thang1, thang2);
        break;
      case 4:
        System.out.println("Tim hoa don tu ngay: ");
        String ngay1 = scanner.nextLine();
        System.out.println("Den ngay: ");
        String ngay2 = scanner.nextLine();
        timtheongaylap(ngay1, ngay2);
        break;
      default:
        System.out.println("Vui long chon phuong thuc tim kiem hop le!");
        timkiemhoadon();
        break;
    }
  }

  public void thongketientheonam(int year1, int year2) {
    int[] count = new int[year2 - year1 + 1];
    DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd");

    for (int i = 0; i < n; i++) {
      LocalDate ngayLap = LocalDate.parse(hd[i].getNgayLap(), dtf);
      int year = ngayLap.getYear();
      if (year >= year1 && year <= year2) {
        count[year - year1] += hd[i].getTongTien();
      }
    }

    for (int i = 0; i < count.length; i++) {
      if (count[i] > 0) {
        System.out.println("Danh sach thu duoc " + count[i] + " trong nam " + (year1 + i));
      }
    }
  }

  public void Ghifile() {
  cthd.GhiFileJava("../src/Chitiethoadon.txt");
  }

  public void Docfile() {
  cthd.DocFileJava("../src/Chitiethoadon.txt");
  }
  public void GhiFileJava(String filename) {
    try (DataOutputStream dos = new DataOutputStream(new FileOutputStream(filename))) {
        dos.writeInt(n);
        for (int i = 0; i < n; i++) {
            hd[i].GhiFile(filename);
        }
    } catch (IOException e) {
        e.printStackTrace();
    }
}
  public void DocFileJava(String filename) {
    int i = 0;
    try (DataInputStream dis = new DataInputStream(new FileInputStream(filename))) {
        n = dis.readInt();
        hd = new HoaDon[n];
        while (i < n) {
            String maHD = dis.readUTF();
            String maNV = dis.readUTF();
            String maKH = dis.readUTF();
            String NgayLap = dis.readUTF();
            String maKM = dis.readUTF();
            double Tongtien = dis.readDouble();
            hd[i] = new HoaDon(maHD, maNV, maKH, NgayLap, Tongtien, maKM);
            i++;
        }
    } catch (IOException e) {
        e.printStackTrace();
    }
}
public void setSoLuong(){
  DS_Chitiethoadon cthd = new DS_Chitiethoadon(0);
  cthd.DocFileJava("../src/Chitiethoadon.txt");
  cthd.setSoLuong();
}


}
