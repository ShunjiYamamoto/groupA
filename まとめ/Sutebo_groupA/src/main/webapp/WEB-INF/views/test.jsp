<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<!DOCTYPE html>
<head>
	<meta charset="UTF-8">
	<title>テスト</title>
</head>

<body>

	<a href="/displayNoticeMonthSetting">月別通知設定</a>
	<a href="/displayItemOutgo">項目編集</a>
	<a href="menu">menu</a>



 	<p>
		<form action="deleteNoticeMonth" method="post">
			<c:forEach items="${noticeList}" var="notice">
			${notice.noticeDate}

				<fmt:formatDate value="${notice.noticeDate}" pattern="yyyy年MM月dd日" />に${notice.content}の支払いがありました。
				<button name="noticeId" value="${notice.noticesMonthId}">削除</button><br>
			</c:forEach>
		</form>
	<p>

</body>

</html>