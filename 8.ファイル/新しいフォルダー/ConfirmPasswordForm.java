package jp.co.example.form;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

public class ConfirmPasswordForm {

	@NotBlank
	@Size(max=20)
	private String rePassword;

	public String getRePassword() {
		return rePassword;
	}
	public void setRePassword(String rePassword) {
		this.rePassword = rePassword;
	}

}