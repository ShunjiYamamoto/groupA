package jp.co.example.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import jp.co.example.entity.User;
import jp.co.example.service.YearService;

@Controller
public class DisplayYearController {

	@Autowired
	private YearService yearService;

	@Autowired
	HttpSession session;

	@RequestMapping("/displayYear")
    public String displayYear(Model model) {

		User user = (User) session.getAttribute("user");
		//session.setAttribute("year1",yearService.yearDate(user.getUsersId()));
		model.addAttribute("year1", yearService.yearDate(user.getUsersId()));


        return "displayYear";
    }

}
