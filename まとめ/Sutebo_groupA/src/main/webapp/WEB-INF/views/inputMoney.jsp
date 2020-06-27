<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>

<!DOCTYPE html>
<html>

<head>
<meta charset="UTF-8" />
<title>入力画面</title>
<style>
label {
	margin-right: 20px;
}

.disptable {
	display: table;
}

.disprow {
	display: table-row;
}

.dispcell {
	display: table-cell;
}

.back {
	margin-left: 300px;
}

.solidlineandcenterdiv {
	border-style: solid;
	padding-right: 5px;
	padding-left: 5px;
	margin-right: 33%;
	margin-left: 33%;
}

div.solidlineandcenterdiv p {
	text-align: left;
}
</style>
</head>

<body>
	<div class="back">
		<button type="submit" form="switchingAndReturn" name="return">戻る</button>
	</div>
	<div align="center">
		<h1>家計データ入力</h1>
		<br> <br> <br>
		<div style="color: red">
			<c:if test="${not empty errorMsg }">${errorMsg}</c:if>
		</div>
		<div class="disptable">
			<form:form id="switchingAndReturn" action="inputMoney"
				modelAttribute="inputMoneyForm">
				<div class="disprow">
					<div class="dispcell">
						<c:if test="${incomeOrOutgo == 2}">
							<form:button type="submit" style="background-color: greenyellow;"
								name="switchOutgo">支出</form:button>
						</c:if>
						<c:if test="${incomeOrOutgo == 1}">
							<form:button type="submit" name="switchOutgo">支出</form:button>
						</c:if>
					</div>
					<div class="dispcell">
						<pre>            </pre>
					</div>
					<div class="dispcell">
						<c:if test="${incomeOrOutgo == 1}">
							<form:button type="submit" style="background-color:greenyellow;"
								name="switchIncome">収入</form:button>
						</c:if>
						<c:if test="${incomeOrOutgo == 2}">
							<form:button type="submit" name="switchIncome">収入</form:button>
						</c:if>
					</div>
				</div>
			</form:form>
		</div>
		<p>
			<form:form action="confirmMoney"
				modelAttribute="inputMoneyForm">
				<div class="solidlineandcenterdiv">
			<form:errors  path="itemsId" cssStyle="color:red"/>
					<p>
						<label>日付</label>
						<form:input type="date" path="date" max="9999-12-31" id = "today" />
						<form:errors path="date" cssStyle="color:red" />
						<br>
					</p>
					<p>

						<label> <form:select path="itemsId">
								<c:forEach var="item" items="${userItems}">
									<form:option value="${item.itemsId}" label="${item.itemName}" />
								</c:forEach>
							</form:select>
						</label> <span><form:input type="number" path="amount" /> <form:errors
								path="amount" cssStyle="color:red" /></span>
					</p>
				</div>
				<div class="disptable">
					<div class="disprow">
						<div class="dispcell">
							<form:button type="submit" name="confirm">登録</form:button>
						</div>
						<div class="dispcell">
							<pre>      </pre>
						</div>
						<div class="dispcell">
							<form:button type="submit" form="switchingAndReturn"
								name="updateItem">項目の編集</form:button>
						</div>
						<div class="dispcell">
							<pre>      </pre>
						</div>
					</div>
				</div>
			</form:form>
		</p>
	</div>
	<script type="text/javascript">
    //今日の日時を表示
        window.onload = function () {
            //今日の日時を表示
            var date = new Date()
            var year = date.getFullYear()
            var month = date.getMonth() + 1
            var day = date.getDate()

            var toTwoDigits = function (num, digit) {
              num += ''
              if (num.length < digit) {
                num = '0' + num
              }
              return num
            }

            var yyyy = toTwoDigits(year, 4)
            var mm = toTwoDigits(month, 2)
            var dd = toTwoDigits(day, 2)
            var ymd = yyyy + "-" + mm + "-" + dd;

            document.getElementById("today").value = ymd;
        }
</script>
</body>

</html>