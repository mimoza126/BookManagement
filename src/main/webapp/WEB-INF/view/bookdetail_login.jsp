<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ page import="dto.BookDTO" %>
<%@ page import="dao.BookDAO" %>
<%@ page import = "dto.ReviewDTO" %>
<%@ page import="java.util.List" %>
<%@ page import="java.util.ArrayList" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title></title>
</head>
<body>
<%List<BookDTO> list = (ArrayList<BookDTO>)request.getAttribute("list");
	for(BookDTO s : list) {
	%>
	<h2><%=s.getIsbn() %></h2>
	<h2><%=s.getTitle() %></h2>
	<p>(著)  <%=s.getAuthor() %></p><p>出版社  <%=s.getPublisher() %></p>
		
	

	<a href = "ReviewWrite?id=<%=s.getId() %>">口コミを書く</a>

	<%} %>
	<%List<ReviewDTO> review = (ArrayList<ReviewDTO>)request.getAttribute("review");
	for(ReviewDTO a : review) {
		%>
		
		<h2><%=a.getTitle() %></h2>
		<h2><%=a.getComment() %></h2>
		<%} %>
</body>
</html>