package jp.co.example.entity;

import java.sql.Date;

public class NoticeMonth {
	private Integer noticesMonthId;
	private Date noticeDate;
	private Integer noticesMonthSettingId;
	private Boolean noticeDelete;
	private String content;

	public NoticeMonth() {

	}

	public NoticeMonth(Date noticeDate, Integer noticesMonthSettingId) {
		this.noticeDate = noticeDate;
		this.noticesMonthSettingId = noticesMonthSettingId;
	}

	public Integer getNoticesMonthId() {
		return noticesMonthId;
	}

	public void setNoticesMonthId(Integer noticesMonthId) {
		this.noticesMonthId = noticesMonthId;
	}

	public Date getNoticeDate() {
		return noticeDate;
	}

	public void setNoticeDate(Date noticeDate) {
		this.noticeDate = noticeDate;
	}

	public Integer getNoticesMonthSettingId() {
		return noticesMonthSettingId;
	}

	public void setNoticesMonthSettingId(Integer noticesMonthSettingId) {
		this.noticesMonthSettingId = noticesMonthSettingId;
	}

	public Boolean getNoticeDelete() {
		return noticeDelete;
	}

	public void setNoticeDelete(Boolean noticeDelete) {
		this.noticeDelete = noticeDelete;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

}
