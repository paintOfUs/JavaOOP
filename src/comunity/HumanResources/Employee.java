package comunity.HumanResources;

public class Employee extends Staff implements ICalculator  {
	private int GioLamThem;

	public Employee(String id, String name, int age, double HSLuong, int ngayVaoLam, String boPhan, int soNgayNghi,
			int gioLamThem) {
		super(id, name, age, HSLuong, ngayVaoLam, boPhan, soNgayNghi);
		GioLamThem = gioLamThem;
	}


	public int getGioLamThem() {
		return GioLamThem;
	}


	public void setGioLamThem(int gioLamThem) {
		GioLamThem = gioLamThem;
	}

	@Override
	public double Salary() {
		return getHSLuong()*3000000 + GioLamThem*200000;
	}
	
	@Override
	public String tostring() {
		// TODO Auto-generated method stub
		return  String.format("%-10s%-20s%-10d%-10.2f%-10d%-10s%-10d%-10d%-10.2f", getId(), getName(), getAge(), getHSLuong(), getNgayVaoLam(), getBoPhan(), getSoNgayNghi(), getGioLamThem(), Salary());
	}

}

