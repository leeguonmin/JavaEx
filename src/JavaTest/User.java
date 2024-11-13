package JavaTest;

public abstract class User {
	// 선언
	private String id;
	private String pw;
	private String name;
//	String id;
//	String pw;
//	String name;
	
	public User() {
		
	}
	
	// 생성자
	public User(String id, String pw, String name) {
		this.id=id;
		this.pw=pw;
		this.name=name;
		
	}

	// getter, setter 우회접근 아녀..?ㅠ
	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getpW() {
		return pw;
	}

	public void setpW(String pw) {
		this.pw = pw;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	
	
//	// toStirng 
//	public String toString() {
//		return String.format("아이디:%s\t비번:%s\t이름:%s", id, pw, name);
//	}
	
	

	public String toString() {
		return "User [id=" + id + ", pw=" + pw + ", name=" + name + "]";
	}

	
	public void showInfo() {
		
	}
	
	
	

}
