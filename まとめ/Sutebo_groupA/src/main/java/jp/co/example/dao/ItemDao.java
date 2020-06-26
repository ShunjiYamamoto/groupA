package jp.co.example.dao;

import java.util.List;

import jp.co.example.entity.Item;

public interface ItemDao {

	List<Item> findByIdAndIncomeOutgoAndNotDelete(Integer usersId, Integer incomeOutgo);

	void inputItem(Item item);

	List<Item> findById(Integer usersId);

	List<Item> findByIdAndIncomeOutgoAndDelete(Integer usersId, Integer incomeOutgo);

	void deleteItem(Integer itemsId);

	void reInputItem(Integer itemsId);

	List<Item> itemNameFindForItemsId(Integer itemsId);


}