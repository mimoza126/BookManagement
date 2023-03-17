<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ page import="java.util.List" %>
    <%@ page import="java.util.ArrayList" %>
    <%@ page import="dto.BookDTO" %>
    <%@ page import="dao.BookDAO" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<form action="BooksearchList" method="post">
	<input type="text" name="name" placeholder="図書検索">
	<input type="submit" value="検索">
	</form>
	
	<form action="index.jsp" method="post">
	<button type="submit" name="buttonName" value="buttonValue">ログイン</button>
	</form>
	
	<ul style="display: flex;">
	  <li><a href="BookSeachlist?category=null">すべて</a> </li>
	  <li><a href="BookSeachlist?category=文芸">文芸</a></li>
	  <li><a href="BookSeachlist?category=実用書">実用書</a></li>
	  <li><a href="BookSeachlist?category=ビジネス">ビジネス</a></li>
	  <li><a href="BookSeachlist?category=絵本">絵本</a></li>
	  <li><a href="BookSeachlist?category=学習">学習</a></li>
	  <li><a href="BookSeachlist?category=専門書">専門書</a></li>
	  <li><a href="BookSeachlist?category=コミック">コミック・雑誌</a></li>
	</ul>
	<table>
	<tr>
		<td>図書名</td><td>出版社</td><td>著者</td>
	</tr>
	<%List<BookDTO> list = (ArrayList<BookDTO>)request.getAttribute("list");
	for(BookDTO s : list) {
	%>
	<tr>
		<td><%=s.getTitle()%></td><td><%=s.getPublisher()%></td><td><%=s.getAuthor()%></td>
	</tr>
	</table>
	<%} %>
</body>
</html>