import java.util.Scanner;
import java.io.*;
import java.lang.Object;
public class O_PhieuNhap{
    private String MaPN;
    private String MaNV;
    private String MaNCC;
    private String NgayLap;
    private int Tongtien;

    public O_PhieuNhap(){

    }
    public O_PhieuNhap(String MaPN,String MaNV,String MaNCC,String NgayLap,int Tongtien){
        this.MaPN=MaPN;
        this.MaNV=MaNV;
        this.MaNCC=MaNCC;
        this.NgayLap=NgayLap;
        this.Tongtien=Tongtien;
    }
    public void setMaPN(String MaPN){
        this.MaPN=MaPN;
    }
    public void setMaNV(String MaNV){
        this.MaNV=MaNV;
    }
    public void setMaNCC(String MaNCC){
        this.MaNCC=MaNCC;
    }
    public void setNgayLap(String NgayLap){
        this.NgayLap=NgayLap;
    }
    public String getMaPN(){
        return MaPN;
    }
    public String getMaNV(){
        return MaNV;
    }
    public String getMaNCC(){
        return MaNCC;
    }
    public String getNgayLap(){
        return NgayLap;
    }
    public void nhap() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Nhập mã phiếu nhập: ");
        MaPN=scanner.nextLine();
        System.out.print("Nhập mã nhân viên: ");
        MaNV=scanner.nextLine();
        System.out.print("Nhập mã nhà cung cấp: ");
        MaNCC=scanner.nextLine();
        System.out.print("Ngày lập phiếu nhập: ");
        NgayLap=scanner.nextLine();
        //Tongtien
    }
    public void xuat(){
        System.out.println("================================================");
        System.out.format("MaPN:%-8s MaNV:%-8s MaNCC:%-8s\n",MaPN,MaNV,MaNCC );
        System.out.format("Tongtien:%-8d Ngay nhap:%-8s\n",Tongtien,NgayLap);    }
    public void GhiFile(String filename)throws IOException{
        try(DataOutputStream dos = new DataOutputStream(new FileOutputStream(filename,true))){
            dos.writeUTF(MaPN);
            dos.writeUTF(MaNV);
            dos.writeUTF(MaNCC);
            dos.writeUTF(NgayLap);
            dos.writeInt(Tongtien);
        }
    }
}
