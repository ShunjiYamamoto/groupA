package jp.co.example.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import jp.co.example.dao.ItemDao;
import jp.co.example.entity.Item;
import jp.co.example.service.ItemService;

@Service
public class ItemServiceImpl implements ItemService {
	@Autowired
	ItemDao itemDao;

	public List<Item> getItemsList(String usersId,Integer incomeOrOutgo){
		List<Item> result = itemDao.itemsAllFindForUserId(usersId,incomeOrOutgo);
		return result;
	}

	@Override
	public String itemsIdConvertItemName(Integer itemsId) {
		List<Item> items = itemDao.itemNameFindForItemsId(String.valueOf(itemsId));
		String result = items.get(0).getItemName();
		return result;
	}
}
