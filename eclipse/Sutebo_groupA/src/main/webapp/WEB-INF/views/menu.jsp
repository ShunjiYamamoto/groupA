<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="ja">

<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.0/css/bootstrap.min.css"
        integrity="sha384-9aIt2nRpC12Uk9gS9baDl411NQApFmC26EwAOH8WgZl5MYYxFfc+NcPb1dKGj7Sk" crossorigin="anonymous">

    <link href="./css/process.css" rel="stylesheet">
    <title>メニュー</title>
</head>

<body>
    <div class=”bg-opacity”>

        <div id="header">
            <p class="systemNameTitle headerIcon"><span id="systemName">スーテェー簿</span></p>
            <span class="headerBtn headerIcon label label-info">ログアウト</span>
        </div>

        <h2>メニュー</h2>

        <div class="main">


            <div class="news">

                <p id="notice">お知らせ</p>


                <c:if test="${not empty noticeMsg}">

                <!-- test用 -->
                <p id="noticeText">x月分のxx日はA代が未入力です。</p>
                <p id="noticeText">x月分のxx日はB代が未入力です。</p>

                </c:if>

            </div>

            <div class="">
                <p><a class="btn btn-primary btn-lg" id="mainBtn">記入</a></p>
                <p><a class="btn btn-primary btn-lg" id="mainBtn">閲覧</a></p>
                <p><a class="btn btn-primary btn-lg" id="mainBtn">設定</a></p>

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