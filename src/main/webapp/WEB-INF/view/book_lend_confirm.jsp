<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ page import = "dto.BookDTO" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<p>下記の本を貸出します。よろしいですか？</p>
	<%
	BookDTO book = (BookDTO)session.getAttribute("list");
	%>
	    ID:<%=book.getId() %><br>
		図書名：<%=book.getTitle() %><br>
			<a href="BookLendServlet">OK</a><br>
				<a href="">戻る</a><br>
			
		


</body>
</html>