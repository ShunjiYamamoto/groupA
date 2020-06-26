package jp.co.example.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import jp.co.example.dao.MoneyDao;
import jp.co.example.form.InputMoneyForm;
import jp.co.example.service.MoneyService;

@Service
public class MoneyServiceImpl implements MoneyService {

	@Autowired
	MoneyDao moneyDao;

	@Override
	public void insertMoneys(InputMoneyForm form){
		moneyDao.moneyInsert(form);
	}
}