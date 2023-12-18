import java.util.Arrays;
import java.util.Scanner;
import java.io.*;

public class DanhSachKH {
    private int n;
    private KhachHang[] KH;
    Scanner sc = new Scanner(System.in);

    public DanhSachKH() {
        n = 0;
        KH = new KhachHang[0];
    }

    public DanhSachKH(int n, KhachHang[] KH) {
        this.n = n;
        this.KH = KH;
    }

    public int getN() {
        return n;
    }

    public void setN(int n) {
        this.n = n;
    }

    public KhachHang[] getKH() {
        return KH;
    }

    public void setKH(KhachHang[] kH) {
        this.KH = kH;
    }

    public void nhapkhachhang() {
        System.out.print("Nhap so luong khach hang: ");
        n = sc.nextInt();
        KH = new KhachHang[n];
        for (int i = 0; i < n; i++) {
            KH[i].nhapkh();
        }
    }

    public void xuatkhachhang() {
        System.out.println("---Danh sach khach hang: ");
        System.out.format("%-8s %-15s %-8s %-8s %-15s %-20s \n", "MaKH", "HoDem", "Ten", "Phai", "SDT", "DiaChi");
        for (int i = 0; i < n; i++) {
            KH[i].xuatkh();
        }
    }

    public void themkhachhang(KhachHang kh) {
        KH = Arrays.copyOf(KH, KH.length + 1);
        this.KH[n] = kh;
        n++;
    }

    public void themkhachhang() {
        KhachHang newkh = new KhachHang();
        System.out.println("Nhap thong tin khach hang can them.");
        newkh.nhapkh();
        themkhachhang(newkh);
        GhiFileJava("../src/KhachHang.txt");
    }

    public void xoakhachhang(String maKhachHang) {
        int index = -1;
        for (int i = 0; i < n; i++) {
            if (KH[i].getmaKhackHang().equals(maKhachHang)) {
                index = i;
                break;
            }
        }
        if (index != -1) {
            for (int i = index; i < n - 1; i++) {
                KH[i] = KH[i + 1];
            }
            KH = Arrays.copyOf(KH, KH.length - 1);
            n--;
        } else {
            System.out.println("Khong tim thay!");
        }
    }

    public void xoakhachhang() {
        String maKhachHang;
        System.out.print("Nhap ma khach hang can xoa: ");
        maKhachHang = sc.nextLine();
        xoakhachhang(maKhachHang);
    }

    public void suathongtin() {
        String maKhachHang;
        int chon;
        System.out.println("Chon ma khach hang can sua: ");
        maKhachHang = sc.nextLine();
        for (int i = 0; i < n; i++) {
            if (KH[i].getmaKhackHang().equals(maKhachHang)) {
                System.out.println("---Thong tin can thay doi: ");
                System.out.println("1.Hodem.");
                System.out.println("2.Ten.");
                System.out.println("3.Gioi tinh.");
                System.out.println("4.So dien thoai.");
                System.out.println("5.Dia chi.");
                System.out.println("Chon: ");
                chon = sc.nextInt();
                switch (chon) {
                    case 1:
                        sc.nextLine();
                        System.out.print("Nhap ho dem moi: ");
                        String hodem2 = sc.nextLine();
                        hodem2 = hodem2.trim();
                        hodem2 = hodem2.replaceAll("\\s+", " ");
                        KH[i].setHodem(hodem2);
                        break;
                    case 2:
                        sc.nextLine();
                        System.out.println("Nhap ten moi: ");
                        String ten2 = sc.nextLine();
                        KH[i].setTen(ten2);
                        break;
                    case 3:
                        sc.nextLine();
                        System.out.println("Nhap gioi tinh moi: ");
                        String phai2 = sc.nextLine();
                        KH[i].setPhai(phai2);
                        break;
                    case 4:
                        sc.nextLine();
                        System.out.print("Nhap so dien thoai moi: ");
                        String sdt2 = sc.nextLine();
                        KH[i].setSoDienThoai(sdt2);
                        break;
                    case 5:
                        sc.nextLine();
                        System.out.println("Nhap dia chi moi: ");
                        String diachi2 = sc.nextLine();
                        diachi2 = diachi2.trim();
                        diachi2 = diachi2.replaceAll("\\s+", " ");
                        KH[i].setDiaChi(maKhachHang);
                        break;
                    default:
                        System.out.println("Thoat chuong trinh");
                        break;
                }
            }
        }
    }

