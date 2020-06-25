package jp.co.example.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import jp.co.example.dao.NoticeMonthDao;
import jp.co.example.entity.NoticeMonth;
import jp.co.example.service.NoticeMonthService;

@Service
public class NoticeMonthServiceImpl implements NoticeMonthService {
	@Autowired
	private NoticeMonthDao noticeMonthDao;

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
