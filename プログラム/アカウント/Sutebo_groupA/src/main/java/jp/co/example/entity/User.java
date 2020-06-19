package jp.co.example.entity;

public class User {

	private Integer userId;
	private String userName;
	private String password;

	@Override
	public String toString() {
		return "User [id=" + userId + ", name=" + userName + ", password=" + password + "]";
	}

	public Integer getUserId() {
		return userId;
	}
	public void setUserId(Integer userId) {
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