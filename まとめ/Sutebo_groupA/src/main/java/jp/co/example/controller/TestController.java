package jp.co.example.controller;


import java.sql.Date;
import java.util.Calendar;
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
import jp.co.example.service.NoticeMonthSettingService;

@Controller
public class TestController {
	@Autowired
	private NoticeMonthSettingService noticeMonthSettingService;

	@Autowired
	private NoticeMonthService noticeMonthService;

	@Autowired
	HttpSession session;

	@RequestMapping("/test")
	public String test(Model model) {
		User user = new User();
		user.setUsersId(1);
		user.setLastLoginDate(Date.valueOf("2020-05-29"));
		session.setAttribute("user", user);

		//ここから通知生成
//		Calendar nowDate = Calendar.getInstance();
//		Calendar calcDate = Calendar.getInstance();
//		calcDate.setTime(user.getLastLoginDate());
//		calcDate.add(Calendar.DAY_OF_MONTH, 1);
//
//		List<NoticeMonthSetting> SettingList = noticeMonthSettingService.findByIdAndNoticeOn(user.getUsersId());
//
//		while(calcDate.before(nowDate)) {
//			int calcDay = calcDate.get(Calendar.DATE);
//
//			for(NoticeMonthSetting nms : SettingList) {
//				if(calcDay == nms.getNoticeDay() && nms.getNoticeDay() <= 28 || calcDay == calcDate.getActualMaximum(Calendar.DATE) && nms.getNoticeDay() == 29){
//					noticeMonthService.inputNoticeMonth(new NoticeMonth(new Date(calcDate.getTime().getTime()), nms.getNoticesMonthSettingId()));
//				}
//			}
//
//			if(compareDate(nowDate, calcDate)) {
//				break;
//			}
//
//			calcDate.add(Calendar.DAY_OF_MONTH, 1);
//		}
		//ここまで通知生成

		List<NoticeMonth> noticeList = noticeMonthService.findByUsersId(user.getUsersId());
		model.addAttribute("noticeList", noticeList);

		return "test";
	}

	@RequestMapping("/adeleteNoticeMonth")
	public String deleteNotice(@RequestParam("noticeId") Integer noticeId, Model model) {
		noticeMonthService.deleteNoticeMonth(noticeId);

		User user = (User) session.getAttribute("user");
		List<NoticeMonth> noticeList = noticeMonthService.findByUsersId(user.getUsersId());
		model.addAttribute("noticeList", noticeList);

		return "test";
	}

	public boolean compareDate(Calendar date1, Calendar date2) {
		if(date1.get(Calendar.YEAR) != date2.get(Calendar.YEAR) || date1.get(Calendar.MONTH) != date2.get(Calendar.MONTH) || date1.get(Calendar.DATE) != date2.get(Calendar.DATE)) {
			return false;
		} else {
			return true;
		}
	}
}
