<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>ユーザー情報修正完了</title>
</head>
<body>

<div style="text-align: center">
<h2>ユーザー情報を修正しました</h2>

<p>
<c:if test="${not empty c}">
ユーザー名：<input  value=${newUesrName }  readonly><br>
</c:if>
</p>
<p>
<c:if test="${not empty d}">
<br>
パスワード：<input type="password" value=${newUserPassword } readonly>
</c:if>
</p>
<p>
<a href="setting">戻る</a>
</p>
</div>

</body>
</html>
