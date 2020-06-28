<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.0/css/bootstrap.min.css"
        integrity="sha384-9aIt2nRpC12Uk9gS9baDl411NQApFmC26EwAOH8WgZl5MYYxFfc+NcPb1dKGj7Sk" crossorigin="anonymous">
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>

	 <link href="./css/index.css" rel="stylesheet">
    <link href="./css/process.css" rel="stylesheet">
<title>設定画面</title>
<style>
</style>
</head>
<body>

	 <div id="header">
     	<p class="systemNameTitle headerIcon"><span id="systemName">スーテェー簿</span></p>
	</div>
		<br>
		<h1 class="left">設定</h1>
		<br>

		<div class="main">

			<p><a href="line" class="btn btn-primary btn-lg" id="mainBtn">忘れ防止</a></p>
			<p><a href="displayNoticeMonthSetting" class="btn btn-primary btn-lg" id="mainBtn">支払い</a></p>
			<p><a href="inputUpdateName" class="btn btn-primary btn-lg" id="mainBtn">ユーザー名変更</a></p>
			<p><a href="inputUpdatePass" class="btn btn-primary btn-lg" id="mainBtn">パスワード変更</a></p>
			<p><a href="deleteUser" class="btn btn-primary btn-lg" id="mainBtn">ユーザー削除</a></p>
			<p><a href="menu"  class="btn btn-primary btn-lg" id="mainBtn">戻る</a></p>

	</div>

</body>
</html>