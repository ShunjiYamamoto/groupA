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
	private ItemDao itemDao;

	@Override
	public List<Item> findItem(Integer usersId, Integer incomeOutgo){
		return itemDao.findByIdAndIncomeOutgoAndNotDelete(usersId, incomeOutgo);
	}

	@Override
	public void inputItem(Item item) {
		itemDao.inputItem(item);
	}

	@Override
	public boolean checkDuplicationItem(Item item) {
		String itemName = item.getItemName();
		List<Item> itemList = itemDao.findById(item.getUsersId());

		for(Item i : itemList) {
			if(itemName.equals(i.getItemName())) {
				return true;
			}
		}

		return false;
	}

	@Override
	public List<Item> findDeleteItem(Integer usersId, Integer incomeOutgo){
		return itemDao.findByIdAndIncomeOutgoAndDelete(usersId, incomeOutgo);
	}

	@Override
	public void deleteItem(Integer itemsId) {
		itemDao.deleteItem(itemsId);
	}

	@Override
	public void reInputItem(Integer itemsId) {
		itemDao.reInputItem(itemsId);
	}
}
