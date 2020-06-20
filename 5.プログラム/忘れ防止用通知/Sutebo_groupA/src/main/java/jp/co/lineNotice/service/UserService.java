package jp.co.lineNotice.service;

import jp.co.lineNotice.entity.User;

public interface UserService {

	public User findByToken(String usersId);
	public int insert2(String userId, String userName, String password);

}
