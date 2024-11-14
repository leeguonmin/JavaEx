package JavaTest;

public class Customer extends User {
	private int point;
	
	public Customer(String id, String pw, String name, int point) {
		super(id,pw,name);
		this.point=point;
		
	}

	public int getPoint() {
		return point;
	}

	public void setPoint(int point) {
		this.point = point;
	}
	
	
	// toString()
//	@Override
//	public String toString() {
//		return String.format("아이디:%s비번:%s\t이름:%s", id, pw, name);
//	}
	
	@Override
	public String toString() {
		return super.toString()+point;
	}
	
	
	@Override
	public void showInfo() {
		System.out.printf("아이디:%s	비번:%s	이름:%s	포인트:%s%n", getId(), getpW(), getName(), point);
	}



	
	

}
