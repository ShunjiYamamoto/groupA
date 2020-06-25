package jp.co.account.service;

import jp.co.account.entity.User;

public interface UserService {

	public User findById(String userId);
	public int insert(String userId, String userName, String password);

}