    public void suahodem(String maKhachHang, String ten2) {
        for (int i = 0; i < n; i++) {
            if (KH[i].getmaKhackHang().equals(maKhachHang)) {
                ten2 = ten2.trim();
                ten2 = ten2.replaceAll("\\s+", " ");
                KH[i].setHodem(ten2);
            }
        }
    }

    public void suaten(String maKhachHang, String ten2) {
        for (int i = 0; i < n; i++) {
            if (KH[i].getmaKhackHang().equals(maKhachHang)) {
                KH[i].setTen(ten2);
            }
        }
    }

    public void suaSDT(String maKhachHang, String sdt2) {
        for (int i = 0; i < n; i++) {
            if (KH[i].getmaKhackHang().equals(maKhachHang)) {
                KH[i].setSoDienThoai(sdt2);
            }
        }
    }

    public void suaphai(String maKhachHang, String newphai) {
        for (int i = 0; i < n; i++) {
            if (KH[i].getmaKhackHang().equals(maKhachHang)) {
                KH[i].setPhai(newphai);
            }
        }

    }

    public void suadiachi(String maKhachHang, String newdc) {

        for (int i = 0; i < n; i++) {
            if (KH[i].getmaKhackHang().equals(maKhachHang)) {
                KH[i].setDiaChi(newdc);
            }
        }

    }

    // public String capitalize(String stringfromclient) {
    // String[] arr = stringfromclient.split(" ");
    // String stringfromclient1 = "";
    // for (String x : arr) {
    // stringfromclient1 = stringfromclient1 + (x.substring(0, 1).toUpperCase() +
    // x.substring(1));
    // stringfromclient1 = stringfromclient1 + "";
    // }
    // return stringfromclient1;
    // }

    public void timkiemkhachhang() {

        System.out.println("---Cac cach tim kiem:  ");
        System.out.println("1.Tim theo ma khach hang.");
        System.out.println("2.Tim theo ho dem.");
        System.out.println("3.Tim theo ten.");
        System.out.println("4.Tim theo so dien thoai.");
        System.out.println("5.Tim theo dia chi.");
        System.out.println("Chon: ");
        int s = sc.nextInt();
        switch (s) {
            case 1:
                sc.nextLine();
                System.out.print("Nhap ma khach hang can tim: ");
                String newMSKH = sc.nextLine();
                boolean ktrmakh = false;
                for (int i = 0; i < n; i++) {
                    if (KH[i].getmaKhackHang().equals(newMSKH)) {
                        System.out.println("Da tim thay khach hang");
                        ktrmakh = true;
                        KH[i].xuatkh();
                        break;
                    }
                }
                if (ktrmakh == false) {
                    System.out.println("Khong tim thay khach hang co ma: " + newMSKH);
                }
                break;
            case 2:
                sc.nextLine();
                System.out.println("Nhap ho dem can tim");
                String newHo = sc.nextLine();
                // newHo = capitalize(newHo);
                newHo = newHo.trim();
                newHo.replaceAll("\\s+", " ");
                boolean datimthayho = false;
                for (int i = 0; i < n; i++) {
                    // System.out.println("Da tim thay khach hang");
                    if (KH[i].getHodem().equals(newHo)) {
                        datimthayho = true;
                        KH[i].xuatkh();
                    }
                }
                if (datimthayho == false) {
                    System.out.println("Khong tim thay khach hang co ho dem: " + newHo);
                }
                break;
            case 3:
                sc.nextLine();
                System.out.print("Nhap ten can tim: ");
                String newTen = sc.nextLine();
                newTen = newTen.substring(0, 1).toUpperCase() + newTen.substring(1);
                boolean ktraten = false;
                for (int i = 0; i < n; i++) {
                    if (KH[i].getTen().contains(newTen)) {
                        System.out.println("Da tim thay ten khach hang. ");
                        ktraten = true;
                        KH[i].xuatkh();
                    }
                }
                if (ktraten == false) {
                    System.out.println("Khong tim thay khach hang co ten: " + newTen);
                }
                break;

            case 4:
                sc.nextLine();
                System.out.print("Nhap so dien thoai can tim: ");
                String newSDT = sc.nextLine();
                boolean ktrasdt = false;
                for (int i = 0; i < n; i++) {
                    if (KH[i].getSoDienThoai().equals(newSDT)) {
                        System.out.println("Da tim thay khach hang. ");
                        ktrasdt = true;
                        KH[i].xuatkh();
                    }
                }
                if (ktrasdt == false) {
                    System.out.println("Khong tim thay khach hang co so dien thoai: " + newSDT);
                }
                break;

            case 5:
                sc.nextLine();
                System.out.print("Nhap dia chi can tim: ");
                String newDC = sc.nextLine();
                boolean flag = false;
                for (int i = 0; i < n; i++) {
                    if (KH[i].getDiaChi().contains(newDC)) {
                        KH[i].xuatkh();
                        flag = true;
                    }
                }
                if (flag == false) {
                    System.out.println("Khong tim thay!");
                }
                break;
            default:
                System.out.println("Thoat chuong trinh");
                break;
        }
    }

