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
<meta charset="UTF-8">
<title>履歴</title>
</head>
<body>

	<h1>ログ</h1>
	<a href="manager_SearchServlet">図書一覧</a>
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