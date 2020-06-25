package jp.co.example.entity;

public class ItemNameAndMoney {

	private String itemName;
	private Integer amount;
	private Integer usersId;


	public ItemNameAndMoney() {

	}

	public ItemNameAndMoney(String itemName, Integer amount) {
		super();
		this.itemName = itemName;
		this.amount = amount;
	}



	public ItemNameAndMoney(Integer usersId, Integer amount) {
		super();
		this.amount = amount;
		this.usersId = usersId;
	}

	public Integer getUsersId() {
		return usersId;
	}

	public void setUsersId(Integer usersId) {
		this.usersId = usersId;
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
