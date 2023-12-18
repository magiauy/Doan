import java.io.*;
import java.util.Arrays;
import java.util.Scanner;

public class DS_NCC implements DanhSach{
    private O_NhaCungCap[] dsncc;
    private int n;
    Scanner input = new Scanner(System.in);

    public DS_NCC() {
        n = 0;
        dsncc = new O_NhaCungCap[0];
    }

    public DS_NCC(O_NhaCungCap[] dsncc, int n) {
        this.dsncc = dsncc;
        this.n = n;
    }

    public DS_NCC(DS_NCC ds) {
        dsncc = ds.dsncc;
        n = ds.n;
    }

    public O_NhaCungCap[] getdsncc() {
        return dsncc;
    }

    public int getn() {
        return n;
    }

    public void setdsncc(O_NhaCungCap[] dsncc) {
        this.dsncc = dsncc;
    }

    public void setn(int n) {
        this.n = n;
    }

    public void nhap() {
        System.out.print("Nhap so luong Nha Cung Cap:");
        n = input.nextInt();
        dsncc = new O_NhaCungCap[n];
        for (int i = 0; i < n; i++) {
            them();
        }
    }

    public void xuat() {
        System.out.format("%-8s %-20s %-45s %-15s %-20s%n","MaNCC", "TenNCC", "DiaChi", "Sdt", "Email");
        for (int i = 0; i < n; i++) {
            dsncc[i].xuat();
        }
    }

    public void them(O_NhaCungCap ncc) {
        dsncc = Arrays.copyOf(dsncc, dsncc.length + 1);
        dsncc[n] = ncc; 
        n++;
    }

    public void them() {
        O_NhaCungCap newncc = new O_NhaCungCap();
        System.out.println("Nhap thong tin nha cung cap muon them:");
        newncc.nhap();
        them(newncc);
        GhiFileJava("../src/NhaCungCap.txt");
    }

    public void suaTheoTen(String ms, String ten) {
        for (int i = 0; i < n; i++) {
            if (dsncc[i].getMaNCC().equals(ms)) {
                dsncc[i].setTenNCC(ten);
            }
        }
        GhiFileJava("../src/NhaCungCap.txt");
    }

    public void suaTheoDiaChi(String ms, String dc) {
        for (int i = 0; i < n; i++) {
            if (dsncc[i].getMaNCC().equals(ms)) {
                dsncc[i].setDiaChi(dc);
            }
        }
        GhiFileJava("../src/NhaCungCap.txt");
    }

    public void suaTheoSdt(String ms, String sdt) {
        for (int i = 0; i < n; i++) {
            if (dsncc[i].getMaNCC().equals(ms)) {
                dsncc[i].setSdt(sdt);
            }
        }
        GhiFileJava("../src/NhaCungCap.txt");
    }

    public void suaTheoEmail(String ms, String newMail) {
        for (int i = 0; i < n; i++) {
            if (dsncc[i].getMaNCC().equals(ms)) {
                dsncc[i].setEmail(newMail);
            }
        }
        GhiFileJava("../src/NhaCungCap.txt");
    }

