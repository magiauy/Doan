import java.util.Scanner;
import java.io.*;

public class ChiTietHoaDon {
    private String maHD;
    private int maSP;
    private String TenSP;
    private int SL;
    private double dongia;
    private double thanhtien;
    private DS_Sanpham dssp = new DS_Sanpham(0);

    public ChiTietHoaDon() {
    }

    public ChiTietHoaDon(String maHD, int maSP, String TenSP, int SL, double dongia, double thanhtien) {
        this.maHD = maHD;
        this.maSP = maSP;
        this.TenSP = TenSP;
        this.SL = SL;
        this.dongia = dongia;
        this.thanhtien = thanhtien;
    }

    public String getmaHD() {
        return maHD;
    }

    public int getmaSP() {
        return maSP;
    }

    public String getTenSP() {
        return TenSP;
    }

    public int getSL() {
        return SL;
    }

    public double getdongia() {
        return dongia;
    }

    public double getthanhtien() {
        return thanhtien;
    }

    public void setmaHD(String maHD) {
        this.maHD = maHD;
    }

    public void setmaSP(int maSP) {
        this.maSP = maSP;
    }

    public void setTenSP(String TenSP) {
        this.TenSP = TenSP;
    }

    public void setSL(int SL) {
        this.SL = SL;
    }

    public void setdongia(double dongia) {
        this.dongia = dongia;
    }

    public void setthanhtien(double thanhtien) {
        this.thanhtien = thanhtien;
    }

    public double ThanhTien(int SL, double dongia) {
        return SL * dongia;
    }

    Scanner sc = new Scanner(System.in);

    public void nhapchitiethoadon(String id) {
        dssp.DocFileJava("../src/Sanpham.txt");
        maHD = id;
        System.out.print("Ma san pham: ");
        maSP = sc.nextInt();
        TenSP = dssp.getTenSP(maSP);
        System.out.print("So luong: ");
        SL = sc.nextInt();
        dongia = dssp.Truyengiasanpham(maSP);
        dssp.setSoLuonghd(maSP,SL);
        dssp.GhiFileJava("../src/Sanpham.txt");
    }
    
    public void xuatchitiethoadon() {
        thanhtien = ThanhTien(SL, dongia);
        System.out.format("%-8d %-20s %-8d %-8.2f %-8.2f%n", maSP, TenSP, SL, dongia, thanhtien);

    }
    public void updateSL(int masp,int soluong){
        dssp.DocFileJava("../src/Sanpham.txt");
        dssp.setSoLuongpn(masp,soluong);
        dssp.GhiFileJava("../src/Sanpham.txt");
    }
    public void GhiFile(String filename) throws IOException {
        try (DataOutputStream dos = new DataOutputStream(new FileOutputStream(filename, true))) {
            dos.writeUTF(maHD);
            dos.writeInt(maSP);
            dos.writeUTF(TenSP);
            dos.writeInt(SL);
            dos.writeDouble(dongia);
            dos.writeDouble(thanhtien);
        }
    }

}