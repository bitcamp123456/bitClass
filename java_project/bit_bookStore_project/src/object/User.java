package object;

public class User {
	private int		userId;		// ���� ������ȣ
	private String	userName;	// ���� �̸�
	private String	password;	// ���� �н�����
	private String	name;		// ���� �̸�   !���� �α��ξ��̵�(userName)�� �����̸�(name) ����!
	private String	email;		// ���� �̸���
	private String	phnum;		// ���� �ڵ��� ��ȣ
	private String	address;	// ���� �ּ� 
	

	public User(int userId, String userName, String password, String name, String email, String phnum, String address) {
		super();
		this.userId = userId;
		this.userName = userName;
		this.password = password;
		this.name = name;
		this.email = email;
		this.phnum = phnum;
		this.address = address;
	}
	
	
	
	@Override
	public String toString() {
		return "User [userId=" + userId + ", userName=" + userName + ", password=" + password + ", name=" + name
				+ ", email=" + email + ", phnum=" + phnum + ", address=" + address + "]";
	}



	public int getUserId() {
		return userId;
	}
	public void setUserId(int userId) {
		this.userId = userId;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPhnum() {
		return phnum;
	}
	public void setPhnum(String phnum) {
		this.phnum = phnum;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	
	
}
