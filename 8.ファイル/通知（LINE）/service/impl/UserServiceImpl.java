package jp.co.lineNotice.service.impl;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import jp.co.lineNotice.dao.UserDao;
import jp.co.lineNotice.service.UserService;

@Service
public class UserServiceImpl implements UserService {

	@Autowired
	private UserDao userDao;

	@Override
	public String findByToken(String usersId) {
		return userDao.findByToken(usersId);
	}

	@Override
	public int update(String userId,String lineToken, Integer hour, Integer minute, boolean lineNoticeOn, Date date) {
		return userDao.update(userId,lineToken,hour,minute,lineNoticeOn,date);
	}

}
