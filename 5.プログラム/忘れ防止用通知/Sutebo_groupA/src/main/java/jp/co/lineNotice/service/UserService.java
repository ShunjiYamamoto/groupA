package jp.co.lineNotice.service;

import java.util.Date;

public interface UserService {

	public String findByToken(String usersId);

	int update(String userId, String lineToken, Integer hour, Integer minute, boolean lineNoticeOn, Date date);


}
