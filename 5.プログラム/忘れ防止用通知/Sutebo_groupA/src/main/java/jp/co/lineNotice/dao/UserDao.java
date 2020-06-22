package jp.co.lineNotice.dao;

public interface UserDao {

	public String findByToken(String userId);
	public int insert2(String userId, String userName, String password);

}
