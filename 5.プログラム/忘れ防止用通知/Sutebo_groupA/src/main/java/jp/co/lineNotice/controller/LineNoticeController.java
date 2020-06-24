package jp.co.lineNotice.controller;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import jp.co.lineNotice.controller.form.LineNoticeForm;
import jp.co.lineNotice.service.UserService;
import jp.co.lineNotice.util.ParamUtil;

@Controller
public class LineNoticeController {

	@Autowired
	HttpSession session;

	@Autowired
	private UserService UserService;

	@RequestMapping("/line")
	public String lineSet(@ModelAttribute("test") LineNoticeForm form, Model model) {

		//Http Sessionを使用して保存
		session.setAttribute("userId","a");

		String userId = (String) session.getAttribute("userId");  // 取得

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
		boolean check = false;

		SimpleDateFormat sdf2 = new SimpleDateFormat("HH");
		SimpleDateFormat sdf3 = new SimpleDateFormat("mm");

		Date date = new Date();

		if(ParamUtil.isNullOrEmpty(form.getLineToken()) == true){
			model.addAttribute("msg_lineToken", "トークンが入力されていません");
			check = true;
		}
		if(ParamUtil.isNullOrEmptyNumber(form.getHour()) == true){
			model.addAttribute("msg_lineTime", "時間が入力されていません");
			check = true;

		}else if(ParamUtil.isNullOrEmptyNumber(form.getMinute()) == true){
			model.addAttribute("msg_lineTime", "時間が入力されていません");
			check = true;

		}else if(form.getHour() < 0 || form.getHour() >= 24 ) {
			model.addAttribute("msg_lineTime", "正しい数値が入力されていません");
			check = true;

		}else if(form.getMinute() < 0 || form.getMinute() >= 60) {
			model.addAttribute("msg_lineTime", "正しい数値が入力されていません");
			check = true;

		}else if(form.getHour() < Integer.parseInt(sdf2.format(date))
				|| form.getMinute() <= Integer.parseInt(sdf3.format(date))) {

			//日付フォーマットの設定
			SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
			//インスタンス作成
			Calendar calendar = Calendar.getInstance();

			//日付を+1してセット
			calendar.add(Calendar.DAY_OF_MONTH,1);
			date = calendar.getTime();

		}

		if(check ==false) {
			int a = UserService.update(userId,form.getLineToken(),form.getHour(),form.getMinute(),form.getLineNoticeOn(),date);

		}

		return "lineNotice";


	}
}
