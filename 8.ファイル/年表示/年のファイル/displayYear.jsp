<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>

<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link rel="stylesheet"
	href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.0/css/bootstrap.min.css"
	integrity="sha384-9aIt2nRpC12Uk9gS9baDl411NQApFmC26EwAOH8WgZl5MYYxFfc+NcPb1dKGj7Sk"
	crossorigin="anonymous">
    <title>閲覧：年表示</title>
</head>
<body>
    <h1>年表示画面</h1>
    <br>
    年選択
    <br>
    <br>
    <table  border="1" align="center">
    	<thead>
			<tr>
				<th>西暦</th>
<!-- 				<th>収入</th> -->
<!-- 				<th>支出</th> -->
<!-- 				<th>差額</th> -->
			</tr>
		</thead>
		<tbody>
			<c:forEach var="year2" items="${year1}">
				<tr>
					<td><a href = "displayMonth?date=${year2.years }">${year2.years}</a></td>

				</tr>
			</c:forEach>
<!-- 				<thead> -->
<!-- 			<tr> -->
<!-- 				<th>合計</th> -->
<%-- 				<th>${incomeSum }円</th> --%>
<%-- 				<th>${spendingSum }円</th> --%>
<%-- 				<th>${differenceSum }円</th> --%>
<!-- 			</tr> -->
<!-- 		</thead> -->
		</tbody>
    </tbody>
  </table>
<!--         <tr> -->
<!--             <td> -->
<!--                 <a href="">2020</a> -->
<!--             </td> -->
<!--             <td>年</td> -->
<!--         </tr> -->
<!--         <tr> -->
<!--             <td> -->
<!--                 <a href="">2021</a> -->
<!--             </td> -->
<!--             <td>年</td> -->
<!--         </tr> -->
<!--         <tr> -->
<!--             <td> -->
<!--                 <a href="">2022</a> -->
<!--             </td> -->
<!--             <td>年</td> -->
<!--         </tr> -->
    </table>
    <br>
    <!-- <form action="" method="post">
        <button type="submit">年を追加</button>
    </form> -->
    <br>
    <form action="" method="post">
        <button type="submit"><a href ="menu">メニュー</a></button>
    </form>
</body>
</html>