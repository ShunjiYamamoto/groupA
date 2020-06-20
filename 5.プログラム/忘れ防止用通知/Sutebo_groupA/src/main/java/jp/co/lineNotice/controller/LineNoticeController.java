package jp.co.lineNotice.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import jp.co.lineNotice.controller.form.LineNoticeForm;
import jp.co.lineNotice.entity.User;
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

		String usersId = (String) session.getAttribute("userId");  // 取得

		//トークンチェック
		User list = UserService.findByToken(usersId);

		System.out.println(list);

		if(list == null) {
			model.addAttribute("lineToken", "トークンを入力してください");
		}

		return "lineNotice";

	}
}
