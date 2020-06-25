package jp.co.example.controller;

import java.sql.Date;
import java.util.Calendar;
import java.util.List;
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

import jp.co.example.entity.NoticeMonth;
import jp.co.example.entity.NoticeMonthSetting;
import jp.co.example.entity.User;
import jp.co.example.form.LoginForm;
import jp.co.example.service.NoticeMonthService;
import jp.co.example.service.NoticeMonthSettingService;
import jp.co.example.service.UserService;

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

	@Autowired
	private NoticeMonthSettingService noticeMonthSettingService;

	@Autowired
	private NoticeMonthService noticeMonthService;

	//ログイン画面遷移
	@RequestMapping("/login")
	public String login(@ModelAttribute("loginForm") LoginForm form, Model model) {
		return "loginPage";
	}

//
//	@RequestMapping("/createAccount")
//	public String createAccount (Model model) {
//		return "createAccount";
//	}


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
		System.out.println(form.getUserId());
		System.out.println(form.getPassword());;

		User user = userService.authentication(form.getUserId(), form.getPassword());

//	    boolean  check = userService.deleteGet(form.getUserId(), form.getPassword());
//
//		if(user == null || check == true || check == null){
		if(user == null){
			//ログイン失敗
			System.out.println(3);
			model.addAttribute("errMsg", errMsg);
			return "loginPage";

		} else {
			//ログイン成功

			//通知を生成
			Calendar nowDate = Calendar.getInstance();
			Calendar calcDate = Calendar.getInstance();
			calcDate.setTime(user.getLastLoginDate());
			calcDate.add(Calendar.DAY_OF_MONTH, 1);

			List<NoticeMonthSetting> SettingList = noticeMonthSettingService.findByIdAndNoticeOn(user.getUsersId());

			while(calcDate.before(nowDate)) {
				int calcDay = calcDate.get(Calendar.DATE);

				for(NoticeMonthSetting nms : SettingList) {
					if(calcDay == nms.getNoticeDay() && nms.getNoticeDay() <= 28 || calcDay == calcDate.getActualMaximum(Calendar.DATE) && nms.getNoticeDay() == 29){
						noticeMonthService.inputNoticeMonth(new NoticeMonth(new Date(calcDate.getTime().getTime()), nms.getNoticesMonthSettingId()));
					}
				}

				if(compareDate(nowDate, calcDate)) {
					break;
				}

				calcDate.add(Calendar.DAY_OF_MONTH, 1);
			}

			//ログイン日を更新
			userService.updateLoginDate(user.getUsersId(), new Date(System.currentTimeMillis()));
			user.setLastLoginDate(new Date(System.currentTimeMillis()));

			//ログインユーザ情報をセッションにセット
//			SessionInfo sessionInfo = ParamUtil.getSessionInfo(session);
			session.setAttribute("user", user);

			return "menu";

		}
	}

	//通知を生成する時に使用
	public boolean compareDate(Calendar date1, Calendar date2) {
		if(date1.get(Calendar.YEAR) != date2.get(Calendar.YEAR) || date1.get(Calendar.MONTH) != date2.get(Calendar.MONTH) || date1.get(Calendar.DATE) != date2.get(Calendar.DATE)) {
			return false;
		} else {
			return true;
		}
	}



	/*userService.updateLoginDate(user.getUsersId(), new Date(System.currentTimeMillis()));
	user.setLastLoginDate(new Date(System.currentTimeMillis()));

	//ログインユーザ情報をセッションにセット
	//			SessionInfo sessionInfo = ParamUtil.getSessionInfo(session);
	session.setAttribute("user", user);

	return "menu";

	}
	}*/


}