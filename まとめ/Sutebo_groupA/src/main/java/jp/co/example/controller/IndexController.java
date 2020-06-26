package jp.co.example.controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import jp.co.example.entity.NoticeMonth;
import jp.co.example.entity.User;
import jp.co.example.service.NoticeMonthService;

@Controller
public class IndexController {
	@Autowired
	private NoticeMonthService noticeMonthService;

	@Autowired
	HttpSession session;

//  TOP画面表示
    @RequestMapping("/index")
    public String index(Model model) {
        return "index";
    }

	/*    @RequestMapping("/loginPage")
	public String login(Model model) {
	    return "loginPage";
	}

	@RequestMapping("/createAccount")
	public String createAccount(Model model) {
	    return "createAccount";
	}*/

	/*    @RequestMapping("/menu")
	public String menu(Model model) {
		displayNotice(model);
	    return "menu";
	}*/

	@RequestMapping("/deleteNoticeMonth")
	public String deleteNotice(@RequestParam("noticeId") Integer noticeId, Model model) {
		noticeMonthService.deleteNoticeMonth(noticeId);

		User user = (User) session.getAttribute("user");
		List<NoticeMonth> noticeList = noticeMonthService.findByUsersId(user.getUsersId());
		model.addAttribute("noticeList", noticeList);

		return "menu";
	}


	@RequestMapping("/logout")
	public String logout(Model model) {

	    session.invalidate();

	    return "logout";
	}

}
