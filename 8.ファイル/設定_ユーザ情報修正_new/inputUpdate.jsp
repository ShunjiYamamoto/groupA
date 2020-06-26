<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>ユーザー情報修正</title>
</head>
<body>

	<div style="text-align: center">
		<h2>ユーザー情報修正</h2>

		ユーザー情報を修正できます。<br> 修正したい情報を変更し、修正ボタンを押してください。<br>

		<c:if test="${not empty a}">
			<form:form action="userUpdateName" modelAttribute="name">
				<p>
  					<div>ユーザー名：<form:input path="userName" type="text"/>
  					<form:errors path="userName" cssStyle="color: red"/></div>
				</p>
				<form:button>修正</form:button>
			</form:form>
		</c:if>

		<c:if test="${not empty b}">
			<form:form action="userUpdatePass" modelAttribute="pass">
				<p>
					<div>現在のパスワード：<form:input path="nowPass" type="password"/><b style =color:red>${passwordNowChange}</b>
					<form:errors path="nowPass" cssStyle="color: red"/></div>

					<div>新しいパスワード：<form:input path="pass" type="password"/>
					<form:errors path="pass" cssStyle="color: red"/></div>

				<br>
				<dvi>新しいパスワード（再確認）：<form:input path="newPass" type="password"/><b style =color:red>${passwordChange}</b>
				<form:errors path="newPass" cssStyle="color: red"/></div>
				</p>
				<form:button>修正</form:button>
			</form:form>
			</c:if>

			<p>
				<a href="setting">戻る</a>
			</p>

	</div>

</body>
</html>
