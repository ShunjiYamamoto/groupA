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
<title>日データ閲覧</title>
</head>
<body>

	<div class=”bg-opacity”>

		<div id="header">
			<p class="systemNameTitle">
				<span id="systemName">スーテェー簿</span>
			</p>
		</div>

		<h2>${dairyDate}</h2>

		<div class="main">

			<form:form action="fixMoney" modelAttribute="fixMoneyForm"
				method="post">

				<table border="1">
					<tr>
						<th></th>
						<th>項目</th>
						<th>金額</th>
					</tr>
					<tbody>
						<c:choose>
							<c:when test="${dairyMoney =='0'}">
								<tr>
									<td>&nbsp;</td>
									<td>NoData</td>
									<td>0</td>
								</tr>
							</c:when>
							<c:when test="${dairyMoney != '0'}">
								<c:forEach items="${dairyMoney}" var="list" varStatus="status">
									<tr>
										<td><form:radiobutton path="itemName"
												value="${list.itemName}"
												checked="${status.first?\"checked\":\"\"}" /></td>
										<td>${list.itemName}</td>
										<td>${list.amount}</td>
									</tr>
								</c:forEach>
							</c:when>
						</c:choose>
					</tbody>
				</table>
				<form:hidden path="inputDate" value="${date}" />

				<c:if test="${dairyMoney != '0'}">
					<form:button>修正</form:button>
				</c:if>

			</form:form>
			<a href="calendar?date=2020-${datem}">戻る</a>


			<table hidden>
				<c:if test="${dairyDataForGraph != '0'}">
					<c:forEach items="${dairyDataForGraph}" var="list"
						varStatus="status">
						<tr id="forGraph">
							<td class="itemName">${list.itemName}</td>
							<td class="amount">${list.amount}</td>
						</tr>
					</c:forEach>
				</c:if>
			</table>
			<div class="pieChart">
				<canvas id="myPieChartForDairy"></canvas>
			</div>
			<script
				src="https://cdnjs.cloudflare.com/ajax/libs/Chart.js/2.7.2/Chart.bundle.js"></script>
			<script type="text/javascript" src="myPieChartForDairy.js"></script>

		</div>

	</div>

</body>
</html>