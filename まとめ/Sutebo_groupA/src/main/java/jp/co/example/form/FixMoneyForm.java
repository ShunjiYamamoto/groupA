package jp.co.example.form;

import java.sql.Date;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

public class FixMoneyForm {


	private Date inputDate;
	private String itemName;
	@NotNull(message = "金額を入力して下さい。")
	@Min(0)
	private Integer amount;
	private Integer fixMoney;


//	public FixMoneyForm() {}
//
//	public FixMoneyForm(String inputDate, String itemName, String amount, Integer fixMoney) {
//		this.setItemName(itemName);
//		this.setAmount(amount);
//		this.setFixMoney(fixMoney);
//		this.setInputDate(inputDate);
//
//	}


	public Integer getFixMoney() {
		return fixMoney;
	}

	public void setFixMoney(Integer fixMoney) {
		this.fixMoney = fixMoney;
	}


	public Date getInputDate() {
		return inputDate;
	}

	public void setInputDate(Date inputDate) {
		this.inputDate = inputDate;
	}

	public String getItemName() {
		return itemName;
	}

	public void setItemName(String itemName) {
		this.itemName = itemName;
	}

	public Integer getAmount() {
		return amount;
	}

	public void setAmount(Integer amount) {
		this.amount = amount;
	}



}
