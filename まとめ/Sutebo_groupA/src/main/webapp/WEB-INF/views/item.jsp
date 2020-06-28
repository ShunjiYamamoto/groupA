<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<!DOCTYPE html>
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<link rel="stylesheet"
	href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.0/css/bootstrap.min.css"
	integrity="sha384-9aIt2nRpC12Uk9gS9baDl411NQApFmC26EwAOH8WgZl5MYYxFfc+NcPb1dKGj7Sk"
	crossorigin="anonymous">
<link href="./css/item.css" rel="stylesheet">
<title>項目の編集</title>
</head>

<body>

	<div id="header">
		<p class="systemNameTitle headerIcon">
			<span id="systemName">スーテェー簿</span>
		</p>
		<a class="headerBtn headerIcon label label-info" href="./inputMoney">戻る</a>
		<a class="headerBtn headerIcon label label-info" href="./menu">メニュー</a>
	</div>

	<h2>項目の編集</h2>

	<div class="center2">
		<c:choose>
			<c:when test="${incomeOutgo == 1}">
				<center><b><a href="/displayItemOutgo">支出</a>／収入</b></center>
			</c:when>
			<c:when test="${incomeOutgo == 2}">
				<center><b>支出／<a href="/displayItemIncome">収入</a></b></center>
			</c:when>
		</c:choose>
	</div>

	<div class="center2">
		<c:if test="${not empty deleteItemList}">
		<form:form action="reInputItem" modelAttribute="reInputForm">
				<center><form:select path="itemsId">
					<c:forEach items="${deleteItemList}" var="item">
						<form:option value="${item.itemsId}" label="${item.itemName}" /></center>
					</c:forEach>
				</form:select>
				<form:button>再追加</form:button></center>
			</form:form>
		</c:if>
	</div>

	<div class="center2">
		<form:form action="inputItem" modelAttribute="inputForm">
			<center><form:input path="itemName" />
			<form:button>追加</form:button></center>
			<br>
			<center><b><form:errors path="itemName" cssStyle="color: red" /></b></center>
		</form:form>
	</div>

	<c:if test="${not empty inputMsg}">
		<center><b style = "color :red">${inputMsg}</b></center>
	</c:if>
	<c:if test="${not empty deleteMsg}">
		<center><b style = "color :red">${deleteMsg}</b></center>
	</c:if>

	<div class="center2">
		<c:choose>
			<c:when test="${not empty itemList}">
				<form:form action="confirmDeleteItem" modelAttribute="deleteForm">
					<table>
						<tr>
							<th>削除</th>
							<th>項目</th>
						</tr>
						<c:forEach items="${itemList}" var="item" varStatus="status">
							<tr>
								<td><form:checkbox path="items" value="${status.index}" /></td>
								<td>${fn:escapeXml(item.itemName)}</td>
							</tr>
						</c:forEach>
					</table>
					<center><form:button class="btn btn-primary btn-lg" id="mainBtn">削除</form:button></center>
				</form:form>
			</c:when>
			<c:otherwise>
				<center><b>
					項目はありません。<br>
					削除した項目を再追加するか、項目を新たに追加してください。</b>
				</center>
			</c:otherwise>
		</c:choose>
	</div>
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