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
		String sql = "SELECT DISTINCT title,author,publisher,isbn FROM book";
		
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
					String isbn = rs.getString("isbn");

					
					// n件目のインスタンスを作成
					BooklistDTO book = new BooklistDTO(title, author, publisher, isbn);
					
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
	
public static List<BooklistDTO> CategorySearchBook(String cate){
		
		// 実行するSQL
		String sql = "SELECT DISTINCT title,author,publisher,isbn FROM book WHERE category = ?";
		
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
					String isbn = rs.getString("isbn");
					
					// n件目のインスタンスを作成
					BooklistDTO book = new BooklistDTO(title, author, publisher, isbn);
					
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

public static List<BookDTO> SelectBookDetail(String cate){
	
	// 実行するSQL
	String sql = "SELECT * FROM book WHERE title = ? LIMIT 1";
	
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
				int id = Integer.parseInt(rs.getString("id"));
				String title = rs.getString("title");
				String author = rs.getString("author");
				String publisher = rs.getString("publisher");
				String isbn = rs.getString("isbn");
				String category = rs.getString("category");
				String type = rs.getString("type");
				
				// n件目のインスタンスを作成
				BookDTO book = new BookDTO(id, title, author, publisher, isbn, category, type);
				
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

public static int selectBookCount(String keyword) {
    int count = 0;
    String sql = "SELECT COUNT(*) FROM book WHERE title LIKE ?";
    try (
        Connection con = getConnection();
        PreparedStatement pstmt = con.prepareStatement(sql);
    ) {
        pstmt.setString(1, "%" + keyword + "%");
        try (ResultSet rs = pstmt.executeQuery()) {
            if (rs.next()) {
                count = rs.getInt(1);
            }
        }
    } catch (SQLException e) {
        e.printStackTrace();
    } catch (URISyntaxException e) {
        e.printStackTrace();
    }
    return count;
}


}
