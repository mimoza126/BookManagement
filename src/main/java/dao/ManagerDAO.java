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
import dto.LendingDTO;
import dto.UsersDTO;

public class ManagerDAO {
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
	 // 本のデータを全件取得する
			public static List<BookDTO> selectAllBookDTO(){
				String sql = "SELECT * FROM book"; 
 				// 返却用変数
 				List<BookDTO> result = new ArrayList<>();

 			
 				
 				try (
 						Connection con = getConnection();
 						PreparedStatement pstmt = con.prepareStatement(sql);
 						){
 					try (ResultSet rs = pstmt.executeQuery()){
 						while(rs.next()) {
 							int id =	rs.getInt("id");
 							String title = rs.getString("title");
 							String author = rs.getString("author");
 							String publisher = rs.getString("publisher");
 							String isbn = rs.getString("isbn");
 							String category = rs.getString("category");
 							String type = rs.getString("type");

 							BookDTO book = new BookDTO(id,title,author,publisher,isbn,category,type);
 							
 							result.add(book);
 						}
 					}
 				} catch (SQLException e) {
 					e.printStackTrace();
 				} catch (URISyntaxException e) {
 					e.printStackTrace();
 				}finally {
 					System.out.println(result + "検索しました。");
 				}

 				// Listを返却する。0件の場合は空のListが返却される。
 				return result;
 			}
			
			 // 履歴のデータ全件取得する
			public static List<LendingDTO> selectAlllendingDTO(){
				String sql = "SELECT * FROM lending"; 
 				// 返却用変数
 				List<LendingDTO> result = new ArrayList<>();

 			
 				
 				try (
 						Connection con = getConnection();
 						PreparedStatement pstmt = con.prepareStatement(sql);
 						){
 					try (ResultSet rs = pstmt.executeQuery()){
 						while(rs.next()) {
 							int id =	rs.getInt("id");
 							int book_id =	rs.getInt("book_id");
 							int user_id =	rs.getInt("user_id");
 							String lending_date = rs.getString("lending_date");
 							String return_date = rs.getString("return_date");
 							String return_status = rs.getString("return_status");
 						

 							LendingDTO lending = new LendingDTO(id,book_id,user_id,lending_date,return_date,return_status);
 							
 							result.add(lending);
 						}
 					}
 				} catch (SQLException e) {
 					e.printStackTrace();
 				} catch (URISyntaxException e) {
 					e.printStackTrace();
 				}finally {
 					System.out.println(result + "検索しました。");
 				}

 				// Listを返却する。0件の場合は空のListが返却される。
 				return result;
 			}
			// usersのデータ全件取得する
						public static List<UsersDTO> selectAllUsersDTO(){
							String sql = "SELECT * FROM users"; 
			 				// 返却用変数
			 				List<UsersDTO> result = new ArrayList<>();

			 			
			 				
			 				try (
			 						Connection con = getConnection();
			 						PreparedStatement pstmt = con.prepareStatement(sql);
			 						){
			 					try (ResultSet rs = pstmt.executeQuery()){
			 						while(rs.next()) {
			 							int id =	rs.getInt("id");
			 							String name =	rs.getString("name");
			 							String email =	rs.getString("email");
			 							String passward = rs.getString("passward");
			 							String salt = rs.getString("salt");
			 							String tell = rs.getString("tell");

			 						

			 							UsersDTO users = new UsersDTO(id,name,email,passward,salt,tell);
			 							
			 							result.add(users);
			 						}
			 					}
			 				} catch (SQLException e) {
			 					e.printStackTrace();
			 				} catch (URISyntaxException e) {
			 					e.printStackTrace();
			 				}finally {
			 					System.out.println(result + "検索しました。");
			 				}

			 				// Listを返却する。0件の場合は空のListが返却される。
			 				return result;
			 			}
    
