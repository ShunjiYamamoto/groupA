package jp.co.example.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import jp.co.example.entity.User;
import jp.co.example.service.NoticeMonthService;

@Controller
public class MoneyMonthController {

	@Autowired
	private NoticeMonthService noticeMonthService;

	@Autowired
	HttpSession session;

	@RequestMapping(value="/displayMonth", method=RequestMethod.GET)
    public String ConfigurationDisplay(@RequestParam("date") String date, Model model ) {

		session.setAttribute("year",date);
		System.out.println(date);
		User user = (User) session.getAttribute("user");


		model.addAttribute("month1",noticeMonthService.monthDataSum(user.getUsersId(), date));
		model.addAttribute("incomeSum",noticeMonthService.monthSumIncome(user.getUsersId(),date));
		model.addAttribute("spendingSum",noticeMonthService.monthSumSpending(user.getUsersId(),date));
		model.addAttribute("differenceSum",noticeMonthService.monthSumIncomeSpendingDifference(user.getUsersId(),date));
		return "displayMonth";
    }






}
