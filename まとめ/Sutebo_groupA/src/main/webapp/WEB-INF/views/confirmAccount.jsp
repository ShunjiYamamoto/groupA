<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>

<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.0/css/bootstrap.min.css"
        integrity="sha384-9aIt2nRpC12Uk9gS9baDl411NQApFmC26EwAOH8WgZl5MYYxFfc+NcPb1dKGj7Sk" crossorigin="anonymous">
    <script src="https://code.jquery.com/jquery-3.5.1.slim.min.js"
        integrity="sha384-DfXdz2htPH0lsSSs5nCTpuj/zy4C+OGpamoFVy38MVBnE+IbbVYUew+OrCXaRkfj"
        crossorigin="anonymous"></script>
    <script src="https://cdn.jsdelivr.net/npm/popper.js@1.16.0/dist/umd/popper.min.js"
        integrity="sha384-Q6E9RHvbIyZFJoft+2mJbHaEWldlvI9IOYy5n3zV9zzTtmI3UksdQRVvoxMfooAo"
        crossorigin="anonymous"></script>
    <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.5.0/js/bootstrap.min.js"
        integrity="sha384-OgVRvuATP1z7JjHLkuOU7Xw704+h835Lr+6QL9UvYjZE3Ipu6Tp75j7Bh/kR0JKI"
        crossorigin="anonymous"></script>
    <link href="./css/index.css" rel="stylesheet">
    <title>アカウント作成</title>
</head>
<body>

<div class=”bg-opacity”>

        <div id="header">
            <p class="systemNameTitle"><span id="systemName">スーテェー簿</span></p>
        </div>

        <h2>アカウント作成確認</h2>

		<h2>これでいいですか？</h2>

        <div class="main">

            <div class="errorMsg">

                ${msg}<br>

            </div>

			<form:form action="confirm" modelAttribute="test">
			ユーザーID：<form:input path="userId" disabled="true" value="${userId}"/><br>
			ユーザー名：<form:input path="userName" disabled="true" value="${userName}"/><br>
			Password：<form:input path="password" disabled="true" type="password" value="${password}"/><br>
			</form:form>

			<form:form action="confirm" modelAttribute="test2">
			Password確認：<form:password path="rePassword" /><br>

			<form:button>送信</form:button>
			</form:form>

			<a href="createAccount" >戻る</a>

    </div>
</div>

</body>
</html>