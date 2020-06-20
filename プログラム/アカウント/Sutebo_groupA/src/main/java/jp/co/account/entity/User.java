package jp.co.account.entity;

public class User {

	private String userId;
	private String userName;
	private String password;

	@Override
	public String toString() {
		return "User [id=" + userId + ", name=" + userName + ", password=" + password + "]";
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
}