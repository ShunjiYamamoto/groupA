package jp.co.lineNotice.dao;

import jp.co.lineNotice.entity.User;

public interface UserDao {

	public User findByToken(String userId);
	public int insert2(String userId, String userName, String password);

}
