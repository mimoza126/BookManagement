
<%@page import="dto.ReviewDTO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>口コミ登録</title>
</head>
<body>
<h3>下記の内容でを口コミを登録しました</h3>
	<%
	ReviewDTO re=(ReviewDTO)request.getAttribute("input");
	%>
		タイトル：<%=re.getTitle() %><br>
		コメント:<%=re.getComment() %><br>
		
	<a href = "BookListlogin">本の一覧画面</a>

</body>
</html>