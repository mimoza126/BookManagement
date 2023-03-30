<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ page import = "dto.BookDTO" %>
    <%@ page import="java.util.List" %>
<%@ page import="java.util.ArrayList" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<h1>貸出が完了しました</h1>
<%
List<BookDTO> list = (ArrayList<BookDTO>)request.getAttribute("list");
for(BookDTO s : list) {
	%>
	    ID:<%=s.getId() %><br>
		図書名：<%=s.getTitle() %><br>
		<%} %>
		<a href="BookListlogin">戻る</a>
</body>
</html>