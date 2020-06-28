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
			<p class="systemNameTitle headerIcon">
				<span id="systemName">スーテェー簿</span>
			</p>
			<a href="createAccount"><span
				class="headerBtn headerIcon label label-info">戻る</span></a>
		</div>

         <h2>アカウント作成確認画面</h2>

		<h2>これでいいですか</h2>

        <div class="main">

            <div class="errorMsg">

				<c:if test="${not empty msg}">
				<p>${msg}</p>
				</c:if>

                <form:form action="confirm" modelAttribute="test2">
                	<p><form:errors path="password" cssStyle="color: red"/></p>
           	 	</form:form>

            </div>

			<form:form action="confirm" modelAttribute="test">
			<p>ユーザーID：<form:input path="userId" disabled="true" value="${userId}"/></p>
			<p>ユーザー名：<form:input path="userName" disabled="true" value="${userName}"/></p>
			<p>パスワード：<form:input path="password" disabled="true" type="password" value="${password}"/></p>
			</form:form>

			<form:form action="confirm" modelAttribute="test2">
			<p>パスワード確認：<form:password path="password" /></p>

			<p><form:button class="btn btn-primary" id="mainBtn">確定</form:button><p>
			</form:form>

    </div>
</div>

</body>
</html>