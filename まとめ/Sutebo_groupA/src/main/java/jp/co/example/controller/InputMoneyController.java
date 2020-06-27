package jp.co.example.controller;

import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import jp.co.example.entity.User;
import jp.co.example.form.InputMoneyForm;
import jp.co.example.service.ItemService;
import jp.co.example.service.MoneyService;

@Controller
public class InputMoneyController {

	@Autowired
	HttpSession session;

	@Autowired
	ItemService itemService;

	@Autowired
	MoneyService moneyService;

	SimpleDateFormat dateFormatTypePrint = new SimpleDateFormat("yyyy/MM/dd");
	SimpleDateFormat dateFormatTypeInsert = new SimpleDateFormat("yyyy-MM-dd");

	//inputMoneyページへの遷移
	@RequestMapping("/inputMoney")
	public String inputMoneyPagePrint(@ModelAttribute("inputMoneyForm") InputMoneyForm form, Model model) {
		session.setAttribute("incomeOrOutgo", 2);
		setItemList(model);
		return "inputMoney";
	}

	//支出を入力できるプルダウンに切り替えるスイッチングメソッド
	@RequestMapping(value = "/inputMoney", params = "switchOutgo")
	public String inputMoneyPageSwitchOutgoSession(@ModelAttribute("inputMoneyForm") InputMoneyForm form, Model model) {
		session.setAttribute("incomeOrOutgo", 2);
		setItemList(model);
		return "inputMoney";
	}

	//収入を入力できるプルダウンに切り替えるスイッチングメソッド
	@RequestMapping(value = "/inputMoney", params = "switchIncome")
	public String inputMoneyPageSwitchIncomeSession(@ModelAttribute("inputMoneyForm") InputMoneyForm form,
			Model model) {
		session.setAttribute("incomeOrOutgo", 1);
		setItemList(model);
		return "inputMoney";
	}

	//formの値を保持して、その値をまたformに入れてconfirmMoneyInputページへの遷移
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	@RequestMapping(value = "/confirmMoney", params = "confirm")
	public String confirmMoneyInput(@Validated @ModelAttribute("inputMoneyForm")  InputMoneyForm form,
			BindingResult bindingResult, Model model) {
		if(bindingResult.hasErrors()) {
			model.addAttribute("errorMsg", "入力内容をよくご確認ください");
			setItemList(model);
			return "inputMoney";
		}
		session.setAttribute("lastMoneyInsertDate", form.getDate());
		model.addAttribute("moneyAmount", form.getAmount().toString());
		model.addAttribute("moneyDateString", dateFormatTypePrint.format(form.getDate()));
		model.addAttribute("moneyDate", dateFormatTypeInsert.format(form.getDate()));
		model.addAttribute("moneyItemsId", form.getItemsId());
		model.addAttribute("moneyItemName", itemService.itemsIdConvertItemName(form.getItemsId()));
		return "confirmMoneyInput";
	}

	//前画面のformから値を取得してinsertしつつcompleteMoneyInputページに遷移する
	@RequestMapping(value = "/completeMoneyInput", params = "insert")
	public String completeMoneyInput(@ModelAttribute("inputMoneyForm") InputMoneyForm form, Model model) {
		try{
		moneyService.insertMoneys(form);
		}catch(Exception e) {
			model.addAttribute("errorMsg","データの挿入に失敗しました。もう一度入力内容を確認して記入しなおしてください。<br>現状、既に入力されているデータに関しては再度入力し上書きすることはできません。修正画面にてご修正ください。");
			return "forward:inputMoney";
		}
		Date lastMoneyInsertDate = (Date) session.getAttribute("lastMoneyInsertDate");
		SimpleDateFormat sdf1 = new SimpleDateFormat("yyyy年MM月");
		SimpleDateFormat sdf2 = new SimpleDateFormat("yyyy年MM月dd日");
		SimpleDateFormat sdf3 = new SimpleDateFormat("MM月dd日");
		SimpleDateFormat sdf4 = new SimpleDateFormat("yyyy");

		model.addAttribute("moneyDateYearAndMonth", sdf1.format(lastMoneyInsertDate));
		model.addAttribute("moneyDateFull", sdf2.format(lastMoneyInsertDate));
		model.addAttribute("moneyDateMonthAndDate", sdf3.format(lastMoneyInsertDate));
		model.addAttribute("moneyDateTypeInsert", dateFormatTypeInsert.format(lastMoneyInsertDate));
		session.setAttribute("year", sdf4.format(lastMoneyInsertDate));
		return "completeMoneyInput";
	}

	//menuページに遷移するだけ
	@RequestMapping(value = "/moneyDirect", params = "menu")
	public String completeMoneyPageDirectMenu(@ModelAttribute("inputMoneyForm") InputMoneyForm form, Model model) {
		return "menu";
	}

	//使用できるか不明なのでコメントアウト
	//
	//	//displayMonthページに遷移するだけ
	//	@RequestMapping(value = "/moneyDirect", params = "displayMonth")
	//	public String completeMoneyPageDirectDisplayMonth(@ModelAttribute("inputMoneyForm") InputMoneyForm form,
	//			Model model) {
	//		return "displayMonth";
	//	}
	//
	//	//diaryDataページに遷移するだけ
	//	@RequestMapping(value = "/moneyDirect", params = "dairyData")
	//	public String completeMoneyPageDirectDiaryData(@ModelAttribute("inputMoneyForm") InputMoneyForm form, Model model) {
	//		return "dairyData";
	//	}

	//updateItemページに遷移するだけ
	@RequestMapping(value = "/inputMoney", params = "updateItem")
	public String inputMoneyPageDirectUpdateItem(@ModelAttribute("inputMoneyForm") InputMoneyForm form, Model model) {
		int isOutgo = (int) session.getAttribute("incomeOrOutgo");
		String send;
		if(isOutgo == 1 ) {
			send = "forward:/displayItemIncome";
		}else{
			send = "forward:/displayItemOutgo";
		}
		return send;
	}

	//inputMoneyページからmenuページに遷移するだけ
	@RequestMapping(value = "/inputMoney", params = "return")
	public String pageReturnInInputMoney(@ModelAttribute("inputMoneyForm") InputMoneyForm form, Model model) {
		return "forward:/menu";
	}

	//confirmMoneyInputページからinputMoneyページに遷移するだけ
	@RequestMapping(value = "/completeMoneyInput", params = "inputReturn")
	public String pageReturnInConfirmMoneyInput(@ModelAttribute("inputMoneyForm") InputMoneyForm form, Model model) {
		return "forward:/inputMoney";
	}

	//completeMoneyInputページからinputMoneyページに遷移するだけ
	@RequestMapping(value = "/moneyDirect", params = "inputReturn")
	public String pageReturnInCompleteMoneyInput(@ModelAttribute("inputMoneyForm") InputMoneyForm form, Model model) {
		return "forward:/inputMoney";
	}

	//itemListをモデルに入れる処理を簡略化したメソッド
	private void setItemList(Model model) {
		int incomeOrOutgo = (int) session.getAttribute("incomeOrOutgo");
		model.addAttribute("userItems", itemService.findItem(((User) session.getAttribute("user")).getUsersId(), incomeOrOutgo));
	}
}