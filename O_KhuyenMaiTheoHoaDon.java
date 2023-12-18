import java.io.*;
import java.util.Scanner;
public class O_KhuyenMaiTheoHoaDon extends O_KhuyenMai implements Object{
    private int MucGia;
    Scanner input = new Scanner(System.in);

    public O_KhuyenMaiTheoHoaDon() {}
    public O_KhuyenMaiTheoHoaDon(String MaCT, String MaKM, int MucKM, int MucGia) {
        super(MaCT, MaKM, MucKM);
        this.MucGia = MucGia;
    }
    public O_KhuyenMaiTheoHoaDon(O_KhuyenMaiTheoHoaDon hd) {
        super((O_KhuyenMai)hd);
        MucGia = hd.MucGia;
    }
    public int getptkm(){
        return MucGia;
    }
    public void setptkm(int MucGia){
        this.MucGia=MucGia;
    }
    public int getMucGia() {
        return MucGia;
    }
    public void setMucGia(int MucGia) {
        this.MucGia = MucGia;
    }

    public void nhap() {
        super.nhap();
        System.out.print("Nhap Muc Gia:");
        MucGia = input.nextInt();
    }

    public void xuat() {
        System.out.format("%-8s %-8d% -8d%n",super.getMaKM(), super.getMucKM(), MucGia);
    }

    public void GhiFile(String filename) throws IOException {
        try (DataOutputStream dos = new DataOutputStream(new FileOutputStream(filename, true))) {
            dos.writeInt(2);
            dos.writeUTF(super.getMaCT());
            dos.writeUTF(super.getMaKM());
            dos.writeInt(super.getMucKM());
            dos.writeInt(MucGia);
        }
    }
}
