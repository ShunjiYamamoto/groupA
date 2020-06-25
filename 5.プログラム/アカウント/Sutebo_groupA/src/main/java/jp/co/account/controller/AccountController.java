package jp.co.account.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import jp.co.account.controller.form.AccountForm;
import jp.co.account.controller.form.ConfirmPasswordForm;
import jp.co.account.entity.User;
import jp.co.account.service.UserService;
import jp.co.account.util.ParamUtil;

@Controller
public class AccountController {

	@Autowired
	HttpSession session;

	@RequestMapping("/menu")
	public String back(@ModelAttribute("test") AccountForm form, Model model) {

		return "menu";

	}
	@RequestMapping("/account")
	public String index(@ModelAttribute("test") AccountForm form, Model model) {

		return "createAccount";

	}

	@Autowired
	private UserService UserService;

	@RequestMapping(value="/create", method=RequestMethod.POST)
	public String post(@ModelAttribute("test") AccountForm form,@ModelAttribute("test2") ConfirmPasswordForm form2, Model model) {

		boolean check = false;

		//入力チェック
		if(ParamUtil.isNullOrEmpty(form.getUserId()) == true){
			model.addAttribute("msg_userId", "ユーザーIDが入力されていません");
			check = true;
		}
		if(ParamUtil.isNullOrEmpty(form.getUserName()) == true){
			model.addAttribute("msg_userName", "ユーザー名が入力されていません");
			check = true;
		}
		if(ParamUtil.isNullOrEmpty(form.getPassword()) == true){
			model.addAttribute("msg_Password", "Passwordが入力されていません");
			check = true;
		}

		//ユーザーID重複チェック
		User list = UserService.findById(form.getUserId());

		if(list != null) {
			model.addAttribute("msg_userId", "入力したユーザーIDはすでに使用されています");
			check = true;
		}

		if(check == true) {
			return "createAccount";
		}

		//Http Sessionを使用して保存
		session.setAttribute("userId",form.getUserId());
		session.setAttribute("userName",form.getUserName());
		session.setAttribute("password",form.getPassword());

		return "confirmAccount";
	}

	@RequestMapping(value="/confirm", method=RequestMethod.POST)
	public String post2(@ModelAttribute("test") AccountForm form,@ModelAttribute("test2") ConfirmPasswordForm form2, Model model) {

		//Http Sessionを使用して取得
		String userId = (String) session.getAttribute("userId");  // 取得
		String userName = (String) session.getAttribute("userName");  // 取得
		String password = (String) session.getAttribute("password");  // 取得

		if(ParamUtil.isNullOrEmpty(form2.getRePassword()) == true) {
			model.addAttribute("msg_rePassword", "Password確認が入力されていません");
			return "confirmAccount";

		}else if(form2.getRePassword().equals(password) != true) {
			model.addAttribute("msg_rePassword", "Passwordが間違っています");
			return "confirmAccount";
		}

		//insert実行
		UserService.insert(userId,userName,password);

		session.invalidate(); // クリア
		return "completeAccount";

	}
}