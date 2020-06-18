<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.0/css/bootstrap.min.css"
        integrity="sha384-9aIt2nRpC12Uk9gS9baDl411NQApFmC26EwAOH8WgZl5MYYxFfc+NcPb1dKGj7Sk" crossorigin="anonymous">
    <script src="https://code.jquery.com/jquery-3.5.1.slim.min.js"
        integrity="sha384-DfXdz2htPH0lsSSs5nCTpuj/zy4C+OGpamoFVy38MVBnE+IbbVYUew+OrCXaRkfj"
        crossorigin="anonymous"></script>
    <script src="https://cdn.jsdelivr.net/npm/popper.js@1.16.0/dist/umd/popper.min.js"
        integrity="sha384-Q6E9RHvbIyZFJoft+2mJbHaEWldlvI9IOYy5n3zV9zzTtmI3UksdQRVvoxMfooAo"
        crossorigin="anonymous"></script>
    <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.5.0/js/bootstrap.min.js"
        integrity="sha384-OgVRvuATP1z7JjHLkuOU7Xw704+h835Lr+6QL9UvYjZE3Ipu6Tp75j7Bh/kR0JKI"
        crossorigin="anonymous"></script>
    <link href="./css/index.css" rel="stylesheet">
    <title>アカウント作成</title>
<body>

   <div class=”bg-opacity”>

        <div id="header">
            <p class="systemNameTitle"><span id="systemName">スーテェー簿</span></p>
        </div>

        <h2>アカウント作成</h2>

        <div class="main">

            <div class="alert alert-dismissible alert-danger">
                <button type="button" class="close" data-dismiss="alert">×</button>
                <strong>※すでに使われているユーザーIDです。</strong>
            </div>

            <div class="errorMsg">

                ※すでに使われているユーザーIDです。<br>

            </div>

            <form:form action="" method="post" modelAttribute="">

                <fieldset>

                    <ul>

                        <div class="inputForm">

                            <li class="userId">
                                <label key="userId">ユーザーID：</label>
                                <!-- placeholderは消してください。 -->
                                <input id="userId" type="text" size="25" placeholder="12345678901234567890">
                            </li>
                            <li class="userName">
                                <label key="userName">ユーザー名：</label>
                                <input id="userName" type="text" size="25">
                            </li>
                            <li class="password">
                                <label for="password">パスワード：</label>
                                <input id="password" type="password" size="25">
                            </li>

                        </div>

                        <li><button class="btn btn-primary" id="mainBtn">登録</button>
                            <a href="index" id class="btn btn-primary" id="backBtn">戻る</a>
                        </li>
                    </ul>

                </fieldset>

            </form:form>
        </div>
    </div>

</body>
</html>