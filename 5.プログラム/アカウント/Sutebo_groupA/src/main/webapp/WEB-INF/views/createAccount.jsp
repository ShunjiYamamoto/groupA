<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>アカウント作成</title>
</head>
<body>

<h1>アカウント作成</h1>


<form:form action="create" modelAttribute="test">

<p>ユーザーID：<form:input path="userId" />${msg_userId}</p><br>
<p>ユーザー名：<form:input path="userName" />${msg_userName}</p><br>
<p>Password：<form:password path="password" />${msg_Password}</p><br>

<form:button>送信</form:button>
</form:form>

<a href="menu" >戻る</a>

</body>
</html>