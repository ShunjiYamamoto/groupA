package jp.co.example.form;

public class LoginForm {

	private String userId;
	private String password;

	public LoginForm() {}

	public LoginForm(String userId,String password) {
		this.userId = userId;
		this.password = password;
	}

	public String getUserId() {
		return this.userId;
	}
	public void setUserId(String userId) {
		this.userId = userId;
	}

	public String getPassword() {
		return this.password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
}
