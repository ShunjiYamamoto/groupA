<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>記入忘れ防止用通知</title>
</head>
<body>

<a href="menu" >メニュー</a>
<a href="configure" >戻る</a>

<h1>記入忘れ防止用通知</h1>

<p>
忘れ防止用通知の登録手順<br>

1.aaaa<br>
2.aaaa<br>
3.aaaa<br>
4.aaaa<br>
</p>

<p>発行されたトークンを入力してください。

<form:form action="token" modelAttribute="test">

<form:input path="token" /><br>

<p>通過をオンにすると、記入した時間に通知が送られます。</p>

<form:input path="hour" />時
<form:input path="minute" />分

<form:input path="lineNoticeOn" /><br>

<form:button>保存</form:button>
</form:form>

</body>
</html>