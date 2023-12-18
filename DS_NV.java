import java.io.*;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Arrays;
import java.util.Scanner;

public class DS_NV implements DanhSach{
    private O_NhanVien[] dsnv;
    private int n;
    Scanner input = new Scanner(System.in);

    public DS_NV() {
        n = 0;
        dsnv = new O_NhanVien[0];
    }

    public DS_NV(O_NhanVien[] dsnv, int n) {
        this.dsnv = dsnv;
        this.n = n;
    }

    public DS_NV(DS_NV ds) {
        dsnv = ds.dsnv;
        n = ds.n;
    }

    public O_NhanVien[] getdsnv() {
        return dsnv;
    }

    public int getn() {
        return n;
    }

    public void setdsnv(O_NhanVien[] dsnv) {
        this.dsnv = dsnv;
    }

    public void setn(int n) {
        this.n = n;
    }

    public void nhap() {
        System.out.print("Nhap so luong Nhan Vien:");
        n = input.nextInt();
        dsnv = new O_NhanVien[n];
        for (int i = 0; i < n; i++) {
            them();
        }
    }

    public void xuat() {
        System.out.format("%-8s %-15s %-8s %-12s %-18s %-5s%n", "MaNV", "HoDem", "TenNV", "NgaySinh", "Luong(Trieu VND)", "Phai");
        for (int i = 0; i < n; i++) {
            dsnv[i].xuat();
        }
    }

    public void them(O_NhanVien nv) {
        dsnv = Arrays.copyOf(dsnv, dsnv.length + 1);
        dsnv[n] = nv;
        n++;
    }
    public void them() {
        O_NhanVien newnv = new O_NhanVien();
        newnv.nhap();
        them(newnv);
        GhiFileJava("../src/NhanVien.txt");
    }

    public void suaTheoHoDem(String ms, String newHo) {
        for (int i = 0; i < n; i++) {
            if (dsnv[i].getMaNV().equals(ms)) {
                dsnv[i].setHoDem(newHo);
            }
        }
        GhiFileJava("../src/NhanVien.txt");
    }

    public void suaTheoTen(String ms, String newTen) {
        for (int i = 0; i < n; i++) {
            if (dsnv[i].getMaNV().equals(ms)) {
                dsnv[i].setTenNV(newTen);
            }
        }
        GhiFileJava("../src/NhanVien.txt");
    }

    public void suaTheoNgaySinh(String ms, String newDate) {
        for (int i = 0; i < n; i++) {
            if (dsnv[i].getMaNV().equals(ms)) {
                dsnv[i].setNgaySinh(newDate);
            }
        }
        GhiFileJava("../src/NhanVien.txt");
    }

    public void suaTheoLuong(String ms, Double newLuong) {
        for (int i = 0; i < n; i++) {
            if (dsnv[i].getMaNV().equals(ms)) {
                dsnv[i].setLuong(newLuong);
            }
        }
        GhiFileJava("../src/NhanVien.txt");
    }

    public void suaTheoPhai(String ms, String newPhai) {
        for (int i = 0; i < n; i++) {
            if (dsnv[i].getMaNV().equals(ms)) {
                dsnv[i].setPhai(newPhai);
            }
        }
        GhiFileJava("../src/NhanVien.txt");
    }

