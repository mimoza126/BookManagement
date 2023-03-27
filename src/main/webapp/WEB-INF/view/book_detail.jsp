<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="dto.BooklistDTO" %>
<%@ page import="dao.BookDAO" %>
<%@ page import="java.util.List" %>
<%@ page import="java.util.ArrayList" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<%List<BooklistDTO> list = (ArrayList<BooklistDTO>)request.getAttribute("list");
	for(BooklistDTO s : list) {
	%>
	<h2><%=s.getTitle() %></h2>
	<p>(著)  <%=s.getAuthor() %></p><p>出版社  <%=s.getPublisher() %></p>
	
	
	<a href="BookReviewServlet?isbn=<%=s.getIsbn()%>">口コミを書く</a>
	<%} %>
</body>
</html>