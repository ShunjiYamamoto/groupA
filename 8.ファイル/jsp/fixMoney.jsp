<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<link rel="stylesheet"
	href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.0/css/bootstrap.min.css"
	integrity="sha384-9aIt2nRpC12Uk9gS9baDl411NQApFmC26EwAOH8WgZl5MYYxFfc+NcPb1dKGj7Sk"
	crossorigin="anonymous">


<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>


<link href="./css/index.css" rel="stylesheet">
<link href="./css/process.css" rel="stylesheet">
<title>日データ修正画面</title>
</head>
<body>

	<div id="header">
            <p class="systemNameTitle headerIcon"><span id="systemName">スーテェー簿</span></p>
            <a href = "logout"><span class="headerBtn headerIcon label label-info">ログアウト</span></a>
        </div>


	<h2>日データ修正</h2>


	<h3>${inputDate}</h3>

  <c:if test="${not empty errorMsg}">
    <p style=color:red class="main">${errorMsg}</p>
  </c:if>

		<form:form action="completeFixMoney" method="post" modelAttribute="fixMoneyForm">

			<table border="1" class="main">
				<tr>
					<th>項目</th>
					<th>金額</th>
					<th>修正金額内容</th>
				</tr>
				<tbody>

				<tr>
					<td>${ItemName}</td>
					<td>${amount}</td>
 					<td><form:input path="amount"/><form:errors path="amount" cssStyle="color: red"/></td>
				</tr>
				</tbody>
			</table>

			<br>
			<form:hidden path = "inputDate" value = "${inputDate}" />
			<form:hidden path = "itemName" value = "${ItemName}" />
			<p class="main"><form:button>確定</form:button></p>

	</form:form>
			<p class="main"><a href="dairyData?date=${inputDate}" class="btn btn-primary btn-lg" id="mainBtn">戻る</a></p>



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
</body>
</html>