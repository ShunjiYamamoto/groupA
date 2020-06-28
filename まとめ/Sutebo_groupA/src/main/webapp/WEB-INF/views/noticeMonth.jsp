<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<!DOCTYPE html>
<head>
<link rel="stylesheet"
	href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.0/css/bootstrap.min.css"
	integrity="sha384-9aIt2nRpC12Uk9gS9baDl411NQApFmC26EwAOH8WgZl5MYYxFfc+NcPb1dKGj7Sk"
	crossorigin="anonymous">
<link href="./css/payment.css" rel="stylesheet">
</head>

<body>

	<div id="header">
		<p class="systemNameTitle headerIcon">
			<span id="systemName">スーテェー簿</span>
		</p>
		<a href="setting"><span class="headerBtn headerIcon btn-lg">戻る</span></a>
		<a href="menu"><span class="headerBtn headerIcon btn-lg">メニュー</span></a>
	</div>

	<h2>支払い通知設定</h2>

	<c:if test="${not empty updateMsg}">
		<h4>${updateMsg}</h4>
	</c:if>

	<c:choose>
		<c:when test="${not empty noticeList}">
			<form:form action="updateNoticeMonthSetting" modelAttribute="updateForm">

				<table>
					<tr>
						<th>日付</th>
						<th>項目</th>
						<th>設定</th>
					</tr>
					<c:forEach items="${noticeList}" var="notice" varStatus="status">
						<tr>
							<td>
								<c:choose>
								<c:when test="${notice.noticeDay == 29}">
									月末
								</c:when>
								<c:otherwise>
									${notice.noticeDay}日
								</c:otherwise>
							</c:choose>
							</td>
							<td>${fn:escapeXml(notice.content)}</td>
							<td>
								<c:choose>
									<c:when test="${notice.noticeOn}">
										<form:radiobutton path="settingList[${status.index}].choice" value="on" checked="checked" />オン
										<form:radiobutton path="settingList[${status.index}].choice" value="off" />オフ
									</c:when>
									<c:otherwise>
										<form:radiobutton path="settingList[${status.index}].choice" value="on" />オン
										<form:radiobutton path="settingList[${status.index}].choice" value="off" checked="checked" />オフ
									</c:otherwise>
								</c:choose>
								<form:radiobutton path="settingList[${status.index}].choice" value="delete"/>削除
							</td>
						</tr>
					</c:forEach>
				</table>

			<center><form:button class="btn btn-primary btn-lg" id="mainBtn">保存</form:button></center>
			</form:form>
		</c:when>
		<c:otherwise>
			<h4>通知設定はありません。</h4>
			<h4>下にあるフォームから、新しく設定を追加してください。</h4>
		</c:otherwise>
	</c:choose>


	<c:if test="${!noticeLimit}">
		<form:form action="inputNoticeMonthSetting" modelAttribute="inputForm">
					<h4><form:errors path="content" cssStyle="color: red"/></h4>
			<table>
		    	<tr>
					<th>日付</th>
					<th>項目</th>
				</tr>
				<tr>
					<td>
						 <form:select path="noticeDay">
	        				<form:options items="${dayList}"/>
	   					 </form:select>
					</td>
					<td><form:input path="content" /></td>
				</tr>
			</table>
		<center><form:button class="btn btn-primary btn-lg" id="mainBtn">追加</form:button></center>

		</form:form>
	</c:if>

	<c:if test="${noticeLimit}">
		<h4>登録上限に達しています。不要な設定があれば削除してください。</h4>
	</c:if>

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