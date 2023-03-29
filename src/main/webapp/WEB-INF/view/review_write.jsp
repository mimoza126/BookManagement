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
<%List<BookDTO> list = (ArrayList<BookDTO>)request.getAttribute("list");
	for(BookDTO s : list) {
	%>

<form action="ReviewConfirm"enctype="multipart/form-data"method="POST">
<p><input type="hidden" name="id" value="<%=s.getId()%>"><%=s.getId()%></p>
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
					<%} %>
	
	
				
</body>
</html>