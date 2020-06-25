package jp.co.example.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import jp.co.example.entity.User;
import jp.co.example.service.NoticeMonthService;

@Controller
public class MoneyMonthController {

	@Autowired
	private NoticeMonthService noticeMonthService;

	@Autowired
	HttpSession session;

	@RequestMapping("/displayMonth")
    public String ConfigurationDisplay(Model model) {

		User user = (User) session.getAttribute("user");


		model.addAttribute("month1",noticeMonthService.monthDataSum(user.getUsersId()));
		model.addAttribute("incomeSum",noticeMonthService.monthSumIncome(user.getUsersId()));
		model.addAttribute("spendingSum",noticeMonthService.monthSumSpending(user.getUsersId()));
		model.addAttribute("differenceSum",noticeMonthService.monthSumIncomeSpendingDifference(user.getUsersId()));
		return "displayMonth";
    }






}
