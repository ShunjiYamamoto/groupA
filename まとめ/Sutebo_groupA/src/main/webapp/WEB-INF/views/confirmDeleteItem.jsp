<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
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
	<title>項目の削除の確認</title>
</head>

<body>

	<div id="header">
            <p class="systemNameTitle headerIcon"><span id="systemName">スーテェー簿</span></p>
    		<c:choose>
			<c:when test="${incomeOutgo == 1}">
				<a href="/displayItemIncome"><span class="headerBtn headerIcon label label-info">戻る</span></a>
			</c:when>
			<c:when test="${incomeOutgo == 2}">
				<a href="/displayItemOutgo"><span class="headerBtn headerIcon label label-info">戻る</span></a>
			</c:when>
		</c:choose>

    </div>

	<h2>項目の削除の確認</h2>

	<p class="center"><b>
	選択した項目の削除を行います。<br>
	内容を確認し、削除ボタンを押してください。
	</b></p>
	<div>
	<table>
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
	<center><p><a href="deleteItem" class="btn btn-primary btn-lg center2" id="mainBtn">削除</a></p></center>

<%-- 	<form action="deleteItem" method="post" class="center2">
		<input type="submit" value="削除">
	</form> --%>


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