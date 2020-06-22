package jp.co.lineNotice.service;

public interface UserService {

	public String findByToken(String usersId);
	public int insert2(String userId, String userName, String password);

}
