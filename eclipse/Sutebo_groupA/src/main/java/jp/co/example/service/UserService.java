package jp.co.example.service;

import jp.co.example.entity.User;

public interface UserService {


	public User authentication(String userId, String password);

//	public List<User> find (User user);

//	public User findByUserIdAndPassword(String userId, String password);
}
