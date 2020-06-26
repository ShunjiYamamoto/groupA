package jp.co.example.controller;

import java.sql.Date;
import java.text.SimpleDateFormat;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestParam;

import jp.co.example.entity.ItemNameAndMoney;
import jp.co.example.entity.User;
import jp.co.example.form.FixMoneyForm;
import jp.co.example.service.MoneyService;

@Controller
public class DairyDataController {

	@Autowired
    private MoneyService moneyService;

	@Autowired
	HttpSession session;

    @GetMapping("/dairyData")
    public String hello(@ModelAttribute("fixMoneyForm") @RequestParam("date") String date, HttpServletRequest request, FixMoneyForm form ) {

//    	Integer testId = 1;
    	User user = (User) session.getAttribute("user");

//    	結合時にtestIdをuser.getUsersIdに変更する。

        List<ItemNameAndMoney> dairyMoney = moneyService.findDairyData(user.getUsersId(),date);

		if(dairyMoney.isEmpty()) {

			request.setAttribute("dairyMoney", 0);

		}else {

		//その日のデータをリクエストスコープに保存。
		request.setAttribute("dairyMoney", dairyMoney);

		}

        Date d = Date.valueOf(date);
        SimpleDateFormat msdf = new SimpleDateFormat("MM");
        SimpleDateFormat dsdf = new SimpleDateFormat("dd");
        String datem = msdf.format(d);
        String dated = dsdf.format(d);
        String dairyDate = (datem +"月"+dated+"日の内訳");
        String dairyDateSession = ("2020-"+datem +"-"+dated);

        //その日をリクエストスコープに保存。
        request.setAttribute("datem", datem);
        request.setAttribute("date", dairyDateSession);
        request.setAttribute("dairyDate", dairyDate);

    	System.out.println(date);
    	System.out.println(datem);

    	return "dairyData";

    }

}
