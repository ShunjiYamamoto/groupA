package jp.co.example.controller;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import jp.co.example.entity.User;
import jp.co.example.form.LineNoticeForm;
import jp.co.example.service.UserService;
import jp.co.example.util.ParamUtil;

@Controller
public class LineNoticeController {

	@Autowired
	HttpSession session;

	@Autowired
	private UserService UserService;

	@RequestMapping("/configure")
	public String back2(@ModelAttribute("test") LineNoticeForm form, Model model) {

		return "configure";

	}

	@RequestMapping("/line")
	public String lineSet(@ModelAttribute("test") LineNoticeForm form, Model model) {



//		//Http Sessionを使用して保存
//		session.setAttribute("userId",);

		User user = (User) session.getAttribute("user");

		String userId =  user.getUserId();  // 取得

		/*		User user = (User) session.getAttribute("user");  // 取得
				String userId = user.getUserId();*/

		//トークンチェック
		String token = UserService.findByToken(userId);

		if(token != null) {
			model.addAttribute("lineToken", token);
		}else {
			model.addAttribute("lineToken", null);
		}

		return "lineNotice";

	}

	@RequestMapping("/line2")
	public String lineCheck(@ModelAttribute("test") LineNoticeForm form, Model model) {

		String userId = (String) session.getAttribute("userId");  // 取得

		//日付フォーマットの設定
		SimpleDateFormat sdf2 = new SimpleDateFormat("HH");
		SimpleDateFormat sdf3 = new SimpleDateFormat("mm");

		Date date = new Date();

		if(ParamUtil.isNullOrEmpty(form.getLineToken()) == true){
			model.addAttribute("msg_lineToken", "トークンが入力されていません");

		}else if(ParamUtil.isNullOrEmptyNumber(form.getHour()) == true){
			model.addAttribute("msg_lineTime", "時間が入力されていません");

		}else if(ParamUtil.isNullOrEmptyNumber(form.getMinute()) == true){
			model.addAttribute("msg_lineTime", "時間が入力されていません");

		}else if(form.getHour() < 0 || form.getHour() >= 24 ) {
			model.addAttribute("msg_lineTime", "正しい数値が入力されていません");

		}else if(form.getMinute() < 0 || form.getMinute() >= 60) {
			model.addAttribute("msg_lineTime", "正しい数値が入力されていません");

		}else {

			//インスタンス作成
			Calendar calendar = Calendar.getInstance();
			//日付を+1してセット
			calendar.add(Calendar.DAY_OF_MONTH,1);

			if(form.getHour() < Integer.parseInt(sdf2.format(date))) {
				date = calendar.getTime();

			}else if(form.getHour() == Integer.parseInt(sdf2.format(date))
					&& form.getMinute() <= Integer.parseInt(sdf3.format(date))) {

				date = calendar.getTime();
			}

			int a = UserService.update(userId,form.getLineToken(),form.getHour(),form.getMinute(),form.getLineNoticeOn(),date);
		}

		return "lineNotice";


	}
}
