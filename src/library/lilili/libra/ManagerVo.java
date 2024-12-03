package library.lilili.libra;

public class ManagerVo {
	private int manager_id;
	private String manager_name;
	private String manager_email;
	private String manager_phone;
	private String manager_nameid;
	private String manager_password;
	
	
	
	public ManagerVo(int manager_id, String manager_name, String manager_email, String manager_phone,
			String manager_nameid, String manager_password) {
		super();
		this.manager_id = manager_id;
		this.manager_name = manager_name;
		this.manager_email = manager_email;
		this.manager_phone = manager_phone;
		this.manager_nameid = manager_nameid;
		this.manager_password = manager_password;
	}



	public ManagerVo(String manager_nameid, String manager_password) {
		super();
		this.manager_nameid = manager_nameid;
		this.manager_password = manager_password;
	}



	public int getManager_id() {
		return manager_id;
	}



	public void setManager_id(int manager_id) {
		this.manager_id = manager_id;
	}



	public String getManager_name() {
		return manager_name;
	}



	public void setManager_name(String manager_name) {
		this.manager_name = manager_name;
	}



	public String getManager_email() {
		return manager_email;
	}



	public void setManager_email(String manager_email) {
		this.manager_email = manager_email;
	}



	public String getManager_phone() {
		return manager_phone;
	}



	public void setManager_phone(String manager_phone) {
		this.manager_phone = manager_phone;
	}



	public String getManager_nameid() {
		return manager_nameid;
	}



	public void setManager_nameid(String manager_nameid) {
		this.manager_nameid = manager_nameid;
	}



	public String getManager_password() {
		return manager_password;
	}



	public void setManager_password(String manager_password) {
		this.manager_password = manager_password;
	}



	@Override
	public String toString() {
		return "ManagerVo [manager_id=" + manager_id + ", manager_name=" + manager_name + ", manager_email="
				+ manager_email + ", manager_phone=" + manager_phone + ", manager_nameid=" + manager_nameid
				+ ", manager_password=" + manager_password + "]";
	}
	
	
	



	
	
	
	

}
