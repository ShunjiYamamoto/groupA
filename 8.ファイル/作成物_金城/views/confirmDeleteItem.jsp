<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<!DOCTYPE html>
<head>
	<meta charset="UTF-8">
	<meta name="viewport" content="width=device-width, initial-scale=1.0">
	<link href="./css/index.css" rel="stylesheet">
	<title>項目の削除の確認</title>
</head>

<body>

	<div class="back">
		<c:choose>
			<c:when test="${incomeOutgo == 1}">
				<a href="/displayItemIncome">戻る</a>
			</c:when>
			<c:when test="${incomeOutgo == 2}">
				<a href="/displayItemOutgo">戻る</a>
			</c:when>
		</c:choose>
	</div>

	<h2>項目の削除の確認</h2>

	<p>
	選択した項目の削除を行います。<br>
	内容を確認し、削除ボタンを押してください。
	</p>

	<table class="paymentTable">
		<tr>
			<th>項目</th>
		</tr>
		<c:forEach items="${confirmDeleteItemList}" var="item">
			<tr>
				<td>${fn:escapeXml(item.itemName)}</td>
			</tr>
		</c:forEach>
	</table>
	<form action="deleteItem" method="post">
		<input type="submit" value="削除">
	</form>


</body>

</html>