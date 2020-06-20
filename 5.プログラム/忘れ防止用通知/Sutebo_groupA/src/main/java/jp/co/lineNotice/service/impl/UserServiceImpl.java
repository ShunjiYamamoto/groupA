package jp.co.lineNotice.service.impl;

import javax.xml.ws.ServiceMode;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import jp.co.account.dao.UserDao;
import jp.co.account.entity.User;
import jp.co.account.service.UserService;

@ServiceMode
public class UserServiceImpl implements UserService {

	@Autowired
	private UserDao userDao;

	@Override
	public String findByToken(String userId);
		return userDao.findById(userId);
	}
}
