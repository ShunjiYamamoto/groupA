<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>ユーザー削除</title>
</head>
<body>

	<div style="text-align: center">
		<h2>ユーザー削除</h2>

		ユーザー情報と家計簿のデータを全て削除できます。<br> パスワードを入力し、削除ボタンを押してください。<br>

		<form:form action="userDateAllDelete" modelAttribute="delete">
			<p>
				<div>パスワード：<form:input path="password" type="password"/><b style= color:red>${passwordChange}</b>
				<form:errors path="password" cssStyle="color: red"/></div>
			</p>
			<form:button>削除</form:button>
		</form:form>

		<p>
			<a href="setting" >戻る</a>
		</p>
	</div>

</body>
</html>
