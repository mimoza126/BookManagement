package dto;

public class Account {
	private String name;
	private String mail;
	private String phone_number;
	private String salt;
	private String password;
	private String hashedPassword;
	
	public Account(String name, String mail, String phone_number, String salt,
			String password, String hashedPassword) {
		super();
		this.name = name;
		this.mail = mail;
		this.phone_number = phone_number;
		this.salt = salt;
		this.password = password;
		this.hashedPassword = hashedPassword;
	}
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getMail() {
		return mail;
	}
	public void setMail(String mail) {
		this.mail = mail;
	}
	public String getPhone_number() {
		return phone_number;
	}
	public void setPhone_number(String phone_number) {
		this.phone_number = phone_number;
	}
	public String getSalt() {
		return salt;
	}
	public void setSalt(String salt) {
		this.salt = salt;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getHashedPassword() {
		return hashedPassword;
	}
	public void setHashedPassword(String hashedPassword) {
		this.hashedPassword = hashedPassword;
	}
	
	
}
