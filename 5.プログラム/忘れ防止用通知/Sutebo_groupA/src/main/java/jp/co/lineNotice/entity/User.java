package jp.co.lineNotice.entity;

import java.security.Timestamp;

public class User {

	private String userId;
	private String userName;
	private String password;
	private String lineToken;
	private Timestamp lineTime;
	private boolean lineNoticeOn;


	@Override
	public String toString() {
		return "User [id=" + userId + ", name=" + userName + ", password=" + password
					+ ",lineToken=" + lineToken +"]";
	}

	public String getUserId() {
		return userId;
	}
	public void setUserId(String userId) {
		this.userId = userId;
	}

	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}

	public String getLineToken() {
		return lineToken;
	}

	public void setLineToken(String lineToken) {
		this.lineToken = lineToken;
	}

	public Timestamp getLineTime() {
		return lineTime;
	}

	public void setLineTime(Timestamp lineTime) {
		this.lineTime = lineTime;
	}

	public boolean getLineNoticeOn() {
		return lineNoticeOn;
	}

	public void setLineNoticeOn(boolean lineNoticeOn) {
		this.lineNoticeOn = lineNoticeOn;
	}
}