package jp.co.example.entity;

import java.sql.Date;

public class Money {

	private Date inputDate;
	private Integer itemsId;
	private Integer amount;
	private String itemName;

	public Money(Date inputDate, Integer itemsId, Integer amount, String itemName) {
		super();
		this.inputDate = inputDate;
		this.itemsId = itemsId;
		this.amount = amount;
		this.itemName = itemName;
	}

	public Money() {

	}

	public Date getInputDate() {
		return inputDate;
	}
	public void setInputDate(Date inputDate) {
		this.inputDate = inputDate;
	}
	public Integer getItemsId() {
		return itemsId;
	}
	public void setItemsId(Integer itemsId) {
		this.itemsId = itemsId;
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
