package jp.co.example.dao;

import java.util.List;

import jp.co.example.entity.NoticeMonthSetting;

public interface NoticeMonthSettingDao {

	List<NoticeMonthSetting> findById(Integer usersId);

	void inputNoticeMonthSetting(NoticeMonthSetting noticeMonthSetting);

	void updateNoticeOn(Integer noticesMonthSettingId, Boolean noticeOn);

	void updateNoticeSettingDelete(Integer noticesMonthSettingId);

	List<NoticeMonthSetting> findByIdAndNoticeOn(Integer usersId);

}
