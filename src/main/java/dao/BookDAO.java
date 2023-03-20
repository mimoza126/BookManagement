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
import dto.BooklistDTO;

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
	
	public static List<BooklistDTO> SelectAllBook(){
		
		// 実行するSQL
		String sql = "SELECT DISTINCT title,author,publisher FROM book";
		
		// 返却用のListインスタンス
		List<BooklistDTO> result = new ArrayList<>();
				
		try (
				Connection con = getConnection();
				PreparedStatement pstmt = con.prepareStatement(sql);
				){
			
			try (ResultSet rs = pstmt.executeQuery()){
				
				while(rs.next()) {

					// n行目のデータを取得
					String title = rs.getString("title");
					String author = rs.getString("author");
					String publisher = rs.getString("publisher");

					
					// n件目のインスタンスを作成
					BooklistDTO book = new BooklistDTO(title, author, publisher);
					
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
	
public static List<BooklistDTO> SelectSearchBook(String cate){
		
		// 実行するSQL
		String sql = "SELECT DISTINCT title,author,publisher FROM book WHERE category = ?";
		
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
					String title = rs.getString("title");
					String author = rs.getString("author");
					String publisher = rs.getString("publisher");
					
					// n件目のインスタンスを作成
					BooklistDTO book = new BooklistDTO(title, author, publisher);
					
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
	String sql = "SELECT DISTINCT title,author,publisher FROM book WHERE title = ?";
	
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
				String title = rs.getString("title");
				String author = rs.getString("author");
				String publisher = rs.getString("publisher");

				
				// n件目のインスタンスを作成
				BooklistDTO book = new BooklistDTO(title, author, publisher);
				
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
}
