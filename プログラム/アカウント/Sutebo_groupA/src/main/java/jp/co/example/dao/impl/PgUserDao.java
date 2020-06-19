package jp.co.example.dao.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

import jp.co.example.dao.UserDao;
import jp.co.example.entity.User;

@Repository
public class PgUserDao implements UserDao {

	@Autowired
	//private JdbcTemplate jdbcTemplate;
	private NamedParameterJdbcTemplate jdbcTemplate;

	public User findById(String userId) {

		String sql = "SELECT * FROM users WHERE user_id =:userId";

		MapSqlParameterSource param = new MapSqlParameterSource();
		param.addValue("userId", userId);

		System.out.println("通過");

		List<User> resultList = jdbcTemplate.query(sql, param,new BeanPropertyRowMapper<User>(User.class));

		System.out.println("通過2");

		return resultList.isEmpty() ? null : resultList.get(0);

	}

	public int insert(String userId,String userName,String password) {

		String sql = "INSERT INTO users VALUES (:userId, :userName, :password)";

		MapSqlParameterSource param = new MapSqlParameterSource();
		param.addValue("userId", userId);
		param.addValue("userName", userName);
		param.addValue("password", password);

		jdbcTemplate.update(sql, param);

		return (Integer) null;

	}
}
