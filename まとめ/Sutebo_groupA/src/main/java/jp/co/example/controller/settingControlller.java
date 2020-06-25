package jp.co.example.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import jp.co.example.form.ConfirmPasswordForm;
import jp.co.example.form.UpdatePasswordForm;
import jp.co.example.form.UpdateUserNameForm;

@Controller
public class settingControlller {


	@RequestMapping("/setting")
    public String ConfigurationDisplay(Model model) {
        return "setting";
    }

	@RequestMapping("/inputUpdateName")
    public String userUpdateName(@ModelAttribute("name") UpdateUserNameForm form, Model model) {
		model.addAttribute("a","a");
        return "inputUpdate";
    }

	@RequestMapping("/inputUpdatePass")
    public String userUpdatePass(@ModelAttribute("pass")UpdatePasswordForm form, Model model) {
		model.addAttribute("b","b");
        return "inputUpdate";
    }

	@RequestMapping("/deleteUser")
    public String userDelete(@ModelAttribute("delete")  ConfirmPasswordForm form, Model model) {
        return "deleteUser";
    }


}
