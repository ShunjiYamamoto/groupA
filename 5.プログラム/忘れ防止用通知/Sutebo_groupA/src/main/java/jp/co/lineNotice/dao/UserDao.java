package jp.co.lineNotice.dao;

public interface UserDao {

	public String findByToken(String userId);

	int update(String userId, String lineToken, Integer hour, Integer minute, boolean lineNoticeOn);

}
