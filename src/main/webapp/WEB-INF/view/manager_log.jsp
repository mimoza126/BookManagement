<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ page import="dto.UsersDTO" %>
<%@ page import="dto.LendingDTO" %>
<%@ page import="dto.BookDTO" %>
<%@ page import="dao.ManagerDAO" %>
<%@ page import="java.util.*" %>
<!DOCTYPE html>
<html>
<head>
<link rel="stylesheet" href="css/style.css">
<meta charset="UTF-8">
<title>履歴title>
</head>
<body>
<header class="header">
      <!-- ヘッダーロゴ -->
      <div class="logo">管理者</div>
    
      <!-- ハンバーガーメニュー部分 -->
      <div class="nav">
    
        <!-- ハンバーガーメニューの表示・非表示を切り替えるチェックボックス -->
        <input id="drawer_input" class="drawer_hidden" type="checkbox">
    
        <!-- ハンバーガーアイコン -->
        <label for="drawer_input" class="drawer_open"><span></span></label>
    
        <!-- メニュー -->
        <nav class="nav_content">
          <ul class="nav_list">
            <li class="nav_item"><a href="managerMenuServlet">図書一覧</a></li>
            <li class="nav_item"><a href="manager_logServlet">ログ</a></li>
            <li class="nav_item"><a href="BookRegester">登録</a></li>
            <li class="nav_item"><a href="">ログアウト</a></li>
          </ul>
        </nav>
   
      </div>
    </header>


	<a href="managerMenuServlet">図書一覧</a>

	<form action="manager_SearchServlet">
	<input type="search" name="name">
			<input type="submit" value="検索">
	</form>
		<% int book;
		String name;
		int meilnumber;
		request.setCharacterEncoding("UTF-8");%>
	<table border="1">
	<tr>
	<th>ID</th>
		<th>本の名前</th>
			<th>メールアドレス</th>
				<th>返却日</th>
					<th>返却</th>
	</tr>
	<% List <LendingDTO>list= ManagerDAO.selectAlllendingDTO(); 
for(LendingDTO e : list){ %>
<tr>
<% book=e.getBook_id(); %>
	<td><a href="manager_DetailsServlet?id=<%=e.getBook_id() %>"><%=e.getBook_id() %></a></td>
		<% List <BookDTO>list2= ManagerDAO.selectAllBookDTO();
for(BookDTO a : list2){ %>
<% if(book == a.getId()) {%>
		<td><%=name=a.getTitle() %></td>
		<% } %>
		<% } %>
		<% meilnumber=e.getUser_id(); %>
		<% List <UsersDTO>list3= ManagerDAO.selectAllUsersDTO();
for(UsersDTO b : list3){ %>
<% if(meilnumber == b.getId() ) {%>
	<td><%=b.getEmail() %></td>
<% } %>
<% } %>
	
	<td><%=e.getReturn_data() %></td>
		<td><%=e.getReturn_status() %></td>
</tr>

<% } %>

	</table>
		
</body>
</html>