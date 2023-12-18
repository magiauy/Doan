import java.util.Arrays;
import java.util.Scanner;
import java.io.*;

public class HoaDon {
    private String maHoaDon;
    private String maNhanVien;
    private String maKhachHang;
    private String ngayLap;
    private double tongTien;
    private String maKhuyenMai;
    private DS_Chitiethoadon ds = new DS_Chitiethoadon();

    public HoaDon() {
    }

    public HoaDon(String maHoaDon, String maNhanVien, String maKhachHang,
            String ngayLap, double tongTien, String maKhuyenMai) {
        this.maHoaDon = maHoaDon;
        this.maNhanVien = maNhanVien;
        this.maKhachHang = maKhachHang;
        this.ngayLap = ngayLap;
        this.tongTien = tongTien;
        this.maKhuyenMai = maKhuyenMai;
    }

    public String getMaHoaDon() {
        return maHoaDon;
    }

    public void setMaHoaDon(String maHoaDon) {
        this.maHoaDon = maHoaDon;
    }

    public String getMaNhanVien() {
        return maNhanVien;
    }

    public void setMaNhanVien(String maNhanVien) {
        this.maNhanVien = maNhanVien;
    }

    public String getMaKhachHang() {
        return maKhachHang;
    }

    public void setMaKhachHang(String maKhachHang) {
        this.maKhachHang = maKhachHang;
    }

    public String getNgayLap() {
        return ngayLap;
    }

    public void setNgayLap(String ngayLap) {
        this.ngayLap = ngayLap;
    }

    public double getTongTien() {        
        return tongTien;
    }

    public void setTongTien(double tongTien) {
        this.tongTien = tongTien;
    }

    public String getMaKhuyenMai() {
        return maKhuyenMai;
    }

    public void setMaKhuyenMai(String maKhuyenMai) {
        this.maKhuyenMai = maKhuyenMai;
    }

    Scanner sc = new Scanner(System.in);

    public void nhaphoadon() {
        DS_NV nv = new DS_NV();
        nv.DocFileJava("../src/NhanVien.txt");
        DanhSachKH kh = new DanhSachKH();
        kh.DocFileJava("../src/KhachHang.txt");
        DS_CTKM km = new DS_CTKM();
        km.DocFileJava("../src/ChuongTrinhKhuyenMai.txt");
        System.out.print("Nhap ma hoa don: ");
        maHoaDon = sc.nextLine();
        nv.xuat();
        System.out.print("Nhap ma nhan vien: ");
        maNhanVien = sc.nextLine();
        kh.xuatkhachhang();
        System.out.print("Nhap ma khach hang: ");
        maKhachHang = sc.nextLine();
        System.out.print("Ngay lap(dd/mm/yyyy): ");
        ngayLap = sc.nextLine();
        km.xuatct();
        System.out.print("Nhap ma khuyen mai: ");
        maKhuyenMai = sc.nextLine();
    }

    public void xuathoadon() {
        System.out.println("---THONG TIN HOA DON---");
        System.out.format("Ma hoa don:%-8s Ma nhan vien:%-8s Ma khach hang:%-8s \n", maHoaDon,maNhanVien,maKhachHang);
        System.out.format("Ngay lap:%-8s Ma khuyen mai:%-8s\n", ngayLap,maKhuyenMai);
    }

    public void GhiFile(String filename) throws IOException {
        try (DataOutputStream dos = new DataOutputStream(new FileOutputStream(filename, true))) {
            dos.writeUTF(maHoaDon);
            dos.writeUTF(maNhanVien);
            dos.writeUTF(maKhachHang);
            dos.writeUTF(ngayLap);
            dos.writeUTF(maKhuyenMai);
            dos.writeDouble(tongTien);
        }
    }
}
