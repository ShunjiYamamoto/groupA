package jp.co.example.controller;

import java.sql.Date;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import jp.co.example.entity.Money;
import jp.co.example.entity.User;
import jp.co.example.form.FixMoneyForm;
import jp.co.example.model.SaveForDairyData;
import jp.co.example.service.FixMoneyService;

@Controller
public class FixMoneyController {



	//セッション情報
	@Autowired
	HttpSession session;

	@Autowired
	FixMoneyService fixMoneyService;


//  @GetMapping("/fixMoney")
	//日データ修正画面へ遷移
	@RequestMapping(value = "/fixMoney", method = RequestMethod.POST)
	public String fixMoney(@Validated @RequestParam("itemName") String itemName,@RequestParam("inputDate") String inputDate,@ModelAttribute("fixMoneyForm") FixMoneyForm form,BindingResult bindingResult, Model model) {

    	Date dateForDisplay = Date.valueOf(inputDate);
		/*		User user =  (User) session.getAttribute("user");
				Integer Id = user.getUsersId();*/

//		Integer Id = 1;

		User user = (User) session.getAttribute("user");

		Integer Id = user.getUsersId();

		Money DairyAmount = fixMoneyService.findDairyAmount(Id,form.getItemName(),dateForDisplay, form.getAmount());

		model.addAttribute("ItemName",form.getItemName());
		model.addAttribute("amount",DairyAmount.getAmount());
		model.addAttribute("inputDate",form.getInputDate());

		/*		List<Object> list = new ArrayList<Object>();

				list.add(model.getAttribute("ItemName"));
				list.add(model.getAttribute("amount"));
				list.add(model.getAttribute("inputDate"));*/

		SaveForDairyData DairyList = new SaveForDairyData(form.getItemName(),DairyAmount.getAmount(),form.getInputDate());

		session.setAttribute("DairyDataList", DairyList);

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

		/*		User user =  (User) session.getAttribute("user");
				Integer Id = user.getUsersId();*/

    	if(bindingResult.hasErrors()) {

    		session.getAttribute("forValidationParameter");



			/*    		String errorMsg = "値を入力して下さい。";
			    		model.addAttribute("errorMsg",errorMsg);*/

    		 SaveForDairyData sfdd = (SaveForDairyData) session.getAttribute("DairyDataList");

    		 String itemName = sfdd.getItemName();
    		 Integer amount = sfdd.getAmount();
    		 Date inputDate = sfdd.getInputDate();

    		model.addAttribute("ItemName",itemName);
    		model.addAttribute("amount",amount);
    		model.addAttribute("inputDate",inputDate);

    		return "fixMoney";
    	}

		User user = (User) session.getAttribute("user");

		Integer Id = user.getUsersId();

	   System.out.println("amount"+form.getAmount());
	   System.out.println("itemName"+form.getItemName());
	   System.out.println("date"+form.getInputDate());

		fixMoneyService.update(form.getAmount(), Id, form.getItemName(), form.getInputDate());
		model.addAttribute("inputDate",form.getInputDate());

		return "completeFixMoney";


	}
}
