<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="ja">

<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<link rel="stylesheet"
	href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.0/css/bootstrap.min.css"
	integrity="sha384-9aIt2nRpC12Uk9gS9baDl411NQApFmC26EwAOH8WgZl5MYYxFfc+NcPb1dKGj7Sk"
	crossorigin="anonymous">
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<link href="./css/process.css" rel="stylesheet">
<title>メニュー</title>
</head>

<body>
	<div class=”bg-opacity”>

		<div id="header">
			<p class="systemNameTitle headerIcon">
				<span id="systemName">スーテェー簿</span>
			</p>
			<a href="logout"><span
				class="headerBtn headerIcon label label-info">ログアウト</span></a>
		</div>

		<p id="displayUserName">${fn:escapeXml(user.userName)}さん、こんにちは</p>

		<h2>メニュー</h2>

		<div class="main">

			<div class="news">

				<p id="notice">お知らせ</p>

				<c:if test="${empty noticeList}">
				<b>お知らせはありません。</b>
				</c:if>

				<form action="deleteNoticeMonth" method="post">
					<c:forEach items="${noticeList}" var="notice">
						<fmt:formatDate value="${notice.noticeDate}" pattern="yyyy年MM月dd日" />に<br>
						${notice.content}の支払いがありました。
						<button name="noticeId" value="${notice.noticesMonthId}">削除</button>
						<br>
					</c:forEach>
				</form>

			</div>

			<div class="">
				<p>
					<a href="inputMoney" class="btn btn-primary btn-lg" id="mainBtn">記入</a>
				</p>
				<p>
					<a href="displayYear" class="btn btn-primary btn-lg" id="mainBtn">閲覧</a>
				</p>
				<p>
					<a href="setting" class="btn btn-primary btn-lg" id="mainBtn">設定</a>
				</p>

			</div>



		</div>
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