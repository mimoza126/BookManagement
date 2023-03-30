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
<title>編集画面</title>
</head>
<body>

	<table border="1">
	<tr>
		<th>ID</th>
				<th>新/旧</th>
	</tr>
	<% request.setCharacterEncoding("UTF-8"); 
	String title= request.getParameter("title"); %>
	<% List <BookDTO> list =ManagerDAO.selectAllBookDTO();
	for( BookDTO e : list ){	%>
	<% if(title == e.getTitle()) {%>
	<tr>
		<td><a href="managerEditdetailsServlet?id<%=e.getId() %>"><%=e.getId() %> </a></td>
		<td><%=e.getType() %> </td>
	</tr>
	
	<% } %>
	<% } %>
	
	</table>
</body>
</html>