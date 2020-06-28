package jp.co.example.controller;

import java.sql.Date;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import jp.co.example.entity.ItemNameAndMoney;
import jp.co.example.entity.Money;
import jp.co.example.entity.User;
import jp.co.example.service.MoneyService;

@Controller
public class CalendarController {

	@Autowired
	private MoneyService moneyService;

	@Autowired
	HttpSession session;

	@GetMapping("/calendar")
	public String hello(@RequestParam("date") String date1, HttpServletRequest request) {

		String aaa = "2";
		System.out.println(aaa);

		/*	@RequestMapping("/calendar")
			String index(HttpServletRequest request, Model model) {*/

		/*		String testYear = "2020";

				session.setAttribute("year", testYear);*/

		    	User user = (User) session.getAttribute("user");
		    	String year = (String) session.getAttribute("year");
		    	Integer numYear = Integer.parseInt(year);

		String testDate = date1 + "-01";

		Date td = Date.valueOf(testDate);
		SimpleDateFormat monthsdf = new SimpleDateFormat("MM");
		String datem = monthsdf.format(td);

		int numMonth = Integer.parseInt(datem);

		System.out.println("Date型 =>" + numMonth);

		int clickedYear = numYear;
		int clickedMonth = numMonth;

		Calendar cal = Calendar.getInstance();

		cal.set(Calendar.YEAR, clickedYear);
		cal.set(Calendar.MONTH, clickedMonth - 1);

		int max = cal.getActualMaximum(Calendar.DAY_OF_MONTH);

		//その月の最終日を取得
		//		Integer max = cal.getActualMaximum(Calendar.DATE);

		//その月を取得
		Integer nowMonth = cal.get(Calendar.MONTH) + 1;
		String.format("%02d", nowMonth);

		System.out.println("year:"+year);

		System.out.println(year+"-" + nowMonth + "-01");
		System.out.println(year+"-" + nowMonth + "-" + max);

		//date型にするためにStringで文字列作成（月初め）
		String DayStart = year+"-" + nowMonth + "-01";
		//date型にするためにStringで文字列作成（月末）
		String DayEnd = year+"-" + nowMonth + "-" + max;

		System.out.println(DayStart);
		System.out.println(DayEnd);

		//日付の文字列をdate型に変換
		Date ds = Date.valueOf(DayStart);
		Date de = Date.valueOf(DayEnd);

//		Integer testId = 1;
		//引数をセッションに保存されているusersIdに変更する。

		// その月の項目別合計値
		List<ItemNameAndMoney> monthlyMoney = moneyService.findMonthlyData(user.getUsersId(), ds, de);

		System.out.println("check1");

		if (monthlyMoney.isEmpty()) {

			request.setAttribute("monthlyMoney", 0);

			System.out.println(request.getAttribute("monthlyMoney"));

		} else {

			System.out.println("check2");
			System.out.println(monthlyMoney.get(0).getItemName());
			System.out.println(monthlyMoney.get(0).getAmount());
			request.setAttribute("monthlyMoney", monthlyMoney);

		}

		//その月の収入の合計
		List<Money> totalIncome = moneyService.findToTalIncomeOfMonth(user.getUsersId(), ds, de);

		/*		if(totalIncome.isEmpty()) {


					request.setAttribute("totalIncome", 0);

				}else {*/

		request.setAttribute("totalIncome", totalIncome.get(0).getAmount());

		//その月の支出の合計
		List<Money> totalOutgo = moneyService.findToTalOutgoOfMonth(user.getUsersId(), ds, de);

		/*		if(totalOutgo.isEmpty()) {

					request.setAttribute("totalOutgo", 0);

				}else {*/

		request.setAttribute("totalOutgo", totalOutgo.get(0).getAmount());

		//その月の収支の合計
		if (totalIncome.get(0).getAmount() == 0) {

			Integer difference = totalIncome.get(0).getAmount() - totalOutgo.get(0).getAmount();

			request.setAttribute("difference", difference);

		} else if (totalOutgo.get(0).getAmount() == 0) {

			Integer difference = totalIncome.get(0).getAmount();

			request.setAttribute("difference", difference);

		} else if ((totalIncome.get(0).getAmount() == 0) && (totalOutgo.get(0).getAmount() == 0)) {

			request.setAttribute("difference", 0);

		} else {

			Integer difference = totalIncome.get(0).getAmount() - totalOutgo.get(0).getAmount();

			request.setAttribute("difference", difference);

		}

		List<Money> money = moneyService.findMoneyForCalendar(user.getUsersId(), ds, de);

		//       String str = money.get(i).getAmount().toString();
		//       String day= money.get(i).getInputDate().toString();

		SimpleDateFormat msdf = new SimpleDateFormat("MM");
		SimpleDateFormat dsdf = new SimpleDateFormat("dd");

		int day[] = new int[max + 1];
		String dayMoney[] = new String[max + 1];

		for (int i = 1; i < day.length; i++) {

			System.out.println("check1");

			if (money.size() == 0) {
				day[i] = i;
				dayMoney[i] = "0";
			}

			for (int j = 0; j < money.size(); j++) {

				String dated = dsdf.format(money.get(j).getInputDate());
				System.out.println("date:" + dated);
				int d = Integer.parseInt(dated);
				System.out.println("d:" + d);
				System.out.println("i:" + i);

				if (i == d) {
					day[i] = d;
					dayMoney[i] = money.get(j).getAmount().toString();

					System.out.println("dayMoney1:" + dayMoney[i]);

				} else {

					System.out.println("check");

					day[i] = i;
					if ((dayMoney[i] == "0") || (dayMoney[i] == null)) {
						dayMoney[i] = "0";
					} else {

					}
				}
			}
		}

		for (int i = 0; i < max + 1; i++) {
			System.out.println(day[i]);
			System.out.println("dayMoney2:" + dayMoney[i]);
		}

		int startday;
		int lastday;
		//  カレンダーの取得

		//  年が設定されていれば、その値を取得。そうでなければ、今年の年号を入れる
		if (request.getParameter("year") == null) {
//			request.setAttribute("year", cal.get(Calendar.YEAR)); //  現在の年
			request.setAttribute("year", year); //  現在の年

		} else {
			request.setAttribute("year", request.getParameter("year")); //  現在の年
		}
		if (request.getParameter("month") == null) {
			System.out.println("checkTheMonth1");
			request.setAttribute("month", cal.get(Calendar.MONTH) + 1); //  現在の月
			System.out.println(request.getAttribute("month"));
		} else {
			System.out.println("checkTheMonth2");
			request.setAttribute("month", request.getParameter("month")); //  与えらられた月
		}
		int yearForCalendar = Integer.parseInt(request.getAttribute("year").toString());
		int month = Integer.parseInt(request.getAttribute("month").toString());

		System.out.println("month:" + month);
		// 月初めの曜日(日-> 1)
		cal.set(yearForCalendar, month - 1, 1);
		startday = cal.get(Calendar.DAY_OF_WEEK);
		// 月末の日付
		//		cal.add(Calendar.MONTH, 1);
		//		cal.add(Calendar.DATE, -1);
		lastday = max;
		//  カレンダーのデータを作成する
		int date = 1;
		int maxday = 6 * 7;
		StringBuilder sb = new StringBuilder();
		sb.append("<table>");
		sb.append("<tr>");
		sb.append("<th style=color:red;>日</th>");
		sb.append("<th>月</th><th>火</th><th>水</th><th>木</th><th>金</th>");
		sb.append("<th style=color:blue;>土</th>");
		sb.append("</tr>");
		sb.append("<tr>");
		for (int num = 1; num <= maxday; num++) {
			if (num < startday || num > lastday + startday - 1) {
				sb.append("<td></td>");
			} else {

				System.out.println("日付1=>" + date);
				System.out.println("日付2=>" + day[date]);

				if ((date == day[date])) {

					sb.append("<td>" + "<a href = \"dairyData?date="+year+"-" + String.format("%02d", month) + "-"
							+ String.format("%02d", date) + "\">" + "<b>"+date+"</b>" + "</a>"
							+ "<br>" + "<b>支出：" + dayMoney[date] +"円</b>"+"</td>");
				} else {
					sb.append("<td>" + "<a href = \"dairyData\">" + "<b>"+date+"</b>" + "</a>" + "</td>");

				}
				date++;
			}

			if (num % 7 == 0) {
				sb.append("</tr>");
				if (num > startday + lastday - 1) {
					break;
				}

				if (date <= lastday) {
					sb.append("<tr>");
				} else {
					//  最後だったら、ループから抜ける
					break;
				}
			}
		}

		sb.append("</table>");
		//  パラメータを設定
		request.setAttribute("calender", sb);

		System.out.println("checkEnd");

		return "calendar";

	}
	//    @GetMapping("/dairyData")
	//    public String hello(@RequestParam("date") String date) {
	//
	//    	System.out.println(date);
	//
	//    	return "dairyData";
	//
	//    }

	/*        for(int i = 1; i < day.length; i++) {

	if(money.size() > i) {

		i=i-1;

		String dated = dsdf.format(money.get(i).getInputDate());
		System.out.println(dated);
	int d = Integer.parseInt(dated);
	System.out.println("d:"+d);
	System.out.println("i:"+i);

	i=i+1;

	if(i == d) {
	day[i]= d;

	dayMoney[i] = money.get(i).getAmount().toString();
	System.out.println("check");
	}else {
	day[i]=i;
	dayMoney[i]="0";
	}
	}else if(money.size() <= i){
	System.out.println(i);
	day[i]=i;
	dayMoney[i]="0";
	}
	}*/

}
