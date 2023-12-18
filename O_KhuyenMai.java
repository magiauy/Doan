import java.io.DataOutputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Scanner;

public abstract class O_KhuyenMai implements Object{
    private String MaCT;
    private String MaKM;
    private int MucKM;
    Scanner input = new Scanner(System.in);

    public O_KhuyenMai() {}
    public O_KhuyenMai(String MaCT, String MaKM, int MucKM) {
        this.MaCT = MaCT;
        this.MaKM = MaKM;
        this.MaKM = MaKM;
        this.MucKM = MucKM;
    }
    public O_KhuyenMai(O_KhuyenMai km) {
        MaCT = km.MaCT;
        MaKM = km.MaKM;
        MucKM = km.MucKM;
    }

    public String getMaCT() {
        return MaCT;
    }
    public String getMaKM() {
        return MaKM;
    }
    public int getMucKM() {
        return MucKM;
    }

    public void setMaCT(String MaCT) {
        this.MaCT = MaCT;
    }
    public void setMaKM(String MaKM) {
        this.MaKM = MaKM;
    }
    public void setMucKM(int MucKM) {
        this.MucKM = MucKM;
    }
    public void nhap() {
        System.out.print("Nhap Ma Khuyen Mai:");
        MaKM = input.nextLine();
        System.out.print("Nhap Muc Khuyen Mai:");
        MucKM = input.nextInt();
    }
    public abstract void xuat();

    public void GhiFile(String filename) throws IOException {
        try (DataOutputStream dos = new DataOutputStream(new FileOutputStream(filename, true))) {
            dos.writeInt(1);
            dos.writeUTF(MaCT);
            dos.writeUTF(MaKM);
            dos.writeInt(MucKM);
        }
    }
}
