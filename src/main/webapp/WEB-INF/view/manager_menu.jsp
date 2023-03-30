<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
    <%@ page import="java.util.List" %>
    <%@ page import="java.util.ArrayList" %>
    <%@ page import="dto.BooklistDTO" %>
    <%@ page import="dao.BookDAO" %>
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
<title>Insert title here</title>
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
            <li class="nav_item"><a href="LoginServlet">ログアウト</a></li>
          </ul>
        </nav>
   
      </div>
    </header>

	<ul class="category-list">
	  <li class="category-item"><a href="BookListServlet">すべて</a> </li>
	  <li class="category-item"><a href="BookSearchlist?category=文芸">文芸</a></li>
	  <li class="category-item"><a href="BookSearchlist?category=実用書">実用書</a></li>
	  <li class="category-item"><a href="BookSearchlist?category=ビジネス書・経済・経営">ビジネス書・経済・経営</a></li>
	  <li class="category-item"><a href="BookSearchlist?category=絵本・児童書">絵本・児童書</a></li>
	  <li class="category-item"><a href="BookSearchlist?category=学習参考書">学習参考書</a></li>
	  <li class="category-item"><a href="BookSearchlist?category=専門書">専門書</a></li>
	  <li class="category-item"><a href="BookSearchlist?category=コミック・雑誌">コミック・雑誌</a></li>
	</ul>
	<br>
	<table border="1">
	<tr>
		<th>図書名</th><th>出版社</th><th>著者</th>
	</tr>
	<%List<BookDTO> list = ManagerDAO.selectAllBookDTO();
	for(BookDTO s : list) {
	%>
	<tr>
		<td><a href="managerBookDetailServlet?title=<%=s.getTitle()%>"><%=s.getTitle()%></a></td>
		<td><%=s.getPublisher()%></td>
		<td><%=s.getAuthor()%></td>
	</tr>
	<%} %>
	</table>
</body>
</html>