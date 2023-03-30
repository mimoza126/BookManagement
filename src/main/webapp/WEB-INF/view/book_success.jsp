<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
     <%@ page import = "dto.BookDTO" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>BookSuccess</title>
</head>
<body>
<h3>下記の内容でを図書を登録しました</h3>

	<%
	BookDTO book = (BookDTO)session.getAttribute("input_data");
	%>
		図書名：<%=book.getTitle() %><br>
		著者:<%=book.getAuthor() %><br>
		出版社：<%=book.getPublisher() %><br>
		ISBN:<%=book.getIsbn() %><br>
		カテゴリ:<%=book.getCategory() %><br>
		
	
	
<a href="managerMenuServlet">戻る</a>
</body>
</html>