package jp.co.example.service;

import java.sql.Date;

import jp.co.example.entity.User;

public interface UserService {

	public User findById(String userId);
	public int insert(String userId, String userName, String password);

	public User authentication(String userId, String password);

	public boolean deleteGet(String userId, String password);


	void updateLoginDate(Integer usersId, Date lastLoginDate);

//	public List<User> find (User user);

//	public User findByUserIdAndPassword(String userId, String password);
}
