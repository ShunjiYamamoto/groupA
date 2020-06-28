<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link href="./css/payment.css" rel="stylesheet">
    <title>支払い通知</title>
</head>

<body>

	<div id="header">
		<p class="systemNameTitle headerIcon">
			<span id="systemName">スーテェー簿</span>
		</p>
		<a href="setting"><span class="headerBtn headerIcon btn-lg">戻る</span></a>
		<a href="menu"><span class="headerBtn headerIcon btn-lg">メニュー</span></a>
	</div>

    <h2>支払い通知設定</h2>


    <form>

        <table class="paymentTable">
            <tr>
                <th></th>
                <th>No.</th>
                <th>日付</th>
                <th>項目</th>
                <th>オン</th>
                <th>オフ</th>
            </tr>
            <tr>
                <td><input type="checkbox"></td>
                <td>1</td>
                <td>17</td>
                <td>通信</td>
                <td><input type="radio" name="1" value="1" checked></td>
                <td><input type="radio" name="1" value="1"></td>
            </tr>
            <tr>
                <td><input type="checkbox"></td>
                <td>2</td>
                <td>15</td>
                <td>クレジット</td>
                <td><input type="radio" checked></td>
                <td><input type="radio"></td>
            </tr>
            <tr>
                <td><input type="checkbox"></td>
                <td>3</td>
                <td>25</td>
                <td>給料日</td>
                <td><input type="radio" checked></td>
                <td><input type="radio"></td>
            </tr>
            <tr>
                <td><input type="checkbox"></td>
                <td>4</td>
                <td>10</td>
                <td>奨学金</td>
                <td><input type="radio"></td>
                <td><input type="radio" checked></td>
            </tr>

        </table>

        <input type="submit" value="保存">
        <input type="submit" value="削除">

    </form>

    <form>
        <table class="paymentTable">
            <tr>
                <th>日付</th>
                <th>項目</th>
            </tr>
            <tr>
                <td><input type="text" size="3"></td>
                <td><input type="text"></td>

            </tr>
        </table>
        <input type="submit" value="追加">
    </form>


</body>

</html>