package jp.co.example.service.impl;


import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import jp.co.example.dao.MoneyDao;
import jp.co.example.entity.ItemNameAndMoney;
import jp.co.example.entity.Money;
import jp.co.example.form.InputMoneyForm;
import jp.co.example.service.MoneyService;

@Service
public class MoneyServiceImpl implements MoneyService {

		@Autowired
		private MoneyDao moneyDao;

		@Override
		public List<Money> findMoneyForCalendar(Integer usersId, Date dayStart, Date dayEnd){
			return moneyDao.findMoneyForCalendar(usersId, dayStart,dayEnd);
		}

		@Override
		public List<ItemNameAndMoney> findDairyData(Integer usersId, String date){
			return moneyDao.findDairyData(usersId, date);
		}

		@Override
		public List<ItemNameAndMoney> findDairyDataForGraph(Integer usersId, String date){
			return moneyDao.findDairyDataForGraph(usersId, date);
		}

		@Override
		public List<ItemNameAndMoney> findMonthlyData(Integer usersId,Date dayStart, Date dayEnd){
			return moneyDao.findMonthlyData(usersId, dayStart, dayEnd);
		}

		@Override
		public List<Money> findToTalOutgoOfMonth(Integer usersId,Date dayStart, Date dayEnd){
			return moneyDao.findToTalOutgoOfMonth(usersId, dayStart, dayEnd);
		}

		@Override
		public List<Money> findToTalIncomeOfMonth(Integer usersId,Date dayStart, Date dayEnd){
			return moneyDao.findToTalIncomeOfMonth(usersId, dayStart, dayEnd);
		}

		@Override
		public void insertMoneys(InputMoneyForm form){
			moneyDao.moneyInsert(form);
		}

	}




