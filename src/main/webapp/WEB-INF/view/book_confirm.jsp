<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
     <%@ page import = "dto.BookDTO" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>confirm</title>
</head>
<body>
	<p>下記の内容で登録します。よろしいですか？</p>
	<%
	BookDTO book = (BookDTO)session.getAttribute("input_data");
	%>
		図書名：<%=book.getTitle() %><br>
		著者:<%=book.getAuthor() %><br>
		出版社：<%=book.getPublisher() %><br>
		ISBN:<%=book.getIsbn() %><br>
		カテゴリ:<%=book.getCategory() %><br>
		
		
		<a href="BookExcuteServlet">OK</a><br>	
</body>
</html>