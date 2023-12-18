import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.EOFException;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Arrays;
import java.util.Scanner;
public class DS_KM {
    private String MaCT;
    private O_KhuyenMai[] ds;
    private int n;
    Scanner input = new Scanner(System.in);

    public DS_KM() {
        n = 0;
        ds = new O_KhuyenMai[0];
    }
    public DS_KM(O_KhuyenMai[] ds, int n) {
        this.ds = ds;
        this.n = n;
    }
    public DS_KM(DS_KM km) {
        ds = km.ds;
        n = km.n;
    }

    public O_KhuyenMai[] getds() {
        return ds;
    }
    public int getn() {
        return n;
    }
    public void setds(O_KhuyenMai[] ds) {
        this.ds = ds;
    }
    public void setn(int n) {
        this.n = n;
    }

    public void nhap(String ms) {
        this.MaCT = ms;
        System.out.println("Ma Chuong Trinh: " + MaCT);
        boolean flag = true;
        while (flag) {
            them();
            System.out.println("Tiep tuc them Chuong Trinh Khuyen Mai?(y/n)");
            String choice = input.next();
            if (choice.equals("n")) {
                flag = false;
            }
        }
    }

    public void xuat(String ms) {
        System.out.format("%-8s %-8s %-8s%n","MaKM", "MucKM(%)", "MaSP");
        for (int i = 0; i < n; i++) {
            if (ds[i].getMaCT().equals(ms) && ds[i] instanceof O_KhuyenMaiTheoSP) {
                ds[i].xuat();
            }
        }
        System.out.println();
        System.out.format("%-8s %-8s %-8s%n","MaKM", "MucKM(%)", "MucGia");
        for (int i = 0; i < n; i++) {
            if (ds[i].getMaCT().equals(ms) && ds[i] instanceof O_KhuyenMaiTheoHoaDon) {
                ds[i].xuat();
            }
        }
    } 
    public void xuat() {
        System.out.println(n);
        System.out.format("%-8s %-8s %-8s%n","MaKM", "MucKM(%)", "MaSP");
        for (int i = 0; i < n; i++) {
            if (ds[i] instanceof O_KhuyenMaiTheoSP) {
                ds[i].xuat();
            }
        }

        System.out.println();
        System.out.format("%-8s %-8s %-8s%n","MaKM", "MucKM(%)", "MucGia");
        for (int i = 0; i < n; i++) {
            if (ds[i] instanceof O_KhuyenMaiTheoHoaDon) {
                ds[i].xuat();
            }
        }
    }

    public void them(O_KhuyenMai km) {
        ds = Arrays.copyOf(ds, ds.length + 1);
        ds[n] = km;
        n++;
    }

    public void them() {
        System.out.println("1: Khuyen Mai Theo Hoa Don");
        System.out.println("2: Khuyen Mai Theo San Pham.");
        System.out.print("Nhap lua chon:");
        int x = input.nextInt();

        switch(x) {
            case 1:
                O_KhuyenMaiTheoHoaDon kmhd = new O_KhuyenMaiTheoHoaDon();
                kmhd.nhap();
                kmhd.setMaCT(MaCT);
                them(kmhd);
                break;
            case 2:
                O_KhuyenMaiTheoSP kmsp = new O_KhuyenMaiTheoSP();
                kmsp.nhap();
                kmsp.setMaCT(MaCT);
                them(kmsp);
                break;
            default: break;
        }
    }

