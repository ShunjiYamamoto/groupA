package jp.co.example.service;


import java.util.Date;
import java.util.List;

import jp.co.example.entity.ItemNameAndMoney;
import jp.co.example.entity.Money;

public interface MoneyService {

	public List<Money> findMoneyForCalendar(Integer usersId, Date dayStart, Date dayEnd);
	public List<ItemNameAndMoney> findDairyData(Integer usersId, String date);
	public List<ItemNameAndMoney> findMonthlyData(Integer usersId,Date dayStart, Date dayEnd);

	public List<Money> findToTalOutgoOfMonth(Integer usersId,Date dayStart, Date dayEnd);
	public List<Money> findToTalIncomeOfMonth(Integer usersId,Date dayStart, Date dayEnd);

}
