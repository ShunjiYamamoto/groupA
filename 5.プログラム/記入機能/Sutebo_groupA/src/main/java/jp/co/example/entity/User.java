package jp.co.example.entity;

import java.sql.Date;
import java.sql.Time;

public class User {
	private Integer usersId;
	private String userId;
	private String userName;
	private String password;
	private Boolean userDelete;
	private Date lastLoginDate;
	private String lineToken;
	private Time lineTime;
	private Boolean lineNoticeOn;

	public User() {

	}

	public User(Integer usersId, String userId, String userName, String password, Boolean userDelete,
			Date lastLoginDate, String lineToken, Time lineTime, Boolean lineNoticeOn) {
		this.setUsersId(usersId);
		this.setUserId(userId);
		this.setUserName(userName);
		this.setPassword(password);
		this.setUserDelete(userDelete);
		this.setLastLoginDate(lastLoginDate);
		this.setLineToken(lineToken);
		this.setLineTime(lineTime);
		this.setLineNoticeOn(lineNoticeOn);
	}

	public Integer getUsersId() {
		return usersId;
	}

	public void setUsersId(Integer usersId) {
		this.usersId = usersId;
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

	public Boolean isUserDelete() {
		return userDelete;
	}

	public void setUserDelete(Boolean userDelete) {
		this.userDelete = userDelete;
	}

	public Date getLastLoginDate() {
		return lastLoginDate;
	}

	public void setLastLoginDate(Date lastLoginDate) {
		this.lastLoginDate = lastLoginDate;
	}

	public String getLineToken() {
		return lineToken;
	}

	public void setLineToken(String lineToken) {
		this.lineToken = lineToken;
	}

	public Time getLineTime() {
		return lineTime;
	}

	public void setLineTime(Time lineTime) {
		this.lineTime = lineTime;
	}

	public Boolean isLineNoticeOn() {
		return lineNoticeOn;
	}

	public void setLineNoticeOn(Boolean lineNoticeOn) {
		this.lineNoticeOn = lineNoticeOn;
	}
}
