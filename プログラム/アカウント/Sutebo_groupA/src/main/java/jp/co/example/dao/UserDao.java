package jp.co.example.dao;

import jp.co.example.entity.User;

public interface UserDao {

	public User findById();
	public int insert();

}
