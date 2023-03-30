<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%@ page import = "dto.ReviewDTO" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet" href="css/review_confirm.css">
<title>口コミ確認</title>
</head>
<body>
<%
	ReviewDTO re = (ReviewDTO)session.getAttribute("input_data");
	%>

		タイトル：<%=re.getTitle() %><br>
		コメント:<%=re.getComment() %><br>
		<a href = "ReviewWrite?id=<%=re.getBook_id()%>">戻る</a>
		<a href="ReviewExcuteServlet">OK</a><br>	

</body>
</html>