package jp.co.example.form;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

public class AccountForm {

	@NotBlank(message="ユーザーIDは必須です。")
	@Size(min=0,max=20,message="文字数は20文字以内です")
	private String userId;

	@NotBlank(message="ユーザー名は必須です。")
	@Size(min=0,max=20,message="文字数は20文字以内です")
	private String userName;

	@NotBlank(message="パスワードは必須です。")
	@Size(min=0,max=20,message="文字数は20文字以内です")
	private String password;

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