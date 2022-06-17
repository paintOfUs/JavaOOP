package comunity.HumanResources;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Scanner;
import java.lang.Double;
public class HummanResources {
	static ArrayList<Staff> Employees = new ArrayList<>();
	static HashMap<String, Integer> nameDpt = new HashMap<>();
	static ArrayList<Department> Departments = new ArrayList<>();
	static int slbp = 0;
	static Scanner sc = new Scanner(System.in);
	public static  void main(String[] args) {
		
		while(true){
            System.out.println("\n-------------------------");
            System.out.println("1. Show staffs list");
            System.out.println("2. Show departments");
            System.out.println("3. Show staffs in each departments");
            System.out.println("4. Add a new staff");
            System.out.println("5. Search a staff by name or ID");
            System.out.println("6. Show staffs salary Up");
            System.out.println("7. Show staffs salary Down");
            System.out.println("8. Exit");
            System.out.print("Your choice: ");
            
            int choice = sc.nextInt();

             switch(choice){
             	 case 1:
             		HienthiDanhSach();
             		break;
                 case 2:
                	 HienThiBoPhan();
                    break;
                 case 3:
                	 HienThiTheoBoPhan();
                    break;
                 case 4:
                    NhapDanhSach();
                    break;
                 case 5:
                    Search();
                    break;
                 case 6:
                	 SalaryUp();
                	 break;
                 case 7:
                	 SalaryDown();
                	 break;
                 case 8:
                    System.exit(0);
             }
        
		}
	}
	
	//nhập danh sách
	public static  void NhapDanhSach() {
		System.out.println("===================================");
		System.out.println("nhập danh sách chọn 1 để nhập nhân viên, chọn 2 để nhập chức vụ khác:");
		int select = sc.nextInt();sc.nextLine();
		
		System.out.println("mời bạn nhập thông tin: ");
		System.out.print("mã ID : ");
		String id = sc.nextLine(); id = id.toUpperCase();
		
		System.out.print("Name : ");
		String name = sc.nextLine(); name = name.toUpperCase();
		
		System.out.print("Age : ");
		int age = sc.nextInt();
		
		System.out.print("Hệ số lương: ");
		double HSLuong = sc.nextDouble();
		
		System.out.print("Ngày vào làm: ");
		int NgayVaoLam = sc.nextInt();
		
		System.out.print("Bộ phận làm việc: ");
		String BoPhan = sc.nextLine();
		sc.nextLine();
		//thêm bộ phận 
		if(nameDpt.get(BoPhan)== null) {
			nameDpt.put(BoPhan, slbp);
			String MaBoPhan = "00"+slbp;
			Department myDpt = new Department(MaBoPhan, BoPhan, 1);
			Departments.add(myDpt);
			//tăng số Bộ Phận
			slbp++;
			
		}else {
			//tăng số lượng nhân viên
			int slnv = Departments.get(nameDpt.get(BoPhan)).getSLNhanVien();
			Departments.get(nameDpt.get(BoPhan)).setSLNhanVien(slnv+1);
			
		}
		
		
		System.out.println("Số ngày nghỉ: ");
		int SoNgayNghi = sc.nextInt();
		
		if(select==1) {
			System.out.print("Số giờ làm thêm: ");
			int GioLamThem = sc.nextInt();
			Staff em = new Employee(id, name, age, HSLuong, NgayVaoLam, BoPhan, SoNgayNghi, GioLamThem);
			Employees.add(em);
		}else {
			System.out.print("Chức Danh: ");
			String ChucDanh = sc.nextLine();
			Staff em = new Manager(id, name, age, HSLuong, NgayVaoLam, BoPhan, SoNgayNghi, ChucDanh);
			Employees.add(em);
			System.out.println("Đã thêm nhân viên vào danh sách");
		}
		
	}
	
	//hiển thị danh sách
	public static void HienthiDanhSach() {
		System.out.println(String.format("%-10s%-20s%-10d%-10.2f%-10d%-10s%-10d%-10d%-10.2f","Mã", "Tên","tuổi", "HSLuong", "Ngày cào làm", "Bộ phân","Số ngày nghỉ", "giờ làm thêm", "lương"));
		for (Staff x : Employees) {
			System.out.println(x.tostring());
		}
	}	
	
	//hiển thị các bộ phận trong công ty
	public static void HienThiBoPhan() {
		if(Departments.size()==0) {
			System.out.println("không có bộ phận nào trong công ty !");
			return;
		}
		System.out.println(String.format("%-20s%-20s%-20s","mã bộ phân","tên bộ phân", "số lượng nhân viên"));
		for(Department x: Departments) {
			System.out.println(String.format("%-20s%-20s%-20s",x.getMaBoPhan(), x.getBoPhan(), x.getSLNhanVien()));
		}
	}
	
	//hiển thị nhân viên theo từng bộ phận
	public static void HienThiTheoBoPhan() {
		for (String maBoPhan : nameDpt.keySet()) {
			System.out.println("bô phận "+maBoPhan+"trong công ty :");
			for(Staff x: Employees) {
				if(x.getBoPhan().equals(maBoPhan)) {
					System.out.println(x.tostring());
				}
			}
		}
	}
	
	//tìm kiếm nhân viên	
	public static void Search() {
		String SearchKey = "";
		System.out.print("nhập id hoặc tên nhân viên để tìm kiếm:");
		SearchKey = sc.nextLine(); 
		SearchKey = SearchKey.toUpperCase();
		
		ArrayList<Staff> emFound = new ArrayList<>();
		for(Staff x: Employees) {
			if(x.getId().contains(SearchKey) || x.getName().contains(SearchKey)) {
				emFound.add(x);
			}
		}
		if(emFound.isEmpty()) {
			System.out.println("không tìm thấy nhân viên");
		}
		else {
			for(Staff x: emFound) {
				System.out.println(x.tostring());
			}
		}
	}
	
	//sắp xếp lương giảm dần
	public static void SalaryUp() {
		ArrayList<Staff> salaryUp = new ArrayList<>();
		salaryUp.addAll(Employees);
		Collections.sort(salaryUp, (a, b)->(int) (a.Salary()- b.Salary()));
		
		
	}
	
	public static void SalaryDown() {
		ArrayList<Staff> salaryDown = new ArrayList<>();
		salaryDown.addAll(Employees);
		Collections.sort(salaryDown, (a, b)->(int) (a.Salary()- b.Salary()));
		Collections.reverse(salaryDown);
	}
}
