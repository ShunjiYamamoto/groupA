package jp.co.example.dao;

import java.util.List;

import jp.co.example.entity.NoticeMonth;

public interface NoticeMonthDao {

	void inputNoticeMonth(NoticeMonth noticeMonth);

	List<NoticeMonth> findByUsersId(Integer usersId);

	void deleteNoticeMonth(Integer noticesMonthId);

}
