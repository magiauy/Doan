import java.io.*;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Arrays;
import java.util.Scanner;

import javax.crypto.Mac;

public class DS_CTKM implements DanhSach{
    private O_ChuongTrinhKhuyenMai[] ds;
    private int n;
    private DS_KM km = new DS_KM();
    Scanner input = new Scanner(System.in);

    public DS_CTKM() {
        n = 0;
        ds = new O_ChuongTrinhKhuyenMai[0];
    }
    public DS_CTKM(O_ChuongTrinhKhuyenMai[] ds, int n) {
        this.ds = ds;
        this.n = n;
    }
    public DS_CTKM(DS_CTKM dss) {
        ds = dss.ds;
        n = dss.n;
    }

    public O_ChuongTrinhKhuyenMai[] getds() {
        return ds;
    }
    public int getn() {
        return n;
    }
    public void setds(O_ChuongTrinhKhuyenMai[] ds) {
        this.ds = ds;
    }
    public void setn(int n) {
        this.n = n;
    }
    public void nhap() {
        System.out.print("Nhap so luong Chuong Trinh Khuyen Mai:");
        n = input.nextInt();
        ds = new O_ChuongTrinhKhuyenMai[n];
        for (int i = 0; i < n; i++) {
            them();
        }
    }
    public void xuat() {
        System.out.println("Danh sach Chuong Trinh Khuyen Mai:");
        for (int i = 0; i < n; i++) {
            ds[i].xuat();
            km.xuat(ds[i].getMaCT());
        }
    }
    public void xuatct(){
        System.out.println("Danh sach Chuong trinh khuyen mai:");
        for(int i=0;i<n;i++){
            ds[i].xuat();
        }
    }
    public void them(O_ChuongTrinhKhuyenMai ctkm) {
        ds = Arrays.copyOf(ds, ds.length + 1);
        ds[n] = ctkm;
        n++;
        GhiFileJava("../src/ChuongTrinhKhuyenMai.txt");
        ghiFile();
    }
    public void them() {
        O_ChuongTrinhKhuyenMai newct = new O_ChuongTrinhKhuyenMai();
        newct.nhap();
        km.nhap(newct.getMaCT());
        them(newct);
    }
    public void suaTheoTenCT(String ms, String ten) {
        for (int i = 0; i < n; i++) {
            if (ds[i].getMaCT().equals(ms)) {
                ds[i].setTenCT(ten);
            }
        }
                GhiFileJava("../src/ChuongTrinhKhuyenMai.txt");
        ghiFile();
    }
    public void suaTheoNgayBD(String ms, String date) {
        for (int i = 0; i < n; i++) {
            if (ds[i].getMaCT().equals(ms)) {
                ds[i].setNgayBatDau(date);
            }
        }
        GhiFileJava("../src/ChuongTrinhKhuyenMai.txt");
        ghiFile();
    }
    public void suaTheoNgayKT(String ms, String date) {
        for (int i = 0; i < n; i++) {
            if (ds[i].getMaCT().equals(ms)) {
                ds[i].setNgayKetThuc(date);
            }
        }
        GhiFileJava("../src/ChuongTrinhKhuyenMai.txt");
        ghiFile();
    }
    public void sua() {
        System.out.print("Nhap Ma Chuong Trinh Khuyen Mai can sua:");
        String ms = input.nextLine();
        for (int i = 0; i < n; i++) {
            if (ds[i].getMaCT().equals(ms)) {
                System.out.println("1. Ten Chuong Trinh");
                System.out.println("2. Ngay Bat Dau");
                System.out.println("3. Ngay Ket Thuc");
                System.out.print("Chon thong tin can sua:");
                int x = input.nextInt();
                input.nextLine();

                switch(x) {
                    case 1:
                        System.out.print("Nhap Ten Chuong Trinh can sua:");
                        String newTen = input.nextLine();
                        ds[i].setTenCT(newTen);
                        break;
                    case 2:
                        System.out.print("Nhap Ngay Bat Dau can sua:");
                        String newDate = input.nextLine();
                        while (ds[i].checkDay(newDate) != true) {
                            System.out.print("Vui long nhap lai Ngay Bat Dau:");
                            newDate = input.nextLine();
                        }
                        ds[i].setNgayBatDau(newDate);
                        break;
                    case 3:
                        System.out.print("Nhap Ngay Ket Thuc can sua:");
                        String newDate1 = input.nextLine();
                        while (ds[i].checkDay(newDate1) != true) {
                            System.out.print("Vui long nhap lai Ngay Ket Thuc:");
                            newDate1 = input.nextLine();
                        }
                        ds[i].setNgayKetThuc(newDate1);
                        break;
                    default: break;
                }
            }
        }
    }

