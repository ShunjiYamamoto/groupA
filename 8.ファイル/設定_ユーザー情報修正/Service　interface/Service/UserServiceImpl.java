package jp.co.example.service.impl;

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



}
