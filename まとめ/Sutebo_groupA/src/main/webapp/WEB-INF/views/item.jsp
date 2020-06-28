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
	<title>項目の編集</title>
</head>

<body>

    <div id="header">
        <p class="systemNameTitle headerIcon"><span id="systemName">スーテェー簿</span></p>
        <a class="headerBtn headerIcon label label-info" href = "logout" >ログアウト</a>
		<a class="headerBtn headerIcon label label-info" href="./inputMoney">戻る</a>
		<a class="headerBtn headerIcon label label-info" href="./menu">メニュー</a>
    </div>

	<h2>項目の編集</h2>

	<div class="center2">
	<c:choose>
		<c:when test="${incomeOutgo == 1}">
			<a href="/displayItemOutgo">支出</a>／収入
		</c:when>
		<c:when test="${incomeOutgo == 2}">
			支出／<a href="/displayItemIncome">収入</a>
		</c:when>
	</c:choose>]
	</div>

	<p class="center2">
		<c:if test="${not empty deleteItemList}">
			<form:form action="reInputItem" modelAttribute="reInputForm">
				<form:select path="itemsId">
					<c:forEach items="${deleteItemList}" var="item">
						<form:option value="${item.itemsId}" label="${item.itemName}"/>
					</c:forEach>
				</form:select>
				<form:button>再追加</form:button>
			</form:form>
		</c:if>
	</p>

	<p class="center2">
		<form:form action="inputItem" modelAttribute="inputForm">
			<form:input path="itemName" />
			<form:button>追加</form:button><br>
			<form:errors path="itemName" cssStyle="color: red"/>
		</form:form>
	</p>

	<c:if test="${not empty inputMsg}">
			<p class="center2">${inputMsg}</p>
	</c:if>

	<div class = "center2">
	<c:choose>
		<c:when test="${not empty itemList}">
			<form:form action="confirmDeleteItem" modelAttribute="deleteForm">
				<table  class="paymentTable">
					<tr>
						<th>削除</th>
						<th>項目</th>
					</tr>
					<c:forEach items="${itemList}" var="item" varStatus="status">
						<tr>
							<td><form:checkbox path="items" value="${status.index}"/></td>
							<td>${fn:escapeXml(item.itemName)}</td>
						</tr>
					</c:forEach>
				</table>
			<form:button>削除</form:button>
			</form:form>
		</c:when>
		<c:otherwise>
			項目はありません。<br>
			削除した項目を再追加するか、項目を新たに追加してください。
		</c:otherwise>
	</c:choose>
	</div>

	<c:if test="${not empty deleteMsg}">
			<p class="center2">${deleteMsg}</p>
	</c:if>

</body>

</html>