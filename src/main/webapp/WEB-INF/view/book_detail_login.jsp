<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="dto.BookDTO" %>
<%@ page import="dao.BookDAO" %>
<%@ page import="dto.ReviewDTO" %>
<%@ page import="java.util.List" %>
<%@ page import="java.util.ArrayList" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet" href="css/style.css">
<title>Insert title here</title>
</head>
<body>
	<br><br><br>
	<%
	List<BookDTO> list = (ArrayList<BookDTO>)request.getAttribute("list");
	for(BookDTO s : list) {
	%>
	<h2><%=s.getTitle() %></h2>
	<p>(著)  <%=s.getAuthor() %> &nbsp; &nbsp; 出版社  <%=s.getPublisher() %></p>
	<br><br><br>
	<%} %>
	<%
	List<ReviewDTO> review = (ArrayList<ReviewDTO>)request.getAttribute("review");
	for(ReviewDTO a : review) {
	%>
	
	<a href="BookBorrowServlet">借りる</a>
	<a href="BookReviewServlet?id=<%=s.getId()%>">口コミを書く</a>
	<%} %>
	<h2><%=a.getTitle() %></h2>
		<h2><%=a.getComment() %></h2>
</body>
</html>