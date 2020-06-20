package jp.co.lineNotice.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import jp.co.lineNotice.controller.form.LineNoticeForm;
import jp.co.lineNotice.entity.User;
import jp.co.lineNotice.service.UserService;

@Controller
public class LineNoticeController {

	@RequestMapping("/line")
	public String back(@ModelAttribute("test") LineNoticeForm form, Model model) {

		//トークンチェック
		User list = UserService.findByToken(form.getLineToken());

		model.addAttribute("token", "トークンを入力してください");
		return "lineNotice";

	}
}
