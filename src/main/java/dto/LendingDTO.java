package dto;

public class LendingDTO {
	int id;
	int book_id;
	int user_id;
	String lendin_date;
	String return_date;
	String return_status;
	public LendingDTO(int id, int book_id, int user_id, String lendin_date, String return_data,
			String return_status) {
		super();
		this.id = id;
		this.book_id = book_id;
		this.user_id = user_id;
		this.lendin_date = lendin_date;
		this.return_date = return_data;
		this.return_status = return_status;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getBook_id() {
		return book_id;
	}
	public void setBook_id(int book_id) {
		this.book_id = book_id;
	}
	public int getUser_id() {
		return user_id;
	}
	public void setUser_id(int user_id) {
		this.user_id = user_id;
	}
	public String getLendin_date() {
		return lendin_date;
	}
	public void setLendin_date(String lendin_date) {
		this.lendin_date = lendin_date;
	}
	
	public String getReturn_data() {
		return return_date;
	}
	public void setReturn_data(String return_data) {
		this.return_date = return_data;
	}
	public String getReturn_status() {
		return return_status;
	}
	public void setReturn_status(String return_status) {
		this.return_status = return_status;
	}
}
