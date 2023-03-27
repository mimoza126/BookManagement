<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<%
		request.setCharacterEncoding("UTF-8");
		if(request.getParameter("error") != null){	
	%>
		<p style="color:red">ログイン失敗</p>
	<form action="LoginServlet" method="post">
		【IDとPWを入力してください。】<br>
		ログインID：<input type="text" name="email" value="<%=request.getParameter("email") %>"><br>
		PW：<input type="password" name="pw"><br>
		<input type="submit" value="ログイン">
	</form>
	<a href="RegisterFormServlet">新規登録はこちら</a>
	<a href="BookListServlet">検索画面</a>
	<%
		} else {
	%>
	<form action="LoginServlet" method="post">
		【IDとPWを入力してください。】<br>
		ログインID：<input type="text" name="email"><br>
		PW：<input type="password" name="pw"><br>
		<input type="submit" value="ログイン">
	</form>
	<a href="RegisterFormServlet">新規登録はこちら</a>
	<a href="BookListServlet">検索画面</a>
	<a href = "BookRegester">図書登録画面</a>
	<%
		}
	%>

</body>
</html>