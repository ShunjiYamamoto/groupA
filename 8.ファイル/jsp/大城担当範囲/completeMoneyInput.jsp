<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html>
<html lang="ja">
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<link rel="stylesheet"
	href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.0/css/bootstrap.min.css"
	integrity="sha384-9aIt2nRpC12Uk9gS9baDl411NQApFmC26EwAOH8WgZl5MYYxFfc+NcPb1dKGj7Sk"
	crossorigin="anonymous">
<link href="./css/lineNotice.css" rel="stylesheet">
<title>入力完了画面</title>
</head>
<body>
	<div id="header">
		<p class="systemNameTitle headerIcon">
			<span id="systemName">スーテェー簿</span>
		</p>
		<a href="menu"><span class="headerBtn headerIcon btn-lg">メニュー</span></a>
		<a href="logout"><span class="headerBtn headerIcon btn-lg">ログアウト</span></a>
	</div>
	<h2>${moneyDateFull}のデータを登録完了しました。</h2>
	<br>
	<br>
	<p class="center">
	<form action="moneyDirect" method="post">
		<p>
			<button type="submit" name="menu" class="btn btn-primary btn-lg">メニュー</button>
		</p>
		<!-- 使用不可の可能性があるためコメントアウト
			<button type="submit" name="displayMonth">月ごと表示</button> -->
		<p>

			<a href="displayMonth" class="btn btn-primary btn-lg">${moneyDateYearAndMonth}の月ごと表示</a>
		</p>
		<!-- 使用不可の可能性があるためコメントアウト
			<button type="submit" name="dairyData">日ごと表示</button> -->
		<p>
			<a href="dairyData?date=${moneyDateTypeInsert}"
				class="btn btn-primary btn-lg">${moneyDateMonthAndDate}の日ごと表示</a>
		</p>
		<p>
			<button type="submit" name="inputReturn"
				class="btn btn-primary btn-lg">記入</button>
		</p>
	</form>
	</p>
</body>
</html>
