package library.libra;

public class UserVo {

	// 수업시간 예시 변수
//	private Long authorId;
//	private String authorName;
//	private String authorDesc;
//	private Date regdate;
	
//	public LibraryVo() {
//		
//	}
	
	// 회원정보를 담는 클래스
	private Long customersId;
	private String customersName;
	private String customersEmail;
	private String Password;
	private String customersphone_number;
	private String name_id;
	
	
	public UserVo() {}


	public UserVo(Long customersId, String customersName, String customersEmail, String password,
			String customersphone_number, String name_id) {
		super();
		this.customersId = customersId;
		this.customersName = customersName;
		this.customersEmail = customersEmail;
		Password = password;
		this.customersphone_number = customersphone_number;
		this.name_id = name_id;
	}


	public UserVo(String password, String name_id) {
		super();
		Password = password;
		this.name_id = name_id;
	}


	public Long getCustomersId() {
		return customersId;
	}


	public void setCustomersId(Long customersId) {
		this.customersId = customersId;
	}


	public String getCustomersName() {
		return customersName;
	}


	public void setCustomersName(String customersName) {
		this.customersName = customersName;
	}


	public String getCustomersEmail() {
		return customersEmail;
	}


	public void setCustomersEmail(String customersEmail) {
		this.customersEmail = customersEmail;
	}


	public String getPassword() {
		return Password;
	}


	public void setPassword(String password) {
		Password = password;
	}


	public String getCustomersphone_number() {
		return customersphone_number;
	}


	public void setCustomersphone_number(String customersphone_number) {
		this.customersphone_number = customersphone_number;
	}


	public String getName_id() {
		return name_id;
	}


	public void setName_id(String name_id) {
		this.name_id = name_id;
	}


	@Override
	public String toString() {
		return "UserVo [customersId=" + customersId + ", customersName=" + customersName + ", customersEmail="
				+ customersEmail + ", Password=" + Password + ", customersphone_number=" + customersphone_number
				+ ", name_id=" + name_id + "]";
	}


	



}
