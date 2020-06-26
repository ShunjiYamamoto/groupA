package jp.co.example.service;

import java.sql.Date;

import jp.co.example.entity.Money;


public interface FixMoneyService{

	Money findDairyAmount(Integer Id, String itemName, Date inputDate, Integer amount);

	void update(Integer amount, Integer Id, String itemName, Date inputDate);

}
