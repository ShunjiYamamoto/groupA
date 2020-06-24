package jp.co.example.service;

import java.util.List;

import jp.co.example.entity.MonthSum;

public interface NoticeMonthService {

	public List<MonthSum> monthDataSum(int usersId);


	//1年の収入合計
	public int monthSumIncome(int usersId);

	//1年の支出合計
	public int monthSumSpending(int usersId);

	//1年の支出合計
	public int monthSumIncomeSpendingDifference(int usersId);







}
