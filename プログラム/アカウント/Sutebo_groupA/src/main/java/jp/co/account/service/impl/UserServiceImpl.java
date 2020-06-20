package jp.co.account.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import jp.co.account.dao.UserDao;
import jp.co.account.entity.User;
import jp.co.account.service.UserService;

@Service
public class UserServiceImpl implements UserService {

	@Autowired
	private UserDao userDao;

	@Override
	public User findById(String userId) {
		return userDao.findById(userId);
	}

	@Override
	public int insert(String userId,String userName,String password) {
		return userDao.insert(userId, userName, password);
	}

}
