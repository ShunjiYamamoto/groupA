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
public class PgUserDao implements UserDao{

	@Autowired
    private NamedParameterJdbcTemplate jdbcTemplate;


	private static final String SELECT_ALL = "SELECT users_id, user_id, user_name, password, user_delete, last_login_date, line_token, line_time, line_notice_on FROM users ORDER BY users_id";
	private static final String SELECT_BY_USER_ID_AND_PASS = "SELECT users_id, user_id, user_name, password FROM users WHERE user_id = :userId AND password = :password";


	//全件取得
//	@Override
//	public List<User> findAll(){
//		List<User> resultList = jdbcTemplate.query(SELECT_ALL, new BeanPropertyRowMapper<User>(User.class));
//
//		return resultList;
//	}



	//userId, password による検索
	@Override
	public User findByUserIdAndPassword(String userId, String password) {
		MapSqlParameterSource param = new MapSqlParameterSource();
		param.addValue("userId", userId);
		param.addValue("password", password);

		List<User> resultList = jdbcTemplate.query(SELECT_BY_USER_ID_AND_PASS, param,
				new BeanPropertyRowMapper<User>(User.class));

		return resultList.isEmpty() ? null : resultList.get(0);
	}

	@Override
	public List<User> deleteGet (String userId, String password){

		String sql = "SELECT user_delete FROM users WHERE user_id = :userId AND password = :password";
		MapSqlParameterSource param = new MapSqlParameterSource();
		param.addValue("userId", userId);
		param.addValue("password", password);

		 List<User> resultList = jdbcTemplate.query(sql, param,
				new BeanPropertyRowMapper<User>(User.class));

	   return resultList;

	}

	@Override
	public User findById(String userId) {

		String sql = "SELECT * FROM users WHERE user_id =:userId";

		MapSqlParameterSource param = new MapSqlParameterSource();
		param.addValue("userId", userId);

		List<User> resultList = jdbcTemplate.query(sql, param,new BeanPropertyRowMapper<User>(User.class));

		return resultList.isEmpty() ? null : resultList.get(0);

	}

	@Override
	public int insert(String userId,String userName,String password) {

		String sql = "INSERT INTO users(user_id, user_name,password) VALUES (:userId, :userName, :password)";

		MapSqlParameterSource param = new MapSqlParameterSource();
		param.addValue("userId", userId);
		param.addValue("userName", userName);
		param.addValue("password", password);

		return jdbcTemplate.update(sql, param);

	}

	@Override
	public Integer findUsersId(String userId) {

		String sql = "SELECT users_id FROM users WHERE user_id =:userId";

		MapSqlParameterSource param = new MapSqlParameterSource();
		param.addValue("userId", userId);

		List<User> resultList = jdbcTemplate.query(sql, param,new BeanPropertyRowMapper<User>(User.class));

		System.out.println("resultList:" + resultList);
		return resultList.get(0).getUsersId();
	}
}

