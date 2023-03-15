<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@page import="dto.Account" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>登録成功</title>
</head>
<body>
	<p>以下の内容で登録が完了しました</p>
	<%
		Account account = (Account)session.getAttribute("input_data");
	%>
	名前：<%=account.getName() %><br>
	メール：<%=account.getMail() %><br>
	電話番号：<%=account.getPhone_number() %><br>
	パスワード：********<br>
</body>
</html>