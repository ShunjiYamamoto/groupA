package jp.co.example.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class TestController {

	@RequestMapping("/test")
	public String index(Model model) {

		model.addAttribute("msg", "Hello MVC!");

		return "index_mvc";
	}
}