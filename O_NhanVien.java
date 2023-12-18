import java.io.*;
import java.lang.Object;
import java.util.Scanner;

public class O_NhanVien{
    private String MaNV;
    private String HoDem;
    private String TenNV;
    private String NgaySinh;
    private double Luong;
    private String Phai;
    Scanner input = new Scanner(System.in);

    public O_NhanVien() {}

    public O_NhanVien(String MaNV, String HoDem, String TenNV, String NgaySinh, double Luong, String Phai) {
        this.MaNV = MaNV;
        this.TenNV = TenNV;
        this.HoDem = HoDem;
        this.NgaySinh = NgaySinh;
        this.Luong = Luong;
        this.Phai = Phai;
    }

    public O_NhanVien(O_NhanVien thongTin) {
        MaNV = thongTin.MaNV;
        TenNV = thongTin.TenNV;
        HoDem = thongTin.HoDem;
        NgaySinh = thongTin.NgaySinh;
        Luong = thongTin.Luong;
        Phai = thongTin.Phai;
    }

    public String getMaNV() {
        return MaNV;
    }

    public String getTenNV() {
        return TenNV;
    }

    public String getHoDem() {
        return HoDem;
    }

    public String getNgaySinh() {
        return NgaySinh;
    }

    public double getLuong() {
        return Luong;
    }

    public String getPhai() {
        return Phai;
    }

    public void setMaNV(String MaNV) {
        this.MaNV = MaNV;
    }

    public void setTenNV(String TenNV) {
        this.TenNV = TenNV;
    }

    public void setHoDem(String HoDem) {
        this.HoDem = HoDem;
    }

    public void setNgaySinh(String NgaySinh) {
        this.NgaySinh = NgaySinh;
    }

    public void setLuong(double Luong) {
        this.Luong = Luong;
    }

    public void setPhai(String Phai) {
        this.Phai = Phai;
    }

    public void nhap() {
        System.out.print("Nhap ma nhan vien:");
        MaNV = input.nextLine();
        System.out.print("Nhap ho dem:");
        HoDem = input.nextLine();
        System.out.print("Nhap ten:");
        TenNV = input.nextLine();
        System.out.print("Nhap luong:");
        Luong = input.nextDouble();
        input.nextLine();
        System.out.print("Nhap phai:");
        Phai = input.nextLine();
        System.out.print("Nhap ngay sinh:");
        NgaySinh = input.nextLine();
        while (checkDay(NgaySinh) != true) {
            System.out.print("Vui long nhap lai:");
            NgaySinh = input.nextLine();
        }
    }

    public void xuat() {        
        System.out.format("%-8s %-15s %-8s %-12s %-18.2f %-5s%n",MaNV, HoDem, TenNV, NgaySinh, Luong, Phai);
    }
    public void GhiFile(String filename) throws IOException {
        try (DataOutputStream dos = new DataOutputStream(new FileOutputStream(filename, true))) {
            dos.writeUTF(MaNV);
            dos.writeUTF(HoDem);
            dos.writeUTF(TenNV);
            dos.writeUTF(NgaySinh);
            dos.writeDouble(Luong);
            dos.writeUTF(Phai);
        }
    }

    public int[] Date(String ngay) {
        String[] date = ngay.split("/");
        int[] dateInt = new int[date.length];
        for (int i = 0; i < date.length; i++) {
            dateInt[i] = Integer.parseInt(date[i]);
        }
        return dateInt;
    }

    public boolean checkDay(String ngay) {
        int[] date = Date(ngay);
        int year = date[0];
        int month = date[1];
        int day = date[2];

        switch (month) {
            case 4: case 6: case 9: case 11:
                if (day < 1 || day > 30) {
                    return false;
                }
                break;
            case 1: case 3: case 5: case 7: case 8: case 10: case 12:
                if (day < 1 || day > 31) {
                    return false;
                }
                break;
            case 2:
                if (year % 4 == 0 && (year % 100 != 0 || year % 400 == 0)) {
                    if (day < 1 || day > 29) {
                        return false;
                    }
                } else {
                    if (day < 1 || day > 28) {
                        return false;
                    }
                }
                break;
            default: return false;
        }
        return true;
    }
}