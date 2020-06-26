<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>

<!DOCTYPE html>
<html lang="ja">
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<link href="content.css" rel="stylesheet">
<title>入力確認画面</title>
</head>
<body>
	<h1>確認画面</h1>
	<form:form action="completeMoneyInput" method="post"
		modelAttribute="inputMoneyForm">
		<table border="1" align="center">
			<tr>
				<td>
					<c:if test="${incomeOrOutgo == 2}">支出</c:if>
					<c:if test="${incomeOrOutgo == 1}">収入</c:if>
				</td>
			</tr>
			<tr>
				<td><form:input type="date" path="date" value="${moneyDate}"
						hidden="true" /> ${moneyDateString}</td>
			</tr>
		</table>
		<fieldset>
			<table>
				<tr>
					<td><label> <form:input type="hidden" path="itemsId"
								value="${moneyItemsId}" /> ${moneyItemName}
					</label></td>
					<td><form:input type="hidden" path="amount"
							value="${moneyAmount}" disabled="readonly" />${moneyAmount}</td>
				</tr>
			</table>
		</fieldset>
		<button type="submit" name="insert">確認</button>
		&ensp;&ensp;
		<button type="submit" name="inputReturn">戻る</button>
	</form:form>
</body>
</html>