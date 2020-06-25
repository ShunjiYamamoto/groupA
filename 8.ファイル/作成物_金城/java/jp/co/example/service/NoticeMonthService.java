package jp.co.example.service;

import java.util.List;

import jp.co.example.entity.NoticeMonth;

public interface NoticeMonthService {

	void inputNoticeMonth(NoticeMonth noticeMonth);

	List<NoticeMonth> findByUsersId(Integer usersId);

	void deleteNoticeMonth(Integer noticesMonthId);

}
