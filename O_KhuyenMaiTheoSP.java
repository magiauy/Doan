import java.io.*;
import java.util.Scanner;
public class O_KhuyenMaiTheoSP extends O_KhuyenMai implements Object{
    private int MaSP;
    Scanner input = new Scanner(System.in);

    public O_KhuyenMaiTheoSP() {}
    public O_KhuyenMaiTheoSP(String MaCT, String MaKM, int MucKM, int MaSP) {
        super(MaCT, MaKM, MucKM);
        this.MaSP = MaSP;
    }
    public O_KhuyenMaiTheoSP(O_KhuyenMaiTheoSP sp) {
        super((O_KhuyenMai)sp);
        MaSP = sp.MaSP;
    }
    public int getptkm(){
        return MaSP;
    }
    public void setptkm(int MaSP){
        this.MaSP=MaSP;
    }
    public int getMaSP() {
        return MaSP;
    }
    public void setMaSP(int MaSP) {
        this.MaSP = MaSP;
    }

    public void nhap() {
        super.nhap();
        System.out.print("Nhap Ma San Pham:");
        MaSP = input.nextInt();
    }

    public void xuat() {
        System.out.format("%-8s %-8d% -8d%n",super.getMaKM(), super.getMucKM(), MaSP);
    }
    public void GhiFile(String filename) throws IOException {
        try (DataOutputStream dos = new DataOutputStream(new FileOutputStream(filename, true))) {
            dos.writeInt(3);
            dos.writeUTF(super.getMaCT());
            dos.writeUTF(super.getMaKM());
            dos.writeInt(super.getMucKM());
            dos.writeInt(MaSP);
        }
    }
}
