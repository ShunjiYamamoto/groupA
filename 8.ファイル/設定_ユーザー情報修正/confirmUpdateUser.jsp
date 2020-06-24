<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>ユーザー情報修正完了</title>
</head>
<body>

<div style="text-align: center">
<h2>ユーザー情報を修正しました</h2>

<p>
ユーザー名：<input  value=${newUesrName }  readonly><br>
<br>
パスワード：<input  value=${newUserPassword } readonly>
</p>

<p>
<a href="setting">戻る</a>
</p>
</div>

</body>
</html>
