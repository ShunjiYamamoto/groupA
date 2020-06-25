package jp.co.account.controller;

import java.util.Locale;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import jp.co.account.controller.form.LoginForm;
import jp.co.account.entity.User;
import jp.co.account.service.UserService;

@Controller
public class LoginController {


	//メッセージ取得用
	@Autowired
	MessageSource messageSource;

	//セッション情報
	@Autowired
	HttpSession session;

	//userService
	@Autowired
	private UserService userService;

	//ログイン画面遷移
	@RequestMapping("/login")
	public String login(@ModelAttribute("loginForm") LoginForm form, Model model) {
		return "loginPage";
	}


	@RequestMapping("/index")
	public String index (Model model) {
		return "index";
	}


	//ログイン処理（ログイン画面のログインボタン押下）
	@RequestMapping(value = "/menu", method = RequestMethod.POST)
	public String login(@Validated @ModelAttribute("loginForm") LoginForm form, BindingResult bindingResult, Model model) {

		String errMsg = messageSource.getMessage("login.error", null, Locale.getDefault());

		System.out.println(form.getUserId());

		if (bindingResult.hasErrors()) {

			System.out.println(1);
			return "loginPage";
		}

		System.out.println(2);

		User user = userService.authentication(form.getUserId(), form.getPassword());

	    boolean  check = userService.deleteGet(form.getUserId(), form.getPassword());

		if(user == null || check == true ){
			//ログイン失敗
			System.out.println(3);
			model.addAttribute("errMsg", errMsg);
			return "loginPage";
		} else {
			//ログイン成功

			//ログインユーザ情報をセッションにセット
//			SessionInfo sessionInfo = ParamUtil.getSessionInfo(session);
			session.setAttribute("user", user);

			return "menu";

		}
	}


}
