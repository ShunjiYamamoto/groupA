package jp.co.lineNotice.dao;

import java.util.Date;

public interface UserDao {

	public String findByToken(String userId);

	int update(String userId, String lineToken, Integer hour, Integer minute, boolean lineNoticeOn, Date date);

}
