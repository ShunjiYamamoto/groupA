package jp.co.example.service.impl;

import java.sql.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import jp.co.example.dao.FixMoneyDao;
import jp.co.example.entity.Money;
import jp.co.example.service.FixMoneyService;


@Service
public  class FixMoneyServiceImpl implements FixMoneyService{


	@Autowired
	private FixMoneyDao fixMoneyDao;


	@Override
	public Money findDairyAmount(Integer Id, String itemName, Date inputDate, Integer amount) {
		return fixMoneyDao.findDairyAmount(Id, itemName, inputDate, amount);
	}

	//更新
	@Override
	public void update(Integer amount, Integer Id, String itemName, Date inputDate) {
		fixMoneyDao.update(amount , Id, itemName, inputDate);
	}
	/*public void update(Money amount) {
		fixMoneyDao.update(amount);
	}
*/



}
