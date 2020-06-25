package jp.co.example.controller;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import jp.co.example.entity.NoticeMonthSetting;
import jp.co.example.entity.User;
import jp.co.example.form.InputNoticeMonthSettingForm;
import jp.co.example.form.MultipleForm;
import jp.co.example.form.UpdateNoticeMonthSettingForm;
import jp.co.example.service.NoticeMonthSettingService;

@Controller
public class NoticeMonthSettingController {
	@Autowired
	private NoticeMonthSettingService noticeMonthSettingService;

	@Autowired
	HttpSession session;

	@RequestMapping("/displayNoticeMonthSetting")
	public String displayNoticeMonthSetting(@ModelAttribute("updateForm") UpdateNoticeMonthSettingForm updateForm, @ModelAttribute("inputForm") InputNoticeMonthSettingForm inputForm, Model model) {
		displayData(model);
		return "noticeMonth";
	}

	@RequestMapping("/inputNoticeMonthSetting")
	public String inputNoticeMonthSetting(@ModelAttribute("updateForm") UpdateNoticeMonthSettingForm updateForm, @Validated @ModelAttribute("inputForm") InputNoticeMonthSettingForm inputForm, BindingResult bindingResult, Model model) {
		if(bindingResult.hasErrors()) {
			displayData(model);
			return "noticeMonth";
		}

		User user = (User) session.getAttribute("user");
		NoticeMonthSetting newNoticeMonthSetting = new NoticeMonthSetting(user.getUsersId(), inputForm.getNoticeDay(), inputForm.getContent());
		noticeMonthSettingService.inputNoticeMonthSetting(newNoticeMonthSetting);

		displayData(model);
		return "noticeMonth";
	}

	@RequestMapping("/updateNoticeMonthSetting")
	public String updateNoticeMonthSetting(@ModelAttribute("updateForm") UpdateNoticeMonthSettingForm updateForm, @ModelAttribute("inputForm") InputNoticeMonthSettingForm inputForm, Model model) {
		User user = (User) session.getAttribute("user");
		List<NoticeMonthSetting> noticeList = noticeMonthSettingService.findById(user.getUsersId());

		for(int i = 0; i < noticeList.size(); i++) {
			Integer id = noticeList.get(i).getNoticesMonthSettingId();
			String choice = updateForm.getSettingList().get(i).getChoice();

			if(choice.equals("on") || choice.equals("off")) {
				noticeMonthSettingService.updateNoticeOn(id, choice);
			} else if(choice.equals("delete")) {
				noticeMonthSettingService.updateNoticeSettingDelete(id);
			}
		}

		updateForm.getSettingList().clear();
		model.addAttribute("updateMsg", "設定を保存しました。");

		displayData(model);
		return "noticeMonth";
	}

	public void displayData(Model model) {
		User user = (User) session.getAttribute("user");
		List<NoticeMonthSetting> noticeList = noticeMonthSettingService.findById(user.getUsersId());
		model.addAttribute("noticeList", noticeList);
		if(noticeList.size() >= 10) {
			model.addAttribute("noticeLimit", true);
		} else {
			model.addAttribute("noticeLimit", false);
		}

		Map<Integer, String> dayList = new HashMap<>();
		for(int i = 1; i <= 28; i++) {
			dayList.put(i, i + "日");
		}
		dayList.put(29, "月末");
	    model.addAttribute("dayList", dayList);
	}

	@ModelAttribute
	public UpdateNoticeMonthSettingForm setUpUpdateNoticeMonthSettingForm() {
		UpdateNoticeMonthSettingForm updateNoticeMonthSettingForm = new UpdateNoticeMonthSettingForm();

		for(int i = 0; i < 10; i++) {
			updateNoticeMonthSettingForm.setSettingList(Arrays.asList(new MultipleForm()));
		}

		return updateNoticeMonthSettingForm;
	}

}