    public void timkiemtheoma(String maKH) {
        boolean ktrmakh = false;
        for (int i = 0; i < n; i++) {
            if (KH[i].getmaKhackHang().equals(maKH)) {
                ktrmakh = true;
                KH[i].xuatkh();
                break;
            }
        }
        if (ktrmakh == false) {
            System.out.println("Khong tim thay!");
        }
    }

    public void timkiemtheohodem(String hodem) {
        hodem = hodem.trim();
        hodem.replaceAll("\\s+", " ");
        boolean datimthayho = false;
        for (int i = 0; i < n; i++) {
            if (KH[i].getHodem().equals(hodem)) {
                datimthayho = true;
                KH[i].xuatkh();
            }
        }
        if (datimthayho == false) {
            System.out.println("Khong tim thay!");
        }
    }

    public void timkiemtheoten(String ten) {
        ten = ten.substring(0, 1).toUpperCase() + ten.substring(1);
        boolean ktraten = false;
        for (int i = 0; i < n; i++) {
            if (KH[i].getTen().contains(ten)) {
                System.out.println("Da tim thay ten khach hang. ");
                ktraten = true;
                KH[i].xuatkh();
            }
        }
        if (ktraten == false) {
            System.out.println("Khong tim thay!");
        }
    }

    public void timkiemtheosdt(String sdt) {
        boolean ktrasdt = false;
        for (int i = 0; i < n; i++) {
            if (KH[i].getSoDienThoai().equals(sdt)) {
                System.out.println("Da tim thay khach hang. ");
                ktrasdt = true;
                KH[i].xuatkh();
            }
        }
        if (ktrasdt == false) {
            System.out.println("Khong tim thay!");
        }
    }

    public void timKiemTheoDC(String newDC) {
        boolean flag = false;
        for (int i = 0; i < n; i++) {
            if (KH[i].getDiaChi().contains(newDC)) {
                KH[i].xuatkh();
                flag = true;
            }
        }
        if (flag == false) {
            System.out.println("Khong tim thay!");
        }
    }

    public void thongketheophai() {
        int countnam = 0, countnu = 0;
        for (int i = 0; i < n; i++) {
            if (KH[i].getPhai().equals("nu"))
                countnu++;
            else {
                if (KH[i].getPhai().equals("nam"))
                    countnam++;
            }
        }
        System.out.println("Danh sach co " + countnam + " khach hang nam.");
        System.out.println("Danh sach co " + countnu + " khach hang nu.");

    }

    public void thongkekhachhang() {
        System.out.println("Thong ke khach hang theo gioi tinh: ");
        thongketheophai();
    }

    public void GhiFileJava(String filename) {
        try {
            DataOutputStream dos = new DataOutputStream(new FileOutputStream(filename));
            dos.writeInt(n);
            try {
                for (int i = 0; i < n; i++) {
                    KH[i].GhiFile(filename);
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
            KH = new KhachHang[n];
            try {
                while (i < n) { // Thêm điều kiện kiểm tra để tránh vượt quá độ dài của mảng
                    String maKhachHang = dis.readUTF();
                    String Hodem = dis.readUTF();
                    String Ten = dis.readUTF();
                    String Phai = dis.readUTF();
                    String SoDienThoai = dis.readUTF();
                    String DiaChi = dis.readUTF();
                    KH[i] = new KhachHang(maKhachHang, Hodem, Ten, Phai, SoDienThoai, DiaChi);
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

}