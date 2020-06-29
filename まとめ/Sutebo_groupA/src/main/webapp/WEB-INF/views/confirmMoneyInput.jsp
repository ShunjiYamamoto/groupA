<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>

<!DOCTYPE html>
<html lang="ja">
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<link rel="stylesheet"
	href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.0/css/bootstrap.min.css"
	integrity="sha384-9aIt2nRpC12Uk9gS9baDl411NQApFmC26EwAOH8WgZl5MYYxFfc+NcPb1dKGj7Sk"
	crossorigin="anonymous">
<link href="./css/confirmMoneyInput.css" rel="stylesheet">
<title>入力確認画面</title>
</head>
<body>
	<div id="header">
		<p class="systemNameTitle headerIcon">
			<span id="systemName">スーテェー簿</span>
		</p>
		<a href="inputMoney"><span class="headerBtn headerIcon btn-lg">戻る</span></a>
		<a href="logout"><span class="headerBtn headerIcon btn-lg">ログアウト</span></a>
	</div>
	<h2>確認画面</h2>

		<form:form action="completeMoneyInput" method="post"
			modelAttribute="inputMoneyForm">
			<table>
				<tr>
					<th><c:if test="${incomeOrOutgo == 2}">支出</c:if> <c:if
							test="${incomeOrOutgo == 1}">収入</c:if></th>
				</tr>
				<tr>
					<td><form:input type="date" path="date" value="${moneyDate}"
							hidden="true" /> ${moneyDateString}</td>
				</tr>
			</table>
			<br>
			<table>
				<tr>
					<td><label style="text-align: center"><form:input
								type="hidden" path="itemsId" value="${moneyItemsId}" />
							${moneyItemName}
					</label></td>
					<td><label style="text-align: center"><form:input type="hidden" path="amount"
							value="${moneyAmount}" disabled="readonly" />${moneyAmount}</label></td>
				</tr>
			</table>
			<p></p>
			<center><button type="submit" name="insert" class="btn btn-primary btn-lg">確定</button></center>
			<!-- 			<button type="submit" name="inputReturn"
				class="btn btn-primary btn-lg">戻る</button> -->
		</form:form>
</body>
</html>