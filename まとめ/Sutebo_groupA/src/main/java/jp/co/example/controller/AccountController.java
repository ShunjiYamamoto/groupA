package jp.co.example.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import jp.co.example.dao.impl.PgItemDao;
import jp.co.example.dao.impl.PgUserDao;
import jp.co.example.entity.User;
import jp.co.example.form.AccountForm;
import jp.co.example.form.ConfirmPasswordForm;
import jp.co.example.service.UserService;
import jp.co.example.util.ParamUtil;

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
	public String post(@ModelAttribute("test") AccountForm form,@ModelAttribute("test2") ConfirmPasswordForm form2, Model model) {

		boolean check = false;

		//ユーザーID重複チェック
		User list = UserService.findById(form.getUserId());

		//入力チェック
		if(ParamUtil.isNullOrEmpty(form.getUserId()) == true){
			model.addAttribute("msg", "ユーザーIDが入力されていません");
			check = true;
		}
		else if(ParamUtil.isNullOrEmpty(form.getUserName()) == true){
			model.addAttribute("msg", "ユーザー名が入力されていません");
			check = true;
		}
		else if(ParamUtil.isNullOrEmpty(form.getPassword()) == true){
			model.addAttribute("msg", "Passwordが入力されていません");
			check = true;
		}
		else if(list != null) {
			model.addAttribute("msg", "入力したユーザーIDはすでに使用されています");
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
	public String post2(@ModelAttribute("test") AccountForm form,@ModelAttribute("test2") ConfirmPasswordForm form2, Model model) throws InterruptedException {

		//Http Sessionを使用して取得
		String userId = (String) session.getAttribute("userId");  // 取得
		String userName = (String) session.getAttribute("userName");  // 取得
		String password = (String) session.getAttribute("password");  // 取得

		if(ParamUtil.isNullOrEmpty(form2.getRePassword()) == true) {
			model.addAttribute("msg", "Password確認が入力されていません");
			return "confirmAccount";

		}else if(form2.getRePassword().equals(password) != true) {
			model.addAttribute("msg", "Passwordが間違っています");
			return "confirmAccount";
		}

		/*		//insert実行
				userService.insert(userId,userName,password);

				//users_id取得
				Integer usersId = userService.findUsersId(userId);

				//項目の追加
				item.inputItem(new Item(usersId, "食費", 2));
				item.inputItem(new Item(usersId, "交通費", 2));
				item.inputItem(new Item(usersId, "光熱費", 2));
				item.inputItem(new Item(usersId, "家賃", 2));
				item.inputItem(new Item(usersId, "医療費", 2));
				item.inputItem(new Item(usersId, "給料", 1));

				userService.updateLoginDate(usersId, new Date(System.currentTimeMillis()));*/

				userService.createAccount(userId, userName, password);

		session.invalidate(); // クリア
		return "completeAccount";

	}
}