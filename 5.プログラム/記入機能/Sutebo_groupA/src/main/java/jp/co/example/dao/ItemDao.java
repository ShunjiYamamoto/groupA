package jp.co.example.dao;

import java.util.List;

import jp.co.example.entity.Item;

public interface ItemDao {

	List<Item> itemsAllFindForUserId(String usersId,Integer incomeOrOutgo);

	List<Item> itemNameFindForItemsId(String itemsId);
}
