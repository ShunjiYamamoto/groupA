<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
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
<script src="https://code.jquery.com/jquery-3.5.1.slim.min.js"
	integrity="sha384-DfXdz2htPH0lsSSs5nCTpuj/zy4C+OGpamoFVy38MVBnE+IbbVYUew+OrCXaRkfj"
	crossorigin="anonymous"></script>
<script
	src="https://cdn.jsdelivr.net/npm/popper.js@1.16.0/dist/umd/popper.min.js"
	integrity="sha384-Q6E9RHvbIyZFJoft+2mJbHaEWldlvI9IOYy5n3zV9zzTtmI3UksdQRVvoxMfooAo"
	crossorigin="anonymous"></script>
<script
	src="https://stackpath.bootstrapcdn.com/bootstrap/4.5.0/js/bootstrap.min.js"
	integrity="sha384-OgVRvuATP1z7JjHLkuOU7Xw704+h835Lr+6QL9UvYjZE3Ipu6Tp75j7Bh/kR0JKI"
	crossorigin="anonymous"></script>
<link href="./css/index.css" rel="stylesheet">
<title>ログイン</title>
</head>

<body>

	<div class=”bg-opacity”>

		<div id="header">
			<p class="systemNameTitle">
				<span id="systemName">スーテェー簿</span>
			</p>
		</div>

		<h2>ログイン画面</h2>

		<div class="main">

			<c:if test="${not empty errMsg}">
				<p class="error">${fn:escapeXml(errMsg)}</p>
			</c:if>


			<form:form action="menu" method="post" modelAttribute="loginForm">
				<fieldset>
					<ul>

						<div class="inputForm">

							<li class="userId"><label>ユーザーID：</label> <form:input
									path="userId" size="25" /> <form:errors path="userId"
									class="error" /></li>
							<li class="password"><label>パスワード：</label> <form:password
									path="password" size="25" /> <form:errors path="password"
									class="error" /></li>

						</div>



						<li><form:button class="btn btn-primary" id="mainBtn">ログイン</form:button>
							<a href="index" class="btn btn-primary" id="backBtn">戻る</a></li>
					</ul>
				</fieldset>
			</form:form>

		</div>

	</div>

</body>

</html>