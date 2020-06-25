package jp.co.example.form;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

public class InputNoticeMonthSettingForm {
	private Integer noticeDay;

	@NotBlank
	@Size(max = 20)
	private String content;

	public Integer getNoticeDay() {
		return noticeDay;
	}

	public void setNoticeDay(Integer noticeDay) {
		this.noticeDay = noticeDay;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}
}
