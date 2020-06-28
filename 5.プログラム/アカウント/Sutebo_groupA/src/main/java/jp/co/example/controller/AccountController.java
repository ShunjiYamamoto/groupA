package jp.co.example.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import jp.co.example.dao.impl.PgItemDao;
import jp.co.example.dao.impl.PgUserDao;
import jp.co.example.entity.Item;
import jp.co.example.entity.User;
import jp.co.example.form.AccountForm;
import jp.co.example.form.ConfirmPasswordForm;
import jp.co.example.service.UserService;

@Controller
public class AccountController {

	@Autowired
	HttpSession session;

	@Autowired
	PgUserDao user;

	@Autowired
	PgItemDao item;

	//userService
	@Autowired
	private UserService userService;

	@RequestMapping("/createBack")
	public String back(@ModelAttribute("test") AccountForm form, Model model) {

		return "index";

	}
	@RequestMapping("/createAccount")
	public String index(@ModelAttribute("test") AccountForm form, Model model) {

		return "createAccount";

	}

	@Autowired
	private UserService UserService;

	@RequestMapping(value="/create", method=RequestMethod.POST)
	public String post(@Validated @ModelAttribute("test") AccountForm form,BindingResult bindingResult,@Validated @ModelAttribute("test2") ConfirmPasswordForm form2, BindingResult bindingResult2, Model model){

		boolean check = false;

		//ユーザーID重複チェック
		User list = UserService.findById(form.getUserId());

		if(list != null) {
			model.addAttribute("msg", "入力したユーザーIDはすでに使用されています");
			check = true;
		}

		if(bindingResult.hasErrors() || check == true) {
			return "createAccount";
		}

		//Http Sessionを使用して保存
		session.setAttribute("userId",form.getUserId());
		session.setAttribute("userName",form.getUserName());
		session.setAttribute("password",form.getPassword());

		return "confirmAccount";
	}

	@RequestMapping(value="/confirm", method=RequestMethod.POST)
	public String post2(@Validated @ModelAttribute("test") AccountForm form,BindingResult bindingResult,@Validated @ModelAttribute("test2") ConfirmPasswordForm form2, BindingResult bindingResult2, Model model){

		//Http Sessionを使用して取得
		String userId = (String) session.getAttribute("userId");  // 取得
		String userName = (String) session.getAttribute("userName");  // 取得
		String password = (String) session.getAttribute("password");  // 取得

		if(bindingResult2.hasErrors()) {
			return "confirmAccount";
		}else if(form2.getPassword().equals(password) != true) {
			model.addAttribute("msg", "Passwordが間違っています");
			return "confirmAccount";
		}

		//insert実行
		user.insert(userId,userName,password);

		//users_id取得
		Integer usersId = user.findUsersId(userId);

		//項目の追加
		item.inputItem(new Item(usersId, "食費", 2));
		item.inputItem(new Item(usersId, "交通費", 2));
		item.inputItem(new Item(usersId, "光熱費", 2));
		item.inputItem(new Item(usersId, "家賃", 2));
		item.inputItem(new Item(usersId, "医療費", 2));
		item.inputItem(new Item(usersId, "給料", 1));

		session.invalidate(); // クリア
		return "completeAccount";

	}
}