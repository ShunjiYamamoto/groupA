package jp.co.example.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import jp.co.example.dao.UserDao;
import jp.co.example.entity.User;
import jp.co.example.service.UserService;

@Service
public class UserServiceImpl implements UserService{


	@Autowired
	private UserDao userDao;


	//認証処理
	@Override
	public User authentication(String userId, String password) {
		return userDao.findByUserIdAndPassword(userId, password);
	}


	@Override
	public boolean deleteGet(String userId, String password) {
		// TODO 自動生成されたメソッド・スタブ
		return false;
	}

	@Override
	public User findById(String userId) {
		return userDao.findById(userId);
	}

	@Override
	public int insert(String userId,String userName,String password) {
		return userDao.insert(userId, userName, password);
	}


//	@Override
//	public boolean deleteGet(String userId, String password) {
//		List<User> list = userDao.deleteGet(userId, password);
//		return list.get(0).getUserDelete();
//	}

//	@Override
//	public List<User> find(User user) {
//		return UserDao.find(user);
//	}


//	@Override
//	public User findByUserIdAndPassword(String userId, String password) {
//		// TODO 自動生成されたメソッド・スタブ
//		return null;
//	}
}
