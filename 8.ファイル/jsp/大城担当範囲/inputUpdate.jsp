<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
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
<link href="./css/process.css" rel="stylesheet">
<title>ユーザー情報修正</title>
</head>
<body>
	<div id="header">
		<p class="systemNameTitle headerIcon">
			<span id="systemName">スーテェー簿</span>
		</p>
		<a href="setting"><span class="headerBtn headerIcon btn-lg">戻る</span></a>
		<a href="logout"><span class="headerBtn headerIcon btn-lg">ログアウト</span></a>
	</div>

	<div style="text-align: center">
		<h2>ユーザー情報修正</h2>

		ユーザー情報を修正できます。<br> 修正したい情報を変更し、修正ボタンを押してください。<br>

		<c:if test="${not empty a}">
			<form:form action="userUpdateName" modelAttribute="name">
				<p>
					<div>
						ユーザー名：
						<form:input path="userName" type="text" />
						<form:errors path="userName" cssStyle="color: red" />
					</div>
				</p>
				<form:button class="btn btn-primary btn-lg" id="mainBtn">修正</form:button>
			</form:form>
		</c:if>

		<c:if test="${not empty b}">
			<form:form action="userUpdatePass" modelAttribute="pass">
				<p>
					<div>
						&emsp;&emsp;&emsp;&emsp;&emsp;パスワード：<form:input path="pass" type="password" />
						<form:errors path="pass" cssStyle="color: red" />
					</div>

					<br>
					<div>パスワード（再確認）：<form:input path="newPass" type="password" />
						<b style="color: red">${passwordChange}</b>
						<form:errors path="newPass" cssStyle="color: red" />
					</div>
				</p>
				<form:button class="btn btn-primary btn-lg" id="mainBtn">修正</form:button>
			</form:form>
		</c:if>

	</div>

</body>
</html>
