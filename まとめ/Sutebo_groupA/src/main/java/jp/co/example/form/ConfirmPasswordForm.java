package jp.co.example.form;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

public class ConfirmPasswordForm {

	@Size(min = 0, max = 20 , message="文字数は20文字以内です")
	@NotBlank(message="パスワードは必須です。")
	private String password;

	public String getPassword() {
		return this.password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

}
