package jp.co.example.service;

import java.sql.Date;

import jp.co.example.entity.Money;


public interface FixMoneyService{


	//public FixMoney get(String itemName, String amount);

	//public void update(Money amount);

	//public Money findDairyAmount(Integer Id,String itemName, String inputDate);



//	public void update(Integer Id, String itemName, String inputDate);



	//public Money findDairyAmount(Integer id, String itemName, String inputDate, String amount);



	//Money findDairyAmount(Integer Id, String itemName, String inputDate, Integer amount);






	Money findDairyAmount(Integer Id, String itemName, Date inputDate, Integer amount);



	void update(Integer amount, Integer Id, String itemName, Date inputDate);



	//public Money findDairyAmount(Integer id, String items, Date date, Integer money);




}
