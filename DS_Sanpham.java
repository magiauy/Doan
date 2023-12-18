import java.util.Scanner;
import java.io.*;
import java.util.Arrays;
public class DS_Sanpham implements DanhSach{
	private int n;
	private int a = 0;
	private int max = 1000;
	private O_SanPham[] sp;
	public DS_Sanpham(){

	}
	public DS_Sanpham(int n){
		sp= new O_SanPham[n];
	}
	public void nhap(){
		Scanner Scanner = new Scanner(System.in);
		System.out.print("Nhap so luong san pham: ");
		n=Scanner.nextInt();
		sp= new O_SanPham[n];
		for (int i =0;i<n ;i++ ) {
			System.out.println("Nhap lua chon");
			System.out.println("1.Nhap but ");
			System.out.println("2.Nhap vo ");
			System.out.println("3.Nhap sp khac ");
			int c = Scanner.nextInt();
			switch (c) {
				case 1:
					sp[i]=new O_But();
					sp[i].nhap();
					break;
				case 2:
					sp[i]=new O_Vo();
					sp[i].nhap();
				case 3:
					sp[i]=new O_SanPham();
					sp[i].nhap();
				default:
					break;
				}
			}
		
		}
	
	public void xuat(){
		System.out.println("Danh Sach San Pham");
		System.out.format("%-8s %-20s %-8s %-8s %-8s %-8s \n",
		"MaSP", "TenSP", "SoLuong", "DonGia", "DonVi", "MaLoai");
			for (int i=0;i<n ;i++ ) {
			sp[i].xuat();
		}
	}
	public void them(O_SanPham sp1){
		
		sp = Arrays.copyOf(sp, sp.length + 1);
			this.sp[n]=sp1;
			n++;
	
	}
	public void them(){
		if (n<max) {
			sp = Arrays.copyOf(sp, sp.length + 1);
			Scanner Scanner = new Scanner(System.in);
			System.out.println("Chon loai san pham");
			System.out.println("1.Them but");
			System.out.println("2.Them vo");
			System.out.println("3.Them san pham khac");
			int c = Scanner.nextInt();	
			switch (c) {
				case 1:
					System.out.println("Nhap thong tin but can them ");
					O_But newbut = new O_But();
					newbut.nhap();
					sp[n]=newbut;
					n++;
					break;
				case 2:
					System.out.println("Nhap thong tin vo can them ");
					O_Vo newvo = new O_Vo();
					newvo.nhap();
					sp[n]=newvo;
					n++;
					break;
				case 3:
					System.out.println("Nhap thong tin sp can them ");
					O_SanPham newsp = new O_SanPham();
					newsp.nhap();
					sp[n]=newsp;
					n++;
					break;
				default:
					break;
			}
		
		}
		else{
			System.out.println("Danh sach da day");
		}

	}
	public void xoa(){
		int tempMaSP;
		boolean daTimThay = false;
		Scanner Scanner = new Scanner(System.in);
		System.out.println("Nhap MaSP can xoa: ");
		tempMaSP=Scanner.nextInt();
		for (int i=0;i<n ;i++ ) {
			if (tempMaSP==sp[i].getMaSP()) {
				for(int j=i;j<n-1;j++){
					sp[j]=sp[j+1];
			}
		}
			sp = Arrays.copyOf(sp, sp.length-1);
			n--;
			daTimThay=true;
			System.out.println("San pham da duoc xoa");
			break;
		}
		if (!daTimThay) {
			System.out.println("Khong tim thay san pham voi MaSP: "+tempMaSP);
		}
		
	}
	public void xoa(int MaSP){
		int tempMaSP=MaSP;
		boolean daTimThay = false;
		for (int i=0;i<n ;i++ ) {
			if (tempMaSP==sp[i].getMaSP()) {
				for (int j=i;j<n ;j++ ) {
					sp[j]=sp[j+1];
				}
			}
			sp = Arrays.copyOf(sp, sp.length + 1);
			n--;
			daTimThay=true;
			System.out.println("San pham da duoc xoa");
			break;
		}
		if (!daTimThay) {
			System.out.println("Khong tim thay san pham voi MaSP: "+tempMaSP);
		}

	}
	public void sua(){
		Scanner Scanner = new Scanner(System.in);
		System.out.println("Con muc can sua ");
		System.out.println("1.Sua MaSP");
		System.out.println("2.Sua TenSP");
		System.out.println("3.Sua So Luong");
		System.out.println("4.Sua Don Gia");
		System.out.println("5.Sua Don Vi");
		System.out.println("6.Sua ma loai");
		int c = Scanner.nextInt();
		switch (c) {
					case 1:
						fixMaSP();
						break;
					case 2:
						fixTenSP();
						break;
					case 3:
						fixSoLuong();
						break;
					case 4:
						fixDonGia();
						break;
					case 5:
						fixDonVi();
						break;
					case 6:
						fixMaLoai();
						break;
					default:
						break;
						
				}
		GhiFileJava("../src/Sanpham.txt");
		}
	public void fixMaSP(){
		Scanner Scanner = new Scanner(System.in);
		System.out.println("Nhap MaSp ");
		int tempMaSP = Scanner.nextInt();
		System.out.println("MaSP moi");
		int fixsp = Scanner.nextInt();
		for (int i=0;i<n ;i++ ) {
			if (tempMaSP==sp[i].getMaSP()) {
				sp[i].setMaSP(fixsp);
				break;
			}
		}
		System.out.println("Da thay the thanh cong");
		
	}
	public void fixMaSP(int tempMaSP,int fixsp){
		for (int i=0;i<n ;i++ ) {
			if (tempMaSP==sp[i].getMaSP()) {
				sp[i].setMaSP(fixsp);
				break;
			}
		}
		System.out.println("Da thay the thanh cong");
	}
	public void fixTenSP(){
		Scanner Scanner = new Scanner(System.in);
		System.out.print("Nhap MaSP can thay ten: ");
		int tempMaSP= Scanner.nextInt();
		System.out.print("Nhap ten moi: ");
		String fixTen=Scanner.nextLine();
		for (int i=0;i<n ;i++ ) {
			if (tempMaSP==sp[i].getMaSP()) {
				sp[i].setTenSP(fixTen);
				break;
			}
		}
		System.out.println("Da thay the thanh cong");
		

	}
	public void fixTenSP(int tempMaSP,String fixTen){
		for (int i=0;i<n ;i++ ) {
			if (tempMaSP==sp[i].getMaSP()) {
				sp[i].setTenSP(fixTen);
				break;
			}
		}
		System.out.println("Da thay the thanh cong");
	}
	public void fixSoLuong(){
		Scanner Scanner = new Scanner(System.in);
		System.out.print("Nhap MaSP can thay doi: ");
		int tempMaSP=Scanner.nextInt();
		System.out.print("Nhap so luong moi: ");
		int fixSoLuong=Scanner.nextInt();
		for (int i=0;i<n ;i++ ) {
			if (tempMaSP==sp[i].getMaSP()) {
				sp[i].setSoLuong(fixSoLuong);
				break;
			}
		}
		System.out.println("Da thay the thanh cong");

	}
	public void fixSoLuong(int tempMaSP , int fixSoLuong){
		for (int i=0;i<n ;i++ ) {
			if (tempMaSP==sp[i].getMaSP()) {
				sp[i].setSoLuong(fixSoLuong);
				break;
			}
		}
		System.out.println("Da thay the thanh cong");
	}
	public void fixDonGia(){
		Scanner Scanner = new Scanner(System.in);
		System.out.println("Nhap MaSP can thay doi: ");
		int tempMaSP=Scanner.nextInt();
		System.out.println("Nhap DonGia moi: ");
		int fixDonGia = Scanner.nextInt();
		for (int i=0;i<n ;i++ ) {
			if (tempMaSP==sp[i].getMaSP()) {
				sp[i].setDonGia(fixDonGia);
				break;
			}
		}
		System.out.println("Da thay the thanh cong");
		
	}
	
