package jp.co.example.entity;

public class NoticeMonthSetting {
	private Integer noticesMonthSettingId;
	private Integer usersId;
	private Integer noticeDay;
	private String content;
	private Boolean noticeOn;
	private Boolean noticeSettingDelete;

	public NoticeMonthSetting() {

	}

	public NoticeMonthSetting(Integer usersId, Integer noticeDay, String content) {
		this.usersId = usersId;
		this.noticeDay = noticeDay;
		this.content = content;
	}

	public Integer getNoticesMonthSettingId() {
		return noticesMonthSettingId;
	}

	public void setNoticesMonthSettingId(Integer noticesMonthSettingId) {
		this.noticesMonthSettingId = noticesMonthSettingId;
	}

	public Integer getUsersId() {
		return usersId;
	}

	public void setUsersId(Integer usersId) {
		this.usersId = usersId;
	}

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

	public Boolean getNoticeOn() {
		return noticeOn;
	}

	public void setNoticeOn(Boolean noticeOn) {
		this.noticeOn = noticeOn;
	}

	public Boolean getNoticeSettingDelete() {
		return noticeSettingDelete;
	}

	public void setNoticeSettingDelete(Boolean noticeSettingDelete) {
		this.noticeSettingDelete = noticeSettingDelete;
	}

}
