<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>入力完了画面</title>
</head>
<body>
	${moneyDateFull}のデータを登録完了しました。
	<br>
	<br>
	<form action="moneyDirect" method="post">
		<button type="submit" name="menu">メニュー</button>
	<br>
		<!-- 使用不可の可能性があるためコメントアウト
		<button type="submit" name="displayMonth">月ごと表示</button> -->
		<a href="displayMonth" >${moneyDateYearAndMonth}の月ごと表示</a>
	<br>
		<!-- 使用不可の可能性があるためコメントアウト
		<button type="submit" name="dairyData">日ごと表示</button> -->
		<a href="dairyData?date=${moneyDateTypeInsert}" >${moneyDateMonthAndDate}の日ごと表示</a>
	<br>
		<button type="submit" name="inputReturn">記入</button>
	</form>

</body>
</html>
