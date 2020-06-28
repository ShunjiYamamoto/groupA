<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<link rel="stylesheet"
	href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.0/css/bootstrap.min.css"
	integrity="sha384-9aIt2nRpC12Uk9gS9baDl411NQApFmC26EwAOH8WgZl5MYYxFfc+NcPb1dKGj7Sk"
	crossorigin="anonymous">
<link href="./css/lineNotice.css" rel="stylesheet">
<title>記入忘れ防止用通知</title>
</head>
<body>

	<div id="header">
		<p class="systemNameTitle headerIcon">
			<span id="systemName">スーテェー簿</span>
		</p>
		<a href="logout"><span class="headerBtn headerIcon btn-lg">ログアウト</span></a>
		<a href="setting"><span class="headerBtn headerIcon btn-lg">戻る</span></a>
		<a href="menu"><span class="headerBtn headerIcon btn-lg">メニュー</span></a>
	</div>


	<h2>記入忘れ防止用通知</h2>

	<div class="news">
		<p id="notice">忘れ防止用通知の登録手順</p>
		<p class = "text">1.LineNofityにログインする。</p>
		<p class = "text">2.マイページからトークンの発行を行う。</p>
		<p class = "text">※トークルームは「1:1でLINENotifyから通知を受け取る」を選択</p>
		<p class = "text">3.発行されたトークンをコピーする。</p>
		<p class = "text">4.トークンを指定した入力フォームにペーストする。</p>
		<p class = "text">5.時間を入力して保存を行う。</p>
	</div>
	    <p>発行されたトークンを入力してください。</p>

		<form:form action="line2" modelAttribute="test">
			<p>
				<form:input path="lineToken" value="${lineToken}" />
			</p>

			<c:if test="${not empty msg_lineToken}">
			<center><b style = "color:red">${msg_lineToken}</b></center>
			</c:if>
			<p>通過をオンにすると、記入した時間に通知が送られます。</p>

			<p>
				<form:input path="hour" type="number" />
				時
				<form:input path="minute" type="number" />
				分
				<form:radiobutton path="lineNoticeOn" value="On" />
				オン
				<form:radiobutton path="lineNoticeOn" value="Off" />
				オフ<br> ${msg_lineTime} <br>
			</p>
			<p>
				<form:button class="btn btn-primary btn-lg">保存</form:button>
			</p>
		</form:form>
</body>
</html>