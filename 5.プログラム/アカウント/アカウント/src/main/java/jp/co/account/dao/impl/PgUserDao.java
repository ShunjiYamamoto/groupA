package jp.co.account.dao.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

import jp.co.account.dao.UserDao;
import jp.co.account.entity.User;

@Repository
public class PgUserDao implements UserDao {

	@Autowired
	//private JdbcTemplate jdbcTemplate;
	private NamedParameterJdbcTemplate jdbcTemplate;

	public User findById(String userId) {

		String sql = "SELECT * FROM users WHERE user_id =:userId";

		MapSqlParameterSource param = new MapSqlParameterSource();
		param.addValue("userId", userId);

		List<User> resultList = jdbcTemplate.query(sql, param,new BeanPropertyRowMapper<User>(User.class));

		return resultList.isEmpty() ? null : resultList.get(0);

	}

	public int insert(String userId,String userName,String password) {

		String sql = "INSERT INTO users(user_id, user_name,password) VALUES (:userId, :userName, :password)";

		MapSqlParameterSource param = new MapSqlParameterSource();
		param.addValue("userId", userId);
		param.addValue("userName", userName);
		param.addValue("password", password);

		return jdbcTemplate.update(sql, param);

	}
}
