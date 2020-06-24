package jp.co.example.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import jp.co.example.entity.Money;
import jp.co.example.entity.User;
import jp.co.example.form.FixMoneyForm;
import jp.co.example.service.FixMoneyService;

@Controller
public class FixMoneyController {



	//セッション情報
	@Autowired
	HttpSession session;

	@Autowired
	FixMoneyService fixMoneyService;



	//日データ修正画面へ遷移
	@RequestMapping(value = "/fixMoney", method = RequestMethod.GET)
	public String fixMoney(@ModelAttribute("fixMoneyForm") FixMoneyForm form, Model model) {

		User user =  (User) session.getAttribute("user");
		Integer Id = user.getUsersId();

		Money DairyAmount = fixMoneyService.findDairyAmount(Id,form.getItemName(),form.getInputDate(), form.getAmount());

		model.addAttribute("ItemName",form.getItemName());
		model.addAttribute("amount",DairyAmount.getAmount());
		model.addAttribute("inputDate",form.getInputDate());
		return "fixMoney";
	}




	/*Integer Id = 1;
	String items = "食費";
	Date date = Date.valueOf("2020-06-01");
	Integer money = 10000;

	Money DairyAmount = fixMoneyService.findDairyAmount(Id, items, date, money);

	model.addAttribute("ItemName",form.getItemName());
	model.addAttribute("amount",DairyAmount.getAmount());
	model.addAttribute("inputDate",form.getInputDate());
	return "fixMoney";
	}
	*/


	//金額修正処理
	@RequestMapping(value = "/completeFixMoney", method = RequestMethod.POST)
	public String fixMoney(@Validated @ModelAttribute("fixMoneyForm") FixMoneyForm form, BindingResult bindingResult, Model model) {

		User user =  (User) session.getAttribute("user");
		Integer Id = user.getUsersId();

	//	Integer Id = 1;

		fixMoneyService.update(Id, form.getItemName(), form.getInputDate());
		model.addAttribute("inputDate",form.getInputDate());

		return "completefixMoney";


	}
}