    public void sua() {
        System.out.print("Nhap Ma Nhan Vien muon sua:");
        String ms = input.nextLine();
        input.nextLine();

        boolean flag = false;
        for (int i = 0; i < n; i++) {
            if (dsnv[i].getMaNV().equals(ms)) {
                flag = true;
                System.out.println("1. Ho Dem");
                System.out.println("2. Ten");
                System.out.println("3. Ngay sinh");
                System.out.println("4. Luong");
                System.out.println("5. Gioi tinh");
                System.out.print("Chon thong tin can sua:");
                int x = input.nextInt();
                input.nextLine();

                switch (x) {
                    case 1:
                        System.out.print("Nhap Ho Dem muon sua:");
                        String newHo = input.nextLine();
                        dsnv[i].setHoDem(newHo);
                        break;
                    case 2:
                        System.out.print("Nhap Ten muon sua:");
                        String newTen = input.nextLine();
                        dsnv[i].setTenNV(newTen);
                        break;
                    case 3:
                        System.out.print("Nhap Ngay Sinh muon sua:");
                        String newDate = input.nextLine();
                        while (dsnv[i].checkDay(newDate) != true) {
                            System.out.print("Vui long nhap lai Ngay Sinh:");
                            newDate = input.nextLine();
                        }
                        dsnv[i].setNgaySinh(newDate);
                        break;
                    case 4:
                        System.out.print("Nhap Luong muon sua:");
                        Double newLuong = input.nextDouble();
                        dsnv[i].setLuong(newLuong);
                        break;
                    case 5:
                        System.out.print("Nhap Gioi tinh muon sua:");
                        String newPhai = input.nextLine();
                        dsnv[i].setPhai(newPhai);
                        break;
                    default:
                        break;
                }
            }
        }
        if (flag == false) {
            System.out.println("Khong tim thay Ma Nhan Vien!");
        }
    }

    public void xoa(String ms) {
        int index = -1;
        for (int i = 0; i < n; i++) {
            if (dsnv[i].getMaNV().equals(ms)) {
                index = i;
                break;
            }
        }
        if (index != -1) {
            for (int i = index; i < n - 1; i++) {
                dsnv[i] = dsnv[i + 1];
            }
            dsnv = Arrays.copyOf(dsnv, dsnv.length - 1);
            n--;
        }
        else {
            System.out.println("Khong tim thay!");
        }
        GhiFileJava("../src/NhanVien.txt");
    }

    public void xoa() {
        System.out.print("Nhap Ma Nhan Vien muon xoa:");
        String ms = input.nextLine();
        xoa(ms);
    }

    public void timKiemTheoMa(String newms) {
        boolean flag = false;
        for (int i = 0; i < n; i++) {
            if (dsnv[i].getMaNV().equals(newms)) {
                dsnv[i].xuat();
                flag = true;
            }
        }
        if (flag == false) {
            System.out.println("Khong tim thay!");
        }
    }

    public void timKiemTheoHoDem(String newHo) {
        boolean flag = false;
        for (int i = 0; i < n; i++) {
            if (dsnv[i].getHoDem().equals(newHo)) {
                dsnv[i].xuat();
                flag = true;
            }
        }
        if (flag == false) {
            System.out.println("Khong tim thay!");
        }
    }

    public void timKiemTheoTen(String newTen) {
        boolean flag = false;
        for (int i = 0; i < n; i++) {
            if (dsnv[i].getTenNV().equals(newTen)) {
                dsnv[i].xuat();
                flag = true;
            }
        }
        if (flag == false) {
            System.out.println("Khong tim thay!");
        }
    }

    public void timKiemTheoNgaySinh(String newDate) {
        boolean flag = false;
        for (int i = 0; i < n; i++) {
            if (dsnv[i].getNgaySinh().equals(newDate)) {
                dsnv[i].xuat();
                flag = true;
            }
        }
        if (flag == false) {
            System.out.println("Khong tim thay!");
        }
    }

    public void timKiemTheoLuong(Double newLuong) {
        boolean flag = false;
        for (int i = 0; i < n; i++) {
            if (dsnv[i].getLuong() == newLuong) {
                dsnv[i].xuat();
                flag = true;
            }
        }
        if (flag == false) {
            System.out.println("Khong tim thay!");
        }
    }

    public void timKiemTheoPhai(String newPhai) {
        boolean flag = false;
        for (int i = 0; i < n; i++) {
            if (dsnv[i].getPhai().equals(newPhai)) {
                dsnv[i].xuat();
                flag = true;
            }
        }
        if (flag == false) {
            System.out.println("Khong tim thay!");
        }
    }

    // Tìm kiếm nhân viên có mức lương L1 => mức lương L2
    public void timKiemTheoLuong12(double luong1, double luong2) {
        boolean flag = false;
        System.out.println("Nhan Vien co muc luong tu " + luong1 + " den " + luong2 + ":");
        for (int i = 0; i < n; i++) {
            double luong = dsnv[i].getLuong();
            if (luong >= luong1 && luong <= luong2) {
                dsnv[i].xuat();
                flag = true;
            }
        }
        if (flag == false) {
            System.out.println("Khong tim thay!");
        }
    }

