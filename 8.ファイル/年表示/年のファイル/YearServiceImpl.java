package jp.co.example.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import jp.co.example.dao.YearDao;
import jp.co.example.entity.Year;
import jp.co.example.service.YearService;

@Service
public class YearServiceImpl implements YearService {

	@Autowired
	private YearDao yearDao;

	@Override
	public List<Year> yearDate(int usersId){

		System.out.println(usersId);
	     List<Year> list = yearDao.yearDate(usersId);

	     return list;
	}

}
