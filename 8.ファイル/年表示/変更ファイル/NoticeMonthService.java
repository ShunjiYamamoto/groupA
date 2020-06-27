package jp.co.example.service;

import java.util.List;

import jp.co.example.entity.MonthSum;
import jp.co.example.entity.NoticeMonth;

public interface NoticeMonthService {

	public List<MonthSum> monthDataSum(int usersId, String year);


	//1年の収入合計
	public int monthSumIncome(int usersId,String year);

	//1年の支出合計
	public int monthSumSpending(int usersId,String year);

	//1年の支出合計
	public int monthSumIncomeSpendingDifference(int usersId,String year);

	void inputNoticeMonth(NoticeMonth noticeMonth);

	List<NoticeMonth> findByUsersId(Integer usersId);

	void deleteNoticeMonth(Integer noticesMonthId);





}
