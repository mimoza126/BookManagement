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
<title>削除</title>
</head>
<body>

<h1>この本を削除しますか？</h1>
<table>
<tr>
<th>ID</th>
<th>ISBN</th>
<th>図書名</th>
</tr>
<% int id =Integer.parseInt(request.getParameter("id")); %>
<% List <BookDTO> list =ManagerDAO.searchBookByID(id);
for(BookDTO e : list) {%>
	<tr>
	<td><%=e.getId() %></td>	
	<td><%=e.getIsbn()%></td>	
	<td><%=e.getTitle() %></td>	
	</tr>
	
<% } %>
</table>

<a href="#">いいえ</a>
<a href="#">はい</a>
</body>
</html>