    public void xoa(String ms) {
        int index = -1;
        for (int i = 0; i < n; i++) {
            if (ds[i].getMaCT().equals(ms)) {
                index = i;
                break;
            }
        }
        if (index != -1) {
            for (int i = index; i < n - 1; i++) {
                ds[i] = ds[i + 1];
            }
            ds = Arrays.copyOf(ds, ds.length - 1);
            n--;
        }
        else {
            System.out.println("Khong tim thay!");
        }
        GhiFileJava("../src/ChuongTrinhKhuyenMai.txt");
        ghiFile();
    }
    public void xoa() {
        System.out.print("Nhap Ma Chuong Trinh muon xoa:");
        String ms = input.nextLine();
        xoa(ms);
    }
    public void timKiemTheoMaCT(String ms) {
        boolean flag = false;
        for (int i = 0; i < n; i++) {
            if (ds[i].getMaCT().equals(ms)) {
                ds[i].xuat();
                km.xuat(ds[i].getMaCT());
                flag = true;
            }
        }
        if (flag == false) {
            System.out.println("Khong tim thay!");
        }
    }
    public void timKiemTheoTenCT(String ten) {
        boolean flag = false;
        for (int i = 0; i < n; i++) {
            if (ds[i].getTenCT().equals(ten)) {
                ds[i].xuat();
                km.xuat(ds[i].getMaCT());
                flag = true;
            }
        }
        if (flag == false) {
            System.out.println("Khong tim thay!");
        }
    }
    public void timKiemTheoNgayBD(String date) {
        boolean flag = false;
        for (int i = 0; i < n; i++) {
            if (ds[i].getNgayBatDau().equals(date)) {
                ds[i].xuat();
                km.xuat(ds[i].getMaCT());
                flag = true;
            }
        }
        if (flag == false) {
            System.out.println("Khong tim thay!");
        }
    }
    public void timKiemTheoNgayKT(String date) {
        boolean flag = false;
        for (int i = 0; i < n; i++) {
            if (ds[i].getNgayKetThuc().equals(date)) {
                ds[i].xuat();
                km.xuat(ds[i].getMaCT());
                flag = true;
            }
        }
        if (flag == false) {
            System.out.println("Khong tim thay!");
        }
    }

    // Tìm kiếm chương trình đang diễn ra
    public void timKiemCTDangDienRa() {
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd");

        System.out.println("Chuong trinh dang dien ra :");
        for (int i = 0; i < n; i++) {
            LocalDate bd = LocalDate.parse(ds[i].getNgayBatDau(), dtf);
            LocalDate kt = LocalDate.parse(ds[i].getNgayKetThuc(), dtf);
            LocalDate hienTai = LocalDate.now();
            if ((hienTai.isAfter(bd) || hienTai.isEqual(bd)) && (hienTai.isBefore(kt) || hienTai.isEqual(kt))) {
                ds[i].xuat();
                km.xuat(ds[i].getMaCT());
            }
        }
    }
    /// Tìm kiếm chương trình đã kết thúc
    public void timKiemCTDaKetThuc() {
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd");

        System.out.println("Chuong trinh da ket thuc:");
        for (int i = 0; i < n; i++) {
            LocalDate kt = LocalDate.parse(ds[i].getNgayKetThuc(), dtf);
            LocalDate hienTai = LocalDate.now();
            if (hienTai.isAfter(kt)) {
                ds[i].xuat();
                km.xuat(ds[i].getMaCT());
            }
        }
    }
    public void timKiem() {
        System.out.println("1. Ma Chuong Trinh");
        System.out.println("2. Ten Chuong Trinh");
        System.out.println("3. Ngay Bat Dau");
        System.out.println("4. Ngay Ket Thuc");
        System.out.println("5. Chuong Trinh dang dien ra");
        System.out.println("6. Chuong Trinh da ket thuc");
        System.out.print("Chon thong tin muon tim kiem:");
        int x = input.nextInt();
        input.nextLine();
        switch(x) {
            case 1:
                System.out.print("Nhap Ma Chuong Trinh muon tim:");
                String newMs = input.nextLine();
                timKiemTheoMaCT(newMs);
                break;
            case 2:
                System.out.print("Nhap Ten Chuong Trinh muon tim:");
                String newTen = input.nextLine();
                timKiemTheoTenCT(newTen);
                break;
            case 3:
                System.out.print("Nhap Ngay Bat Dau muon tim:");
                String newDate = input.nextLine();
                timKiemTheoNgayBD(newDate);
                break;
            case 4:
                System.out.print("Nhap Ngay Ket Thuc muon tim:");
                String newDate1 = input.nextLine();
                timKiemTheoNgayKT(newDate1);
                break;
            case 5:
                timKiemCTDangDienRa();
                break;
            case 6:
                timKiemCTDaKetThuc();
                break;
            default: break;
        }
    }

    public void ghiFile(){
        km.GhiFileJava("../src/KhuyenMai.txt");
    }
    public void docFile(){
        km.DocFileJava("../src/KhuyenMai.txt");
    }
    public void GhiFileJava(String filename) {
        try {
            
            DataOutputStream dos = new DataOutputStream(new FileOutputStream(filename));
            dos.writeInt(n);
            try {
                for(int i = 0; i < n; i++) {
                    ds[i].GhiFile(filename);
                }
            }catch(NullPointerException npe) {
                
            }
            dos.close();
        }catch(IOException e) {
            e.printStackTrace();
        }
    }
    public void DocFileJava(String filename) {
        int i = 0;
        try {
            DataInputStream dis = new DataInputStream(new FileInputStream(filename));
            n = dis.readInt();
            ds = new O_ChuongTrinhKhuyenMai[n];
            try {
                while (i < n) {  // Thêm điều kiện kiểm tra để tránh vượt quá độ dài của mảng
                    String MaCT = dis.readUTF();
                    String TenCT = dis.readUTF();
                    String NgayBatDau = dis.readUTF();
                    String NgayKetThuc = dis.readUTF();
                    ds[i] = new O_ChuongTrinhKhuyenMai(MaCT, TenCT, NgayBatDau, NgayKetThuc);
                    i++;
                }
            } catch (EOFException e) {
                // End of file reached
            } finally {
                dis.close();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public String getMaKM(String id){
        for(int i=0;i<n;i++){
            ds[i].getMaCT().equals(id);;
            return ds[i].getMaCT();
        }
        return null;
    }

}
