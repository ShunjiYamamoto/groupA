package jp.co.example.dao;

import java.util.List;

import jp.co.example.entity.MonthSum;

public interface NoticeMonthDao {

	public List<MonthSum> monthDateIncomeSpending(int usersId);

	public List<MonthSum> monthSum(int usersId);

}
