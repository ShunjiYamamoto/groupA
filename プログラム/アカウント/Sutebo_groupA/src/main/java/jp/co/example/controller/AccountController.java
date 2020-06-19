package jp.co.example.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import jp.co.example.controller.form.AccountForm;
import jp.co.example.controller.form.ConfirmPasswordForm;
import jp.co.example.entity.User;
import jp.co.example.service.UserService;
import jp.co.example.util.ParamUtil;

@Controller
public class AccountController {

	@RequestMapping("/account")
	public String index(@ModelAttribute("test") AccountForm form, Model model) {

		return "createAccount";

	}

	@Autowired
	private UserService UserService;

	@RequestMapping(value="/create", method=RequestMethod.POST)
	public String post(@ModelAttribute("test") AccountForm form,@ModelAttribute("test2") ConfirmPasswordForm form2, Model model) {

		boolean check = false;

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

		User list = UserService.findById(form.getUserId());

		System.out.println(list);

		if(check == true || list != null) {
			return "createAccount";
		}

		return "confirmAccount";
	}

	@RequestMapping(value="/confirm", method=RequestMethod.POST)
	public String post2(@ModelAttribute("test") AccountForm form,ConfirmPasswordForm form2, Model model) {

		if(ParamUtil.isNullOrEmpty(form2.getRePassword()) == true) {
			model.addAttribute("msg_rePassword", "Password確認が入力されていません");
			return "confirmAccount";
		}

		//insert実行
		UserService.insert(form.getUserId(),form.getUserName(),form.getPassword());

		return "completeAccount";

	}
}