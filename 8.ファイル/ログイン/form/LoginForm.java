package jp.co.example.form;


import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

public class LoginForm {

	@NotBlank(message = "ユーザ名は必須です")
	@Size(min = 0, max = 20, message = "文字数20文字以内です")
	private String userId;
	@NotBlank(message = "ASSWORDは必須です")
	@Size(min = 0, max = 20, message = "文字数は20文字以内です")
	private String password;

	private String userName;

	/*	public LoginForm() {}

		public LoginForm(String userId,String password, String userName) {
			this.userId = userId;
			this.password = password;
			this.userName = userName;
		}*/

	public String getUserId() {
		return userId;
	}
	public void setUserId(String userId) {
		this.userId = userId;
	}

	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}

	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
}
