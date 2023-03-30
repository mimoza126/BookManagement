<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<link rel="stylesheet" href="css/style.css">
<meta charset="UTF-8">
<title>regester</title>
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


<div>図書登録</div>
<form action="BookConfirmRegester"method="POST">


<table>
    <tr>
		<th>図書名</th>
		<td><input size="20"type = "text" name = "title" placeholder = "図書名"class="wide"></td>
	</tr>
	<tr>
		<th>著者</th>
		<td><input size="10"type = "text" name = "author" placeholder = "著者"class="wide"></td>
	</tr>	 
	<tr>
		<th>出版社</th>
		<td><input size="10"type = "text" name = "publisher" placeholder = "出版社"class="wide"></td>
	</tr>	
	<tr>
		<th>ISBN</th>
		<td><input size="10"type = "text" name = "isbn" placeholder = "ISBN"class="wide"></td>
	</tr>	 
</table>
		カテゴリ<br>
		<input type = "radio" name = "category" value = "文芸">文芸<br>		
		<input type = "radio" name = "category" value = "実用書">実用書<br>		
		<input type = "radio" name = "category" value = "ビジネス書・経済・経営">ビジネス書・経済・経営<br>		
		<input type = "radio" name = "category" value = "絵本・児童書">絵本・児童書<br>		
		<input type = "radio" name = "category" value = "専門書">専門書<br>		
		<input type = "radio" name = "category" value = "学習参考書">学習参考書<br>		
		<input type = "radio" name = "category" value = "コミック・雑誌">コミック・雑誌<br>		
		
		新・旧<br>
		<input type = "radio" name = "type" value = "新">新<br>
		<input type = "radio" name = "type" value = "旧">旧<br>
		
		<input type="submit" value="登録">
</form>
</body>
</html>