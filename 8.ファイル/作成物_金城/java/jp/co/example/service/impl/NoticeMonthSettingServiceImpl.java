package jp.co.example.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import jp.co.example.dao.NoticeMonthSettingDao;
import jp.co.example.entity.NoticeMonthSetting;
import jp.co.example.service.NoticeMonthSettingService;

@Service
public class NoticeMonthSettingServiceImpl implements NoticeMonthSettingService {
	@Autowired
	private NoticeMonthSettingDao noticeMonthSettingDao;

	@Override
	public List<NoticeMonthSetting> findById(Integer usersId) {
		return noticeMonthSettingDao.findById(usersId);
	}

	@Override
	public void inputNoticeMonthSetting(NoticeMonthSetting noticeMonthSetting) {
		noticeMonthSettingDao.inputNoticeMonthSetting(noticeMonthSetting);
	}

	@Override
	public void updateNoticeOn(Integer noticesMonthSettingId, String choice) {
		if(choice.equals("on")) {
			noticeMonthSettingDao.updateNoticeOn(noticesMonthSettingId, true);
		}else if(choice.equals("off")) {
			noticeMonthSettingDao.updateNoticeOn(noticesMonthSettingId, false);
		}
	}

	@Override
	public void updateNoticeSettingDelete(Integer noticesMonthSettingId) {
		noticeMonthSettingDao.updateNoticeSettingDelete(noticesMonthSettingId);
	}

	@Override
	public List<NoticeMonthSetting> findByIdAndNoticeOn(Integer usersId) {
		return noticeMonthSettingDao.findByIdAndNoticeOn(usersId);
	}

}
