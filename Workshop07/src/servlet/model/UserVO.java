package servlet.model;

public class UserVO {
	private String id;
	private String password;
	private String name;

	
	public UserVO() {}
	public UserVO(String userId, String password, String name) {
		this.id = id;
		this.password = password;
		this.name = name;
	}
	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
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
	
	@Override
	public String toString() {
		return "UserVO [id=" + id + ", password=" + password + ", name=" + name + "]";
	}

}
