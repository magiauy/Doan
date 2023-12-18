import java.io.DataOutputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Scanner;

public class KhachHang {
    private String maKhachHang;
    private String Hodem;
    private String Ten;
    private String Phai;
    private String SoDienThoai;
    private String DiaChi;
    Scanner sc = new Scanner(System.in);

    public KhachHang() {
    }

    public void GhiFile(String filename) throws IOException {
        try (DataOutputStream dos = new DataOutputStream(new FileOutputStream(filename, true))) {
            dos.writeUTF(maKhachHang);
            dos.writeUTF(Hodem);
            dos.writeUTF(Ten);
            dos.writeUTF(Phai);
            dos.writeUTF(SoDienThoai);
            dos.writeUTF(DiaChi);
        }
    }
    public KhachHang(String maKhachHang, String Hodem, String Ten, String Phai, String SoDienThoai, String DiaChi) {
        this.maKhachHang = maKhachHang;
        this.Hodem = Hodem;
        this.Ten = Ten;
        this.Phai = Phai;
        this.SoDienThoai = SoDienThoai;
        this.DiaChi = DiaChi;
    }

    public String getmaKhackHang() {
        return maKhachHang;
    }

    public String getPhai() {
        return Phai;
    }

    public void setPhai(String phai) {
        Phai = phai;
    }

    public String getHodem() {
        return Hodem;
    }

    public String getTen() {
        return Ten;
    }

    public String getSoDienThoai() {
        return SoDienThoai;
    }

    public String getDiaChi() {
        return DiaChi;
    }

    public void setmaKhachHang(String maKhachHang) {
        this.maKhachHang = maKhachHang;
    }

    public void setHodem(String Hodem) {
        this.Hodem = Hodem;
    }

    public void setTen(String Ten) {
        this.Ten = Ten;
    }

    public void setSoDienThoai(String SoDienThoai) {
        this.SoDienThoai = SoDienThoai;
    }

    public void setDiaChi(String DiaChi) {
        this.DiaChi = DiaChi;
    }

    public void nhapkh() {
        System.out.print("Nhap ma khach hang: ");
        maKhachHang = sc.nextLine();
        System.out.print("Nhap ho dem: ");
        Hodem = sc.nextLine();
        System.out.print("Nhap ten: ");
        Ten = sc.nextLine();
        System.out.print("Nhap gioi tinh: ");
        Phai = sc.nextLine();
        System.out.print("Nhap so dien thoai: ");
        SoDienThoai = sc.nextLine();
        sc.nextLine();
        System.out.print("Nhap dia chi: ");
        DiaChi = sc.nextLine();
    }
    
    public void xuatkh() {
        System.out.format("%-8s %-15s %-8s %-8s %-15s %-20s \n", maKhachHang, Hodem, Ten, Phai, SoDienThoai, DiaChi);
    }
    
}
