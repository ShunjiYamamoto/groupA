<%@ page language="java" contentType="text/html; charset=UTF-8"
pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<!DOCTYPE html>
<html lang="ja">
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
<!-- <link href="./css/index.css" rel="stylesheet"> -->
<link href="./css/displayMonth.css" rel="stylesheet">
    <title>月表示</title>

</head>
<body>

        <div id="header">
            <p class="systemNameTitle headerIcon"><span id="systemName">スーテェー簿</span></p>

            <span class="headerBtn headerIcon label label-info"><a href = "displayYear">戻る</a></span>

        </div>

    <h2>${year}年</h2>
    <table border="1" width="500" cellspacing="0" cellpading="5" align = "center">
    	<thead class="tableTitle">
			<tr>
				<th>月</th>
				<th>収入</th>
				<th>支出</th>
				<th>差額</th>
			</tr>
		</thead>
		<tbody>
			<c:forEach var="date" items="${month1}">
				<tr>
					<td><a href = "calendar?date=${year}-${date.monthDate }">${date.monthDate}</a></td>
					<td>${date.monthIncome}円</td>
					<td>${date.monthSpending}円</td>
					<td>${date.monthIncomeSpendingDifference}円</td>
				</tr>
			</c:forEach>
				<thead>
			<tr>
				<th class="tableTitle">合計</th>
				<th>${incomeSum }円</th>
				<th>${spendingSum }円</th>
				<th>${differenceSum }円</th>
			</tr>
		</thead>
		</tbody>
    </tbody>
  </table>

<!--     <div>
        <button type="button"><a href = "menu">戻る</a></button>

    </div> -->
</body>
</html>