package day5_inherittance;

public class Application {

	public static void main(String[] args) {
		SinhVien sv1 = new SinhVien();
		sv1.setHoTen("Nguyen Van SV1");
		sv1.setDiaChi("Ha Noi");
		sv1.setNgaySinh("1/1/2001");
		sv1.GPA = 4.5;
		System.out.println(sv1.getHoTen() + ", " + sv1.getDiaChi() + ", " + sv1.getNgaySinh() + ", " + sv1.GPA);
		sv1.diHoc();
		sv1.diChoi();
		System.out.println();
		
		GiaoVien gv1 = new GiaoVien();
		gv1.setHoTen("Le Van GV1");
		gv1.setDiaChi("Ha Noi");
		gv1.setNgaySinh("12/1/1977");
		gv1.monHoc = "Auto test";
		System.out.println(gv1.getHoTen() + ", " + gv1.getDiaChi() + ", " + gv1.getNgaySinh() + ", " + gv1.monHoc);
		gv1.diDay();
		gv1.diChoi();
	}

}
