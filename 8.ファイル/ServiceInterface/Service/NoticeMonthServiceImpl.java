package jp.co.example.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import jp.co.example.dao.NoticeMonthDao;
import jp.co.example.entity.MonthSum;
import jp.co.example.service.NoticeMonthService;

@Service
public class NoticeMonthServiceImpl implements NoticeMonthService{

	@Autowired
	private NoticeMonthDao noticeMonthDao;


	public List<MonthSum> monthDataSum(int usersId){
		List<MonthSum> list = noticeMonthDao.monthDateIncomeSpending(usersId);
		return list;
	}




	//1年の収入合計
	@Override
	public int monthSumIncome(int usersId) {
		List<MonthSum> list = noticeMonthDao.monthSum(usersId);
		return list.get(0).getMonthIncomeSum();
	}

	//1年の支出合計
	@Override
	public int monthSumSpending(int usersId) {
		List<MonthSum> list = noticeMonthDao.monthSum(usersId);
		return list.get(0).getMonthSpendingSum();
	}

	//1年の支出合計
	@Override
	public int monthSumIncomeSpendingDifference(int usersId) {
		List<MonthSum> list = noticeMonthDao.monthSum(usersId);
		return list.get(0).getMonthIncomeSpendingDifferenceSum();
	}


}
