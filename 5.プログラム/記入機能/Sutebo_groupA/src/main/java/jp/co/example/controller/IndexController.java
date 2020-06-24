package jp.co.example.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class IndexController {

    @RequestMapping("/index")
    public String index(Model model) {
        return "index";
    }

    @RequestMapping("/loginPage")
    public String login(Model model) {
        return "loginPage";
    }

    @RequestMapping("/createAccount")
    public String createAccount(Model model) {
        return "createAccount";
    }

    @RequestMapping("/menu")
    public String menu(Model model) {
        return "menu";
    }

}