    // Tìm kiếm nhân viên có ngày sinh ns1 => ngày sinh ns2
    public void timKiemTheoNgaySinh12(String ngaySinh1, String ngaySinh2) {
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd");
        LocalDate ns1 = LocalDate.parse(ngaySinh1, dtf);
        LocalDate ns2 = LocalDate.parse(ngaySinh2, dtf);

        boolean flag = false;
        System.out.println("Nhan Vien co ngay sinh " + ngaySinh1 + " den " + ngaySinh2 + ":");
        for (int i = 0; i < n; i++) {
            LocalDate ngaySinh = LocalDate.parse(dsnv[i].getNgaySinh(), dtf);
            if ((ngaySinh.isAfter(ns1) || ngaySinh.isEqual(ns1)) && (ngaySinh.isBefore(ns2) || ngaySinh.isEqual(ns2))) {
                dsnv[i].xuat();
                flag = true;
            }
        }
        if (flag == false) {
            System.out.println("Khong tim thay!");
        }
    }
    // Tìm kiếm nhân viên có năm sinh year1 => năm sinh year2
    public void timKiemTheoNamSinh12(int year1, int year2) {
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd");

        boolean flag = false;
        for (int i = 0; i < n; i++) {
            LocalDate ngaySinh = LocalDate.parse(dsnv[i].getNgaySinh(), dtf);
            int year = ngaySinh.getYear();
            if (year >= year1 && year <= year2) {
                dsnv[i].xuat();
                flag = true;
            }
        }
        if (flag == false) {
            System.out.println("Khong tim thay!");
        }
    }
    public void timKiem() {
        System.out.println("1: Ma Nhan Vien");
        System.out.println("2: Ho Dem");
        System.out.println("3: Ten");
        System.out.println("4: Ngay Sinh");
        System.out.println("5: Luong");
        System.out.println("6: Phai");
        System.out.println("7: Nhan Vien co muc luong tu L1 => L2");
        System.out.println("8: Nhan Vien co ngay sinh tu ns1 => ns2");
        System.out.println("9: Nhan Vien co nam sinh tu year1 => year2");
        System.out.print("Chon thong tin muon tim kiem:");
        int x = input.nextInt();
        input.nextLine();

        switch (x) {
            case 1:
                System.out.print("Nhap Ma Nhan Vien muon tim:");
                String newMs = input.nextLine();
                timKiemTheoMa(newMs);
                break;
            case 2:
                System.out.print("Nhap Ho Dem Nhan Vien muon tim:");
                String newHo = input.nextLine();
                timKiemTheoHoDem(newHo);
                break;
            case 3:
                System.out.print("Nhap Ten Nhan Vien muon tim:");
                String newTen = input.nextLine();
                timKiemTheoTen(newTen);
                break;
            case 4:
                System.out.print("Nhap Ngay Sinh muon tim:");
                String newDate = input.nextLine();
                timKiemTheoNgaySinh(newDate);
                break;
            case 5:
                System.out.print("Nhap Luong muon tim:");
                double newLuong = input.nextDouble();
                timKiemTheoLuong(newLuong);
                break;
            case 6:
                System.out.print("Nhap Phai muon tim:");
                String newPhai = input.nextLine();
                timKiemTheoPhai(newPhai);
                break;
            case 7:
                System.out.print("Tu muc Luong:");
                double L1 = input.nextInt();
                System.out.print("Den muc Luong:");
                double L2 = input.nextInt();
                timKiemTheoLuong12(L1,L2);
                break;
            case 8:
                System.out.print("Tu Ngay Sinh:");
                String ns1 = input.nextLine();
                System.out.print("Den Ngay Sinh:");
                String ns2 = input.nextLine();
                timKiemTheoNgaySinh12(ns1,ns2);
                break;
            case 9:
                System.out.print("Tu Nam Sinh:");
                int year1 = input.nextInt();
                System.out.print("Den Nam Sinh:");
                int year2 = input.nextInt();
                timKiemTheoNamSinh12(year1,year2);
                break;
            default:
                break;
        }
    }

