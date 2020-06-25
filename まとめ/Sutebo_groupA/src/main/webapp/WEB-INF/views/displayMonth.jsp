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
    <title>月表示</title>
    <style>
        .border {
            width: 100px;
            padding: 10px;
            margin: 20px;
        }
    </style>
</head>
<!-- width="500" cellspacing="0" cellpading="5" -->
<body>
    2020年
    <div class="border border-solid">
    <table border="1" width="500" cellspacing="0" cellpading="5">
    	<thead>
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
					<td><a href = "calendar?date=2020-${date.monthDate }">${date.monthDate}</a></td>
					<td>${date.monthIncome}円</td>
					<td>${date.monthSpending}円</td>
					<td>${date.monthIncomeSpendingDifference}円</td>
				</tr>
			</c:forEach>
				<thead>
			<tr>
				<th>合計</th>
				<th>${incomeSum }円</th>
				<th>${spendingSum }円</th>
				<th>${differenceSum }円</th>
			</tr>
		</thead>
		</tbody>
    </tbody>
  </table>

    </div>
    <div>
        <button type="button"><a href = "menu">戻る</a></button>

    </div>
</body>
</html>