package jp.co.example.entity;

public class Money {



	private String itemName;
	private Integer amount;
	private Integer fixAmount;
	private String inputDate;



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
	public Integer getFixAmount() {
		return fixAmount;
	}
	public void setFixAmount(Integer fixAmount) {
		this.fixAmount = fixAmount;
	}

	public String getInputDate() {
		return inputDate;
	}
	public void setInputDate(String inputDate) {
		this.inputDate = inputDate;
	}

}
