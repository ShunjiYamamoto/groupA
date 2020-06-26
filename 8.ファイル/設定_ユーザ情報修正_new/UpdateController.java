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

import jp.co.example.entity.User;
import jp.co.example.form.ConfirmPasswordForm;
import jp.co.example.form.UpdatePasswordForm;
import jp.co.example.form.UpdateUserNameForm;
import jp.co.example.service.UserService;

@Controller
public class UpdateController {

	@Autowired
	private UserService userService;

	@Autowired
	HttpSession session;




	@RequestMapping(value="/userUpdateName" , method=RequestMethod.POST)
    public String updateUserName(@Validated @ModelAttribute("name") UpdateUserNameForm form,BindingResult bindingResult, Model model) {
		if(bindingResult.hasErrors()){
			model.addAttribute("a","a");
			return "inputUpdate";
		}else {

			User user = (User) session.getAttribute("user");

			userService.updateUserName(form.getUserName(),user.getUserId());
			model.addAttribute("newUesrName", form.getUserName());
			model.addAttribute("newUserPassword",userService.passwordGet(user.getUserId()));
			model.addAttribute("c","c");
			user.setUserName(form.getUserName());
			session.setAttribute("user", user);

			return "confirmUpdateUser";

		}
	}

	@RequestMapping(value="/userUpdatePass" , method=RequestMethod.POST)
    public String updatePassword(@Validated @ModelAttribute("pass") UpdatePasswordForm form,BindingResult bindingResult, Model model) {
		User user = (User) session.getAttribute("user");
		System.out.println(userService.passwordGet(user.getUserId()));
		if(bindingResult.hasErrors()){
			model.addAttribute("b","b");
			return "inputUpdate";
		}else if(!(form.getNowPass().equals(userService.passwordGet(user.getUserId())))) {
			model.addAttribute("b","b");
			model.addAttribute("passwordNowChange","パスワードが一致しません");
			return "inputUpdate";
		}else if(!(form.getPass().equals(form.getNewPass()))){
			model.addAttribute("b","b");
			model.addAttribute("passwordChange","パスワードが一致しません");
			return "inputUpdate";
		}else {
			userService.updatePassword(form.getNewPass(),user.getUserId());
			model.addAttribute("newUesrName",userService.userNameGet(user.getUserId()));
			model.addAttribute("newUserPassword",form.getNewPass());

			user.setPassword(form.getNewPass());
			session.setAttribute("user", user);

        	return "confirmUpdateUser";
        }
	}



	@RequestMapping(value="/userDateAllDelete" , method=RequestMethod.POST)
	public String userDeleteUpdate(@Validated @ModelAttribute("delete")  ConfirmPasswordForm form,BindingResult bindingResult, Model model) {

		User user = (User) session.getAttribute("user");

		if(bindingResult.hasErrors()){
			return "deleteUser";
		}else if(!(form.getPassword().equals(userService.passwordGet(user.getUserId())))) {
			model.addAttribute("passwordChange","パスワードが違います");
			return "deleteUser";
		}else {



			userService.updateDelete(user.getUserId());
			return "confirmDeleteUser";
		}
	}


}