    public void xoa(String ms) {
        int index = -1;
        for (int i = 0; i < n; i++) {
            if (ds[i].getMaKM().equals(ms)) {
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
    }
    public void xoa() {
        System.out.print("Nhap Ma Khuyen Mai muon xoa:");
        String ms = input.nextLine();
        xoa(ms);
    }
    public void suaTheoMucKM(String ms, int muc) {
        for (int i = 0; i < n; i++) {
            if (ds[i].getMaKM().equals(ms)) {
                ds[i].setMucKM(muc);
            }
        }
    }
    public void sua() {
        System.out.print("Nhap Ma Khuyen Mai can sua Muc Khuyen Mai:");
        String ms = input.nextLine();
        for (int i = 0; i < n; i++) {
            if (ds[i].getMaKM().equals(ms)) {
                System.out.print("Nhap Muc Khuyen Mai can sua:");
                int newMucKM = input.nextInt();
                ds[i].setMucKM(newMucKM);
            }
        }
    }

    public void timKiemTheoMaKM(String ms) {
        boolean flag = false;
        for (int i = 0; i < n; i++) {
            if (ds[i].getMaKM().equals(ms)) {
                ds[i].xuat();
                System.out.println();
                flag = true;
            }
        }
        if (flag == false) {
            System.out.println("Khong ton tai!");
        }
    }
    public void timKiemTheoMucKM(int mucKM) {
        boolean flag = false;
        for (int i = 0; i < n; i++) {
            if (ds[i].getMucKM() == mucKM){
                ds[i].xuat();
                System.out.println();
                flag = true;
            }
        }
        if (flag == false) {
            System.out.println("Khong ton tai!");
        }
    }

    //Tìm kiếm danh sách có mức khuyến mãi m1 => m2
    public void timKiemTheoMucKM12(int m1, int m2) {
        boolean flag = false;
        for (int i = 0; i < n; i++) {
            if (ds[i].getMucKM() >= m1 && ds[i].getMucKM() <= m2){
                ds[i].xuat();
                System.out.println();
                flag = true;
            }
        }
        if (flag == false) {
            System.out.println("Khong ton tai!");
        }
    }

    public void timKiem() {
        System.out.println("1.Ma Khuyen Mai");
        System.out.println("2.Muc Khuyen Mai");
        System.out.println("3.Cac Ma Khuyen Mai co Muc Khuyen Mai tu m1 => m2");
        System.out.print("Chon thong tin muon tim kiem:");
        int x = input.nextInt();
        input.nextLine();
        switch(x) {
            case 1:
                System.out.print("Nhap Ma Khuyen Mai muon tim:");
                String newMs = input.nextLine();
                timKiemTheoMaKM(newMs);
                break;
            case 2:
                System.out.print("Nhap Muc Khuyen Mai muon tim:");
                int newMuc = input.nextInt();
                timKiemTheoMucKM(newMuc);
                break;
            case 3:
                System.out.print("Tu Muc Khuyen Mai:");
                int m1 = input.nextInt();
                System.out.print("Den Muc Khuyen Mai:");
                int m2 = input.nextInt();
                timKiemTheoMucKM12(m1,m2);
                break;
            default: break;
        }
    }

    public void thongKeTheoMucKM() {
        System.out.println("Thong ke theo Muc Khuyen Mai:");
        int[] count = new int[100];
        for (int i = 0; i < n; i++) {
            count[ds[i].getMucKM()]++;
        }
        for (int i = 0; i < 100; i++) {
            if (count[i] > 0) {
                System.out.println("Danh sach Co " + count[i] + " Ma Khuyen Mai co Muc Khuyen Mai la " + i + "%");
            }
        }
    }

    //Thống kê danh sách có mức khuyến mãi từ m1 => m2
    public void thongKeTheoMucKM12(int m1, int m2) {
        System.out.println("Thong ke theo Muc Khuyen Mai tu " + m1 + " den " + m2 + ":");
        int[] count = new int[100];
        for (int i = 0; i < n; i++) {
            if (ds[i].getMucKM() >= m1 && ds[i].getMucKM() <= m2) {
                count[ds[i].getMucKM()]++;
            }
        }
        for (int i = 0; i < 100; i++) {
            if (count[i] > 0) {
                System.out.println("Danh sach Co " + count[i] + " Ma Khuyen Mai co Muc Khuyen Mai la " + i + "%");
            }
        }
    }

    public void thongKe() {
        System.out.println("1.Muc Khuyen Mai");
        System.out.println("2.Cac Ma Khuyen Mai co Muc Khuyen Mai tu m1 => m2");
        System.out.print("Chon thong tin muon thong ke:");
        int x = input.nextInt();
        switch(x) {
            case 1:
                thongKeTheoMucKM();
                break;
            case 2:
                System.out.println("Tu Muc Khuyen Mai:");
                int m1 = input.nextInt();
                System.out.println("Den Muc Khuyen Mai:");
                int m2 = input.nextInt();
                thongKeTheoMucKM12(m1,m2);
                break;
            default: break;
        }
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
		System.out.println("Cap nhat thanh cong");
	}
	public void DocFileJava(String filename) {
		int i = 0;
		try {
			DataInputStream dis = new DataInputStream(new FileInputStream(filename));
			n = dis.readInt();
			ds = new O_KhuyenMai[n];
			try {
				while (true) {
					int type = dis.readInt(); // Đọc loại đối tượng (1, 2, 3)
                    String MaCT = dis.readUTF();
					String MaKM = dis.readUTF();
					int MucKM = dis.readInt();
					if (type == 2) {
						int MucGia = dis.readInt();
						ds[i] = new O_KhuyenMaiTheoHoaDon(MaCT, MaKM, MucKM, MucGia);
					}
					else if (type == 3) {
						int MaSP = dis.readInt();
						ds[i] = new O_KhuyenMaiTheoSP(MaCT, MaKM, MucKM, MaSP);
					}
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
    public double apdungkm(double Dongia,int MaSP,String ctkm){
        for(int i=0;i<n;i++){
            if (ds[i].getMaCT().equals(ctkm)) {
            if (ds[i] instanceof O_KhuyenMaiTheoSP) {
                if (ds[i].getptkm()==MaSP) {
                    return Dongia-(Dongia*ds[i].getMucKM())/100;
                }
            }
            }
        }
        return Dongia;
    }

}
