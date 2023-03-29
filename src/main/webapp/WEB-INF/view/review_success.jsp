
<%@page import="dto.ReviewDTO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">

<title>success</title>
</head>
<body>
<h3>下記の内容でを口コミを登録しました</h3>

	<%
	ReviewDTO re = (ReviewDTO)session.getAttribute("input_data");
	%>
		タイトル：<%=re.getTitle() %><br>
		コメント:<%=re.getComment() %><br>
		
	<a href="../">戻る</a>

</body>
</html>