<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="dto.BookDTO" %>
<%@ page import="dao.BookDAO" %>
<%@ page import = "dto.ReviewDTO" %>
<%@ page import="java.util.List" %>
<%@ page import="java.util.ArrayList" %>
<!DOCTYPE html>
<html>
<link rel = "stylesheet" href = "css/style.css">
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC" crossorigin="anonymous">
<head>
<meta charset="UTF-8">
<title>図書詳細</title>
</head>
<body>
	<%
	List<BookDTO> list = (ArrayList<BookDTO>)request.getAttribute("list");
	for(BookDTO s : list) {
	%>
	<h2><%=s.getIsbn() %></h2>
	<h2><%=s.getTitle() %></h2>
	<p>(著)  <%=s.getAuthor() %></p><p>出版社  <%=s.getPublisher() %></p>
		
	<%} %>
	<%
	List<ReviewDTO> review = (ArrayList<ReviewDTO>)request.getAttribute("review");
	for(ReviewDTO a : review) {
	%>
		
		<h2><%=a.getTitle() %></h2>
		<h2><%=a.getComment() %></h2>
		<%} %>
		
</body>
</html>