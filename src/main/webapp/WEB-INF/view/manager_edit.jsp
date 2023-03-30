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
<title>編集画面</title>
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


	<% request.setCharacterEncoding("UTF-8"); 
	String title= request.getParameter("title"); %>
<h1><%=title %></h1>


	<table border="1">
	<tr>
		<th>ID</th>
				<th>新/旧</th>
	</tr>

	<% List <BookDTO> list =ManagerDAO.selectAllBookDTO(); %>
	<% for( BookDTO e : list ){	%>
	
	<% if(title.equals(e.getTitle()) ) {%>
	<tr>
		<td><a href="managerEditdetailsServlet?id=<%=e.getId() %>"><%=e.getId() %> </a></td>

		<td><%=e.getType() %> </td>
	</tr>
	
	<% } %>
	<% } %>
	
	</table>
</body>
</html>