package JavaTest;

public class Staff extends User {
	int salary;
	
	
	
	public Staff(String id, String pw, String name, int salary) {
		super(id,pw,name);
		this.salary=salary;
		
	}
	

	public int getSalary() {
		return salary;
	}

	public void setSalary(int salary) {
		this.salary = salary;
	}
	
	
	// toStirng 
	@Override
	public String toString() {
		return super.toString()+salary;
	}
	
	
	@Override
	public void showInfo() {								
		System.out.printf("아이디:%s	비번:%s	이름:%s	월급:%s%n", getId(), getpW(), getName(), salary);
	}
	

}
