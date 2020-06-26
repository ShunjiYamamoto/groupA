package jp.co.example.entity;

public class Money {
	private Integer moneyId;
	private String inputDate;
	private Integer itemsId;
	private Integer amount;

	public Money () {

	}

	public Money (Integer moneyId,String inputDate,Integer itemsId,Integer amount) {
		this.setMoneyId(moneyId);
		this.setInputDate(inputDate);
		this.setItemsId(itemsId);
		this.setAmount(amount);
	}

	public Integer getMoneyId() {
		return moneyId;
	}

	public void setMoneyId(Integer moneyId) {
		this.moneyId = moneyId;
	}

	public String getInputDate() {
		return inputDate;
	}

	public void setInputDate(String inputDate) {
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

}
