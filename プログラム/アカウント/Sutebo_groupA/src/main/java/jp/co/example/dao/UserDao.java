package jp.co.example.dao;

import jp.co.example.entity.User;

public interface UserDao {

	public User findById(String userId);
	public int insert(String userId, String userName, String password);

}
