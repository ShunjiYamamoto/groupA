package jp.co.account.dao;

import jp.co.account.entity.User;

public interface UserDao {

	public User findById(String userId);
	public int insert(String userId, String userName, String password);

}
