package jp.co.example.form;

public class LineNoticeForm {

	private String lineToken;
	private Integer hour;
	private Integer minute;
	private boolean lineNoticeOn;

	public String getLineToken() {
		return lineToken;
	}
	public void setLineToken(String lineToken) {
		this.lineToken = lineToken;
	}

	public Integer getHour() {
		return hour;
	}
	public void setHour(Integer hour) {
		this.hour = hour;
	}

	public Integer getMinute() {
		return minute;
	}
	public void setMinute(Integer minute) {
		this.minute = minute;
	}

	public boolean getLineNoticeOn() {
		return lineNoticeOn;
	}
	public void setLineNoticeOn(boolean lineNoticeOn) {
		this.lineNoticeOn = lineNoticeOn;
	}

}
