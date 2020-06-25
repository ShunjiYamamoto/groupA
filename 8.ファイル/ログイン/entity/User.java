package jp.co.example.entity;

import java.sql.Date;

public class User {

	private String userId;
	private String userName;
	private String password;
	private Integer usersId;
	private boolean userDelete;
	private Date lastLoginDate;


	@Override
	public String toString() {
		return "User [id=" + userId + ", name=" + userName + ", password=" + password + "]";
	}
	public User () {};

	public User (String userId, String userName, String password, Integer usersId, boolean userDelete) {
		this.userId = userId;
		this.userName = userName;
		this.password = password;
		this.usersId = usersId;
		this.userDelete = userDelete;
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

	public Integer getUsersId() {
		return usersId;
	}

	public void setUsersId(Integer usersId) {
		this.usersId = usersId;
	}

	public boolean getUserDelete() {
		return userDelete;
	}

	public void setUserDelete(boolean userDelete) {
		this.userDelete = userDelete;
	}
	public Date getLastLoginDate() {
		return lastLoginDate;
	}
	public void setLastLoginDate(Date lastLoginDate) {
		this.lastLoginDate = lastLoginDate;
	}
}
