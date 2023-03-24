<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
     <%@ page import = "dto.ReviewDTO" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>review_confirm</title>
</head>
<body>
<%
	ReviewDTO re = (ReviewDTO)session.getAttribute("input_data");
	%>
		口コミタイトル：<%=re.getTitle() %><br>
		口コミ内容:<%=re.getComment() %><br>
		<a href = "ReivewExcuteServlet">OK</a>
</body>
</html>