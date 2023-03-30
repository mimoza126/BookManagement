<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="dto.BookDTO" %>
<%@ page import="dao.BookDAO" %>
<%@ page import="java.util.List" %>
<%@ page import="java.util.ArrayList" %>
<!DOCTYPE html>
<html>
<head>
<link rel="stylesheet" href="css/style.css">
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<%List<BookDTO> list = (ArrayList<BookDTO>)request.getAttribute("list");
	for(BookDTO s : list) {
	%>
	<h2><%=s.getTitle() %></h2>
	<p>(著)  <%=s.getAuthor() %></p><p>出版社  <%=s.getPublisher() %></p>
	
	<a href="Test">借りる</a>
	
	<a href="BookReviewServlet?id=<%=s.getId()%>">口コミを書く</a>
	<%} %>
</body>
</html>