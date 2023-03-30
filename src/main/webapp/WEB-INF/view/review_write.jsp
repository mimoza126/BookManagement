<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="dto.BookDTO" %>
<%@ page import="dao.BookDAO" %>
<%@ page import = "dto.ReviewDTO" %>
<%@ page import="java.util.List" %>
<%@ page import="java.util.ArrayList" %>
<!DOCTYPE html>
<html>
<link rel = "stylesheet" href = "css/review.css">
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC" crossorigin="anonymous">
<head>
<meta charset="UTF-8">
<title>口コミ</title>
</head>
<body>
	<%
	int book_id = (int)session.getAttribute("book_id");
	%>

<form action="ReviewConfirm"method="POST">
<input type="hidden" name="id" value="<%=book_id%>"><%=book_id%>
<table class="formTable">
	 <tr>
		<th>口コミタイトル</th>
		<td><input size="20"type = "text" name = "title" placeholder = "タイトル"class="wide"></td>
	</tr>
	 
</table>
	コメント<br>	
<textarea class="form-control" id="exampleFormControlTextarea1"name="comment" rows="10" cols="50" placeholder="内容を入力"></textarea><br>
			<input type="submit" value="登録">
				</form>
					
	
	
			
</body>
</html>