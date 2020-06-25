package jp.co.example.dao;

import jp.co.example.entity.User;

public interface UserDao {


//	public List<User> findAll();

	 public User findByUserIdAndPassword(String userId, String password);


//	public static List<User> find(User user) {
//		return null;
//	}

}
