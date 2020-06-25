package jp.co.example.model;

import java.sql.Date;

public class SaveForDairyData {

	private Date inputDate;
	private Integer amount;
	private String itemName;



	public SaveForDairyData(String itemName, Integer amount, Date inputDate) {

		this.inputDate = inputDate;
		this.amount = amount;
		this.itemName = itemName;
	}

	public SaveForDairyData() {

	}

	public Date getInputDate() {
		return inputDate;
	}
	public void setInputDate(Date inputDate) {
		this.inputDate = inputDate;
	}
	public Integer getAmount() {
		return amount;
	}
	public void setAmount(Integer amount) {
		this.amount = amount;
	}
	public String getItemName() {
		return itemName;
	}
	public void setItemName(String itemName) {
		this.itemName = itemName;
	}


}
