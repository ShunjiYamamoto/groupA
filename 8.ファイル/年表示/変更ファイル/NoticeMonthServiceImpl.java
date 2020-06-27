package jp.co.example.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import jp.co.example.dao.NoticeMonthDao;
import jp.co.example.entity.MonthSum;
import jp.co.example.entity.NoticeMonth;
import jp.co.example.service.NoticeMonthService;

@Service
public class NoticeMonthServiceImpl implements NoticeMonthService{

	@Autowired
	private NoticeMonthDao noticeMonthDao;

	@Override
	public List<MonthSum> monthDataSum(int usersId,String year){
		List<MonthSum> list = noticeMonthDao.monthDateIncomeSpending(usersId,year);
		return list;
	}




	//1年の収入合計
	@Override
	public int monthSumIncome(int usersId,String year) {
		List<MonthSum> list = noticeMonthDao.monthSum(usersId,year);
		return list.get(0).getMonthIncomeSum();
	}

	//1年の支出合計
	@Override
	public int monthSumSpending(int usersId,String year) {
		List<MonthSum> list = noticeMonthDao.monthSum(usersId,year);
		return list.get(0).getMonthSpendingSum();
	}

	//1年の支出合計
	@Override
	public int monthSumIncomeSpendingDifference(int usersId,String year) {
		List<MonthSum> list = noticeMonthDao.monthSum(usersId,year);
		return list.get(0).getMonthIncomeSpendingDifferenceSum();
	}

	@Override
	public void inputNoticeMonth(NoticeMonth noticeMonth) {
		noticeMonthDao.inputNoticeMonth(noticeMonth);
	}

	@Override
	public List<NoticeMonth> findByUsersId(Integer usersId) {
		return noticeMonthDao.findByUsersId(usersId);
	}

	@Override
	public void deleteNoticeMonth(Integer noticesMonthId) {
		noticeMonthDao.deleteNoticeMonth(noticesMonthId);
	}


}
