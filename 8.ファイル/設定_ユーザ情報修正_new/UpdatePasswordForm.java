package jp.co.example.form;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

public class UpdatePasswordForm {

	@Size(min = 0, max = 20 , message="文字数は20文字以内です")
	@NotBlank(message="パスワードは入力必須です。")
	private String nowPass;

	@Size(min = 0, max = 20 , message="文字数は20文字以内です")
	@NotBlank(message="パスワードは入力必須です。")
	private String pass;


	@Size(min = 0, max = 20 , message="文字数は20文字以内です")
	@NotBlank(message="再パスワードは入力必須です。")
	private String newPass;

	public String  getNowPass() {
		return this.nowPass;
	}
	public void setNowPass(String nowPass) {
		this.nowPass = nowPass;
	}


	public String getPass() {
		return this.pass;
	}
	public void setPass(String pass) {
		this.pass = pass;
	}

	public String getNewPass() {
		return this.newPass;
	}
	public void setNewPass(String newPass) {
		this.newPass = newPass;
	}

}

