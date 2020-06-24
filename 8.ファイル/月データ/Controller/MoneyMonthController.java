package jp.co.example.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import jp.co.example.service.NoticeMonthService;

@Controller
public class MoneyMonthController {

	@Autowired
	private NoticeMonthService noticeMonthService;

	@RequestMapping("/displayMonth")
    public String ConfigurationDisplay(Model model) {
		model.addAttribute("month1",noticeMonthService.monthDataSum(1));
		model.addAttribute("incomeSum",noticeMonthService.monthSumIncome(1));
		model.addAttribute("spendingSum",noticeMonthService.monthSumSpending(1));
		model.addAttribute("differenceSum",noticeMonthService.monthSumIncomeSpendingDifference(1));
		return "displayMonth";
    }






}
