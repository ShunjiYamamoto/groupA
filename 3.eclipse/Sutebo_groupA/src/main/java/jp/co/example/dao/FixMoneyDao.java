package jp.co.example.dao;

import java.sql.Date;

import jp.co.example.entity.Money;

public interface FixMoneyDao {


	//public Money findByItemNameAndAmount(String itemName, String amount);




	public void update(Integer Id, String itemName, Date inputDate );


//	public Money findDairyAmount(Integer id, String itemName, String inputDate, Integer amount);



//	public Money findDairyAmount(Integer id, String itemName, String inputDate, Integer amount);


	public Money findDairyAmount(Integer id, String itemName, Date inputDate, Integer amount);



}


