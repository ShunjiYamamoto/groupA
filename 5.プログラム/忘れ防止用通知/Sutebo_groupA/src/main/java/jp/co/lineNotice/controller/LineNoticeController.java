package jp.co.lineNotice.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import jp.co.lineNotice.controller.form.LineNoticeForm;
import jp.co.lineNotice.service.UserService;
import jp.co.lineNotice.util.ParamUtil;

@Controller
public class LineNoticeController {

	@Autowired
	HttpSession session;

	@Autowired
	private UserService UserService;

	@RequestMapping("/line")
	public String lineSet(@ModelAttribute("test") LineNoticeForm form, Model model) {

		//Http Sessionを使用して保存
		session.setAttribute("userId","b");

		String userId = (String) session.getAttribute("userId");  // 取得

		//トークンチェック
		String token = UserService.findByToken(userId);

		if(token != null) {
			model.addAttribute("lineToken", token);
		}else {
			model.addAttribute("lineToken", null);
		}

		return "lineNotice";

	}

	@RequestMapping("/line2")
	public String lineCheck(@ModelAttribute("test") LineNoticeForm form, Model model) {

		String userId = (String) session.getAttribute("userId");  // 取得
		boolean check = false;

		if(ParamUtil.isNullOrEmpty(form.getLineToken()) == true){
			model.addAttribute("msg_lineToken", "トークンが入力されていません");
			check = true;
		}
		if(ParamUtil.isNullOrEmptyNumber(form.getHour()) == true){
			model.addAttribute("msg_lineTime", "時間が入力されていません");
			check = true;

		}else if(ParamUtil.isNullOrEmptyNumber(form.getMinute()) == true){
			model.addAttribute("msg_lineTime", "時間が入力されていません");
			check = true;
		}

		if(check ==false) {

			int a = UserService.update(userId,form.getLineToken(),form.getHour(),form.getMinute(),form.getLineNoticeOn());

		}

		return "lineNotice";


	}
}
