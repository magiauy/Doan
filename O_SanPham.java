import java.io.*;
import java.lang.Object;
import java.util.Scanner;
public class O_SanPham{
    protected int MaSP;
    protected String TenSP;
    protected int SoLuong;
    protected int DonGia;
    protected String DonVi;
    protected int MaLoai;
    public O_SanPham(){

    }
    public O_SanPham(int MaSP, String TenSP,int SoLuong,int DonGia,String DonVi,int MaLoai){
        this.MaSP=MaSP;
        this.TenSP=TenSP;
        this.SoLuong=SoLuong;
        this.DonGia=DonGia;
        this.DonVi=DonVi;
        this.MaLoai=MaLoai;
    }
    public O_SanPham(O_SanPham sp){
        MaSP=sp.MaSP;
        TenSP=sp.TenSP;
        SoLuong=sp.SoLuong;
        DonGia=sp.DonGia;
        DonVi=sp.DonVi;
        MaLoai=sp.MaLoai;

    }
    public void nhap(){
        Scanner Scanner = new Scanner(System.in);
        System.out.print("Nhap MaSP: ");
        MaSP = Scanner.nextInt();
        Scanner.nextLine();
        System.out.print("Nhap TenSP: ");
        TenSP= Scanner.nextLine();
        System.out.print("Nhap Soluong: ");
        SoLuong = Scanner.nextInt();
        Scanner.nextLine();
        System.out.print("Nhap Don Gia: ");
        DonGia=Scanner.nextInt();
        Scanner.nextLine();
        System.out.print("Nhap Don Vi(Cai,cay,chai): ");
        DonVi=Scanner.nextLine();
        System.out.print("Nhap ma loai: ");
        MaLoai=Scanner.nextInt();
    Scanner.close();
    }
    public void xuat(){
        System.out.format("%-8d %-20s %-8d %-8d %-8s %-8d\n",
        MaSP, TenSP, SoLuong, DonGia, DonVi, MaLoai);
    }
    public int getMaSP(){
        return MaSP;
    }
    public String getTenSP(){
        return TenSP;
    }
    public int getSoluong(){
        return SoLuong;
    }
    public int getDonGia(){
        return DonGia;
    }
    public String getDonVi(){
        return DonVi;
    }
    public int getMaLoai(){
        return MaLoai;
    }
    public void setMaSP(int MaSP){
        this.MaSP=MaSP;
    }
    public void setTenSP(String TenSP){
        this.TenSP=TenSP;
    }
    public void setSoLuong(int SoLuong){
        this.SoLuong=SoLuong;
    }
    public void setDonGia(int DonGia){
        this.DonGia=DonGia;
    }
    public void setDonVi(String DonVi){
        this.DonVi=DonVi;
    }
    public void setMaLoai(int MaLoai){
        this.MaLoai=MaLoai;
    }
    public void GhiFile(String filename) throws IOException {
        try (DataOutputStream dos = new DataOutputStream(new FileOutputStream(filename, true))) {
            dos.writeInt(1);
            dos.writeInt(MaSP);
            dos.writeUTF(TenSP);
            dos.writeInt(SoLuong);
            dos.writeInt(DonGia);
            dos.writeUTF(DonVi);
            dos.writeInt(MaLoai);
        }
    }


}
