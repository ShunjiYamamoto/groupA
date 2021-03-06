package jp.co.example.service;

public interface UserService {

	//パスワードを取得
	public String passwordGet(String userId);

	//ユーザー名取得
	public String userNameGet(String userId);

	//ユーザー名変更
	public void updateUserName(String newUserId,String userId);

	//ユーザーパスワード変更
	public void updatePassword(String newPassword,String userId);

	//ユーザーの全データ削除（表面だけ）
	public void updateDelete(String userId);

}
