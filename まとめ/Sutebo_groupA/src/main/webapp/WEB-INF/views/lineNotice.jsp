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
<a href="setting" >戻る</a>

<h1>記入忘れ防止用通知</h1>

<p>
忘れ防止用通知の登録手順<br>

1.Line Nofityにログインする<br>
2.マイページからトークンの発行を行う<br>
　※トークルームは「1:1でLINE Notifyから通知を受け取る」を選択<br>
3.発行されたトークンをコピーする<br>
4.トークンを指定した入力フォームにペーストする<br>
5.時間を入力して保存を行う<br>

</p>

<p>発行されたトークンを入力してください。

<form:form action="line2" modelAttribute="test">

<form:input path="lineToken" value="${lineToken}"/><br>
${msg_lineToken}<br>

<p>通過をオンにすると、記入した時間に通知が送られます。</p>

<form:input path="hour" type="number" />時
<form:input path="minute" type="number" />分

<form:radiobutton path="lineNoticeOn" value="On"/>オン
<form:radiobutton path="lineNoticeOn" value="Off"/>オフ<br>
${msg_lineTime}<br>

<form:button>保存</form:button>
</form:form>

</body>
</html>