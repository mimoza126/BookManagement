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
	BookDTO bo = (BookDTO)session.getAttribute("input_data");
	%>
		図書名：<%=bo.getTitle() %><br>
		著者:<%=bo.getAuthor() %><br>
		出版社：<%=bo.getPublisher() %><br>
		ISBN:<%=bo.getIsbn() %><br>
		カテゴリ:<%=bo.getCategory() %><br>
		
		
		<a href="BookExcuteServlet">OK</a><br>	
</body>
</html>