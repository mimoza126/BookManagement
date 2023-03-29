package dto;

public class BooklistDTO {
	private int book_id;
	private String title;
	private String author;
	private String publisher;

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

	public String getAuthor() {
		return author;
	}

	public void setAuthor(String author) {
		this.author = author;
	}

	public String getPublisher() {
		return publisher;
	}

	public void setPublisher(String publisher) {
		this.publisher = publisher;
	}

	public BooklistDTO(int book_id, String title, String author, String publisher) {
		super();
		this.book_id = book_id;
		this.title = title;
		this.author = author;
		this.publisher = publisher;
	}
	
	

	
}