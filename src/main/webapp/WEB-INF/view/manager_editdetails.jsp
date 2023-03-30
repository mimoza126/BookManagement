<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
   <%@ page import="dto.UsersDTO" %>
<%@ page import="dto.LendingDTO" %>
<%@ page import="dto.BookDTO" %>
<%@ page import="dao.ManagerDAO" %>
<%@ page import="java.util.*" %>
<%@ page import="javax.servlet.ServletException" %>
<%@ page import="javax.servlet.annotation.WebServlet" %>
<%@ page import="javax.servlet.http.HttpServlet" %>
<%@ page import="javax.servlet.http.HttpServletRequest" %>
<%@ page import="javax.servlet.http.HttpServletResponse" %>
<%@ page import="javax.servlet.http.HttpSession" %>
<%@ page import="javax.servlet.RequestDispatcher" %>
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
            <li class="nav_item"><a href="">ログアウト</a></li>
          </ul>
        </nav>
   
      </div>
    </header>

<% request.setCharacterEncoding("UTF-8");
int book_id=Integer.parseInt(request.getParameter("id"));
System.out.print("ここには来てる"+book_id);%>

<form action="manager_DeletecomfirmServlet?id=<%=book_id %>">
 <table border="1">
 <tr>
  <th>ID</th>
 </tr>
<% List <BookDTO>list= ManagerDAO.searchBookByID(book_id);
	for(BookDTO e : list){%>
		<tr>
			<td><%=e.getId() %></td>
		</tr>
		
 </table>
	
		<input type = "radio" name = "type" value = "<%=e.getId()%>">新　←→　旧		<br>
		<input type = "radio" name = "type" value = "<%=e.getId()%>">削除	<br>
		<a href="managerEditingServlet">戻る</a>
				<input type="submit" value="確定">
				<% } %>
</form>
</body>
</html>