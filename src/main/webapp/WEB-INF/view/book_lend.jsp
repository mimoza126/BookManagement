<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>本のIDを入力して下さい</h1>
	<form action="BookLendServlet" method="post">
		ID：<input type="text" name="id"><br>
		<input type="submit" value="借りる">
	</form>

</body>
</html>