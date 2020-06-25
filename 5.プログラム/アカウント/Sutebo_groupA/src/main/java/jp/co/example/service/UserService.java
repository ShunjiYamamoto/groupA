package jp.co.example.service;

import jp.co.example.entity.User;

public interface UserService {

	public User findById(String userId);
	public int insert(String userId, String userName, String password);

}
