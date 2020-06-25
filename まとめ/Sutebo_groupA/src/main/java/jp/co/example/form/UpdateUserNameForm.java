package jp.co.example.form;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

public class UpdateUserNameForm {

	@Size(min = 0, max = 20 , message="文字数は20文字以内です")
	@NotBlank(message="ユーザー名は入力必須です。")
	private String userName;



	public String getUserName() {
		return this.userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
}