<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

    <%@ page import="dto.BookDTO" %>
<%@ page import="dao.BookDAO" %>
<%@ page import = "dto.ReviewDTO" %>
<%@ page import="java.util.List" %>
<%@ page import="java.util.ArrayList" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">

<title>review</title>
</head>
<body>
<%
	
	int book_id = (int)session.getAttribute("book_id");
	%>

<form action="ReviewConfirm"method="POST">
<p><input type="hidden" name="id" value="<%=book_id%>"><%=book_id%></p>
<table class="formTable">
	 <tr>
		<th>タイトル</th>
		<td><input size="20"type = "text" name = "title" placeholder = "タイトル"class="wide"></td>
	</tr>
	 
</table>
	コメント<br>	
<textarea class="form-control" id="exampleFormControlTextarea1"name="comment" rows="10" cols="50" placeholder="内容を入力"></textarea><br>
			<input type="submit" value="登録">
				</form>
					
	
	
			
</body>
</html>