						// LIKEを使ったキーワード検索(部分一致)
						public static List<BookDTO> searchBookBytitle(String keyword){
							
							// 実行するSQL
							String sql = "SELECT * FROM book WHERE title LIKE ?";
							// ダメな例 String sql = "SELECT * FROM employee WHERE name LIKE %?%";
							// なぜなら値を埋め込むとSELECT * FROM employee WHERE name LIKE %'keyword'%となるから。
							
							// 返却用のListインスタンス
							List<BookDTO> result = new ArrayList<>();
									
							try (
									Connection con = getConnection();	// DB接続
									PreparedStatement pstmt = con.prepareStatement(sql);			// 構文解析
									){
								
								// %や_はここで文字列結合する。そうすると'%keyword%'となる。
								pstmt.setString(1, "%" + keyword + "%");
								
								// SQL実行！
								// ResultSetもcloseする必要があるのでtry-with-resources文を使う
								try (ResultSet rs = pstmt.executeQuery()){
									
									// next()がfalseを返すまでループ
									while(rs.next()) {

										// n行目のデータを取得
										int id =	rs.getInt("id");
			 							String title = rs.getString("title");
			 							String author = rs.getString("author");
			 							String publisher = rs.getString("publisher");
			 							String isbn = rs.getString("isbn");
			 							String category = rs.getString("category");
			 							String type = rs.getString("type");
										// n件目のインスタンスを作成
										BookDTO book = new BookDTO(id,title,author,publisher,isbn,category,type);
										
										// インスタンスをListに追加
										result.add(book);
									}
								}
								
							} catch (SQLException e) {
								e.printStackTrace();
							} catch (URISyntaxException e) {
								e.printStackTrace();
							}

							// Listを返却する。0件の場合は空のListが返却される。
							return result;
						}

						
						
public static List<BookDTO> searchBookByID(int keyword){
							
							// 実行するSQL
							String sql = "SELECT * FROM book WHERE id = ?";
							// ダメな例 String sql = "SELECT * FROM employee WHERE name LIKE %?%";
							// なぜなら値を埋め込むとSELECT * FROM employee WHERE name LIKE %'keyword'%となるから。
							
							// 返却用のListインスタンス
							List<BookDTO> result = new ArrayList<>();
									
							try (
									Connection con = getConnection();	// DB接続
									PreparedStatement pstmt = con.prepareStatement(sql);			// 構文解析
									){
								
								// %や_はここで文字列結合する。そうすると'%keyword%'となる。
								pstmt.setInt(1, keyword );
								
								// SQL実行！
								// ResultSetもcloseする必要があるのでtry-with-resources文を使う
								try (ResultSet rs = pstmt.executeQuery()){
									
									// next()がfalseを返すまでループ
									while(rs.next()) {

										// n行目のデータを取得
										int id =	rs.getInt("id");
			 							String title = rs.getString("title");
			 							String author = rs.getString("author");
			 							String publisher = rs.getString("publisher");
			 							String isbn = rs.getString("isbn");
			 							String category = rs.getString("category");
			 							String type = rs.getString("type");
										// n件目のインスタンスを作成
										BookDTO book = new BookDTO(id,title,author,publisher,isbn,category,type);
										
										// インスタンスをListに追加
										result.add(book);
									}
								}
								
							} catch (SQLException e) {
								e.printStackTrace();
							} catch (URISyntaxException e) {
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
public static int UpdateBook(LendingDTO bo) {
	String sql = "UPDATE lending SET return_status = ? WHERE id = ?";
	int result = 0;
	try (
			Connection con = getConnection();
			PreparedStatement pstmt = con.prepareStatement(sql);
			){
		   pstmt.setString(1, bo.getReturn_status());
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

//引数の社員番号を元にデータを1件 DELETE するメソッド
		public static void deleteBook( int id) {
			String sql = "DELETE FROM book WHERE id = ?";
			int result = 0;

			try (
					Connection con = getConnection();	// DB接続
					PreparedStatement pstmt = con.prepareStatement(sql);			// 構文解析
					){

				pstmt.setInt(1,id);

				result = pstmt.executeUpdate();
			} catch (SQLException e) {
				e.printStackTrace();
			} catch (URISyntaxException e) {
				e.printStackTrace();
			} finally {
				System.out.println(result + "件更新しました。");
			}
		}






						
}

