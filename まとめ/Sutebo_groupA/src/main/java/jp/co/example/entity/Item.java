package jp.co.example.entity;

public class Item {
	private Integer itemsId;
	private Integer usersId;
	private String itemName;
	private Integer incomeOutgo;
	private Boolean itemDelete;

	public Item() {

	}

	public Item(Integer usersId, String itemName, Integer incomeOutgo) {
		this.usersId = usersId;
		this.itemName = itemName;
		this.incomeOutgo = incomeOutgo;
	}

	public Integer getItemsId() {
		return itemsId;
	}

	public void setItemsId(Integer itemsId) {
		this.itemsId = itemsId;
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

	public Integer getIncomeOutgo() {
		return incomeOutgo;
	}

	public void setIncomeOutgo(Integer incomeOutgo) {
		this.incomeOutgo = incomeOutgo;
	}

	public Boolean getItemDelete() {
		return itemDelete;
	}

	public void setItemDelete(Boolean itemDelete) {
		this.itemDelete = itemDelete;
	}


}
