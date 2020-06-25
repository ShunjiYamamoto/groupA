package jp.co.example.dao;

import java.sql.Date;
import java.util.List;

import jp.co.example.entity.User;

public interface UserDao {


//	public List<User> findAll();
	public User findById(String userId);
	public int insert(String userId, String userName, String password);


	 public User findByUserIdAndPassword(String userId, String password);

	 public List<User> deleteGet(String userId, String password);

	void updateLoginDate(Integer usersId, Date lastLoginDate);


//	public static List<User> find(User user) {
//		return null;
//	}

}