    public void thongKeTheoPhai() {
        System.out.println("Thong ke theo phai:");
        int countFemale = 0, countMale = 0;
        for (int i = 0; i < n; i++) {
            if (dsnv[i].getPhai().toLowerCase().equals("nu")) {
                countFemale++;
            }
            if (dsnv[i].getPhai().toLowerCase().equals("nam")) {
                countMale++;
            }
        }
        System.out.println("Danh sach co " + countFemale + " nhan vien Nu.");
        System.out.println("Danh sach co " + countMale + " nhan vien Nam.");
    }

    public void thongKeTheoTuoi() {
        int[] count = new int[100];
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd");

        for (int i = 0; i < n; i++) {
            LocalDate ngaySinh = LocalDate.parse(dsnv[i].getNgaySinh(), dtf);
            int tuoi = 2023 - ngaySinh.getYear();
            if (tuoi >= 0 && tuoi < 100) {
                count[tuoi]++;
            }
        }
        // In kết quả
        System.out.format("%-8s %-8s\n","Tuoi","So Luong");
        for (int i = 0; i < count.length; i++) {
            if (count[i] > 0) {
                System.out.format("%-8d %-8d\n",count[i],i);
            }
        }
    }

    //tìm kiếm Nhân Viên từ năm sinh year1 đến năm sinh year2
    public void thongKeTheoNam12(int year1, int year2) {
        int[] count = new int[year2 - year1 + 1]; // Mảng để đếm số lượng nhân viên sinh trong mỗi năm
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd");

        for (int i = 0; i < n; i++) {
            LocalDate ngaySinh = LocalDate.parse(dsnv[i].getNgaySinh(), dtf);
            int year = ngaySinh.getYear();
            if (year >= year1 && year <= year2) {
                count[year - year1]++; // Tăng số lượng nhân viên sinh trong năm đó
            }
        }
        // In kết quả
        System.out.format("%-8s %-8s \n","Nam Sinh","So Luong");
        for (int i = 0; i < count.length; i++) {
            if (count[i] > 0) {
                System.out.format("%-8d %-10d\n",(year1+i),count[i]);
            }
            
        }
    }

    public void thongKe() {
        System.out.println("1: Phai");
        System.out.println("2: Tuoi");
        System.out.println("3: Cac Nhan Vien co Nam Sinh tu year1 den Nam Sinh year2");
        System.out.print("Nhap thong tin muon thong ke:");
        int x = input.nextInt();

        switch (x) {
            case 1:
                thongKeTheoPhai();
                break;
            case 2:
                thongKeTheoTuoi();
                break;
            case 3:
                System.out.print("Tu Nam Sinh:");
                int year1 = input.nextInt();
                System.out.print("Den Nam Sinh:");
                int year2 = input.nextInt();
                thongKeTheoNam12(year1, year2);
                break;
            default:
                break;
        }
    }

    public void GhiFileJava(String filename) {
        try {
            DataOutputStream dos = new DataOutputStream(new FileOutputStream(filename));
            dos.writeInt(n);
            try {
                for (int i = 0; i < n; i++) {
                    dsnv[i].GhiFile(filename);
                }
            } catch (NullPointerException npe) {

            }
            dos.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        System.out.println("Ghi file thanh cong");
    }

    public void DocFileJava(String filename) {
        int i = 0;
        try {
            DataInputStream dis = new DataInputStream(new FileInputStream(filename));
            n = dis.readInt();
            dsnv = new O_NhanVien[n];
            try {
                while (i < n) {
                    String MaNV = dis.readUTF();
                    String HoDem = dis.readUTF();
                    String TenNV = dis.readUTF();
                    String NgaySinh = dis.readUTF();
                    Double Luong = dis.readDouble();
                    String Phai = dis.readUTF();
                    dsnv[i] = new O_NhanVien(MaNV, HoDem, TenNV, NgaySinh, Luong, Phai);
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
    public boolean checkNV(String id){
        for(int i=0;i<n;i++){
            if (dsnv[i].getMaNV().equals(id)) {
                return true;
            }
        }
        return false;
    }
}
