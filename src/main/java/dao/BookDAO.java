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
	public static List<BookDTO> SearchBook(String SerchCategory,String Serch) {
		String  SerchCategoryName = "%"+SerchCategory+"%";
		String SerchName = "%"+Serch+"%";
		
		
		String sql = "select * from book where category LIKE ? AND title LIKE ?";
		List<BookDTO>result=new ArrayList<>();
		try (
				Connection con = getConnection();
				PreparedStatement pstmt = con.prepareStatement(sql);
				){
			
			pstmt.setString(1, SerchCategoryName);
			pstmt.setString(2,SerchName);
			try (ResultSet rs = pstmt.executeQuery()){
				while(rs.next()) {
					
					int id = rs.getInt("id");
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
	
	
}