	public void fixDonGia(int tempMaSP , int fixDonGia){
		for (int i=0;i<n ;i++ ) {
			if (tempMaSP==sp[i].getMaSP()) {
				sp[i].setDonGia(fixDonGia);
				break;
			}
		}
		System.out.println("Da thay the thanh cong");
	}
	public void fixDonVi(){
		Scanner Scanner = new Scanner(System.in);
		System.out.print("Nhap MaSP can thay doi: ");
		int tempMaSP=Scanner.nextInt();
		System.out.print("Nhap DonVi can thay doi: ");
		String fixDonVi=Scanner.nextLine();
		for (int i=0;i<n ;i++ ) {
			if (tempMaSP==sp[i].getMaSP()) {
				sp[i].setDonVi(fixDonVi);
				break;
			}
		}
		System.out.println("Da thay the thanh cong");
		
	}
	public void fixDonVi(int tempMaSP, String fixDonVi){
		for (int i=0;i<n ;i++ ) {
			if (tempMaSP==sp[i].getMaSP()) {
				sp[i].setDonVi(fixDonVi);
				break;
			}
		}
		System.out.println("Da thay the thanh cong");
	}
	public void fixMaLoai(){
		Scanner Scanner = new Scanner(System.in);
		System.out.print("Nhap MaSP can thay doi: ");
		int tempMaSP=Scanner.nextInt();
		System.out.println("Nhap ma loai moi: ");
		int fixMaLoai=Scanner.nextInt();
		for (int i=0;i<n ;i++ ) {
			if (tempMaSP==sp[i].getMaSP()) {
				sp[i].setMaLoai(fixMaLoai);
				break;
			}
		}
		System.out.println("Da thay the thanh cong");
		

			}
	public void fixMaLoai(int tempMaSP ,int fixMaLoai){
		for (int i=0;i<n ;i++ ) {
			if (tempMaSP==sp[i].getMaSP()) {
				sp[i].setMaLoai(fixMaLoai);
				break;
			}
		}
		System.out.println("Da thay the thanh cong");
	}
	public void find(){
		Scanner Scanner = new Scanner(System.in);
		System.out.println("Chon phuong thuc tim kiem");
		System.out.println("1.Tim kiem theo MASP");
		System.out.println("2Tim kiem theo Ten SP");
		System.out.println("3.Tiem kiem theo khoang gia");
		System.out.print("Nhập lựa chọn: ");
		int c = Scanner.nextInt();
		switch (c) {
			case 1:
				findMaSP();
				break;
			case 2:
				findTenSP();
				break;
			case 3:
				findkhoangia();
			default:
				break;
		}
	}
	public void findMaSP(){
		Scanner Scanner = new Scanner(System.in);
		System.out.println("Nhap ma SP can tiem");
		int tempMaSP=Scanner.nextInt();
		for(int i=0;i<n;i++){
			if (sp[i].getMaSP()==tempMaSP) {
				sp[i].xuat();
			}
		}
		
	}
	public void findMaSP(int tempMaSP){
		for(int i=0;i<n;i++){
			if (sp[i].getMaSP()==tempMaSP) {
				sp[i].xuat();
			}
		}

	}
	public void findTenSP(){
		Scanner Scanner = new Scanner(System.in);
		System.out.println("Nhap ten sp can tim");
		String tempTenSP=Scanner.nextLine();
		for(int i=0 ;i<n;i++){
			if (sp[i].getTenSP().contains(tempTenSP)) {
				sp[i].xuat();
			}
		}
		
	}
	public void findTenSP(String tempTenSP){
		for(int i=0 ;i<n;i++){
			if (sp[i].getTenSP().contains(tempTenSP)) {
				sp[i].xuat();
			}
		}
	}
	public void findkhoangia(){
		Scanner Scanner = new Scanner(System.in);
		System.out.print("Nhap gia khoi diem: ");
		int tempgia1=Scanner.nextInt();
		System.out.print("Nhap gia ket thuc");
		int tempgia2=Scanner.nextInt();
		for(int i=0;i<n;i++){
			if (tempgia1<=sp[i].getDonGia()&&sp[i].getDonGia()<=tempgia2) {
				sp[i].xuat();
			}
		}
		
	}
	public void findkhoangia(int tempgia1,int tempgia2){
		for(int i=0;i<n;i++){
			if (tempgia1<=sp[i].getDonGia()&&sp[i].getDonGia()<=tempgia2) {
				sp[i].xuat();
			}
		}
	}
	public void thongke(){
		Scanner Scanner = new Scanner(System.in);
		System.out.println("Chon phuong thuc thong ke ");
		System.out.println("1.Thong ke theo loai ");
		System.out.println("2.Thong ke theo gia ");
		int c = Scanner.nextInt();
		switch (c) {
			case 1:
				// thongkeloai();
				break;
			case 2:
				//thongkegia();
				break;
		
			default:
				break;
		}
		
	}
	// public void thongkeloai() {
	// 	int[] coutloai = new int[m+1];
		
	
	// 	for (int i = 0; i < n; i++) {
	// 		coutloai[sp[i].getMaLoai()]++;
	// 	}
	// 	String header = String.format("%-12s |%s", "Loại ", "Số Lượng");
	// 	System.out.println(header);
	// 	System.out.println("------------------------");
	
