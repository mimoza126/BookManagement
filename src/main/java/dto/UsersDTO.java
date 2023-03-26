package dto;

public class UsersDTO {
	int id;
	String name;
	String email;
	String passward;
	String salt;
	String tell;
	public UsersDTO(int id, String name, String email, String passward, String salt, String tell) {
		super();
		this.id = id;
		this.name = name;
		this.email = email;
		this.passward = passward;
		this.salt = salt;
		this.tell = tell;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
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
	public String getPassward() {
		return passward;
	}
	public void setPassward(String passward) {
		this.passward = passward;
	}
	public String getSalt() {
		return salt;
	}
	public void setSalt(String salt) {
		this.salt = salt;
	}
	public String getTell() {
		return tell;
	}
	public void setTell(String tell) {
		this.tell = tell;
	}
	
}
