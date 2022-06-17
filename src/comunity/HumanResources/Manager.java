package comunity.HumanResources;

public  class Manager extends Staff implements ICalculator  {
	private  String ChucDanh;
	private int LuongTrachNhiem;
	
	
	
	public Manager(String id, String name, int age, double hSLuong, int ngayVaoLam, String boPhan, int soNgayNghi,
			String chucDanh) {
		super(id, name, age, hSLuong, ngayVaoLam, boPhan, soNgayNghi);
		ChucDanh = chucDanh;
	}

	public String getChucDanh() {
		return ChucDanh;
	}

	public void setChucDanh(String chucDanh) {
		ChucDanh = chucDanh;
	}

	@Override
	public double Salary() {
		// TODO Auto-generated method stub
		if(ChucDanh.equals("Business Leader")) {
			LuongTrachNhiem = 8000000;
		}else if(ChucDanh.equals("Project Leader")) {
			LuongTrachNhiem = 5000000;
		}else {
			LuongTrachNhiem = 6000000;
		}
		
		return getHSLuong()*5000000 + LuongTrachNhiem;
	}
	
	@Override
	public String tostring() {
		// TODO Auto-generated method stub
		 return String.format("%-10s%-20s%-10d%-10.2f%-10d%-10s%-10d%-10s%-10.2f", getId(), getName(), getAge(), getHSLuong(), getNgayVaoLam(), getBoPhan(), getSoNgayNghi(), getChucDanh(), Salary());
	}
	
}
	

