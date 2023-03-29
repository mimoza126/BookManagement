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
<title>Insert title here</title>
</head>
<body>
		<h1>ログ</h1>
	<a href="manager_SearchServlet">図書一覧</a>
	<form action="manager_SearchServlet">
	<input type="search" name="name">
			<input type="submit" value="検索">
	</form>
	<table border="1">
			<tr>
				<th>ID</th>
				<th>本の名前</th>
				<th>メールアドレス</th>
				<th>返却日</th>
				<th>返却</th>
			</tr>
	<% request.setCharacterEncoding("UTF-8"); 
	String search=request.getParameter("name");%>
	
	<% List <BookDTO>list= ManagerDAO.searchBookByID(search);
	for(BookDTO e : list){ %> 
		<% List <LendingDTO> list2=ManagerDAO.selectAlllendingDTO();
		for(LendingDTO a : list2) {%>
		<% if(e.getId() == a.getBook_id() )	{ %>
				<% List <UsersDTO> list3=ManagerDAO.selectAllUsersDTO();
		for(UsersDTO w : list3) {%>
			<% if(a.getUser_id() == w.getId()) {%>
			<tr>
			<td><a href="manager_DetailsServlet?id=<%=e.getId() %>"><%=e.getId() %></a></td>
						<td><%=e.getTitle() %></td>
						<td><%=w.getEmail() %></td>
						<td><%=a.getLendin_date() %></td>
						<td><%=a.getReturn_status() %></td>

			</tr>
		<% } %>
		<% } %>
		<% } %>
		<% } %>
	<% } %>
	</table>
</body>
</html>