	// 	for (int i = 1; i <= m; i++) {
	// 		if (coutloai[i] > 0) {
	// 			String loai = l[i-1].getTenLoai();
	// 			String soLuong = String.valueOf(coutloai[i]);
	// 			String thongke = String.format("%-12s | %s", loai, soLuong);
	// 			System.out.println(thongke);
	// 		}
	// 	}
	// }
	public void GhiFileJava(String filename) {
		try {
			
			DataOutputStream dos = new DataOutputStream(new FileOutputStream(filename));
			dos.writeInt(n);
			try {
				for(int i = 0; i < n; i++) {
					sp[i].GhiFile(filename);
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
			sp = new O_SanPham[n];
			try {
				while (true) {
					int type = dis.readInt(); // Đọc loại đối tượng (1, 2, 3)
					int MaSP = dis.readInt();
					String TenSP = dis.readUTF();
					int Soluong = dis.readInt();
					int DonGia = dis.readInt();
					String DonVi = dis.readUTF();
					int MaLoai = dis.readInt();
					if(type == 1) {
						sp[i] = new O_SanPham(MaSP, TenSP, Soluong, DonGia, DonVi, MaLoai);
					}
					else if(type == 2) {
						String Mau = dis.readUTF();
						sp[i] = new O_But(MaSP, TenSP, Soluong, DonGia, DonVi, MaLoai,Mau);
					}
					else if (type == 3) {
						int SoTrang = dis.readInt();
						String ChatLuongGiay = dis.readUTF();
						sp[i]= new O_Vo(MaSP, TenSP, Soluong, DonGia, DonVi, MaLoai,SoTrang,ChatLuongGiay);
					}
					i++;
				}
			} catch (EOFException e) {
				// End of file reached
			} finally {
				a = i;
				dis.close();
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public int Truyengiasanpham(int MaSP){
		for(int i=0 ;i<n;i++){
			if (sp[i].getMaSP()==MaSP) {
				return sp[i].getDonGia();
			}
		}
		return -1;
	}
	public int TruyenSoLuong(int MaSP){
		for(int i=0;i<n;i++){
			if (sp[i].getMaSP()==MaSP) {
				return sp[i].getSoluong();
			}
		}
		return 0;
	}
	public String getTenSP(int MaSP){
		for(int i=0;i<n;i++){
			if (sp[i].getMaSP()==MaSP) {
				return sp[i].getTenSP();
			}
		}
		return null;
	}
	public void setSoLuonghd(int MaSP,int newsl){
		for(int i=0;i<n;i++){
			if (sp[i].getMaSP()==MaSP) {
				sp[i].setSoLuong(sp[i].getSoluong() - newsl) ;
			}
		}
	}
	
	public void setSoLuongpn(int MaSP,int newsl){
		for(int i=0;i<n;i++){
			if (sp[i].getMaSP()==MaSP) {
				sp[i].setSoLuong(sp[i].getSoluong() + newsl) ;
			}
		}
	}
	public boolean checkSP(int id){
		for(int i=0 ;i<n;i++){
			if (sp[i].getMaSP()==id) {
				return true;
			}
		}
		return false;
	}
	public boolean checktontai(int id){
		for(int i=0;i<n;i++){
			if (sp[i].getMaSP()==id) {
				return true;
			}
		}
		return false;
	}	



}