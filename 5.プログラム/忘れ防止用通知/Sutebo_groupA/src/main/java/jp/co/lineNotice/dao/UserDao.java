package jp.co.lineNotice.dao;

public interface UserDao {

	public User findById(String userId);
	public int insert(String userId, String userName, String password);

}
