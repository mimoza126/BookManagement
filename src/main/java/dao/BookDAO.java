package dao;

import java.net.URI;
import java.net.URISyntaxException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import dto.BookDTO;
import dto.ReviewDTO;
import dto.BooklistDTO;
import dto.ReviewDTO;

public class BookDAO {
	private static Connection getConnection()throws URISyntaxException, SQLException {
		try {
			Class.forName("org.postgresql.Driver");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	    URI dbUri = new URI(System.getenv("DATABASE_URL"));

	    String username = dbUri.getUserInfo().split(":")[0];
	    String password = dbUri.getUserInfo().split(":")[1];
	    String dbUrl = "jdbc:postgresql://" + dbUri.getHost() + ':' + dbUri.getPort() + dbUri.getPath();

	    return DriverManager.getConnection(dbUrl, username, password);
	}
	public static int RegisterBook(BookDTO bo) {
		String sql = "INSERT INTO book VALUES(default, ?, ?, ?, ? ,? ,?)";
		int result = 0;
		try (
				Connection con = getConnection();
				PreparedStatement pstmt = con.prepareStatement(sql);
				){
			pstmt.setString(1, bo.getTitle());
			pstmt.setString(2, bo.getAuthor());
			pstmt.setString(3,bo.getPublisher());
			pstmt.setString(4,bo.getIsbn());
			pstmt.setString(5, bo.getCategory());
			pstmt.setString(6,bo.getType());
			result = pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (URISyntaxException e) {
			e.printStackTrace();
		} finally {
			System.out.println(result + "件更新しました。");

		}
		return result;
	}
	
	
	public static int RegisterReview(ReviewDTO re) {
		String sql = "INSERT INTO review VALUES(default,?,?,?)";
		int result = 0;
		try (
				Connection con = getConnection();
				PreparedStatement pstmt = con.prepareStatement(sql);
				){

			pstmt.setInt(1, re.getBook_id());
			pstmt.setString(2,re.getTitle());
			pstmt.setString(3,re.getComment());
			result = pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (URISyntaxException e) {
			e.printStackTrace();
		} finally {
			System.out.println(result + "件更新しました。");

		}
		return result;
	}

public static List<ReviewDTO> SelectAllReview(){
		
		// 実行するSQL
		String sql = "SELECT * FROM review WHERE book_id = ?";
		
		// 返却用のListインスタンス
		List<ReviewDTO> result = new ArrayList<>();
				
		try (
				Connection con = getConnection();
				PreparedStatement pstmt = con.prepareStatement(sql);
				){
			
			try (ResultSet rs = pstmt.executeQuery()){
				
				while(rs.next()) {

					// n行目のデータを取得
					int id = rs.getInt("id");
					int book_id = rs.getInt("book_id");
					String title = rs.getString("title");
					String comment = rs.getString("comment");

					
					// n件目のインスタンスを作成
					ReviewDTO review = new ReviewDTO(id,book_id, title,comment);
					
					// インスタンスをListに追加
					result.add(review);
				}
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}catch (URISyntaxException e) {
			e.printStackTrace();
		}

		// Listを返却する。0件の場合は空のListが返却される。
		return result;
	}
	
	
		// 実行するSQL

		String sql = "SELECT DISTINCT id,title,author,publisher FROM book WHERE category = ?";
		
		// 返却用のListインスタンス
		List<BooklistDTO> result = new ArrayList<>();
				

		try (
				Connection con = getConnection();
				PreparedStatement pstmt = con.prepareStatement(sql);
				){
			

			pstmt.setString(1, SerchCategoryName);
			pstmt.setString(2,SerchName);
			try (ResultSet rs = pstmt.executeQuery()){
				while(rs.next()) {
					
					int id = rs.getInt("id");
          
			pstmt.setString(1, cate);
			
			try (ResultSet rs = pstmt.executeQuery()){
				
				while(rs.next()) {

					// n行目のデータを取得
					int book_id = rs.getInt("id");
					String title = rs.getString("title");
					String author = rs.getString("author");
					String publisher = rs.getString("publisher");
					String isbn = rs.getString("isbn");
					String category = rs.getString("category");
					String type = rs.getString("type");
	
					BookDTO book = new BookDTO(id ,title , author , publisher , isbn , category , type);
					
					result.add(book);
					
				}
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (URISyntaxException e) {
			e.printStackTrace();
		} finally {
			System.out.println(result + "件商品を検索しました。");
		}
		return result;
	}
	
	
	
					
					// n件目のインスタンスを作成

					BooklistDTO book = new BooklistDTO(book_id,title, author, publisher);
					
					// インスタンスをListに追加
					result.add(book);
				}
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}catch (URISyntaxException e) {
			e.printStackTrace();
		}

		// Listを返却する。0件の場合は空のListが返却される。
		return result;
	}

public static List<BooklistDTO> SearchBook(String title){
	
	// 実行するSQL
	String sql = "SELECT DISTINCT title,author,publisher,isbn FROM book WHERE title like ?";
	
	// 返却用のListインスタンス
	List<BooklistDTO> result = new ArrayList<>();
			
	try (
			Connection con = getConnection();
			PreparedStatement pstmt = con.prepareStatement(sql);
			){
		
		pstmt.setString(1, "%" + title + "%");
		
		try (ResultSet rs = pstmt.executeQuery()){
			
			while(rs.next()) {

				// n行目のデータを取得
				String title1 = rs.getString("title");
				String author = rs.getString("author");
				String publisher = rs.getString("publisher");
				String isbn = rs.getString("isbn");
				
				// n件目のインスタンスを作成
				BooklistDTO book = new BooklistDTO(title1, author, publisher, isbn);
				
				// インスタンスをListに追加
				result.add(book);
			}
		}
		
	} catch (SQLException e) {
		e.printStackTrace();
	}catch (URISyntaxException e) {
		e.printStackTrace();
	}

	// Listを返却する。0件の場合は空のListが返却される。
	return result;
}

public static List<BooklistDTO> SelectBookDetail(String cate){
	
	// 実行するSQL

	String sql = "SELECT DISTINCT id,title,author,publisher FROM book WHERE title = ?";
	
	// 返却用のListインスタンス
	List<BooklistDTO> result = new ArrayList<>();
			
	try (
			Connection con = getConnection();
			PreparedStatement pstmt = con.prepareStatement(sql);
			){
		
		pstmt.setString(1, cate);
		
		try (ResultSet rs = pstmt.executeQuery()){
			
			while(rs.next()) {

				// n行目のデータを取得
				int book_id = rs.getInt("id");
				String title = rs.getString("title");
				String author = rs.getString("author");
				String publisher = rs.getString("publisher");

				
				// n件目のインスタンスを作成
				BooklistDTO book = new BooklistDTO(book_id,title, author, publisher);
				
				// インスタンスをListに追加
				result.add(book);
			}
		}
		
	} catch (SQLException e) {
		e.printStackTrace();
	}catch (URISyntaxException e) {
		e.printStackTrace();
	}

	// Listを返却する。0件の場合は空のListが返却される。
	return result;
}

public static List<BookDTO> AndBookSerch(String serchName , String SerchCategory) {
	String serchname="%"+serchName+"%";
	String serchcategory = "%"+SerchCategory+"%";
	
	String sql = "select * from book where title LIKE ? AND category LIKE ? ";
	List<BookDTO>result=new ArrayList<>();
	try (
			Connection con = getConnection();
			PreparedStatement pstmt = con.prepareStatement(sql);
			){
		pstmt.setString(1,serchname);
		pstmt.setString(2, serchcategory);
		try (ResultSet rs = pstmt.executeQuery()){
			while(rs.next()) {
				int id = rs.getInt("id");
				String title = rs.getString("title");
				String author = rs.getString("author");
				String publisher = rs.getString("publisher");
				String isbn = rs.getString("isbn");

				String category = rs.getString("category");
				String type = rs.getString("type");
				
				BookDTO book = new BookDTO(id , title , author,publisher,isbn ,category , type);		
				result.add(book);
				
			}
		}
	} catch (SQLException e) {
		e.printStackTrace();
	} catch (URISyntaxException e) {
		e.printStackTrace();
	} finally {
		System.out.println(result + "件商品を検索しました。");
	}
	return result;
}
public static List<BookDTO> SelectBook(String ti){
	
	// 実行するSQL
	String sql = "SELECT DISTINCT title,author,publisher,isbn,category,type FROM book WHERE title = ?";
	
	// 返却用のListインスタンス
	List<BookDTO> result = new ArrayList<>();
			
	try (
			Connection con = getConnection();
			PreparedStatement pstmt = con.prepareStatement(sql);
			){
		
		pstmt.setString(1, ti);
		
		try (ResultSet rs = pstmt.executeQuery()){
			
			while(rs.next()) {

				// n行目のデータを取得
				
				String title = rs.getString("title");
				String author = rs.getString("author");
				String publisher = rs.getString("publisher");
				String isbn = rs.getString("isbn");
				String category = rs.getString("category");
				String type = rs.getString("type");
				
				
				// n件目のインスタンスを作成
				BookDTO book = new BookDTO(0,title, author, publisher,isbn,category,type);

				
				// インスタンスをListに追加
				result.add(book);
			}
		}
		
	} catch (SQLException e) {
		e.printStackTrace();
	}catch (URISyntaxException e) {
		e.printStackTrace();
	}

	// Listを返却する。0件の場合は空のListが返却される。
	return result;
}
public static int UpdateBook(BookDTO bo) {
	String sql = "UPDATE book SET type = ? WHERE id = ?";
	int result = 0;
	try (
			Connection con = getConnection();
			PreparedStatement pstmt = con.prepareStatement(sql);
			){
		   pstmt.setString(1, bo.getType());
           pstmt.setInt(2, bo.getId());
		result = pstmt.executeUpdate();
	} catch (SQLException e) {
		e.printStackTrace();
	} catch (URISyntaxException e) {
		e.printStackTrace();
	} finally {
		System.out.println(result + "件編集しました。");

	}
	return result;
}
public static List<BookDTO> SelectAllBookD(){
	
	// 実行するSQL
	String sql = "SELECT * FROM book";
	
	// 返却用のListインスタンス
	List<BookDTO> result = new ArrayList<>();
			
	try (
			Connection con = getConnection();
			PreparedStatement pstmt = con.prepareStatement(sql);
			){
		
		try (ResultSet rs = pstmt.executeQuery()){
			
			while(rs.next()) {

				// n行目のデータを取得
				int id = rs.getInt("id");
				String title = rs.getString("title");
				String author = rs.getString("author");
				String publisher = rs.getString("publisher");
				String isbn = rs.getString("isbn");
				String category = rs.getString("category");
				String type = rs.getString("type");

				
				// n件目のインスタンスを作成
				BookDTO book = new BookDTO(id,title, author, publisher,isbn,category,type);
				
				// インスタンスをListに追加
				result.add(book);
			}
		}
		
	} catch (SQLException e) {
		e.printStackTrace();
	}catch (URISyntaxException e) {
		e.printStackTrace();
	}

	// Listを返却する。0件の場合は空のListが返却される。
	return result;
}
public static List<BookDTO> SelectBookTitle(String ti){
	
	// 実行するSQL
	String sql = "SELECT * FROM book WHERE title = ?";
	
	// 返却用のListインスタンス
	List<BookDTO> result = new ArrayList<>();
			
	try (
			Connection con = getConnection();
			PreparedStatement pstmt = con.prepareStatement(sql);
			){
		
		pstmt.setString(1, ti);
		
		try (ResultSet rs = pstmt.executeQuery()){
			
			while(rs.next()) {

				// n行目のデータを取得
				int id = rs.getInt("id");
				String title = rs.getString("title");
				String author = rs.getString("author");
				String publisher = rs.getString("publisher");
				String isbn = rs.getString("isbn");
				String category = rs.getString("category");
				String type = rs.getString("type");
				
				
				// n件目のインスタンスを作成
				BookDTO book = new BookDTO(id,title, author, publisher,isbn,category,type);
				
				// インスタンスをListに追加
				result.add(book);
			}
		}
		
	} catch (SQLException e) {
		e.printStackTrace();
	}catch (URISyntaxException e) {
		e.printStackTrace();
	}

	// Listを返却する。0件の場合は空のListが返却される。
	return result;
}
public static List<BookDTO> SelectBookId(int book_id){
	
	// 実行するSQL
	String sql = "SELECT * FROM book WHERE id = ?";
	
	// 返却用のListインスタンス
	List<BookDTO> result = new ArrayList<>();
			
	try (
			Connection con = getConnection();
			PreparedStatement pstmt = con.prepareStatement(sql);
			){
		
		pstmt.setInt(1, book_id);
		
		try (ResultSet rs = pstmt.executeQuery()){
			
			while(rs.next()) {

				// n行目のデータを取得
				int id = rs.getInt("id");
				String title = rs.getString("title");
				String author = rs.getString("author");
				String publisher = rs.getString("publisher");
				String isbn = rs.getString("isbn");
				String category = rs.getString("category");
				String type = rs.getString("type");
				
				
				// n件目のインスタンスを作成
				BookDTO book = new BookDTO(id,title, author, publisher,isbn,category,type);
				
				// インスタンスをListに追加
				result.add(book);
			}
		}
		
	} catch (SQLException e) {
		e.printStackTrace();
	}catch (URISyntaxException e) {
		e.printStackTrace();
	}

	// Listを返却する。0件の場合は空のListが返却される。
	return result;
}
public static List<BookDTO> SelectSearchBookCategory(String cate){
	
	// 実行するSQL
	String sql = "SELECT * FROM book WHERE category = ?";
	
	// 返却用のListインスタンス
	List<BookDTO> result = new ArrayList<>();
			
	try (
			Connection con = getConnection();
			PreparedStatement pstmt = con.prepareStatement(sql);
			){
		
		pstmt.setString(1, cate);
		
		try (ResultSet rs = pstmt.executeQuery()){
			
			while(rs.next()) {

				// n行目のデータを取得
				int id = rs.getInt("id");
				String title = rs.getString("title");
				String author = rs.getString("author");
				String publisher = rs.getString("publisher");
				String isbn = rs.getString("isbn");
				String category = rs.getString("category");
				String type = rs.getString("type");
				
				
				// n件目のインスタンスを作成
				BookDTO book = new BookDTO(id,title, author, publisher,isbn,category,type);
				
				// インスタンスをListに追加
				result.add(book);
			}
		}
		
	} catch (SQLException e) {
		e.printStackTrace();
	}catch (URISyntaxException e) {
		e.printStackTrace();
	}

	// Listを返却する。0件の場合は空のListが返却される。
	return result;
}
public static List<ReviewDTO> SelectAllReviewId(int review_id){
	
	// 実行するSQL
	
	String sql = "SELECT * FROM review "
			+ "INNER JOIN book "
			+ "ON book.id = review.book_id "
			+ "WHERE book.id = ?";
	
	// 返却用のListインスタンス
	List<ReviewDTO> result = new ArrayList<>();
			
	try (
			Connection con = getConnection();
			PreparedStatement pstmt = con.prepareStatement(sql);
			){
		pstmt.setInt(1, review_id);
		
		try (ResultSet rs = pstmt.executeQuery()){
			
			while(rs.next()) {

				// n行目のデータを取得
				int id = rs.getInt("id");
				int book_id = rs.getInt("book_id");
				String title = rs.getString("title");
				String comment = rs.getString("comment");

				
				// n件目のインスタンスを作成
				ReviewDTO review = new ReviewDTO(id,book_id, title,comment);
				
				// インスタンスをListに追加
				result.add(review);
			}
		}
		
	} catch (SQLException e) {
		e.printStackTrace();
	}catch (URISyntaxException e) {
		e.printStackTrace();
	}

	// Listを返却する。0件の場合は空のListが返却される。
	return result;
}


}
