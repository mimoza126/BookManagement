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
	<% request.setCharacterEncoding("UTF-8");
	int i;%>
	<table border="1">
	<tr>
	<td>本のID</td><td><%=i=Integer.parseInt(request.getParameter("id")) %></td>
	</tr>
		<% List <BookDTO>list1= ManagerDAO.selectAllBookDTO();
for(BookDTO a : list1){ %>
<% if( i == a.getId()) {%>
<tr>
		<td>本の名前</td><td><%=a.getTitle() %></td>
</tr>
		<% } %>
		<% } %>
		
		<% List <LendingDTO>list2= ManagerDAO.selectAlllendingDTO();
		 List <UsersDTO>list3= ManagerDAO.selectAllUsersDTO();
		int user=0; %>
<% for(LendingDTO e : list2){ %>
<% if( i == e.getBook_id()) {%>
		<% user=e.getUser_id(); %>
		<% } %>
<% } %>	
		


<%for(UsersDTO b : list3){ %>
<% if( user == b.getId()) {%>

	<tr>
		<td>借りた人</td><td><%=b.getName() %></td>
</tr>

	<tr>
		<td>メールアドレス</td><td><%=b.getEmail() %></td>
</tr>		

	<tr>
		<td>電話番号</td><td><%=b.getTell() %></td>
</tr>		

<% } %>
<% } %>
		
		
		<% List <LendingDTO>list4= ManagerDAO.selectAlllendingDTO(); %>
<% for(LendingDTO q : list4){ %>
<% if( i == q.getBook_id()) {%>
	<tr>
		<td>貸し出し日</td><td><%=q.getLendin_date() %></td>
</tr>

<tr>
		<td>返却日</td><td><%=q.getReturn_data() %></td>
</tr>			
		<% } %>
<% } %>	

</table>
	<a href="managerReturnServlet?id=<%=i %>">返却</a>
		<a href="manager_logServlet">戻る</a>
	
	
</body>
</html>