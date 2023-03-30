<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
     <%@ page import = "dto.BookDTO" %>
<!DOCTYPE html>
<html>
<link rel = "stylesheet" href = "css/register.css">
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC" crossorigin="anonymous">

<head>
<meta charset="UTF-8">
<title>本の登録画面</title>
</head>
<body>
	<p>下記の内容で登録します。よろしいですか？</p>
	<%
	BookDTO bo = (BookDTO)session.getAttribute("input_data");
	%>
<div class="box_con02">

<table class="formTable">
    <tr>
		<th>図書名</th>	
		<td class="wide"><%=bo.getTitle() %></td>
	</tr>
	<tr>
		<th>著者</th>
		<td class="wide"><%=bo.getAuthor() %></td>
	</tr>	 
	<tr>
		<th>出版社</th>
		<td class="wide"><%=bo.getPublisher() %></td>
	</tr>	
	<tr>
		<th>ISBN</th>
		<td class="wide"><%=bo.getIsbn() %></td>
	</tr>
	<tr>
		<th>カテゴリ</th>
		<td class="wide"><%=bo.getCategory() %></td>
	</tr>	 
</table>
	
	</div>	
		<a href = "./">戻る</a>
		<a href="BookExcuteServlet">OK</a><br>	
</body>
</html>