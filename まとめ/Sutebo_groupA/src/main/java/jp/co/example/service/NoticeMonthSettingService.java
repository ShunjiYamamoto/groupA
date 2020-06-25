package jp.co.example.service;

import java.util.List;

import jp.co.example.entity.NoticeMonthSetting;

public interface NoticeMonthSettingService {

	List<NoticeMonthSetting> findById(Integer usersId);

	void inputNoticeMonthSetting(NoticeMonthSetting noticeMonthSetting);

	void updateNoticeOn(Integer noticesMonthSettingId, String choice);

	void updateNoticeSettingDelete(Integer noticesMonthSettingId);

	List<NoticeMonthSetting> findByIdAndNoticeOn(Integer usersId);

}
