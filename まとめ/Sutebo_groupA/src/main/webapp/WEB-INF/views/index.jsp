<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.0/css/bootstrap.min.css"
        integrity="sha384-9aIt2nRpC12Uk9gS9baDl411NQApFmC26EwAOH8WgZl5MYYxFfc+NcPb1dKGj7Sk" crossorigin="anonymous">

    <link href="./css/index.css" rel="stylesheet">
<title>トップ画面</title>
</head>
<body>

<div class=”bg-opacity”>
        <div id="header">
            <p class="systemNameTitle"><span id="systemName">スーテェー簿</span></p>
        </div>

        <div class="main">

            <div id="top-img">

                <img border="0" src="./img/kotowaza_neko_koban.png" width="128" height="128" alt="トップ画像-猫ちゃん">

            </div>

            <div id="topMessage">
                <p>家計簿アプリ「<span id="systemName">スーテェー簿</span>」の<br>ご利用ありがとうございます。</p>
                <p>浪費を無くし、自由なお金を増やし<br>豊かな人生を送りませんか？
                </p>
            </div>
            <div id="topBtn">
                <a href="login" id="mainBtn" class="btn btn btn-primary">ログイン画面</a>
                <a href="createAccount" id="createAccount" class="btn btn btn-primary">アカウント作成</a>
            </div>
        </div>
    </div>

        <script src="https://code.jquery.com/jquery-3.5.1.slim.min.js"
        integrity="sha384-DfXdz2htPH0lsSSs5nCTpuj/zy4C+OGpamoFVy38MVBnE+IbbVYUew+OrCXaRkfj"
        crossorigin="anonymous"></script>
    <script src="https://cdn.jsdelivr.net/npm/popper.js@1.16.0/dist/umd/popper.min.js"
        integrity="sha384-Q6E9RHvbIyZFJoft+2mJbHaEWldlvI9IOYy5n3zV9zzTtmI3UksdQRVvoxMfooAo"
        crossorigin="anonymous"></script>
    <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.5.0/js/bootstrap.min.js"
        integrity="sha384-OgVRvuATP1z7JjHLkuOU7Xw704+h835Lr+6QL9UvYjZE3Ipu6Tp75j7Bh/kR0JKI"
        crossorigin="anonymous"></script>

</body>
</html>