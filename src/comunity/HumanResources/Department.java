package comunity.HumanResources;

public class Department {
	public String maBoPhan;
	public String boPhan;
	public int SLNhanVien;
	
	public Department(String maBoPhan, String boPhan, int SLNhanVien) {
		this.maBoPhan = maBoPhan;
		this.boPhan = boPhan;
		this.SLNhanVien = SLNhanVien;
	}

	public String getMaBoPhan() {
		return maBoPhan;
	}

	public void setMaBoPhan(String maBoPhan) {
		this.maBoPhan = maBoPhan;
	}

	public String getBoPhan() {
		return boPhan;
	}

	public void setBoPhan(String boPhan) {
		this.boPhan = boPhan;
	}

	public int getSLNhanVien() {
		return SLNhanVien;
	}

	public void setSLNhanVien(int sLNhanVien) {
		SLNhanVien = sLNhanVien;
	}

	
}
