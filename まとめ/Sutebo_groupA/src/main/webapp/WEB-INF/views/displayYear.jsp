<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>

<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<link rel="stylesheet"
	href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.0/css/bootstrap.min.css"
	integrity="sha384-9aIt2nRpC12Uk9gS9baDl411NQApFmC26EwAOH8WgZl5MYYxFfc+NcPb1dKGj7Sk"
	crossorigin="anonymous">
	<link href="./css/displayYear.css" rel="stylesheet">
<title>閲覧：年表示</title>
</head>
<body>

	<div id="header">
		<p class="systemNameTitle headerIcon">
			<span id="systemName">スーテェー簿</span>
		</p>

		<span class="headerBtn headerIcon label label-info"><a
			href="menu">戻る</a></span>

	</div>
 	<h2>閲覧したい年を選択して下さい。</h2>
	<table border="1" width="500" cellspacing="0" cellpading="5"
		align="center">
		<thead>
			<tr>
				<th>西暦</th>
			</tr>
		</thead>
		<tbody>
			<c:forEach var="year2" items="${year1}">
				<tr>
					<td><a href="displayMonth?date=${year2.years }">${year2.years}年</a></td>

				</tr>
			</c:forEach>
		</tbody>
		</tbody>
	</table>
</body>
</html>