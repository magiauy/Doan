import java.io.*;
import java.util.Map;
import java.util.Scanner;
import java.util.zip.DataFormatException;
public class O_ChiTietPhieuNhap {
    private String MaPN;
    private int MaSP;
    private String TenSP;
    private int SoLuong;
    private double DonGia;
    private DS_Sanpham dssp = new DS_Sanpham(0);
    Scanner scanner = new Scanner(System.in);


    public O_ChiTietPhieuNhap(){

    }
    public O_ChiTietPhieuNhap(String MaPN,int MaSP,String TenSP,int SoLuong,double DonGia){
        this.MaPN=MaPN;
        this.MaSP=MaSP;
        this.TenSP=TenSP;
        this.SoLuong=SoLuong;
        this.DonGia=DonGia;
    }
    public void setMaPN(String MaPN){
        this.MaPN=MaPN;
    }
    public void setMaSP(int MaSP){
        this.MaSP=MaSP;
    }
    public void setTenSP(String TenSP){
        this.TenSP=TenSP;
    }
    public void SoLuong(int SoLuong){
        this.SoLuong=SoLuong;
    }
    public void DonGia(double DonGia){
        this.DonGia=DonGia;
    }
    public String getMaPN(){
        return MaPN;
    }
    public int getMaSP(){
        return MaSP;
    }
    public String getTenSP(){
        return TenSP;
    }
    public int getSoLuong(){
        return SoLuong;
    }
    public double getDonGia(){
        return DonGia;
    }
    public void nhap(String id){
        dssp.DocFileJava("../src/Sanpham.txt");
        dssp.xuat();
        MaPN=id;
        System.out.println("Nhập chi tiết phiếu có mã: "+MaPN);
        System.out.print("Nhập mã sản phẩm: ");
        MaSP=scanner.nextInt();
        System.out.print("Nhập số lượng: ");
        SoLuong=scanner.nextInt();
        scanner.nextLine();
        DonGia=(dssp.Truyengiasanpham(MaSP)*0.5);
        TenSP = dssp.getTenSP(MaSP);
    }
    public void xuat(){
        double ThanhTien;
        dssp.DocFileJava("../src/Sanpham.txt");
        ThanhTien=DonGia*SoLuong;
        System.out.format("%-8s %-8d %-20s %-8d %-8.0f %-8.0f\n",MaPN,MaSP,TenSP,SoLuong,DonGia,ThanhTien);
    }
    public void GhiFile(String filename)throws IOException{
        try(DataOutputStream dos = new DataOutputStream(new FileOutputStream(filename,true))){
            dos.writeUTF(MaPN);
            dos.writeInt(MaSP);
            dos.writeUTF(TenSP);
            dos.writeInt(SoLuong);
            dos.writeDouble(DonGia);
        }
    }
}
