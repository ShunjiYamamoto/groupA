<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>アカウント登録確認</title>
</head>
<body>

<h1>アカウント作成確認画面</h1>

<p>これでいいですか</p>


<form:form action="confirm" modelAttribute="test">
ユーザーID：<form:input path="userId" disabled="true"/><br>
ユーザー名：<form:input path="userName" disabled="true"/><br>
Password：<form:input path="password" disabled="true" type="password"/><br>
</form:form>

<form:form action="confirm" modelAttribute="test2">
<p>Password確認：<form:password path="rePassword" />${msg_rePassword}</p><br>

<form:button>送信</form:button>
</form:form>

<a href="account" >戻る</a>

</body>
</html>