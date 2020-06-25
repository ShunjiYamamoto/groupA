package jp.co.example.service.impl;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import jp.co.example.dao.UserDao;
import jp.co.example.entity.User;
import jp.co.example.service.UserService;

@Service
public class UserServiceImpl implements UserService{

	@Autowired
	private UserDao userDao;

	@Override
	public String passwordGet(String userId) {
		List<User> list= userDao.passwordNameGet(userId);
		return list.get(0).getPassword();
	}

	@Override
	public String userNameGet(String userId) {
		List<User> list= userDao.passwordNameGet(userId);
		return list.get(0).getUserName();
	}

	@Override
	public void updateUserName(String newUserName,String userId) {
		userDao.updateUserName(newUserName, userId);
	}

	@Override
	public void updatePassword(String newPassword,String userId) {
		userDao.updatePassword(newPassword, userId);
	}

	@Override
	public void updateDelete(String userId) {
		userDao.updateDelete(userId);
	}

	@Override
	public String findByToken(String usersId) {
		return userDao.findByToken(usersId);
	}

	@Override
	public int update(String userId,String lineToken, Integer hour, Integer minute, boolean lineNoticeOn, Date date) {
		return userDao.update(userId,lineToken,hour,minute,lineNoticeOn,date);
	}

	//認証処理
		@Override
		public User authentication(String userId, String password) {
			return userDao.findByUserIdAndPassword(userId, password);
		}


		@Override
		public boolean deleteGet(String userId, String password) {
			List<User> list = userDao.deleteGet(userId, password);
			System.out.println(list.get(0).getUserDelete());
			return list.get(0).getUserDelete();
		}


		@Override
		public User findById(String userId) {
			return userDao.findById(userId);
		}

		@Override
		public int insert(String userId,String userName,String password) {
			return userDao.insert(userId, userName, password);
		}


		@Override
		public void updateLoginDate(Integer usersId, Date lastLoginDate) {
			userDao.updateLoginDate(usersId, lastLoginDate);
		}

		@Override
		public Integer findUsersId(String userId) {
			return userDao.findUsersId(userId);
		}

}
