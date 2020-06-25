package jp.co.example.dao;

import java.util.List;

import jp.co.example.entity.MonthSum;
import jp.co.example.entity.NoticeMonth;

public interface NoticeMonthDao {

	public List<MonthSum> monthDateIncomeSpending(int usersId);

	public List<MonthSum> monthSum(int usersId);

	void inputNoticeMonth(NoticeMonth noticeMonth);

	List<NoticeMonth> findByUsersId(Integer usersId);

	void deleteNoticeMonth(Integer noticesMonthId);

}
