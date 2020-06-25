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
	<title>支払い通知</title>
</head>

<body>

	<div class="back">
		<a href="./menu.html">メニュー</a>
		<a href="./settei.html">戻る</a>
	</div>

	<h2>支払い通知設定</h2>

	<c:if test="${not empty updateMsg}">
		${updateMsg}
	</c:if>

	<c:choose>
		<c:when test="${not empty noticeList}">
			<form:form action="updateNoticeMonthSetting" modelAttribute="updateForm">
				<table  class="paymentTable">
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
			<form:button>保存</form:button>
			</form:form>
		</c:when>
		<c:otherwise>
			通知設定はありません。<br>
			下にあるフォームから、新しく設定を追加してください。
		</c:otherwise>
	</c:choose>

	<c:if test="${!noticeLimit}">
		<form:form action="inputNoticeMonthSetting" modelAttribute="inputForm">
			<table class="paymentTable">
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
		<form:button>追加</form:button><br>
		<form:errors path="content" cssStyle="color: red"/>
		</form:form>
	</c:if>

	<c:if test="${noticeLimit}">
		登録上限に達しています。不要な設定があれば削除してください。
	</c:if>

</body>

</html>