<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ page import="java.util.List" %>
    <%@ page import="java.util.ArrayList" %>
    <%@ page import="dto.BooklistDTO" %>
    <%@ page import="dao.BookDAO" %>
       <%@ page import="dto.UsersDTO" %>
<%@ page import="dto.LendingDTO" %>
<%@ page import="dto.BookDTO" %>
<%@ page import="dao.ManagerDAO" %>
<%@ page import="java.util.*" %>
<!DOCTYPE html>
<html>
<head>
<link rel="stylesheet" href="css/style.css">
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<header class="header">
      <!-- ヘッダーロゴ -->
      <div class="logo">管理者</div>
    
      <!-- ハンバーガーメニュー部分 -->
      <div class="nav">
    
        <!-- ハンバーガーメニューの表示・非表示を切り替えるチェックボックス -->
        <input id="drawer_input" class="drawer_hidden" type="checkbox">
    
        <!-- ハンバーガーアイコン -->
        <label for="drawer_input" class="drawer_open"><span></span></label>
    
        <!-- メニュー -->
        <nav class="nav_content">
          <ul class="nav_list">
            <li class="nav_item"><a href="managerMenuServlet">図書一覧</a></li>
            <li class="nav_item"><a href="manager_logServlet">ログ</a></li>
            <li class="nav_item"><a href="BookRegester">登録</a></li>
            <li class="nav_item"><a href="">ログアウト</a></li>
          </ul>
        </nav>
   
      </div>
    </header>

	<h1>返却しました。</h1>

	<% request.setCharacterEncoding("UTF-8");
	int i;
	int book_id=0;%>
	<table border="1">
	<tr>
	<td>本のID</td><td><%=i=Integer.parseInt(request.getParameter("id")) %></td>
	</tr>
	
	<% List <LendingDTO> li =ManagerDAO.selectAlllendingDTO();
	for(LendingDTO k : li){
	if(i == k.getId()){%>
	<% book_id=k.getBook_id();%>
	<% } %> 
	<% } %> 
		<% List <BookDTO>list1= ManagerDAO.selectAllBookDTO();
for(BookDTO a : list1){ %>
<% if( book_id == a.getId()) {%>
<tr>
		<td>本の名前</td><td><%=a.getTitle() %></td>
</tr>
		<% } %>
		<% } %>
		
		<% List <LendingDTO>list2= ManagerDAO.selectAlllendingDTO();
		 List <UsersDTO>list3= ManagerDAO.selectAllUsersDTO();
		int user=0; %>
<% for(LendingDTO e : list2){ %>
<% if( book_id == e.getBook_id()) {%>
		<% user=e.getUser_id(); %>
		<% } %>
<% } %>	
		


<%for(UsersDTO b : list3){ %>
<% if( user == b.getId()) {%>

	<tr>
		<td>借りた人</td><td><%=b.getName() %></td>
</tr>

	<tr>
		<td>メールアドレス</td><td><%=b.getEmail() %></td>
</tr>		

	<tr>
		<td>電話番号</td><td><%=b.getTell() %></td>
</tr>		

<% } %>
<% } %>
		
		<% List <LendingDTO>list4= ManagerDAO.selectAlllendingDTO();%>
<% for(LendingDTO o : list4){ %>
		<% if(book_id == o.getBook_id()){ %>
<tr>
		<td>貸し出し日</td><td><%=o.getLendin_date() %></td>
</tr>			
<% } %>	
<% } %>	
		
		
		<% List <BookDTO>list5= ManagerDAO.selectAllBookDTO(); 
		String type ="新";%>
<% for(BookDTO q : list5){ %>
<% if( book_id == q.getId() && type.equals(q.getId())) {%>
	<tr>
		<td>貸出日数</td><td>7</td>
		<% }else if(i == q.getId()){%>
			<td>貸出日数</td><td>7</td> 
</tr>
<% } %>
		<% } %>
	<% List <LendingDTO>list6= ManagerDAO.selectAlllendingDTO();%>
<% for(LendingDTO o : list6){ %>
<% if(book_id == o.getBook_id()){ %>
<tr>
		<td>返却日</td><td><%=o.getReturn_data() %></td>
</tr>			
<% } %>	
<% } %>	

</table>
</body>
</html>