package jp.co.example.dao.impl;

import java.sql.Time;
import java.util.Date;
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

//	private static final String SELECT_ALL = "SELECT users_id, user_id, user_name, password, user_delete, last_login_date, line_token, line_time, line_notice_on FROM users ORDER BY users_id";
	private static final String SELECT_BY_USER_ID_AND_PASS = "SELECT users_id,user_id,user_name,password,last_login_date FROM users WHERE user_id = :userId AND password = :password AND user_delete = false";


	@Override
	public  List<User> passwordNameGet(String userId){
		String sql ="select user_name,password from users where user_id = :userId";

		MapSqlParameterSource param = new MapSqlParameterSource();
		param.addValue("userId", userId);

		List<User> resultList =jdbcTemplate.query(sql,param,new BeanPropertyRowMapper<User>(User.class));

		return resultList;
	}

	@Override
	public void updateUserName(String newUserName,String userId) {
		String sql ="update users set user_name =:newUserName where user_id = :userId";

		MapSqlParameterSource param = new MapSqlParameterSource();
		param.addValue("newUserName", newUserName);
		param.addValue("userId", userId);

		jdbcTemplate.update(sql, param);
	}

	@Override
	public void updatePassword(String newPassword,String userId) {
		String sql ="update users set password = :newPassword where user_id =:userId";

		MapSqlParameterSource param = new MapSqlParameterSource();
		param.addValue("newPassword",newPassword);
		param.addValue("userId", userId);

		jdbcTemplate.update(sql, param);
	}

	@Override
	public void updateDelete(String userId) {
		String sql ="update users set user_delete = true where user_id = :userId";

		MapSqlParameterSource param = new MapSqlParameterSource();
		param.addValue("userId", userId);

		jdbcTemplate.update(sql, param);
	}

	@Override
	public String findByToken(String userId) {


		String sql = "SELECT line_token FROM users WHERE user_id =:userId";

		MapSqlParameterSource param = new MapSqlParameterSource();
		param.addValue("userId", userId);

		List<User> resultList = jdbcTemplate.query(sql, param,new BeanPropertyRowMapper<User>(User.class));

		String lineToken = resultList.get(0).getLineToken();

		return resultList.isEmpty() ? null : lineToken;

	}

	@Override
	public int update(String userId,String lineToken,Integer hour,Integer minute,boolean lineNoticeOn, Date date) {

		String sql = "UPDATE users SET line_token = :lineToken,line_time = :lineTime,"
				+ "	line_notice_on = :lineNoticeOn, line_day = :line_day  WHERE user_id = :userId";

		Time lineTime = new Time(hour,minute,0);

		MapSqlParameterSource param = new MapSqlParameterSource();
		param.addValue("lineToken", lineToken);
		param.addValue("lineTime",lineTime);
		param.addValue("lineNoticeOn", lineNoticeOn);
		param.addValue("userId", userId);
		param.addValue("line_day", date);

		return jdbcTemplate.update(sql, param);

	}

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
	public void updateLoginDate (Integer usersId, Date lastLoginDate) {

		String sql = "UPDATE users SET last_login_date = :lastLoginDate WHERE users_id = :usersId";
		MapSqlParameterSource param = new MapSqlParameterSource();
		param.addValue("usersId", usersId);
		param.addValue("lastLoginDate", lastLoginDate);

		jdbcTemplate.update(sql, param);

	}

	@Override
	public User findById(String userId) {

		String sql = "SELECT user_id FROM users WHERE user_id =:userId";

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
