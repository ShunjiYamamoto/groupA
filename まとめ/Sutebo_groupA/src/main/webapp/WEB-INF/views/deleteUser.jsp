<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<link rel="stylesheet"
	href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.0/css/bootstrap.min.css"
	integrity="sha384-9aIt2nRpC12Uk9gS9baDl411NQApFmC26EwAOH8WgZl5MYYxFfc+NcPb1dKGj7Sk"
	crossorigin="anonymous">
<link href="./css/process.css" rel="stylesheet">
<title>ユーザー削除</title>
</head>
<body>
	<div id="header">
		<p class="systemNameTitle headerIcon">
			<span id="systemName">スーテェー簿</span>
		</p>
		<a href="setting"><span class="headerBtn headerIcon btn-lg">戻る</span></a>
		<a href="logout"><span
			class="headerBtn headerIcon btn-lg">ログアウト</span></a>
	</div>

	<div style="text-align: center">
		<h2>ユーザー削除</h2>

		<b>ユーザー情報と家計簿のデータを全て削除できます。<br> パスワードを入力し、削除ボタンを押してください。<br></b>

		<form:form action="userDateAllDelete" modelAttribute="delete">
			<p>
			<div>
				パスワード：
				<form:input path="password" type="password" />
				<b style="color: red">${passwordChange}</b>
				<form:errors path="password" cssStyle="color: red" />
			</div>
			</p>
			<form:button class="btn btn-primary btn-lg" id="mainBtn">削除</form:button>
		</form:form>
	</div>

</body>
</html>
