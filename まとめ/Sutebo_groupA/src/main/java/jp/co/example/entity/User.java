package jp.co.example.entity;

import java.security.Timestamp;
import java.util.Date;

public class User {

	//usersテーブルに対応するフィールド

	private Integer usersId;
	private String userId;
	private String userName;
	private String password;
	private Boolean userDelete;
	private Date lastLoginDate;
	private String lineToken;
	private Timestamp lineTime;
	private Boolean lineNoticeOn ;
	private String rePassword;

	public User() {}

	public User(Integer usersId,String userId,String userName,String password,Boolean userDelete,Date lastLoginDate,String lineToken,Timestamp lineTime,Boolean lineNoticeOn) {
		this.usersId = usersId;
		this.userId = userId;
		this.userName = userName;
		this.password = password;
		this.userDelete = userDelete;
		this.lastLoginDate = lastLoginDate;
		this.lineToken = lineToken;
		this.lineTime = lineTime;
		this.lineNoticeOn = lineNoticeOn;
	}

	@Override
	public String toString() {
		return "User [id=" + userId + ", name=" + userName + ", password=" + password
					+ ",lineToken=" + lineToken +"]";
	}

	public Integer getUsersId() {
		return this.usersId;
	}
	public void setUsersId(Integer usersId) {
		this.usersId = usersId;
	}

	public String getUserId() {
		return this.userId ;
	}
	public void setUserId(String userId) {
		this.userId = userId;
	}

	public String getUserName() {
		return this.userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getPassword() {
		return this.password;
	}
	public void setPassword(String password) {
		this.password = password;
	}

	public Boolean getUserDelete() {
		return this.userDelete;
	}
	public void setUserDelete(Boolean userDelete) {
		this.userDelete = userDelete;
	}

	public  Date getLastLoginDate() {
		return this.lastLoginDate;
	}
	public void setLastLoginDate(Date lastLoginDate) {
		this.lastLoginDate = lastLoginDate;
	}

	public String getLineToken() {
		return this.lineToken;
	}
	public void setLineToken(String lineToken) {
		this.lineToken = lineToken;
	}

	public Timestamp getLineTime() {
		return this.lineTime;
	}
	public void setLineTime(Timestamp lineTime) {
		this.lineTime = lineTime;
	}

	public Boolean getLineNoticeOn() {
		return this.lineNoticeOn;
	}
	public void setLineNoticeOn(Boolean lineNoticeOn) {
		this.lineNoticeOn = lineNoticeOn;
	}

	public String getRePassword() {
		return rePassword;
	}

	public void setRePassword(String rePassword) {
		this.rePassword = rePassword;
	}

}
