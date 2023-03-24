<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>review_write</title>
</head>
<body>
 <div class="box_con02">
<form action="ReviewConfirm"enctype="multipart/form-data"method="POST">
<table class="formTable">
    <tr>
		<th>口コミタイトル</th>
		<td><input size="20"type = "text" name = "title" placeholder = "商品名"class="wide"></td>
	</tr>
</table>
			口コミ内容<br>	
<textarea class="form-control" id="exampleFormControlTextarea1"name="detail" rows="10" cols="50" placeholder="内容を入力"></textarea><br>
			<input type="submit" value="登録">
				</form>
		</div>
</body>
</html>