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
<title>編集・削除</title>
</head>
<body>
<% request.setCharacterEncoding("UTF-8");
int book_id=Integer.parseInt(request.getParameter("id"));%>
<form action="manager_DeletecomfirmServlet">
 <table>
 <tr>
  <th>ID</th>
 </tr>
<% List <BookDTO>list= ManagerDAO.searchBookByID(book_id);
	for(BookDTO e : list){ %> 
		<tr>
			<td><%=e.getId() %></td>
		</tr>
		
	<% } %>
 </table>
		<input type = "radio" name = "type" value = "新　←→　旧">新　←→　旧		
		<input type = "radio" name = "delete" value = "削除">削除	
		<a href="">戻る</a>
				<input type="submit" value="確定">
</form>
</body>
</html>