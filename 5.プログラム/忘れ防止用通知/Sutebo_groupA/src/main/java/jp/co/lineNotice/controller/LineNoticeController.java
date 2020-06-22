package jp.co.lineNotice.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import jp.co.lineNotice.controller.form.LineNoticeForm;
import jp.co.lineNotice.service.UserService;

@Controller
public class LineNoticeController {

	@Autowired
	HttpSession session;

	@Autowired
	private UserService UserService;

	@RequestMapping("/line")
	public String back(@ModelAttribute("test") LineNoticeForm form, Model model) {

		//Http Sessionを使用して保存
		session.setAttribute("userId","b");

		String userId = (String) session.getAttribute("userId");  // 取得

		//トークンチェック
		String token = UserService.findByToken(userId);

		if(token != null) {
			model.addAttribute("lineToken", "a");
			//session.setAttribute("lineToken","b");
			System.out.println("通過");
		}

		return "lineNotice";

	}
}
