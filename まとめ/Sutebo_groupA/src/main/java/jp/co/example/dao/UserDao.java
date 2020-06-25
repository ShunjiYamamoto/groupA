package jp.co.example.dao;

import java.util.Date;
import java.util.List;

import jp.co.example.entity.User;

public interface UserDao {

	//ユーザー名変更用
	public void updateUserName(String newUserName,String userId);

	//ユーザーパスワード変更
	public void updatePassword(String newPassword,String userId);

	//ユーザーの全データ削除（表面だけ）
	public void updateDelete(String userId);

	//ユーザーのパスワード取得
	public List<User> passwordNameGet(String userId);

	public String findByToken(String userId);

	int update(String userId, String lineToken, Integer hour, Integer minute, boolean lineNoticeOn, Date date);

	public User findByUserIdAndPassword(String userId, String password);

	public List<User> deleteGet(String userId, String password);

	public void updateLoginDate(Integer usersId, Date lastLoginDate);

	public User findById(String userId);

	public int insert(String userId, String userName, String password);

	public Integer findUsersId(String userId);
}