    public void sua() {
        System.out.print("Nhap Ma Nha Cung Cap muon sua:");
        String ms = input.nextLine();
        input.nextLine();

        boolean flag = false;
        for (int i = 0; i < n; i++) {
            if (dsncc[i].getMaNCC().equals(ms)) {
                flag = true;
                System.out.println("1. Ten Nha Cung Cap");
                System.out.println("2. Dia Chi");
                System.out.println("3. So Dien Thoai");
                System.out.println("4. Email");
                System.out.print("Chon thong tin can sua:");
                int x = input.nextInt();
                input.nextLine();

                switch(x) {
                    case 1:
                        System.out.print("Nhap Ten Nha Cung Cap muon sua:");
                        String newTen = input.nextLine();
                        dsncc[i].setTenNCC(newTen);
                        break;
                    case 2:
                        System.out.print("Nhap Dia Chi muon sua:");
                        String newDC = input.nextLine();
                        dsncc[i].setDiaChi(newDC);
                        break;
                    case 3:
                        System.out.print("Nhap So Dien Thoai muon sua:");
                        String newSdt = input.nextLine();
                        dsncc[i].setSdt(newSdt);
                        break;
                    case 4:
                        System.out.print("Nhap Email muon sua:");
                        String newEmail = input.nextLine();
                        dsncc[i].setEmail(newEmail);
                        break;
                    default: break;
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
            if (dsncc[i].getMaNCC().equals(ms)) {
                index = i;
                break;
            }
        }
        if (index != -1) {
            for (int i = index; i < n - 1; i++) {
                dsncc[i] = dsncc[i + 1];
            }
            dsncc = Arrays.copyOf(dsncc, dsncc.length - 1);
            n--;
        }
        else {
            System.out.println("Khong tim thay!");
        }
        GhiFileJava("../src/NhaCungCap.txt");
    }

    public void xoa() {
        System.out.print("Nhap Ma Nha Cung Cap muon xoa:");
        String ms = input.nextLine();
        xoa(ms);
    }

    public void timKiemTheoMa(String newms) {
        boolean flag = false;
        for (int i = 0; i < n; i++) {
            if (dsncc[i].getMaNCC().equals(newms)) {
                dsncc[i].xuat();
                flag = true;
            }
        }
        if (flag == false) {
            System.out.println("Khong tim thay!");
        }
        GhiFileJava("../src/NhaCungCap.txt");
    }

    public void timKiemTheoTen(String newten) {
        boolean flag = false;
        for (int i = 0; i < n; i++) {
            if (dsncc[i].getTenNCC().equals(newten)) {
                dsncc[i].xuat();
                flag = true;
            }
        }
        if (flag == false) {
            System.out.println("Khong tim thay!");
        }
    }

    public void timKiemTheoDC(String newDC) {
        boolean flag = false;
        for (int i = 0; i < n; i++) {
            if (dsncc[i].getDiaChi().contains(newDC)) {
                dsncc[i].xuat();
                flag = true;
            }
        }
        if (flag == false) {
            System.out.println("Khong tim thay!");
        }
    }

    public void timKiemTheoSDT(String newsdt) {
        boolean flag = false;
        for (int i = 0; i < n; i++) {
            if (dsncc[i].getSdt().equals(newsdt)) {
                dsncc[i].xuat();
                flag = true;
            }
        }
        if (flag == false) 
        {
            System.out.println("Khong tim thay!");
        }
    }

    public void timKiemTheoEmail(String newEmail) {
        boolean flag = false;
        for (int i = 0; i < n; i++) {
            if (dsncc[i].getEmail().equals(newEmail)) {
                dsncc[i].xuat();
                flag = true;
            }
        }
        if (flag == false) {
            System.out.println("Khong tim thay!");
        }
    }

    public void timKiem() {
        System.out.println("1: Ma Nha Cung Cap");
        System.out.println("2: Ten Nha Cung Cap");
        System.out.println("3: Dia Chi");
        System.out.println("4: So Dien Thoai");
        System.out.println("5: Email");
        System.out.print("Chon thong tin muon tim kiem:");
        int x = input.nextInt();
        input.nextLine();

        switch (x) {
            case 1:
                System.out.print("Nhap Ma Nha Cung Cap muon tim:");
                String newMs = input.nextLine();
                timKiemTheoMa(newMs);
                break;
            case 2:
                System.out.print("Nhap Ten Nha Cung Cap muon tim:");
                String newTen = input.nextLine();
                timKiemTheoTen(newTen);
                break;
            case 3:
                System.out.print("Nhap Dia Chi muon tim:");
                String newDC = input.nextLine();
                timKiemTheoDC(newDC);
                break;
            case 4:
                System.out.print("Nhap So Dien Thoai muon tim:");
                String newsdt = input.nextLine();
                timKiemTheoSDT(newsdt);
                break;
            case 5:
                System.out.print("Nhap Email muon tim:");
                String newEmail = input.nextLine();
                timKiemTheoEmail(newEmail);
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
                for(int i = 0; i < n; i++) {
                    dsncc[i].GhiFile(filename);
                }
            } catch(NullPointerException npe) {

            }
            dos.close();
        } catch(IOException e) {
            e.printStackTrace();
        }
        System.out.println("Ghi file thanh cong");
    }

    public void DocFileJava(String filename) {
        int i = 0;
        try {
            DataInputStream dis = new DataInputStream(new FileInputStream(filename));
            n = dis.readInt();
            dsncc = new O_NhaCungCap[n];
            try {
                while (i < n) {  // Thêm điều kiện kiểm tra để tránh vượt quá độ dài của mảng
                    String MaNCC = dis.readUTF();
                    String TenNCC = dis.readUTF();
                    String DiaChi = dis.readUTF();
                    String Sdt = dis.readUTF();
                    String Email = dis.readUTF();
                    dsncc[i] = new O_NhaCungCap(MaNCC, TenNCC, DiaChi, Sdt, Email);
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
    public boolean checkNCC(String id){
        for(int i=0;i<n;i++){
            if (dsncc[i].getMaNCC().equals(id)) {
                return true;
            }
        }
        return false;
    }
}
