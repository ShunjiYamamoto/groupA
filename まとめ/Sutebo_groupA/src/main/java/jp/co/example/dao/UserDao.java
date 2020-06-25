package jp.co.example.dao;

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
}
