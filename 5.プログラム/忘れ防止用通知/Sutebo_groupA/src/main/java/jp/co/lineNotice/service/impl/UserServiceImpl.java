package jp.co.lineNotice.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import jp.co.lineNotice.dao.UserDao;
import jp.co.lineNotice.entity.User;
import jp.co.lineNotice.service.UserService;

@Service
public class UserServiceImpl implements UserService {

	@Autowired
	private UserDao userDao;

	@Override
	public User findByToken(String usersId) {
		return userDao.findByToken(usersId);
	}

	@Override
	public int insert2(String userId, String userName, String password) {
		return userDao.insert2(userId, userName, password);
	}
}
