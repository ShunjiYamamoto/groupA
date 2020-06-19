package jp.co.example.dao.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import jp.co.example.dao.UserDao;
import jp.co.example.entity.User;

@Repository
public class PgUserDao implements UserDao {

	@Autowired
	private JdbcTemplate jdbcTemplate;

	public List<User> findAll() {

		return jdbcTemplate.query("SELECT * FROM users ORDER BY user_id",
			new BeanPropertyRowMapper<User>(User.class));
	}
}
