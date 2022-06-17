package comunity.HumanResources;

public abstract class Staff  {
	private  String id;
	private  String name;
	private  int age;
	private  double HSLuong;
	private  int NgayVaoLam;
	private  String BoPhan;
	private  int SoNgayNghi;
	
	
	
	public Staff(String id, String name, int age, double hSLuong, int ngayVaoLam, String boPhan, int soNgayNghi) {
		super();
		this.id = id;
		this.name = name;
		this.age = age;
		HSLuong = hSLuong;
		NgayVaoLam = ngayVaoLam;
		BoPhan = boPhan;
		SoNgayNghi = soNgayNghi;
	}
	
	

	public String getId() {
		return id;
	}



	public void setId(String id) {
		this.id = id;
	}



	public String getName() {
		return name;
	}



	public void setName(String name) {
		this.name = name;
	}



	public int getAge() {
		return age;
	}



	public void setAge(int age) {
		this.age = age;
	}



	public double getHSLuong() {
		return HSLuong;
	}



	public void setHSLuong(double hSLuong) {
		HSLuong = hSLuong;
	}



	public int getNgayVaoLam() {
		return NgayVaoLam;
	}



	public void setNgayVaoLam(int ngayVaoLam) {
		NgayVaoLam = ngayVaoLam;
	}



	public String getBoPhan() {
		return BoPhan;
	}



	public void setBoPhan(String boPhan) {
		BoPhan = boPhan;
	}



	public int getSoNgayNghi() {
		return SoNgayNghi;
	}



	public void setSoNgayNghi(int soNgayNghi) {
		SoNgayNghi = soNgayNghi;
	}


	
	//trừu tượng phương thức tostring
	public abstract String tostring();
	
	public abstract double Salary();

	
}

