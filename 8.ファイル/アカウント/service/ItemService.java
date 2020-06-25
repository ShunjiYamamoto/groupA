package jp.co.example.service;

import java.util.List;

import jp.co.example.entity.Item;

public interface ItemService {

	List<Item> findItem(Integer usersId, Integer incomeOutgo);

	void inputItem(Item item);

	boolean checkDuplicationItem(Item item);

	List<Item> findDeleteItem(Integer usersId, Integer incomeOutgo);

	void deleteItem(Integer itemsId);

	void reInputItem(Integer itemsId);

}
