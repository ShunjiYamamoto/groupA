package jp.co.example.service;

import java.util.List;

import jp.co.example.entity.Item;

public interface ItemService {

	public List<Item> getItemsList(String usersId,Integer incomeOrOutgo);

	public String itemsIdConvertItemName(Integer itemsId);

}
