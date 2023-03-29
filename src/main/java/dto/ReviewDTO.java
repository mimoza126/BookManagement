package dto;

public class ReviewDTO {
	private int id;
	private int book_id;
	private String title;
	private String comment;
	

	public ReviewDTO(int id, int book_id, String title, String comment) {
		super();
		this.id = id;
		this.book_id = book_id;
		this.title = title;
		this.comment = comment;
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
	
	
	public String getTitle() {
		return title;
	}
	
	public void setTitle(String title) {
		this.title = title;
	}
	
	public String getComment() {
		return comment;
	}
	
	public void setComment(String comment) {
		this.comment = comment;
	}
	
	
	
}
