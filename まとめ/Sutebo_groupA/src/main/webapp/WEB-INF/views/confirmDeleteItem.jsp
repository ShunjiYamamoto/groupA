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

	<div id="header">
            <p class="systemNameTitle headerIcon"><span id="systemName">スーテェー簿</span></p>
            <a href = "logout"><span class="headerBtn headerIcon label label-info">ログアウト</span></a>
    		<c:choose>
			<c:when test="${incomeOutgo == 1}">
				<a href="/displayItemIncome" class="headerBtn headerIcon label label-info">戻る</a>
			</c:when>
			<c:when test="${incomeOutgo == 2}">
				<a href="/displayItemOutgo" class="headerBtn headerIcon label label-info">戻る</a>
			</c:when>
		</c:choose>

    </div>


	<div class="back">

	</div>

	<h2>項目の削除の確認</h2>

	<p class="center">
	選択した項目の削除を行います。<br>
	内容を確認し、削除ボタンを押してください。
	</p>
	<div>
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
	</div><br>
	<p><a href="deleteItem" class="btn btn-primary btn-lg center2" id="mainBtn">削除</a></p>

	<form action="deleteItem" method="post" class="center2">
		<input type="submit" value="削除">
	</form>


</body>

</html>