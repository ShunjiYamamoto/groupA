package jp.co.example.entity;

public class Item {
	private Integer itemsId;
	private Integer usersId;
	private String itemsName;
	private Integer incomeOutgo;
	private Boolean itemsDelete;

	public Item(Integer itemsId,Integer usersId,String itemsName,Integer incomeOutgo, Boolean itemsDelete) {
		this.itemsId = itemsId;
		this.usersId = usersId;
		this.itemsName = itemsName;
		this.incomeOutgo = incomeOutgo;
		this.itemsDelete = itemsDelete;
	}

	public Item() {

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
		return itemsName;
	}
	public void setItemName(String itemsName) {
		this.itemsName = itemsName;
	}
	public Integer getIncomeOutgo() {
		return incomeOutgo;
	}
	public void setIncomeOutgo(Integer incomeOutgo) {
		this.incomeOutgo = incomeOutgo;
	}
	public Boolean isItemDelete() {
		return itemsDelete;
	}
	public void setItemDelete(Boolean itemsDelete) {
		this.itemsDelete = itemsDelete;
	}
}
