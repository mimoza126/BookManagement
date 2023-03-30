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
<link rel="stylesheet" href="css/style.css">
<title>Insert title here</title>
</head>
<body>

	<form action="Searchlist" method="post">
	<input type="text" name="title" placeholder="図書検索">
	<input type="submit" value="検索">
	</form>
	
	<form action="index.jsp" method="post">
	<button type="submit" name="buttonName" value="buttonValue">ログイン</button>
	</form>
	
	<ul class="category-list">
	  <li class="category-item"><a href="BookListServlet">すべて</a> </li>
	  <li class="category-item"><a href="BookSearchlist?category=文芸">文芸</a></li>
	  <li class="category-item"><a href="BookSearchlist?category=実用書">実用書</a></li>
	  <li class="category-item"><a href="BookSearchlist?category=ビジネス書・経済・経営">ビジネス書・経済・経営</a></li>
	  <li class="category-item"><a href="BookSearchlist?category=絵本・児童書">絵本・児童書</a></li>
	  <li class="category-item"><a href="BookSearchlist?category=学習参考書">学習参考書</a></li>
	  <li class="category-item"><a href="BookSearchlist?category=専門書">専門書</a></li>
	  <li class="category-item"><a href="BookSearchlist?category=コミック・雑誌">コミック・雑誌</a></li>
	</ul>
	<br>
	<table>
	<tr>
		<td>図書名</td><td>出版社</td><td>著者</td>
	</tr>
	<%
	List<BookDTO> list = (ArrayList<BookDTO>)request.getAttribute("list");
	String cisbn = "";
	for(BookDTO s : list) {
	%>
	<%
	if(s.getIsbn().equals(cisbn)){
	continue;
	}else{
	%>
	<tr>
		<td><a href="BookIdDetailServlet?id=<%=s.getId()%>"><%=s.getTitle()%></a></td><td><%=s.getPublisher()%></td><td><%=s.getAuthor()%></td>
	</tr>
	</table>
	<% cisbn = s.getIsbn(); %>
	<%} %>
	<%} %>
</body>
</html>