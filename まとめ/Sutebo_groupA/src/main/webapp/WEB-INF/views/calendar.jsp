<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import="java.util.*"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="stylesheet"
	href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.0/css/bootstrap.min.css"
	integrity="sha384-9aIt2nRpC12Uk9gS9baDl411NQApFmC26EwAOH8WgZl5MYYxFfc+NcPb1dKGj7Sk"
	crossorigin="anonymous">
<script src="https://code.jquery.com/jquery-3.5.1.slim.min.js"
	integrity="sha384-DfXdz2htPH0lsSSs5nCTpuj/zy4C+OGpamoFVy38MVBnE+IbbVYUew+OrCXaRkfj"
	crossorigin="anonymous"></script>
<script
	src="https://cdn.jsdelivr.net/npm/popper.js@1.16.0/dist/umd/popper.min.js"
	integrity="sha384-Q6E9RHvbIyZFJoft+2mJbHaEWldlvI9IOYy5n3zV9zzTtmI3UksdQRVvoxMfooAo"
	crossorigin="anonymous"></script>
<script
	src="https://stackpath.bootstrapcdn.com/bootstrap/4.5.0/js/bootstrap.min.js"
	integrity="sha384-OgVRvuATP1z7JjHLkuOU7Xw704+h835Lr+6QL9UvYjZE3Ipu6Tp75j7Bh/kR0JKI"
	crossorigin="anonymous"></script>
<link href="./css/index.css" rel="stylesheet">
<title>カレンダー</title>
</head>
<body>

	<div class=”bg-opacity”>

        <div id="header">
            <p class="systemNameTitle headerIcon"><span id="systemName">スーテェー簿</span></p>

            <span class="headerBtn headerIcon label label-info"><a href = "displayMonth?date=${year}">戻る</a></span>
            <span class="headerBtn headerIcon label label-info"><a href = "menu">メニュー</a></span>
        </div>

		<h2><%=request.getAttribute("year")%>年<%=request.getAttribute("month")%>月のカレンダー
		</h2>


		<div id="titleAndTotal" class="calendarPageElement totalPage">
			<table>
				<tbody>
					<tr>
						<td>月収入</td>
						<td>${totalIncome}</td>
					</tr>
					<tr>
						<td>月支出</td>
						<td>${totalOutgo}</td>
					</tr>
					<tr>
						<td>差額</td>
						<td>${difference}</td>
					</tr>
				</tbody>
			</table>


		</div>

		<div class="main">

			<div class="calendarPageElement calendarPage">
				<%=request.getAttribute("calender")%>
			</div>

			<div id="inlineA" class="calendarPageElement eachMoney">
				<table>
					<tr>
						<th>項目</th>
						<th>金額</th>
					<tbody>

						<c:choose>
							<c:when test="${monthlyMoney =='0'}">
								<tr>
									<td>NoData</td>
									<td>0</td>
								</tr>
							</c:when>
							<c:when test="${monthlyMoney != '0'}">
								<c:forEach items="${monthlyMoney}" var="list">
									<tr>
										<td class="itemName">${list.itemName}</td>
										<td class="amount">${list.amount}</td>
									</tr>
								</c:forEach>
							</c:when>
						</c:choose>

					</tbody>

				</table>
			</div>
			<br />
			<div id="inlineA" class="pieChart calendarPageElement">
				<canvas id="myPieChart"></canvas>
			</div>
			<script
				src="https://cdnjs.cloudflare.com/ajax/libs/Chart.js/2.7.2/Chart.bundle.js"></script>
			<script type="text/javascript" src="piechart.js"></script>

		</div>

	</div>

</body>
</html>

<%-- <b>カレンダーの変更</b>
<br/>
<div style="text-align:center;">
<form action="CalenderAccess" method="get">
<select id="year" name="year">
<%
    int year = Integer.parseInt(request.getAttribute("year").toString());
    int month = Integer.parseInt(request.getAttribute("month").toString());
    for(int i = year-10; i <= year+10; i++){
%>
<option value="<%=i %>"
<%
        if(i == year){
%>
selected
<%
        }
%>
><%=i %>年</option>
<%
    }
%>
</select>

<select id="moneth" name="month">
<%
    for(int i = 1; i <= 12; i++){
%>
<option value="<%=i %>"
<%
        if(i == month){
%>
selected
<%
        }
%>
><%=i %>月</option>
<%
    }
%>
</select>
<br/>
<br/>
<input type="submit" id="ok" name="ok" value="送信"/>
</form>
</div> --%>




<!-- fullcalendar -->

<%-- <%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<!-- <link rel='stylesheet' href='webjars/fullcalendar/3.5.1/dist/fullcalendar.css' /> -->
<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/fullcalendar/3.4.0/fullcalendar.min.css">
<title>カレンダー</title>
</head>
<body>

<div id='calendar'></div>

<!-- <script src="webjars/jquery/2.0.3/jquery.min.js"></script>
<script src='webjars/moment/2.19.1/min/moment.min.js'></script>
<script src='webjars/fullcalendar/3.5.1/dist/fullcalendar.js'></script> -->

<script src="https://code.jquery.com/jquery-3.2.1.min.js"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/moment.js/2.18.1/moment.min.js"></script>
<!-- <script src="https://cdnjs.cloudflare.com/ajax/libs/fullcalendar/3.4.0/fullcalendar.min.js"></script> -->
<script type="text/javascript" src="./js/url.js"></script>
<script src="../js/ja.js"></script>
<script type="text/javascript" src="./js/fullcalendar.min.js"></script>

<script type="text/javascript">
$(document).ready(function() {
    $('#calendar').fullCalendar({
      events: {
        url : '/api/event/all'
      }
    });
});

</script>
</body>
</html> --%>